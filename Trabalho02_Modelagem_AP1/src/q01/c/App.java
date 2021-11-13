package q01.c;



public class App {
    public static void main(String[] args) {
        byte hora = 10;
        byte minutos = 00;
        //byte segundos = 00;
        //byte centesimo = 77;

        byte dia = 29;
        byte mes = 12;
        short ano = 2000;
        DataHora dataHora = new DataHora();
        dataHora.data.inicializaData(dia, mes, ano);
        dataHora.horaAprox.inicializaHora(hora, minutos);
        dataHora.mostraDataHora();
    }
}
