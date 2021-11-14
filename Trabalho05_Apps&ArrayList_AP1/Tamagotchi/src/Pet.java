class Pet{
    private int energyMax, hungryMax, cleanMax; //atributos máximos
    private int energy, hungry, clean; //atributos de energia, saciedade e limpeza
    private int diamonds; //atributos de diamantes
    private int age; //atributo para idade
    private boolean alive; //booleano para verificar se o pet está vivo

    /**
     * setEnergy() vai atribuir um valor inteiro passado no parâmetro ao
     * atributo energy da classe. Caso o valor seja menor ou igual
     * a zero, o pet morre. Caso o valor seja maior que o limite, 
     * o atributo energy pega o valor máximo. Caso o valor seja menor
     * que o limite e maior que zero, energy recebe valor passado.
     * @param value - valor de energia
     */
    void setEnergy(int value){
        if(value <= 0){
            this.energy = 0;
            System.out.println("fail: pet morreu de fraqueza");
            this.alive = false;
        }
        else if(value > this.energyMax)
            this.energy = this.energyMax;
        else
            this.energy = value;
    }

    /**
     * Seguindo mesmo padrão do método setEnergy(), temos setHungry()
     * que vai atribuir um valor inteiro passado por referencia ao
     * atributo hungry da classe. Caso o valor seja menor ou igual
     * a zero, o pet morre. Caso o valor seja maior que o limite, 
     * o atributo hungry pega o valor máximo. Caso o valor seja menor
     * que o limite e maior que zero, hungry recebe valor passado.
     * @param value - inteiro correspondente ao valor que o atributo 
     * vai receber
     */
    void setHungry(int value) {
        if(value <= 0) {
            this.hungry = 0;
            System.out.println("fail: pet morreu de fome");
            this.alive = false;
        } 
        else if(value > this.hungryMax) 
            this.hungry = this.hungryMax;
        else 
            this.hungry = value;
    }
    /**
     * Seguindo mesmo padrão do método setEnergy(), temos setClean()
     * que vai atribuir um valor inteiro passado por referencia ao
     * atributo clean da classe. Caso o valor seja menor ou igual
     * a zero, o pet morre. Caso o valor seja maior que o limite, 
     * o atributo clean pega o valor máximo. Caso o valor seja menor
     * que o limite e maior que zero, clean recebe valor passado.
     * @param value - inteiro correspondente ao valor que o atributo 
     * vai receber
     */
    void setClean(int value) {
        if(value <= 0) {
            this.clean = 0;
            System.out.println("fail: pet morreu de sujeira");
            this.alive = false;
        }
        else if(value > this.cleanMax) 
            this.clean = this.cleanMax;
        else 
            this.clean = value;
    }

    /**
     * Construtor da Classe Pet. Faz a inicialização dos atributos.
     * Inicia energy, hungry e clean com seus valores máximos
     * Inicia diamantes e idade com zero
     * Inicia alive como true, o pet está vivo
     * @param energy - valor que corresponde a energia máxima
     * @param hungry - valor que corresponde a saciedade máxima
     * @param clean - valor que corresponde a limpeza máxima
     */
    public Pet(int energy, int hungry, int clean) {
        this.energyMax = energy;
        this.hungryMax = hungry;
        this.cleanMax = clean;
        this.energy = energyMax;
        this.hungry = hungryMax;
        this.clean = cleanMax;
        diamonds = 0;
        age = 0;
        alive = true;
    }

    /**
     * Método getClean
     * @return - retorna o valor do atributo clean
     */
    int getClean() {
        return this.clean;
    }

    /**
     * Método getHungry
     * @return - retorna o valor do atributo hungry
     */
    int getHungry() {
        return this.hungry;
    }

    /**
     * Método getEnergy
     * @return - retorna o valor do atributo energy
     */
    int getEnergy() {
        return this.energy;
    }

    /**
     * Método getEnergyMax
     * @return - retorna o valor do atributo energyMax
     */
    int getEnergyMax() {
        return this.energyMax;
    }

    /**
     * Método getCleanMax
     * @return - retorna o valor do atributo cleanMax
     */
    int getCleanMax() {
        return this.cleanMax;
    }

    /**
     * Método getHungryMax
     * @return - retorna o valor do atributo hungryMax
     */
    int getHungryMax() {
        return this.hungryMax;
    }
    

    /**
     * Método toString() padrão da classe, para que o objeto seja impresso
     * no formato: E: energy/energyMax, S:hungry/hungryMax, L:clean/cleanMax, D:diamonds, I:age
     * @return 
     */
    public String toString() {
        return String.format("E:%d/%d, S:%d/%d, L:%d/%d, D:%d, I:%d", energy, energyMax, hungry,
        hungryMax, clean, cleanMax, diamonds, age);
    }

    /**
     * Método booleano que verifica se o pet está vivo
     * @return true caso esteja vivo, false caso contrário
     */
    public boolean testAlive() {
        return (alive) ? true:false;
    }

    // Invoca o método testAlive para verificar se o pet esta vivo
    // Se estiver vivo, altere os atributos utilizando os métodos set e get
    /**
     * O método play() é chamado quando o pet vai brincar, mas primeiro o
     * pet tem que estar vivo, se não estiver uma mensagem de erro é impressa.
     * Ao brincar, o pet perde 2 energias, perde 1 saciedade, perde 3 de limpeza,
     * diamantes aumentam em 1 e idade também.
     */
    public void play() {
        if(testAlive()) {
            setEnergy(getEnergy() - 2);
            setHungry(getHungry() - 1);
            setClean(getClean() - 3);
            diamonds++;
            age++;
        } else {
            System.out.println("fail: pet esta morto");
        }
    }

    /**
     * O método shower() é chamado quando o pet vai tomar banho, porém ele precisa
     * estar vivo, se não uma mensagem é impressa.
     * Ao tomar banho, o pet perde 3 energias, perde 1 saciedade, limpeza vai para
     * máximo e idade aumenta em 2.
     */
    public void shower() {
        if(testAlive()) {
            setEnergy(getEnergy() - 3);
            setHungry(getHungry() - 1);
            setClean(getCleanMax());
            age += 2;
        } else {
            System.out.println("fail: pet esta morto");
        }
    }

    /**
     * O método eat() é chamado quando o pet vai comer, porém ele precisa
     * estar vivo, se não uma mensagem é impressa.
     * Ao comer, o pet perde 1 energia, ganha 4 saciedades, perde 2 limpezas
     * e idade aumenta em 1.
     */
    public void eat() {
        if(testAlive()) {
            setEnergy(getEnergy() - 1);
            setHungry(getHungry() + 4);
            setClean(getClean() - 2);
            age++;
        } else {
            System.out.println("fail: pet esta morto");
        }
    }

    /**
     * O método sleep() é chamado quando o pet vai dormir, porém ele precisa
     * estar vivo, se não uma mensagem é impressa.
     * Para o pet conseguir dormir, é necessário que ele tenha gasto
     * pelo menos 5 unidades de energia, caso contrário ele não irá dormir
     * e uma mensagem será impressa.
     * Ao dormir, o pet tem a energia maximizada, perde 1 saciedade,
     * limpeza não muda e idade aumenta a cada vez que o comando "sleep"
     * é digitado.
     */
    public void sleep() {
        if(testAlive()) {
            if((getEnergyMax() - getEnergy()) < 5) {
                System.out.println("fail: nao esta com sono");
            } else {
                setEnergy(getEnergyMax());
                setHungry(getHungry() - 1);
                age++;
                
            }
        } else {
            System.out.println("fail: pet esta morto");
        }
    }
}
