package cadastro;

class CheckingAccount extends Account {
    //inicializa conta.type com "CC"
    public CheckingAccount(int id, String idClient) {
        super(id, idClient);
        super.type = "CC";
    }
    
    //retira 20 do saldo
    public void monthlyUpdate() {
        super.balance -= 20;
    }
}