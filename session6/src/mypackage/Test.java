package mypackage;

import mypackage.DAO.StudentDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        frame.setBounds(110,100,400,400);
        JPanel panel=new JPanel();
        panel.setBackground(Color.blue);

        JLabel idlabel=new JLabel("id");
        JTextField id=new JTextField(10);

        JLabel namelabel=new JLabel("name");
        JTextField name=new JTextField(10);

        JLabel familylabel=new JLabel("family");
        JTextField family=new JTextField(10);

        JButton button=new JButton("ok");
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("mouse click");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("mouse Pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("mouse Released");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("mouse Entered");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("mouse Exited");
            }
        });
        name.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("key type");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("key press");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("key release");
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //name.setText("hello");
                //System.out.println(name.getText());
                Student st=new Student();
                st.setNam(name.getText());
                st.setFamily(family.getText());
                st.setId(Integer .parseInt(id.getText()));
                StudentDAO std;
                std=new StudentDAO();
                std.insert(st);




            }
        });
        panel.add(idlabel);
        panel.add(id);
        panel.add(namelabel);
        panel.add(name);
        panel.add(familylabel);
        panel.add(family);
        panel.add(button);
        frame.add(panel);
        frame.setVisible(true);
        //frame.dispose();
        //frame.setDefaultCloseOperation(0);

    }
}
