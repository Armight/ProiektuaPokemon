package proiektuPokemonAbiapuntu;
import java.util.ArrayList;

// Pokemon klase abstraktua
public abstract class Pokemon {
	protected String izena;
    protected int bizitza;
    protected int erasoa;
    protected int defentsa;
    protected ArrayList<Ekintza> ekintzak;

    public Pokemon(String pIzena, int pBizitza, int pErasoa, int pDefentsa) {
        this.izena = pIzena;
        this.bizitza = pBizitza;
        this.erasoa = pErasoa;
        this.defentsa = pDefentsa;
        this.ekintzak = new ArrayList<Ekintza>();
        this.setEkintzak(); //IMPORTANTE CAMBIO
    }

    public abstract void setEkintzak();

    public void erasotu(Pokemon etsaia, Ekintza ekintza) {
        System.out.println(this.izena + " erabiltzen ari da " + ekintza.getIzena() + " " + etsaia.izena + "ren aurka.");
        etsaia.jasoErasoa(kalkulatuKaltea(ekintza, etsaia));
    }

    public double kalkulatuKaltea(Ekintza ekintza, Pokemon etsaia) {
        double kaltea = (ekintza.getIndarra() * erasoa)/etsaia.defentsa;
        return kaltea; 
    }

    public void jasoErasoa(double kaltea) {
        bizitza = bizitza - (int) kaltea;
        System.out.println(izena + " eraso bat jaso du " + kaltea + " kaltearekin. Bizitza: " + bizitza);
    }

    public boolean bizirikDago() {
        if (bizitza > 0) {
        	return true;}
        else {
        	return false;}
    }

    public ArrayList<Ekintza> getEkintzak() {
        return ekintzak;
    }

    public String getIzena() {
        return this.izena;
    }

    public int getBizitza() {
        return this.bizitza;
    }

    public int getErasoa() {
        return this.erasoa;
    }

    public int getDefentsa() {
        return this.defentsa;
    }
    
    // Ekintza klasea (barneko klasea)
    public static class Ekintza {
        private String izena;
        private int indarra;
        private String mota;

        public Ekintza(String pIzena, int pIndarra, String pMota) {
            this.izena = pIzena;
            this.indarra = pIndarra;
            this.mota = pMota;

        }

        public String getIzena() {
            return this.izena;
        }

        public int getIndarra() {
            return this.indarra;
        }

        public String getMota() {
            return this.mota;
        }
    }
}