package classlar;
public class pokemon {
    private String pokemonAd;
    private String pokemonTip;
    private int pokemonId;
    public pokemon(){
        pokemonAd=null;
        pokemonId=-1;
        pokemonTip=null;
    }
    public pokemon(String pokemonAd, String pokemonTip, int pokemonId) {
        this.setPokemonAd(pokemonAd);
        this.setPokemonTip(pokemonTip);
        this.setPokemonId(pokemonId);
    }
    public String hasarpuanigoster(int hasarpuani) {
       String hasargoster = Integer.toString(hasarpuani);
        return hasargoster;
    }
    public String getPokemonTip() {
        return this.pokemonTip;
    }
    public void setPokemonTip(String pokemonTip) {
        this.pokemonTip = pokemonTip;
    }
    public String getPokemonAd() {
        return this.pokemonAd;
    }
    public void setPokemonAd(String pokemonAd) {
        this.pokemonAd = pokemonAd;
    }
    public int getPokemonId() {
        return this.pokemonId;
    }
    public void setPokemonId(int pokemonId) {
        this.pokemonId = pokemonId;
    }
}
