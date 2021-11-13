package q02.c;

public class App {
    public static void main(String[] args) {
        Linha linha = new Linha();

        linha.p1 = new Ponto2D();
        linha.p2 = new Ponto2D();

        linha.p1.inicializaPontos(10, 2.5);
        linha.p2.inicializaPontos(-10, -2.5);
        linha.mostraLinha();
    }
}
