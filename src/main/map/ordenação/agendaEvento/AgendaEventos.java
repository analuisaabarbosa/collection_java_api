package main.map.ordenação.agendaEvento;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    private Map<LocalDate, Evento> eventosMap;

    public AgendaEventos() {
        this.eventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao) {
        eventosMap.put(data, new Evento(nome, atracao));
    }

    public void exibirAgenda() {
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        System.out.println(eventosTreeMap);
    }

    public void obterProximoEvento() {
        LocalDate dataAtual = LocalDate.now();
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        for(var entry : eventosTreeMap.entrySet()){
            if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual)) {
                System.out.println("O próximo evento: " + entry.getValue() + "acontecerá na data " + entry.getKey());
                break;
            }
        }
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();

        agendaEventos.adicionarEvento(LocalDate.of(2022, Month.JULY, 15), "Festa da Piscina", "Piscina");
        agendaEventos.adicionarEvento(LocalDate.of(2022, 7, 14), "Festa de Aniversário", "Patrulha Canina");
        agendaEventos.adicionarEvento(LocalDate.of(2004, Month.JULY, 23), "Festa Neon", "Pintura facial");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.AUGUST, 4), "Festa de Aniversário", "Animadores de festa");

        agendaEventos.exibirAgenda();

        agendaEventos.obterProximoEvento();
    }
}
