package car;
public class Car {
    
    private int gas;
    private final int gasMax = 100;
    private int km;
    private int passageiros;
    private final int passageirosMax = 2;

    /**
     * Construtor da classe, inicia os atributos apenas com zero
     */
    public Car() {
        gas = 0;
        passageiros = 0;
        km = 0;
    }

    /**
     * Método que faz o carro andar, para o carro andar é preciso
     * que tenha gasolina e pelo menos uma pessoa dentro (mostorista).
     * Caso não tenha ninguém dentro, o carro não anda. 
     * Caso não tenha gasolina o carro também não anda.
     * Caso tenha alguém e não tenha gasolina, o carro também não anda.
     * Caso o combustível seja insuficiente para quantidade andada, o carro
     * anda até o zerar o tanque.
     * @param kmAndar - quantidade em km a ser andada
     */
    public void drive(int kmAndar) {
        if((passageiros != 0) && (gas > 0)) {
            if(kmAndar <= gas) {
                km += kmAndar;
                gas -= kmAndar;
            } else if(kmAndar > gas){
                km += gas;
                System.out.println("fail: tanque vazio apos andar " + this.gas + " km");
                gas = 0;
            } else {
                System.out.println("fail: tanque vazio");
            }
        } else if((passageiros != 0) && (gas == 0)) {
            System.out.println("fail: tanque vazio");
        } else {
            System.out.println("fail: nao ha ninguem no carro");
        }
    }
    
    /**
     * Método que embarca pessoas dentro do carro, caso 
     * não tenha atingido o limte
     */
    public void in() {
        if(passageiros < passageirosMax) passageiros++;
        else System.out.println("fail: limite de pessoas atingido");
    }

    /**
     * Método que desenbarca pessoas dentro do carro, caso 
     * tenha alguém no carro
     */
    public void out() {
        if(passageiros != 0) passageiros--;
        else System.out.println("fail: nao ha ninguem no carro");
    }

    /**
     * Método para fazer o abastecimento de gasolina. O carro
     * tem limite para 100 litros de gasolina, caso o valor passado
     * ultrapasse o limite, o restante será descartada
     * @param gasAdd - quantidade a ser colocada de gasolina
     */
    public void fuel(int gasAdd) {
        gas += gasAdd;
        if(gas > gasMax) {
            gas = gasMax;
        }
    }

    /**
     * Método toString() para imprimir o objeto
     */
    public String toString() {
        return "pass: "
            + passageiros
            + ", gas: "
            + gas
            + ", km: " 
            + km;
    }
}
