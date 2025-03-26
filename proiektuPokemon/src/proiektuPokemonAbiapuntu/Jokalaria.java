package proiektuPokemonAbiapuntu;
//Jokalaria klasea (Entrenatzailea)
public class Jokalaria {
 private String izena;
 private PokemonZerrenda taldea;
 
 public Jokalaria(String izena) {
     this.izena = izena;
     this.taldea = new PokemonZerrenda();
 }
 
 public void gehituPokemon(Pokemon pokemon) {
     taldea.gehituPokemon(pokemon);
 }
 
 public boolean bizirikDagoPokemon() {
     return taldea.bizirikDagoPokemon();
 }
 
 public Pokemon getPokemonAktiboa() {
     return taldea.getPokemonAktiboa();
 }
 
 public String getIzena() {
     return izena;
 }
 
 public PokemonZerrenda getTaldea() {
     return taldea;
 }
}
