package controller;

import model.Destillering;
import model.Tønde;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {
    private Storage storage = new Storage();

    public void opretTønde(int tøndeId, int størrelse, String tidligerIndhold, String fadType){
        Tønde tønde = new Tønde(tøndeId, størrelse,tidligerIndhold, fadType);
        storage.gemTønde(tønde);
    }



    public void opretDestillering(int newMake, int mængde, String medarbejderNavn, LocalDate startDato, LocalDate slutDato,
                                  String kornSort, int maltBatch, double alkoholProcent){

        Destillering destillering = new Destillering(newMake, mængde, medarbejderNavn,  startDato, slutDato,
                kornSort, maltBatch, alkoholProcent);
        storage.gemDestillering(destillering);

    }

    public ArrayList<Destillering> getDestilleringer() {
        return storage.getDestilleringer();
    }

    public ArrayList<Tønde> getTønde() {
        return storage.getTønder();
    }

}
