package controller;

import java.awt.*;
import javax.swing.*;

import service.HealthService;
import service.impl.HealthServiceImpl;

public class HealthFrame extends JFrame {

    private JComboBox<String> comboPeriod;
    private JComboBox<String> comboTime;

    private JTextField txtSystolic;
    private JTextField txtDiastolic;
    private JTextField txtTemperature;

    private JTextArea areaResult;

    private HealthService healthService = new HealthServiceImpl();

    private JPanel mainPanel;

    public HealthFrame() {

        setTitle("CareMate - 血壓 / 體溫");
        setSize(400, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        mainPanel = new JPanel(null);
        mainPanel.setPreferredSize(new Dimension(380, 850));
        mainPanel.setBackground(new Color(250, 241, 232));

        JScrollPane mainScroll = new JScrollPane(mainPanel);
        mainScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        setContentPane(mainScroll);

        initUI();

        setVisible(true);
    }

    private void initUI() {

        JLabel back = new JLabel("←");
        back.setBounds(20, 20, 40, 30);
        back.setFont(new Font("Dialog", Font.BOLD, 22));
        mainPanel.add(back);

        JLabel logo = new JLabel("CareMate", SwingConstants.CENTER);
        logo.setBounds(120, 25, 160, 30);
        logo.setFont(new Font("Dialog", Font.BOLD, 16));
        logo.setForeground(new Color(40, 130, 140));
        mainPanel.add(logo);

        JLabel bell = new JLabel("🔔");
        bell.setBounds(330, 25, 40, 30);
        bell.setFont(new Font("Dialog", Font.PLAIN, 22));
        mainPanel.add(bell);

        JLabel title = new JLabel("血壓 / 體溫", SwingConstants.CENTER);
        title.setBounds(80, 85, 240, 40);
        title.setFont(new Font("Dialog", Font.BOLD, 26));
        mainPanel.add(title);

        JPanel timePanel = new JPanel(null);
        timePanel.setBounds(25, 150, 350, 50);
        timePanel.setOpaque(false);
        mainPanel.add(timePanel);

        comboPeriod = new JComboBox<String>(new String[] { "早上", "中午", "晚上" });
        comboPeriod.setBounds(20, 10, 90, 30);
        timePanel.add(comboPeriod);

        comboTime = new JComboBox<String>(
                new String[] {
                        "06:00", "07:00", "08:00", "09:00", "10:00",
                        "11:00", "12:00", "13:00", "14:00", "15:00",
                        "16:00", "17:00", "18:00", "19:00", "20:00",
                        "21:00", "22:00"
                }
        );
        comboTime.setBounds(130, 10, 90, 30);
        comboTime.setSelectedItem("08:00");
        timePanel.add(comboTime);

        JLabel hint = new JLabel("請輸入時段與時間");
        hint.setBounds(235, 10, 120, 30);
        hint.setFont(new Font("Dialog", Font.PLAIN, 12));
        hint.setForeground(Color.GRAY);
        timePanel.add(hint);

        JPanel bpCard = card(25, 215, 350, 130);
        mainPanel.add(bpCard);

        JLabel bpLabel = new JLabel("血壓量測");
        bpLabel.setBounds(20, 12, 120, 25);
        bpLabel.setFont(new Font("Dialog", Font.BOLD, 14));
        bpLabel.setForeground(new Color(220, 80, 40));
        bpCard.add(bpLabel);

        JLabel bpIcon = new JLabel("血壓");
        bpIcon.setBounds(35, 55, 60, 30);
        bpIcon.setFont(new Font("Dialog", Font.BOLD, 18));
        bpCard.add(bpIcon);

        JLabel bpTitle = new JLabel("現在血壓");
        bpTitle.setBounds(145, 35, 120, 30);
        bpTitle.setFont(new Font("Dialog", Font.BOLD, 20));
        bpCard.add(bpTitle);

        JLabel systolic = new JLabel("收縮壓：");
        systolic.setBounds(115, 70, 70, 25);
        bpCard.add(systolic);

        txtSystolic = new JTextField();
        txtSystolic.setBounds(180, 72, 65, 24);
        bpCard.add(txtSystolic);

        JLabel unit1 = new JLabel("mmHg");
        unit1.setBounds(250, 70, 60, 25);
        unit1.setFont(new Font("Dialog", Font.PLAIN, 11));
        bpCard.add(unit1);

        JLabel diastolic = new JLabel("舒張壓：");
        diastolic.setBounds(115, 98, 70, 25);
        bpCard.add(diastolic);

        txtDiastolic = new JTextField();
        txtDiastolic.setBounds(180, 100, 65, 24);
        bpCard.add(txtDiastolic);

        JLabel unit2 = new JLabel("mmHg");
        unit2.setBounds(250, 98, 60, 25);
        unit2.setFont(new Font("Dialog", Font.PLAIN, 11));
        bpCard.add(unit2);

        JPanel tempCard = card(25, 365, 350, 110);
        mainPanel.add(tempCard);

        JLabel tempLabel = new JLabel("體溫量測");
        tempLabel.setBounds(20, 12, 120, 25);
        tempLabel.setFont(new Font("Dialog", Font.BOLD, 14));
        tempLabel.setForeground(new Color(30, 130, 190));
        tempCard.add(tempLabel);

        JLabel tempIcon = new JLabel("體溫");
        tempIcon.setBounds(35, 55, 60, 30);
        tempIcon.setFont(new Font("Dialog", Font.BOLD, 18));
        tempCard.add(tempIcon);

        JLabel tempTitle = new JLabel("現在體溫：");
        tempTitle.setBounds(120, 50, 120, 30);
        tempTitle.setFont(new Font("Dialog", Font.BOLD, 20));
        tempCard.add(tempTitle);

        txtTemperature = new JTextField();
        txtTemperature.setBounds(230, 53, 55, 24);
        tempCard.add(txtTemperature);

        JLabel c = new JLabel("°C");
        c.setBounds(292, 50, 40, 30);
        c.setFont(new Font("Dialog", Font.BOLD, 18));
        tempCard.add(c);

        JButton btnSave = new JButton("完成紀錄");
        btnSave.setBounds(95, 500, 210, 45);
        btnSave.setFont(new Font("Dialog", Font.BOLD, 20));
        mainPanel.add(btnSave);

        JButton btnRead = new JButton("查看紀錄");
        btnRead.setBounds(40, 565, 95, 35);
        mainPanel.add(btnRead);

        JButton btnClear = new JButton("清除");
        btnClear.setBounds(153, 565, 95, 35);
        mainPanel.add(btnClear);

        JButton btnDelete = new JButton("刪除全部");
        btnDelete.setBounds(265, 565, 95, 35);
        mainPanel.add(btnDelete);

        areaResult = new JTextArea();
        areaResult.setEditable(false);
        areaResult.setFont(new Font("Dialog", Font.PLAIN, 12));
        areaResult.setLineWrap(true);

        JScrollPane scroll = new JScrollPane(areaResult);
        scroll.setBounds(30, 625, 340, 180);
        mainPanel.add(scroll);

        btnSave.addActionListener(e -> save());

        btnRead.addActionListener(e -> {
            areaResult.setText(healthService.readHealth());
        });

        btnClear.addActionListener(e -> clear());

        btnDelete.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "確定要刪除全部健康紀錄嗎？",
                    "刪除確認",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                healthService.deleteHealth();
                areaResult.setText(healthService.readHealth());
            }
        });

        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new HomeFrame();
                dispose();
            }
        });
    }

    private JPanel card(int x, int y, int w, int h) {

        JPanel p = new JPanel(null);
        p.setBounds(x, y, w, h);
        p.setBackground(Color.WHITE);
        p.setBorder(BorderFactory.createLineBorder(new Color(230, 220, 215)));

        return p;
    }

    private void save() {

        String period = comboPeriod.getSelectedItem().toString();
        String time = comboTime.getSelectedItem().toString();
        String systolic = txtSystolic.getText();
        String diastolic = txtDiastolic.getText();
        String temperature = txtTemperature.getText();

        if (systolic.trim().equals("")
                || diastolic.trim().equals("")
                || temperature.trim().equals("")) {

            JOptionPane.showMessageDialog(this, "請完整輸入血壓與體溫");
            return;
        }

        healthService.createHealth(
                period,
                time,
                systolic,
                diastolic,
                temperature
        );

        JOptionPane.showMessageDialog(this, "新增成功");

        clear();

        areaResult.setText(healthService.readHealth());
    }

    private void clear() {

        comboPeriod.setSelectedItem("早上");
        comboTime.setSelectedItem("08:00");

        txtSystolic.setText("");
        txtDiastolic.setText("");
        txtTemperature.setText("");
    }

    public static void main(String[] args) {
        new HealthFrame();
    }
}