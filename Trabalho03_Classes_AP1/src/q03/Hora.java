package q03;
class Hora {
    
    byte hora;
    byte minutos;
    /**
     * Metodo construtor que inicializa os atributos presentes
     * na classe Hora
     * @param hora - corresponde ao campo das horas
     * @param minutos - corresponde ao campo dos minutos
     */
    Hora(byte hora, byte minutos) {
        if(horaEhValida(hora, minutos)) {
            this.hora = hora;
            this.minutos = minutos;
        } else {
            this.hora = -1;
            this.minutos = -1;
        }
        
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
    /*void mostraHora() {
        System.out.printf("%02d:%02d\n", hora, minutos);
    }*/

    public String toString() {
        return String.format("%02d", (byte) this.hora)
            + ':'
            + String.format("%02d", (byte) this.minutos);
    }
}
