package proiektuPokemonAbiapuntu;

public class Ekintza {
    private String izena;
    private int indarra;
    private String mota;

    public Ekintza(String pIzena, int pIndarra, String pMota) {
        this.izena = pIzena;
        this.indarra = pIndarra;
        this.mota = pMota;
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
