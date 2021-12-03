public class Client {
    private String id; //id do cliente
    private String fone; //telefone do cliente

    /**
     * Construtor do cliente
     * @param id - identificação do cliente
     * @param fone - telefone do cliente
     */
    public Client(String id, String fone) {
        setId(id);
        setFone(fone);
    }
    /**
     * Métodos getters e setters dos atributos
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFone() {
        return fone;
    }
    
    public void setFone(String fone) {
        this.fone = fone;
    }

    /**
     * toString para imprimir o objeto
     */
    public String toString() {
        return id + ":" + fone;
    }
}