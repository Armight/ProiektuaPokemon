package proiektuPokemonAbiapuntu;


public class PokemonSua extends Pokemon{
	public PokemonSua(String pIzena, int pBizitza,int pErasoa,int pDefentsa) {
		super(pIzena,pBizitza,pErasoa,pDefentsa);
		this.setEkintzak();
		
	}
	
	@Override
	
	public void setEkintzak() {
		EkintzaZerrenda ekintzak = getEkintzak();
		ekintzak.gehituEkintza(new Ekintza("Sugarrada",50,"Sua"));
		ekintzak.gehituEkintza(new Ekintza("Su-ukabilkada",25,"Sua"));
		ekintzak.gehituEkintza(new Ekintza("Bero-kolpea",30,"Sua"));
		ekintzak.gehituEkintza(new Ekintza("Nitrokarga",40,"Sua"));
		
	}
	@Override
	protected double kalkulatuKaltea(Ekintza pEkintza, Pokemon etsaia) {
		double kaltea = super.kalkulatuKaltea(pEkintza, etsaia);
	
		if (etsaia instanceof PokemonBelar) {
			kaltea = kaltea * 1.5;
			System.out.println("Eraginkorra da!");
		}
		else if (etsaia instanceof PokemonUra) {
			kaltea= kaltea * 0.5;
			System.out.println("Ez da hain eraginkorra...");
		}
		
		return kaltea;
	
}

}

