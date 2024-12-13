package controller;

import model.Destillering;
import model.Mængde;
import model.Tønde;
import model.Whisky;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {
    private Storage storage = new Storage();

    public void opretTønde(int tøndeId, int størrelse, String tidligerIndhold, String fadType){
        Tønde tønde = new Tønde(tøndeId, størrelse,tidligerIndhold, fadType);
        storage.gemTønde(tønde);
    }


    // tilføj Lager lager
    // Mængde Arraylist, hvad skal vi gøre med den ?


    public void opretDestillering(int newMake, int mængde, String medarbejderNavn, LocalDate startDato, LocalDate slutDato,
                                  String kornSort, int maltBatch, double alkoholProcent){

        Destillering destillering = new Destillering(newMake, mængde, medarbejderNavn,  startDato, slutDato,
                kornSort, maltBatch, alkoholProcent);
        storage.gemDestillering(destillering);

    }


    public void opretWhisky(int produktId, String type, double alkoholProcent, int fortyndet, int antalFlasker) {

        Whisky whisky = new Whisky(produktId,type,alkoholProcent,fortyndet,antalFlasker);
        storage.gemWhisky(whisky);
    }



    public ArrayList<Destillering> getDestilleringer() {
        return storage.getDestilleringer();
    }

    public ArrayList<Tønde> getTønde() {
        return storage.getTønder();
    }

    public ArrayList<Whisky> getWhisky() {
        return storage.getWhisky();
    }


    public void opretMængde(int m, Tønde tønde, Destillering destillering, LocalDate påFyldningsDato) {

    }
}
