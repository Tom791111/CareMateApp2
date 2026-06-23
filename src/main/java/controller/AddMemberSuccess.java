package controller;

import javax.swing.*;
import java.awt.*;

public class AddMemberSuccess extends JFrame {

    public AddMemberSuccess() {

        setTitle("CareMate - 帳號建立成功");
        setSize(360, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(250, 247, 242));

        JLabel label = new JLabel("帳號建立成功", SwingConstants.CENTER);
        label.setFont(new Font("Microsoft JhengHei", Font.BOLD, 26));
        label.setBounds(50, 45, 250, 40);
        add(label);
        
        /**********************************event***********************************/

        JButton btn = new JButton("回到選擇身分");
        btn.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
        btn.setBounds(90, 115, 170, 40);
        add(btn);

        btn.addActionListener(e -> {
            new RoleFrame();
            dispose();
        });

        setVisible(true);
    }
}