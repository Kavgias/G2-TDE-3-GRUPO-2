package model;

public class Terceirizado extends Funcionario {
    private String empresaOrigem;

    public Terceirizado(String nome, String matricula, double salario, String empresaOrigem) {
        super(nome, matricula, salario);
        this.empresaOrigem = empresaOrigem;
    }

    @Override
    public void exibirDados() {
        System.out.println("Terceirizado - Nome: " + nome + ", Matrícula: " + matricula +
                ", Salário: " + salario + ", Empresa: " + empresaOrigem);
    }
}
