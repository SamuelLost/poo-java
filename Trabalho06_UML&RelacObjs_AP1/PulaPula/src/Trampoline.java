import java.util.LinkedList;

public class Trampoline{
    private LinkedList<Kid> waiting; //Fila de quem está esperando
    private LinkedList<Kid> playing; //Fila de quem está brincando

    /**
     * Contrutor que instancia as filas, não tem
     * parametros
     */
    public Trampoline() {
        waiting = new LinkedList<>();
        playing = new LinkedList<>();
    }

    //remove and return the Kid with this name or null
    /**
     * Método privado para ser utilizado dentro da classe.
     * Recebe um nome e uma fila como parâmetro e remove
     * a criança da fila de acordo com o nome desejado.
     * O método percorre a lista procurando a crianção
     * que tem o nome igual ao passado por parametro, 
     * se a criança for encontrada, ela é removida da
     * lista em que está. 
     * @param name - nome da criança a ser removida
     * @param list - instância de uma lista
     * @return - retorna um objeto Kid caso encontre-a ou
     * retorna null caso não encontre a criança.
     */
    private Kid remove_kid(String name, LinkedList<Kid> list) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getName().equals(name)) {
                return list.remove(i);
            }
        }
        return null;
    }

    //insere na lista de espera
    /**
     * Quando uma criança nova chegar, ela vai para a fila
     * de espera, e esse método garante isso. A criança é
     * adicionada ao final da lista pelo método add() da classe
     * LinkedList.
     * @param kid - instância que corresponde a uma criança.
     */
    public void arrive(Kid kid) {
        if(kid != null) {
            waiting.add(kid);
        }
    }

    //remove da lista de espera e insere na lista playing
    /**
     * O seguinte método faz a transição de esperando
     * para brincando. Agora, ela vai ser removida da fila
     * de espera e vai entrar na fila de brincando.
     * A criança é adicionada na primeira posição
     * da fila de brincar.
     */
    public void in() {
        Kid kid = waiting.remove();
        playing.addFirst(kid);
    }

    //remove de playing para waiting
    /**
     * O método out faz outra transição. A criança que
     * está brincando sai do pula-pula e volta para
     * a lista de espera. A última criança da fila de
     * brincar é removida e adicionada na última posição
     * da fila de espera. 
     */
    public void out() {
        Kid aux = playing.removeLast();
        waiting.addLast(aux);
    }

    //remove do parquinho
    /**
     * O seguinte método remove uma criança específica
     * O seguinte método é auxiliado pelo metodo privado
     * remove_kid() que faz a busca e remoção da criança
     * olhando as duas listas. Caso não ache a criança
     * null é retornado.
     * @param name - nome da criança
     * @return - retorna a criança ou null caso não ache
     * a criança.
     */
    public Kid remove(String name) {
        Kid pulando = remove_kid(name, playing);
        Kid esperando = remove_kid(name, waiting);

        if(pulando != null) return pulando;

        if(esperando != null) return esperando;

        return null;
    }

    /**
     * Método toString() para imprimir os objetos no formato
     * desejado. 
     */
    public String toString() {
        String out = "=> ";
        for (int i = waiting.size()-1; i >= 0; i--) {
            out += waiting.get(i).toString() + " ";
        }
        out += "=> [ ";
        for (Kid kid : playing) {
            out += kid.toString()+" ";
        }
        out += "]";
        return out;
    }
}
