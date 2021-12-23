package contact;
import java.util.List;
import fone.Fone;


public class ContactStar extends Contact {
    private boolean star;
    //contrutor default
    public ContactStar(String name, List<Fone> fones, boolean star) {
        super(name, fones);
        setStar(star);
    }
    //muda o prefixo e o valor de star
    public void setStar(boolean value) {
        super.prefix = (value) ? "@" : "-";
        star = value;
    }
    public boolean getStar() {
        return star;
    }
}
