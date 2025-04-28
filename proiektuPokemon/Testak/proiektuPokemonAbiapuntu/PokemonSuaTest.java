package proiektuPokemonAbiapuntu;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PokemonSuaTest {

    private PokemonSua charmander;

    @Before
    public void setUp() throws Exception {
        charmander = new PokemonSua("Charmander", 90, 55, 45);
    }

    @After
    public void tearDown() throws Exception {
        charmander = null;
    }

    @Test
    public void testSetEkintzak() {
        assertEquals(4, charmander.getEkintzak().tamaina());

        assertEquals("Sugarrada", charmander.getEkintzak().getEkintza(0).getIzena());
        assertEquals("Su-ukabilkada", charmander.getEkintzak().getEkintza(1).getIzena());
        assertEquals("Bero-kolpea", charmander.getEkintzak().getEkintza(2).getIzena());
        assertEquals("Nitrokarga", charmander.getEkintzak().getEkintza(3).getIzena());
    }

    @Test
    public void testKalkulatuKalteaKontraPokemonBelar() {
        PokemonBelar bulbasaur = new PokemonBelar("Bulbasaur", 95, 50, 40);
        Ekintza sugarrada = charmander.getEkintzak().getEkintza(0);

        double kaltea = charmander.kalkulatuKaltea(sugarrada, bulbasaur);

        double kalteBase = (sugarrada.getIndarra() * 55) / 40.0;
        assertEquals(kalteBase * 1.5, kaltea, 0.01);
    }

    @Test
    public void testKalkulatuKalteaKontraPokemonUra() {
        PokemonUra squirtle = new PokemonUra("Squirtle", 100, 60, 50);
        Ekintza sugarrada = charmander.getEkintzak().getEkintza(0);

        double kaltea = charmander.kalkulatuKaltea(sugarrada, squirtle);

        double kalteBase = (sugarrada.getIndarra() * 55) / 50.0;
        assertEquals(kalteBase * 0.5, kaltea, 0.01);
    }

    @Test
    public void testKalkulatuKalteaKontraPokemonNormala() {
        PokemonNormala snorlax = new PokemonNormala("Snorlax", 200, 70, 60);
        Ekintza sugarrada = charmander.getEkintzak().getEkintza(0);

        double kaltea = charmander.kalkulatuKaltea(sugarrada, snorlax);

        double kalteBase = (sugarrada.getIndarra() * 55) / 60.0;
        assertEquals(kalteBase, kaltea, 0.01);
    }
}
