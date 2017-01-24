package bl.budjettilaskuri.logiikka;

public class Rahatapahtuma {
    private String nimi; 
    private double maara;
    
    public Rahatapahtuma(String n, double m){
        this.nimi=n;
        this.maara=m;
    }

    public double getMaara() {
        return maara;
    }

    public void setMaara(int maara) {
        if (this.maara >= 0){
            this.maara = maara;
        }        
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        if (this.nimi.length()<26){
            this.nimi = nimi;
        }       
    }
    
    
}
