package com.ahilessprime.gameLife;

import com.ahilessprime.gameLife.GUI.Window;
import com.ahilessprime.gameLife.Map.StandartGameField;
import com.ahilessprime.gameLife.gamer.StandartPlayer;

public class GameLife {


    //ссылка окно программы
    private Window window;
    //ссылка на поле игры
    private StandartGameField standartGF;
    //булевая ссылка на объекты
    private boolean[][] booleanGameMap;
    //получаем длинну осей
    private int[] lengthYX;
    //ссылка на игрока
    private StandartPlayer standartPlayer;

    //следит за тем, нажатали кнопка игры
    private boolean inGame;
    private boolean newGenerationField;


    public GameLife(){
        //иниц. игровое поле
        standartGF = new StandartGameField();
        //запускаем окно программы
        window = new Window(standartGF);
        //получаем булевую карту
        booleanGameMap=standartGF.getBooleanGameMap();
        //получаем длинну осей
        lengthYX=standartGF.getLengthYX();

        //создаем объект игрока
        standartPlayer = new StandartPlayer(booleanGameMap,lengthYX);






        //standartGF.repaint(); //перерисовка массива карты


        //запуск итерации игры
        iteration();
    }


    private void iteration(){


        while (true){

            inGame=window.getInGame();
            newGenerationField=window.getGenerationField();

            if (newGenerationField){
                standartPlayer.newGenerationField();
                newGenerationField=false;
            }

            try {

                while (inGame){
                    standartPlayer.start();
                    Thread.sleep(200);
                    standartGF.repaint();
                    this.inGame=window.getInGame();
                }
            }catch (InterruptedException e){}

            standartGF.repaint();
        }
    }

}
