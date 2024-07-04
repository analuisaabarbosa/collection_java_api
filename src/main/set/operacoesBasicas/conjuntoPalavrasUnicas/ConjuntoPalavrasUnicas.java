package main.set.operacoesBasicas.conjuntoPalavrasUnicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavrasUnicasSet;

    public ConjuntoPalavrasUnicas() {
        this.palavrasUnicasSet = new HashSet<>();
    }

    public void adicionarUmaPalavra(String palavra) {
        this.palavrasUnicasSet.add(palavra);
    }

    public void removerPalavra(String palavra) {
        if (!palavrasUnicasSet.isEmpty()) {
            if (palavrasUnicasSet.contains(palavra)) {
                palavrasUnicasSet.remove(palavra);
            } else {
                System.out.println("Palavra não encontrada no conjunto!");
            }
        } else {
            System.out.println("O conjunto está vazio!");
        }
    }

    public boolean verificarPalavra(String palavra) {
        return palavrasUnicasSet.contains(palavra);
    }

    public void exibirPalavrasUnicas() {
        if (!palavrasUnicasSet.isEmpty()) {
            System.out.println(palavrasUnicasSet);
        } else {
            System.out.println("O conjunto está vazio!");
        }
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();

        conjuntoPalavrasUnicas.adicionarUmaPalavra("Elefante");
        conjuntoPalavrasUnicas.adicionarUmaPalavra("Macaco");
        conjuntoPalavrasUnicas.adicionarUmaPalavra("Girafa");
        conjuntoPalavrasUnicas.adicionarUmaPalavra("Macaco");
        conjuntoPalavrasUnicas.adicionarUmaPalavra("Esquilo");
        conjuntoPalavrasUnicas.adicionarUmaPalavra("Jacaré");

        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

        conjuntoPalavrasUnicas.removerPalavra("Macaco");
        conjuntoPalavrasUnicas.exibirPalavrasUnicas();

        conjuntoPalavrasUnicas.removerPalavra("Esquilo");

        System.out.println("O animal 'Elefante' está no conjunto? " + conjuntoPalavrasUnicas.verificarPalavra("Elefante"));
        System.out.println("O animal 'Macaco' está no conjunto? " + conjuntoPalavrasUnicas.verificarPalavra("Macaco"));

        conjuntoPalavrasUnicas.exibirPalavrasUnicas();
    }
}
