import java.util.ArrayList;

public class Topic {
    private ArrayList<Pass> prioritySeats; //assentos prioritários
    private ArrayList<Pass> normalSeats; //assento normais

    /**
     * Construtor para a topic
     * @param capacity - quantidade de assentos na topic
     * @param qtdPriority - quantidade prioritários
     */
    public Topic(int capacity, int qtdPriority) {

        prioritySeats = new ArrayList<>();
        for (int i = 0; i < qtdPriority; i++) {
            prioritySeats.add(null);
        }

        normalSeats = new ArrayList<>();
        for (int i = 0; i < (capacity-qtdPriority); i++) {
            normalSeats.add(null);
        }
    }

    //return the first free pos or -1
    /**
     * Método faz a procura do primeiro assento livre na topic
     * @param list - lista de assentos a ser procurada
     * @return - posição livre ou -1 caso não exista alguma livre
     */
    private int findFirstFreePos(ArrayList<Pass> list) {
        for (Pass p : list) {
            if(p == null) return list.indexOf(p);
            
        }
        return -1;
    }

    //search in list using name and return position or return -1
    /**
     * Método que realiza a busca de um passageiro pelo seu nome
     * em alguma lista
     * @param name - nome a ser buscado
     * @param list - lista que será feita a busca
     * @return - posição do passageiro ou -1 caso não encontre
     */
    private int findByName(String name, ArrayList<Pass> list) {
        for (Pass p : list) {
            if(p != null && p.getName().equals(name)) return list.indexOf(p);
        }
        return -1;
    }

    //use the findFirstFreePos to search a free position
    //if exists, insert the pass and return true
    //else return false
    /**
     * Método insere um passageiro em alguma lista de assentos
     * @param pass - objeto passageiro
     * @param list - a lista de asssentos
     * @return true se foi inserido, false caso contrário
     */
    private boolean insertOnList(Pass pass, ArrayList<Pass> list) {
        if(findFirstFreePos(list) != -1) {
            list.set(findFirstFreePos(list), pass);
            return true;
        } else {
            return false;
        }
        

    }

    //use the findByName method to locate pos in list, if found, remore the person
    //setting the pos location to null
    /**
     * Método que remove o passageiro de um assento de acordo
     * com seu nome. Usando o método findByName() para saber
     * se o passageiro existe ou não.
     * @param name - nome do passageiro
     * @param list - lista de assento
     * @return true caso tenha removido, false caso contrário
     */
    private boolean removeFromList(String name, ArrayList<Pass> list) {
        if(findByName(name, list) == -1) {
            return false;
        }
        list.set(findByName(name, list), null);
        return true;
    }

    //use findByName to test if the pass is already in the topic
    //use the insertOnList method to insert in the right list based in
    //the pass.isPriority result
    /**
     * Métodp que insere um passageiro. Esse método faz uso dos 
     * métodos findByName, isPriority e insertOnList. 
     * Só entra passageiros com nomes diferentes. Antes de entrar
     * é verificado se ele é ou não prioridade e insere no assento
     * correto ou vago. 
     * @param pass
     * @return
     */
    public boolean insert(Pass pass) {
        if((findByName(pass.getName(), normalSeats) != -1) || (findByName(pass.getName(), prioritySeats) != -1)) {
            System.out.println("fail: pass ja esta na topic");
            return false;
        }
        if(pass.isPriority()) {
            if(insertOnList(pass, prioritySeats)) {
                return true;
            }
            else if(insertOnList(pass, normalSeats)){
                return true;
            }
            
        } else {
            if(insertOnList(pass, normalSeats)) {
                return true;
            }
            else if(insertOnList(pass, prioritySeats)){
                return true;
            }
        }
        System.out.println("fail: topic lotada");
        return false;
    }

    //use the removeFromList method to try to remove from both lists
    /**
     * Método para remover uma pessoa pelo seu nome utilizando o
     * método removeFromList(). Caso essa pessoa não esteja na topic
     * uma mensagem é impressa.
     * @param name - nome do passageiro
     * @return true caso tenha sido removido, false caso contrário
     */
    public boolean remove(String name) {
        if(removeFromList(name, prioritySeats)) {
            return true;
        } else if(removeFromList(name, normalSeats)){
            return true;
        }
        System.out.println("fail: pass nao esta na topic");
        return false;
    }

    /**
     * Formatando a saída para imprimir o estado da topic.
     */
    public String toString() {
        String out = "[";
        for(Pass aux : prioritySeats) {
            if(aux != null) {
                out += "@" + aux.toString() + " ";
            } else {
                out += "@ ";
            }
        }

        for(Pass aux : normalSeats) {
            if(aux != null) {
                out += "=" + aux.toString() + " ";
            } else {
                out += "= ";
            }
        }
        out = out.trim();
        out += "]";
        return out;
    }
}