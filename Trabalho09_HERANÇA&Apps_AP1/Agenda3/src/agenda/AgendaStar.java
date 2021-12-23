
package agenda;
import java.util.ArrayList;
import java.util.List;

import contact.Contact;
import contact.ContactStar;
public class AgendaStar extends Agenda {
    //SE o contato existir e for do tipo ContatoStar altere o atributo star dele
    /**
     * Método que favorita o contato caso ele já exista e seja instância de
     * ContatoStar. Usando o método findContact(name) para encontrar o contato
     * pelo nome. Se existir, altera o valor da variável star.
     * @param name - nome do contato
     * @param value - true para star, false para unstar
     */
    public void star(String name, boolean value) {
        Contact contc = super.findContact(name);
        if((contc != null) && (contc instanceof ContactStar)) {
            ((ContactStar) contc).setStar(value);
        } else {
            System.out.printf("fail: contato %s nao existe\n", name);
        }
    }

    //filtre em uma nova lista apenas os contatos que forem do tipo ContatoStar e que estão favoritados
    /**
     * O método cria uma lista auxilia de modo que nela seja adicionado
     * apenas os contatos que foram marcados com star. Para isso, é preciso
     * percorrer a lista de contatos através do FOR-EACH pegando o método
     * getContacts() da classe pai (Agenda). Além disso é preciso verificar
     * se o contato é instancia de ContactStar e se o atributo star é true, 
     * caso respeite isso o contato é adicionado na lista auxiliar e no final
     * do método a lista é retornada.
     * @return lista com os contatos star
     */
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
}