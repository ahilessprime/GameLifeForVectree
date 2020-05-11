package com.ahilessprime.gameLife.Map;

import javax.swing.*;
import com.ahilessprime.gameLife.sourceString;

import java.awt.*;

public class StandartGameField extends JPanel {

    //ширина и высота панели отображения карты
    private int width_field, height_field;
    //размер одной ячейки
    private final int DOT_RADIUS = 10;

    //количество ячеек по X координат
    private int full_dots_X;
    //количество ячеек по Y кординат
    private int full_dots_Y;

    //массив координат карты игры
    private boolean[][] booleanGameMap;

    //массив графических ячеек, карты игры
    private GamerDot [][] gamerDots;




    public StandartGameField(){
        width_field=sourceString.SIZE_WIDTH_GAME_FIELD;
        height_field=sourceString.SIZE_HEIGHT_GAME_FIELD;

        //определяем количество возможных точек на карте
        amountOfDots(DOT_RADIUS, width_field, height_field);

        //создаем массив координат карты игры
        booleanGameMap = new boolean[full_dots_Y][full_dots_X];

        //инициализируем графическую карту игры
        initGraficField();


        //графически визиализируем карту игры
        setLayout( //задаем правила размещения графических объект на карте
                new GridLayout //строгая компоновка. размещает объекты слева направо
                               //и сверху вниз, в равномерных клетках.
                (full_dots_Y,full_dots_X, //количество размещаемых  графических объектов по осям
                        0,0)); //интервал между объектами в пикселях
        //размещаем оюъекты на карте
        for (int y = 0; y < full_dots_Y; y++){
            for (int x = 0; x < full_dots_X; x++){
                add(gamerDots[y][x]); //добавляем ячейки по их координатам
            }
        }


    }

    @Override
    public void repaint(){ //метод перерисовывает карту согласно булевой карте игры
        for (int y = 0; y<full_dots_Y; y++){
            for (int x = 0; x<full_dots_X; x++){
                //если ячейка жива, задаем ему черный цвет
                if(booleanGameMap[y][x]) gamerDots[y][x].setBackground(Color.BLACK);
                else gamerDots[y][x].setBackground(Color.WHITE); //иначе белую
            }
        }
    }

    public boolean[][] getBooleanGameMap() { //возвращает булевую карту
        return booleanGameMap;
    }
    public int[] getLengthYX(){ //геттер размера карты по осям
        int[] lengthYX=new int[]{full_dots_Y,full_dots_X};
        return lengthYX;
    }


    //метод создает массив координат карты игры
    private void amountOfDots(int Dot_radius, int width_field, int height_field){
        //размер карты по осям делим на радиус ячейки
        full_dots_X =width_field/Dot_radius;
        full_dots_Y =height_field/Dot_radius;
        //в итоге получаем, сколько в себе содержит ячеек, каждая из осей
    }
    //инициализируем графическую карту игры
    private  void initGraficField(){
        //создаем массив длинною количества ячеек по осям
        // Y имеет вид столбцов, а Х имеет вид строк
        gamerDots = new GamerDot[full_dots_Y][full_dots_X];
        //создаем графический объект каждой из ячейки
        for (int y = 0; y<full_dots_Y; y++){ //столбцы
            for (int x = 0; x<full_dots_X; x++){ //строки
                gamerDots[y][x]=new GamerDot();
            }

        }
    }


}


//тут какая то проблема с отрисовкой, щееееет, реши
//все норм, поправил
class  GamerDot extends Canvas{
}
