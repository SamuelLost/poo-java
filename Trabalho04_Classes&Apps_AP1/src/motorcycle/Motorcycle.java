package motorcycle;

public class Motorcycle {
    /**
     * Atributos da classe
     */
    private Person person; // agregacao
    private int power;
    private int time;

    /**
     * Contrutor da classe. Inicia o atributo power, time com zero e person com null
     * @param power - inteiro representando a potência da moto
     */
    public Motorcycle(int power) {
        person = null;
        this.power = power;
        time = 0;
    }

    // Comprar mais tempo
    /**
     * Método que faz a compra de mais minutos para 
     * a utilização da moto
     * @param time - quantidade de tempo a ser comprada
     */
    public void buy(int time) {
        this.time += time;
    }

    // Se estiver vazio, coloca a pessoa na moto e retorna true
    /**
     * Método que faz uma pessoa subir na moto
     * Se o parâmetro for nulo, não pode entrar na moto.
     * Se a pessoa empacota for nula (não estiver ninguém na moto),
     * a pessoa do parâmetro assume o lugar.
     * Se já estiver alguém na moto, uma mensagem de erro é exibida
     * @param person - uma instância da classe Person
     * @return - true caso seja possível entrar na moto, false caso contrário
     */
    public boolean in(Person person) {
        if (person == null)
            return false;
        if (this.person == null) {
            this.person = person;
            return true;
        } else {
            System.out.println("fail: moto ocupada");
            return false;
        }
    }

    // Se houver uma person, retira e retorna
    // Se não, retorna null
    /**
     * Método que faz uma pessoa sair da moto.
     * Se tiver alguém na moto essa pessoa é retornada pelo
     * método e a pessoa encapsulado se torna null, ou seja,
     * a moto fica livre. Caso não tenha ninguém na moto,
     * ou seja, o atributo person da classe seja null, uma 
     * mensagem de erro é exibida.
     * @return - uma instância da classe Person
     * que representa a pessoa que saiu da moto.
     */
    public Person out() {
        if (person != null) {
            Person p = person;
            person = null;
            return p;
        } else {
            System.out.println("fail: moto vazia");
            return null;
        }

    }

    /**
     * Método para fazer a pessoa andar na motinha.
     * Primeiro é preciso ver se tem alguém montado na moto, 
     * se não tiver, uma mensagem é exibida. 
     * Caso tenha, é preciso ver se o tempo encapsulado é 
     * maior que zero e se a pessoa tem idade menor igual a 10 anos,
     * se for, a pessoa vai andar na motinha até o tempo encapsulado
     * acabar caso o tempo encapsulado seja menor que o tempo passado no parametro.
     * Caso o tempo encapsulado seja maior ou igual ao parâmetro passado, 
     * a pessoa vai andar todo esse tempo.
     * Caso não respeite a condição de tempo zerado ou idade, uma 
     * mensagem será exibida
     * @param time - inteiro para o tempo que quer andar na moto
     */
    public void drive(int time) {
        if (person != null) {
            if ((this.time > 0) && (person.getAge() <= 10)) {
                if(this.time < time) {
                    System.out.printf("fail: andou %d min e acabou o tempo\n", this.time);
                    this.time = 0;
                } else {
                    this.time -= time;
                }
            } else if ((this.time == 0) && (person.getAge() <= 10)) {
                System.out.println("fail: tempo zerado");
            } else if ((this.time > 0) && (person.getAge() > 10)) {
                System.out.println("fail: muito grande para andar de moto");
            }
        } else {
            System.out.println("fail: moto vazia");
        }
    }

    // buzinar
    /**
     * Método que faz a buzina de acordo com a potência da moto
     * imprime na tela Pem com o número de "e" de acordo com o
     * valor encapuslado no atributo potência. For variando de 0
     * até a potencia concatenando vários "e". A moto tem que 
     * ter alguém em cima para poder buzinar
     */
    public void honk() {
        if (person != null) {
            String out = "P";
            for (int i = 0; i < power; i++) {
                out += "e";
            }
            out += "m";
            System.out.println(out);
        } else {
            System.out.println("fail: moto vazia");
        }

    }

    /**
     * Método toString para imprimir o objeto no formato
     * pedido pela questão, caso tenham alguém na moto,
     * imprime nome e idade, caso contrário, apenas null
     */
    public String toString() {
        // String p = person.toString();
        if (person != null) {
            return "potencia: " 
                + power 
                + ", minutos: " 
                + time 
                + ", pessoa: " 
                + person.toString();
        } else {
            return "potencia: " 
                + power 
                + ", minutos: " 
                + time 
                + ", pessoa: null";
        }
    }
}