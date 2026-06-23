package controller;

import javax.swing.*;
import java.awt.*;

public class LoginError extends JFrame {

    public LoginError(String role) {

        setTitle("CareMate - 登入失敗");
        setSize(360, 260);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(250, 247, 242));

        JLabel title = new JLabel("登入失敗", SwingConstants.CENTER);
        title.setFont(new Font("Microsoft JhengHei", Font.BOLD, 28));
        title.setForeground(new Color(220, 60, 80));
        title.setBounds(70, 35, 220, 40);
        add(title);

        JLabel text = new JLabel("查無此帳號，請先註冊", SwingConstants.CENTER);
        text.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 16));
        text.setBounds(50, 85, 260, 30);
        add(text);
        
        /**********************************event***********************************/

        JButton registerBtn = new JButton("請先註冊");
        registerBtn.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
        registerBtn.setBounds(95, 125, 170, 40);
        add(registerBtn);

        JButton backBtn = new JButton("返回");
        backBtn.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
        backBtn.setBounds(95, 175, 170, 40);
        add(backBtn);

        registerBtn.addActionListener(e -> {
            new AddMemberFrame(role);
            dispose();
        });

        backBtn.addActionListener(e -> {
            dispose();
        });

        setVisible(true);
    }
}