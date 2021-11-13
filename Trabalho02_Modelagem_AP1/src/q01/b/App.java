package q01.b;

public class App {
    public static void main(String[] args) {
        HoraPrecisa hora = new HoraPrecisa();
        hora.inicializaHora((byte)00, (byte)00, (byte)10, (byte)99);
        hora.mostraHora();
    }
}