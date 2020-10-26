package util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String dirver;

    static{
        //��ȡ��Դ�ļ�����ȡֵ
        try {
            //1.����properties������
            Properties pro = new Properties();
            //2.��ȡsrc·���µ��ļ���ʽ��Classloader �������
            ClassLoader classloader = JDBCUtils.class.getClassLoader();
            URL res = classloader.getResource("jdbc.properties");
            String path = res.getPath();
            //3.�����ļ�
            pro.load(new FileReader(path));
            //4.��ȡ���ݣ���ֵ
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            dirver = pro.getProperty("driver");
            //5.ע������
            Class.forName(dirver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * ��ȡ����
     * @return ���Ӷ���
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }


    /**
     * �ͷ���Դ
     * @param ress
     * @param stat
     * @param conn
     */
    public static void close(ResultSet ress, Statement stat, Connection conn){
        if(ress != null){
            try {
                ress.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stat != null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}