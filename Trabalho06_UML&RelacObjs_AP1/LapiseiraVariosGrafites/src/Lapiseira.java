import java.util.ArrayList;
import java.util.Locale;

class Lapiseira {
    private float calibre; //espessura que a lapiseira comporta
    private Grafite bico; // instancia de Grafite representando o bico
    private ArrayList<Grafite> tambor; //ArrayList dos grafites reservas
    private final int TAMANHO_MIN = 10; //Tamanho mínimo para o grafite

    /**
     * Construtor da classe
     * @param calibre - inteiro que representa qual
     * espessura a lapiseira suporta
     */
    Lapiseira(float calibre) {
        this.calibre = calibre;
        tambor = new ArrayList<>(); //inicializa o ArrayList de tambor do tipo Grafite
    }
    
    /**
     * Método toString() para imprimir na tela, no formato desejado.
     * Imprime o conteúdo presente no bico e no tambor, mesmo quando vazios.
     */
    public String toString() {
        Locale.setDefault(Locale.US);
        if(bico == null) {
            String out = "calibre: " + this.calibre + ", bico: []" + ", tambor: {";
            if(tambor != null) {
                for(Grafite a : tambor) {
                    out += a.toString();
                }
            }
            
            out += "}";
            return out;
        }

        String out = "calibre: " + this.calibre + ", bico: " + bico.toString()
            + ", tambor: {";
        if(tambor != null) {
            for(Grafite a : tambor) {
                out += a.toString();
            }
        }
        
        out += "}";
        return out;
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
        if((grafite.getCalibre() != this.calibre)) {
            System.out.println("fail: calibre incompativel");
            return false;
        }
        this.tambor.add(grafite);
        return true;
    }

    /**
     * Remove um grafite do bico da lapiseira, cria um
     * grafite auxilia, faz ele apontar para o 
     * grafite dentro da lapiseira e faz o grafite
     * da lapiseira apontar para null. E depois
     * retorna o grafite que foi removido.
     * @return - objeto grafite que foi removido
     */
    Grafite remover() {
        Grafite aux = bico;
        bico = null;
        return aux;
    }

    /**
     * O seguinte método é usado quando se quer puxar um 
     * grafite novo do tambor para o bico. Para esse método
     * funcionar é preciso o bico estar vazio, além de ter
     * algum grafite dentro do tambor. A primeira posição
     * do tambor é que vai para o bico. Caso os requisitos
     * não seja atendidos, mensagens de erro são impressas.
     * @return - true caso tenha sido um sucesso, false
     * caso contrário.
     */
    boolean puxar() {
        if(bico != null) {
            System.out.println("fail: ja existe grafite no bico");
            return false;
        } else {
            if(tambor.isEmpty()) {
                System.out.println("fail: nao existe grafite no tambor");
                return false;
            }
            bico = tambor.remove(0);
            return true;
        }
    }

    /**
     * Método para poder escrever usando a lapiseira e 
     * grafite. Primeiro checa se há algum grafite no bico, se
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
        if(this.bico == null) {
            System.out.println("fail: nao existe grafite no bico");
        } else {
            int desgaste = this.bico.desgastePorFolha();
            if(desgaste == this.bico.getTamanho()) {
                System.out.println("warning: grafite acabou");
            }
            else if(this.bico.getTamanho() <= TAMANHO_MIN) {
                System.out.println("warning: grafite acabou");
            }
            else if(desgaste < this.bico.getTamanho()) {
                bico.setTamanho(bico.getTamanho() - desgaste);
                if(bico.getTamanho() < TAMANHO_MIN) {
                    bico.setTamanho(TAMANHO_MIN);
                    System.out.println("fail: folha incompleta");
                    System.out.println("warning: grafite acabou");
                } else if(bico.getTamanho() == TAMANHO_MIN) {
                    System.out.println("warning: grafite acabou");
                }
            }
        }
    }
}