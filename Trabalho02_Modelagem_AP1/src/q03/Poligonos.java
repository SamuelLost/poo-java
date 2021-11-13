package q03;

public class Poligonos {
    int numDeLados;
    String nomePoligono;

    /**
     * Inicialização do atributo qntdLados da Classe Poligono
     * 
     * @param numDeLados - quantos lados do poligono
     */
    void inicializaPoligono(int numDeLados) {
        this.numDeLados = numDeLados;
    }

    /**
     * Método simples com switch-case analisando o atributo numLados para determinar
     * qual o nome do poligono inicializado
     */
    String qualPoligono() {
        switch (numDeLados) {
        case 3:
            nomePoligono = "Triângulo";
            break;
        case 4:
            nomePoligono = "Quadrilátero";
            break;
        case 5:
            nomePoligono = "Pentágono";
            break;
        case 6:
            nomePoligono = "Hexágono";
            break;
        case 7:
            nomePoligono = "Heptágono";
            break;
        case 8:
            nomePoligono = "Octágono";
            break;
        case 9:
            nomePoligono = "Eneágono";
            break;
        case 10:
            nomePoligono = "Decágono";
            break;

        default:
            break;
        }

        return nomePoligono;
    }

    /**
     * Metodo booleano para saber se o poligono
     * está entre o grupo de regulares pedido
     * pelo enunciado até 10 lados
     * @return - true caso esteja, false caso contrario
     */
    boolean estaEntreOsRegulares() {
        if(numDeLados < 3 || numDeLados > 10) {
            return false;
        }
        return true;
    }

    /**
     * Metodo que imprime os dados referentes ao poligono que foi inicializado
     * caso ele seja regular
     */
    void mostraPoligono() {
        if(estaEntreOsRegulares())
            System.out.println("Número de lados: " + numDeLados + "\n" + "Nome: " + qualPoligono());
        else
            System.out.println("Polígono não está entre 3 e 10 lados");
    }
}
