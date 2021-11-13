import java.util.Locale;
import java.util.Scanner;
/*
Motivação
Pedro e João foram no Silvio Santos. O programa era aquele que o Silvio mostrava um produto do 
mercantil e a pessoa que chegasse mais próximo do preço real ganhava.

João e Pedro são concorrentes. O objetivo do seu programa é informar quem ganhou a disputa.

O primeiro jogador informa o preço e o segundo jogador informa maior ou menor.
Quem vencer mais disputas ganha o jogo. Se o valor do produto for igual ao chute, 
ganha o primeiro concorrente.

Se ambos vencerem a mesma quantidade então acontece o empate. 

Se ambos tiverem igualmente próximos do preço então nenhum dos dois ganha a disputa.

Entrada:

linha 1: a quantidade de produtos (1 a 50)
linha 2: o valor dos produtos (0.01 até 1000.0)
linha 3: os chutes do Primeiro (float)
linha 4: as escolhas do segundo (m para menor, M para maior)


Saída:

"primeiro" ou "segundo" ou "empate"
*/
public class Mercantil {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int numProdutos = sc.nextInt();
        float priceProducts[] = new float[numProdutos];
        float chutesJog1[] = new float[numProdutos];
        char chutesJog2[] = new char[numProdutos];

        for (int i = 0; i < numProdutos; i++) {
            priceProducts[i] = sc.nextFloat();
        }
        for (int i = 0; i < numProdutos; i++) {
            chutesJog1[i] = sc.nextFloat();
        }
        for (int i = 0; i < numProdutos; i++) {
            chutesJog2[i] = sc.next().charAt(0);
        }

        int pontJog1 = 0, pontJog2 = 0;

        for (int i = 0; i < numProdutos; i++) {
            if ((chutesJog1[i] > priceProducts[i]) && (chutesJog2[i] == 'm')) {
                pontJog2++;
            } else if ((chutesJog1[i] < priceProducts[i]) && (chutesJog2[i] == 'M')) {
                pontJog2++;
            } else {
                pontJog1++;
            }
        }

        if(pontJog1 > pontJog2) {
            System.out.println("primeiro");
        }
        else if(pontJog1 < pontJog2) {
            System.out.println("segundo");
        }
        else {
            System.out.println("empate");
        }
        sc.close();
    }
}
