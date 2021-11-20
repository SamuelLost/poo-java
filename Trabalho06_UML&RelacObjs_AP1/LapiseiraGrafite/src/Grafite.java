class Grafite {
    private float calibre; //espessura do grafite
    private String dureza; //dureza do grafite
    private int tamanho; //tamanho

    /**
     * Construtor da classe
     * @param calibre - inteiro para espessura do grafite
     * @param dureza - string para dureza do grafite
     * @param tamanho - inteiro para o tamanho
     */
    Grafite(float calibre, String dureza, int tamanho) {
        this.calibre = calibre;
        this.dureza = dureza;
        this.tamanho = tamanho;
    }
    /**
     * Método toString para imprimir no formato
     */
    public String toString() {
        return String.format("grafite: [%.1f:%s:%d]", this.calibre, this.dureza, this.tamanho);
    }
    
    /**
     * Métodos getters
     * @return retornam o calibre e o tamanho
     */
    public float getCalibre() {
        return calibre;
    }

    public int getTamanho() {
        return tamanho;
    }

    /**
     * Método para setar o tamanho do grafite na hora de escrever
     * @param tamanho
     */
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * Método que analisa a dureza do grafite e 
     * retorna quanto ele é gasto por forma
     * @return - inteiro que corresponde ao gasto
     */
    public int desgastePorFolha() {
        if(this.dureza.equals("HB")) return 1;
        if(this.dureza.equals("2B")) return 2;
        if(this.dureza.equals("4B")) return 4;
        if(this.dureza.equals("6B")) return 6;
        return 0;
     }
    
}
