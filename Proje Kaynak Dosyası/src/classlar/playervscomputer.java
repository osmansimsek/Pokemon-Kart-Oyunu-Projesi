package classlar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

public class playervscomputer extends JPanel implements ActionListener, MouseListener {
    int skor1 = 0;
    int skor2 = 0;
    int tur = 1;
    String ad1 = null;
    String ad2 = null;
    int elsayisi = 0;
    int indistut1 = 0;
    static int indistut2 = -1;
    ArrayList<pokemon> kartlistesi = new ArrayList<>();
    ArrayList<pokemon> kartlistesibil1 = new ArrayList<>();
    ArrayList<pokemon> kartlistesibil2 = new ArrayList<>();
    pokemon al1 = new pokemon();
    pokemon al2 = new pokemon();
    Bilgisayaroyuncu bil1 = new Bilgisayaroyuncu("Bilgisayar", "ID1", 0);
    insanoyuncu in1 = new insanoyuncu("Osman", "ID2", 0);
    Timer zaman = new Timer(1500, this);

    public playervscomputer() {
        addMouseListener(this);
        zaman.start();
        kartlistesi.add(new Bulbasaur("Bulbasaur", "Çim", 1));
        kartlistesi.add(new Butterfree("Butterfree", "Hava", 2));
        kartlistesi.add(new Charmander("Charmander", "Ateş", 3));
        kartlistesi.add(new Meowth("Meowth", "Normal", 4));
        kartlistesi.add(new Pikachu("Pikachu", "Elektrik", 5));
        kartlistesi.add(new Zubat("Zubat", "Hava", 6));
        kartlistesi.add(new Snorlax("Snorlax", "Normal", 7));
        kartlistesi.add(new Squirtle("Squirtle", "Su", 8));
        kartlistesi.add(new Psyduck("Psyduck", "Su", 9));
        kartlistesi.add(new Jigglypuff("Jigglypuff", "Ses", 10));
        Collections.shuffle(kartlistesi);
        this.rastgelekart();
    }

    private void baslangicciz(Graphics g) {
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, 800, 600);
        g.setColor(Color.white);
        g.fillRect(200, 70, 95, 95);
        g.fillRect(350, 70, 95, 95);
        g.fillRect(500, 70, 95, 95);
        g.fillRect(200, 395, 95, 95);
        g.fillRect(350, 395, 95, 95);
        g.fillRect(500, 395, 95, 95);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Timesroman", Font.PLAIN, 21));
        g.drawString("Kalan Kart", 50, 195);
        g.drawString("Adedi", 71, 225);
        String size = Integer.toString(kartlistesi.size());
        g.drawString(size, 90, 255);
        g.setFont(new Font("Timesroman", Font.PLAIN, 23));
        g.drawString("Skor", 640, 90);
        g.drawString("Skor", 640, 420);
        g.setFont(new Font("Timesroman", Font.PLAIN, 30));
        g.drawString(bil1.getOyuncuAd(), 328, 40);
        g.drawString(in1.getOyuncuAd(), 349, 545);
        g.setFont(new Font("Timesroman", Font.PLAIN, 14));
        g.setColor(Color.white);
        g.setFont(new Font("Timesroman", Font.PLAIN, 21));
        g.setColor(Color.white);
        g.drawString(bil1.skorgoster(), 653, 120);
        g.drawString(in1.skorgoster(), 653, 450);
    }

    private void rastgelekart() {
        for (int i = 0; i < 3; i++) {
            kartlistesibil1.add(kartlistesi.get(i));
            kartlistesi.remove(i);
        }
        for (int i = 0; i < 3; i++) {
            kartlistesibil2.add(kartlistesi.get(i));
            kartlistesi.remove(i);
        }
        bil1.setKartlistesi(kartlistesibil1);
        in1.setKartlistesi(kartlistesibil2);
    }

    private void kartcek1() {
        Graphics g = getGraphics();
        g.setColor(Color.gray);
        g.fillRect(350, 175, 95, 95);
        g.setFont(new Font("Timesroman", Font.PLAIN, 19));
        g.setColor(Color.WHITE);
        g.drawString("Kart",370,205);
        g.drawString("Arkasi",367,235);
        al1 = bil1.kartSec(-1);
        indistut1 = bil1.indisyakal();
        ad1 = al1.getPokemonAd();
    }

    private void kartcek2(int indistut2) {
        Graphics g = getGraphics();
        al2 = in1.kartSec(indistut2);
        g.setColor(Color.gray);
        g.fillRect(350, 290, 95, 95);
        g.setFont(new Font("Timesroman", Font.PLAIN, 19));
        g.setColor(Color.WHITE);
        g.drawString("Kart",370,320);
        g.drawString("Arkasi",367,350);
        ad2 = al2.getPokemonAd();
    }

    private void skorgoster() {
        Graphics g = getGraphics();
        if (skor1 > skor2) {
            bil1.setSkor(bil1.getSkor() + 5);
            g.setColor(Color.darkGray);
            g.fillRect(635, 100, 100, 100);
            g.setFont(new Font("Timesroman", Font.PLAIN, 18));
            g.setColor(Color.white);
            g.drawString(bil1.skorgoster(), 653, 120);

        }
        if (skor1 < skor2) {
            in1.setSkor(in1.getSkor() + 5);
            g.setColor(Color.darkGray);
            g.fillRect(635, 430, 100, 100);
            g.setFont(new Font("Timesroman", Font.PLAIN, 18));
            g.setColor(Color.white);
            g.drawString(in1.skorgoster(), 653, 450);
        }
    }

    private void kazananbelirle() {
        Graphics g = getGraphics();
        if (bil1.getSkor() > in1.getSkor()) {
            g.setColor(Color.darkGray);
            g.fillRect(0, 0, 800, 600);
            g.setColor(Color.white);
            g.setFont(new Font("Timesroman", Font.PLAIN, 41));
            g.drawString("Winner Bilgisayar", 245, 270);
        }
        if (bil1.getSkor() < in1.getSkor()) {
            g.setColor(Color.darkGray);
            g.fillRect(0, 0, 800, 600);
            g.setColor(Color.white);
            g.setFont(new Font("Timesroman", Font.PLAIN, 41));
            g.drawString("Winner Osman", 275, 270);
        }
        if (bil1.getSkor() == in1.getSkor()) {
            g.setColor(Color.darkGray);
            g.fillRect(0, 0, 800, 600);
            g.setColor(Color.white);
            g.setFont(new Font("Timesroman", Font.PLAIN, 41));
            g.drawString("Berabere", 310, 280);
        }

    }

    private void kartciz1(Graphics g, String ad, int num) {
        g.setColor(new Color(173, 6, 6));
        g.setFont(new Font("Timesroman", Font.PLAIN, 17));
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                if (bil1.getKartlistesi().get(i).getPokemonAd().equals("Pikachu")) {
                    g.drawString(bil1.getKartlistesi().get(i).getPokemonAd(), 218, 105);
                    g.drawString(bil1.getKartlistesi().get(i).hasarpuanigoster(new Pikachu().getHasarpuani()), 242, 136);
                }
                if (bil1.getKartlistesi().get(i).getPokemonAd().equals("Bulbasaur")) {
                    g.drawString(bil1.getKartlistesi().get(i).getPokemonAd(), 211, 105);
                    g.drawString(bil1.getKartlistesi().get(i).hasarpuanigoster(new Bulbasaur().getHasarpuani()), 242, 136);
                }
                if (bil1.getKartlistesi().get(i).getPokemonAd().equals("Butterfree")) {
                    g.drawString(bil1.getKartlistesi().get(i).getPokemonAd(), 211, 105);
                    g.drawString(bil1.getKartlistesi().get(i).hasarpuanigoster(new Butterfree().getHasarpuani()), 242, 136);
                }
                if (bil1.getKartlistesi().get(i).getPokemonAd().equals("Psyduck")) {
                    g.drawString(bil1.getKartlistesi().get(i).getPokemonAd(), 216, 105);
                    g.drawString(bil1.getKartlistesi().get(i).hasarpuanigoster(new Psyduck().getHasarpuani()), 242, 136);
                }
                if (bil1.getKartlistesi().get(i).getPokemonAd().equals("Charmander")) {
                    g.drawString(bil1.getKartlistesi().get(i).getPokemonAd(), 201, 105);
                    g.drawString(bil1.getKartlistesi().get(i).hasarpuanigoster(new Charmander().getHasarpuani()), 242, 136);
                }
                if (bil1.getKartlistesi().get(i).getPokemonAd().equals("Jigglypuff")) {
                    g.drawString(bil1.getKartlistesi().get(i).getPokemonAd(), 211, 105);
                    g.drawString(bil1.getKartlistesi().get(i).hasarpuanigoster(new Jigglypuff().getHasarpuani()), 242, 136);
                }
                if (bil1.getKartlistesi().get(i).getPokemonAd().equals("Snorlax")) {
                    g.drawString(bil1.getKartlistesi().get(i).getPokemonAd(), 220, 105);
                    g.drawString(bil1.getKartlistesi().get(i).hasarpuanigoster(new Snorlax().getHasarpuani()), 242, 136);
                }
                if (bil1.getKartlistesi().get(i).getPokemonAd().equals("Meowth")) {
                    g.drawString(bil1.getKartlistesi().get(i).getPokemonAd(), 220, 105);
                    g.drawString(bil1.getKartlistesi().get(i).hasarpuanigoster(new Meowth().getHasarpuani()), 242, 136);
                }
                if (bil1.getKartlistesi().get(i).getPokemonAd().equals("Squirtle")) {
                    g.drawString(bil1.getKartlistesi().get(i).getPokemonAd(), 221, 105);
                    g.drawString(bil1.getKartlistesi().get(i).hasarpuanigoster(new Squirtle().getHasarpuani()), 242, 136);
                }
                if (bil1.getKartlistesi().get(i).getPokemonAd().equals("Zubat")) {
                    g.drawString(bil1.getKartlistesi().get(i).getPokemonAd(), 229, 105);
                    g.drawString(bil1.getKartlistesi().get(i).hasarpuanigoster(new Zubat().getHasarpuani()), 242, 136);
                }


            }
            if (i == 1) {
                if (bil1.getKartlistesi().get(i).getPokemonAd().equals("Pikachu")) {
                    g.drawString(bil1.getKartlistesi().get(i).getPokemonAd(), 367, 105);
                    g.drawString(bil1.getKartlistesi().get(i).hasarpuanigoster(new Pikachu().getHasarpuani()), 392, 136);
                }
                if (kartlistesibil1.get(i).getPokemonAd().equals("Bulbasaur")) {
                    g.drawString(bil1.getKartlistesi().get(i).getPokemonAd(), 361, 105);
                    g.drawString(bil1.getKartlistesi().get(i).hasarpuanigoster(new Bulbasaur().getHasarpuani()), 392, 136);
                }
                if (bil1.getKartlistesi().get(i).getPokemonAd().equals("Butterfree")) {
                    g.drawString(bil1.getKartlistesi().get(i).getPokemonAd(), 361, 105);
                    g.drawString(bil1.getKartlistesi().get(i).hasarpuanigoster(new Butterfree().getHasarpuani()), 392, 136);
                }
                if (bil1.getKartlistesi().get(i).getPokemonAd().equals("Psyduck")) {
                    g.drawString(bil1.getKartlistesi().get(i).getPokemonAd(), 365, 105);
                    g.drawString(bil1.getKartlistesi().get(i).hasarpuanigoster(new Psyduck().getHasarpuani()), 392, 136);
                }
                if (bil1.getKartlistesi().get(i).getPokemonAd().equals("Charmander")) {
                    g.drawString(bil1.getKartlistesi().get(i).getPokemonAd(), 353, 105);
                    g.drawString(bil1.getKartlistesi().get(i).hasarpuanigoster(new Charmander().getHasarpuani()), 392, 136);
                }
                if (bil1.getKartlistesi().get(i).getPokemonAd().equals("Jigglypuff")) {
                    g.drawString(bil1.getKartlistesi().get(i).getPokemonAd(), 362, 105);
                    g.drawString(bil1.getKartlistesi().get(i).hasarpuanigoster(new Jigglypuff().getHasarpuani()), 392, 136);
                }
                if (bil1.getKartlistesi().get(i).getPokemonAd().equals("Snorlax")) {
                    g.drawString(bil1.getKartlistesi().get(i).getPokemonAd(), 368, 105);
                    g.drawString(bil1.getKartlistesi().get(i).hasarpuanigoster(new Snorlax().getHasarpuani()), 392, 136);
                }
                if (bil1.getKartlistesi().get(i).getPokemonAd().equals("Meowth")) {
                    g.drawString(bil1.getKartlistesi().get(i).getPokemonAd(), 368, 105);
                    g.drawString(bil1.getKartlistesi().get(i).hasarpuanigoster(new Meowth().getHasarpuani()), 392, 136);
                }
                if (bil1.getKartlistesi().get(i).getPokemonAd().equals("Squirtle")) {
                    g.drawString(bil1.getKartlistesi().get(i).getPokemonAd(), 372, 105);
                    g.drawString(bil1.getKartlistesi().get(i).hasarpuanigoster(new Squirtle().getHasarpuani()), 392, 136);
                }
                if (bil1.getKartlistesi().get(i).getPokemonAd().equals("Zubat")) {
                    g.drawString(bil1.getKartlistesi().get(i).getPokemonAd(), 380, 105);
                    g.drawString(bil1.getKartlistesi().get(i).hasarpuanigoster(new Zubat().getHasarpuani()), 392, 136);
                }
            }
            if (i == 2) {
                if (bil1.getKartlistesi().get(i).getPokemonAd().equals("Pikachu")) {
                    g.drawString(bil1.getKartlistesi().get(i).getPokemonAd(), 517, 105);
                    g.drawString(bil1.getKartlistesi().get(i).hasarpuanigoster(new Pikachu().getHasarpuani()), 540, 136);
                }
                if (bil1.getKartlistesi().get(i).getPokemonAd().equals("Bulbasaur")) {
                    g.drawString(bil1.getKartlistesi().get(i).getPokemonAd(), 509, 105);
                    g.drawString(bil1.getKartlistesi().get(i).hasarpuanigoster(new Bulbasaur().getHasarpuani()), 540, 136);
                }
                if (bil1.getKartlistesi().get(i).getPokemonAd().equals("Butterfree")) {
                    g.drawString(bil1.getKartlistesi().get(i).getPokemonAd(), 509, 105);
                    g.drawString(bil1.getKartlistesi().get(i).hasarpuanigoster(new Butterfree().getHasarpuani()), 540, 136);
                }
                if (bil1.getKartlistesi().get(i).getPokemonAd().equals("Psyduck")) {
                    g.drawString(bil1.getKartlistesi().get(i).getPokemonAd(), 522, 105);
                    g.drawString(bil1.getKartlistesi().get(i).hasarpuanigoster(new Psyduck().getHasarpuani()), 540, 136);
                }
                if (bil1.getKartlistesi().get(i).getPokemonAd().equals("Charmander")) {
                    g.drawString(bil1.getKartlistesi().get(i).getPokemonAd(), 502, 105);
                    g.drawString(bil1.getKartlistesi().get(i).hasarpuanigoster(new Charmander().getHasarpuani()), 540, 136);
                }
                if (bil1.getKartlistesi().get(i).getPokemonAd().equals("Jigglypuff")) {
                    g.drawString(bil1.getKartlistesi().get(i).getPokemonAd(), 509, 105);
                    g.drawString(bil1.getKartlistesi().get(i).hasarpuanigoster(new Jigglypuff().getHasarpuani()), 540, 136);
                }
                if (bil1.getKartlistesi().get(i).getPokemonAd().equals("Meowth")) {
                    g.drawString(bil1.getKartlistesi().get(i).getPokemonAd(), 519, 105);
                    g.drawString(bil1.getKartlistesi().get(i).hasarpuanigoster(new Meowth().getHasarpuani()), 540, 136);
                }
                if (bil1.getKartlistesi().get(i).getPokemonAd().equals("Snorlax")) {
                    g.drawString(bil1.getKartlistesi().get(i).getPokemonAd(), 520, 105);
                    g.drawString(bil1.getKartlistesi().get(i).hasarpuanigoster(new Snorlax().getHasarpuani()), 540, 136);
                }
                if (bil1.getKartlistesi().get(i).getPokemonAd().equals("Squirtle")) {
                    g.drawString(bil1.getKartlistesi().get(i).getPokemonAd(), 519, 105);
                    g.drawString(bil1.getKartlistesi().get(i).hasarpuanigoster(new Squirtle().getHasarpuani()), 540, 136);
                }
                if (bil1.getKartlistesi().get(i).getPokemonAd().equals("Zubat")) {
                    g.drawString(bil1.getKartlistesi().get(i).getPokemonAd(), 525, 105);
                    g.drawString(bil1.getKartlistesi().get(i).hasarpuanigoster(new Zubat().getHasarpuani()), 540, 136);
                }
            }
        }
    }

    private void kartciz2(Graphics g, String ad, int num) {
        for (int i = 0; i < 3; i++) {
            g.setColor(new Color(173, 2, 30));
            g.setFont(new Font("Timesroman", Font.PLAIN, 17));
            if (i == 0) {
                if (in1.getKartlistesi().get(i).getPokemonAd().equals("Pikachu")) {
                    g.drawString(in1.getKartlistesi().get(i).getPokemonAd(), 218, 434);
                    g.drawString(in1.getKartlistesi().get(i).hasarpuanigoster(new Pikachu().getHasarpuani()), 242, 466);
                }
                if (in1.getKartlistesi().get(i).getPokemonAd().equals("Bulbasaur")) {
                    g.drawString(in1.getKartlistesi().get(i).getPokemonAd(), 211, 434);
                    g.drawString(in1.getKartlistesi().get(i).hasarpuanigoster(new Bulbasaur().getHasarpuani()), 242, 466);
                }
                if (in1.getKartlistesi().get(i).getPokemonAd().equals("Butterfree")) {
                    g.drawString(in1.getKartlistesi().get(i).getPokemonAd(), 211, 434);
                    g.drawString(in1.getKartlistesi().get(i).hasarpuanigoster(new Butterfree().getHasarpuani()), 242, 466);
                }
                if (in1.getKartlistesi().get(i).getPokemonAd().equals("Psyduck")) {
                    g.drawString(in1.getKartlistesi().get(i).getPokemonAd(), 216, 434);
                    g.drawString(in1.getKartlistesi().get(i).hasarpuanigoster(new Psyduck().getHasarpuani()), 242, 466);
                }
                if (in1.getKartlistesi().get(i).getPokemonAd().equals("Charmander")) {
                    g.drawString(in1.getKartlistesi().get(i).getPokemonAd(), 201, 434);
                    g.drawString(in1.getKartlistesi().get(i).hasarpuanigoster(new Charmander().getHasarpuani()), 242, 466);
                }
                if (in1.getKartlistesi().get(i).getPokemonAd().equals("Jigglypuff")) {
                    g.drawString(in1.getKartlistesi().get(i).getPokemonAd(), 211, 434);
                    g.drawString(in1.getKartlistesi().get(i).hasarpuanigoster(new Jigglypuff().getHasarpuani()), 242, 466);
                }
                if (in1.getKartlistesi().get(i).getPokemonAd().equals("Snorlax")) {
                    g.drawString(in1.getKartlistesi().get(i).getPokemonAd(), 220, 434);
                    g.drawString(in1.getKartlistesi().get(i).hasarpuanigoster(new Snorlax().getHasarpuani()), 242, 466);
                }
                if (in1.getKartlistesi().get(i).getPokemonAd().equals("Meowth")) {
                    g.drawString(in1.getKartlistesi().get(i).getPokemonAd(), 220, 434);
                    g.drawString(in1.getKartlistesi().get(i).hasarpuanigoster(new Meowth().getHasarpuani()), 242, 466);
                }
                if (in1.getKartlistesi().get(i).getPokemonAd().equals("Squirtle")) {
                    g.drawString(in1.getKartlistesi().get(i).getPokemonAd(), 221, 434);
                    g.drawString(in1.getKartlistesi().get(i).hasarpuanigoster(new Squirtle().getHasarpuani()), 242, 466);
                }
                if (in1.getKartlistesi().get(i).getPokemonAd().equals("Zubat")) {
                    g.drawString(in1.getKartlistesi().get(i).getPokemonAd(), 229, 434);
                    g.drawString(in1.getKartlistesi().get(i).hasarpuanigoster(new Zubat().getHasarpuani()), 242, 466);
                }
            }
            if (i == 1) {
                if (in1.getKartlistesi().get(i).getPokemonAd().equals("Pikachu")) {
                    g.drawString(in1.getKartlistesi().get(i).getPokemonAd(), 367, 434);
                    g.drawString(in1.getKartlistesi().get(i).hasarpuanigoster(new Pikachu().getHasarpuani()), 392, 466);
                }
                if (in1.getKartlistesi().get(i).getPokemonAd().equals("Bulbasaur")) {
                    g.drawString(in1.getKartlistesi().get(i).getPokemonAd(), 361, 434);
                    g.drawString(in1.getKartlistesi().get(i).hasarpuanigoster(new Bulbasaur().getHasarpuani()), 392, 466);
                }
                if (in1.getKartlistesi().get(i).getPokemonAd().equals("Butterfree")) {
                    g.drawString(in1.getKartlistesi().get(i).getPokemonAd(), 361, 434);
                    g.drawString(in1.getKartlistesi().get(i).hasarpuanigoster(new Butterfree().getHasarpuani()), 392, 466);
                }
                if (in1.getKartlistesi().get(i).getPokemonAd().equals("Psyduck")) {
                    g.drawString(in1.getKartlistesi().get(i).getPokemonAd(), 365, 434);
                    g.drawString(in1.getKartlistesi().get(i).hasarpuanigoster(new Psyduck().getHasarpuani()), 392, 466);
                }
                if (in1.getKartlistesi().get(i).getPokemonAd().equals("Charmander")) {
                    g.drawString(in1.getKartlistesi().get(i).getPokemonAd(), 353, 434);
                    g.drawString(in1.getKartlistesi().get(i).hasarpuanigoster(new Charmander().getHasarpuani()), 392, 466);
                }
                if (in1.getKartlistesi().get(i).getPokemonAd().equals("Jigglypuff")) {
                    g.drawString(in1.getKartlistesi().get(i).getPokemonAd(), 362, 434);
                    g.drawString(in1.getKartlistesi().get(i).hasarpuanigoster(new Jigglypuff().getHasarpuani()), 392, 466);
                }
                if (in1.getKartlistesi().get(i).getPokemonAd().equals("Snorlax")) {
                    g.drawString(in1.getKartlistesi().get(i).getPokemonAd(), 368, 434);
                    g.drawString(in1.getKartlistesi().get(i).hasarpuanigoster(new Snorlax().getHasarpuani()), 392, 466);
                }
                if (in1.getKartlistesi().get(i).getPokemonAd().equals("Meowth")) {
                    g.drawString(in1.getKartlistesi().get(i).getPokemonAd(), 368, 434);
                    g.drawString(in1.getKartlistesi().get(i).hasarpuanigoster(new Meowth().getHasarpuani()), 392, 466);
                }
                if (in1.getKartlistesi().get(i).getPokemonAd().equals("Squirtle")) {
                    g.drawString(in1.getKartlistesi().get(i).getPokemonAd(), 372, 434);
                    g.drawString(in1.getKartlistesi().get(i).hasarpuanigoster(new Squirtle().getHasarpuani()), 392, 466);
                }
                if (in1.getKartlistesi().get(i).getPokemonAd().equals("Zubat")) {
                    g.drawString(in1.getKartlistesi().get(i).getPokemonAd(), 380, 434);
                    g.drawString(in1.getKartlistesi().get(i).hasarpuanigoster(new Zubat().getHasarpuani()), 392, 466);
                }
            }
            if (i == 2) {
                if (in1.getKartlistesi().get(i).getPokemonAd().equals("Pikachu")) {
                    g.drawString(in1.getKartlistesi().get(i).getPokemonAd(), 517, 434);
                    g.drawString(in1.getKartlistesi().get(i).hasarpuanigoster(new Pikachu().getHasarpuani()), 540, 464);
                }
                if (in1.getKartlistesi().get(i).getPokemonAd().equals("Bulbasaur")) {
                    g.drawString(in1.getKartlistesi().get(i).getPokemonAd(), 509, 434);
                    g.drawString(in1.getKartlistesi().get(i).hasarpuanigoster(new Bulbasaur().getHasarpuani()), 540, 464);
                }
                if (in1.getKartlistesi().get(i).getPokemonAd().equals("Butterfree")) {
                    g.drawString(in1.getKartlistesi().get(i).getPokemonAd(), 509, 434);
                    g.drawString(in1.getKartlistesi().get(i).hasarpuanigoster(new Butterfree().getHasarpuani()), 540, 464);
                }
                if (in1.getKartlistesi().get(i).getPokemonAd().equals("Psyduck")) {
                    g.drawString(in1.getKartlistesi().get(i).getPokemonAd(), 522, 434);
                    g.drawString(in1.getKartlistesi().get(i).hasarpuanigoster(new Psyduck().getHasarpuani()), 540, 464);
                }
                if (in1.getKartlistesi().get(i).getPokemonAd().equals("Charmander")) {
                    g.drawString(in1.getKartlistesi().get(i).getPokemonAd(), 502, 434);
                    g.drawString(in1.getKartlistesi().get(i).hasarpuanigoster(new Charmander().getHasarpuani()), 540, 464);
                }
                if (in1.getKartlistesi().get(i).getPokemonAd().equals("Jigglypuff")) {
                    g.drawString(in1.getKartlistesi().get(i).getPokemonAd(), 509, 434);
                    g.drawString(in1.getKartlistesi().get(i).hasarpuanigoster(new Jigglypuff().getHasarpuani()), 540, 464);
                }
                if (in1.getKartlistesi().get(i).getPokemonAd().equals("Meowth")) {
                    g.drawString(in1.getKartlistesi().get(i).getPokemonAd(), 519, 434);
                    g.drawString(in1.getKartlistesi().get(i).hasarpuanigoster(new Meowth().getHasarpuani()), 540, 464);
                }
                if (in1.getKartlistesi().get(i).getPokemonAd().equals("Snorlax")) {
                    g.drawString(in1.getKartlistesi().get(i).getPokemonAd(), 520, 434);
                    g.drawString(in1.getKartlistesi().get(i).hasarpuanigoster(new Snorlax().getHasarpuani()), 540, 464);
                }
                if (in1.getKartlistesi().get(i).getPokemonAd().equals("Squirtle")) {
                    g.drawString(in1.getKartlistesi().get(i).getPokemonAd(), 519, 434);
                    g.drawString(in1.getKartlistesi().get(i).hasarpuanigoster(new Squirtle().getHasarpuani()), 540, 464);
                }
                if (in1.getKartlistesi().get(i).getPokemonAd().equals("Zubat")) {
                    g.drawString(in1.getKartlistesi().get(i).getPokemonAd(), 525, 434);
                    g.drawString(in1.getKartlistesi().get(i).hasarpuanigoster(new Zubat().getHasarpuani()), 540, 464);
                }
            }
        }
    }

    private void kartyok1() {
        Graphics g = getGraphics();
        if (bil1.getKartlistesi().get(0).getPokemonAd() == ad1) {
            g.setColor(Color.darkGray);
            g.fillRect(200, 70, 95, 105);
        }
        if (bil1.getKartlistesi().get(1).getPokemonAd() == ad1) {
            g.setColor(Color.darkGray);
            g.fillRect(350, 70, 95, 105);
        }
        if (bil1.getKartlistesi().get(2).getPokemonAd() == ad1) {
            g.setColor(Color.darkGray);
            g.fillRect(500, 70, 95, 105);
        }
    }

    private void kartyok2() {
        Graphics g = getGraphics();
        if (in1.getKartlistesi().get(0).getPokemonAd() == ad2) {
            g.setColor(Color.darkGray);
            g.fillRect(200, 395, 95, 95);
        }
        if (in1.getKartlistesi().get(1).getPokemonAd() == ad2) {
            g.setColor(Color.darkGray);
            g.fillRect(350, 395, 95, 95);
        }
        if (in1.getKartlistesi().get(2).getPokemonAd() == ad2) {
            g.setColor(Color.darkGray);
            g.fillRect(500, 395, 95, 95);
        }
    }

    private void ortayitemizle() {
        Graphics g = getGraphics();
        g.setColor(Color.darkGray);
        g.fillRect(350, 175, 95, 210);
    }

    private void kartlariac1(){
        Graphics g = getGraphics();
        g.setColor(Color.gray);
        g.fillRect(350, 175, 95, 95);
        g.setFont(new Font("Timesroman", Font.PLAIN, 17));
        g.setColor(Color.WHITE);
        {
            if (al1.getPokemonAd() == "Pikachu") {
                g.drawString(((Pikachu) al1).hasarpuanigoster(), 386, 235);
                g.drawString(al1.getPokemonAd(), 364, 205);
                skor1 = ((Pikachu) al1).getHasarpuani();
                ad1 = al1.getPokemonAd();
            }
            if (al1.getPokemonAd() == "Bulbasaur") {
                g.drawString(((Bulbasaur) al1).hasarpuanigoster(), 386, 235);
                g.drawString(al1.getPokemonAd(), 357, 205);
                skor1 = ((Bulbasaur) al1).getHasarpuani();
                ad1 = al1.getPokemonAd();
            }
            if (al1.getPokemonAd() == "Butterfree") {
                g.drawString(((Butterfree) al1).hasarpuanigoster(), 386, 235);
                g.drawString(al1.getPokemonAd(), 356, 205);
                skor1 = ((Butterfree) al1).getHasarpuani();
                ad1 = al1.getPokemonAd();
            }
            if (al1.getPokemonAd() == "Charmander") {
                g.drawString(((Charmander) al1).hasarpuanigoster(), 386, 235);
                g.drawString(al1.getPokemonAd(), 351, 205);
                skor1 = ((Charmander) al1).getHasarpuani();
                ad1 = al1.getPokemonAd();
            }
            if (al1.getPokemonAd() == "Jigglypuff") {
                g.drawString(((Jigglypuff) al1).hasarpuanigoster(), 386, 235);
                g.drawString(al1.getPokemonAd(), 360, 205);
                skor1 = ((Jigglypuff) al1).getHasarpuani();
                ad1 = al1.getPokemonAd();
            }
            if (al1.getPokemonAd() == "Psyduck") {
                g.drawString(((Psyduck) al1).hasarpuanigoster(), 386, 235);
                g.drawString(al1.getPokemonAd(), 362, 205);
                skor1 = ((Psyduck) al1).getHasarpuani();
                ad1 = al1.getPokemonAd();
            }
            if (al1.getPokemonAd() == "Snorlax") {
                g.drawString(((Snorlax) al1).hasarpuanigoster(), 386, 235);
                g.drawString(al1.getPokemonAd(), 369, 205);
                skor1 = ((Snorlax) al1).getHasarpuani();
                ad1 = al1.getPokemonAd();
            }
            if (al1.getPokemonAd() == "Zubat") {
                g.drawString(((Zubat) al1).hasarpuanigoster(), 386, 235);
                g.drawString(al1.getPokemonAd(), 373, 205);
                skor1 = ((Zubat) al1).getHasarpuani();
                ad1 = al1.getPokemonAd();
            }
            if (al1.getPokemonAd() == "Squirtle") {
                g.drawString(((Squirtle) al1).hasarpuanigoster(), 386, 235);
                g.drawString(al1.getPokemonAd(), 367, 205);
                skor1 = ((Squirtle) al1).getHasarpuani();
                ad1 = al1.getPokemonAd();
            }
            if (al1.getPokemonAd() == "Meowth") {
                g.drawString(((Meowth) al1).hasarpuanigoster(), 386, 235);
                g.drawString(al1.getPokemonAd(), 365, 205);
                skor1 = ((Meowth) al1).getHasarpuani();
                ad1 = al1.getPokemonAd();
            }
        }

    }

    private void kartlariac2(){
        Graphics g = getGraphics();
        g.setColor(Color.gray);
        g.fillRect(350, 290, 95, 95);
        g.setFont(new Font("Timesroman", Font.PLAIN, 17));
        g.setColor(Color.WHITE);
        {
            if (al2.getPokemonAd() == "Pikachu") {
                g.drawString(((Pikachu) al2).hasarpuanigoster(), 386, 355);
                g.drawString(al2.getPokemonAd(), 364, 325);
                skor2 = ((Pikachu) al2).getHasarpuani();
                ad2 = al2.getPokemonAd();
            }
            if (al2.getPokemonAd() == "Bulbasaur") {
                g.drawString(((Bulbasaur) al2).hasarpuanigoster(), 386, 355);
                g.drawString(al2.getPokemonAd(), 357, 325);
                skor2 = ((Bulbasaur) al2).getHasarpuani();
                ad2 = al2.getPokemonAd();
            }
            if (al2.getPokemonAd() == "Butterfree") {
                g.drawString(((Butterfree) al2).hasarpuanigoster(), 386, 355);
                g.drawString(al2.getPokemonAd(), 356, 325);
                skor2 = ((Butterfree) al2).getHasarpuani();
                ad2 = al2.getPokemonAd();
            }
            if (al2.getPokemonAd() == "Charmander") {
                g.drawString(((Charmander) al2).hasarpuanigoster(), 386, 355);
                g.drawString(al2.getPokemonAd(), 351, 325);
                skor2 = ((Charmander) al2).getHasarpuani();
                ad2 = al2.getPokemonAd();
            }
            if (al2.getPokemonAd() == "Jigglypuff") {
                g.drawString(((Jigglypuff) al2).hasarpuanigoster(), 386, 355);
                g.drawString(al2.getPokemonAd(), 360, 325);
                skor2 = ((Jigglypuff) al2).getHasarpuani();
                ad2 = al2.getPokemonAd();
            }
            if (al2.getPokemonAd() == "Psyduck") {
                g.drawString(((Psyduck) al2).hasarpuanigoster(), 386, 355);
                g.drawString(al2.getPokemonAd(), 362, 325);
                skor2 = ((Psyduck) al2).getHasarpuani();
                ad2 = al2.getPokemonAd();
            }
            if (al2.getPokemonAd() == "Snorlax") {
                g.drawString(((Snorlax) al2).hasarpuanigoster(), 386, 355);
                g.drawString(al2.getPokemonAd(), 369, 325);
                skor2 = ((Snorlax) al2).getHasarpuani();
                ad2 = al2.getPokemonAd();
            }
            if (al2.getPokemonAd() == "Zubat") {
                g.drawString(((Zubat) al2).hasarpuanigoster(), 386, 355);
                g.drawString(al2.getPokemonAd(), 373, 325);
                skor2 = ((Zubat) al2).getHasarpuani();
                ad2 = al2.getPokemonAd();
            }
            if (al2.getPokemonAd() == "Squirtle") {
                g.drawString(((Squirtle) al2).hasarpuanigoster(), 386, 355);
                g.drawString(al2.getPokemonAd(), 367, 325);
                skor2 = ((Squirtle) al2).getHasarpuani();
                ad2 = al2.getPokemonAd();
            }
            if (al2.getPokemonAd() == "Meowth") {
                g.drawString(((Meowth) al2).hasarpuanigoster(), 386, 355);
                g.drawString(al2.getPokemonAd(), 365, 325);
                skor2 = ((Meowth) al2).getHasarpuani();
                ad2 = al2.getPokemonAd();
            }
        }
    }

    private void kartdagit1() {
        Graphics g = getGraphics();
        if (kartlistesi.size() > 0) {
            bil1.getKartlistesi().set(indistut1, kartlistesi.get(0));
            kartlistesi.remove(0);
            if (indistut1 == 0) {
                g.setColor(Color.white);
                g.fillRect(200, 70, 95, 95);
                g.setColor(new Color(173, 6, 6));
                g.setFont(new Font("Timesroman", Font.PLAIN, 17));
                if (bil1.getKartlistesi().get(indistut1).getPokemonAd().equals("Pikachu")) {
                    g.drawString(bil1.getKartlistesi().get(indistut1).getPokemonAd(), 218, 105);
                    g.drawString(bil1.getKartlistesi().get(indistut1).hasarpuanigoster(new Pikachu().getHasarpuani()), 242, 136);
                }
                if (bil1.getKartlistesi().get(indistut1).getPokemonAd().equals("Bulbasaur")) {
                    g.drawString(bil1.getKartlistesi().get(indistut1).getPokemonAd(), 211, 105);
                    g.drawString(bil1.getKartlistesi().get(indistut1).hasarpuanigoster(new Bulbasaur().getHasarpuani()), 242, 136);
                }
                if (bil1.getKartlistesi().get(indistut1).getPokemonAd().equals("Butterfree")) {
                    g.drawString(bil1.getKartlistesi().get(indistut1).getPokemonAd(), 211, 105);
                    g.drawString(bil1.getKartlistesi().get(indistut1).hasarpuanigoster(new Butterfree().getHasarpuani()), 242, 136);
                }
                if (bil1.getKartlistesi().get(indistut1).getPokemonAd().equals("Psyduck")) {
                    g.drawString(bil1.getKartlistesi().get(indistut1).getPokemonAd(), 216, 105);
                    g.drawString(bil1.getKartlistesi().get(indistut1).hasarpuanigoster(new Psyduck().getHasarpuani()), 242, 136);
                }
                if (bil1.getKartlistesi().get(indistut1).getPokemonAd().equals("Charmander")) {
                    g.drawString(bil1.getKartlistesi().get(indistut1).getPokemonAd(), 201, 105);
                    g.drawString(bil1.getKartlistesi().get(indistut1).hasarpuanigoster(new Charmander().getHasarpuani()), 242, 136);
                }
                if (bil1.getKartlistesi().get(indistut1).getPokemonAd().equals("Jigglypuff")) {
                    g.drawString(bil1.getKartlistesi().get(indistut1).getPokemonAd(), 211, 105);
                    g.drawString(bil1.getKartlistesi().get(indistut1).hasarpuanigoster(new Jigglypuff().getHasarpuani()), 242, 136);
                }
                if (bil1.getKartlistesi().get(indistut1).getPokemonAd().equals("Snorlax")) {
                    g.drawString(bil1.getKartlistesi().get(indistut1).getPokemonAd(), 220, 105);
                    g.drawString(bil1.getKartlistesi().get(indistut1).hasarpuanigoster(new Snorlax().getHasarpuani()), 242, 136);
                }
                if (bil1.getKartlistesi().get(indistut1).getPokemonAd().equals("Meowth")) {
                    g.drawString(bil1.getKartlistesi().get(indistut1).getPokemonAd(), 220, 105);
                    g.drawString(bil1.getKartlistesi().get(indistut1).hasarpuanigoster(new Meowth().getHasarpuani()), 242, 136);
                }
                if (bil1.getKartlistesi().get(indistut1).getPokemonAd().equals("Squirtle")) {
                    g.drawString(bil1.getKartlistesi().get(indistut1).getPokemonAd(), 221, 105);
                    g.drawString(bil1.getKartlistesi().get(indistut1).hasarpuanigoster(new Squirtle().getHasarpuani()), 242, 136);
                }
                if (bil1.getKartlistesi().get(indistut1).getPokemonAd().equals("Zubat")) {
                    g.drawString(bil1.getKartlistesi().get(indistut1).getPokemonAd(), 229, 105);
                    g.drawString(bil1.getKartlistesi().get(indistut1).hasarpuanigoster(new Zubat().getHasarpuani()), 242, 136);
                }
            }
            if (indistut1 == 1) {
                g.setColor(Color.white);
                g.fillRect(350, 70, 95, 95);
                g.setColor(new Color(173, 6, 6));
                g.setFont(new Font("Timesroman", Font.PLAIN, 17));
                if (bil1.getKartlistesi().get(indistut1).getPokemonAd().equals("Pikachu")) {
                    g.drawString(bil1.getKartlistesi().get(indistut1).getPokemonAd(), 367, 105);
                    g.drawString(bil1.getKartlistesi().get(indistut1).hasarpuanigoster(new Pikachu().getHasarpuani()), 392, 136);
                }
                if (kartlistesibil1.get(indistut1).getPokemonAd().equals("Bulbasaur")) {
                    g.drawString(bil1.getKartlistesi().get(indistut1).getPokemonAd(), 361, 105);
                    g.drawString(bil1.getKartlistesi().get(indistut1).hasarpuanigoster(new Bulbasaur().getHasarpuani()), 392, 136);
                }
                if (bil1.getKartlistesi().get(indistut1).getPokemonAd().equals("Butterfree")) {
                    g.drawString(bil1.getKartlistesi().get(indistut1).getPokemonAd(), 361, 105);
                    g.drawString(bil1.getKartlistesi().get(indistut1).hasarpuanigoster(new Butterfree().getHasarpuani()), 392, 136);
                }
                if (bil1.getKartlistesi().get(indistut1).getPokemonAd().equals("Psyduck")) {
                    g.drawString(bil1.getKartlistesi().get(indistut1).getPokemonAd(), 365, 105);
                    g.drawString(bil1.getKartlistesi().get(indistut1).hasarpuanigoster(new Psyduck().getHasarpuani()), 392, 136);
                }
                if (bil1.getKartlistesi().get(indistut1).getPokemonAd().equals("Charmander")) {
                    g.drawString(bil1.getKartlistesi().get(indistut1).getPokemonAd(), 353, 105);
                    g.drawString(bil1.getKartlistesi().get(indistut1).hasarpuanigoster(new Charmander().getHasarpuani()), 392, 136);
                }
                if (bil1.getKartlistesi().get(indistut1).getPokemonAd().equals("Jigglypuff")) {
                    g.drawString(bil1.getKartlistesi().get(indistut1).getPokemonAd(), 362, 105);
                    g.drawString(bil1.getKartlistesi().get(indistut1).hasarpuanigoster(new Jigglypuff().getHasarpuani()), 392, 136);
                }
                if (bil1.getKartlistesi().get(indistut1).getPokemonAd().equals("Snorlax")) {
                    g.drawString(bil1.getKartlistesi().get(indistut1).getPokemonAd(), 368, 105);
                    g.drawString(bil1.getKartlistesi().get(indistut1).hasarpuanigoster(new Snorlax().getHasarpuani()), 392, 136);
                }
                if (bil1.getKartlistesi().get(indistut1).getPokemonAd().equals("Meowth")) {
                    g.drawString(bil1.getKartlistesi().get(indistut1).getPokemonAd(), 368, 105);
                    g.drawString(bil1.getKartlistesi().get(indistut1).hasarpuanigoster(new Meowth().getHasarpuani()), 392, 136);
                }
                if (bil1.getKartlistesi().get(indistut1).getPokemonAd().equals("Squirtle")) {
                    g.drawString(bil1.getKartlistesi().get(indistut1).getPokemonAd(), 372, 105);
                    g.drawString(bil1.getKartlistesi().get(indistut1).hasarpuanigoster(new Squirtle().getHasarpuani()), 392, 136);
                }
                if (bil1.getKartlistesi().get(indistut1).getPokemonAd().equals("Zubat")) {
                    g.drawString(bil1.getKartlistesi().get(indistut1).getPokemonAd(), 380, 105);
                    g.drawString(bil1.getKartlistesi().get(indistut1).hasarpuanigoster(new Zubat().getHasarpuani()), 392, 136);
                }

            }
            if (indistut1 == 2) {
                g.setColor(Color.white);
                g.fillRect(500, 70, 95, 95);
                g.setColor(new Color(173, 6, 6));
                g.setFont(new Font("Timesroman", Font.PLAIN, 17));
                if (bil1.getKartlistesi().get(indistut1).getPokemonAd().equals("Pikachu")) {
                    g.drawString(bil1.getKartlistesi().get(indistut1).getPokemonAd(), 517, 105);
                    g.drawString(bil1.getKartlistesi().get(indistut1).hasarpuanigoster(new Pikachu().getHasarpuani()), 540, 136);
                }
                if (bil1.getKartlistesi().get(indistut1).getPokemonAd().equals("Bulbasaur")) {
                    g.drawString(bil1.getKartlistesi().get(indistut1).getPokemonAd(), 509, 105);
                    g.drawString(bil1.getKartlistesi().get(indistut1).hasarpuanigoster(new Bulbasaur().getHasarpuani()), 540, 136);
                }
                if (bil1.getKartlistesi().get(indistut1).getPokemonAd().equals("Butterfree")) {
                    g.drawString(bil1.getKartlistesi().get(indistut1).getPokemonAd(), 509, 105);
                    g.drawString(bil1.getKartlistesi().get(indistut1).hasarpuanigoster(new Butterfree().getHasarpuani()), 540, 136);
                }
                if (bil1.getKartlistesi().get(indistut1).getPokemonAd().equals("Psyduck")) {
                    g.drawString(bil1.getKartlistesi().get(indistut1).getPokemonAd(), 522, 105);
                    g.drawString(bil1.getKartlistesi().get(indistut1).hasarpuanigoster(new Psyduck().getHasarpuani()), 540, 136);
                }
                if (bil1.getKartlistesi().get(indistut1).getPokemonAd().equals("Charmander")) {
                    g.drawString(bil1.getKartlistesi().get(indistut1).getPokemonAd(), 502, 105);
                    g.drawString(bil1.getKartlistesi().get(indistut1).hasarpuanigoster(new Charmander().getHasarpuani()), 540, 136);
                }
                if (bil1.getKartlistesi().get(indistut1).getPokemonAd().equals("Jigglypuff")) {
                    g.drawString(bil1.getKartlistesi().get(indistut1).getPokemonAd(), 509, 105);
                    g.drawString(bil1.getKartlistesi().get(indistut1).hasarpuanigoster(new Jigglypuff().getHasarpuani()), 540, 136);
                }
                if (bil1.getKartlistesi().get(indistut1).getPokemonAd().equals("Meowth")) {
                    g.drawString(bil1.getKartlistesi().get(indistut1).getPokemonAd(), 519, 105);
                    g.drawString(bil1.getKartlistesi().get(indistut1).hasarpuanigoster(new Meowth().getHasarpuani()), 540, 136);
                }
                if (bil1.getKartlistesi().get(indistut1).getPokemonAd().equals("Snorlax")) {
                    g.drawString(bil1.getKartlistesi().get(indistut1).getPokemonAd(), 520, 105);
                    g.drawString(bil1.getKartlistesi().get(indistut1).hasarpuanigoster(new Snorlax().getHasarpuani()), 540, 136);
                }
                if (bil1.getKartlistesi().get(indistut1).getPokemonAd().equals("Squirtle")) {
                    g.drawString(bil1.getKartlistesi().get(indistut1).getPokemonAd(), 519, 105);
                    g.drawString(bil1.getKartlistesi().get(indistut1).hasarpuanigoster(new Squirtle().getHasarpuani()), 540, 136);
                }
                if (bil1.getKartlistesi().get(indistut1).getPokemonAd().equals("Zubat")) {
                    g.drawString(bil1.getKartlistesi().get(indistut1).getPokemonAd(), 525, 105);
                    g.drawString(bil1.getKartlistesi().get(indistut1).hasarpuanigoster(new Zubat().getHasarpuani()), 540, 136);
                }
            }
            g.setColor(Color.darkGray);
            g.fillRect(50, 230, 150, 150);
            String size = Integer.toString(kartlistesi.size());
            g.setColor(Color.WHITE);
            g.setFont(new Font("Timesroman", Font.PLAIN, 21));
            g.drawString(size, 90, 255);
        }
    }

    private void kartdagit2() {
        Graphics g = getGraphics();
        if (kartlistesi.size() > 0) {
            in1.getKartlistesi().set(indistut2, kartlistesi.get(0));
            kartlistesi.remove(0);
            if (indistut2 == 0) {
                g.setColor(Color.white);
                g.fillRect(200, 395, 95, 95);
                g.setColor(new Color(173, 6, 6));
                g.setFont(new Font("Timesroman", Font.PLAIN, 17));
                if (in1.getKartlistesi().get(indistut2).getPokemonAd().equals("Pikachu")) {
                    g.drawString(in1.getKartlistesi().get(indistut2).getPokemonAd(), 218, 434);
                    g.drawString(in1.getKartlistesi().get(indistut2).hasarpuanigoster(new Pikachu().getHasarpuani()), 242, 466);
                }
                if (in1.getKartlistesi().get(indistut2).getPokemonAd().equals("Bulbasaur")) {
                    g.drawString(in1.getKartlistesi().get(indistut2).getPokemonAd(), 211, 434);
                    g.drawString(in1.getKartlistesi().get(indistut2).hasarpuanigoster(new Bulbasaur().getHasarpuani()), 242, 466);
                }
                if (in1.getKartlistesi().get(indistut2).getPokemonAd().equals("Butterfree")) {
                    g.drawString(in1.getKartlistesi().get(indistut2).getPokemonAd(), 211, 434);
                    g.drawString(in1.getKartlistesi().get(indistut2).hasarpuanigoster(new Butterfree().getHasarpuani()), 242, 466);
                }
                if (in1.getKartlistesi().get(indistut2).getPokemonAd().equals("Psyduck")) {
                    g.drawString(in1.getKartlistesi().get(indistut2).getPokemonAd(), 216, 434);
                    g.drawString(in1.getKartlistesi().get(indistut2).hasarpuanigoster(new Psyduck().getHasarpuani()), 242, 466);
                }
                if (in1.getKartlistesi().get(indistut2).getPokemonAd().equals("Charmander")) {
                    g.drawString(in1.getKartlistesi().get(indistut2).getPokemonAd(), 201, 434);
                    g.drawString(in1.getKartlistesi().get(indistut2).hasarpuanigoster(new Charmander().getHasarpuani()), 242, 466);
                }
                if (in1.getKartlistesi().get(indistut2).getPokemonAd().equals("Jigglypuff")) {
                    g.drawString(in1.getKartlistesi().get(indistut2).getPokemonAd(), 211, 434);
                    g.drawString(in1.getKartlistesi().get(indistut2).hasarpuanigoster(new Jigglypuff().getHasarpuani()), 242, 466);
                }
                if (in1.getKartlistesi().get(indistut2).getPokemonAd().equals("Snorlax")) {
                    g.drawString(in1.getKartlistesi().get(indistut2).getPokemonAd(), 220, 434);
                    g.drawString(in1.getKartlistesi().get(indistut2).hasarpuanigoster(new Snorlax().getHasarpuani()), 242, 466);
                }
                if (in1.getKartlistesi().get(indistut2).getPokemonAd().equals("Meowth")) {
                    g.drawString(in1.getKartlistesi().get(indistut2).getPokemonAd(), 220, 434);
                    g.drawString(in1.getKartlistesi().get(indistut2).hasarpuanigoster(new Meowth().getHasarpuani()), 242, 466);
                }
                if (in1.getKartlistesi().get(indistut2).getPokemonAd().equals("Squirtle")) {
                    g.drawString(in1.getKartlistesi().get(indistut2).getPokemonAd(), 221, 434);
                    g.drawString(in1.getKartlistesi().get(indistut2).hasarpuanigoster(new Squirtle().getHasarpuani()), 242, 466);
                }
                if (in1.getKartlistesi().get(indistut2).getPokemonAd().equals("Zubat")) {
                    g.drawString(in1.getKartlistesi().get(indistut2).getPokemonAd(), 229, 434);
                    g.drawString(in1.getKartlistesi().get(indistut2).hasarpuanigoster(new Zubat().getHasarpuani()), 242, 466);
                }
            }
            if (indistut2 == 1) {
                g.setColor(Color.white);
                g.fillRect(350, 395, 95, 95);
                g.setColor(new Color(173, 6, 6));
                g.setFont(new Font("Timesroman", Font.PLAIN, 17));
                if (in1.getKartlistesi().get(indistut2).getPokemonAd().equals("Pikachu")) {
                    g.drawString(in1.getKartlistesi().get(indistut2).getPokemonAd(), 367, 434);
                    g.drawString(in1.getKartlistesi().get(indistut2).hasarpuanigoster(new Pikachu().getHasarpuani()), 392, 466);
                }
                if (in1.getKartlistesi().get(indistut2).getPokemonAd().equals("Bulbasaur")) {
                    g.drawString(in1.getKartlistesi().get(indistut2).getPokemonAd(), 361, 434);
                    g.drawString(in1.getKartlistesi().get(indistut2).hasarpuanigoster(new Bulbasaur().getHasarpuani()), 392, 466);
                }
                if (in1.getKartlistesi().get(indistut2).getPokemonAd().equals("Butterfree")) {
                    g.drawString(in1.getKartlistesi().get(indistut2).getPokemonAd(), 361, 434);
                    g.drawString(in1.getKartlistesi().get(indistut2).hasarpuanigoster(new Butterfree().getHasarpuani()), 392, 466);
                }
                if (in1.getKartlistesi().get(indistut2).getPokemonAd().equals("Psyduck")) {
                    g.drawString(in1.getKartlistesi().get(indistut2).getPokemonAd(), 365, 434);
                    g.drawString(in1.getKartlistesi().get(indistut2).hasarpuanigoster(new Psyduck().getHasarpuani()), 392, 466);
                }
                if (in1.getKartlistesi().get(indistut2).getPokemonAd().equals("Charmander")) {
                    g.drawString(in1.getKartlistesi().get(indistut2).getPokemonAd(), 353, 434);
                    g.drawString(in1.getKartlistesi().get(indistut2).hasarpuanigoster(new Charmander().getHasarpuani()), 392, 466);
                }
                if (in1.getKartlistesi().get(indistut2).getPokemonAd().equals("Jigglypuff")) {
                    g.drawString(in1.getKartlistesi().get(indistut2).getPokemonAd(), 362, 434);
                    g.drawString(in1.getKartlistesi().get(indistut2).hasarpuanigoster(new Jigglypuff().getHasarpuani()), 392, 466);
                }
                if (in1.getKartlistesi().get(indistut2).getPokemonAd().equals("Snorlax")) {
                    g.drawString(in1.getKartlistesi().get(indistut2).getPokemonAd(), 368, 434);
                    g.drawString(in1.getKartlistesi().get(indistut2).hasarpuanigoster(new Snorlax().getHasarpuani()), 392, 466);
                }
                if (in1.getKartlistesi().get(indistut2).getPokemonAd().equals("Meowth")) {
                    g.drawString(in1.getKartlistesi().get(indistut2).getPokemonAd(), 368, 434);
                    g.drawString(in1.getKartlistesi().get(indistut2).hasarpuanigoster(new Meowth().getHasarpuani()), 392, 466);
                }
                if (in1.getKartlistesi().get(indistut2).getPokemonAd().equals("Squirtle")) {
                    g.drawString(in1.getKartlistesi().get(indistut2).getPokemonAd(), 372, 434);
                    g.drawString(in1.getKartlistesi().get(indistut2).hasarpuanigoster(new Squirtle().getHasarpuani()), 392, 466);
                }
                if (in1.getKartlistesi().get(indistut2).getPokemonAd().equals("Zubat")) {
                    g.drawString(in1.getKartlistesi().get(indistut2).getPokemonAd(), 380, 434);
                    g.drawString(in1.getKartlistesi().get(indistut2).hasarpuanigoster(new Zubat().getHasarpuani()), 392, 466);
                }
            }
            if (indistut2 == 2) {
                g.setColor(Color.white);
                g.fillRect(500, 395, 95, 95);
                g.setColor(new Color(173, 6, 6));
                g.setFont(new Font("Timesroman", Font.PLAIN, 17));
                if (in1.getKartlistesi().get(indistut2).getPokemonAd().equals("Pikachu")) {
                    g.drawString(in1.getKartlistesi().get(indistut2).getPokemonAd(), 517, 434);
                    g.drawString(in1.getKartlistesi().get(indistut2).hasarpuanigoster(new Pikachu().getHasarpuani()), 540, 464);
                }
                if (in1.getKartlistesi().get(indistut2).getPokemonAd().equals("Bulbasaur")) {
                    g.drawString(in1.getKartlistesi().get(indistut2).getPokemonAd(), 509, 434);
                    g.drawString(in1.getKartlistesi().get(indistut2).hasarpuanigoster(new Bulbasaur().getHasarpuani()), 540, 464);
                }
                if (in1.getKartlistesi().get(indistut2).getPokemonAd().equals("Butterfree")) {
                    g.drawString(in1.getKartlistesi().get(indistut2).getPokemonAd(), 509, 434);
                    g.drawString(in1.getKartlistesi().get(indistut2).hasarpuanigoster(new Butterfree().getHasarpuani()), 540, 464);
                }
                if (in1.getKartlistesi().get(indistut2).getPokemonAd().equals("Psyduck")) {
                    g.drawString(in1.getKartlistesi().get(indistut2).getPokemonAd(), 522, 434);
                    g.drawString(in1.getKartlistesi().get(indistut2).hasarpuanigoster(new Psyduck().getHasarpuani()), 540, 464);
                }
                if (in1.getKartlistesi().get(indistut2).getPokemonAd().equals("Charmander")) {
                    g.drawString(in1.getKartlistesi().get(indistut2).getPokemonAd(), 502, 434);
                    g.drawString(in1.getKartlistesi().get(indistut2).hasarpuanigoster(new Charmander().getHasarpuani()), 540, 464);
                }
                if (in1.getKartlistesi().get(indistut2).getPokemonAd().equals("Jigglypuff")) {
                    g.drawString(in1.getKartlistesi().get(indistut2).getPokemonAd(), 509, 434);
                    g.drawString(in1.getKartlistesi().get(indistut2).hasarpuanigoster(new Jigglypuff().getHasarpuani()), 540, 464);
                }
                if (in1.getKartlistesi().get(indistut2).getPokemonAd().equals("Meowth")) {
                    g.drawString(in1.getKartlistesi().get(indistut2).getPokemonAd(), 519, 434);
                    g.drawString(in1.getKartlistesi().get(indistut2).hasarpuanigoster(new Meowth().getHasarpuani()), 540, 464);
                }
                if (in1.getKartlistesi().get(indistut2).getPokemonAd().equals("Snorlax")) {
                    g.drawString(in1.getKartlistesi().get(indistut2).getPokemonAd(), 520, 434);
                    g.drawString(in1.getKartlistesi().get(indistut2).hasarpuanigoster(new Snorlax().getHasarpuani()), 540, 464);
                }
                if (in1.getKartlistesi().get(indistut2).getPokemonAd().equals("Squirtle")) {
                    g.drawString(in1.getKartlistesi().get(indistut2).getPokemonAd(), 519, 434);
                    g.drawString(in1.getKartlistesi().get(indistut2).hasarpuanigoster(new Squirtle().getHasarpuani()), 540, 464);
                }
                if (in1.getKartlistesi().get(indistut2).getPokemonAd().equals("Zubat")) {
                    g.drawString(in1.getKartlistesi().get(indistut2).getPokemonAd(), 525, 434);
                    g.drawString(in1.getKartlistesi().get(indistut2).hasarpuanigoster(new Zubat().getHasarpuani()), 540, 464);
                }

            }
            g.setColor(Color.darkGray);
            g.fillRect(50, 230, 150, 150);
            String size = Integer.toString(kartlistesi.size());
            g.setColor(Color.WHITE);
            g.setFont(new Font("Timesroman", Font.PLAIN, 21));
            g.drawString(size, 90, 255);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        baslangicciz(g);
        kartciz1(g, ad1, indistut1);
        kartciz2(g, ad2, indistut2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (tur % 2 != 0 && indistut2 != -1) {
            kartcek2(indistut2);
            kartyok2();
            tur++;
        }
        if (tur % 2 == 0) {
            kartcek1();
            kartyok1();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            kartlariac1();
            kartlariac2();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            skorgoster();
            ortayitemizle();
            kartdagit1();
            kartdagit2();
            indistut2 = -1;
            tur++;
        }
        if (tur > 10) {
            kazananbelirle();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            zaman.stop();
            Main.pvspekran.setVisible(false);
            Main.frame.setVisible(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getX() > 200 && e.getX() < 295 && e.getY() > 395 && e.getY() < 490) {
            indistut2 = 0;
        }
        if (e.getX() > 350 && e.getX() < 445 && e.getY() > 395 && e.getY() < 490) {
            indistut2 = 1;
        }
        if (e.getX() > 500 && e.getX() < 595 && e.getY() > 395 && e.getY() < 490) {
            indistut2 = 2;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
