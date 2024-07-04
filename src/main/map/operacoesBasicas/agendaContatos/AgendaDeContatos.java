package main.map.operacoesBasicas.agendaContatos;

import java.util.HashMap;
import java.util.Map;

public class AgendaDeContatos {
    private Map<String, Integer> agendaContatosMap;

    public AgendaDeContatos(String nome, Integer numero) {
        this.agendaContatosMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer numero) {
        agendaContatosMap.put(nome, numero);
    }

    public void removerContato(String nome) {
        if (!agendaContatosMap.isEmpty()) {
            agendaContatosMap.remove(nome);
        }
    }

    public void exibirContatos() {
        System.out.println(agendaContatosMap);
    }

    public Integer pesquisarPorNome(String nome) {
        Integer numeroPorNome = null;
        if (!agendaContatosMap.isEmpty()) {
            numeroPorNome = agendaContatosMap.get(nome);
        }
        return numeroPorNome;
    }

    public static void main(String[] args) {
        AgendaDeContatos agendaDeContatos = new AgendaDeContatos(null, null);

        agendaDeContatos.adicionarContato("Camila", 123456);
        agendaDeContatos.adicionarContato("João", 5665);
        agendaDeContatos.adicionarContato("Carlos", 1111111);
        agendaDeContatos.adicionarContato("Ana", 654987);
        agendaDeContatos.adicionarContato("Maria", 1111111);
        agendaDeContatos.adicionarContato("Camila", 44444);

        agendaDeContatos.exibirContatos();

        agendaDeContatos.removerContato("Maria");
        agendaDeContatos.exibirContatos();

        String nomePesquisa = "João";
        Integer numeroPesquisa = agendaDeContatos.pesquisarPorNome("João");
        System.out.println("Número de telefone de " + nomePesquisa + ": " + numeroPesquisa);

        String nomePesquisaNaoExistente = "Paula";
        Integer numeroPesquisaNaoExistente = agendaDeContatos.pesquisarPorNome(nomePesquisaNaoExistente);
        System.out.println("Número de telefone de " + nomePesquisaNaoExistente + ": " + numeroPesquisaNaoExistente);
    }

}
