package q01.e;

class Data {
    
    byte dia;
    byte mes;
    short ano;

    /**
     * Inicializa os atributos da classe com os parâmetros passados
     * 
     * @param dia - corresponde ao campo dia
     * @param mes - corresponde ao campo mes
     * @param ano - corresponde ao campo ano
     */
    void inicializaData(byte dia, byte mes, short ano) {
        if (dataEhValida(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            this.dia = 0;
            this.mes = 0;
            this.ano = 0;
        }
    }

    /**
     * O metodo dataEhvalida recebe tres valores e faz uma verificação
     * mais completa com switch-case, levando em cosideracao anos bissextos,
     * cada mes especifico para determinar a validade de uma data.
     * 
     * @param dia - corresponde ao campo dia
     * @param mes - corresponde ao campo mes
     * @param ano - corresponde ao campo ano
     * @return true se a data for valida, false se não
     */
    boolean dataEhValida(byte dia, byte mes, short ano) {
        switch (mes) {
            case 1:
                if (dia <= 31 && dia >= 1) {
                    return true;
                }
                break;
            case 2:
                if (ehBissexto(ano)) {
                    if (dia <= 29 && dia >= 1)
                        return true;
                }
                else {
                    if (dia <= 28 && dia >= 1)
                        return true;
                }
                break;
            case 3:
                if (dia <= 31 && dia >= 1) {
                    return true;
                }
                break;
            case 4:
                if (dia <= 30 && dia >= 1) {
                    return true;
                }
                break;
            case 5:
                if (dia <= 31 && dia >= 1) {
                    return true;
                }
                break;
            case 6:
                if (dia <= 30 && dia >= 1) {
                    return true;
                }
                break;
            case 7:
                if (dia <= 31 && dia >= 1) {
                    return true;
                }
                break;
            case 8:
                if (dia <= 31 && dia >= 1) {
                    return true;
                }
                break;
            case 9:
                if (dia <= 30 && dia >= 1) {
                    return true;
                }
                break;
            case 10:
                if (dia <= 31 && dia >= 1) {
                    return true;
                }
                break;
            case 11:
                if (dia <= 30 && dia >= 1) {
                    return true;
                }
                break;
            case 12:
                if (dia <= 31 && dia >= 1) {
                    return true;
                }
                break;
            default:
                break;
        }
        return false;
    }

    /**
     * O método ehIgual faz uma simples comparação se as datas representadas pela
     * classe e pela instancia que foi passada são iguais
     * 
     * @param data - instancia da propria classe Data
     * @return true se for igual, false caso contrario
     */
    boolean ehIgual(Data data) {
        if ((dia == data.dia) && (mes == data.mes) && (ano == data.ano)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo ehBissexto detecta se um ano tem 366 dias, 
     * um ano é dito bissexto quando é divisivel por 4 ou 100 ou 400
     * @param ano - campo que corresponde ao ano de uma data
     * @return true caso o resto da divisao seja 0, false caso contrario
     */
    boolean ehBissexto(short ano) {
        return ((ano % 4 == 0) || (ano % 100 == 0) || (ano % 400 == 0)) ? true : false;
    }

    /**
     * O metodo apenas imprime a data na tela caso a data seja valida, se nao for
     * então uma mensagem de "Data invalida" sera impressa
     */
    void mostraData() {
        if (dataEhValida(dia, mes, ano)) {
            System.out.printf("%02d/%02d/%04d\n", dia, mes, ano);
        } else {
            System.out.println("Data inválida");
        }
    }
}
