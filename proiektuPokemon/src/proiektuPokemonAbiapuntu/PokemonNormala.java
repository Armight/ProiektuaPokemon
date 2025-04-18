package proiektuPokemonAbiapuntu;


public class PokemonNormala extends Pokemon{
	public PokemonNormala(String pIzena, int pBizitza,int pErasoa,int pDefentsa) {
		super(pIzena,pBizitza,pErasoa,pDefentsa);
		this.setEkintzak();
		
		
	}
	
	@Override
	
	public void setEkintzak() {
		EkintzaZerrenda ekintzak = getEkintzak();
		ekintzak.gehituEkintza(new Ekintza("Gorputzada",30,"Normala"));
		ekintzak.gehituEkintza(new Ekintza("Eraso-Bizkorra",40,"Normala"));
		ekintzak.gehituEkintza(new Ekintza("Oldartu",20,"Normala"));
		ekintzak.gehituEkintza(new Ekintza("Kolpe-Bikoitza",55,"Normala"));
		
	}

}
