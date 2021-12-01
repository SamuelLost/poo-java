import java.util.ArrayList;

public class Sala{
    private ArrayList<Client> cadeiras;
    ArrayList<Client> getCadeiras() {
        return cadeiras;
    }
    public Sala(int capacidade) {
        cadeiras = new ArrayList<>(capacidade);
    }
    public boolean reservar(String id, String fone, int ind) {
        return false;
    }
    public void cancelar(String id) {

    }
    public String toString() {
        return "";
    }
}