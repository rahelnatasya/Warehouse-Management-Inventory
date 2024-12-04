package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionProvider {
    private static Connection mysqlkonek;

    public static Connection getCon() {
        if (mysqlkonek == null) {
            try {
                // Memuat driver MySQL
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // URL koneksi ke database 'inventory'
                String dbUrl = "jdbc:mysql://localhost:3306/inventory?useSSL=false";
                String user = "root";
                String pass = ""; // Password sesuai konfigurasi Anda
                
                // Membuka koneksi
                mysqlkonek = DriverManager.getConnection(dbUrl, user, pass);
            } catch (ClassNotFoundException | SQLException e) {
                JOptionPane.showMessageDialog(null, "Koneksi Gagal: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return mysqlkonek;
    }
}
