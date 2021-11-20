class Lapiseira {
    float calibre;
    Grafite bico;
    ArrayList<Grafite> tambor;
    Lapiseira(float calibre);
    String toString();
    boolean inserir(Grafite grafite);
    Grafite remover();
    boolean puxar();
    void escrever();
}