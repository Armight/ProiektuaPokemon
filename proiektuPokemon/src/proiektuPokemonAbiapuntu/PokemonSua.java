package proiektuPokemonAbiapuntu;

public class PokemonSua extends Pokemon{
	public PokemonSua(String pIzena, int pBizitza,int pErasoa,int pDefentsa) {
		super(pIzena,pBizitza,pErasoa,pDefentsa);
		
	}
	
	@Override
	
	public void setEkintzak() {
		ekintzak.add(new Ekintza("Sugarrada",50,"Sua"));
		ekintzak.add(new Ekintza("Su-ukabilkada",25,"Sua"));
		ekintzak.add(new Ekintza("Bero-kolpea",30,"Sua"));
		ekintzak.add(new Ekintza("Nitrokarga",40,"Sua"));
		
	}
	@Override
	public double kalkulatuKaltea(Ekintza pEkintza, Pokemon etsaia) {
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

