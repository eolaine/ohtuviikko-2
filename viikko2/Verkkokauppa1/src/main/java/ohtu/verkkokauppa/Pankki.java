package ohtu.verkkokauppa;

public class Pankki implements Pankkirajapinta {

    
    private Kirjanpitorajapinta kirjanpito;

    public Pankki(Kirjanpitorajapinta uusipito) {
        kirjanpito = uusipito;
    }

    @Override
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpito.lisaaTapahtuma("tilisiirto: tililtä " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}
