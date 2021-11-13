package q04.c;

import java.util.Locale;

public class LivroDeBiblioteca {

    Livro livro;
    int qntdDisponivel; //Qnts livros tem na biblioteca
    double precoAluguel; //Preço do aluguel
    int codigoDoLivro;
    int diasAluguel = 0;
    double custoDoAluguel = 0;
    String nomeDoLocador;
    int qntsEmprestados = 0; //Qnts livros tem emprestado

    /**
     * Metodo para fazer a inicialização da classe e atributos
     * @param book - um livro da Classe Livro
     * @param qntsLivros - quantos livros a biblioteca terá
     * @param preco - o preço de aluguel do livro
     * @param codigo - código do livro
     */
    void inicializarLivroDeBiblioteca(Livro book, int qntsLivros, double preco, int codigo) {
        livro = book;
        qntdDisponivel = qntsLivros;
        precoAluguel = preco;
        codigoDoLivro = codigo;
    }
    /**
     * Análise para saber se tem unidades disponiveis do livro
     * na biblioteca
     * @return true se tiver, false caso contrario
     */
    boolean estaDisponivel() {
        return (qntdDisponivel > 0) ? true:false;
    }

    /**
     * Metodo que realiza a locação de um livro, informando quantos dias que
     * será locação e o nome do locador
     * @param livro - uma instancia da propria classe
     * @param dias - quantos dias a pessoa quer alugar
     * @param nome - nome do locador
     */
    void aluguelDeLivro(LivroDeBiblioteca livro, int dias, String nome) {
        if(estaDisponivel()) {
            diasAluguel = dias;
            nomeDoLocador = nome;
            qntsEmprestados++;
            qntdDisponivel -= 1; 
            custoDoAluguel = precoAluguel * diasAluguel;
            System.out.printf("Custo do aluguel: R$%.2f\n", custoDoAluguel);
            System.out.println("Aluguel realizado com sucesso");
        }
        else {
            System.out.println("Todos os exemplares já estão alugados");
        }
    }

    /**
     * O metodo imprime informações sobre o livro que foi locado
     * @param livro - instancia da propria classe
     */
    void informacoesDoAluguel(LivroDeBiblioteca livro) {
        livro.livro.mostraLivro();
        System.out.println("Nome do locador: " + nomeDoLocador);
        System.out.println("Quantos dias de aluguel: " + diasAluguel);
    }

    /**
     * Metodo que faz impressão das informações do livro
     * presente na biblioteca
     */
    void mostraLivroDeBiblioteca() {
        Locale.setDefault(Locale.US);
        livro.mostraLivro();
        System.out.println("Código do livro: " + codigoDoLivro);
        System.out.println("Unidades disponíveis: " + qntdDisponivel);
        System.out.println("Preço do aluguel: " + precoAluguel);
        System.out.println("Unidades emprestadas: " + qntsEmprestados);
    }

}
