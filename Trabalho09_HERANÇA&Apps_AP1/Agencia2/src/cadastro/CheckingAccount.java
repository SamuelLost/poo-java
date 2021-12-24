package cadastro;

class CheckingAccount extends Account {
    //inicializa conta.type com "CC"
    /**
     * Construtor da classe conta corrente.
     * @param id - id da conta
     * @param idClient - id do cliente
     */
    public CheckingAccount(int id, String idClient) {
        super(id, idClient);
        super.type = "CC";
    }
    
    //retira 20 do saldo
    /**
     * Atualização mensal da conta-corrente, retirando
     * 20 reais do saldo a cada mês.
     */
    public void monthlyUpdate() {
        super.balance -= 20;
    }
}