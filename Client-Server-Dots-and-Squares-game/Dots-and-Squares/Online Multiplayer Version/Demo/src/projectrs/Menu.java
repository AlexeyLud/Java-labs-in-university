package projectrs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu {
    Menu() {
        JFrame Frame = new JFrame();
        Frame.setLayout(new BorderLayout());
        Frame.setSize(250,300);
        Frame.setTitle("Меню");
        Frame.setName("Демо");
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JLabel empty2 = new JLabel("                                                                   ");
        JLabel empty3 = new JLabel("                                                                   ");
        JLabel empty4 = new JLabel("                                                                   ");
        JButton newGame = new JButton("Новая Игра(с ботом)");
        JButton multi = new JButton("Новая Игра(онлайн)");
        newGame.setSize(200,100);
        JLabel empty = new JLabel("                                                                   ");
        JLabel empty1 = new JLabel("                                                                  ");
        JButton howToPlay = new JButton("Как Играть");
        howToPlay.setSize(200,100);
        
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame.setVisible(false);
                GameEngine gameengine = new GameEngine();
            }      
        });
        
        howToPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame.setVisible(false);
                Tutorial newtutorial = new Tutorial();
            }
        });
        
        multi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Frame.setVisible(false);
                    Socket socket = new Socket("0.0.0.0",8080);
                    DataInputStream in = new DataInputStream(socket.getInputStream());
                    String s= in.readUTF();
                    System.out.println(s);
                    Multiplayer m = new Multiplayer(s,socket);
                } catch (IOException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }   
        });
        
        //panel.add(empty2);
        panel.add(empty3);
        panel.add(empty4);
        panel.add(newGame);
        
        panel.add(empty1);
        panel.add(multi);
        panel.add(empty);
        panel.add(howToPlay);
        //panel.add(empty1);
        Frame.add(panel);
        
        Frame.setVisible(true);
    }
}
