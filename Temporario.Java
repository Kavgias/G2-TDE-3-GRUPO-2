package model;

public class Temporario extends Funcionario {
    private int duracaoContratoMeses;

    public Temporario(String nome, String matricula, double salario, int duracao) {
        super(nome, matricula, salario);
        this.duracaoContratoMeses = duracao;
    }

    @Override
    public void exibirDados() {
        System.out.println("Temporário - Nome: " + nome + ", Matrícula: " + matricula +
                ", Salário: " + salario + ", Duração do Contrato: " + duracaoContratoMeses + " meses");
    }
}
