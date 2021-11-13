package q04.b;

public class App {
    public static void main(String[] args) {
        LivroDeLivraria livro1 = new LivroDeLivraria();
        
        livro1.livro = new Livro();
        livro1.livro.inicializaLivro("Java - Como programar", "Paul Deitel", 970, 2016, 10);

        livro1.inicializaLivroDeLivraria(livro1.livro, 314.98, 10);

        //livro1.mostraLivroLivraria();
        livro1.comprarLivro(livro1.livro, 1);
        livro1.mostraLivroLivraria();
    }
}
