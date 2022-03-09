import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class tic_tac_toe implements ActionListener{


    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    //JPanel restart_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton buttons[] = new JButton[9];
    JButton restart_button = new JButton();
    JButton bot_button = new JButton();
    boolean player1_turn;
    int timeplay = 0;
    boolean gameend = false;  
    boolean boton = false;

    tic_tac_toe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink free",Font.BOLD,50));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());

        button_panel.setBounds(0,200,500,500);
        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));
        

        for(int i = 0; i < 9; i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Ink free", Font.BOLD, 50));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this); 
        }

        restart_button.setFont(new Font("Ink free", Font.BOLD, 50));
        restart_button.setFocusable(false);
        restart_button.addActionListener(this);
        restart_button.setText("restart");

        bot_button.setFont(new Font("Ink free", Font.BOLD, 50));
        bot_button.setFocusable(false);
        bot_button.addActionListener(this);
        bot_button.setText("Bot : OFF");

        title_panel.add(textfield,"North");
        title_panel.add(restart_button,"Center");
        title_panel.add(bot_button,"South");

        frame.add(title_panel,"North");
        frame.add(button_panel);


        try {
            Thread.sleep(1000);
        }
        catch (Exception e) {
            // System.out.println(e);
        }
        random_start();
        
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == restart_button || e.getSource() == bot_button){
            for(int i =0; i < 9; i++){
                buttons[i].setText("");
            }
            gameend = false;
            timeplay = 0;
            if(e.getSource() == bot_button){
                if(boton == false){
                    boton = true;
                    bot_button.setText("Bot : ON");
                }
                else{
                    boton = false;
                    bot_button.setText("Bot : OFF");
                }
                
            }
            random_start();
            
        }
        else{
            if(boton == false){
                for(int i = 0; i < 9; i++){
                    if(e.getSource() == buttons[i] && buttons[i].getText() == "" && gameend  == false){
                        timeplay++;
                        // System.out.println(timeplay);
                        if(player1_turn){
                            buttons[i].setText("X");
                            textfield.setText("O turn");
                            player1_turn = false;
                        }
                        else{
                            buttons[i].setText("O");
                            textfield.setText("X turn");
                            player1_turn = true;
                        }
                        
                    }
                }
            }
            else{
                textfield.setText("X turn");
                for(int i = 0; i < 9; i++){
                    if(e.getSource() == buttons[i] && buttons[i].getText() == "" && gameend  == false){
                        timeplay++;
                        // System.out.println(timeplay);
                        buttons[i].setText("X");
                        check();
                        if(gameend == false){
                            bot_tech();
                            timeplay++;
                            // System.out.println(timeplay);
                        }
                        
                        
                    }
                }
            }
            
            check();
        }
        
        
    }

    public void random_start(){
        if(random.nextInt(2) == 1){
            player1_turn =true;
            textfield.setText("X turn");
        }
        else{
            player1_turn = false;
            if(boton == false) textfield.setText("O turn");
            else{
                textfield.setText("X turn");
                bot_tech();
                timeplay++;
                // System.out.println(timeplay);
                
            }
        }
    }
        

    public void check(){
        if(buttons[0].getText() == "X" &&
            buttons[1].getText() == "X" &&
            buttons[2].getText() == "X" || 
            buttons[3].getText() == "X" &&
            buttons[4].getText() == "X" &&
            buttons[5].getText() == "X" || 
            buttons[6].getText() == "X" &&
            buttons[7].getText() == "X" &&
            buttons[8].getText() == "X" || 
            buttons[0].getText() == "X" &&
            buttons[3].getText() == "X" &&
            buttons[6].getText() == "X" || 
            buttons[1].getText() == "X" &&
            buttons[4].getText() == "X" &&
            buttons[7].getText() == "X" || 
            buttons[2].getText() == "X" &&
            buttons[5].getText() == "X" &&
            buttons[8].getText() == "X" || 
            buttons[0].getText() == "X" &&
            buttons[4].getText() == "X" &&
            buttons[8].getText() == "X" || 
            buttons[2].getText() == "X" &&
            buttons[4].getText() == "X" &&
            buttons[6].getText() == "X"){
            textfield.setText("X win!");
            gameend = true;
        }
        else if(buttons[0].getText() == "O" &&
            buttons[1].getText() == "O" &&
            buttons[2].getText() == "O" || 
            buttons[3].getText() == "O" &&
            buttons[4].getText() == "O" &&
            buttons[5].getText() == "O" || 
            buttons[6].getText() == "O" &&
            buttons[7].getText() == "O" &&
            buttons[8].getText() == "O" || 
            buttons[0].getText() == "O" &&
            buttons[3].getText() == "O" &&
            buttons[6].getText() == "O" || 
            buttons[1].getText() == "O" &&
            buttons[4].getText() == "O" &&
            buttons[7].getText() == "O" || 
            buttons[2].getText() == "O" &&
            buttons[5].getText() == "O" &&
            buttons[8].getText() == "O" || 
            buttons[0].getText() == "O" &&
            buttons[4].getText() == "O" &&
            buttons[8].getText() == "O" || 
            buttons[2].getText() == "O" &&
            buttons[4].getText() == "O" &&
            buttons[6].getText() == "O"){
            textfield.setText("O win!");
            gameend = true;
        }
        else if(timeplay == 9){
            textfield.setText("Draw!");
            gameend = true;
        }

    }

    public void bot_tech(){
        if(timeplay == 0) buttons[6].setText("O");
        else if(timeplay == 1 && buttons[4].getText() == "") buttons[4].setText("O");
        else if(timeplay == 1 && buttons[4].getText() == "X") buttons[6].setText("O");
        else if(timeplay == 2 && 
                (buttons[5].getText() == "X" ||
                buttons[7].getText() == "X")) buttons[0].setText("O");
        else if(timeplay == 2 && 
                (buttons[1].getText() == "X" ||
                buttons[3].getText() == "X")) buttons[8].setText("O");
        else if(timeplay == 2 && buttons[3].getText() == "X") buttons[8].setText("O");
        else if(timeplay == 2 && (buttons[0].getText() == "X" || buttons[8].getText() == "X" )) buttons[4].setText("O");
        else if(timeplay == 2 && buttons[4].getText() == "X") buttons[2].setText("O");
        else if(timeplay == 2 && buttons[2].getText() == "X") buttons[4].setText("O");



        else if(buttons[3].getText() == "O" &&
            buttons[6].getText() == "O" &&
            buttons[0].getText() == "" ||
            buttons[8].getText() == "O" &&
            buttons[4].getText() == "O" &&
            buttons[0].getText() == "" ||
            buttons[2].getText() == "O" &&
            buttons[1].getText() == "O" &&
            buttons[0].getText() == ""){
            buttons[0].setText("O");
        }
        else if(buttons[0].getText() == "O" &&
            buttons[2].getText() == "O" &&
            buttons[1].getText() == "" ||
            buttons[4].getText() == "O" &&
            buttons[7].getText() == "O" &&
            buttons[1].getText() == ""){
            buttons[1].setText("O");
        }
        else if(buttons[0].getText() == "O" &&
            buttons[1].getText() == "O" &&
            buttons[2].getText() == "" ||
            buttons[6].getText() == "O" &&
            buttons[4].getText() == "O" &&
            buttons[2].getText() == "" ||
            buttons[5].getText() == "O" &&
            buttons[8].getText() == "O" &&
            buttons[2].getText() == ""){
            buttons[2].setText("O");
        }
        else if(buttons[0].getText() == "O" &&
            buttons[6].getText() == "O" &&
            buttons[3].getText() == "" ||
            buttons[5].getText() == "O" &&
            buttons[4].getText() == "O" &&
            buttons[3].getText() == ""){
            buttons[3].setText("O");
        }
        else if(buttons[0].getText() == "O" &&
            buttons[8].getText() == "O" &&
            buttons[4].getText() == "" ||
            buttons[1].getText() == "O" &&
            buttons[7].getText() == "O" &&
            buttons[4].getText() == "" ||
            buttons[2].getText() == "O" &&
            buttons[6].getText() == "O" &&
            buttons[4].getText() == "" ||
            buttons[3].getText() == "O" &&
            buttons[5].getText() == "O" &&
            buttons[4].getText() == ""){
            buttons[4].setText("O");
        }
        else if(buttons[2].getText() == "O" &&
            buttons[8].getText() == "O" &&
            buttons[5].getText() == "" ||
            buttons[3].getText() == "O" &&
            buttons[4].getText() == "O" &&
            buttons[5].getText() == ""){
            buttons[5].setText("O");
        }
        else if(buttons[0].getText() == "O" &&
            buttons[3].getText() == "O" &&
            buttons[6].getText() == "" ||
            buttons[7].getText() == "O" &&
            buttons[8].getText() == "O" &&
            buttons[6].getText() == "" ||
            buttons[2].getText() == "O" &&
            buttons[4].getText() == "O" &&
            buttons[6].getText() == ""){
            buttons[6].setText("O");
        }
        else if(buttons[1].getText() == "O" &&
            buttons[4].getText() == "O" &&
            buttons[7].getText() == "" ||
            buttons[6].getText() == "O" &&
            buttons[8].getText() == "O" &&
            buttons[7].getText() == ""){
            buttons[7].setText("O");
        }
        else if(buttons[2].getText() == "O" &&
            buttons[5].getText() == "O" &&
            buttons[8].getText() == "" ||
            buttons[0].getText() == "O" &&
            buttons[4].getText() == "O" &&
            buttons[8].getText() == "" ||
            buttons[6].getText() == "O" &&
            buttons[7].getText() == "O" &&
            buttons[8].getText() == ""){
            buttons[8].setText("O");
        }





        else if(buttons[3].getText() == "X" &&
            buttons[6].getText() == "X" &&
            buttons[0].getText() == "" ||
            buttons[8].getText() == "X" &&
            buttons[4].getText() == "X" &&
            buttons[0].getText() == "" ||
            buttons[2].getText() == "X" &&
            buttons[1].getText() == "X" &&
            buttons[0].getText() == ""){
                buttons[0].setText("O");
        }
        else if(buttons[0].getText() == "X" &&
                buttons[2].getText() == "X" &&
                buttons[1].getText() == "" ||
                buttons[4].getText() == "X" &&
                buttons[7].getText() == "X" &&
                buttons[1].getText() == ""){
            buttons[1].setText("O");
        }
        else if(buttons[0].getText() == "X" &&
                buttons[1].getText() == "X" &&
                buttons[2].getText() == "" ||
                buttons[6].getText() == "X" &&
                buttons[4].getText() == "X" &&
                buttons[2].getText() == "" ||
                buttons[5].getText() == "X" &&
                buttons[8].getText() == "X" &&
                buttons[2].getText() == ""){
            buttons[2].setText("O");
        }
        else if(buttons[0].getText() == "X" &&
                buttons[6].getText() == "X" &&
                buttons[3].getText() == "" ||
                buttons[5].getText() == "X" &&
                buttons[4].getText() == "X" &&
                buttons[3].getText() == ""){
            buttons[3].setText("O");
        }
        else if(buttons[0].getText() == "X" &&
                buttons[8].getText() == "X" &&
                buttons[4].getText() == "" ||
                buttons[1].getText() == "X" &&
                buttons[7].getText() == "X" &&
                buttons[4].getText() == "" ||
                buttons[2].getText() == "X" &&
                buttons[6].getText() == "X" &&
                buttons[4].getText() == "" ||
                buttons[3].getText() == "X" &&
                buttons[5].getText() == "X" &&
                buttons[4].getText() == ""){
            buttons[4].setText("O");
        }
        else if(buttons[2].getText() == "X" &&
                buttons[8].getText() == "X" &&
                buttons[5].getText() == "" ||
                buttons[3].getText() == "X" &&
                buttons[4].getText() == "X" &&
                buttons[5].getText() == ""){
            buttons[5].setText("O");
        }
        else if(buttons[0].getText() == "X" &&
                buttons[3].getText() == "X" &&
                buttons[6].getText() == "" ||
                buttons[7].getText() == "X" &&
                buttons[8].getText() == "X" &&
                buttons[6].getText() == "" ||
                buttons[2].getText() == "X" &&
                buttons[4].getText() == "X" &&
                buttons[6].getText() == ""){
            buttons[6].setText("O");
        }
        else if(buttons[1].getText() == "X" &&
                buttons[4].getText() == "X" &&
                buttons[7].getText() == "" ||
                buttons[6].getText() == "X" &&
                buttons[8].getText() == "X" &&
                buttons[7].getText() == ""){
            buttons[7].setText("O");
        }
        else if(buttons[2].getText() == "X" &&
                buttons[5].getText() == "X" &&
                buttons[8].getText() == "" ||
                buttons[0].getText() == "X" &&
                buttons[4].getText() == "X" &&
                buttons[8].getText() == "" ||
                buttons[6].getText() == "X" &&
                buttons[7].getText() == "X" &&
                buttons[8].getText() == ""){
            buttons[8].setText("O");
        }
        






        else if(timeplay == 3 && 
                (buttons[0].getText() == "X" &&
                buttons[8].getText() == "X" ||
                buttons[2].getText() == "X" &&
                buttons[6].getText() == "X")) buttons[1].setText("O");
        else if(timeplay == 3 && 
                (buttons[3].getText() == "X" &&
                buttons[7].getText() == "X"||
                buttons[1].getText() == "X" &&
                buttons[5].getText() == "X")) buttons[0].setText("O");
        else if(timeplay == 3 && 
                (buttons[1].getText() == "X" &&
                buttons[3].getText() == "X"||
                buttons[5].getText() == "X" &&
                buttons[7].getText() == "X")) buttons[2].setText("O");
        else if(timeplay == 3 && 
                (buttons[3].getText() == "X" &&
                buttons[2].getText() == "X"||
                buttons[1].getText() == "X" &&
                buttons[6].getText() == "X")) buttons[0].setText("O");
        else if(timeplay == 3 && 
                (buttons[1].getText() == "X" &&
                buttons[8].getText() == "X"||
                buttons[5].getText() == "X" &&
                buttons[0].getText() == "X")) buttons[2].setText("O");
        else if(timeplay == 3 && 
                (buttons[7].getText() == "X" &&
                buttons[2].getText() == "X"||
                buttons[5].getText() == "X" &&
                buttons[6].getText() == "X")) buttons[8].setText("O");
        else if(timeplay == 3 && 
                (buttons[7].getText() == "X" &&
                buttons[0].getText() == "X"||
                buttons[3].getText() == "X" &&
                buttons[8].getText() == "X")) buttons[6].setText("O");
        else if(timeplay == 4 && buttons[4].getText() == "") buttons[4].setText("O");
        else{
            for(int k = 0; k < 9; k++){
                if(buttons[k].getText() == ""){
                    buttons[k].setText("O");
                    break;
                }

            }
        }
    }

}