package entity;

public class Member {

    private int id;
    private String name;
    private String phone;
    private String account;
    private String password;
    private String address;
    private String role;

    public Member() {
    }

    public Member(String name, String phone, String account, String password, String address, String role) {
        this.name = name;
        this.phone = phone;
        this.account = account;
        this.password = password;
        this.address = address;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getRole() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRole(String role) {
        this.role = role;
    }
}