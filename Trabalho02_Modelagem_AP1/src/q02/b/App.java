package q02.b;

import java.util.Locale;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Retangulo ret = new Retangulo();
        ret.p1 = new Ponto2D();
        ret.p2 = new Ponto2D();
        
        ret.p1.inicializaPontos(0, 3);
        ret.p2.inicializaPontos(3, 0);

        ret.inicializaRetangulo(ret.p1, ret.p2);
        ret.p1.mostraPontos();
        ret.p2.mostraPontos();
    }
}
