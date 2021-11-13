package q01.d;

class Data {
    
    byte dia;
    byte mes;
    short ano;

    /**
     * Inicializa os atributos da classe com os parâmetros passados
     * @param dia - corresponde ao campo dia
     * @param mes - corresponde ao campo mes
     * @param ano - corresponde ao campo ano
     */
    void inicializaData(byte dia, byte mes, short ano) {
        if(dataEhValida(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        }
        else {
            this.dia = 0;
            this.mes = 0;
            this.ano = 0;
        }
    }

    /**
     * O metodo dataEhvalida recebe tres valores 
     * e faz a verificação genérica se os dados
     * correspondem com uma data valida
     * @param dia - corresponde ao campo dia
     * @param mes - corresponde ao campo mes
     * @param ano - corresponde ao campo ano
     * @return true se a data for valida, false se não
     */
    boolean dataEhValida(byte dia, byte mes, short ano) {
        if(dia >= 1 && dia <= 31) {
            if(mes >= 1 && mes <= 12) {
                if(ano > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * O método ehIgual faz uma simples comparação se 
     * as datas representadas pela classe e pela instancia que foi
     * passada são iguais
     * @param data - instancia da propria classe Data
     * @return true se for igual, false caso contrario
     */
    boolean ehIgual(Data data) {
        if((dia == data.dia) && (mes == data.mes) && (ano == data.ano)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * O metodo apenas imprime a data na tela caso a data seja valida,
     * se nao for então uma mensagem de "Data invalida" sera impressa
     */
    void mostraData() {
        if(dataEhValida(dia, mes, ano)) {
            System.out.printf("%02d/%02d/%04d\n", dia, mes, ano);
        }
        else {
            System.out.println("Data inválida");
        }
    }
}
