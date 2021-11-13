package q04.b;

public class Livro {
    String nomeDoLivro;
    String nomeDoAutor;
    int edicao;
    int numPaginas;
    int anoDeLancamento;

    /**
     * Inicialização dos atributos da classe
     * @param nome - nome do livro
     * @param autor - nome do autor
     * @param paginas - numero de pags
     * @param ano - ano de lançamento
     */
    void inicializaLivro(String nome, String autor, int paginas, int ano, int ed) {
        nomeDoLivro = nome;
        nomeDoAutor = autor;
        numPaginas = paginas;
        anoDeLancamento = ano;
        edicao = ed;
    }

    /**
     * Imprime na tela informaçoes sobre o livro
     */
    void mostraLivro() {
        System.out.println("Nome do livro: " + nomeDoLivro);
        System.out.println("Nome do autor: " + nomeDoAutor);
        System.out.println("Número de páginas: " + numPaginas);
        System.out.println("Edição: " + edicao);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }
}
