package q04.c;

public class App {
    public static void main(String[] args) {
        LivroDeBiblioteca book = new LivroDeBiblioteca();
        LivroDeBiblioteca bookTwo = new LivroDeBiblioteca();
        book.livro = new Livro(); //Instanciando a classe Livro
        bookTwo.livro = new Livro();
        //Inicializando a classe Livro
        book.livro.inicializaLivro("Java - Como programar", "Deitel", 970, 2016, 10);
        bookTwo.livro.inicializaLivro("Orientação a objetos", "Thiago Leite", 245, 2016, 1);
        //Inicializando a classe LivroDeBiblioteca
        book.inicializarLivroDeBiblioteca(book.livro, 15, 0.5, 1167890);
        bookTwo.inicializarLivroDeBiblioteca(bookTwo.livro, 5, 0.15, 7895001);
        
        //Realizando o aluguel de um livro
        book.aluguelDeLivro(book, 7, "Samuel Henrique");
        System.out.println();
        bookTwo.aluguelDeLivro(bookTwo, 2, "Atílio Gomes");
        System.out.println();

        //Informações do aluguel
        book.informacoesDoAluguel(book);
        System.out.println();
        bookTwo.informacoesDoAluguel(bookTwo);
        System.out.println();
        
        //Mostrando dados do livro
        book.mostraLivroDeBiblioteca();
        System.out.println();
        bookTwo.mostraLivroDeBiblioteca();
    }

}
