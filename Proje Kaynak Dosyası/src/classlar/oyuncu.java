package classlar;

public abstract class oyuncu {
    private String oyuncuAd;
    private String oyuncuId;
    private int skor = 0;

    public oyuncu(String oyuncuAd, String oyuncuId, int skor) {
        this.setOyuncuAd(oyuncuAd);
        this.setOyuncuId(oyuncuId);
        this.setSkor(skor);
    }

    public String skorgoster() {
        String skorgoster = Integer.toString(skor);
        return (skorgoster);

    }

    public abstract pokemon kartSec(int indis);
    public String getOyuncuAd() {
        return this.oyuncuAd;
    }
    public void setOyuncuAd(String oyuncuAd) {
        this.oyuncuAd = oyuncuAd;
    }
    public String getOyuncuId() {
        return this.oyuncuId;
    }
    public void setOyuncuId(String oyuncuId) {
        this.oyuncuId = oyuncuId;
    }
    public int getSkor() {
        return this.skor;
    }
    public void setSkor(int skor) {
        this.skor = skor;
    }
}
