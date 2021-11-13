import java.util.Scanner;
/*
Motivação
Você ganhou uma bolsa de auxílio pra organizar a fila do RU.
Então teve uma brilhante ideia para organizar as filas.
Ao invés de uma única fila você vai fazer uma para os professores e STAs e uma para alunos.

Ação
Imprima todos os números ímpares na ordem em que foram inseridos na primeira linha, 
e imprima todos os pares na segunda linha de forma análoga.

Entrada e Saída
Entrada:
Quantidade N de pessoas na fila.
N valores inteiros onde um número ímpar representa um aluno e um par representa um servidor.

Saída:

Os números ímpares na ordem que aparecem na entrada.
Os números pares na ordem que aparecem na entrada.
*/
public class FilaRU {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int numeros[] = new int[n];
        int par[] = new int[n];
        int impar[] = new int[n];
        int j = 0, k = 0;
        for(int i = 0; i < n; i++) {
            numeros[i] = sc.nextInt();
            if(numeros[i] % 2 == 0){
                par[k++] = numeros[i];
            }
            else {
                impar[j++] = numeros[i];
            }
        }
        System.out.print("[ ");
        for (int i = 0; i < impar.length; i++) {
            if(impar[i] != 0)
                System.out.printf("%d ", impar[i]);
        }
        System.out.println("]");

        System.out.print("[ ");
        for (int i = 0; i < par.length; i++) {
            if(par[i] != 0)
                System.out.printf("%d ", par[i]);
        }
        System.out.println("]");
        sc.close();
    }
}
