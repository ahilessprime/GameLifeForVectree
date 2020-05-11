package com.ahilessprime.gameLife.gamer;

import java.util.Random;

public class StandartPlayer {

    private boolean [][] booleanGameMap; //булевая карта игры

    private int lengthY; //длинна карты по Y
    private int lengthX;

    public StandartPlayer(boolean[][] booleanGameMap, int[] lengthYX){
        this.booleanGameMap=booleanGameMap;
        lengthY=lengthYX[0];
        lengthX=lengthYX[1];
    }

    public void start(){
        for (int y = 0; y < lengthY; y++){
            for (int x = 0; x < lengthX; x++){
                int summTrueBoolean = sortirovka(y,x);
                if (!booleanGameMap[y][x] && summTrueBoolean==3) {
                    booleanGameMap[y][x] = true;
                }
                else if (booleanGameMap[y][x] && ( summTrueBoolean<2 | summTrueBoolean>3 ))
                    booleanGameMap[y][x]=false;
            }
        }
    }

    public void newGenerationField(){
        Random random=new Random();
        for (int y = 0; y < lengthY; y++){
            for (int x = 0; x < lengthX; x++){
                    booleanGameMap[y][x]=random.nextBoolean();

            }
        }
    }

    private int sortirovka(int y, int x){
        int[] Ysort = new int[] {y-1, y, y+1};
        int[] Xsort = new int[] {x-1, x, x+1};
        int summTrueBoolean=0;

        for (int Y =0; Y<Ysort.length; Y++){
            for (int X=0; X<Xsort.length; X++){
                if (Y==1&&X==1) continue;
                try {
                    if(booleanGameMap[Ysort[Y]][Xsort[X]]) summTrueBoolean++;
                }catch (ArrayIndexOutOfBoundsException e){}
            }
        }

        return summTrueBoolean;
    }

    private void setSummObject(int y, int x){
        for (int i=0; i <=8; i++);

    }


    public void setBooleanGameMap(boolean[][] booleanGameMap) {
        this.booleanGameMap = booleanGameMap;
    }
}
