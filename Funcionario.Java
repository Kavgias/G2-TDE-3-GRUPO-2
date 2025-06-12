package model;

public abstract class Funcionario implements Exibivel {
    protected String nome;
    protected String matricula;
    protected double salario;

    public Funcionario(String nome, String matricula, double salario) {
        this.nome = nome;
        this.matricula = matricula;
        this.salario = salario;
    }

    public String getNome() { return nome; }
    public String getMatricula() { return matricula; }
    public double getSalario() { return salario; }

    public void setNome(String nome) { this.nome = nome; }
    public void setSalario(double salario) { this.salario = salario; }

    public abstract void exibirDados();
}
