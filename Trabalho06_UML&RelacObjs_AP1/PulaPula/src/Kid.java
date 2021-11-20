class Kid {
    private int age; //idade da criança
    private String name; //nome da criança

    /**
     * Construtor que inicializa os atributos da classe
     * @param name - nome da criança
     * @param age - idade da criança
     */
    public Kid(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Métodos getters para retornar idade e nome
     * @return inteiro e Stringe, respectivamente
     */
    int getAge() {
        return age;
    }

    String getName() {
        return name;
    }
    
    /**
     * Métodos setters para setar idade e nome
     */
    void setAge(int age) {
        if(age > 0) this.age = age;
        else System.out.println("fail: idade invalida");
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Método toString() para imprimir o objeto no formato
     * desejado pela questão
     */
    public String toString() {
        return String.format("%s:%d", this.name, this.age);
    }
}