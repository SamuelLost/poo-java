package q05.c;

public class App {
    public static void main(String[] args) {
        Empregado e1 = new Empregado();
        Empregado e2 = new Empregado();

        e1.inicializaEmpregado("José", "Diretoria", 100, 18, 5, 260);
        e2.inicializaEmpregado("Samuel", "Limpeza", 100, 10.7, 0, 0);
        System.out.println(e2.calculaSalarioMensal());
        System.out.println(e1.calculaSalarioMensal());
        
    }
}
