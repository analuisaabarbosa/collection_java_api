package main.list.operacoesBasicas.carrinhoCompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompra {
    private List<Item> itemList;

    public CarrinhoCompra() {
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, Double preco, Integer quantidade) {
        Item item = new Item(nome, preco, quantidade);
        this.itemList.add(item);
    }

    public void removerItem(String nome) {
        List<Item> itensParaRemover = new ArrayList<>();
        if (!itemList.isEmpty()) {
            for (Item i : itemList) {
                if (i.getNome().equalsIgnoreCase(nome)) {
                    itensParaRemover.add(i);
                }
            }
            itemList.removeAll(itensParaRemover);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public double calcularValorTotal() {
        double valorTotal = 0d;
        if (!itemList.isEmpty()) {
            for (Item item : itemList) {
                double valorItem = item.getPreco() * item.getQuantidade();
                valorTotal += valorItem;
            }
            return valorTotal;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public void exibirItens() {
        if (!itemList.isEmpty()) {
            System.out.println(itemList);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public String toString() {
        return "CarrinhoDeCompras{" +
                "itens=" + itemList +
                '}';
    }

    public static void main(String[] args) {
        CarrinhoCompra carrinhoCompra = new CarrinhoCompra();

        carrinhoCompra.adicionarItem("Óculos de Sol", 100.00, 1);
        carrinhoCompra.adicionarItem("Óculos de Grau", 200.00, 1);
        carrinhoCompra.adicionarItem("Calça Jeans", 199.99, 2);
        carrinhoCompra.adicionarItem("Mini Saia", 35.50, 1);
        carrinhoCompra.exibirItens();
        
        carrinhoCompra.removerItem("Óculos de Sol");
        carrinhoCompra.exibirItens();
        
        System.out.println("O valor total da compra é: " + carrinhoCompra.calcularValorTotal());
    }
}