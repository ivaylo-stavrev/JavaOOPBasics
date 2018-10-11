package ex08_pokemon_trainer;

import java.util.LinkedList;
import java.util.List;

public class Trainer {
    private static final int DEFAULT_STARTING_BADGES = 0;

    private String name;
    private int numOfBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.numOfBadges = DEFAULT_STARTING_BADGES;
        this.pokemons = new LinkedList<>();
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public void setNumOfBadges(int numOfBadges) {
        this.numOfBadges = numOfBadges;
    }

    public int getNumOfBadges() {
        return this.numOfBadges;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public int countPokemonWithElement (String element) {
        int pokemonsCount = this.getNumOfBadges();
        for (Pokemon pokemon : pokemons) {
            if(pokemon.getElement().equals(element)) {
                pokemonsCount++;
            }
        }
        return pokemonsCount;
    }

    public boolean hasPokemonWithElement(String element) {
        boolean result = false;
        if(this.countPokemonWithElement(element) != 0) {
            result = true;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.name).append(" ").append(this.numOfBadges).append(" ").append(this.pokemons.size());
        return sb.toString();
    }

    public void printStats() {
        System.out.println(this.toString());
    }
}
