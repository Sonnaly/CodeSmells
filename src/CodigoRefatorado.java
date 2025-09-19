package src;

import java.util.*;
class Grupo1_OrderCalculator {
    static class Item {
        String nome; int qtd; double preco;
        Item(String n, int q, double p){nome=n; qtd=q; preco=p;}
    }
    private static final double FATOR_DESCONTO_PROMOCIONAL = 0.9; // 10% de desconto

    public static double calcularTotal(List<Item> itens, String pais, boolean expresso) {
        double subtotal = 0;
        for (Item it : itens) {
            double linha = it.preco * it.qtd;
            if (it.nome != null && it.nome.toLowerCase().contains("promo")) {
                linha = linha * FATOR_DESCONTO_PROMOCIONAL;
            }
            subtotal += linha;
        }
        double frete;
        switch (pais) {
            case "BR" -> {
                frete = expresso ? 39.90 : 19.90;
                if (subtotal > 200) frete = 0;
            }
            case "US" -> {
                frete = expresso ? 29.90 : 9.90;
                if (subtotal > 150) frete = 0;
            }
            default -> frete = expresso ? 59.90 : 39.90;
        }
        double imposto = subtotal * 0.085;
        return subtotal + frete + imposto;
    }
    public static void main(String[] args) {
        List<Item> itens = Arrays.asList(
                new Item("copo promo", 3, 10.0),
                new Item("prato", 1, 50.0)
        );
        System.out.println(calcularTotal(itens, "BR", true));
    }
}