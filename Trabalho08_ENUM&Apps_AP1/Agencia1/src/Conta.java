public class Conta {
    //O número da conta
    private int id;
    private Financas financas;
    public Conta(int id) {
        this.id = id;
        this.financas = new Financas();
        this.financas.addOperacao(Label.abertura, 0);
    }
    //só realiza a operação se houver dinheiro suficiente na conta
    public boolean sacar(int value) {
        if(financas.getSaldo() > value) {
            financas.addOperacao(Label.saque, value);
            return true;
        }
        System.out.println("fail: saldo insuficiente");
        return false;
    }
    //retira o dinheiro, mesmo que o saldo fique negativo
    public boolean tarifar(int value) {
        financas.addOperacao(Label.tarifa, value);
        return true;
    }
    //se o índice for válido e representar uma operação de tarifa
    //adicione o mesmo valor tarifado, mas com label de extorno
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
    public boolean creditar(Label label, int value) {
        if(value > 0) {
            financas.addOperacao(label, value);
            return true;
        }
        System.out.println("fail: valor invalido");
        return false;
    }

    public String toString() {
        return "conta:" + id + " saldo:" + financas.getSaldo();
    }

    public Financas getFinancas() {
        return financas;
    }
}