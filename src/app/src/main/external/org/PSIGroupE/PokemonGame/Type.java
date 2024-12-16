package org.PSIGroupE.PokemonGame;

public enum Type {
    DARK("#757575"),
    DRAGON("#6666CC"),
    FIRE("#FF6666"),
    GRASS("#99CC99"),
    GROUND("#C57A4A"),
    ICE("#DDEEFF"),
    NORMAL("#CCCCCC"),
    ROCK("#E8D188"),
    STEEL("#A8B8C5"),
    WATER("#6666FF");
    private final String color;

    // Constructor del enum
    Type(String color) {
        this.color = color;
    }

    // Método para obtener el color
    public String getColor() {
        return color;
    }
}