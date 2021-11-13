package q01.b;

public class HoraPrecisa {
    
    byte hora;
    byte minutos;
    byte segundos;
    byte centesimos;
    /**
     * Inicia uma hora mais precisa com segundos e centesimos de segundos
     * @param hora - campo da hora
     * @param minutos - campo dos minutos
     * @param segundos - campo dos segundos
     * @param centesimos - campo dos centesimos
     */
    void inicializaHora(byte hora, byte minutos, byte segundos, byte centesimos) {
        this.hora = hora;
        this.minutos = minutos;
        this.segundos = segundos;
        this.centesimos = centesimos;
    }

    /**
     * O metodo faz uma analise dos limites de cada atributos para 
     * julgar se a hora e valida ou nao
     * @param hora - campo da hora
     * @param minutos - campo dos minutos
     * @param segundos - campo dos segundos
     * @param centesimos - campo dos centesimos
     * @return true caso seja valida, false caso contrario
     */
    boolean horaEhValida(byte hora, byte minutos, byte segundos, byte centesimos) {
        if(hora <= 24 && hora >= 00) {
            if(minutos <= 59 && minutos >= 00) {
                if(segundos <= 59 && segundos >= 0) {
                    if(centesimos <= 99 && centesimos >= 0) {
                        return true;
                    }
                }
                
            }
        }
        return false;
    }
    /**
     * O metodo imprime a hora caso ela seja valida
     */
    void mostraHora() {
        if(horaEhValida(hora, minutos, segundos, centesimos)) {
            System.out.printf("%02d:%02d:%02d::%02d\n", hora, minutos, segundos, centesimos);
        }
        else {
            System.out.println("Hora inválida");
        }
    }

}
