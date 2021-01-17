package Vue;

import Datas.Map;
import Datas.Player;
import Logic.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class DiceWarsInterface extends JFrame{
    private JPanel mainPanel;
    private JButton OKButton;
    private JLabel tfname;
    private JTextField enterYourNameTextField;
    private JTextField textField1;
    private JLabel Name2;
    private JButton playButton;
    ArrayList<Player> players;

    private PlayingInterface playingmode;

    private Game newGame;

    public DiceWarsInterface(String title){
        super(title);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        setVisible(true);

        this.playingmode = new PlayingInterface("Dice Wars");

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //retrieve the players' name
                String P1 = enterYourNameTextField.getText();
                String P2 = textField1.getText();

                //creation of the two players
                players = new ArrayList<>();
                Player player1 = new Player(1);
                player1.setName(P1);

                Player player2 = new Player(2);
                player1.setName(P2);
                setPlayers(player1,player2);

                Map newMap = new Map(2);

                //initializes a new game party
                newGame = new Game(players, newMap);



                System.out.println("Player " + player1.getId() + " : "+ player1.getName());
                System.out.println("Player " + player2.getId() + " : "+ player2.getName());

                setVisible(false);


                playingmode.setVisible(true);




            }
        });
    }

    public ArrayList<Player> getPlayers(){return players;}
    public void setPlayers(Player p1, Player p2){players.add(p1);players.add(p2);}
    public void createPlayers(String P1, String P2){

    }



    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args){
        new DiceWarsInterface("Dice Wars");
    }
}
