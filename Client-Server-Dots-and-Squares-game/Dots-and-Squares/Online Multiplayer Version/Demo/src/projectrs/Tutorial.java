
package projectrs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import static jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType.NEWLINE;


public class Tutorial {
    Tutorial() {
        JFrame tutorial = new JFrame();
        tutorial.setLayout(new BorderLayout());
        tutorial.setSize(800,400);
        tutorial.setTitle("Как Играть");
        tutorial.setName("Демо");
        tutorial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel Tutorial = new JLabel();
        JLabel Tutorial2 = new JLabel();
        JLabel Tutorial3 = new JLabel();
        JLabel Tutorial4 = new JLabel();
        JLabel Tutorial5 = new JLabel();
        JLabel Tutorial6 = new JLabel();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        Tutorial.setText("Нажмите \"Новая игра\", чтобы начать. Это многопользовательская игра между двумя игроками. ");
        Tutorial2.setText("Щелкните между двумя точками, чтобы создать линию. ");
        Tutorial5.setText("Ваша цель состоит в том, чтобы заполнить квадраты, чтобы получить очки. ");
        Tutorial3.setText("Игроки могут ставить линии по очереди. ");
        Tutorial6.setText("Но когда кто-то завершает квадрат, он/она получает дополнительный ход. ");
        Tutorial4.setText("Игрок, который заполнит больше квадратов, станет победителем. ");
        Tutorial.setFont(new Font("Serif", Font.PLAIN, 20));
        Tutorial2.setFont(new Font("Serif", Font.PLAIN, 20));
        Tutorial3.setFont(new Font("Serif", Font.PLAIN, 20));
        Tutorial4.setFont(new Font("Serif", Font.PLAIN, 20));
        Tutorial5.setFont(new Font("Serif", Font.PLAIN, 20));
        Tutorial6.setFont(new Font("Serif", Font.PLAIN, 20));
        panel.add(Tutorial,BorderLayout.PAGE_END);
        panel.add(Tutorial2,BorderLayout.PAGE_END);
        panel.add(Tutorial5,BorderLayout.PAGE_END);
        panel.add(Tutorial3,BorderLayout.PAGE_END);
        panel.add(Tutorial6,BorderLayout.PAGE_END);
        panel.add(Tutorial4,BorderLayout.PAGE_END);
        JButton button = new JButton("Вернуться в Меню");
        panel.setAlignmentX(button.CENTER_ALIGNMENT);
        JLabel empty = new JLabel("                                ");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tutorial.setVisible(false);
                Menu menu = new Menu();
            }                    
        });
        button.setVisible(true);
        button.setBounds(new Rectangle(new Point(100, 650), button.getPreferredSize()));
        //panel.add(empty);
        panel.add(Box.createHorizontalGlue());
        panel.add(Box.createRigidArea(new Dimension(150, 100)));
        panel.add(button, BorderLayout.PAGE_END);
        
        tutorial.add(panel, BorderLayout.CENTER);
        tutorial.setVisible(true);
        tutorial.repaint();
    }
}
