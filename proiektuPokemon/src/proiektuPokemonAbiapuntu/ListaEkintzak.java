package proiektuPokemonAbiapuntu;

import java.util.ArrayList;

public class ListaEkintzak {
    private ArrayList<Ekintza> ekintzak;

    // Constructor
    public ListaEkintzak() {
        this.ekintzak = new ArrayList<>();
    }

    // Método para agregar una Ekintza a la lista
    public void gehituEkintza(Ekintza ekintza) {
        ekintzak.add(ekintza);
    }

    // Método para obtener una Ekintza por su índice
    public Ekintza getEkintza(int index) {
        if (index >= 0 && index < ekintzak.size()) {
            return ekintzak.get(index);
        }
        return null; // Retorna null si el índice es inválido
    }

    // Método para obtener todas las Ekintzak
    public ArrayList<Ekintza> getEkintzak() {
        return ekintzak;
    }

    // Método para obtener el tamaño de la lista
    public int tamaina() {
        return ekintzak.size();
    }
}