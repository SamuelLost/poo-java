import java.util.ArrayList;

public class Contact {
    private String name;
    private ArrayList<Fone> fones;
    protected String prefix = "-"; //utilizado no toString
    //Crie um ArrayList para o ATRIBUTO fones
    //Se a variável fones não for null, adicione todos os fones usando o método addFone
    public Contact(String name, ArrayList<Fone> fones) {
        if(name != null) {
            setName(name);
        } else {
            setName("");
        }
        this.fones = new ArrayList<>();
    }
    //Se fone for válido, insira no atributo fones
    //Se não, informe o erro
    public void addFone(Fone fone) {
        if(!Fone.validate(fone.getNumber())) {
            System.out.println("fail: invalid number");
            return;
        }
        fones.add(fone);

    }
    //Se o índice existir no ArrayList, remova o telefone com esse índice
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
    //GETS e SETS
    String getName() {
        return name;
    }
    void setName(String name) {
        this.name = name;
    }
    ArrayList<Fone> getFones() {
        return fones;
    }
}
