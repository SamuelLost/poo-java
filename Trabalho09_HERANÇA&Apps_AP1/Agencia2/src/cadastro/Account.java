package cadastro;

import java.util.Locale;

public abstract class Account {
    protected int id;
    protected float balance;
    protected String clientId;
    protected String type; //CC or CP

    public Account(int id, String clientId) {
        this.id = id;
        this.clientId = clientId;
        balance = 0;
    }

    //abstract method
    public abstract void monthlyUpdate();

    //saque
    public void withdraw(float value) {
        if(value > balance) {
            throw new AccountException("fail: saldo insuficiente");
        } else {
            balance -= value;
        }
    }

    //deposito
    public void deposit(float value) {
        if(value > 0) {
            balance += value;
            return;
        }
        throw new AccountException("fail: valor invalido");
    }

    //transferencia para outra conta
    public void transfer(Account other, float value) {
        if(value > this.balance) {
			throw new AccountException("fail: saldo insuficiente");
		}
		this.balance -= value;
		other.deposit(value);
    }

    @Override
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