import java.util.ArrayList;

public class Sala{
    //ArrayList de clientes representando as cadeiras
    private ArrayList<Client> cadeiras;

    /**
     * Construtor para as cadeiras
     * @param capacidade - numero total de cadeiras
     */
    public Sala(int capacidade) {
        cadeiras = new ArrayList<>();
        // Iniciando todo mundo com null
        for (int i = 0; i < capacidade; i++) {
            cadeiras.add(null);
        }
    }

    /**
     * Método getter
     * @return - o próprio ArrayList cadeiras
     */
    public ArrayList<Client> getCadeiras() {
        return cadeiras;
    }

    /**
     * Método para fazer a reserva de uma cadeira. É preciso
     * verificar se a cadeira escolhida está ocupada ou se já
     * existe alguém com o mesmo id, caso alguma dessas condições
     * seja verdadeira, não é possível fazer a reserva.
     * Caso contrário, a reserva é feita na cadeira desejada através
     * do método set(index, Element) de ArrayList. 
     * 
     * Para verificar se a cadeira está livre, basta ver se a cadeira
     * na posição pelo método get(index) é igual a null. 
     * Para buscar o mesmo id, basta percorrer o ArrayList por foreach
     * e usar os métodos getId() da classe Client e equals(). 
     * @param id - id do cliente que vai ser adicionado
     * @param fone - telefone do cliente
     * @param ind - número da cadeira desejada
     * @return true caso a reserva tenha sido um êxito, false caso
     * contrário
     */
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

    /**
     * Método para fazer o cancelamento da reserva. 
     * É feito uma busca pelo ArrayList de cadeiras de 
     * acordo com o id, ao encontrar, a cadeira é setada
     * como null. O índice da cadeira é pego através do
     * método indexOf(Client) e retorna vazio para parar
     * o método, caso não encontre a pessoa, emite uma 
     * mensagem. 
     * @param id - id a ser removido
     */
    public void cancelar(String id) {
        for (Client aux : cadeiras) {
            if(aux != null && aux.getId().equals(id)) {
                cadeiras.set(cadeiras.indexOf(aux), null);
                return;
            }            
        }
        System.out.println("fail: cliente nao esta no cinema");

    }

    /**
     * Formatando a string de saída, imprimindo as cadeiras vazias
     * ou o objeto que ela contém
     */
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