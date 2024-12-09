package model;
import jdk.jfr.SettingControl;

import java.time.LocalDate;

public class Mængde {
    private int antalLiter;

    // final: en variable der ikke må ændres og gemmer den samme variable f.eks. pi (3.14..)
    private final Tønde tønde;
    private final Destillering destillering;
    private LocalDate påfyldningsDato;

    public Mængde(int antaliter, Tønde tønde, Destillering destillering, LocalDate påfyldningsDato){
        this.antalLiter = antalLiter;
        this.tønde = tønde;
        this.destillering = destillering;
        this.påfyldningsDato = påfyldningsDato;
    }



    // Setter & Getter
    public int getAntalLiter() {
        return antalLiter;
    }

    public void setAntalLiter(int antalLiter) {
        this.antalLiter = antalLiter;
    }

    public Tønde getTønde(){
        return tønde;
    }

    public Destillering getDestillering() {
        return destillering;
    }

}
