import java.util.ArrayList;
import java.util.List;

public class Contact {
    private String name;
    private List<Fone> fones;
    protected String prefix = "-"; //utilizado no toString
    //Crie um ArrayList para o ATRIBUTO fones
    //Se a variável fones não for null, adicione todos os fones usando o método addFone
    /**
     * Construtor da classe
     * @param name - nome
     * @param fones - números
     */
    public Contact(String name, List<Fone> fones) {
        if(name != null) {
            setName(name);
        } else {
            setName("");
        }
        this.fones = new ArrayList<>();
        if(fones != null) {
            for (Fone f : fones) {
                addFone(f);
            }
        }
        
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
        if(!fone.isValid()) {
            System.out.println("fail: invalid number");
            return;
        }
        fones.add(fone);

    }
    //Se o índice existir no ArrayList, remova o telefone com esse índice
    public void rmFone(int index) {
        if(index < 0 || index > fones.size()) {
            System.out.println("indice nao existe");
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
    //GETS e SETS
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Fone> getFones() {
        return fones;
    }
    //limpe a lista de fones
    //utilize o addFone para adicionar apenas os fones válidos
    public void setFones(List<Fone> fones) {
        this.fones = new ArrayList<>();
        if(fones != null) {
            for (Fone fone : fones) {
                if(fone.isValid()) {
                    addFone(fone);
                }
            }
        }
    }
}
