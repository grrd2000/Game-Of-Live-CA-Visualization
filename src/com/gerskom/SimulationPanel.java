package com.gerskom;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SimulationPanel extends JPanel{
    public final Grid map;
    public boolean pause = true;
    public boolean started = false;

    public SimulationPanel (Grid grid) {
        super();
        this.map = grid;
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addMouseListener(new MainInputHandler(this));
        this.addKeyListener(new MainInputHandler(this));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g.create();

        for(int x = 0; x < map.width; x++){
            for(int y = 0; y < map.height; y++){
                if (map.table[x][y] == 0)
                    g2D.setColor(map.bgColor);
                else
                    g2D.setColor(map.cellColor);

                g2D.fillRect(x, y, 1, 1);
            }
        }
        g2D.dispose();

        this.requestFocusInWindow();
    }

    public void startGameOfLife(){
        Timer timer;
        started = true;

        if(!pause) {
            timer = new Timer(20, e -> {
                map.twoDimSimulation();
                repaint();
            });
            timer.start();
        }
    }
}
