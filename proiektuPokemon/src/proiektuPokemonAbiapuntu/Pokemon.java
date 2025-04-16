package proiektuPokemonAbiapuntu;
import java.util.ArrayList;
import java.util.List;

// Pokemon klase abstraktua
public abstract class Pokemon {
    private String izena;
    private int bizitza;
    private int erasoa;
    private int defentsa;
    private ArrayList<Ekintza> ekintzak;

    public Pokemon(String pIzena, int pBizitza, int pErasoa, int pDefentsa) {
        this.izena = pIzena;
        this.bizitza = pBizitza;
        this.erasoa = pErasoa;
        this.defentsa = pDefentsa;
        this.ekintzak = new ArrayList<Ekintza>();
    }

    public abstract void setEkintzak();

    public void erasotu(Pokemon etsaia, Ekintza ekintza) {
        System.out.println(this.izena + " erabiltzen ari da " + ekintza.getIzena() + " " + etsaia.izena + "ren aurka.");

        double probabilitatea = Math.random(); // entre 0.0 y 1.0
        if (probabilitatea < 0.15) {
            System.out.println(ekintza.getIzena() + " huts egin du!");
            return;
        }

        double kaltea = kalkulatuKaltea(ekintza, etsaia);

        //  Golpe crítico: 10% de probabilidad
        if (Math.random() < 0.1) {
            kaltea *= 2;
            System.out.println("KOLPE KRITIKOA! Kaltea bikoiztuta!");
        }

        etsaia.jasoErasoa(kaltea);
    }


    protected double kalkulatuKaltea(Ekintza ekintza, Pokemon etsaia) {
        double kaltea = (ekintza.getIndarra() * erasoa) / (double) etsaia.defentsa;
        return Math.max(1, kaltea); // Garantiza mínimo 1 de daño
    }

    public void jasoErasoa(double kaltea) {
        int kalteOsoa = (int) Math.round(kaltea);
        bizitza = Math.max(0, bizitza - kalteOsoa);
        System.out.println(izena + " eraso bat jaso du " + kalteOsoa + " kaltearekin. Bizitza: " + bizitza);
    }

    public boolean bizirikDago() {
        return bizitza > 0;
    }

    protected ArrayList<Ekintza> getEkintzak() {
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
}