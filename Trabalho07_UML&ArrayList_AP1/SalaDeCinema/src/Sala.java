import java.util.ArrayList;

public class Sala{
    private ArrayList<Client> cadeiras;

    ArrayList<Client> getCadeiras() {
        return cadeiras;
    }

    public Sala(int capacidade) {
        cadeiras = new ArrayList<>();
        for (int i = 0; i < capacidade; i++) {
            cadeiras.add(null);
        }
    }

    /* public boolean reservar(String id, String fone, int ind) {
		if(this.cadeiras.get(ind) != null) {
			System.out.println("fail: cadeira ja esta ocupada");
			return false;
		}
		for(Client aux : cadeiras) {
			//Client aux = this.cadeiras.get(i);
			if(aux != null && aux.getId().equals(id)) {
				System.out.println("fail: cliente ja esta no cinema");
				return false;
			}
		}
		Client cliente = new Client(id, fone);
		this.cadeiras.set(ind, cliente);
		return true;
	} */
    public boolean reservar(String id, String fone, int ind) {
        if(this.cadeiras.get(ind) != null) {
            System.out.println("fail: cadeira ja esta ocupada");
            return false;
        }
        for(Client aux : cadeiras) {
            if((aux != null) && (aux.getId().equals(id))) {
                System.out.println("fail: cliente ja esta no cinema");
                return false;
            }
        }
        Client a = new Client(id, fone);
        this.cadeiras.set(ind, a);
        return true;
    }

    public void cancelar(String id) {
        for (Client aux : cadeiras) {
            if(aux != null && aux.getId().equals(id)) {
                cadeiras.set(cadeiras.indexOf(aux), null);
                return;
            }            
        }
        System.out.println("fail: cliente nao esta no cinema");

    }
    
    public String toString() {
        String out = "[ ";
        for (Client aux : cadeiras) {
            if(aux == null) {
                out += "- ";
            } else {
                out += aux.toString() + " ";
            }
            
        }
        out += "]";
        return out;
    }
}