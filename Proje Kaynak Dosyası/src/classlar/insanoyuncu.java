package classlar;

import java.util.ArrayList;

public class insanoyuncu extends oyuncu {
    private ArrayList<pokemon> kartlistesi = new ArrayList<>();
    pokemon ver = new pokemon();
    public insanoyuncu(String oyuncuAd, String oyuncuId, int skor) {
        super(oyuncuAd, oyuncuId, skor);
    }
    public pokemon kartSec(int indistut2) {
            if(indistut2 != -1) {
                ver = kartlistesi.get(indistut2);
                return ver;
            }
            else return null;
    }
    public ArrayList<pokemon> getKartlistesi() {
        return kartlistesi;
    }

    public void setKartlistesi(ArrayList<pokemon> kartlistesi) {
        this.kartlistesi = kartlistesi;
    }
}