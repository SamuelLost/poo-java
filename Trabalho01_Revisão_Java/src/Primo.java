import java.util.Scanner;
/*
Descrição
Faça uma função chamada primo que recebe um inteiro positivo n e retorna true (verdadeiro) 
se n é primo, ou false (falso) caso contrário. Um número inteiro é primo quando é 
divisível apenas por 1 e por ele mesmo.

Uma estratégia simples para testar se um número n é primo consiste em procurar um 
divisor de n do número 2 até o número n−1. Se algum valor nesta faixa é divisor do n, 
então n não é primo. Caso contrário, n é primo.

Note que a função pode retornar true assim que encontrar um divisor de n entre 2 e n−1.
Ou seja, não é necessário retornar apenas no final da função.

Na função main, leia dois inteiros positivos A e B, com A≤B, e imprima todos os primos de A até B.
Portanto, use a função primo dentro da função main.

Entrada:
* 1a linha: valor do inteiro positivo A.
* 2a linha: valor do inteiro positivo B (com A≤B).

Saída:
* Todos os primos de A até B (um por linha).
*/
public class Primo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        for (int i = a; i <= b; i++) {
            if(primo(i))
                System.out.println(i);
        }
        sc.close();
    }
    
    public static boolean primo(int n) {

        for (int i = 2; i < n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
