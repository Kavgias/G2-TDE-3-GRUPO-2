package view;

import controller.FuncionarioController;
import model.*;
import model.Terceirizado;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FuncionarioController controller = new FuncionarioController();

        while (true) {
            System.out.println("\n1. Adicionar Funcionário");
            System.out.println("2. Listar Funcionários");
            System.out.println("3. Buscar Funcionário");
            System.out.println("4. Atualizar Salário");
            System.out.println("5. Remover Funcionário");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            int opcao = sc.nextInt(); sc.nextLine();

            try {
                switch (opcao) {
                    case 1 -> {
                        System.out.print("Tipo (1-Efetivo, 2-Temporário, 3-Terceirizado): ");
                        int tipo = sc.nextInt(); sc.nextLine();

                        System.out.print("Nome: ");
                        String nome = sc.nextLine();
                        System.out.print("Matrícula: ");
                        String matricula = sc.nextLine();
                        System.out.print("Salário: ");
                        double salario = sc.nextDouble(); sc.nextLine();

                        switch (tipo) {
                            case 1 -> {
                                System.out.print("Departamento: ");
                                String departamento = sc.nextLine();
                                controller.adicionarFuncionario(new Efetivo(nome, matricula, salario, departamento));
                            }
                            case 2 -> {
                                System.out.print("Duração (meses): ");
                                int duracao = sc.nextInt(); sc.nextLine();
                                controller.adicionarFuncionario(new Temporario(nome, matricula, salario, duracao));
                            }
                            case 3 -> {
                                System.out.print("Empresa de Origem: ");
                                String empresa = sc.nextLine();
                                controller.adicionarFuncionario(new Terceirizado(nome, matricula, salario, empresa));
                            }
                            default -> throw new EntradaInvalidaException("Tipo inválido.");
                        }
                    }
                    case 2 -> controller.listarFuncionarios();
                    case 3 -> {
                        System.out.print("Matrícula: ");
                        String mat = sc.nextLine();
                        Funcionario f = controller.buscarPorMatricula(mat);
                        f.exibirDados();
                    }
                    case 4 -> {
                        System.out.print("Matrícula: ");
                        String mat = sc.nextLine();
                        System.out.print("Novo salário: ");
                        double novoSalario = sc.nextDouble(); sc.nextLine();
                        controller.atualizarSalario(mat, novoSalario);
                    }
                    case 5 -> {
                        System.out.print("Matrícula: ");
                        String mat = sc.nextLine();
                        controller.removerFuncionario(mat);
                    }
                    case 0 -> {
                        System.out.println("Saindo...");
                        return;
                    }
                    default -> System.out.println("Opção inválida!");
                }
            } catch (FuncionarioNaoEncontradoException | EntradaInvalidaException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        }
    }
}
