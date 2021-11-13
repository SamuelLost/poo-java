package q01;
public class App {
    public static void main(String[] args) throws Exception {
        /**
         * Criação dos objetos
         */
        NumeroComplexo z = new NumeroComplexo();
        NumeroComplexo complexo = new NumeroComplexo();
        NumeroComplexo result = new NumeroComplexo();
        double a = 2.0;
        double b = 4.0;
        double c = 5.0;
        double d = 2.0;

        z.inicializaNumero(a, b); //inicialização
        complexo.inicializaNumero(c, d); //inicialização

        z.imprimeNumero();
        System.out.println(z.ehIgual(complexo));

        /**
         * Testando as operações
         */
        result = z.soma(complexo);
        System.out.print("Soma: ");
        result.imprimeNumero();

        result = z.subtrai(complexo);
        System.out.print("Subtração: ");
        result.imprimeNumero();

        result = z.multiplica(complexo);
        System.out.print("Multiplicação: ");
        result.imprimeNumero();
        
        result = z.divide(complexo);
        System.out.print("Divisão: ");
        result.imprimeNumero();

    }
}
