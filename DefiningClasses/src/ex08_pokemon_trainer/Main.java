package ex08_pokemon_trainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Trainer> trainers = new LinkedHashMap<>();
        Pokemon pokemon;

        while (true) {
            String[] input = reader.readLine().split("\\s+");
            if("Tournament".equals(input[0])) {
                break;
            }
            String currentTrainerName = input[0];
            String currentPokemonName = input[1];
            String currentPokemonElement = input[2];
            int currentPokemonHealth = Integer.parseInt(input[3]);
            pokemon = new Pokemon(currentPokemonName, currentPokemonElement, currentPokemonHealth);
            if(trainers.containsKey(currentTrainerName)) {
                trainers.get(currentTrainerName).addPokemon(pokemon);
            }
            else {
                Trainer currentTrainer = new Trainer(currentTrainerName);
                currentTrainer.addPokemon(pokemon);
                trainers.put(currentTrainerName, currentTrainer);
            }
        }

        while (true) {
            String element = reader.readLine();
            if ("End".equals(element)) {
                break;
            }

            for (Trainer trainer : trainers.values()) {
                if (trainer.hasPokemonWithElement(element)) {
                    trainer.setNumOfBadges(trainer.countPokemonWithElement(element));
                } else {
                    trainer.getPokemons().forEach(p -> p.damagePokemon());
                    //for (Pokemon p : trainer.getPokemons()) {
                    //    if (p.getHealth() <= 0) {
                    //        trainer.getPokemons().remove(p);
                    //    }
                    //}
                    trainer.getPokemons().removeIf(p -> p.getHealth() <= 0);
                }
            }
        }

        trainers.values()
                .stream()
                .sorted((x1, x2) -> Integer.compare(x2.getNumOfBadges(), x1.getNumOfBadges()))
                .forEach(t -> t.printStats());
    }
}
