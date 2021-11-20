import java.util.ArrayList;
import java.util.Locale;

class Lapiseira {
    private float calibre; //espessura que a lapiseira comporta
    private Grafite bico; // instancia de Grafite representando o bico
    private ArrayList<Grafite> tambor; //ArrayList dos grafites reservas
    private final int TAMANHO_MIN = 10;
    Lapiseira(float calibre) {
        this.calibre = calibre;
        tambor = new ArrayList<>();
    }
    
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
    Grafite remover() {
        Grafite aux = bico;
        bico = null;
        return aux;
    }
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