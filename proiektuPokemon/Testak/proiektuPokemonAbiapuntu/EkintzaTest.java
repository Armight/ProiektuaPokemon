package proiektuPokemonAbiapuntu;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EkintzaTest {

	private Ekintza erasoa;
	
	@Before
    public void setUp() throws Exception {
        erasoa = new Ekintza("Hidrobomba", 85,"Ura");
    }

    @After
    public void tearDown() throws Exception {
        erasoa = null;
    }
    
	@Test
	public void testEkintza() {
		assertEquals("Hidrobomba", erasoa.getIzena());
		assertEquals(85, erasoa.getIndarra());
		assertEquals("Ura", erasoa.getMota());
		
	}

	@Test
	public void testGetIzena() {
		assertEquals("Hidrobomba", erasoa.getIzena());
	}

	@Test
	public void testGetIndarra() {
		assertEquals(85, erasoa.getIndarra());
	}

	@Test
	public void testGetMota() {
		assertEquals("Ura", erasoa.getMota());
	}

}
