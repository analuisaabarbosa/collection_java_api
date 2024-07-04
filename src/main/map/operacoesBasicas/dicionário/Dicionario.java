package main.map.operacoesBasicas.dicionário;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    Map<String, String> dicionarioMap;

    public Dicionario(String palavra, String definicao){
        this.dicionarioMap = new HashMap<>();
    }

    public void adicionarPalavras(String palavra, String definicao){
        this.dicionarioMap.put(palavra, definicao);
    }

    public void removerPalavra(String palavra){
        if (!dicionarioMap.isEmpty()) {
            dicionarioMap.remove(palavra);
        }
    }

    public void exibirPalavras(){
        System.out.println(dicionarioMap);
    }

    public String pesquisarPorPalavra(String palavra){
        String definicaoPorPalavra = null;
        if (!dicionarioMap.isEmpty()) {
            definicaoPorPalavra = dicionarioMap.get(palavra);
        }
        return definicaoPorPalavra;
    }

    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario(null, null);

        dicionario.adicionarPalavras("Brigadeiro", "Doce feito com leite condensado e chocolate em pó");
        dicionario.adicionarPalavras("Gato", "Pequeno mamífero carnívoro, doméstico, da familía dos felídeos");
        dicionario.adicionarPalavras("Pão de alho", "Pão guarnecido com uma mistura de alho e azeite");
        dicionario.adicionarPalavras("Radar", " Dispositivo que permite detectar objetos distantes e inferir suas distâncias");

        dicionario.exibirPalavras();

        dicionario.removerPalavra("Radar");

        dicionario.exibirPalavras();

        System.out.println(dicionario.pesquisarPorPalavra("Brigadeiro"));
    }
}
