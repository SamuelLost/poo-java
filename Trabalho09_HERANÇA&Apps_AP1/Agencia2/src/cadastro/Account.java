package cadastro;

import java.util.Locale;

public abstract class Account {
    protected int id; //número da conta
    protected float balance; //saldo
    protected String clientId; //id do cliente
    protected String type; //CC or CP

    /**
     * Construtor da classe
     * @param id - número da conta
     * @param clientId - id do cliente
     */
    public Account(int id, String clientId) {
        this.id = id;
        this.clientId = clientId;
        this.balance = 0;
    }

    //abstract method
    /**
     * Método abstrato para as classes filhas implementarem.
     * É o método que realiza a atualização mensal das contas.
     */
    public abstract void monthlyUpdate();

    //saque
    /**
     * Método que realiza o saque da conta. Caso o valor seja
     * maior do que o saldo, uma exceção será lançada.
     * @param value - valor a ser sacado
     */
    public void withdraw(float value) {
        if(value < 0) throw new AccountException("fail: valor invalido");
        if(value > balance) {
            throw new AccountException("fail: saldo insuficiente");
        } else {
            this.balance -= value;
        }
    }

    //deposito
    /**
     * Método para realizar o depósito na conta. Caso o valor
     * seja menor que zero, uma exceção será lançada.
     * @param value
     */
    public void deposit(float value) {
        if(value > 0) {
            this.balance += value;
            return;
        }
        throw new AccountException("fail: valor invalido");
    }

    //transferencia para outra conta
    /**
     * Método que faz a transferência para outra conta.
     * @param other - conta de destino
     * @param value - valor da transferência
     */
    public void transfer(Account other, float value) {
        if(value > this.balance) {
			throw new AccountException("fail: saldo insuficiente");
		}
		this.balance -= value;
		other.deposit(value);
    }

    @Override
    /**
     * Formatando a saída.
     */
    public String toString() {
        Locale.setDefault(Locale.US);
        return this.id + ":" + this.clientId + ":" + String.format("%.2f", this.balance) + ":" + this.type;
    }

    //GETS and SETS
    int getId() {
        return id;
    }

    float getBalance() {
        return balance;
    }

    String getClientId() {
        return clientId;
    }

    String getType() {
        return type;
    }
}