package cadastro;
//excessão lançada em quaisquer erros relacionados à conta
public class AccountException extends RuntimeException {
    public AccountException(String message) {
        super(message);
    }
}
