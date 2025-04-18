package proiektuPokemonAbiapuntu;

import java.util.ArrayList;

public class EkintzaZerrenda {
    private ArrayList<Ekintza> ekintzak;

    // Eraikitzailea
    public EkintzaZerrenda() {
        this.ekintzak = new ArrayList<>();
    }

    // Ekintzak gehitzeko metodoa
    public void gehituEkintza(Ekintza ekintza) {
        ekintzak.add(ekintza);
    }

    // Método para obtener una Ekintza por su índice
    public Ekintza getEkintza(int zenbakia) {
        if (zenbakia >= 0 && zenbakia < ekintzak.size()) {
            return ekintzak.get(zenbakia);
        }
        return null; // Retorna null si el índice es inválido
    }
    
    // Ekintzen gettera
    public ArrayList<Ekintza> getEkintzak() {
        return ekintzak;
    }

    // Listaren tamaina lortzeko (1 eta 4 artean da)
    public int tamaina() {
        return ekintzak.size();
    }
}