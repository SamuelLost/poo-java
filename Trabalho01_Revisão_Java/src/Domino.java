import java.util.Scanner;
/*
Motivação
Deoclécio tem o passatempo de montar filas de dominós para derrubá-las depois.
Para fazer um efeito mais interessante, ele usa peças de dominó com tamanhos variados, sempre colocando
as menores peças no começo da fila.

Para ajudar nessa importante tarefa, Deo pediu sua ajuda para verificar se uma fila de dominós está
dentro do padrão, ou seja, se os tamanhos dos dominós estão ordenados de forma crescente.

Ação
Leia um vetor(array) de tamanho n (quantidade de dominós) , e diga se ele está ordenado 
de forma crescente.

Entrada e Saída
Entrada:

O número n ( 0 < n <= 50) de dominós.
A altura (inteira) de cada dominó.

Saída

"ok" caso  caso vetor esteja ordenado.
"precisa de ajuste" caso vetor esteja desordenado.
*/

public class Domino {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int vet[] = new int[n];
        boolean flag = true;

        for (int i = 0; i < vet.length; i++) {
            vet[i] = sc.nextInt();
        }
        for (int i = 0; i < vet.length; i++) {
            for (int j = i+1; j < vet.length; j++) {
                if(vet[i] > vet[j]) {
                    flag = false;
                    break;
                }
            }
        }

        System.out.println((flag) ? "ok":"precisa de ajuste");
        sc.close();
    }
}
