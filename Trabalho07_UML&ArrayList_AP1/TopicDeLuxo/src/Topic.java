import java.util.ArrayList;

public class Topic {
    private ArrayList<Pass> prioritySeats;
    private ArrayList<Pass> normalSeats;
    public Topic(int capacity, int qtdPriority) {

        prioritySeats = new ArrayList<>();
        for (int i = 0; i < qtdPriority; i++) {
            prioritySeats.add(null);
        }

        normalSeats = new ArrayList<>();
        for (int i = 0; i < (capacity-qtdPriority); i++) {
            normalSeats.add(null);
        }
    }
    //return the first free pos or -1
    private int findFirstFreePos(ArrayList<Pass> list) {
        for (Pass p : list) {
            if(p == null) return list.indexOf(p);
            
        }
        return -1;
    }
    //search in list using name and return position or return -1
    private int findByName(String name, ArrayList<Pass> list) {
        for (Pass p : list) {
            if(p != null && p.getName().equals(name)) return list.indexOf(p);
        }
        return -1;
    }
    //use the findFirstFreePos to search a free position
    //if exists, insert the pass and return true
    //else return false
    private boolean insertOnList(Pass pass, ArrayList<Pass> list) {
        if(findFirstFreePos(list) != -1) {
            list.set(findFirstFreePos(list), pass);
            return true;
        } else {
            return false;
        }
        

    }
    //use the findByName method to locate pos in list, if found, remore the person
    //setting the pos location to null
    private boolean removeFromList(String name, ArrayList<Pass> list) {
        if(findByName(name, list) == -1) {
            return false;
        }
        list.set(findByName(name, list), null);
        return true;
    }
    //use findByName to test if the pass is already in the topic
    //use the insertOnList method to insert in the right list based in
    //the pass.isPriority result

    public boolean insert(Pass pass) {
        if((findByName(pass.getName(), normalSeats) != -1) || (findByName(pass.getName(), prioritySeats) != -1)) {
            System.out.println("fail: pass ja esta na topic");
            return false;
        }
        if(pass.isPriority()) {
            if(insertOnList(pass, prioritySeats)) {
                return true;
            }
            else if(insertOnList(pass, normalSeats)){
                
                return true;
            }
            
        } else {
            if(insertOnList(pass, normalSeats)) {
                return true;
            }
            else if(insertOnList(pass, prioritySeats)){
                return true;
            }
        }
        System.out.println("fail: topic lotada");
        return false;
        /* if(pass.isPriority()) {
            if(findFirstFreePos(prioritySeats) > 0) {
                prioritySeats.set(findFirstFreePos(prioritySeats), pass);
                return true;
            } else {
                normalSeats.set(findFirstFreePos(normalSeats), pass);
                return true;
            }
        } else {
            if(findFirstFreePos(normalSeats) > 0) {
                normalSeats.set(findFirstFreePos(normalSeats), pass)
                return true;
            } else {
                prioritySeats.set(findFirstFreePos(prioritySeats), pass);
                return true;
            }
        }
        System.out.println("fail: topic lotada");
		return false; */
    }
    //use the removeFromList method to try to remove from both lists
    public boolean remove(String name) {
        if(removeFromList(name, prioritySeats)) {
            return true;
        } else if(removeFromList(name, normalSeats)){
            
            return true;
        }
        System.out.println("fail: pass nao esta na topic");
        return false;
    }
    public String toString() {
        String out = "[";
        for(Pass aux : prioritySeats) {
            if(aux != null) {
                out += "@" + aux.toString() + " ";
            } else {
                out += "@ ";
            }
        }

        for(Pass aux : normalSeats) {
            if(aux != null) {
                out += "=" + aux.toString() + " ";
            } else {
                out += "= ";
            }
        }
        out += "]";
        return out;
    }
}