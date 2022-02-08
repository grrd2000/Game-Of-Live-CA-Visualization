package com.gerskom;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        /*int width = 1200, timeSteps = 1200, rule;

        Grid map_1 = new Grid(width, timeSteps);

        map_1.table[width / 2 - 2][0] = 1;
        map_1.table[width / 2 - 1][0] = 1;
        //map_1.table[width / 2][0] = 1;
        map_1.table[width / 2 + 1][0] = 1;

        for (int i = 1; i <= 255; i++) {
            rule = i;
            map_1.oneDimSimulation(rule);
            map_1.exportImage("r" + rule + ".bmp");
        }

        //Scanner scanner = new Scanner(System.in);
        //System.out.print("\nRULE: ");
        //rule = scanner.nextInt();

        //map_1.oneDimSimulation(rule);
        //map_1.exportImage("r" + rule + ".png");*/

        //int width = 800, height = 800, timeSteps = 1500, nMax = 150000;
        //Grid map = new Grid(width, height, timeSteps, nMax);
//
        ///*map.table[5][4] = 1;
        //map.table[6][4] = 1;
        //map.table[4][5] = 1;
        //map.table[7][5] = 1;
        //map.table[5][6] = 1;
        //map.table[6][6] = 1;*/    //beehive
//
        ///*map.table[4][4] = 1;
        //map.table[4][5] = 1;
        //map.table[4][6] = 1;*/    //oscillator
//
        //for(int c = 0; c < nMax; c++) {
        //    Random ran = new Random();
        //    int x = ran.nextInt(width - 2) + 1;
        //    int y = ran.nextInt(height - 2) + 1;
        //    map.table[x][y] = 1;
        //}
//
        //new MainFrame(map);

        //for(int i = 0; i <= timeSteps; i++) {
        //    System.out.println(i);
        //    map.exportImage("game_" + i);
        //    map.twoDimSimulation();
        //}

        new GameOfLife();
    }
}
