package proiektuPokemonAbiapuntu;
import java.util.ArrayList;

//Borroka klasea (Batalla - Borrokak kudeatzen ditu)
public class Borroka {
	 private static Borroka nireEMA = null;
	 private Jokalaria j1;
	 private Jokalaria j2;
	 
 private Borroka() {
 }
 
 public static Borroka getEMA() { // Cambiado el nombre del método
     if (nireEMA == null) {
         nireEMA = new Borroka();
     }
     return nireEMA;
 }
 
 public void setJokalariak(Jokalaria j1, Jokalaria j2) {
     this.j1 = j1;
     this.j2 = j2;
 }
 public void partidaBatJolastu() {
     System.out.println("\n=== BORROKA HASIERA ===");
     System.out.println(j1.getIzena() + " VS " + j2.getIzena());
     System.out.println("=======================\n");
     
     
     
     // Borrokaren begizta nagusia
     while (j1.bizirikDagoPokemon() && j2.bizirikDagoPokemon()) {
         Pokemon p1 = j1.getPokemonAktiboa();
         Pokemon p2 = j2.getPokemonAktiboa();
         
         System.out.println("\n" + j1.getIzena() + " erabiltzen ari da " + p1.getIzena() + 
             " [HP: " + p1.getBizitza() + "]");
         System.out.println(j2.getIzena() + " erabiltzen ari da " + p2.getIzena() + 
             " [HP: " + p2.getBizitza() + "]");
         
         // Lehen jokalariak erasotzen du
         eginTxanda(p1, p2);
         if (!p2.bizirikDago()) {
             System.out.println(p2.getIzena() + " garaitua izan da!");
             
             // Begiratu ea bigarren jokalariak Pokemon bizi gehiago dituen
             if (!j2.bizirikDagoPokemon()) {
                 System.out.println("\n" + j2.getIzena() + "ren Pokemon guztiak garaituak izan dira!");
                 break; // Amaitu borrokarena begizta
             }
             continue;
         }
         
         // Bigarren jokalariak erasotzen du
         eginTxanda(p2, p1);
         if (!p1.bizirikDago()) {
             System.out.println(p1.getIzena() + " garaitua izan da!");
             
             // Begiratu ea lehen jokalariak Pokemon bizi gehiago dituen
             if (!j1.bizirikDagoPokemon()) {
                 System.out.println("\n" + j1.getIzena() + "ren Pokemon guztiak garaituak izan dira!");
                 break; // Amaitu borrokarena begizta
             }
         }

     }
     // Irabazlea erakutsi
     String irabazlea = j1.bizirikDagoPokemon() ? j1.getIzena() : j2.getIzena();
     System.out.println("\n=== BORROKA AMAIERA ===");
     System.out.println("Irabazlea: " + irabazlea + "!");
     System.out.println("======================");
     
     nireEMA=null;
     
 }
 
 private void eginTxanda(Pokemon erasotzailea, Pokemon defendatzailea) {
     System.out.println("\n" + erasotzailea.getIzena() + "ren txanda");
     Ekintza aukeratutakoEkintza = aukeratuEkintza(erasotzailea);
     erasotzailea.erasotu(defendatzailea, aukeratutakoEkintza);
 }
 
 private Ekintza aukeratuEkintza(Pokemon pokemon) {
     ArrayList<Ekintza> ekintzak = pokemon.getEkintzak();
     System.out.println("Aukeratu ekintza:");
     
     for (int i = 0; i < ekintzak.size(); i++) {
         Ekintza ekintza = ekintzak.get(i);
         System.out.println((i + 1) + ". " + ekintza.getIzena() + 
                            " [Indarra: " + ekintza.getIndarra() + ", Mota: " + ekintza.getMota() + "]");
     }
     
     // Usa la instancia de Teklatua para leer la opción seleccionada
     Teklatua teklatua = Teklatua.getTeklatua();
     int aukera = teklatua.irakurriInt("Hautatu zenbakia (1-" + ekintzak.size() + "): ", 1, ekintzak.size());
     
     return ekintzak.get(aukera - 1);
 }
}
