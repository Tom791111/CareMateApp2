package controller;

import javax.swing.*;
import java.awt.*;

public class HomeFrame extends JFrame {

    public HomeFrame() {

        setTitle("CareMate - 首頁");
        setSize(400, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(250, 247, 242));

        JLabel logo = new JLabel("CareMate", SwingConstants.CENTER);
        logo.setFont(new Font("Arial", Font.BOLD, 18));
        logo.setForeground(new Color(74, 132, 137));
        logo.setBounds(120, 65, 160, 30);
        add(logo);

        JLabel taskText = new JLabel("今天有");
        taskText.setFont(new Font("Microsoft JhengHei", Font.BOLD, 22));
        taskText.setBounds(38, 145, 90, 35);
        add(taskText);

        JLabel number = new JLabel("3 個");
        number.setFont(new Font("Microsoft JhengHei", Font.BOLD, 26));
        number.setForeground(new Color(220, 70, 45));
        number.setBounds(120, 143, 70, 35);
        add(number);

        JLabel task = new JLabel("任務");
        task.setFont(new Font("Microsoft JhengHei", Font.BOLD, 22));
        task.setBounds(192, 145, 90, 35);
        add(task);

        JPanel medicinePanel = new JPanel();
        medicinePanel.setLayout(null);
        medicinePanel.setBackground(new Color(248, 201, 90));
        medicinePanel.setBounds(46, 200, 130, 120);
        add(medicinePanel);

        JLabel medicineTitle = new JLabel("用藥管理", SwingConstants.CENTER);
        medicineTitle.setFont(new Font("Microsoft JhengHei", Font.BOLD, 17));
        medicineTitle.setBounds(0, 15, 130, 25);
        medicinePanel.add(medicineTitle);

        JLabel time1 = new JLabel("08:00", SwingConstants.CENTER);
        time1.setFont(new Font("Arial", Font.PLAIN, 15));
        time1.setForeground(Color.RED);
        time1.setBounds(0, 45, 130, 20);
        medicinePanel.add(time1);

        JLabel time2 = new JLabel("12:00", SwingConstants.CENTER);
        time2.setFont(new Font("Arial", Font.PLAIN, 15));
        time2.setForeground(Color.RED);
        time2.setBounds(0, 67, 130, 20);
        medicinePanel.add(time2);

        JLabel time3 = new JLabel("20:00", SwingConstants.CENTER);
        time3.setFont(new Font("Arial", Font.PLAIN, 15));
        time3.setForeground(Color.RED);
        time3.setBounds(0, 89, 130, 20);
        medicinePanel.add(time3);

        JPanel foodPanel = new JPanel();
        foodPanel.setLayout(null);
        foodPanel.setBackground(new Color(89, 146, 205));
        foodPanel.setBounds(206, 200, 130, 120);
        add(foodPanel);

        JLabel foodTitle = new JLabel("飲食營養", SwingConstants.CENTER);
        foodTitle.setFont(new Font("Microsoft JhengHei", Font.BOLD, 17));
        foodTitle.setForeground(Color.WHITE);
        foodTitle.setBounds(0, 15, 130, 25);
        foodPanel.add(foodTitle);

        JLabel breakfast = new JLabel("早餐", SwingConstants.CENTER);
        breakfast.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
        breakfast.setForeground(Color.WHITE);
        breakfast.setBounds(0, 45, 130, 20);
        foodPanel.add(breakfast);

        JLabel lunch = new JLabel("午餐", SwingConstants.CENTER);
        lunch.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
        lunch.setForeground(Color.WHITE);
        lunch.setBounds(0, 67, 130, 20);
        foodPanel.add(lunch);

        JLabel dinner = new JLabel("晚餐", SwingConstants.CENTER);
        dinner.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
        dinner.setForeground(Color.WHITE);
        dinner.setBounds(0, 89, 130, 20);
        foodPanel.add(dinner);

        JButton measureBtn = new JButton("<html><center>血壓 / 體溫<br>量測紀錄</center></html>");
        measureBtn.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
        measureBtn.setForeground(Color.WHITE);
        measureBtn.setBackground(new Color(230, 120, 95));
        measureBtn.setFocusPainted(false);
        measureBtn.setBounds(46, 340, 290, 55);
        add(measureBtn);

        measureBtn.addActionListener(e -> {
            new HealthFrame();
            dispose();
        });

        JPanel moodPanel = new JPanel();
        moodPanel.setLayout(null);
        moodPanel.setBackground(new Color(250, 247, 242));
        moodPanel.setBorder(BorderFactory.createLineBorder(new Color(170, 160, 155)));
        moodPanel.setBounds(46, 420, 290, 85);
        add(moodPanel);

        JLabel mood = new JLabel("阿公今天心情？  開心  普通  ...", SwingConstants.CENTER);
        mood.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
        mood.setForeground(new Color(80, 70, 70));
        mood.setBounds(10, 25, 270, 35);
        moodPanel.add(mood);

        JPanel remindPanel = new JPanel();
        remindPanel.setLayout(null);
        remindPanel.setBackground(Color.WHITE);
        remindPanel.setBorder(BorderFactory.createLineBorder(new Color(190, 185, 180)));
        remindPanel.setBounds(46, 545, 290, 50);
        add(remindPanel);

        JLabel remind = new JLabel("提醒：尚有 3 筆用藥未完成  >", SwingConstants.CENTER);
        remind.setFont(new Font("Microsoft JhengHei", Font.BOLD, 15));
        remind.setForeground(new Color(80, 70, 70));
        remind.setBounds(10, 10, 270, 30);
        remindPanel.add(remind);

        JLabel sos = new JLabel("SOS", SwingConstants.CENTER);
        sos.setFont(new Font("Arial", Font.BOLD, 18));
        sos.setForeground(new Color(226, 57, 84));
        sos.setBounds(45, 655, 80, 25);
        add(sos);

        JLabel sosText = new JLabel("緊急救助", SwingConstants.CENTER);
        sosText.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
        sosText.setForeground(new Color(226, 57, 84));
        sosText.setBounds(45, 680, 80, 20);
        add(sosText);

        JLabel translate = new JLabel("翻譯", SwingConstants.CENTER);
        translate.setFont(new Font("Microsoft JhengHei", Font.BOLD, 15));
        translate.setForeground(new Color(89, 146, 205));
        translate.setBounds(160, 655, 80, 25);
        add(translate);

        JLabel translateText = new JLabel("即時翻譯", SwingConstants.CENTER);
        translateText.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
        translateText.setForeground(new Color(89, 146, 205));
        translateText.setBounds(160, 680, 80, 20);
        add(translateText);

        JLabel contact = new JLabel("聯絡", SwingConstants.CENTER);
        contact.setFont(new Font("Microsoft JhengHei", Font.BOLD, 15));
        contact.setForeground(Color.BLACK);
        contact.setBounds(275, 655, 80, 25);
        add(contact);

        JLabel contactText = new JLabel("聯絡人", SwingConstants.CENTER);
        contactText.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 12));
        contactText.setForeground(Color.BLACK);
        contactText.setBounds(275, 680, 80, 20);
        add(contactText);

        setVisible(true);
    }
}