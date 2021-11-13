package calculator;

class Calculator {
    private int batteryMax;
    private int battery;
    private float display;
    //Inicia os atributos, battery e display começam com o zero.
    /**
     * Construtor para iniciar os atributos da classe
     * @param batteryMax - inteiro correspondente a quantidade máxima da bateria
     */
    public Calculator(int batteryMax) {
        this.batteryMax = batteryMax;
        battery = 0;
        display = 0;
    }
    //Aumenta a bateria, porém não além do máximo.
    /**
     * Método que realiza a carga da bateria até seu limite máximo
     * @param value - inteiro correspondente ao limite
     */
    public void chargeBattery(int value) {
        battery += value;
        if(battery > batteryMax) {
            battery = batteryMax;
        }
    }
    //Tenta gastar uma unidade da bateria e emite um erro se não conseguir.
    /**
     * Método que faz a verificação da bateria, se estiver com carga,
     * decrementa em uma unidade a bateria.
     * @return true caso tenha bateria suficiente, false caso contrário
     */
    public boolean useBattery() {
        if((battery != 0) && (battery > 0)) {
            battery--;
            return true;
        }
        return false;
    }
    //Se conseguir gastar bateria, armazene a soma no atributo display.
    /**
     * O método sum(a,b) realiza a operação de soma, o método useBattery()
     * é chamado para saber se é possível utilizar a calculadora, ou seja, 
     * se tem bateria o suficiente, caso tenha a operação é realizada.
     * Caso contrário, uma mensagem de erro é mostrada. O resultado da
     * operação é armazenado em display.
     * @param a - inteiro correspondente ao número 1
     * @param b - inteiro correspondente ao número 2
     */
    public void sum(int a, int b) {
        if(useBattery()) {
            display = a + b;
        } else {
            System.out.println("fail: bateria insuficiente");
        }
    }
    
    /**
     * O método subtract(a,b) realiza a operação de subtração, o método useBattery()
     * é chamado para saber se é possível utilizar a calculadora, ou seja, 
     * se tem bateria o suficiente, caso tenha a operação é realizada.
     * Caso contrário, uma mensagem de erro é mostrada. O resultado da
     * operação é armazenado em display.
     * @param a - inteiro correspondente ao número 1
     * @param b - inteiro correspondente ao número 2
     */
    public void subtract(int a, int b) {
        if(useBattery()) {
            display = a - b;
        } else {
            System.out.println("fail: bateria insuficiente");
        }
    }

    /**
     * O método multiply(a,b) realiza a operação de multiplicação, o método useBattery()
     * é chamado para saber se é possível utilizar a calculadora, ou seja, 
     * se tem bateria o suficiente, caso tenha a operação é realizada.
     * Caso contrário, uma mensagem de erro é mostrada. O resultado da
     * operação é armazenado em display.
     * @param a - inteiro correspondente ao número 1
     * @param b - inteiro correspondente ao número 2
     */
    public void multiply(int a, int b) {
        if(useBattery()) {
            display = a * b;
        } else {
            System.out.println("fail: bateria insuficiente");
        }
    }

    //Se conseguir gastar bateria e não for divisão por 0.
    /**
     * O método division(a,b) realiza a operação de divisão, o método useBattery()
     * é chamado para saber se é possível utilizar a calculadora, ou seja, 
     * se tem bateria o suficiente, caso tenha a operação é realizada.
     * Caso contrário, uma mensagem de erro é mostrada. Caso tente dividir por 0,
     * uma mensagem de erro será mostrada. O resultado da operação é armazenado em display.
     * @param a - inteiro correspondente ao número 1
     * @param b - inteiro correspondente ao número 2
     */
    public void division(int num, int den) {
        if(den == 0) {
            if(useBattery()) {
                System.out.println("fail: divisao por zero");
            } else {
                System.out.println("fail: bateria insuficiente");
            }
        } else {
            if(useBattery()) {
                display = (float) num/den;
            } else {
                System.out.println("fail: bateria insuficiente");
            }
        }
    }
    //Retorna o conteúdo do display com duas casas decimais.
    /**
     * Método toSting() para poder mostrar o objeto na tela,
     * utilizando 2 casas decimais para mostrar o display
     */
    public String toString() {
        return "display: "
            + String.format("%.2f", display)
            + ", battery: "
            + String.format("%d", battery);
    }
}
