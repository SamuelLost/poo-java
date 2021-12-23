package agenda;
import java.util.ArrayList;
import java.util.List;

import contact.Contact;
import fone.Fone;
public class Agenda {
    private List<Contact> contacts; //lista de contatos
    //Contrutor da classe
    public Agenda() {
        contacts = new ArrayList<>();
    }

    //retorna a posição do contato com esse nome no vetor ou -1 se não existir.
    /**
     * Método que faz a busca na lista de contatos pelo nome do contato.
     * @param name - nome a ser procurado
     * @return - índice do contato caso tenha sido encontrado, -1 caso contrário
     */
    private int findPosByName(String name) {
        for(Contact c : contacts) {
            if(c != null && c.getName().equals(name)) return contacts.indexOf(c);
        }
        return -1;
    }

    //retorna o objeto contato com esse nome ou null se não existir
    //utilize o método findPosByName
    /**
     * Método para procurar o contato pelo nome, ao invés da posição
     * o método retorna o contato.
     * @param name - nome a ser procurado
     * @return - o objeto contato ou null caso não esteja presente
     */
    public Contact findContact(String name) {
        if(findPosByName(name) != -1) {
            return contacts.get(findPosByName(name));
        }
        return null;
    }

    //se nenhum contato existir com esse nome, adicione
    //se ja existir, faça o merge adicionando os telefones
    //por fim, ordene a lista para ficar em ordem alfabética
    /**
     * Adicionando um contato a lista de contatos, se algum
     * contato for encontrado com o mesmo nome, apenas o novo
     * número é adicionado. Usa o método add() de ArrayList ou
     * o metodo addFones() caso já tenha o contato.
     * @param contact - contato a ser adicionado
     */
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
    /**
     * O método em questão utiliza o método para a achar a posição
     * pelo nome do contato, ao encontrar esse contato é removido.
     * @param name - nome do contato
     */
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
    /**
     * O método a seguir faz uma busca dentro da lista de contatos a partir
     * de uma substring, a informação basta conter essa substring para ser
     * encontrada, não é necessário ser totalmente igual.
     * Usando os métodos toString() e contains() de String.
     * @param pattern - substring
     * @return - uma lista dos resultados encontrados.
     */
    public List<Contact> search(String pattern) {
        List<Contact> aux = new ArrayList<>();
        for (Contact contact : contacts) {
            if(contact.toString().contains(pattern.toLowerCase())){
                aux.add(contact);
            }
        }
        return aux;
    }

    //GET
    public List<Contact> getContacts() {
        return contacts;
    }

    //Formatando a string de saída
    @Override
    public String toString() {
        String out = "";
        for(Contact c : contacts) {
            out += c.toString() + "\n";
        }
        return out.trim();
    }
}
