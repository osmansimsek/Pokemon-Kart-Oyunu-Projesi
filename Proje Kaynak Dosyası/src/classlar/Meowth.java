package classlar;

public class Meowth extends pokemon {
    private Boolean kullan = false;
    private int hasarpuani = 40;
    public Meowth(){
        super(null,null,-1);
    }
    public Meowth(String pokemonad, String pokemontip, int pokemonid) {
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
