package contact;
import java.util.List;
import fone.Fone;

public class ContactStar extends Contact {
    private boolean star;
    //contrutor default
    /**
     * Construtor da classe ContactStar que chamar o construtor
     * da classe pai Contact
     * @param name - nome do contato
     * @param fones - telefones do contato
     * @param star - se o contato é favorito ou não
     */
    public ContactStar(String name, List<Fone> fones, boolean star) {
        super(name, fones);
        setStar(star);
    }
    
    //muda o prefixo e o valor de star
    /**
     * Método para setar a variável booleana star e 
     * mudar o prefixo da classe pai
     * @param value - true se for star, false se não
     */
    public void setStar(boolean value) {
        super.prefix = (value) ? "@" : "-";
        star = value;
    }

    /**
     * GET
     * @return true ou false
     */
    public boolean getStar() {
        return star;
    }
}
