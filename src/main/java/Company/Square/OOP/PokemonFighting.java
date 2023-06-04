package Company.Square.OOP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class PokemonFighting {
    static enum Power {
        Fire,
        Rock,
        Dark,
        Poison,
        Water,
        Ice,
        Electric
    }

    static class Pokemon {
        String name;
        int totalHealth;
        int leftHealth;
        Set<Power> weakness;        // fire
        Set<Power> strength;        // water, lighting
        String status;
        
        public Pokemon(String name, int th, int lh, Set<Power> w, Set<Power> s, String status){
            this.name = name;
            this.totalHealth = th;
            this.leftHealth = lh;
            this.weakness = w;
            this.strength = s;
            this.status = status;
        }
    }

    static List<Pokemon> pokemons = new ArrayList<>();
    static PriorityQueue<Pokemon> maxHealthPokemons;
    public static void main(String[] args) {
        Pokemon pkQ = new Pokemon("pkq", 10, 10, Set.of(Power.Fire, Power.Electric),  Set.of(Power.Fire, Power.Electric), "live");
        Pokemon fireDragon = new Pokemon("fireDragon", 10, 10, Set.of(Power.Fire, Power.Electric),  Set.of(Power.Fire, Power.Electric), "live");

        Pokemon enemyPokemon = new Pokemon("enemyPokemon", 8, 8,Set.of(Power.Fire, Power.Electric),  Set.of(Power.Fire, Power.Electric), "live");

        pokemons = Arrays.asList(pkQ, fireDragon);
        Collections.sort(pokemons, new Comparator<Pokemon>() {
            @Override
            public int compare(Pokemon p1, Pokemon p2){
                return p2.leftHealth - p1.leftHealth;
            }
        });

        Collections.sort(pokemons, (a,b)-> (b.leftHealth - a.leftHealth));

        maxHealthPokemons = new PriorityQueue<>(new Comparator<Pokemon>() {
            @Override
            public int compare(Pokemon p1, Pokemon p2){
                return p2.leftHealth - p1.leftHealth;
            }
        });

        for (Pokemon p : pokemons){
            maxHealthPokemons.add(p);
        }

        fight(enemyPokemon);
    }

    private static void fight(Pokemon enemyPokemons){
        ans: for (Pokemon myPokemon : pokemons){
            if (myPokemon.leftHealth > enemyPokemons.leftHealth && myPokemon.status.equals("live")) {
                System.out.println(myPokemon.name);
            } else if (myPokemon.leftHealth == enemyPokemons.leftHealth){
                Set<Power> strPowers = myPokemon.strength;
                Set<Power> enWeakPowners = enemyPokemons.weakness;
                for (Power p : strPowers){
                    if (enWeakPowners.contains(p)) {
                        System.out.println(myPokemon.name);
                        myPokemon.leftHealth -= enemyPokemons.leftHealth;
                        break ans;
                    }
                }
            }
        }
    }
}
