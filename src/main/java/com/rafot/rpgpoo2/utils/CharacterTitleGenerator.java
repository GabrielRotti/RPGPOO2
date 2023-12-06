package com.rafot.rpgpoo2.utils;

import java.util.List;
import java.util.Random;

public class CharacterTitleGenerator {
    private static final Random RANDOM = new Random();
    private static final List<String> TITLES = List.of(
            "O Ninguém",
            "Guardião das Constelações",
            "Martelo de Guerra",
            "Machado de Guerra",
            "Senhor do Trovão",
            "Cavaleiro da Aurora",
            "Errante dos Ventos",
            "Alquimista do Fogo Verde",
            "Navegante do Abismo",
            "Guardião das Portas do Céu",
            "Mestre das Lâminas",
            "Arauto da Morte",
            "O Comum"
    );

    public static String generateTitle() {
        return TITLES.get(RANDOM.nextInt(TITLES.size()));
    }
}
