package contagemPalavras;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {
    Map<String, Integer> contagemPalavrasMap;

    public ContagemPalavras(String palavra, Integer contagem){
        this.contagemPalavrasMap = new HashMap<>();
    }

    public void exibirPalavras(){
        System.out.println(contagemPalavrasMap);
    }

    public void adicionarPalavra(String palavra, Integer contagem){
        this.contagemPalavrasMap.put(palavra, contagem);
    }

    public void removerPalavra(String palavra){
        if (!contagemPalavrasMap.isEmpty()) {
            this.contagemPalavrasMap.remove(palavra);
        } else {
            System.out.println("O map está vazio!");
        }
    }

    public int exibirContagemPalavras(){
        int contagemTotal = 0;
        for (int contagem : contagemPalavrasMap.values()) {
            contagemTotal += contagem;
        }
        return contagemTotal;
    }

    public String encontrarPalavraMaisFrequente(){
        String palavraMaisFrequente = null;
        int maiorContagem = 0;
        for (Map.Entry<String, Integer> entry : contagemPalavrasMap.entrySet()) {
            if (entry.getValue() > maiorContagem) {
                maiorContagem = entry.getValue();
                palavraMaisFrequente = entry.getKey();
            }
        }
        return palavraMaisFrequente;
    }

    public static void main(String[] args) {
        ContagemPalavras contagemPalavras = new ContagemPalavras(null, null);

        contagemPalavras.adicionarPalavra("Java", 2);
        contagemPalavras.adicionarPalavra("Python", 8);
        contagemPalavras.adicionarPalavra("JavaScript", 1);
        contagemPalavras.adicionarPalavra("C#", 1);

        contagemPalavras.exibirPalavras();

        System.out.println("Existem " + contagemPalavras.exibirContagemPalavras() + " palavras");

        System.out.println("A palavra mais frequente é: " + contagemPalavras.encontrarPalavraMaisFrequente());

        contagemPalavras.removerPalavra("C#");

        contagemPalavras.exibirPalavras();
    }
}
