package q02.a;

import java.util.Locale;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Ponto2D ponto1 = new Ponto2D();
        double x = -2.0, y = -4.5;
        ponto1.inicializaPontos(x, y);
        ponto1.mostraPontos();
        ponto1.quadrante();
    }
}
