import java.util.Scanner;
/*Motivação
O dono do zoológico quer a lista de todas as espécies de animais
que existem no zoológico. Para isso, ele te deu uma lista de todos os animais.

Ele quer que você faça um programa que retorne a quantidade de espécies diferentes.
Considere que um número representa uma espécie.

Ação
Faça um programa para calcular a quantidade de números diferentes inseridos, dado um vetor e seu tamanho como entrada.

Entrada e Saída
Entrada:

Inteiro com a quantidade de elementos do vetor (1 até 50).
Elementos inteiros do vetor.
Saída:

Quantidade de espécies.
*/
public class Zoo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int animais[] = new int[n];
        int count = 0;
        for (int i = 0; i < animais.length; i++) {
            animais[i] = sc.nextInt();
        }
        for (int i = 0; i < animais.length; i++) {
            for (int j = i + 1; j < animais.length; j++) {

                if (animais[i] == animais[j]) {
                    animais[j] = -10;
                }
                
            }
        }

        for (int i = 0; i < animais.length; i++) {
            if(animais[i] != -10){
                count++;
            }
        }
        System.out.println(count);

        sc.close();
    }
}
