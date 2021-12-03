class Fone {
    private String id;
    private String number;
    public Fone(String id, String number) {
        setId(id);
        this.number = number;
    }

    //verifica se o número é um número de telefone válido
    public static boolean validate(String number) {
        return false;
    }

    //O resultado deve ficar assim
    //oi:1234
    public String toString() {
        return id + ":" + number;
    }

    //GETS e SETS
    String getId() {
        return id;
    }

    void setId(String id) {
        this.id = id;
    }

    String getNumber() {
        return number;
    }

    void setNumber(String number) {
        this.number = number;
    }
}