package controller;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RoleFrame extends JFrame {

    private JLabel foreignTitle;
    private JLabel timeLabel;

    private String selectedForeignRole = "外籍照顧者-TW";

    public RoleFrame() {

        setTitle("CareMate - 選擇身分");
        setSize(400, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(250, 247, 242));

        JLabel title = new JLabel("<html>請選擇<br>您的身分</html>");
        title.setFont(new Font("Microsoft JhengHei", Font.BOLD, 28));
        title.setForeground(new Color(45, 45, 55));
        title.setBounds(35, 55, 250, 80);
        add(title);

        JLabel subTitle = new JLabel("choose your role");
        subTitle.setFont(new Font("Arial", Font.PLAIN, 16));
        subTitle.setForeground(new Color(45, 45, 55));
        subTitle.setBounds(37, 150, 200, 30);
        add(subTitle);

        timeLabel = new JLabel("", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
        timeLabel.setForeground(Color.GRAY);
        timeLabel.setBounds(45, 185, 300, 25);
        add(timeLabel);

        JButton familyBtn = createRoleButton("我是家屬（照顧者）", new Color(139, 190, 70));
        familyBtn.setBounds(30, 230, 330, 80);
        add(familyBtn);

        JButton patientBtn = createRoleButton("我是被照顧者", new Color(248, 201, 90));
        patientBtn.setBounds(30, 345, 330, 80);
        add(patientBtn);

        JPanel foreignPanel = new JPanel();
        foreignPanel.setLayout(null);
        foreignPanel.setBackground(new Color(89, 146, 205));
        foreignPanel.setBounds(30, 460, 330, 145);
        foreignPanel.setBorder(BorderFactory.createLineBorder(new Color(60, 115, 170)));
        add(foreignPanel);

        foreignTitle = new JLabel("我是外籍照顧者", SwingConstants.CENTER);
        foreignTitle.setFont(new Font("Microsoft JhengHei", Font.BOLD, 18));
        foreignTitle.setForeground(Color.WHITE);
        foreignTitle.setBounds(0, 18, 330, 30);
        foreignPanel.add(foreignTitle);

        JLabel langText = new JLabel("請選擇語言 / Choose Language", SwingConstants.CENTER);
        langText.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
        langText.setForeground(Color.WHITE);
        langText.setBounds(0, 50, 330, 25);
        foreignPanel.add(langText);

        JButton twBtn = createLangButton("TW");
        twBtn.setBounds(25, 88, 60, 38);
        foreignPanel.add(twBtn);

        JButton vnBtn = createLangButton("VN");
        vnBtn.setBounds(100, 88, 60, 38);
        foreignPanel.add(vnBtn);

        JButton phBtn = createLangButton("PH");
        phBtn.setBounds(175, 88, 60, 38);
        foreignPanel.add(phBtn);

        JButton idBtn = createLangButton("ID");
        idBtn.setBounds(250, 88, 60, 38);
        foreignPanel.add(idBtn);

        familyBtn.addActionListener(e -> openRegister("家屬照顧者"));
        patientBtn.addActionListener(e -> openRegister("被照顧者"));

        foreignPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                openRegister(selectedForeignRole);
            }
        });

        twBtn.addActionListener(e -> {
            foreignTitle.setText("我是外籍照顧者");
            selectedForeignRole = "外籍照顧者-TW";
        });

        vnBtn.addActionListener(e -> {
            foreignTitle.setText("Tôi là người chăm sóc nước ngoài");
            selectedForeignRole = "外籍照顧者-VN";
        });

        phBtn.addActionListener(e -> {
            foreignTitle.setText("Ako ay foreign caregiver");
            selectedForeignRole = "外籍照顧者-PH";
        });

        idBtn.addActionListener(e -> {
            foreignTitle.setText("Saya pengasuh asing");
            selectedForeignRole = "外籍照顧者-ID";
        });

        startClock();

        setVisible(true);
    }

    private JButton createRoleButton(String text, Color color) {

        JButton button = new JButton(text);
        button.setFont(new Font("Microsoft JhengHei", Font.BOLD, 18));
        button.setForeground(Color.WHITE);
        button.setBackground(color);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(color.darker()));

        return button;
    }

    private JButton createLangButton(String text) {

        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setForeground(Color.BLACK);
        button.setBackground(new Color(235, 242, 250));
        button.setFocusPainted(false);

        return button;
    }

    private void startClock() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        Timer timer = new Timer(1000, e -> {
            timeLabel.setText("系統時間：" + LocalDateTime.now().format(formatter));
        });

        timer.start();
    }

    private void openRegister(String role) {
        new AddMemberFrame(role);
        dispose();
    }
}