package cadastro;

import java.util.Map;
import java.util.TreeMap;

public class BankAgency {
    private Map<String, Client> clients;
    private Map<Integer, Account> accounts;
    private int nextAccountId = 0;

    //obtém conta ou lança exceção
    private Account getAccount(int id) {
        if(accounts.containsKey(id)) {
            return accounts.get(id);
        }
        throw new AccountException("fail: conta nao encontrada");
    }

    public BankAgency() {
        clients = new TreeMap<>();
        accounts = new TreeMap<>();
    }

    //se o cliente não existir
    //cria o cliente
    //cria uma conta poupança e uma conta corrent para o cliente
    //adiciona essas contas no vetor de contas e no vetor do cliente
    //adiciona o cliente no mapa de clientes
    public void addClient(String clientId) {
        if(clients.containsKey(clientId)) {
           throw new AccountException("fail: cliente ja existe"); 
        }
        Client client = new Client(clientId);
        Account cc = new CheckingAccount(this.nextAccountId, clientId);
        client.addAccount(cc);
        this.accounts.put(this.nextAccountId++, cc);

        Account cp = new SavingsAccount(this.nextAccountId, clientId);
        client.addAccount(cp);
        this.accounts.put(this.nextAccountId++, cp);

        clients.put(clientId, client); 
    }

    //obtem o cliente e invoca as ações
    public void withdraw(int idConta, float value) {
        Account c = getAccount(idConta);
        c.withdraw(value);
        //accounts.replace(idConta, c);
    }

    public void deposit(int idConta, float value) {
        Account conta = getAccount(idConta);
        conta.deposit(value);
        //accounts.replace(idConta, conta);
    }

    public void transfer(int contaDe, int contaPara, float value) {
        Account origem = getAccount(contaDe);
        Account destino = getAccount(contaPara);
        origem.transfer(destino, value);
    }

    public void monthlyUpdate() {
        for (Account aux : accounts.values()) {
            aux.monthlyUpdate();
        }
    }

    @Override
    public String toString() {
        String out = "Clients:\n";
        for (Client client : clients.values()) {
            out += client.toString();
        }
        out += "Accounts:\n";
        for (Account conta : accounts.values()) {
            out += conta.toString() + "\n";
        }
        return out.trim();
    }
}
