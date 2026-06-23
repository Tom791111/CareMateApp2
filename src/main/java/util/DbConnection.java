package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

    public static Connection getConnection() {

        Connection conn = null;

        String url =
            "jdbc:mysql://localhost:3306/caremate"
            + "?serverTimezone=Asia/Taipei"
            + "&useSSL=false"
            + "&characterEncoding=utf8";

        String user = "root";
        String password = "1234";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(
                    url,
                    user,
                    password);

            System.out.println("資料庫連線成功");

        }
        catch (Exception e) {

            System.out.println("資料庫連線失敗");

            e.printStackTrace();
        }

        return conn;
    }
}
	
