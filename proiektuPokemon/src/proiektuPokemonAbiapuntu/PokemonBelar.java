package proiektuPokemonAbiapuntu;

public class PokemonBelar extends Pokemon{
	public PokemonBelar(String pIzena, int pBizitza,int pErasoa,int pDefentsa) {
		super(pIzena,pBizitza,pErasoa,pDefentsa);
		this.setEkintzak();
		
	}
	
	@Override
	
	public void setEkintzak() {
		EkintzaZerrenda ekintzak = getEkintzak();
		ekintzak.gehituEkintza(new Ekintza("Hostokada",30,"Belar"));
		ekintzak.gehituEkintza(new Ekintza("Loratze",25,"Belar"));
		ekintzak.gehituEkintza(new Ekintza("Eguzki Izpia",50,"Belar"));
		ekintzak.gehituEkintza(new Ekintza("Xurgapena",40,"Belar"));
		
	}
	@Override
	protected double kalkulatuKaltea(Ekintza pEkintza, Pokemon etsaia) {
		double kaltea = super.kalkulatuKaltea(pEkintza, etsaia);
	
		if (etsaia instanceof PokemonUra) {
			kaltea = kaltea * 1.5;
			System.out.println("Eraginkorra da!");
		}
		else if (etsaia instanceof PokemonSua) {
			kaltea= kaltea * 0.5;
			System.out.println("Ez da hain eraginkorra...");
		}
		
		return kaltea;
	
}

}