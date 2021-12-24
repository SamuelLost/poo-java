package cadastro;

class SavingsAccount extends Account {
    //inicializa conta.type com "CP"
    /**
     * Construtor para a classe de conta poupança
     * @param id - id da conta
     * @param idClient - id do cliente
     */
    public SavingsAccount(int id, String idClient) {
        super(id, idClient);
        super.type = "CP";
    }

    //aumenta saldo em 1%
    /**
     * Atualização mensal do saldo da conta, aumentando 1% em cada
     * mês.
     */
    public void monthlyUpdate() {
        super.balance += super.balance * 0.01;
    }
}