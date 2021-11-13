package q02.c;

class Linha {
    /**
     * Instancias da classe Ponto2D
     */
    Ponto2D p1, p2;

    /**
     * Metodo inicializaLinha faz a construção de uma linha
     * ligada em dois pontos quaisquer
     * @param p1 - pontos 1 da classe Ponto2D
     * @param p2 - pontos 2 da classe Ponto2D
     */
    void inicializaLinha(Ponto2D p1, Ponto2D p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     * Para se caracterizar uma linha é preciso ter uma
     * distancia entre esse pontos, que é o mesmo tamanho da reta
     * entre os dois ponto, o metodo distance2Points faz o calculo
     * @param p1 - pontos 1 da classe Ponto2D
     * @param p2 - pontos 2 da classe Ponto2D
     * @return - o valor da distancia em double
     */
    double distance2Points(Ponto2D p1, Ponto2D p2) {
        double x1 = p1.x;
        double y1 = p1.y;
        double x2 = p2.x;
        double y2 = p2.y;

        double dist = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        return dist;
    }

    /**
     * Método para imprimir os dois pontos presentes na reta e 
     * mostrar a distancia entre eles, que exemplifica a reta.
     */
    void mostraLinha() {
        p1.mostraPontos();
        p2.mostraPontos();
        System.out.println("Tamanho da linha: " + distance2Points(p1, p2));
    }

}
