package q01.c;

class DataHora {
    /**
     * Criação das instancias HoraAproximada e Data
     */
    HoraAproximada horaAprox = new HoraAproximada();
    Data data = new Data();
    
    /**
     * Medoto que checa se a data é válida e imprime
     * a data ou uma mensagem de erro
     */
    void mostraDataHora() {
        data.mostraData();
        horaAprox.mostraHora();
    }
    
}
