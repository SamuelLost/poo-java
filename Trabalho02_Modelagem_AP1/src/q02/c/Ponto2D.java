package q02.c;

import java.util.Locale;

class Ponto2D {
    double x;
    double y;

    /**
     * Metodo para iniciar os atributos da classe 
     * com os parametos passados
     * @param x - numero que representa um ponto no eixo x
     * @param y - numero que representa um ponto no eixo y
     */
    void inicializaPontos(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Imprime o par ordenados dos pontos
     */
    void mostraPontos() {
        Locale.setDefault(Locale.US);
        System.out.printf("(%.1f,%.1f)\n", x, y);
    }

    /**
     * Método que faz a análise dos pontos em termos de sinal
     * para determinar em qual quadrante ele está 
     */
    void quadrante() {
        if ((x == 0) & (y == 0)) {
			System.out.println("Origem");
		}
		else if ((x > 0) & (y > 0)) {
			System.out.println("1º quadrante");
		}
		else if ((x < 0) & (y > 0)) {
			System.out.println("2º quadrante");
		}
		else if ((x < 0) & (y < 0)) {
			System.out.println("3º quadrante");
		}
		else if ((x > 0) & (y < 0)) {
			System.out.println("4º quadrante");
		}
        else if (y == 0) {
			System.out.println("Eixo X");
		}
		else if (x == 0) {
			System.out.println("Eixo Y");
		}
    }

}
