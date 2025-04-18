package proiektuPokemonAbiapuntu;



public class PokemonUra extends Pokemon{
	public PokemonUra(String pIzena, int pBizitza,int pErasoa,int pDefentsa) {
		super(pIzena,pBizitza,pErasoa,pDefentsa);
		this.setEkintzak();
	}
	
	@Override
	
	public void setEkintzak() {
		EkintzaZerrenda ekintzak = getEkintzak();
		ekintzak.gehituEkintza(new Ekintza("Surf",30,"Ura"));
		ekintzak.gehituEkintza(new Ekintza("Aqua-Jet",40,"Ura"));
		ekintzak.gehituEkintza(new Ekintza("Ur-pistola",20,"Ura"));
		ekintzak.gehituEkintza(new Ekintza("Hidrobomba",50,"Ura"));
		
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