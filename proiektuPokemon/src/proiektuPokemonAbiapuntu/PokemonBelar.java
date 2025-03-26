package proiektuPokemonAbiapuntu;
//PokemonBelar klasea (Pokemon Hierba - Belar pokemona)
public class PokemonBelar extends Pokemon {
 
 public PokemonBelar(String izena, int bizitza, int erasoa, int defentsa) {
     super(izena, bizitza, erasoa, defentsa);
 }

 @Override
 public void setEkintzak() {
     ekintzak.add(new Ekintza("Hostokada", 80, "Belar"));
     ekintzak.add(new Ekintza("Loratze", 50, "Belar"));
     ekintzak.add(new Ekintza("Eguzki Izpia", 75, "Belar"));
     ekintzak.add(new Ekintza("Xurgapena", 60, "Belar"));
 }
 
 @Override
 public double kalkulatuKaltea(Ekintza ekintza, Pokemon etsaia) {
     double kaltea = super.kalkulatuKaltea(ekintza, etsaia);
     
     // Tipo abantailak
     if (etsaia instanceof PokemonUra) {
         kaltea *= 1.5; // Efektiboa uraren aurka
         System.out.println("Oso eraginkorra da!");
     } else if (etsaia instanceof PokemonSua) {
         kaltea *= 0.5; // Ez oso efektiboa suaren aurka
         System.out.println("Ez da oso eraginkorra...");
     }
     
     return kaltea;
 }
}
