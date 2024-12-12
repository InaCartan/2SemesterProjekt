package model;

public class Whisky {

    private int produktID;

    private String type;

    private double alkoholProcent;

    private int fortyndet;

    private int antalFlasker;


    public Whisky(int produktID, String type, double alkoholProcent, int fortyndet, int antalFlasker) {
        this.produktID = produktID;
        this.type = type;
        this.alkoholProcent = alkoholProcent;
        this.fortyndet = fortyndet;
        this.antalFlasker = antalFlasker;
    }


    public int getProduktID() {
        return produktID;
    }

    public String getType() {
        return type;
    }

    public double getAlkoholProcent() {
        return alkoholProcent;
    }

    public int getFortyndet() {
        return fortyndet;
    }

    public int getAntalFlasker() {
        return antalFlasker;
    }

    @Override
    public String toString() {
        return "Produkt ID: " + produktID + "\n"
                + "Typen: " + type.toString() + "\n"
                + "Alkohol procenten: " + alkoholProcent + "\n"
                + "Fortyndelse: " + fortyndet + "\n"
                + "Antal flasker: " + antalFlasker + "\n";
    }

}
