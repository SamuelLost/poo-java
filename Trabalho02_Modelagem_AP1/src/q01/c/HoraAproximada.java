package q01.c;
class HoraAproximada {
    
    byte hora;
    byte minutos;
    /**
     * Metodo que inicializa os atributos presentes
     * na classe HoraAproximada
     * @param hora - corresponde ao campo das horas
     * @param minutos - corresponde ao campo dos minutos
     */
    void inicializaHora(byte hora, byte minutos) {
        this.hora = hora;
        this.minutos = minutos;
    }

    /**
     * O metodo horaEhValida faz uma checagem simples
     * se a hora esta dentre seus limites
     * @param hora - corresponde ao campo das horas
     * @param minutos - corresponde ao campo dos minutos
     * @return true se a hora for valida, false caso contrario
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
     * Chama o metodo horaEhValida, caso seja true, 
     * imprime o horario no formato Hora:minuto
     * caso contrario, uma mensagem de erro
     */
    void mostraHora() {
        if(horaEhValida(hora, minutos))
            System.out.printf("%02d:%02d\n", hora, minutos);
        else
            System.out.println("Hora inválida");
    }
}
