package model;

import java.util.ArrayList;

public class Tønde {
    private int tøndeId;

    private int størrelse;

    private String tidligerIndhold;

    private Lager lager;

    private ArrayList<Mængde> mængder = new ArrayList<>();

    private String fadType;

    public Tønde(int tøndeId, int størrelse, String tidligerIndhold, String fadType){

        this.tøndeId = tøndeId;
        this.størrelse = størrelse;
        this.tidligerIndhold = tidligerIndhold;
        this.fadType = fadType;
    }

    public void addMængde(Mængde mængde){
        mængder.add(mængde);
    }



    // Setter & Getter
    public ArrayList<Mængde> getMængder(){
        return new ArrayList<>(mængder);
    }

    public int getTøndeId() {
        return tøndeId;
    }

    public int getStørrelse() {
        return størrelse;
    }

    public String getTidligerIndhold() {
        return tidligerIndhold;
    }

    public Lager getLager() {
        return lager;
    }

    public String getFadType() {
        return fadType;
    }


    @Override
    public String toString() {
        return   "TøndeID: " + tøndeId + "\n"
                + "Tidligere indhold: " + tidligerIndhold.toString() + "\n"
                + "Størrelse: " + størrelse + "\n"
                + "Fadtype: " + fadType.toString() + "\n"
                + "Lager: " + lager + "\n";



    }
}

