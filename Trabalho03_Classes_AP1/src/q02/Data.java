package q02;

public class Data {

    private byte dia;
    private byte mes;
    private short ano;

    /**
     * Contrutor da classe Data
     * @param dia - campo referente ao dia
     * @param mes - campo referente ao mes
     * @param ano - campo referente ao ano
     */
    public Data(byte dia, byte mes, short ano) {
        if(dataEhValida(dia, mes, ano)) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            this.dia = 1;
            this.mes = 1;
            this.ano = 1;
        }
        
    }

    /**
     * Método que retorna o dia encapsulado
     * @return - byte representando o dia
     */
    public byte getDia() {
        return dia;
    }

    /**
     * Método que retorna o mês encapsulado
     * @return - byte representando o mês
     */
    public byte getMes() {
        return mes;
    }

    /**
     * Metódo que retorna o mês por extenso,
     * analisa mês por mês em um switch-case.
     * @return string contendo o mês em questão por extenso
     */
    public String getMesExtenso() {
        switch (this.mes) {
        case 1:
            return "Janeiro";
        case 2:
            return "Fereiro";
        case 3:
            return "Março";
        case 4:
            return "Abril";
        case 5:
            return "Maio";
        case 6:
            return "Junho";
        case 7:
            return "Julho";
        case 8:
            return "Agosto";
        case 9:
            return "Setembro";
        case 10:
            return "Outubro";
        case 11:
            return "Novembro";
        case 12:
            return "Dezembro";
        default:
            return "Mês inválido";
        }
    }

    /**
     * Método que retorna o ano encapsulado
     * @return - short representando o ano
     */
    public short getAno() {
        return ano;
    }

    /**
     * Metodo ehBissexto detecta se um ano tem 366 dias, um ano é dito bissexto
     * quando é divisivel por 4 ou 100 ou 400
     * 
     * @param ano - campo que corresponde ao ano de uma data
     * @return true caso o resto da divisao seja 0, false caso contrario
     */
    boolean isBissexto(short ano) {
        return ((ano % 4 == 0) || (ano % 100 == 0) || (ano % 400 == 0)) ? true : false;
    }

    /**
     * O metodo dataEhvalida recebe tres valores e faz uma verificação mais completa
     * com switch-case, levando em cosideracao anos bissextos, cada mes especifico
     * para determinar a validade de uma data.
     * 
     * @param dia - corresponde ao campo dia
     * @param mes - corresponde ao campo mes
     * @param ano - corresponde ao campo ano
     * @return true se a data for valida, false se não
     */
    boolean dataEhValida(byte dia, byte mes, short ano) {
        switch (mes) {
        case 1:
            if (dia <= 31 && dia >= 1) return true;
            break;
        case 2:
            if (isBissexto(ano)) {
                if (dia <= 29 && dia >= 1) return true;
            } else {
                if (dia <= 28 && dia >= 1) return true;
            }
            break;
        case 3:
            if (dia <= 31 && dia >= 1) return true;
            break;
        case 4:
            if (dia <= 30 && dia >= 1) return true;
            break;
        case 5:
            if (dia <= 31 && dia >= 1) return true;
            break;
        case 6:
            if (dia <= 30 && dia >= 1) return true;
            break;
        case 7:
            if (dia <= 31 && dia >= 1) return true;
            break;
        case 8:
            if (dia <= 31 && dia >= 1) return true;
            break;
        case 9:
            if (dia <= 30 && dia >= 1) return true;
            break;
        case 10:
            if (dia <= 31 && dia >= 1) return true;
            break;
        case 11:
            if (dia <= 30 && dia >= 1) return true;
            break;
        case 12:
            if (dia <= 31 && dia >= 1) return true;
            break;
        default:
            break;
        }
        return false;
    }

    /**
     * Método faz a comparação entre duas data, se uma é maior,
     * igual ou menor que a outra.
     * @param d - instância de outra data
     * @return - 0: caso as duas data sejam iguais
     *         - 1: caso a data correte seja maior que a passada como parâmetro
     *         - -1: caso a data correte seja menor que a passada como parâmetro
     */
    public int compara(Data d) {
        if((this.dia == d.dia) && (this.mes == d.mes) && (this.ano == d.ano)) {
            return 0;
        } else if(this.dia == d.dia) { //dias iguais
            if(this.mes == d.mes) { //meses iguais
                if(this.ano > d.ano) return 1; //ano corrente > ano parametro
                else return -1;
            } else if(this.mes > d.mes) { //mes corrente > mes parametro
                if(this.ano > d.ano || this.ano == d.ano) return 1;
                else return -1;
            } else { //mes corrente < mes parametro
                //Diferente do papel
                if(this.ano > d.ano || this.ano == d.ano) return 1;
                else return -1;
            }
            
        } else if(this.dia > d.dia) { //dia corrente > dia parametro
            if(this.mes == d.mes) { //meses iguais
                if(this.ano > d.ano || this.ano == d.ano) return 1; //ano corrente > ano parametro ou ambos iguais
                else return -1; ///ano corrente < ano parametro ou ambos iguais
            } else if(this.mes > d.mes) { //mes corrente > mes parametro
                if(this.ano > d.ano || this.ano == d.ano) return 1; //ano corrente > ano parametro ou ambos iguais
                else return -1; //ano corrente < ano parametro ou ambos iguais
            } else { // mes corrente < mes parametro
                if(this.ano > d.ano) return 1; // ano corrente > ano parametro
                else return -1; //ano corrente < ano parametro
            }
        } else { //dia corrente < dia parametro
            if(this.mes == d.mes) {
                if(this.ano > d.ano) return 1;
                else return -1;
            } else if(this.mes > d.mes) {
                if(this.ano > d.ano || this.ano == d.ano) return 1;
                else return -1;
            } else {
                if(this.ano > d.ano) return 1;
                else return -1;
            }
        }
        
    }

    /**
     * O método clona o objeto encapsulado a si próprio.
     */
    public Data clone(){
        Data c = new Data(this.dia, this.mes, this.ano);
        return c;
    }

    /**
     * Método toString() para fazer a impressão do objeto,
     * ou seja, ele vai fazer a impressão da data na tela
     * no seguinte formato: dd/mm/aaaa
     * @return - string do dia
     */
    public String toString() {
        return String.format("%02d", this.dia)
            + "/"
            + String.format("%02d", this.mes)
            + "/"
            + String.format("%04d", this.ano);
    }

    /**
     * O método toStringMesExtenso() imprime a data em 
     * um outro formato, agora o mês sai por extenso
     * chamando o método getDiaExtenso().
     * @return string no formato: dd de mesExtenso de aaaa
     */
    public String toStringMesExtenso() {
        return String.format("%02d", this.dia)
            + " de "
            + getMesExtenso()
            + " de "
            + String.format("%04d", this.ano);
    }

}
