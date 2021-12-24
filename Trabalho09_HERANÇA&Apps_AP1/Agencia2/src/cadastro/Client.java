package cadastro;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String clientId;
    private List<Account> accounts;

    public Client(String clientId) {
        setClientId(clientId);
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        if(account != null) {
            accounts.add(account);
        }
    }

    @Override
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
    
    public void setAccounts(List<Account> accounts) {
        this.accounts = new ArrayList<>();
        if(accounts != null) {
            for (Account account : accounts) {
                addAccount(account);
            }
        }
    }
}
