import java.util.ArrayList;

public class Topic {
  // Atributos
  private ArrayList<Pass> prioritySeats;
  private ArrayList<Pass> normalSeats;

  /**
   * Método construtor
   * 
   * @param capacity    - quantidade de assentos normais
   * @param qtdPriority - quantidade de assentos prioritários
   */
  public Topic(int capacity, int qtdPriority) {
    this.prioritySeats = new ArrayList<>(qtdPriority);
    this.normalSeats = new ArrayList<>(capacity - qtdPriority);
    for (int i = 0; i < capacity - qtdPriority; i++) {
      this.normalSeats.add(null);
    }
    for (int i = 0; i < qtdPriority; i++) {
      this.prioritySeats.add(null);
    }
  }

  // return the first free pos or -1
  /**
   * Método que procura o primeiro assento livre
   * 
   * @param list - lista de assentos
   * @return - posição do primeiro assento livre
   */
  private int findFirstFreePos(ArrayList<Pass> list) {
    int index = -1;
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) == null) {
        index = i;
        break;
      }
    }
    return index;
  }

  // search in list using name and return position or return -1
  /**
   * Médodo que procura um passageiro pelo nome na lista
   * 
   * @param name - nome do passageiro
   * @param list - lista de assentos
   * @return - posição do passageiro
   */
  private int findByName(String name, ArrayList<Pass> list) {
    int index = -1;
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) != null && list.get(i).getName().equals(name)) {
        index = i;
      }
    }
    return index;
  }

  // use the findFirstFreePos to search a free position
  // if exists, insert the pass and return true
  // else return false
  /**
   * Método que insere um passageiro na lista de assentos
   * 
   * @param pass - passageiro
   * @param list - lista de assentos
   * @return - true se o passageiro foi inserido, false caso contrário
   */
  private boolean insertOnList(Pass pass, ArrayList<Pass> list) {
    int posFree = this.findFirstFreePos(list);
    if (posFree != -1) {
      list.set(posFree, pass);
      return true;
    } else {
      return false;
    }
  }

  // use the findByName method to locate pos in list, if found, remore the person
  // setting the pos location to null
  /**
   * Método que remove um passageiro da lista de assentos
   * 
   * @param name - nome do passageiro
   * @param list - lista de assentos
   * @return - true se o passageiro foi removido, false caso contrário
   */
  private boolean removeFromList(String name, ArrayList<Pass> list) {
    int posPass = findByName(name, list);

    if (posPass != -1) {
      list.set(posPass, null);
      return true;
    } else {
      return false;
    }
  }

  // use findByName to test if the pass is already in the topic
  // use the insertOnList method to insert in the right list based in
  // the pass.isPriority result
  /**
   * Método que insere um passageiro
   * 
   * @param pass - passageiro
   * @return - true se o passageiro foi inserido, false caso contrário
   */
  public boolean insert(Pass pass) {
    int posPassNormal = findByName(pass.getName(), this.normalSeats);
    int posPassPriority = findByName(pass.getName(), this.prioritySeats);

    if (posPassNormal != -1 || posPassPriority != -1) {
      System.out.println("fail: pass ja esta na topic");
      return false;
    }

    // This pass is priority
    if (pass.isPriority()) {
      // normal seats and priority seats are full
      if (!this.insertOnList(pass, this.prioritySeats) && !this.insertOnList(pass, this.normalSeats)) {
        System.out.println("fail: topic lotada");
        return false;
      }

      // This pass is not priority
    } else {
      // normal seats and priority seats are full
      if (!this.insertOnList(pass, this.normalSeats) && !this.insertOnList(pass, this.prioritySeats)) {
        System.out.println("fail: topic lotada");
        return false;
      }
    }
    return true;
  }

  // use the removeFromList method to try to remove from both lists
  /**
   * Método que remove um passageiro
   * 
   * @param name - nome do passageiro
   * @return - true se o passageiro foi removido, false caso contrário
   */
  public boolean remove(String name) {
    if (this.removeFromList(name, this.normalSeats) || this.removeFromList(name, this.prioritySeats)) {
      return true;
    } else {
      System.out.println("fail: pass nao esta na topic");
      return false;
    }
  }

  public String toString() {
    String state = "";
    state += "[";
    // priority
    for (Pass pass : this.prioritySeats) {
      if (pass == null) {
        state += "@ ";
      } else {
        state += "@" + pass.toString() + " ";
      }
    }

    // normal
    for (Pass pass : this.normalSeats) {
      if (pass == null) {
        state += "= ";
      } else {
        state += "=" + pass.toString() + " ";
      }
    }

    state += "]";

    return state;
  }
}