package q03;

import q02.Data;

public class Voo {

    /**
     * Atributos da classe Voo
     */
    private boolean[] cadeirasOcupadas = new boolean[100];
    private Data data;
    private Hora hora;
    private int numVoo;

    /**
     * Contrutor da classe
     * @param numVoo - número aleatório do vôo
     * @param data - instancia da classe Data representando a data do vôo
     * @param hora - instancia da classe Hora representando a hora do vôo
     */
    public Voo(int numVoo, Data data, Hora hora) {
        
        this.data = data;
        this.hora = hora;
        this.numVoo = numVoo;
    }

    /**
     * Método para pegar a instancia da data
     * @return - retorna a instancia data do vôo
     */
    public Data getData() {
        return data;
    }

    /**
     * Método para pegar o número do vôo
     * @return - inteiro, número do vôo
     */
    public int getNumVoo() {
        return numVoo;
    }

    /**
     * Que procura pela próxima cadeira livre
     * @param cadeira - inteiro entre 1 e 100.
     * A verificação começa de cadeira-1 pois o vetor 
     * está entre 0 e 99, o parâmetro entre 1 e 100 e
     * porque quer a próxima cadeira livre, cadeira 
     * na frente da que foi ocupada. 
     * @return - o número da cadeira
     *         -1: caso não tenha mais cadeiras livres 
     * após o argumento
     */
    public int proximoLivre(int cadeira) {
        for(int i = cadeira-1; cadeira < 100; i++) {
            if(cadeirasOcupadas[i] == false) return i+1;
        }
        return -1;
    }

    /**
     * O método faz a verificação para saber se a cadeira está
     * ocupada não. Olha a posição do vetor booleano, se na posição
     * do parâmetro for true, então ela está ocupada e uma
     * mensagem é exibida.
     * @param cadeira - o número da cadeira a ser verificada
     */
    public void verifica(int cadeira) {
        if((cadeirasOcupadas[cadeira-1])) System.out.println("Cadeira #" + cadeira + " está ocupada");
        else System.out.println("Cadeira #" + cadeira + " está livre");
    }

    /**
     * Método faz a ocupação de uma cadeira, como se o usuário tivesse
     * comprado uma passagem. Analisa o número da cadeira no vetor de 
     * cadeiras, se for true, está ocupada. Se não, ela pode e será 
     * ocupada. 
     * @param cadeira - o número da cadeira desejada
     * @return true - caso a ocupação tenha sido bem-sucedida,
     * false caso contrário
     */
    public boolean ocupa(int cadeira) {
        if(cadeirasOcupadas[cadeira-1]) return false; //Cadeira já está ocupada
        else {
            cadeirasOcupadas[cadeira-1] = true;
            return true;
        }
    }

    /**
     * Método percorre o vetor de cadeiras e conta quantas
     * vagas ainda tem disponível
     * @return - inteiro com o número de vagas
     */
    public int vagas() {
        int count = 0;
        for(int i = 0; i < cadeirasOcupadas.length; i++) {
            if(cadeirasOcupadas[i] == false) count++;
        }
        return count;
    }

    /**
     * Método clone, cria uma instancia da classe
     * e faz apontar a classe passada por argumento
     * @param voo - instancia da própria classe
     * @return - um objeto clone de si mesmo
     */
	//Errada
    /*public Voo clone(Voo voo) {
        Voo clone = voo;
        return clone;
    }/*

    public Voo clone(Voo voo) {
        Voo clone = new Voo(this.numVoo, this.data, this.hora);
        return clone;
    }

    /**
     * Método toString() padrão com as informações do vôo
     */
    public String toString() {
        return "Vôo número: " 
            + getNumVoo()
            + '\n'
            + "Capacidade máxima: 100\n"
            + "Vagas: "
            + this.vagas()
            + '\n'
            + "Data: "
            + data.toString()
            + "\nHora: "
            + hora.toString();
    }
}
