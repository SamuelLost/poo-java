package q01.a;
public class HoraAproximada {
    
    byte hora;
    byte minutos;
    /**
     * Faz a inicializacao de uma hora, recebendo 2 atributos
     * @param hora - campo que corresponde a horas
     * @param minutos - campo que corresponde aos minutos
     */
    void inicializaHora(byte hora, byte minutos) {
        this.hora = hora;
        this.minutos = minutos;
    }

    /**
     * Analise simplista e generica para determinar se
     * a hora inicializada é valida ou nao
     * @param hora - campo que corresponde a horas
     * @param minutos - campo que corresponde aos minutos
     * @return true caso seja valida, false caso contrario
     */
    boolean horaEhValida(byte hora, byte minutos) {
        if(hora <= 24 && hora >= 00) {
            if(minutos <= 59 && minutos >= 00) {
                return true;
            }
        }
        return false;
    }
    /**
     * Metodo para imprimir a hora se ela for valida
     */
    void mostraHora() {
        if(horaEhValida(hora, minutos))
            System.out.printf("%02d:%02d\n", hora, minutos);
        else
            System.out.println("Hora inválida");
    }
}
