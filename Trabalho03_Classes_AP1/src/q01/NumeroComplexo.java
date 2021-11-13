package q01;

import java.util.Locale;

public class NumeroComplexo {
    /**
     * Atributos da classe
     */
    private double parteReal;
    private double parteImaginaria;

    /**
     * Méodo que retorna a parte real de um número complexo
     * @return double da parte real
     */
    public double getParteReal() {
        return parteReal;
    }

    /**
     * Método para atribuir a parte real 
     * @param parteReal - double parte real 
     */
    public void setParteReal(double parteReal) {
        this.parteReal = parteReal;
    }

    /**
     * Méodo que retorna a parte imaginária de um número complexo
     * @return double da parte imaginária
     */
    public double getParteImaginaria() {
        return parteImaginaria;
    }

    /**
     * Método para atribuir a parte imaginária 
     * @param parteReal - double parte imaginária 
     */
    public void setParteImaginaria(double parteImaginaria) {
        this.parteImaginaria = parteImaginaria;
    }

    /**
     * Metodo faz a inicialização dos atributos presente na
     * classe NumeroComplexo que correspondem aos campos
     * parte real e parte imaginaria de um número complexo
     * @param parteReal - parte real
     * @param parteImaginaria - parte imaginária
     */
    public void inicializaNumero(double parteReal, double parteImaginaria) {
        this.parteReal = parteReal;
        this.parteImaginaria = parteImaginaria;
    }

    /**
     * Método que faz a impressão de um número complexo no formato
     * a +bi, o sinal fica colado a parte imágina pois se tá utlizando
     * a flag '+' do printf e precisão de 2 casas decimais, pois os 
     * valores são em double.
     */
    public void imprimeNumero() {
        Locale.setDefault(Locale.US);
        System.out.printf("%.2f %+.2fi\n", parteReal, parteImaginaria);    
    }

    /**
     * Método faz a análise se um número complexo está instanciado.
     * O método foi criado para fazer reuso de código, pois essa 
     * análise é bastante utilizada em outros métodos.
     * @param z - a instancia de um número complexo
     * @return true caso seja diferente de null e false caso contrário
     */
    public boolean estaInstanciado(NumeroComplexo z) {
        return (z != null) ? true : false;
    }

    /**
     * Método que compara os atributos da classe encapsulada
     * com os atributos da classe passado como parâmetro.
     * Faz a comparação entre as duas partes reais e as
     * duas parte imaginárias
     * @param z - a instancia de um número complexo
     * @return true se a parte real e imaginária de um for igual a 
     * do outro número complexo, false caso tenha alguma parte diferente
     */
    public boolean ehIgual(NumeroComplexo z) {
        if (estaInstanciado(z)) {
            return (this.parteReal == z.parteReal) && (this.parteImaginaria == z.parteImaginaria) ? true : false;
        }
        return false;
    }

    /**
     * O método soma faz a soma de dois números complexos.
     * A soma é feita separadamente, ou seja, parte real soma
     * com parte real, parte imaginária com parte imaginária.
     * Ex:
     *      NumeroComplexo encapsulado: a + bi
     *      NumeroComplexo passado como argumento: c + di
     * 
     *      Operação: (a + bi) + (c + di)
     *      NumeroComplexo novo = (a + c) + (b + d)i
     * a e c são as partes reais de cada complexo, enquanto
     * d e b são as partes imaginárias.
     * 
     * Caso o parâmetro não tenha sido instanciado,
     * será designado -1 para a parte real e imaginária
     * do novo complexo.
     * @param z - a instancia de um número complexo
     * @return a instancia de número complexo novo com o resultado
     */
    public NumeroComplexo soma(NumeroComplexo z) {
        NumeroComplexo aux = new NumeroComplexo();
        if (estaInstanciado(z)) {
            double auxReal = this.parteReal + z.parteReal;
            double auxImaginaria = this.parteImaginaria + z.parteImaginaria;
            aux.inicializaNumero(auxReal, auxImaginaria);
            return aux;
        } else {
            aux.inicializaNumero(-1, -1);
            return aux;
        }
    }

    /**
     * O método subtrai faz a subtração de dois números complexos.
     * A subtração é feita separadamente, ou seja, parte real subtrai
     * com parte real, parte imaginária com parte imaginária.
     * Ex:
     *      NumeroComplexo encapsulado: a + bi
     *      NumeroComplexo passado como argumento: c + di
     * 
     *      Operação: (a + bi) - (c + di)
     *      NumeroComplexo novo = (a - c) + (b - d)i
     * a e c são as partes reais de cada complexo, enquanto
     * d e b são as partes imaginárias.
     * 
     * Caso o parâmetro não tenha sido instanciado,
     * será designado -1 para a parte real e imaginária
     * do novo complexo.
     * @param z - a instancia de um número complexo
     * @return a instancia de número complexo novo com o resultado
     */
    public NumeroComplexo subtrai(NumeroComplexo z) {
        NumeroComplexo aux = new NumeroComplexo();
        if (estaInstanciado(z)) {
            double auxReal = this.parteReal - z.parteReal;
            double auxImaginaria = this.parteImaginaria - z.parteImaginaria;
            aux.inicializaNumero(auxReal, auxImaginaria);
            return aux;
        } else {
            aux.inicializaNumero(-1, -1);
            return aux;
        }
    }

    /**
     * O método multiplica faz a multiplicação de dois números complexos.
     * Ela é feita da seguinte forma: a subtração do produto das partes
     * reias com o produto das parte imaginária, essa é a parte real
     * do novo complexo. A parte imaginária se dá pela subtração do produto
     * entre a parte real do primeiro número com a parte imaginária
     * do segundo número com o produto da parte imaginária do primeiro número 
     * e parte real do segundo número
     * Ex:
     *      NumeroComplexo encapsulado: a + bi
     *      NumeroComplexo passado como argumento: c + di
     * 
     *      Operação: (a + bi) * (c + di)
     *      NumeroComplexo novo = (ac - bd) + (ad - bc)i
     * a e c são as partes reais de cada complexo, enquanto
     * d e b são as partes imaginárias.
     * 
     * Caso o parâmetro não tenha sido instanciado,
     * será designado -1 para a parte real e imaginária
     * do novo complexo.
     * @param z - a instancia de um número complexo
     * @return a instancia de número complexo novo com o resultado
     */
    public NumeroComplexo multiplica(NumeroComplexo z) {
        NumeroComplexo aux = new NumeroComplexo();
        if (estaInstanciado(z)) {
            double auxReal = (this.parteReal * z.parteReal) - (this.parteImaginaria * z.parteImaginaria);
            double auxImaginaria = (this.parteReal * z.parteImaginaria) + (this.parteImaginaria * z.parteReal);
            aux.inicializaNumero(auxReal, auxImaginaria);
            return aux;
        } else {
            aux.inicializaNumero(-1, -1);
            return aux;
        }

    }

    /**
     * O método divide faz a divisão de dois números complexos.
     * Ela é feita da seguinte forma: a soma do produto das partes
     * reias com o produto das parte imaginária, essa é a parte real
     * do novo complexo. A parte imaginária se dá pela subtração do produto
     * entre a parte imaginária do primeiro número e parte real do segundo número
     * com o produto da parte real do primeiro número com a parte imaginária
     * do segundo número. 
     * Ex:
     *      NumeroComplexo encapsulado: a + bi
     *      NumeroComplexo passado como argumento: c + di
     * 
     *      Operação: (a + bi) / (c + di)
     *      NumeroComplexo novo = (ac + bd)/(c² + d²) + (bc - ad)/(c² + d²)i
     * a e c são as partes reais de cada complexo, enquanto
     * d e b são as partes imaginárias.
     * 
     * Antes da divisão ser realizada, é preciso analisar se c e d são zero,
     * pois o denominador não pode ser 0 na hora da divisão. Se os dois
     * não forem zeros ao mesmo tempo, a divisão será realizada, caso contrário
     * o novo complexo será inicializado com 0 em ambos atributos e será retornado.
     * 
     * Caso o parâmetro não tenha sido instanciado,
     * será designado -1 para a parte real e imaginária
     * do novo complexo.
     * @param z - a instancia de um número complexo
     * @return a instancia de número complexo novo com o resultado
     */
    public NumeroComplexo divide(NumeroComplexo z) {
        NumeroComplexo aux = new NumeroComplexo();
        if (estaInstanciado(z)) {
            if((z.parteImaginaria != 0) && (z.parteReal != 0)) {
                double denominador = Math.pow(z.parteReal, 2) + Math.pow(z.parteImaginaria, 2);
                double auxReal = ((this.parteReal * z.parteReal) + (this.parteImaginaria * z.parteImaginaria)) / denominador;
                double auxImaginaria = ((this.parteImaginaria * z.parteReal) - (this.parteReal * z.parteImaginaria)) / denominador;
                aux.inicializaNumero(auxReal, auxImaginaria);
                return aux;
            }
            else {
                System.out.println("Denominador é zero, divisão não é possível");    
                aux.inicializaNumero(0, 0);
                return aux;
            }
            
        } else {
            aux.inicializaNumero(-1, -1);
            return aux;
        }
    }
}
