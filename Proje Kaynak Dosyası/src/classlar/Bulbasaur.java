package classlar;

public class Bulbasaur extends pokemon {
    private Boolean kullan = false;
    private int hasarpuani = 50;
    public Bulbasaur(){
        super(null,null,-1);
    }
    public Bulbasaur(String pokemonad, String pokemontip, int pokemonid) { super(pokemonad, pokemontip, pokemonid); }
    public String hasarpuanigoster() {
        return super.hasarpuanigoster(this.hasarpuani);
    }
    public int getHasarpuani() {
        return this.hasarpuani;
    }
    public void setHasarpuani(int hasarpuani) { this.hasarpuani = hasarpuani; }
    public Boolean getKullan() { return this.kullan; }
    public void setKullan(Boolean kullan) { this.kullan = kullan; }
}
