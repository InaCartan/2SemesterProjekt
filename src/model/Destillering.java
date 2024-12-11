package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Destillering {
    private int newMake;

    private int mængde;


    private ArrayList<Mængde> mængder = new ArrayList<>();

    private String medarbejderNavn;

    private LocalDate startDato;

    private LocalDate slutDato;

    private String kornSort;

    private int maltBatch;

    private double alkoholProcent;


    public Destillering(int newMake, int mængde, String medarbejderNavn, LocalDate startDato, LocalDate slutDato,
                        String kornSort, int maltBatch, double alkoholProcent){

        this.newMake = newMake;
        this.mængde = mængde;
        this.medarbejderNavn = medarbejderNavn;
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.kornSort = kornSort;
        this.maltBatch = maltBatch;
        this.alkoholProcent = alkoholProcent;

    }

    public Mængde opretMængde(int antalLiter, Tønde tønde, LocalDate påfyldingsDato){
        Mængde mængde = new Mængde(antalLiter, tønde, this, påfyldingsDato);
        mængder.add(mængde);
        tønde.addMængde(mængde);
        return mængde;
    }

    // Setter & Getter
    public int getNewMake() {
        return newMake;
    }

    public void setNewMake(int newMake) {
        this.newMake = newMake;
    }

    public int getMængde() {
        return mængde;
    }

    public void setMængde(int mængde) {
        this.mængde = mængde;
    }

    public String getMedarbejderNavn() {
        return medarbejderNavn;
    }

    public void setMedarbejderNavn(String medarbejderNavn) {
        this.medarbejderNavn = medarbejderNavn;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public void setSlutDato(LocalDate slutDato) {
        this.slutDato = slutDato;
    }

    public String getKornSort() {
        return kornSort;
    }

    public void setKornSort(String kornSort) {
        this.kornSort = kornSort;
    }

    public int getMaltBatch() {
        return maltBatch;
    }

    public void setMaltBatch(int maltBatch) {
        this.maltBatch = maltBatch;
    }

    public double getAlkoholProcent() {
        return alkoholProcent;
    }

    public void setAlkoholProcent(double alkoholProcent) {
        this.alkoholProcent = alkoholProcent;
    }

    public ArrayList<Mængde> getMængder(){
        return new ArrayList<>(mængder);
    }

    @Override
    public String toString() {
        return   "Medarbejder navn: " + medarbejderNavn + "\n"
                + "Dato: " + startDato.toString() + "... til ... " + slutDato.toString() + "\n"
                + "Korn sort: " + kornSort.toString() + "\n"
                + "Malt batch: " + maltBatch + "\n"
                + "Mængde: " + mængde + "\n"
                + "New make: " + newMake + "\n"
                + "Alkohol procent: " + alkoholProcent + "\n";


    }
}
