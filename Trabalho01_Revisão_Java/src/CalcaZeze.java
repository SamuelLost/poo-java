import java.util.Locale;
import java.util.Scanner;
/*
Motivação
Tem mulheres que gostam de roupa apertada. E homens sertanejos também. Mariana olhou em seu armário
e se vestiu para lacrar na festa do Luan Santana. Então pegou 5 de suas melhores calças jeans e decidiu
escolher a mais justa.

Ação 
Faça um programa que receba cinco valores inteiros e encontre o menor deles

Entrada e Saída
Entrada:

5 valores inteiros (entre 1 e 30), um por linha.
Saída:

O menor valor inteiro.
*/
public class CalcaZeze {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int[] medidas = new int[5];
        
        for (int i = 0; i < medidas.length; i++) {
            medidas[i] = sc.nextInt();
        }
    
        int menorMedida = 10000;
        for (int i = 0; i < medidas.length; i++) {
            if(medidas[i] < menorMedida) {
                menorMedida = medidas[i];
            } 
        }

        System.out.println(menorMedida);
        sc.close();
    }
}
