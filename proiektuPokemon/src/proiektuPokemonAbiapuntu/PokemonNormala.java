package proiektuPokemonAbiapuntu;
//PokemonNormala klasea (Pokemon Normal - Pokemon normala)
public class PokemonNormala extends Pokemon {
 
 public PokemonNormala(String izena, int bizitza, int erasoa, int defentsa) {
     super(izena, bizitza, erasoa, defentsa);
 }

 @Override
 public void setEkintzak() {
     ekintzak.add(new Ekintza("Gorputzada", 70, "Normala"));
     ekintzak.add(new Ekintza("Oldartu", 50, "Normala"));
     ekintzak.add(new Ekintza("Eraso Bizkorra", 40, "Normala"));
     ekintzak.add(new Ekintza("Kolpe Bikoitza", 60, "Normala"));
 }
 
 // Pokemon normalak ez du abantaila edo desabantaila tiporik
}
