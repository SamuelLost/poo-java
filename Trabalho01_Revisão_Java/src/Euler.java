import java.util.Scanner;
/*
Descrição
O número de Euler (2,71828182846...) pode ser aproximado pela série abaixo:
E = 1 + 1/1! + 1/2! + 1/3! + ⋯ + 1/N!

Faça uma função que retorna o fatorial de um número inteiro positivo n passado como parâmetro,
ou seja, retorna 1 * 2 * 3 * ... * (n-1) * n.

Chame esta função de `fatorial`.
O valor retornado, e a variável que armazena o fatorial, devem ser do tipo double, pois esta função
cresce muito rápido. Uma variável do tipo int só é capaz de armazenar até 12!.
Em seguida, crie uma função chamada `euler` que recebe um inteiro N e retorna o valor da série
E = 1 + 1/1! + 1/2! + 1/3! + ⋯ + 1/N!
A função euler deve chamar a função fatorial.
A função main lê o inteiro N e imprime o valor de euler(N).

Entrada:
1a linha: valor do inteiro positivo N

Saída:
Aproximação do número de Euler somando até 1/N!
*/
public class Euler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.printf("%.6f", euler(n));
        sc.close();
    }
    public static double fatorial(int n) {
        double fat = 1;
        for (int i = n-1; i >= 1; i--) {
            fat += fat*i;
        }
        return fat;
    }

    public static double euler(int n) {
        double euler = 1;
        for (int i = 1; i <= n; i++) {
            euler += 1/fatorial(i);
        }
        return euler;
    }
}
