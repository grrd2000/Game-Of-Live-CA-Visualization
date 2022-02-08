package com.gerskom;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Grid {
    public int width;
    public int height;
    private int timeSteps;
    public int nMax;
    public int[][] table;
    private final int[][] tmpTable;
    private final int[] ruleTab;
    public final Color bgColor = new Color(50, 50, 50);
    public final Color cellColor = new Color(250, 110, 0);

    public Grid(int width, int height, int nMax) {
        this.width = width;
        this.height = height;
        this.nMax = nMax;
        this.table = new int[width][height];
        this.ruleTab = new int[8];

        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                this.table[x][y] = 0;
        for (int i = 0; i < ruleTab.length; i++)
            this.ruleTab[i] = 0;

        this.tmpTable = new int[width][height];
        dataCopier();
    }

    public Grid(int width, int height, int timeSteps, int nMax) {
        this.width = width;
        this.height = height;
        this.timeSteps = timeSteps;
        this.nMax = nMax;
        this.table = new int[width][height];
        this.ruleTab = new int[8];

        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                this.table[x][y] = 0;
        for (int i = 0; i < ruleTab.length; i++)
            this.ruleTab[i] = 0;

        this.tmpTable = new int[width][height];
        dataCopier();
    }

    void oneDimSimulation(int rule) {
        String s_Rule = Integer.toBinaryString(rule);
        String[] t_Rule = s_Rule.split("");

        int j = ruleTab.length - 1;
        for(int i = t_Rule.length - 1; i >= 0; i--) {
            ruleTab[j] = Integer.parseInt(t_Rule[i]);
            j--;
        }

        for (int k : ruleTab) System.out.print(k);
        System.out.println();

        for (int y = 1; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (x != 0 && x != width - 1) {
                    if      (table[x - 1][y - 1] == 1 && table[x][y - 1] == 1 && table[x + 1][y - 1] == 1) table[x][y] = ruleTab[0];
                    else if (table[x - 1][y - 1] == 1 && table[x][y - 1] == 1 && table[x + 1][y - 1] == 0) table[x][y] = ruleTab[1];
                    else if (table[x - 1][y - 1] == 1 && table[x][y - 1] == 0 && table[x + 1][y - 1] == 1) table[x][y] = ruleTab[2];
                    else if (table[x - 1][y - 1] == 1 && table[x][y - 1] == 0 && table[x + 1][y - 1] == 0) table[x][y] = ruleTab[3];
                    else if (table[x - 1][y - 1] == 0 && table[x][y - 1] == 1 && table[x + 1][y - 1] == 1) table[x][y] = ruleTab[4];
                    else if (table[x - 1][y - 1] == 0 && table[x][y - 1] == 1 && table[x + 1][y - 1] == 0) table[x][y] = ruleTab[5];
                    else if (table[x - 1][y - 1] == 0 && table[x][y - 1] == 0 && table[x + 1][y - 1] == 1) table[x][y] = ruleTab[6];
                    else if (table[x - 1][y - 1] == 0 && table[x][y - 1] == 0 && table[x + 1][y - 1] == 0) table[x][y] = ruleTab[7];
                }
                else if (x == 0) {
                    if      (table[width - 1][y - 1] == 1 && table[x][y - 1] == 1 && table[x + 1][y - 1] == 1) table[x][y] = ruleTab[0];
                    else if (table[width - 1][y - 1] == 1 && table[x][y - 1] == 1 && table[x + 1][y - 1] == 0) table[x][y] = ruleTab[1];
                    else if (table[width - 1][y - 1] == 1 && table[x][y - 1] == 0 && table[x + 1][y - 1] == 1) table[x][y] = ruleTab[2];
                    else if (table[width - 1][y - 1] == 1 && table[x][y - 1] == 0 && table[x + 1][y - 1] == 0) table[x][y] = ruleTab[3];
                    else if (table[width - 1][y - 1] == 0 && table[x][y - 1] == 1 && table[x + 1][y - 1] == 1) table[x][y] = ruleTab[4];
                    else if (table[width - 1][y - 1] == 0 && table[x][y - 1] == 1 && table[x + 1][y - 1] == 0) table[x][y] = ruleTab[5];
                    else if (table[width - 1][y - 1] == 0 && table[x][y - 1] == 0 && table[x + 1][y - 1] == 1) table[x][y] = ruleTab[6];
                    else if (table[width - 1][y - 1] == 0 && table[x][y - 1] == 0 && table[x + 1][y - 1] == 0) table[x][y] = ruleTab[7];
                }
                else if (x == width - 1) {
                    if      (table[x - 1][y - 1] == 1 && table[x][y - 1] == 1 && table[0][y - 1] == 1) table[x][y] = ruleTab[0];
                    else if (table[x - 1][y - 1] == 1 && table[x][y - 1] == 1 && table[0][y - 1] == 0) table[x][y] = ruleTab[1];
                    else if (table[x - 1][y - 1] == 1 && table[x][y - 1] == 0 && table[0][y - 1] == 1) table[x][y] = ruleTab[2];
                    else if (table[x - 1][y - 1] == 1 && table[x][y - 1] == 0 && table[0][y - 1] == 0) table[x][y] = ruleTab[3];
                    else if (table[x - 1][y - 1] == 0 && table[x][y - 1] == 1 && table[0][y - 1] == 1) table[x][y] = ruleTab[4];
                    else if (table[x - 1][y - 1] == 0 && table[x][y - 1] == 1 && table[0][y - 1] == 0) table[x][y] = ruleTab[5];
                    else if (table[x - 1][y - 1] == 0 && table[x][y - 1] == 0 && table[0][y - 1] == 1) table[x][y] = ruleTab[6];
                    else if (table[x - 1][y - 1] == 0 && table[x][y - 1] == 0 && table[0][y - 1] == 0) table[x][y] = ruleTab[7];
                }
            }
        }
    }

    public void twoDimSimulation() {
        for(int x = 1; x < width - 1; x++) {
            for(int y = 1; y < height - 1; y++) {
                if(tmpTable[x][y] == 0 && neighbourScan(x, y) == 3)
                    table[x][y] = 1;
                else if(tmpTable[x][y] == 1 && (neighbourScan(x, y) > 3 || neighbourScan(x, y) < 2))
                    table[x][y] = 0;
            }
        }
        dataCopier();
    }

    int neighbourScan(int w, int h) {
        int counter = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (!(i == 0 && j == 0)) {
                    if (tmpTable[w + i][h + j] == 1) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    public void dataCopier() {
        for(int x = 0; x < width; x++)
            for(int y = 0; y < height; y++)
                this.tmpTable[x][y] = table[x][y];
    }

    public void addCell(int xCor, int yCor) {
        this.table[xCor][yCor] = 1;
    }

    public void addSquareOfCells(int xCor, int yCor, int size) {
        for (int x = xCor - (size / 2); x < xCor + (size / 2); x+=2) {
            for (int y = yCor - (size / 2); y < yCor + (size / 2); y++) {
                if(x > 0 && x < width && y > 0 && y < height)
                    addCell(x, y);
            }
        }
    }

    public void addRandomCells() {
        for(int c = 0; c < nMax; c++) {
            Random ran = new Random();
            int x = ran.nextInt(width - 2) + 1;
            int y = ran.nextInt(height - 2) + 1;
            addCell(x, y);
        }
    }

    public void exportImage(String fileName) throws IOException {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();

        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                if (table[x][y] == 0)
                    g2d.setColor(bgColor);
                else
                    g2d.setColor(cellColor);

                g2d.fillRect(x, y, 1, 1);
            }
        }
        g2d.dispose();

        String formatName = "png";
        File file = new File("output/" + fileName + "." + formatName);
        ImageIO.write(bufferedImage, formatName, file);
    }
}