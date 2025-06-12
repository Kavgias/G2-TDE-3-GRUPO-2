package model;

public class Efetivo extends Funcionario {
    private String departamento;

    public Efetivo(String nome, String matricula, double salario, String departamento) {
        super(nome, matricula, salario);
        this.departamento = departamento;
    }

    @Override
    public void exibirDados() {
        System.out.println("Efetivo - Nome: " + nome + ", Matrícula: " + matricula +
                ", Salário: " + salario + ", Departamento: " + departamento);
    }
}
