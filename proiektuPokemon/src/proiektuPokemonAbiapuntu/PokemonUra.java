package proiektuPokemonAbiapuntu;

import java.util.ArrayList;


public class PokemonUra extends Pokemon{
	public PokemonUra(String pIzena, int pBizitza,int pErasoa,int pDefentsa) {
		super(pIzena,pBizitza,pErasoa,pDefentsa);
		this.setEkintzak();
	}
	
	@Override
	
	public void setEkintzak() {
		ArrayList<Ekintza> ekintzak = getEkintzak();
		ekintzak.add(new Ekintza("Surf",30,"Ura"));
		ekintzak.add(new Ekintza("Aqua-Jet",40,"Ura"));
		ekintzak.add(new Ekintza("Ur-pistola",20,"Ura"));
		ekintzak.add(new Ekintza("Hidrobomba",50,"Ura"));
		
	}
	@Override
	protected double kalkulatuKaltea(Ekintza pEkintza, Pokemon etsaia) {
		double kaltea = super.kalkulatuKaltea(pEkintza, etsaia);
	
		if (etsaia instanceof PokemonSua) {
			kaltea = kaltea * 1.5;
			System.out.println("Eraginkorra da!");
		}
		else if (etsaia instanceof PokemonBelar) {
			kaltea= kaltea * 0.5;
			System.out.println("Ez da hain eraginkorra...");
		}
		
		return kaltea;
	
}

}