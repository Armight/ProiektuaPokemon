package proiektuPokemonAbiapuntu;

import java.util.ArrayList;


public class PokemonNormala extends Pokemon{
	public PokemonNormala(String pIzena, int pBizitza,int pErasoa,int pDefentsa) {
		super(pIzena,pBizitza,pErasoa,pDefentsa);
		this.setEkintzak();
		
		
	}
	
	@Override
	
	public void setEkintzak() {
		ArrayList<Ekintza> ekintzak = getEkintzak();
		ekintzak.add(new Ekintza("Gorputzada",30,"Normala"));
		ekintzak.add(new Ekintza("Eraso-Bizkorra",40,"Normala"));
		ekintzak.add(new Ekintza("Oldartu",20,"Normala"));
		ekintzak.add(new Ekintza("Kolpe-Bikoitza",55,"Normala"));
		
	}

}
