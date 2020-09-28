package classlar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class menu extends JPanel implements MouseListener {

    public menu() {
        addMouseListener(this);
    }
    public void paint(Graphics g) {
        super.paint(g);
        setBackground(Color.darkGray);
        g.setColor(Color.WHITE);
        g.fillRect(150, 200, 200, 75);
        g.fillRect(435, 200, 200, 75);
        g.fillRect(290, 325, 200, 75);
        g.setFont(new Font("Timesroman", Font.PLAIN, 40));
        g.drawString("Pokemon Kart Oyunu", 200, 100);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Timesroman", Font.PLAIN, 19));
        g.drawString("Player vs Computer", 167, 243);
        g.setFont(new Font("Timesroman", Font.PLAIN, 18));
        g.drawString("Computer vs Computer", 441, 243);
        g.setFont(new Font("Timesroman", Font.PLAIN, 20));
        g.drawString("Exit", 373, 370);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getX() >= 150 && e.getX() <= 350 && e.getY() >= 200 && e.getY() <= 275) {
            Main.pvspekran.add(new playervscomputer());
            Main.frame.setVisible(false);
            Main.pvspekran.setVisible(true);
        } else if (e.getX() >= 435 && e.getX() <= 635 && e.getY() >= 200 && e.getY() <= 275) {
            Main.cvscekran.add(new computervscomputer());
            Main.frame.setVisible(false);
            Main.cvscekran.setVisible(true);
        } else if (e.getX() >= 290 && e.getX() <= 490 && e.getY() >= 325 && e.getY() <= 400) {
            System.exit(0);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
