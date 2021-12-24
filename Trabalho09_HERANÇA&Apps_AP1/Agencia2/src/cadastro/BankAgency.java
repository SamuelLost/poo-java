package cadastro;

import java.util.Map;
import java.util.TreeMap;

public class BankAgency {
    private Map<String, Client> clients; //Map para os clientes
    private Map<Integer, Account> accounts; //Map para contas
    private int nextAccountId = 0; //id das contas

    //obtém conta ou lança exceção
    /**
     * O método faz a busca da conta de acordo com seu id dentro
     * do Map<Integer, Account> accounts. Caso a conta procurada
     * não seja encontrada, uma exceção é lançada, se a conta
     * for encontrada, ela é retornada. 
     * 
     * Utiliza o método contaisKey() da interface Map<>, esse método
     * verifica se o Map possui o id. O método get() também é utilizado
     * para retornar a conta pelo id.
     * @param id - id da conta
     * @return objeto conta que foi pesquisado
     */
    private Account getAccount(int id) {
        if(accounts.containsKey(id)) {
            return this.accounts.get(id);
        }
        throw new AccountException("fail: conta nao encontrada");
    }

    /**
     * Construtor da classe no qual os Maps são instanciados.
     */
    public BankAgency() {
        this.clients = new TreeMap<>();
        this.accounts = new TreeMap<>();
    }

    //se o cliente não existir
    //cria o cliente
    //cria uma conta poupança e uma conta corrent para o cliente
    //adiciona essas contas no vetor de contas e no vetor do cliente
    //adiciona o cliente no mapa de clientes
    /**
     * Método para adicionar clientes, adiciona apenas clientes
     * com clientId diferentes.
     * 
     * É criado um cliente passando seu id, apóis isso é criado
     * uma conta corrente passando o id e o clientId, essa conta 
     * corrente é adicionada no Map<> clients pelo método addAccount
     * da classe Client, após isso a conta é adicionada no Map<> accounts
     * através do método put(), passando o id da conta e a conta-corrente.
     * O id da conta é incrementado após adicionar no Map<> accounts.
     * 
     * O mesmo processo é feito para a conta poupança, usando o mesmo 
     * cliente, pois ao cadastrar um cliente automaticamente é aberta
     * uma conta poupança e corrente.
     * 
     * Após todo o processo de adicionar as contas no cliente, é preciso
     * colocar o cliente dentro do Map<> clients, passando do id do cliente
     * e o cliente que vai ser adicionado.
     * @param clientId - id do cliente.
     */
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

        this.clients.put(clientId, client); 
    }

    //obtem o cliente e invoca as ações
    /**
     * Método para realizar o saque da conta. Pega a conta de acordo
     * com seu id e chama o método withdraw(value) de Account.
     * @param idConta - id da conta
     * @param value - valor a ser sacado
     */
    public void withdraw(int idConta, float value) {
        Account c = getAccount(idConta);
        c.withdraw(value);
    }

    /**
     * Método para realizar o depósito em uma conta. Pega a conta de acordo
     * com seu id e chama o método deposit(value) de Account.
     * @param idConta - id da conta
     * @param value - valor a ser depositado
     */
    public void deposit(int idConta, float value) {
        Account conta = getAccount(idConta);
        conta.deposit(value);
    }

    /**
     * Método que faz a transferência de um valor entre duas contas
     * origem e destino. As duas contas criadas através do método
     * getAccount(id), cada conta com um id único. 
     * 
     * Após criada as contas, o objeto que representa a conta de origem
     * chama o método transfer(conta, valor) da classe Account e a
     * transferência é realizada. 
     * @param contaDe - id da conta de origem
     * @param contaPara - id da conta de destino
     * @param value - valor a ser transferido
     */
    public void transfer(int contaDe, int contaPara, float value) {
        Account origem = getAccount(contaDe);
        Account destino = getAccount(contaPara);
        origem.transfer(destino, value);
    }

    /**
     * O método chama cada conta para atualizar o seu saldo.
     * Se a conta for conta-corrente, chama o seu método específico,
     * assim como conta-poupança.
     */
    public void monthlyUpdate() {
        for (Account aux : this.accounts.values()) {
            aux.monthlyUpdate();
        }
    }

    @Override
    /**
     * Método sobrescrito para formatar os dados de saída
     */
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
