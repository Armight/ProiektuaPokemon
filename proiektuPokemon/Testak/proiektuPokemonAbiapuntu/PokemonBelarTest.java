package proiektuPokemonAbiapuntu;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PokemonBelarTest {

    private PokemonBelar bulbasaur;

    @Before
    public void setUp() throws Exception {
        bulbasaur = new PokemonBelar("Bulbasaur", 95, 50, 40);
    }

    @After
    public void tearDown() throws Exception {
        bulbasaur = null;
    }

    @Test
    public void testSetEkintzak() {
        assertEquals(4, bulbasaur.getEkintzak().tamaina());

        assertEquals("Hostokada", bulbasaur.getEkintzak().getEkintza(0).getIzena());
        assertEquals("Loratze", bulbasaur.getEkintzak().getEkintza(1).getIzena());
        assertEquals("Eguzki Izpia", bulbasaur.getEkintzak().getEkintza(2).getIzena());
        assertEquals("Xurgapena", bulbasaur.getEkintzak().getEkintza(3).getIzena());
    }

    @Test
    public void testKalkulatuKalteaKontraPokemonUra() {
        PokemonUra squirtle = new PokemonUra("Squirtle", 100, 60, 50);
        Ekintza hostokada = bulbasaur.getEkintzak().getEkintza(0);

        double kaltea = bulbasaur.kalkulatuKaltea(hostokada, squirtle);

        double kalteBase = (hostokada.getIndarra() * 50) / 50.0;
        assertEquals(kalteBase * 1.5, kaltea, 0.01);
    }

    @Test
    public void testKalkulatuKalteaKontraPokemonSua() {
        PokemonSua charmander = new PokemonSua("Charmander", 90, 55, 45);
        Ekintza hostokada = bulbasaur.getEkintzak().getEkintza(0);

        double kaltea = bulbasaur.kalkulatuKaltea(hostokada, charmander);

        double kalteBase = (hostokada.getIndarra() * 50) / 45.0;
        assertEquals(kalteBase * 0.5, kaltea, 0.01);
    }

    @Test
    public void testKalkulatuKalteaKontraPokemonNormala() {
        PokemonNormala snorlax = new PokemonNormala("Snorlax", 200, 70, 60);
        Ekintza hostokada = bulbasaur.getEkintzak().getEkintza(0);

        double kaltea = bulbasaur.kalkulatuKaltea(hostokada, snorlax);

        double kalteBase = (hostokada.getIndarra() * 50) / 60.0;
        assertEquals(kalteBase, kaltea, 0.01);
    }
}
