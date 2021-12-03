public class Pass {
    private String name; //nome do passageiro
    private int age; //idade

    /**
     * Construtor do passageiro
     * @param name - nome
     * @param age - idade
     */
    public Pass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Método para checar se a pessoa é prioridade
     * @return
     */
    public boolean isPriority() {
        return (age >= 65) ? true:false;
    }

    //GETS e SETS
    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }
    
    /**
     * Formatando a saída
     */
    public String toString() {
        return name + ":" + age;
    }
}