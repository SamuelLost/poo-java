
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
            //ContactStar star = new ContactStar(contc.getName(), contc.getFones(), value);
            ((ContactStar) contc).setStar(value);
            super.rmContact(name);
            super.addContact(((ContactStar) contc));
        } else {
            System.out.printf("fail: contato %s nao existe\n", name);
        }
    }
    //filtre em uma nova lista apenas os contatos que forem do tipo ContatoStar e que estão favoritados
    public List<Contact> getStarred() {
        List<Contact> aux = new ArrayList<>();
        for(Contact contato : super.getContacts()) {
            if(contato instanceof ContactStar && contato != null) {
                if(((ContactStar) contato).getStar()) {
                    aux.add(contato);
                }
            } 
        }

        return aux;

    }

    /* @Override
    public String toString() {
        return super.toString();
    } */
    
}
