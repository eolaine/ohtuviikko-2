package ohtu.verkkokauppa;

public class Kauppa implements KauppaRajapinta {

    private Varastorajapinta varasto;
    private Pankkirajapinta pankki;
    private Ostoskori ostoskori;
    private Generaattorirajapinta viitegeneraattori;
    private String kaupanTili;

    public Kauppa(Varastorajapinta uusivarasto, Pankkirajapinta uusipankki, Generaattorirajapinta uusiviitegeneraattori) {
        varasto = uusivarasto;
        pankki = uusipankki;
        viitegeneraattori = uusiviitegeneraattori;
        kaupanTili = "33333-44455";
    }

    @Override
    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    @Override
    public void poistaKorista(int id) {
        Tuote t = varasto.haeTuote(id); 
        varasto.palautaVarastoon(t);
    }

    @Override
    public void lisaaKoriin(int id) {
        if (varasto.saldo(id)>0) {
            Tuote t = varasto.haeTuote(id);             
            ostoskori.lisaa(t);
            varasto.otaVarastosta(t);
        }
    }

    @Override
    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = viitegeneraattori.uusi();
        int summa = ostoskori.hinta();
        
        return pankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
