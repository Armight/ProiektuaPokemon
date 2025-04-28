package proiektuPokemonAbiapuntu;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PokemonUraTest {

    private PokemonUra squirtle;

    @Before
    public void setUp() throws Exception {
        squirtle = new PokemonUra("Squirtle", 100, 60, 50);
    }

    @After
    public void tearDown() throws Exception {
        squirtle = null;
    }

    @Test
    public void testSetEkintzak() {
        assertEquals(4, squirtle.getEkintzak().tamaina());

        assertEquals("Surf", squirtle.getEkintzak().getEkintza(0).getIzena());
        assertEquals("Aqua-Jet", squirtle.getEkintzak().getEkintza(1).getIzena());
        assertEquals("Ur-pistola", squirtle.getEkintzak().getEkintza(2).getIzena());
        assertEquals("Hidrobomba", squirtle.getEkintzak().getEkintza(3).getIzena());
    }

    @Test
    public void testKalkulatuKalteaKontraPokemonSua() {
        PokemonSua charmander = new PokemonSua("Charmander", 90, 55, 45);
        Ekintza surf = squirtle.getEkintzak().getEkintza(0);

        double kaltea = squirtle.kalkulatuKaltea(surf, charmander);

        double kalteBase = (surf.getIndarra() * 60) / 45.0;
        assertEquals(kalteBase * 1.5, kaltea, 0.01);
    }

    @Test
    public void testKalkulatuKalteaKontraPokemonBelar() {
        PokemonBelar bulbasaur = new PokemonBelar("Bulbasaur", 95, 50, 40);
        Ekintza surf = squirtle.getEkintzak().getEkintza(0);

        double kaltea = squirtle.kalkulatuKaltea(surf, bulbasaur);

        double kalteBase = (surf.getIndarra() * 60) / 40.0;
        assertEquals(kalteBase * 0.5, kaltea, 0.01);
    }

    @Test
    public void testKalkulatuKalteaKontraPokemonNormala() {
        PokemonNormala snorlax = new PokemonNormala("Snorlax", 200, 70, 60);
        Ekintza surf = squirtle.getEkintzak().getEkintza(0);

        double kaltea = squirtle.kalkulatuKaltea(surf, snorlax);

        double kalteBase = (surf.getIndarra() * 60) / 60.0;
        assertEquals(kalteBase, kaltea, 0.01);
    }
}
