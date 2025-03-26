package proiektuPokemonAbiapuntu;
//PokemonSua klasea (Pokemon Fuego - Suzko pokemona)
public class PokemonSua extends Pokemon {
 
 public PokemonSua(String izena, int bizitza, int erasoa, int defentsa) {
     super(izena, bizitza, erasoa, defentsa);
 }

 @Override
 public void setEkintzak() {
     ekintzak.add(new Ekintza("Sugarrada", 90, "Sua"));
     ekintzak.add(new Ekintza("Txingar", 40, "Sua"));
     ekintzak.add(new Ekintza("Su Bira", 60, "Sua"));
     ekintzak.add(new Ekintza("Su-izpiak", 75, "Sua"));
 }
 
 @Override
 public double kalkulatuKaltea(Ekintza ekintza, Pokemon etsaia) {
     double kaltea = super.kalkulatuKaltea(ekintza, etsaia);
     
     // Tipo abantailak
     if (etsaia instanceof PokemonBelar) {
         kaltea *= 1.5; // Efektiboa belarraren aurka
         System.out.println("Oso eraginkorra da!");
     } else if (etsaia instanceof PokemonUra) {
         kaltea *= 0.5; // Ez oso efektiboa uraren aurka
         System.out.println("Ez da oso eraginkorra...");
     }
     
     return kaltea;
 }
}
