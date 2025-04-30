import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class JokalariaTest {

    private Jokalaria jokalaria;

    @Before
    public void setUp() {
        jokalaria = new Jokalaria("Ash");
    }

    // === TEST: gehituPokemon(Pokemon) === 
    @Test
    public void testGehituPokemon() {
        Pokemon pikachu = new Pokemon("Pikachu", 100);
        jokalaria.gehituPokemon(pikachu);
        assertEquals(1, jokalaria.getTaldea().tamaina());
    }

    // === TEST: bizirikDagoPokemon() ===
    @Test
    public void testBizirikDagoPokemon_Bai() {
        Pokemon pikachu = new Pokemon("Pikachu", 100);
        jokalaria.gehituPokemon(pikachu);
        assertTrue(jokalaria.bizirikDagoPokemon());
    }

    @Test
    public void testBizirikDagoPokemon_Ez() {
        Pokemon pikachu = new Pokemon("Pikachu", 0);
        jokalaria.gehituPokemon(pikachu);
        assertFalse(jokalaria.bizirikDagoPokemon());
    }

    // === TEST: getTaldea() ===
    @Test
    public void testGetTaldea_EskuratuTaldeaZuzen() {
        Pokemon pikachu = new Pokemon("Pikachu", 100);
        Pokemon charmander = new Pokemon("Charmander", 80);

        jokalaria.gehituPokemon(pikachu);
        jokalaria.gehituPokemon(charmander);

        PokemonZerrenda taldea = jokalaria.getTaldea();
        assertNotNull(taldea);
        assertEquals(2, taldea.tamaina());

        Iterator<Pokemon> it = taldea.getPokemonak();
        assertTrue(it.hasNext());
        assertEquals("Pikachu", it.next().getIzena());
        assertTrue(it.hasNext());
        assertEquals("Charmander", it.next().getIzena());
    }

    // === TEST: getPokemonAktiboa() ===
    @Test
    public void testGetPokemonAktiboa_BatBizirik() {
        Pokemon pikachu = new Pokemon("Pikachu", 100);
        jokalaria.gehituPokemon(pikachu);
        assertEquals("Pikachu", jokalaria.getPokemonAktiboa().getIzena());
    }

    @Test
    public void testGetPokemonAktiboa_LehenHilda_BigarrenaBizirik() {
        jokalaria.gehituPokemon(new Pokemon("Pikachu", 0));
        jokalaria.gehituPokemon(new Pokemon("Bulbasaur", 50));
        assertEquals("Bulbasaur", jokalaria.getPokemonAktiboa().getIzena());
    }

    @Test
    public void testGetPokemonAktiboa_EzDagoPokemonik_JaurtiErrorea() {
        try {
            jokalaria.getPokemonAktiboa();
            fail("Espero zen IllegalStateException jaurtitzea.");
        } catch (IllegalStateException e) {
            assertEquals("Ez dago Pokémon aktiborik taldean.", e.getMessage());
        }
    }

    @Test
    public void testGetPokemonAktiboa_GuztiakHilda_JaurtiErrorea() {
        jokalaria.gehituPokemon(new Pokemon("Charmander", 0));
        jokalaria.gehituPokemon(new Pokemon("Squirtle", 0));
        try {
            jokalaria.getPokemonAktiboa();
            fail("Espero zen IllegalStateException jaurtitzea.");
        } catch (IllegalStateException e) {
            assertEquals("Ez dago Pokémon aktiborik taldean.", e.getMessage());
        }
    }

    // === TEST: getIzena() ===
    @Test
    public void testGetIzena() {
        assertEquals("Ash", jokalaria.getIzena());
    }

    // === TEST: Jokalaria izen hutsarekin ===
    @Test
    public void testJokalariaIzenaHutsik() {
        try {
            new Jokalaria("");
            fail("Espero zen IllegalArgumentException jaurtitzea.");
        } catch (IllegalArgumentException e) {
            assertEquals("Jokalariaren izena ezin da hutsik egon.", e.getMessage());
        }
    }


    // === TEST: gehituPokemon(null) ===
    @Test
    public void testGehituPokemonNull() {
        try {
            jokalaria.gehituPokemon(null);
            fail("Espero zen IllegalArgumentException jaurtitzea.");
        } catch (IllegalArgumentException e) {
            assertEquals("Ezin da null den Pokémona gehitu.", e.getMessage());
        }
    }
}
