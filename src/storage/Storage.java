package storage;

import model.Destillering;
import model.Tønde;

import java.util.ArrayList;

public class Storage {
    private ArrayList<Tønde> tønder = new ArrayList<>();
    private ArrayList<Destillering> destilleringer = new ArrayList<>();

    public void gemTønde(Tønde tønde){
        tønder.add(tønde);
    }

    public ArrayList<Tønde> getTønder() {
        return tønder;
    }

    public void gemDestillering(Destillering destillering){
        destilleringer.add(destillering);
    }

    public ArrayList<Destillering> getDestilleringer() {
        return destilleringer;
    }
}
