package cadastro;

class SavingsAccount extends Account {
    //inicializa conta.type com "CP"
    public SavingsAccount(int id, String idClient) {
        super(id, idClient);
        super.type = "CP";
    }
    
    //aumenta saldo em 1%
    public void monthlyUpdate() {
        super.balance += super.balance * 0.01;
    }
}