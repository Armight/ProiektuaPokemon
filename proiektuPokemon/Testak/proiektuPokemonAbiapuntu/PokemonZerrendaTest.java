package proiektuPokemonAbiapuntu;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class PokemonZerrendaTest {

    private PokemonZerrenda zerrenda;

    @Before
    public void setUp() throws Exception {
        zerrenda = new PokemonZerrenda();
    }

    @After
    public void tearDown() throws Exception {
        zerrenda = null;
    }

    @Test
    public void testGehituPokemon() {
        Pokemon pikachu = new PokemonNormala("Pikachu", 100, 50, 40);
        Pokemon bulbasaur = new PokemonBelar("Bulbasaur", 100, 45, 35);
        Pokemon charmander = new PokemonSua("Charmander", 100, 55, 30);

        zerrenda.gehituPokemon(pikachu);
        assertEquals(1, zerrenda.tamaina());

        zerrenda.gehituPokemon(bulbasaur);
        assertEquals(2, zerrenda.tamaina());

        // Intentar añadir un tercer Pokémon no debe cambiar el tamaño
        zerrenda.gehituPokemon(charmander);
        assertEquals(2, zerrenda.tamaina());
    }

    @Test
    public void testGetPokemonAktiboa() {
        Pokemon pikachu = new PokemonNormala("Pikachu", 100, 50, 40);
        Pokemon bulbasaur = new PokemonBelar("Bulbasaur", 0, 45, 35); // Muerto (HP = 0)

        zerrenda.gehituPokemon(pikachu);
        zerrenda.gehituPokemon(bulbasaur);

        // Pikachu está vivo, debe ser el activo
        assertEquals(pikachu, zerrenda.getPokemonAktiboa());

        // Si Pikachu muere...
        pikachu.jasoErasoa(200); // suficiente para matarlo
        assertNull(zerrenda.getPokemonAktiboa());
    }

    @Test
    public void testBizirikDagoPokemon() {
        Pokemon pikachu = new PokemonNormala("Pikachu", 100, 50, 40);

        zerrenda.gehituPokemon(pikachu);
        assertTrue(zerrenda.bizirikDagoPokemon());

        pikachu.jasoErasoa(200);
        assertFalse(zerrenda.bizirikDagoPokemon());
    }

    @Test
    public void testGetPokemonakIterator() {
        Pokemon pikachu = new PokemonNormala("Pikachu", 100, 50, 40);
        Pokemon bulbasaur = new PokemonBelar("Bulbasaur", 100, 45, 35);

        zerrenda.gehituPokemon(pikachu);
        zerrenda.gehituPokemon(bulbasaur);

        Iterator<Pokemon> it = zerrenda.getPokemonak();
        assertTrue(it.hasNext());
        assertEquals(pikachu, it.next());
        assertTrue(it.hasNext());
        assertEquals(bulbasaur, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    public void testTamaina() {
        assertEquals(0, zerrenda.tamaina());

        Pokemon pikachu = new PokemonNormala("Pikachu", 100, 50, 40);
        zerrenda.gehituPokemon(pikachu);
        assertEquals(1, zerrenda.tamaina());

        Pokemon bulbasaur = new PokemonBelar("Bulbasaur", 100, 45, 35);
        zerrenda.gehituPokemon(bulbasaur);
        assertEquals(2, zerrenda.tamaina());
    }
}
