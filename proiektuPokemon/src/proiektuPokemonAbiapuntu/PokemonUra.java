package proiektuPokemonAbiapuntu;
//PokemonUra klasea (Pokemon Agua - Ur pokemona)
public class PokemonUra extends Pokemon {
 
 public PokemonUra(String izena, int bizitza, int erasoa, int defentsa) {
     super(izena, bizitza, erasoa, defentsa);
 }

 @Override
 public void setEkintzak() {
     ekintzak.add(new Ekintza("Hidrobonba", 85, "Ura"));
     ekintzak.add(new Ekintza("Ur Pistola", 40, "Ura"));
     ekintzak.add(new Ekintza("Olatuak", 70, "Ura"));
     ekintzak.add(new Ekintza("Burbuila Izpia", 60, "Ura"));
 }
 
 @Override
 public double kalkulatuKaltea(Ekintza ekintza, Pokemon etsaia) {
     double kaltea = super.kalkulatuKaltea(ekintza, etsaia);
     
     // Tipo abantailak
     if (etsaia instanceof PokemonSua) {
         kaltea *= 1.5; // Efektiboa suaren aurka
         System.out.println("Oso eraginkorra da!");
     } else if (etsaia instanceof PokemonBelar) {
         kaltea *= 0.5; // Ez oso efektiboa belarraren aurka
         System.out.println("Ez da oso eraginkorra...");
     }
     
     return kaltea;
 }
}
