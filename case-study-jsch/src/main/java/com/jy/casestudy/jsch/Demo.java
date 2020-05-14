package com.jy.casestudy.jsch;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.sql.*;

/**
 * @author yj
 * @since 2020-05-14 19:31
 **/
public class Demo {
    public static void main(String[] args) throws JSchException, ClassNotFoundException, SQLException {
        String jumpServerHost = "192.168.10.101";
        String jumpServerUsername = "jumper";

        String databaseHost = "192.168.100.100";
        int databasePort = 3306;
        String databaseUsername = "admin";
        String databasePassword = "123456";

        JSch jsch = new JSch();
        jsch.addIdentity("~/.ssh/rsa/id_rsa");
        jsch.setKnownHosts("~/.ssh/known_hosts");

        Session session = jsch.getSession(jumpServerUsername, jumpServerHost);
        session.connect();

        int forwardedPort = session.setPortForwardingL(0, databaseHost, databasePort);
        String jdbcUrl = "jdbc:mysql://127.0.0.1:"+ forwardedPort +"/myDb?useSSL=false&characterEncoding=UTF-8&createDatabaseIfNotExist=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Shanghai";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(jdbcUrl, databaseUsername, databasePassword);

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from store limit 10");
        // 展开结果集数据库
        while(rs.next()){
            // 通过字段检索
            int id  = rs.getInt("id");
            String name = rs.getString("name");
            // 输出数据
            System.out.print("ID: " + id);
            System.out.print(", 名称: " + name);
            System.out.print("\n");
        }
        rs.close();
        stmt.close();
        conn.close();
        session.disconnect();
    }
}
