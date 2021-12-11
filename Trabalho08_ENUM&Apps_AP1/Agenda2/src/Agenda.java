import java.util.ArrayList;
import java.util.List;

class Agenda {
    private List<Contact> contacts;
    public Agenda() {
        contacts = new ArrayList<>();
    }
    //retorna a posição do contato com esse nome no vetor ou -1 se não existir.
    private int findPosByName(String name) {
        for(Contact c : contacts) {
            if(c != null && c.getName().equals(name)) return contacts.indexOf(c);
        }
        return -1;
    }
    //retorna o objeto contato com esse nome ou null se não existir
    //utilize o método findPosByName
    public Contact findContact(String name) {
        if(findPosByName(name) != -1) {
            return contacts.get(findPosByName(name));
        }
        return null;
    }
    //se nenhum contato existir com esse nome, adicione
    //se ja existir, faça o merge adicionando os telefones
    //por fim, ordene a lista para ficar em ordem alfabética
    public void addContact(Contact contact) {
        if(findPosByName(contact.getName()) == -1) {
            this.contacts.add(contact);
        } else {
            for (Fone fone : contact.getFones()) {
                this.contacts.get(findPosByName(contact.getName())).addFone(fone);
            }
        }
        // O código para a ordenação da lista já está feito logo abaixo
        // esta é a última linha de código da função
        this.contacts.sort((Contact c1, Contact c2) -> (c1.getName().compareTo(c2.getName())));
    }
    //Utilize o método findPosByName
    public void rmContact(String name) {
        if(findPosByName(name) != -1) {
            contacts.remove(findPosByName(name));
            return;
        }
        System.out.println("fail: contato nao existe");
    }
    //Monte uma lista auxiliar procurando no .toString() de cada contato
    //se ele possui a substring procurada.
    //dica: reveja os métodos da classe String e procure algum que ajude aqui
    public List<Contact> search(String pattern) {
        List<Contact> aux = new ArrayList<>();
        for (Contact contact : contacts) {
            if(contact.toString().contains(pattern.toLowerCase())){
                aux.add(contact);
            }
        }
        return aux;
    }
    public List<Contact> getContacts() {
        return contacts;
    }
    public String toString() {
        String out = "";
        for(Contact c : contacts) {
            out += c.toString() + "\n";
        }
        return out;
    }
}