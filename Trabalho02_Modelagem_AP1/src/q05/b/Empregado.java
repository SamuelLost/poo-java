package q05.b;

public class Empregado {
    /**
     * Atributos e informações sobre o empregado
     */
    String nomeEmpregado;
    String departamentoEmpregado;
    double horasTrabalhadasNoMes;
    double horasExtrasNoMes; //Hora extra no mes
    double salarioPorHora;
    double salarioPorHoraExtra; // Quanto ganha por hora extra trabalhada

    /**
     * Metodo que faz inicialização de uma empregado, com informações
     * básicas sobre ele, acerca de salario, nome e departamento
     * @param nome - nome do empregado
     * @param departamento - departamento do empregado
     * @param horasTrabalhadas - quantas horas o empregado trabalhou no mes
     * @param salarioHora - quanto o empregado ganha por hora
     * @param horasExtras - quantas horas extras o empregado tem no mes
     * @param salarioHoraExtra - quanto ganha por hora extra trabalhada
     */
    void inicializaEmpregado(String nome, String departamento, double horasTrabalhadas, double salarioHora
    , double horasExtras, double salarioHoraExtra) {
        nomeEmpregado = nome;
        horasTrabalhadasNoMes = horasTrabalhadas;
        salarioPorHora = salarioHora;
        horasExtrasNoMes = horasExtras;
        salarioPorHoraExtra = salarioHoraExtra;
    }

    /**
     * O metodo em questão está fazendo o cálculo do salário
     * no mês fazendo o produto entre horaTrabalhadasNoMes
     * e salarioPorHora
     * @return - double com o valor do salario no mes
     */
    double calculaSalarioMensal() {
        return ((horasTrabalhadasNoMes * salarioPorHora) + (salarioPorHoraExtra * horasExtrasNoMes));
    }

    /**
     * O metodo faz a impressao dos dados do empregrado na tela
     */
    void mostraEmpregado() {
        System.out.println("Nome: " + nomeEmpregado);
        System.out.println("Departamento: " + departamentoEmpregado);
        System.out.println("Salário por hora: " + salarioPorHora);
        System.out.println("Horas trabalhadas no mês: " + horasTrabalhadasNoMes);
        System.out.println("Horas extras trabalhadas " + horasExtrasNoMes);
        System.out.println("Salário por hora extra " + salarioPorHoraExtra);
    }
}
