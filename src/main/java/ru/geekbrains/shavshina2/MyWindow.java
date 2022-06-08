package ru.geekbrains.shavshina2;

import javax.swing.*;
import java.awt.*;


public class MyWindow extends JFrame {
    private JTextField field;
    private JTextArea jta;
    private JButton button;

    public MyWindow(){
        setTitle("Chat with me");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(150, 150, 500, 500);

        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());

        jta = new JTextArea();
        jta.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(jta);
        jp.add(jsp, BorderLayout.CENTER);

        JPanel bottomJp = new JPanel();
        bottomJp.setLayout(new BorderLayout());

        addTextField();
        bottomJp.add(field, BorderLayout.CENTER);

        addButton();
        bottomJp.add(button, BorderLayout.EAST);
        jp.add(bottomJp, BorderLayout.SOUTH);
        add(jp);

        setVisible(true);
        field.grabFocus();
    }

    private void sendMessage(){
        if(!field.getText().isEmpty()){
            jta.append(field.getText()+"\n");
            field.setText("");
            field.grabFocus();
        }
    }

    private void addTextField(){
        field = new JTextField();
        field.addActionListener(e -> sendMessage());
    }

    private void addButton(){
        button = new JButton("Отправить");
        button.addActionListener(e -> sendMessage());
    }
}