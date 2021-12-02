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
}