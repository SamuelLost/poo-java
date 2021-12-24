package cadastro;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String clientId; //id do cliente
    private List<Account> accounts; //Lista para as contas

    /**
     * Construtor da classe
     * @param clientId - string para nome ou id do cliente
     */
    public Client(String clientId) {
        setClientId(clientId);
        this.accounts = new ArrayList<>();
    }

    /**
     * Adicionar conta na Lista de contas
     * @param account
     */
    public void addAccount(Account account) {
        if(account != null) {
            this.accounts.add(account);
        }
    }

    @Override
    /**
     * Método sobrescrito para formatar a saída de acordo com
     * o que é pedido.
     */
    public java.lang.String toString() {
        String out = "- " + this.clientId + " [";
        for (Account account : accounts) {
            if(account instanceof CheckingAccount) {
                out += account.getId() + ", ";
            }
            if(account instanceof SavingsAccount) {
                out += account.getId();
            }
        }
        out += "]\n";
        return out;
    }

    //GETS and SETS
    public String getClientId() {
        return clientId;
    }
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    public List<Account> getAccounts() {
        return accounts;
    }

    /**
     * Método para setar novas contas, outros objeto conta
     * é instanciado, limpando as antigas, em sequencia
     * a lista passado por parâmetro é percorrida e adicionada
     * na nova Lista de contas.
     * @param accounts - lista de contas novas
     */
    public void setAccounts(List<Account> accounts) {
        this.accounts = new ArrayList<>();
        if(accounts != null) {
            for (Account account : accounts) {
                this.addAccount(account);
            }
        }
    }
}
