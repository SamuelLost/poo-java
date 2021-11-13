package q03;

import q02.Data;

public class App {
    public static void main(String[] args) {
        /**
         * Criaçãp dos objetos
         */
        Hora horaVoo = new Hora((byte) 10, (byte) 30);
        Data dataVoo = new Data((byte) 19, (byte) 12, (short) 2021);
        Voo voo = new Voo(473360, dataVoo, horaVoo);

        int cadeira = 10;
        voo.ocupa(cadeira); //Ocupando uma cadeira
        System.out.println("Próxima cadeira livre: #" + voo.proximoLivre(cadeira));
        voo.ocupa(cadeira+1); //Ocupando uma cadeira
        voo.verifica(cadeira); //Verificando uma cadeira
        voo.ocupa(1); //Ocupando uma cadeira
        voo.verifica(cadeira+1); //Ocupando uma cadeira
        System.out.println("---------- DADOS DO VÔO ----------\n" + voo 
                        + "\n----------------------------------");    
        
        System.out.println("Próxima cadeira livre: #" + voo.proximoLivre(cadeira+1));
        
        Data data = voo.getData(); //Pegando o objeto data
        System.out.println("Data do vôo pelo método getDat(): " + data);

        Voo clone = voo.clone(voo); //Clonando o objeto
        System.out.println(clone);
    }
}
