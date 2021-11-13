package q04.b;

import java.util.Locale;

public class LivroDeLivraria {

    Livro livro;
    double preco;
    int qntdDisponivel;

    /**
     * Metodo inicializaLivroDeLivraria faz a inicialização
     * dos atributos presentes nessa classe
     * @param book - Um livro com nome, nome do autor e numero de paginas
     * @param price - o preço do livro
     * @param qntd - quantidade presente na livraria
     */
    void inicializaLivroDeLivraria(Livro book, double price, int qntd) {
        livro = book;
        preco = price;
        qntdDisponivel = qntd;
    }

    /**
     * Metodo livroDisponivel que faz uma analise do estoque presente,
     * se tem o livro em questao disponível
     * @param livro
     * @return
     */
    boolean livroDisponivel(Livro livro) {
        return (qntdDisponivel > 0) ? true:false;
    }

    /**
     * O método precoDoLivro serve para o usario saber o preço
     * do livro
     * @return - double com o preço do livro
     */
    double precoDoLivro() {
        return preco;
    }

    /**
     * Método mostraLivroLivraria faz a impressão na tela
     * das informações do livro, quantidade e preço
     */
    void mostraLivroLivraria() {
        Locale.setDefault(Locale.US);
        livro.mostraLivro();
        if(livroDisponivel(livro)) {
            System.out.println("Preço do livro: " + preco);
            System.out.println("Quantidade restante: " + qntdDisponivel);
        }
        else {
            System.out.println("Livro indisponível no momento");
        }
    }

    /**
     * Método comprarLivro serve para o usuario fazer a compra
     * de um livro, a quantidade no estoque é diminuida ao
     * realizar a compra, caso esteja disponivel
     * @param livro - objeto da classe livro que contem informações 
     * básicas de um livro
     * @param qndtComprada - quantos livros serão comprados
     */
    void comprarLivro(Livro livro, int qntdComprada) {
        if(livroDisponivel(livro)) {
            if(qntdDisponivel < qntdComprada) {
                System.out.println("Quantidade indisponível" +
                "\nQuantidade disponível: " + qntdDisponivel);
            }
            else {
                qntdDisponivel -= qntdComprada;
                System.out.println("Compra efetuada com sucesso");
            }
        }
        else {
            System.out.println("Livro sem estoque");
        }
    }
}
