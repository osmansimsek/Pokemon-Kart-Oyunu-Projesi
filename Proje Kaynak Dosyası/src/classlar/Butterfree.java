package classlar;

public class Butterfree extends pokemon {
    private Boolean kullan = false;
    private int hasarpuani = 10;
    public Butterfree(){
        super(null,null,-1);
    }
    public Butterfree(String pokemonad, String pokemontip, int pokemonid) {
        super(pokemonad, pokemontip, pokemonid);
    }
    public String hasarpuanigoster() {
       return super.hasarpuanigoster(this.hasarpuani);
    }
    public int getHasarpuani() {
        return this.hasarpuani;
    }
    public void setHasarpuani(int hasarpuani) {
        this.hasarpuani = hasarpuani;
    }
    public Boolean getKullan() {
        return this.kullan;
    }
    public void setKullan(Boolean kullan) {
        this.kullan = kullan;
    }
}
