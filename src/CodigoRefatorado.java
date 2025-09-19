package src;

import java.util.*;

class Grupo1_OrderCalculator {
    static class Item {
        String nome; int qtd; double preco;
        Item(String n, int q, double p){nome=n; qtd=q; preco=p;}
    }

    // --- CONSTANTES ---
    // Para números mágicos
    private static final double FATOR_DESCONTO_PROMOCIONAL = 0.9; // 10% de desconto

    // Para strings mágicas
    private static final String PALAVRA_CHAVE_PROMO = "promo";
    private static final String PAIS_BRASIL = "BR";
    private static final String PAIS_EUA = "US";


    public static double calcularTotal(List<Item> itens, String pais, boolean expresso) {
        double subtotal = 0;
        for (Item it : itens) {
            double linha = it.preco * it.qtd;
            // SUBSTITUÍDO: Usando a constante para a palavra da promoção
            if (it.nome != null && it.nome.toLowerCase().contains(PALAVRA_CHAVE_PROMO)) {
                linha = linha * FATOR_DESCONTO_PROMOCIONAL;
            }
            subtotal += linha;
        }

        double frete;
        // SUBSTITUÍDO: Usando as constantes de países no switch case
        switch (pais) {
            case PAIS_BRASIL -> {
                frete = expresso ? 39.90 : 19.90;
                if (subtotal > 200) frete = 0;
            }
            case PAIS_EUA -> {
                frete = expresso ? 29.90 : 9.90;
                if (subtotal > 150) frete = 0;
            }
            default -> frete = expresso ? 59.90 : 39.90;
        }

        double imposto = subtotal * 0.085; // <- OBS: Este 0.085 ainda é um número mágico!
        return subtotal + frete + imposto;
    }

    public static void main(String[] args) {
        List<Item> itens = Arrays.asList(
                new Item("copo promo", 3, 10.0),
                new Item("prato", 1, 50.0)
        );
        // SUBSTITUÍDO: Usando a constante na chamada do método
        System.out.println(calcularTotal(itens, PAIS_BRASIL, true));
    }

}

