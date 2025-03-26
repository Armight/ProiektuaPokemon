package proiektuPokemonAbiapuntu;
import java.util.ArrayList;
import java.util.List;

// Pokemon klase abstraktua
public abstract class Pokemon {
    protected String izena;
    protected int bizitza;
    protected int erasoa;
    protected int defentsa;
    protected List<Ekintza> ekintzak;

    public Pokemon(String izena, int bizitza, int erasoa, int defentsa) {
        this.izena = izena;
        this.bizitza = bizitza;
        this.erasoa = erasoa;
        this.defentsa = defentsa;
        this.ekintzak = new ArrayList<>();
        setEkintzak();
    }

    public abstract void setEkintzak();

    public void erasotu(Pokemon etsaia, Ekintza ekintza) {
        System.out.println(izena + " erabiltzen ari da " + ekintza.getIzena() + " " + etsaia.izena + "ren aurka.");
        etsaia.jasoErasoa(kalkulatuKaltea(ekintza, etsaia));
    }

    public double kalkulatuKaltea(Ekintza ekintza, Pokemon etsaia) {
        double kaltea = (ekintza.getIndarra() * erasoa) / (double) etsaia.defentsa;
        return Math.max(1, kaltea); // Gutxienez 1 kaltea
    }

    public void jasoErasoa(double kaltea) {
        int kalteOsoa = (int) Math.round(kaltea);
        bizitza = Math.max(0, bizitza - kalteOsoa);
        System.out.println(izena + " eraso bat jaso du " + kalteOsoa + " kaltearekin. Bizitza: " + bizitza);
    }

    public boolean bizirikDago() {
        return bizitza > 0;
    }

    public List<Ekintza> getEkintzak() {
        return ekintzak;
    }

    public String getIzena() {
        return izena;
    }

    public int getBizitza() {
        return bizitza;
    }

    public int getErasoa() {
        return erasoa;
    }

    public int getDefentsa() {
        return defentsa;
    }
    
    // Ekintza klasea (barneko klasea)
    public static class Ekintza {
        private String izena;
        private int indarra;
        private String mota;

        public Ekintza(String izena, int indarra, String mota) {
            this.izena = izena;
            this.indarra = indarra;
            this.mota = mota;
        }

        public String getIzena() {
            return izena;
        }

        public int getIndarra() {
            return indarra;
        }

        public String getMota() {
            return mota;
        }
    }
}
