package classlar;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Bilgisayaroyuncu extends oyuncu {
    pokemon ver = new pokemon();
    int indistut=-1;
    private ArrayList<pokemon> kartlistesi = new ArrayList<>();
    public Bilgisayaroyuncu(String oyuncuAd, String oyuncuId, int skor) {
        super(oyuncuAd, oyuncuId, skor);
    }
    public int indisyakal(){
        return indistut;
    }
    public pokemon kartSec(int indis){
        while(true){
            int random1 = (int)(Math.random()*3);
            ver=kartlistesi.get(random1);
            indistut=random1;
                if (ver.getPokemonAd() == "Pikachu") {
                    if(((Pikachu)ver).getKullan()==false){
                        ((Pikachu)ver).setKullan(true);
                        return ver;
                    }
                    else continue;
                }
                if (ver.getPokemonAd() == "Bulbasaur") {
                    if(((Bulbasaur)ver).getKullan()==false){
                        ((Bulbasaur)ver).setKullan(true);
                        return ver;
                    }
                    else continue;
                }
                if (ver.getPokemonAd() == "Butterfree") {
                    if(((Butterfree)ver).getKullan()==false){
                        ((Butterfree)ver).setKullan(true);
                        return ver;
                    }
                    else continue;
                }
                if (ver.getPokemonAd() == "Charmander") {
                    if(((Charmander)ver).getKullan()==false){
                        ((Charmander)ver).setKullan(true);
                        return ver;
                    }
                    else continue;
                }
                if (ver.getPokemonAd() == "Jigglypuff") {
                    if(((Jigglypuff)ver).getKullan()==false){
                        ((Jigglypuff)ver).setKullan(true);
                        return ver;
                    }
                    else continue;
                }
                if (ver.getPokemonAd() == "Psyduck") {
                    if(((Psyduck)ver).getKullan()==false){
                        ((Psyduck)ver).setKullan(true);
                        return ver;
                    }
                    else continue;
                }
                if (ver.getPokemonAd() == "Snorlax") {
                    if(((Snorlax)ver).getKullan()==false){
                        ((Snorlax)ver).setKullan(true);
                        return ver;
                    }
                    else continue;
                }
                if (ver.getPokemonAd() == "Zubat") {
                    if(((Zubat)ver).getKullan()==false){
                        ((Zubat)ver).setKullan(true);
                        return ver;
                    }
                    else continue;
                }
                if (ver.getPokemonAd() == "Squirtle") {
                    if(((Squirtle)ver).getKullan()==false){
                        ((Squirtle)ver).setKullan(true);
                        return ver;
                    }
                    else continue;
                }
                if (ver.getPokemonAd() == "Meowth") {
                    if(((Meowth)ver).getKullan()==false){
                        ((Meowth)ver).setKullan(true);
                        return ver;
                    }
                    else continue;
                }
        }
    }
    public ArrayList<pokemon> getKartlistesi() {
        return kartlistesi;
    }

    public void setKartlistesi(ArrayList<pokemon> kartlistesi) {
        this.kartlistesi = kartlistesi;
    }
}