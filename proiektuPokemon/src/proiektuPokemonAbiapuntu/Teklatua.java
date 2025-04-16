package proiektuPokemonAbiapuntu;
import java.util.Scanner;

public class Teklatua {
    
    private static Teklatua nireTeklatua = null;
    
    private Scanner scanner;

    private Teklatua() {
        scanner = new Scanner(System.in);
    }
    

    public static Teklatua getTeklatua() {
        if (nireTeklatua == null) {
            nireTeklatua = new Teklatua();
        }
        return nireTeklatua;
    }
    

    public String irakurriString() {
        return scanner.nextLine();
    }
    

    public int irakurriInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Mesedez, sartu zenbaki bat.");
            scanner.next(); // kontsumitzen du sarrera okerra
        }
        int zenbakia = scanner.nextInt();
        scanner.nextLine();
        return zenbakia;
    }
    
    public int irakurriInt(String mezua, int min, int max) {
        int aukera;
        do {
            System.out.print(mezua);
            aukera = irakurriInt();
            
            if (aukera < min || aukera > max) {
                System.out.println("Zenbaki okerra. Mesedez, sartu " + min + " eta " + max + " arteko zenbaki bat.");
            }
        } while (aukera < min || aukera > max);
        
        return aukera;
    }
    
    public void itxi() {
        scanner.close();
    }
}