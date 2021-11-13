import java.util.Scanner;
/*
Motivação
A brincadeira preferida de Maurício é pegar os copos da sua mãe e fazer uma torre
no formato de um triangulo isósceles.

Um dia, sua mãe entrou na cozinha e viu aquela torre de base 5 utilizando 15 copos.
Imediatamente uma chinela voou pela casa acertando em cheio a cabeça de Maurício,
é claro, pra aprender a não fazer torres com copos de vidro.

Ação
Faça um programa que dado um numero N inteiro (0<N<50) mostre na tela um triangulo
isósceles formado por apenas N e com altura igual a N.

Entrada:
    Inteiro N(0<N<50)
Saída:

Um triângulo isósceles formado por apenas pelo numero N e com altura igual a N.
*/
public class QuebradorCopos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            pontos(num - i - 1); // Imprime os ponto do lado esquerdo
            numeros(num, i + 1); // Imprime os números
            pontos(num - 1 - i); // Imprime os ponto do lado direito
            System.out.println();
        }
        sc.close();
    }

    public static void pontos(int qntd) {
        for (int i = 0; i < qntd; i++) {
            System.out.print(".");
        }
    } 

    public static void numeros(int valor, int qntd) {
        System.out.printf("%d", valor);
        for (int i = 0; i < (qntd - 1); i++) {
            System.out.printf(".%d", valor);
        }
    }
}
