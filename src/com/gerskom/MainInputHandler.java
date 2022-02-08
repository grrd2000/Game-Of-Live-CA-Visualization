package com.gerskom;

import java.awt.event.*;
import java.io.IOException;

public class MainInputHandler implements KeyListener, MouseListener {
    SimulationPanel simulationPanel;

    public MainInputHandler(SimulationPanel simulationPanel) {
        this.simulationPanel = simulationPanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case '\n' -> {
                if (!simulationPanel.started) {
                    simulationPanel.pause = false;
                    System.out.println("\n~START~\n");
                    simulationPanel.startGameOfLife();
                }
            }
            case ' ' -> {
                simulationPanel.pause = true;
                System.out.println("~PAUSE~");
            }

            case 'f' -> {
                try {
                    simulationPanel.map.exportImage("game_of_life");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            case 'r' -> {
                simulationPanel.map.addRandomCells();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


    @Override
    public void mousePressed(MouseEvent e) {
        int x = simulationPanel.getMousePosition().x;
        int y = simulationPanel.getMousePosition().y;

        switch (e.getButton()) {
            case 1 -> simulationPanel.map.addSquareOfCells(x, y, 50);
            case 2 -> simulationPanel.map.addCell(x, y);
            case 3 -> simulationPanel.map.addSquareOfCells(x, y, 150);
        }
        simulationPanel.map.dataCopier();
        simulationPanel.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
