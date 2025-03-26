package proiektuPokemonAbiapuntu;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("============================");
        System.out.println("=== POKEMON BORROKA JOKOA ===");
        System.out.println("============================\n");
        
        // Entrenatzaileen izenak sartu
        System.out.print("Sartu lehen entrenatzailearen izena: ");
        String izena1 = scanner.nextLine();
        Jokalaria j1 = new Jokalaria(izena1);
        
        System.out.print("Sartu bigarren entrenatzailearen izena: ");
        String izena2 = scanner.nextLine();
        Jokalaria j2 = new Jokalaria(izena2);
        
        // 1. Jokalaria - Pokemonak aukeratu
        System.out.println("\n=== " + izena1 + ", aukeratu zure Pokemonak ===");
        aukeratuPokemonak(j1, scanner);
        
        // 2. Jokalaria - Pokemonak aukeratu
        System.out.println("\n=== " + izena2 + ", aukeratu zure Pokemonak ===");
        aukeratuPokemonak(j2, scanner);
        
        // Borroka hasi
        Borroka borroka = new Borroka(j1, j2);
        borroka.partidaBatJolastu();
        
        scanner.close();
    }
    
    private static void aukeratuPokemonak(Jokalaria jokalaria, Scanner scanner) {
        boolean[] aukeratutakoMotak = new boolean[5]; // 1-4 indizeak erabiltzeko
        
        for (int i = 0; i < 2; i++) { // 2 Pokemon bakarrik
            System.out.println("\nAukeratu " + (i+1) + ". Pokemon mota:");
            
            // Erakutsi eskuragarri dauden motak bakarrik
            if (!aukeratutakoMotak[1]) System.out.println("1. Suzko Pokemon");
            if (!aukeratutakoMotak[2]) System.out.println("2. Ur Pokemon");
            if (!aukeratutakoMotak[3]) System.out.println("3. Belar Pokemon");
            if (!aukeratutakoMotak[4]) System.out.println("4. Pokemon Normala");
            
            int mota;
            do {
                mota = aukeratuZenbakia(scanner, 1, 4, "Hautatu Pokemon mota (1-4): ");
                if (aukeratutakoMotak[mota]) {
                    System.out.println("Jada badaukazu mota horretako Pokemon bat. Aukeratu beste mota bat.");
                }
            } while (aukeratutakoMotak[mota]);
            
            // Markatu mota hau aukeratuta bezala
            aukeratutakoMotak[mota] = true;
            
            System.out.print("Sartu Pokemonaren izena: ");
            String izena = scanner.nextLine();
            
            // Pokemon bakoitzarentzako ausazko balio desberdina
            int bizitza = 80 + (int)(Math.random() * 40); // 80-120 artean
            int erasoa = 50 + (int)(Math.random() * 30); // 50-80 artean
            int defentsa = 40 + (int)(Math.random() * 20); // 40-60 artean
            
            Pokemon pokemon = null;
            switch (mota) {
                case 1:
                    pokemon = new PokemonSua(izena, bizitza, erasoa, defentsa);
                    break;
                case 2:
                    pokemon = new PokemonUra(izena, bizitza, erasoa, defentsa);
                    break;
                case 3:
                    pokemon = new PokemonBelar(izena, bizitza, erasoa, defentsa);
                    break;
                case 4:
                    pokemon = new PokemonNormala(izena, bizitza, erasoa, defentsa);
                    break;
            }
            
            jokalaria.gehituPokemon(pokemon);
            System.out.println(izena + " gehitu da zure taldera! [HP: " + bizitza + 
                               ", Erasoa: " + erasoa + ", Defentsa: " + defentsa + "]");
        }
    }
    
    private static int aukeratuZenbakia(Scanner scanner, int min, int max, String mezua) {
        int aukera;
        do {
            System.out.print(mezua);
            while (!scanner.hasNextInt()) {
                System.out.println("Mesedez, sartu zenbaki bat.");
                scanner.next(); // kontsumitzen du sarrera okerra
                System.out.print(mezua);
            }
            aukera = scanner.nextInt();
            scanner.nextLine(); // buffer garbitu
            
            if (aukera < min || aukera > max) {
                System.out.println("Zenbaki okerra. Mesedez, sartu " + min + " eta " + max + " arteko zenbaki bat.");
            }
        } while (aukera < min || aukera > max);
        
        return aukera;
    }
}
