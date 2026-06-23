package controller;

import javax.swing.*;
import java.awt.*;

public class LoginSuccess extends JFrame {

    public LoginSuccess() {

        setTitle("CareMate - 登入成功");
        setSize(360, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(250, 247, 242));

        JLabel title = new JLabel("登入成功", SwingConstants.CENTER);
        title.setFont(new Font("Microsoft JhengHei", Font.BOLD, 28));
        title.setBounds(70, 45, 220, 40);
        add(title);

        JLabel text = new JLabel("歡迎使用 CareMate", SwingConstants.CENTER);
        text.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 16));
        text.setBounds(70, 85, 220, 30);
        add(text);
        
        /**********************************event***********************************/

        JButton btn = new JButton("進入首頁");
        btn.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
        btn.setBounds(110, 130, 140, 40);
        add(btn);

        btn.addActionListener(e -> {
            new HomeFrame();
            dispose();
        });

        setVisible(true);
    }
}