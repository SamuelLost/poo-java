import java.util.ArrayList;
import java.util.Scanner;

public class Solver {
    public static void main(String[] args) {
        ArrayList<Integer> vet = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        while (true) {
            String line = scan.nextLine();
            System.out.println("$" + line);
            String ui[] = line.split(" ");
            String cmd = ui[0];
            if (line.equals("end")) {
                break;
            } else if (cmd.equals("show")) {
                System.out.print("[ ");
                for (Integer value : vet)
                    System.out.print(value + " ");
                System.out.print("]\n");
            } else if (cmd.equals("rshow")) {
                // Para imprimir ao contrário, começa pelo final do
                // ArrayList diminuindo até zero, com isso imprime
                // o valor na posição i através o método get()
                System.out.print("[ ");
                for (int i = vet.size() - 1; i >= 0; i--) {
                    System.out.print(vet.get(i) + " ");
                }
                System.out.print("]\n");
            } else if (cmd.equals("add")) {
                for (int i = 1; i < ui.length; i++)
                    vet.add(Integer.parseInt(ui[i]));
            } else if (cmd.equals("find")) {
                // O comando find é para encontrar algum valor dentro do ArrayList.
                // Para isso o método indexOf passando o valor a ser encontrado.
                // Esse método retorna o índice do número caso tenha, se não ter o 
                // número, -1 é retornado.
                System.out.print("[ ");
                for (int i = 1; i < ui.length; i++) {
                    System.out.print(vet.indexOf(Integer.parseInt(ui[i])) + " ");
                }
                System.out.println("]");
            } else if (cmd.equals("get")) {
                // O comando get é usado para retornar um valor presente
                // no índice passado junto com o comando
                if((Integer.parseInt(ui[1]) > vet.size() - 1)) {
                    System.out.println("fail: indice nao existe");
                } else {
                    System.out.println(vet.get(Integer.parseInt(ui[1])));
                }
            } else if (cmd.equals("set")) {
                // O comando set é usado para o valor de uma posição
                // dentro da lista, o método set é usando passando o 
                // índice e o valor. Se o índice não existir, uma msg é exibida
                if((Integer.parseInt(ui[1]) > vet.size() - 1)) {
                    System.out.println("fail: indice nao existe");
                } else {
                    vet.set(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
                }
            } else if (cmd.equals("ins")) {
                // O comando ins é usado para inserir um valor
                // em determinada posição e deve respeitar os índices
                // presente, caso o índice seja maior que o último índice
                // o valor é inserido no final
                if ((Integer.parseInt(ui[1]) >= 0)) {
                    if ((Integer.parseInt(ui[1])) > (vet.size() - 1)) {
                        vet.add(Integer.parseInt(ui[2]));
                    } else {
                        vet.add(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
                    }
                }
            } else if (cmd.equals("rmi")) {
                /**
                 * O comando rmi é usado quando se quer remover um elemento
                 * de um determinado índice através do método remove(int ind).
                 * É feita uma verificação de índice antes de chamar o método,
                 * caso o índice seja inválido, uma mensagem é exibida.
                 */
                if(Integer.parseInt(ui[1]) < vet.size() && Integer.parseInt(ui[1]) >= 0) {
                    vet.remove(Integer.parseInt(ui[1]));
                } else {
                    System.out.println("fail");
                }
            } else if (cmd.equals("rma")) {
                /**
                 * O comando rma é chamado quando se quer remover toda ocorrência
                 * de um número dado. Para isso, existe o método removeAll(Collection).
                 * Porém, esse método aceita apenas uma coleção como parâmetro, para isso
                 * uma lista auxilia é criada e nela é adicionada o número passado
                 * junto com o comando "rma value". E assim, todas as ocorrências são
                 * removidas.
                 */
                ArrayList<Integer> aux = new ArrayList<>();
                aux.add(Integer.parseInt(ui[1]));
                vet.removeAll(aux);
            } else {
                System.out.print("fail: command not found\n");
            }
        }
        scan.close();
    }
}
