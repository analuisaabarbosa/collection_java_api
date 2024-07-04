package main.set.ordenação.listaAlunos;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Alunos> alunosSet;

    public GerenciadorAlunos() {
        this.alunosSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, long matricula, double nota) {
        alunosSet.add(new Alunos(nome, matricula, nota));
    }

    public void removerAlunoPorMatricula(long matricula) {
        Alunos alunoParaRemover = null;
        if (!alunosSet.isEmpty()) {
            for (Alunos a : alunosSet) {
                if (a.getMatricula() == matricula) {
                    alunoParaRemover = a;
                    break;
                }
            }
            alunosSet.remove(alunoParaRemover);
        } else {
            throw new RuntimeException("O conjunto está vazio!");
        }

        if (alunoParaRemover == null) {
            System.out.println("Matricula não encontrada!");
        }
    }

    public Set<Alunos> exibirAlunosPorNome() {
        Set<Alunos> alunosPorNome = new TreeSet<>(alunosSet);
        return alunosPorNome;
    }

    public Set<Alunos> exibirAlunosPorNota() {
        Set<Alunos> alunosPorNota = new TreeSet<>(new ComparatorPorNota());
        alunosPorNota.addAll(alunosSet);
        return alunosPorNota;
    }

    public void exibirAlunos() {
        System.out.println(alunosSet);
    }

    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        gerenciadorAlunos.adicionarAluno("Marcos Guimarâes", 2069l, 7.5);
        gerenciadorAlunos.adicionarAluno("Ana Maria Santos", 3589l, 10);
        gerenciadorAlunos.adicionarAluno("Bruno Soares", 1488l, 5);
        gerenciadorAlunos.adicionarAluno("Yasmin Monte Negro", 7542l, 8.5);

        gerenciadorAlunos.exibirAlunos();

        System.out.println(gerenciadorAlunos.exibirAlunosPorNome());

        System.out.println(gerenciadorAlunos.exibirAlunosPorNota());

        gerenciadorAlunos.removerAlunoPorMatricula(1488l);

        gerenciadorAlunos.exibirAlunos();
    }
}
