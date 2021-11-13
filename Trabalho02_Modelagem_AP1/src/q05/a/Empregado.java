package q05.a;

public class Empregado {
    
    String nomeEmpregado;
    String departamentoEmpregado;
    double horaTrabalhadasNoMes;
    double salarioPorHora;

    /**
     * Metodo que faz inicialização de uma empregado, com informações
     * básicas sobre ele, acerca de salario, nome e departamento
     * @param nome - nome do empregado
     * @param departamento - departamento do empregado
     * @param horasTrabalhadas - quantas horas o empregado trabalhou no mes
     * @param salarioHora - quanto o empregado ganha por hora
     */
    void inicializaEmpregado(String nome, String departamento, double horasTrabalhadas, double salarioHora) {
        nomeEmpregado = nome;
        horaTrabalhadasNoMes = horasTrabalhadas;
        salarioPorHora = salarioHora;
    }

    /**
     * O metodo em questão está fazendo o cálculo do salário
     * no mês fazendo o produto entre horaTrabalhadasNoMes
     * e salarioPorHora
     * @return - double com o valor do salario no mes
     */
    double calculaSalarioMensal() {
        return (horaTrabalhadasNoMes * salarioPorHora);
    }

    /**
     * O metodo faz a impressao dos dados do empregrado na tela
     */
    void mostraEmpregado() {
        System.out.println("Nome: " + nomeEmpregado);
        System.out.println("Departamento: " + departamentoEmpregado);
        System.out.println("Salário por hora: " + salarioPorHora);
        System.out.println("Horas trabalhadas no mês: " + horaTrabalhadasNoMes);
    }
}
