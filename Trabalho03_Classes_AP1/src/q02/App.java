package q02;

public class App {
    public static void main(String[] args) {
        /**
         * Declaração e instanciação das datas
         */
        Data d = new Data((byte) 29, (byte) 12, (short) 2000);
        Data d2 = new Data((byte) 6, (byte) 3, (short) 2003);

        //método toString()
        System.out.println("Data 1: " + d + "\nData 2: " + d2);

        /**
         * Método compara sendo utilizado
         */
        int x = d.compara(d2);
        if(x == 0) System.out.println("Datas iguais");
        else if(x == 1) System.out.println("Data 1 é maior que Data 2");
        else System.out.println("Data 1 é menor que Data 2");
        
        /**
         * Mês por extenso e vendo se o ano é bissexto
         */
        System.out.println("Data 1: " + d.toStringMesExtenso() + "\nData 2: " + d2.toStringMesExtenso());
        System.out.println("O ano de Data 1 é bissexto? " + d.isBissexto(d.getAno()));
        System.out.println("O ano de Data 2 é bissexto? " + d2.isBissexto(d2.getAno()));

        /**
         * Clonando os objetos
         */
        Data clone = d.clone();
        System.out.println("Data clone de Data 1: " + clone);
        clone = d2.clone();
        System.out.println("Data clone de Data 2: " + clone);
    }
}
