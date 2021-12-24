package cadastro;
//excessão lançada em quaisquer erros relacionados à conta
public class AccountException extends RuntimeException {
    /**
     * Construtor para a classe que lança exceções da aplicação.
     * @param message - mensagem que a exceção vai lançar.
     */
    public AccountException(String message) {
        super(message);
    }
}
