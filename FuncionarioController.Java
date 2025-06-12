package controller;

import model.*;
import java.util.*;

public class FuncionarioController {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public void adicionarFuncionario(Funcionario f) {
        funcionarios.add(f);
    }

    public void listarFuncionarios() {
        for (Funcionario f : funcionarios) {
            f.exibirDados();
        }
    }

    public Funcionario buscarPorMatricula(String matricula) throws FuncionarioNaoEncontradoException {
        for (Funcionario f : funcionarios) {
            if (f.getMatricula().equalsIgnoreCase(matricula)) {
                return f;
            }
        }
        throw new FuncionarioNaoEncontradoException("Funcionário não encontrado.");
    }

    public void atualizarSalario(String matricula, double novoSalario) throws FuncionarioNaoEncontradoException {
        Funcionario f = buscarPorMatricula(matricula);
        f.setSalario(novoSalario);
    }

    public void removerFuncionario(String matricula) throws FuncionarioNaoEncontradoException {
        Funcionario f = buscarPorMatricula(matricula);
        funcionarios.remove(f);
    }
}
