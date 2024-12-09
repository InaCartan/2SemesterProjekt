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


    // Husk resten af argumenterne i den anden metoder (husk at slette denne metode)
    public void opretDestillering(String kornSort){
        Destillering destillering = new Destillering(1,1,"?",
                LocalDate.now(),LocalDate.now(),kornSort,1,1.1);
        storage.gemDestillering(destillering);
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
}
