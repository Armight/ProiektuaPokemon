package proiektuPokemonAbiapuntu;
public class Main {
    public static void main(String[] args) {
        System.out.println("============================");
        System.out.println("=== POKEMON BORROKA JOKOA ===");
        System.out.println("============================\n");
        
        // Obtener instancia del teclado
        Teklatua teklatua = Teklatua.getTeklatua();
        
        // Entrenatzaileen izenak sartu
        System.out.print("Sartu lehen entrenatzailearen izena: ");
        String izena1 = teklatua.irakurriString();
        Jokalaria j1 = new Jokalaria(izena1);
        
        System.out.print("Sartu bigarren entrenatzailearen izena: ");
        String izena2 = teklatua.irakurriString();
        Jokalaria j2 = new Jokalaria(izena2);
        
        // 1. Jokalaria - Pokemonak aukeratu
        System.out.println("\n=== " + izena1 + ", aukeratu zure Pokemonak ===");
        aukeratuPokemonak(j1);
        
        // 2. Jokalaria - Pokemonak aukeratu
        System.out.println("\n=== " + izena2 + ", aukeratu zure Pokemonak ===");
        aukeratuPokemonak(j2);
        
        // Borroka hasi
        Borroka borroka = Borroka.getEMA();
        borroka.setJokalariak(j1, j2);
        borroka.partidaBatJolastu();
        
        // Cerrar el teclado al final del programa
        teklatua.itxi();
    }
    
    private static void aukeratuPokemonak(Jokalaria jokalaria) {
        boolean[] aukeratutakoMotak = new boolean[5]; // 1-4 indizeak erabiltzeko
        Teklatua teklatua = Teklatua.getTeklatua();
        
        for (int i = 0; i < 2; i++) { // 2 Pokemon bakarrik
            System.out.println("\nAukeratu " + (i+1) + ". Pokemon mota:");
            
            // Erakutsi eskuragarri dauden motak bakarrik
            if (!aukeratutakoMotak[1]) System.out.println("1. Suzko Pokemon");
            if (!aukeratutakoMotak[2]) System.out.println("2. Ur Pokemon");
            if (!aukeratutakoMotak[3]) System.out.println("3. Belar Pokemon");
            if (!aukeratutakoMotak[4]) System.out.println("4. Pokemon Normala");
            
            int mota;
            do {
                mota = teklatua.irakurriInt("Hautatu Pokemon mota (1-4): ", 1, 4);
                if (aukeratutakoMotak[mota]) {
                    System.out.println("Jada badaukazu mota horretako Pokemon bat. Aukeratu beste mota bat.");
                }
            } while (aukeratutakoMotak[mota]);
            
            // Markatu mota hau aukeratuta bezala
            aukeratutakoMotak[mota] = true;
            
            System.out.print("Sartu Pokemonaren izena: ");
            String izena = teklatua.irakurriString();
            
            // Pokemon bakoitzarentzako ausazko balio desberdina
            int bizitza = 100; 
            int erasoa = 50; 
            int defentsa = 60; 
            
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
}
