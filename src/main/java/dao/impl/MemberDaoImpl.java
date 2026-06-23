package dao.impl;

import dao.MemberDao;
import entity.Member;
import util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDaoImpl implements MemberDao {

    @Override
    public Member login(String username, String password) {

        String sql = "SELECT * FROM member WHERE account = ? AND password = ?";

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Member member = new Member();

                member.setId(rs.getInt("id"));
                member.setName(rs.getString("name"));
                member.setPhone(rs.getString("phone"));
                member.setAccount(rs.getString("account"));
                member.setPassword(rs.getString("password"));
                member.setAddress(rs.getString("address"));
                member.setRole(rs.getString("role"));

                rs.close();
                ps.close();
                conn.close();

                return member;
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void createMember(Member member) {

        String sql = "INSERT INTO member(name, phone, account, password, address, role) VALUES(?,?,?,?,?,?)";

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, member.getName());
            ps.setString(2, member.getPhone());
            ps.setString(3, member.getAccount());
            ps.setString(4, member.getPassword());
            ps.setString(5, member.getAddress());
            ps.setString(6, member.getRole());

            ps.executeUpdate();

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkUsername(String username) {

        String sql = "SELECT * FROM member WHERE account = ?";

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                rs.close();
                ps.close();
                conn.close();

                return true;
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}