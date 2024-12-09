package model;

import java.util.ArrayList;

public class Lager {
    private String lagerType;

    private int kapacitet;

    private String lokation;

    private ArrayList<Tønde> tønder = new ArrayList<>();


    public Lager(String lagerType, int kapacitet, String lokation){
        this.lagerType = lagerType;
        this.kapacitet = kapacitet;
        this. lokation = lokation;
    }

    public void addTønde(Tønde tønde){
        tønder.add(tønde);
    }

    // Setter & Getter
    public ArrayList<Tønde> getTønder(){
        return new ArrayList<>(tønder);
    }

    public String getLokation() {
        return lokation;
    }

    public void setLokation(String lokation) {
        this.lokation = lokation;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(int kapacitet) {
        this.kapacitet = kapacitet;
    }

    public String getLagerType() {
        return lagerType;
    }

    public void setLagerType(String lagerType) {
        this.lagerType = lagerType;
    }
}
