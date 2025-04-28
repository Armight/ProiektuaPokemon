package proiektuPokemonAbiapuntu;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class EkintzaZerrendaTest {

    private EkintzaZerrenda ekintzaZerrenda;

    @Before
    public void setUp() throws Exception {
        ekintzaZerrenda = new EkintzaZerrenda();
    }

    @After
    public void tearDown() throws Exception {
        ekintzaZerrenda = null;
    }

    @Test
    public void testGehituEkintza() {
        Ekintza surf = new Ekintza("Surf", 30, "Ura");
        ekintzaZerrenda.gehituEkintza(surf);

        assertEquals(1, ekintzaZerrenda.tamaina());
        assertEquals(surf, ekintzaZerrenda.getEkintza(0));
    }

    @Test
    public void testGetEkintzaValidIndex() {
        Ekintza hidrobomba = new Ekintza("Hidrobomba", 50, "Ura");
        ekintzaZerrenda.gehituEkintza(hidrobomba);

        Ekintza result = ekintzaZerrenda.getEkintza(0);
        assertNotNull(result);
        assertEquals("Hidrobomba", result.getIzena());
        assertEquals(50, result.getIndarra());
        assertEquals("Ura", result.getMota());
    }

    @Test
    public void testGetEkintzaInvalidIndex() {
        Ekintza result = ekintzaZerrenda.getEkintza(5); // índice inválido (lista vacía)
        assertNull(result);

        ekintzaZerrenda.gehituEkintza(new Ekintza("Aqua Jet", 40, "Ura"));
        result = ekintzaZerrenda.getEkintza(-1); // índice negativo
        assertNull(result);

        result = ekintzaZerrenda.getEkintza(2); // índice fuera de rango
        assertNull(result);
    }

    @Test
    public void testGetEkintzak() {
        Ekintza e1 = new Ekintza("Surf", 30, "Ura");
        Ekintza e2 = new Ekintza("Aqua Jet", 40, "Ura");

        ekintzaZerrenda.gehituEkintza(e1);
        ekintzaZerrenda.gehituEkintza(e2);

        ArrayList<Ekintza> lista = ekintzaZerrenda.getEkintzak();
        assertEquals(2, lista.size());
        assertEquals(e1, lista.get(0));
        assertEquals(e2, lista.get(1));
    }

    @Test
    public void testTamaina() {
        assertEquals(0, ekintzaZerrenda.tamaina());

        ekintzaZerrenda.gehituEkintza(new Ekintza("Surf", 30, "Ura"));
        assertEquals(1, ekintzaZerrenda.tamaina());

        ekintzaZerrenda.gehituEkintza(new Ekintza("Aqua Jet", 40, "Ura"));
        assertEquals(2, ekintzaZerrenda.tamaina());
    }
}
