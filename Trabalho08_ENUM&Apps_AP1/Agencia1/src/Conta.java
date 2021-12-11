public class Conta {
    //O número da conta
    private int id;
    private Financas financas; //objeto da classe Finanças
    /**
     * Construtor da classe Conta
     * @param id
     */
    public Conta(int id) {
        this.id = id;
        this.financas = new Financas();
        this.financas.addOperacao(Label.abertura, 0);
    }

    //só realiza a operação se houver dinheiro suficiente na conta
    /**
     * Método usado para sacar dinheiro da conta, usa o método addOperacao()
     * da classe Finanças passando label e valor
     * @param value - valor a ser sacado
     * @return - true caso tenha sido possível saca, false caso contrário.
     */
    public boolean sacar(int value) {
        if(financas.getSaldo() > value) {
            financas.addOperacao(Label.saque, value);
            return true;
        }
        System.out.println("fail: saldo insuficiente");
        return false;
    }

    //retira o dinheiro, mesmo que o saldo fique negativo
    /**
     * Método que cobra tarifa da conta, chamando o método
     * addOperacao() de Finanças.
     * @param value - valor da tarifa
     * @return true caso a tarifa tenha sido cobrada.
     */
    public boolean tarifar(int value) {
        financas.addOperacao(Label.tarifa, value);
        return true;
    }

    //se o índice for válido e representar uma operação de tarifa
    //adicione o mesmo valor tarifado, mas com label de extorno
    /**
     * O método extornar pega um tarifa que foi cobrada e retorna para o 
     * saldo da conta. Para isso é preciso encontrar qual operação foi a 
     * tarifa e não pode ser valores inválidos. É feita a partir do método
     * addOperacoes().
     * @param indice - indice da tarifa que vai ser extornada
     * @return true caso tenha sido possível extornar, false caso contrário. 
     */
    public boolean extornar(int indice) {
        if(indice < 0 || indice > financas.getExtrato().size()) {
            System.out.println("fail: indice " + indice + " invalido");
            return false;
        }
        if(financas.getExtrato().get(indice).getLabel() != Label.tarifa) {
            System.out.println("fail: indice " + indice + " nao e tarifa");
            return false;
        } 
        financas.addOperacao(Label.extorno, financas.getExtrato().get(indice).getValue());
        return true;
    }

    //adiciona valor à conta
    /**
     * O método creditar é usado para depósitos. Só valores positivos e maiores que 0 são aceitos
     * @param label - label de depósito
     * @param value - valor a ser depositado
     * @return - true caso tenha sido possível depositar, false caso contrário.
     */
    public boolean creditar(Label label, int value) {
        if(value > 0) {
            financas.addOperacao(label, value);
            return true;
        }
        System.out.println("fail: valor invalido");
        return false;
    }

    /**
     * Formatando a string de saída da conta.
     */
    public String toString() {
        return "conta:" + id + " saldo:" + financas.getSaldo();
    }

    //GET para o objeto finanças
    public Financas getFinancas() {
        return financas;
    }
}