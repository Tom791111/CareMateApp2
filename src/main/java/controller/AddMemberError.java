package controller;

import javax.swing.*;
import java.awt.*;

public class AddMemberError extends JFrame {

    public AddMemberError() {

        setTitle("CareMate - 帳號重複");
        setSize(360, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(250, 247, 242));

        JLabel label = new JLabel("帳號重複", SwingConstants.CENTER);
        label.setFont(new Font("Microsoft JhengHei", Font.BOLD, 26));
        label.setForeground(new Color(220, 60, 80));
        label.setBounds(50, 45, 250, 40);
        add(label);

        JLabel text = new JLabel("請重新輸入帳號", SwingConstants.CENTER);
        text.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 16));
        text.setBounds(50, 85, 250, 30);
        add(text);
        /**********************************event***********************************/
        JButton btn = new JButton("我知道了");
        btn.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
        btn.setBounds(110, 130, 130, 35);
        add(btn);

        btn.addActionListener(e -> dispose());

        setVisible(true);
    }
}