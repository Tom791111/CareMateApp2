package controller;

import entity.Member;
import service.MemberService;
import service.impl.MemberServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddMemberFrame extends JFrame {

    private JTextField nameField;
    private JTextField phoneField;
    private JTextField accountField;
    private JPasswordField passwordField;
    private JTextField addressField;

    private JLabel timeLabel;

    private String role;

    private MemberService memberService = new MemberServiceImpl();

    public AddMemberFrame(String role) {

        this.role = role;

        setTitle("CareMate - 我的帳戶");
        setSize(400, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(250, 247, 242));

        JButton backBtn = new JButton("←");
        backBtn.setFont(new Font("Arial", Font.BOLD, 18));
        backBtn.setBounds(10, 20, 50, 35);
        backBtn.setBorderPainted(false);
        backBtn.setContentAreaFilled(false);
        add(backBtn);

        JLabel logo = new JLabel("CareMate", SwingConstants.CENTER);
        logo.setFont(new Font("Arial", Font.BOLD, 18));
        logo.setForeground(new Color(74, 132, 137));
        logo.setBounds(120, 35, 160, 30);
        add(logo);

        JLabel title = new JLabel("我的帳戶", SwingConstants.CENTER);
        title.setFont(new Font("Microsoft JhengHei", Font.BOLD, 28));
        title.setBounds(90, 80, 220, 40);
        add(title);

        timeLabel = new JLabel("", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
        timeLabel.setForeground(Color.GRAY);
        timeLabel.setBounds(60, 122, 280, 25);
        add(timeLabel);

        JLabel roleLabel = new JLabel("目前身分：" + role, SwingConstants.CENTER);
        roleLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 14));
        roleLabel.setBounds(70, 148, 260, 30);
        add(roleLabel);

        nameField = createInput("姓名：", 48, 190);
        phoneField = createInput("手機號碼：", 48, 255);
        accountField = createInput("帳號：", 48, 320);
        passwordField = createPasswordInput("密碼：", 48, 385);
        addressField = createInput("通訊 / 服務地址：", 48, 450);

        JButton submitBtn = new JButton("確定送出");
        submitBtn.setFont(new Font("Microsoft JhengHei", Font.BOLD, 18));
        submitBtn.setForeground(Color.WHITE);
        submitBtn.setBackground(new Color(121, 108, 106));
        submitBtn.setBounds(65, 545, 260, 50);
        submitBtn.setFocusPainted(false);
        add(submitBtn);

        JButton loginBtn = new JButton("查詢");
        loginBtn.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setBackground(new Color(89, 146, 205));
        loginBtn.setBounds(65, 615, 120, 40);
        loginBtn.setFocusPainted(false);
        add(loginBtn);

        JButton clearBtn = new JButton("清除");
        clearBtn.setFont(new Font("Microsoft JhengHei", Font.BOLD, 16));
        clearBtn.setForeground(Color.WHITE);
        clearBtn.setBackground(new Color(226, 57, 84));
        clearBtn.setBounds(205, 615, 120, 40);
        clearBtn.setFocusPainted(false);
        add(clearBtn);

        backBtn.addActionListener(e -> {
            new RoleFrame();
            dispose();
        });

        submitBtn.addActionListener(e -> register());

        loginBtn.addActionListener(e -> login());

        clearBtn.addActionListener(e -> clearFields());

        startClock();

        setVisible(true);
    }

    private JTextField createInput(String labelText, int x, int y) {

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 14));
        label.setBounds(x, y - 20, 160, 25);
        add(label);

        JTextField field = new JTextField();
        field.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 16));
        field.setBounds(x, y, 295, 40);
        add(field);

        return field;
    }

    private JPasswordField createPasswordInput(String labelText, int x, int y) {

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 14));
        label.setBounds(x, y - 20, 160, 25);
        add(label);

        JPasswordField field = new JPasswordField();
        field.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 16));
        field.setBounds(x, y, 295, 40);
        add(field);

        return field;
    }

    private void startClock() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        Timer timer = new Timer(1000, e -> {
            timeLabel.setText("系統時間：" + LocalDateTime.now().format(formatter));
        });

        timer.start();
    }

    private void register() {

        String name = nameField.getText();
        String phone = phoneField.getText();
        String username = accountField.getText();
        String password = new String(passwordField.getPassword());
        String address = addressField.getText();

        if (name.isEmpty() || phone.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "姓名、手機、帳號、密碼不可空白");
            return;
        }

        boolean isRepeat = memberService.checkUsername(username);

        if (isRepeat) {
            new AddMemberError();
            return;
        }

        Member member = new Member(name, phone, username, password, address, role);

        memberService.createMember(member);

        new AddMemberSuccess();
        dispose();
    }

    private void login() {

        String username = accountField.getText();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "請輸入帳號與密碼");
            return;
        }

        Member member = memberService.login(username, password);

        if (member == null) {
            new LoginError(role);
            return;
        }

        new LoginSuccess();
        dispose();
    }

    private void clearFields() {
        nameField.setText("");
        phoneField.setText("");
        accountField.setText("");
        passwordField.setText("");
        addressField.setText("");
    }
}