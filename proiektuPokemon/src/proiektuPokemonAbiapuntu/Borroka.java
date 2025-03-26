package proiektuPokemonAbiapuntu;
import java.util.List;
import java.util.Scanner;

// Borroka klasea (Batalla - Borrokak kudeatzen ditu)
public class Borroka {
    private Jokalaria j1;
    private Jokalaria j2;
    private Scanner scanner;
    
    public Borroka(Jokalaria j1, Jokalaria j2) {
        this.j1 = j1;
        this.j2 = j2;
        this.scanner = new Scanner(System.in);
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
    }
    
    private void eginTxanda(Pokemon erasotzailea, Pokemon defendatzailea) {
        System.out.println("\n" + erasotzailea.getIzena() + "ren txanda");
        Pokemon.Ekintza aukeratutakoEkintza = aukeratuEkintza(erasotzailea);
        erasotzailea.erasotu(defendatzailea, aukeratutakoEkintza);
    }
    
    private Pokemon.Ekintza aukeratuEkintza(Pokemon pokemon) {
        List<Pokemon.Ekintza> ekintzak = pokemon.getEkintzak();
        System.out.println("Aukeratu ekintza:");
        
        for (int i = 0; i < ekintzak.size(); i++) {
            Pokemon.Ekintza ekintza = ekintzak.get(i);
            System.out.println((i + 1) + ". " + ekintza.getIzena() + 
                               " [Indarra: " + ekintza.getIndarra() + ", Mota: " + ekintza.getMota() + "]");
        }
        
        int aukera = 1; // Default to first attack if input fails
        
        try {
            do {
                System.out.print("Hautatu zenbakia (1-" + ekintzak.size() + "): ");
                
                if (scanner.hasNextInt()) {
                    aukera = scanner.nextInt();
                    if (scanner.hasNextLine()) {
                        scanner.nextLine(); // Buffer garbitu
                    }
                    
                    if (aukera < 1 || aukera > ekintzak.size()) {
                        System.out.println("Zenbaki okerra. Mesedez, sartu 1 eta " + ekintzak.size() + " arteko zenbaki bat.");
                    }
                } else {
                    if (scanner.hasNextLine()) {
                        scanner.nextLine(); // Skip invalid input
                    }
                    System.out.println("Zenbaki okerra. Lehen ekintza hautatzen.");
                    aukera = 1; // Default to first attack
                    break;
                }
            } while (aukera < 1 || aukera > ekintzak.size());
        } catch (Exception e) {
            System.out.println("Errorea sarreran. Lehen ekintza hautatzen: " + ekintzak.get(0).getIzena());
            aukera = 1; // Default to first attack on error
        }
        
        return ekintzak.get(aukera - 1);
    }
}
