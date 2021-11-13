package motorcycle;

public class Person {
    /**
     * Atributos da classe
     */
    private String name;
    private int age;

    /**
     * Construtor da classe Person
     * @param name - string que representa o nome da pessoa
     * @param age - inteiro que representa a idade de pessoa
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    /**
     * Método getName()
     * @return - retorna o nome da pessoa
     */
    public String getName() {
        return name;
    }

    /**
     * Método getAge()
     * @return - retorna a idade da pessoa
     */
    public int getAge() {
        return age;
    }

    /**
     * Método toString() para fazer a impressão
     * do objeto no formato [name:age]
     * @return - string formatada
     */
    public String toString() {
        return "["
            + name
            + ":"
            + age
            + "]";
    }
}