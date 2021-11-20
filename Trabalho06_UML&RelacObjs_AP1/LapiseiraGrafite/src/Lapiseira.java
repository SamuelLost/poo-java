import java.util.Locale;

class Lapiseira {
    
    private float calibre; //espessura do grafite
    private Grafite grafite; //instância da Classe Grafite
    private final int TAMANHO_MIN = 10;

    /**
     * Construtor da classe lapiseira
     * @param calibre - espessura aceita pela lapiseira
     * o grafite começa vazio
     */
    Lapiseira(float calibre) {
        this.calibre = calibre;
        this.grafite = null;
    }

    /**
     * Método booleano para fazer a inserção de um grafite
     * na lapiseira. A lapiseira não pode estar ocupada por
     * outro grafite e o calibre da lapiseira e o grafite a ser
     * inserido devem corresponder, caso contrário não é 
     * possível inserir.
     * @param grafite - instância da classe Grafite
     * @return true caso a inserção seja feita com sucesso, false 
     * caso contrário.
     */
    boolean inserir(Grafite grafite) {
        if(this.grafite != null) {
            System.out.println("fail: ja existe grafite");
            return false;
        }
        if((grafite.getCalibre() != this.calibre)) {
            System.out.println("fail: calibre incompativel");
            return false;
        }
        this.grafite = grafite;
        return true;
    }

    /**
     * Remove um grafite da lapiseira, cria um
     * grafite auxilia, faz ele apontar para o 
     * grafite dentro da lapiseira e faz o grafite
     * da lapiseira apontar para null. E depois
     * retorna o grafite que foi removido.
     * @return - objeto grafite que foi removido
     */
    Grafite remover() {
        Grafite aux = this.grafite;
        this.grafite = null;
        return aux;
    }

    /**
     * Método para poder escrever usando a lapiseira e 
     * grafite. Primeiro checa se tem algum grafite, se
     * não houver, uma mensagem é impressa. 
     * Caso tenha, é necessário calcular o desgaste do
     * gratife, de acordo com sua dureza. Se o desgaste
     * for igual ao tamanho do grafite, uma mensagem é impressa 
     * e nada é escrito. Caso o tamanho seja menor que o tamanho
     * mínimo (10) também não escreve e uma mensagem é impressa.
     * Se o desgaste for menor que o tamanho, escreve e o tamanho
     * é diminuído, porém é checado se o tamanho ficou inferior
     * ao mínimo, caso tenha ficado, o tamnho é setado a 10
     * e mensagens são impressas, caso tenha ficado igual outra
     * mensagem é impressa, caso tenha ficado maior, nada é impresso
     * apenas o tamanho é reduzido.
     */
    void escrever() {
        if(this.grafite == null) {
            System.out.println("warning: grafite acabou");
        } else {
            int desgaste = this.grafite.desgastePorFolha();
            if(desgaste == this.grafite.getTamanho()) {
                System.out.println("warning: grafite acabou");
            }
            else if(this.grafite.getTamanho() <= TAMANHO_MIN) {
                System.out.println("warning: grafite acabou");
            }
            else if(desgaste < this.grafite.getTamanho()) {
                grafite.setTamanho(grafite.getTamanho() - desgaste);
                if(grafite.getTamanho() < TAMANHO_MIN) {
                    grafite.setTamanho(TAMANHO_MIN);
                    System.out.println("fail: folha incompleta");
                    System.out.println("warning: grafite acabou");
                } else if(grafite.getTamanho() == TAMANHO_MIN) {
                    System.out.println("warning: grafite acabou");
                }
            }
        }
        
    }

    /**
     * Método toString() padrão para imprimir no formato desejado
     */
    public String toString() {
        Locale.setDefault(Locale.US);
        if(grafite == null) {
            return String.format("calibre: %.1f, grafite: null", this.calibre);
        } else {
            return String.format("calibre: %.1f, %s", this.calibre, this.grafite.toString());
        }
    }
}