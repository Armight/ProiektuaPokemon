package proiektuPokemonAbiapuntu;

import java.util.ArrayList;
import java.util.Iterator;

// PokemonZerrenda klasea (ListaPokemon - Pokemonen zerrenda)
public class PokemonZerrenda {
    private ArrayList<Pokemon> pokemonak;
    
    public PokemonZerrenda() {
        this.pokemonak = new ArrayList<>();
    }
    
    public void gehituPokemon(Pokemon pokemon) {
        if (pokemonak.size() < 2) {
            pokemonak.add(pokemon);
        } else {
            System.out.println("Ezin da gehitu Pokemon gehiago. Mugako 2 Pokemonak jadanik gehitu dira.");
        }
    }
    
    public Pokemon getPokemonAktiboa() {
        for (Pokemon p : pokemonak) {
            if (p.bizirikDago()) {
                return p;
            }
        }
        return null; // Ez dago Pokemon aktibo bizirik
    }
    
    public boolean bizirikDagoPokemon() {
        return getPokemonAktiboa() != null;
    }
    
    // Iterator moduan functzionatuko duen getter-a
    public Iterator<Pokemon> getPokemonak() {
        return pokemonak.iterator();
    }
    
    public int tamaina() {
        return pokemonak.size();
    }
}
