public class Client {
    private String id;
    private String fone;

    public Client(String id, String fone) {
        this.id = id;
        this.fone = fone;
    }

    public String toString() {
        return id + ":" + fone;
    }

    String getId() {
        return id;
    }

    void setId(String id) {
        this.id = id;
    }

    String getFone() {
        return fone;
    }
    
    void setFone(String fone) {
        this.fone = fone;
    }
}