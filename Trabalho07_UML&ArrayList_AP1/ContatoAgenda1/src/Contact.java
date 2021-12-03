import java.util.ArrayList;

public class Contact {
    private String name; //nome do contato
    private ArrayList<Fone> fones; //números de telefone
    protected String prefix = "-"; //utilizado no toString

    //Crie um ArrayList para o ATRIBUTO fones
    //Se a variável fones não for null, adicione todos os fones usando o método addFone
    /**
     * Construtor da classe
     * @param name - nome
     * @param fones - números
     */
    public Contact(String name, ArrayList<Fone> fones) {
        if(name != null) {
            setName(name);
        } else {
            setName("");
        }
        if(fones != null) {
            this.fones = new ArrayList<>();
        }
        
    }
    
    //GETS e SETS
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<Fone> getFones() {
        return fones;
    }

    //Se fone for válido, insira no atributo fones
    //Se não, informe o erro
    /**
     * Método para adicionar um número na agenda, porém só
     * podem ser adicionados números válidos, caso não seja, 
     * um erro é informado. É usado o método add() da classe
     * ArrayList, adicionando ao final.
     * @param fone - fone a ser adicionado.
     */
    public void addFone(Fone fone) {
        if(!Fone.validate(fone.getNumber())) {
            System.out.println("fail: invalid number");
            return;
        }
        fones.add(fone);

    }

    //Se o índice existir no ArrayList, remova o telefone com esse índice
    /**
     * Removendo um número de acordo com o índice, se o
     * índice for menor que zero ou maior que o tamanho
     * da lista não é possível remover.
     * @param index - indice do número a ser removido
     */
    public void rmFone(int index) {
        if(index < 0 || index >= fones.size()) {
            System.out.println("fail: index nao existe");
            return;
        }
        fones.remove(index);
    }

    //Use um contador para mostrar o índice do telefone
    //Use o toString do fone para adicioná-lo à saída
    //O resultado dever ficar assim:
    //- david [0:oi:123] [1:tim:9081] [2:claro:5431]
    public String toString() {
        String out = "";
        if(name != null && name != "") {
            out += prefix + " " + name + " ";
            for (Fone aux : fones) {
                if(aux != null) {
                    out += "[" + fones.indexOf(aux) + ":" + aux.toString() + "] ";
                }
            }
        }
        return out;
    }
}
