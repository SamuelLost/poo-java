import java.util.ArrayList;
import java.util.List;

//Finanças registra o saldo e guarda as movimentações financeiras
public class Financas {
    //O id da próxima operação dessa conta
    private int nextId;
    //A lista de operações realizadas
    private List<Operacao> extrato;
    private int saldo; //saldo

    /**
     * Construtor padrão da classe.
     */
    public Financas() {
        nextId = 0;
        extrato = new ArrayList<>();
        saldo = 0;

    }

    //Adiciona value ao saldo
    //Crie operação e adiciona ao vetor de operações
    //Incrementa o nextId
    /**
     * Método addOperacao, de acordo com a label, uma 
     * operação é feita e a operação é adicionada na
     * lista de operações
     * @param label - label da operação
     * @param value - valor referente a operação
     */
    public void addOperacao(Label label, int value) {
        if(label == Label.abertura) {
            saldo = value;
            extrato.add(new Operacao(nextId, label, value, saldo));
            nextId++;
        } else if(label == Label.deposito) {
            saldo += value;
            extrato.add(new Operacao(nextId, label, value, saldo));
            nextId++;
        } else if(label == Label.extorno) {
            saldo += -value;
            extrato.add(new Operacao(nextId, label, -value, saldo));
            nextId++;
        } else if(label == Label.saque) {
            saldo -= value;
            extrato.add(new Operacao(nextId, label, -value, saldo));
            nextId++;
        } else if(label == Label.tarifa) {
            saldo -= value;
            extrato.add(new Operacao(nextId, label, -value, saldo));
            nextId++;
        }
    }

    /**
     * Métodos GETTERS
     */
    public int getSaldo() {
        return saldo;
    }
    public List<Operacao> getExtrato() {
        return extrato;
    }
    /**
     * Usando o método subList() da classe List, com ela é possível
     * pegar uma parte específica da Lista completa, nesse caso as
     * N ultimas operações. 
     * @param qtdOp - qntd de operações
     * @return - a sublista
     */
    public List<Operacao> getExtrato(int qtdOp) {
        return extrato.subList(extrato.size() - qtdOp, extrato.size());
    }
}