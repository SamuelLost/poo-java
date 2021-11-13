class Pet{
    private int energyMax, hungryMax, cleanMax;
    private int energy, hungry, clean;
    private int diamonds;
    private int age;
    private boolean alive;
    // Atribui o valor de energia
    // Se o valor ficar abaixo de 0, o pet morre de fraqueza
    // Garanta que os valores ficarão no interalo 0 - max
    // Use esse modelo para fazer os outros métodos set
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

    void setHungry(int value) {
        if(value <= 0) {
            this.hungry = 0;
            System.out.println("fail: pet morreu de fome");
            this.alive = false;
        } 
        else if(value > this.energyMax) 
            this.hungry = this.hungryMax;
        else 
            this.hungry = value;
    }

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
    int getClean() {
        return this.clean;
    }
    int getHungry() {
        return this.hungry;
    }
    int getEnergy() {
        return this.energy;
    }
    int getEnergyMax() {
        return this.energyMax;
    }
    int getCleanMax() {
        return this.cleanMax;
    }
    int getHungryMax() {
        return this.hungryMax;
    }
    public String toString() {
        return String.format("E:%d/%d, S:%d/%d, L:%d/%d, D:%d, I:%d", energy, energyMax, hungry,
        hungryMax, clean, cleanMax, diamonds, age);
    }
    public boolean testAlive() {
        return (alive) ? true:false;
    }
    // Invoca o método testAlive para verificar se o pet esta vivo
    // Se estiver vivo, altere os atributos utilizando os métodos set e get
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
    public void sleep() {
        if(testAlive()) {
            if((getEnergyMax() - getEnergy()) < 5) {
                System.out.println("fail: nao esta com sono");
            } else {
                setEnergy(getEnergyMax());
                setHungry(getHungry() - 1);
                age++;
                //age = age + (getEnergyMax()-getEnergy());
            }
        } else {
            System.out.println("fail: pet esta morto");
        }
    }
}
