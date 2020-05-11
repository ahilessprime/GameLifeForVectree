package com.ahilessprime.gameLife.GUI;

import javax.swing.*;
import com.ahilessprime.gameLife.sourceString;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements game_GUI_Interface {

    //родительская панель
    private JPanel parentPanel;
    //панель для размещения игровой карты
    private JPanel fieldPanel;
    //панель расположения кнопок
    private JPanel buttonPanel;
    //кнопка для генерации поля
    private JButton generationButton;
    //кнопка инициализации - для старта, остановки игры
    private JButton ingameButton;


    //игровая карта
    private JPanel gameFieldPanel;

    //статус активности игры
    private Boolean inGame = false;

    //нужна ли новая генерация карты
    private Boolean generationField = false; // !!! обратите внемание на геттер переменной !!!


    //стандарт конструктор
    public Window(JPanel gameFieldPanel){
        //титр к окне
        setTitle("Game Life");
        //размер окна
        setSize(600,400);
        //обработчик выхода из проги
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //запрети на изменение размера окна
        setResizable(false);
        //разместить окно по центру
        setLocationRelativeTo(null);

        this.gameFieldPanel=gameFieldPanel; //карта игры

        add(parentPanel); //добавляем в окно родительский панель, со всем его содержимым
        ingameButton.setText(sourceString.START); //задаем текст кнопке, инициализации игры
        generationButton.setText(sourceString.GENERATION); //текст кнопке генерации карты
        fieldPanel.add(gameFieldPanel); //передаем игровую карту, в окно его назначения


        setVisible(true);


        //назначаем слушатель событий кнопки, инициализации игры
        ingameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //в случай нажатия кнопки

                if(!inGame) inGame=true; //если игра не запущена - запускаем
                else inGame=false; //иначе останавливаем

                //меняем текст кнопки инициализации в зависимости от состояния игры
                ingameButton.setText(inGame?sourceString.STOP:sourceString.START);

                //если игра запущена
                if (inGame) generationButton.setEnabled(false); //отключаем кнопку генерации
                else generationButton.setEnabled(true); //иначе запускаем его
            }
        });

        //назначаем слушетель событий, для кнопки запроса генерации поля
        generationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generationField=true;
            }
        });
    }

    public Boolean getInGame(){
        return inGame;
    }

    public Boolean getGenerationField() {
        //создаем новую переменную и передаем ему значение
        boolean generationField = this.generationField;
        //родительскую пременную обнуляем
        this.generationField=false;

        //передаем дочернюю переменную
        return generationField;

        //вся эта хренотень сделанна для того что бы
        //обнулять кнопку запроса генерации, при этом
        //не потеряв его значение до передачи
    }



}
