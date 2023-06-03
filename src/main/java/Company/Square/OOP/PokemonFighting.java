package Company.Square.OOP;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PokemonFighting {
    static class Pokemon {
        String name;
        int totalHealth;
        int leftHealth;
        List<String> weakness;        // fire
        List<String> strength;        // water, lighting
        String status;
        
        public Pokemon(String name, int th, int lh, List<String> w, List<String> s, String status){
            this.name = name;
            this.totalHealth = th;
            this.leftHealth = lh;
            this.weakness = w;
            this.strength = s;
            this.status = status;
        }
    }

    public static void main(String[] args) {
        Pokemon pkQ = new Pokemon("pkq", 10, 10, Arrays.asList("posion", "fire"),  Arrays.asList("lighting", "fire"), "live");
        Pokemon fireDragon = new Pokemon("fireDragon", 10, 10, Arrays.asList("water", "posion"),  Arrays.asList("fire"), "live");

        List<Pokemon> pokemons = Arrays.asList(pkQ, fireDragon);
        Collections.sort(pokemons, new Comparator<Pokemon>() {
            @Override
            public int compare(Pokemon p1, Pokemon p2){
                return p2.leftHealth - p1.leftHealth;
            }
        });
    }

    private static void fight(List<Pokemon> myPokemons, List<Pokemon> enemyPokemons){
        for (Pokemon badP : enemyPokemons){
            
        }
    }
}
