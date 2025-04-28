package proiektuPokemonAbiapuntu;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PokemonNormalaTest {

    private PokemonNormala snorlax;

    @Before
    public void setUp() throws Exception {
        snorlax = new PokemonNormala("Snorlax", 200, 70, 60);
    }

    @After
    public void tearDown() throws Exception {
        snorlax = null;
    }

    @Test
    public void testSetEkintzak() {
        assertEquals(4, snorlax.getEkintzak().tamaina());

        assertEquals("Gorputzada", snorlax.getEkintzak().getEkintza(0).getIzena());
        assertEquals("Eraso-Bizkorra", snorlax.getEkintzak().getEkintza(1).getIzena());
        assertEquals("Oldartu", snorlax.getEkintzak().getEkintza(2).getIzena());
        assertEquals("Kolpe-Bikoitza", snorlax.getEkintzak().getEkintza(3).getIzena());
    }

    @Test
    public void testKalkulatuKalteaKontraPokemonNormala() {
        PokemonNormala pidgey = new PokemonNormala("Pidgey", 80, 40, 30);
        Ekintza gorputzada = snorlax.getEkintzak().getEkintza(0);

        double kaltea = snorlax.kalkulatuKaltea(gorputzada, pidgey);

        double kalteBase = (gorputzada.getIndarra() * 70) / 30.0;
        assertEquals(kalteBase, kaltea, 0.01);
    }
}
