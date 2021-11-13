import java.util.Scanner;
/*
Descrição
Vários competidores disputaram uma competição interessante. Eles tinham duas pedras para lançar. 
Chamemos de pedra A e pedra B. Eles tinham que arremessar ambas as pedras
a pelo menos 10 metros de distância. Ganhava a competição, o competidor que arremessou as 
duas além da linha de 10 m o mais próximo possível uma da outra. Se alguma das
pedras tiver distância menor que 10 metros, o competidor estará desclassificado.

Ação
Faça um programa que retorne o número do vencedor do jogo. O primeiro jogador recebe o número 0.
Ganha a competição, o competidor que arremessar as duas além da linha de 10 m o mais próximo 
possível uma da outra; e que tiver o arremesso (A ou B) mais próximo de 10m.
Arremessos com distância menor que 10 metros do jogador são ignorados e o jogador já está 
desclassificado.

Entrada:
O número N de competidores.
Distância das pedras A e B de cada competidor.

Saida:
O número do competidor vitorioso. O primeiro competidor tem número 0. Caso haja empate, 
mostre o de menor número. Se ninguém ganhar o jogo, porque não conseguiram lançar
as bolas além dos 10 metros, imprima "sem ganhador".
*/
public class PedraLua {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int indice = -1;
        int ganhadorPontos = 0;

        for(int i = 0; i < n; i++) {
            int pedra1 = sc.nextInt();
            int pedra2 = sc.nextInt();
            if(pedra1 >= 10 && pedra2 >= 10) {
                int dif = Math.abs(pedra1 - pedra2);
                if(indice == -1 || ganhadorPontos > dif) {
                    indice = i;
                    ganhadorPontos = dif;
                }
            }
            /* else {
                indice++;
            } */
        }
        if(indice != -1) {
            System.out.println(indice);
        }
        else {
            System.out.println("sem ganhador");
        }

        sc.close();
    }
}
