package fone;
public class Fone {
    private String id;
    private String number;
    /**
     * Construtor da classe Fone
     * @param id - id
     * @param number - numero
     */
    public Fone(String id, String number) {
        setId(id);
        setNumber(number);
    }
    //verifica se o número é um número de telefone válido
    /**
     * Verifica se o número é válido, numéros, parêntes e pontos
     * são válidos. É criado uma string contendos os caracteres válidos,
     * ela é percorrida comparando com um caractere do número, se o número
     * tiver algum caractere diferente então é inválido.
     * @param number - número
     * @return true caso o número seja válido, false caso contrário.
     */
    public static boolean validate(String number) {
        String validos = "0123456789().";

        for(int i = 0; i < number.length(); i++) {
            if(validos.indexOf(number.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }
    //O resultado deve ficar assim
    //oi:1234
    @Override
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
    
    //utiliza o static validate para retornar se essa instancia do fone é valida
    public boolean isValid() {
        if(Fone.validate(this.number)) return true;
        else return false;
    }
}
