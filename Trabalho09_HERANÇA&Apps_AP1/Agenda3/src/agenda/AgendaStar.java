
package agenda;
import java.util.ArrayList;
import java.util.List;

import contact.Contact;
import contact.ContactStar;
public class AgendaStar extends Agenda {
    //SE o contato existir e for do tipo ContatoStar altere o atributo star dele
    public void star(String name, boolean value) {
        if(findContact(name) != null) {
            Contact contc = super.findContact(name);
            ContactStar star = new ContactStar(contc.getName(), contc.getFones(), value);
            super.rmContact(name);
            super.addContact(star);
        } else {
            System.out.println("fail: contato nao existe");
        }
    }
    //filtre em uma nova lista apenas os contatos que forem do tipo ContatoStar e que estão favoritados
    public List<Contact> getStarred() {
        return new ArrayList<Contact>();
    }

    @Override
    public String toString() {
        return "";
    }
    
}
