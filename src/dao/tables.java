package dao;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class tables {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try {
            // Mendapatkan koneksi dari ConnectionProvider
            con = ConnectionProvider.getCon();
            
            // Membuat statement untuk mengeksekusi query SQL
            st = con.createStatement();
            
            // Query untuk membuat tabel appuser
            String createTableSQL = "CREATE TABLE IF NOT EXISTS appuser ("
                    + "appuser_pk INT AUTO_INCREMENT PRIMARY KEY, "
                    + "userRole VARCHAR(50), "
                    + "name VARCHAR(200), "
                    + "mobileNumber VARCHAR(50), "
                    + "email VARCHAR(200), "
                    + "password VARCHAR(50), "
                    + "address VARCHAR(200), "
                    + "status VARCHAR(50)"
                    + ")";
            
            // Mengeksekusi query untuk membuat tabel
            st.executeUpdate(createTableSQL);
            JOptionPane.showMessageDialog(null, "Table 'appuser' Created Successfully");
            
            // Query untuk memasukkan data ke dalam tabel appuser
            String insertDataSQL = "INSERT INTO appuser (userRole, name, mobileNumber, email, password, address, status) "
                    + "VALUES ('SuperAdmin', 'Super Admin', '12345', 'superadmin@testemail.com', 'admin', 'Indonesia', 'Active')";
            
            // Mengeksekusi query insert data
            st.executeUpdate(insertDataSQL);
            JOptionPane.showMessageDialog(null, "Data Inserted Successfully");

        } catch (Exception e) {
            // Menangkap dan menampilkan error jika terjadi kesalahan
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        } finally {
            try {
                // Menutup koneksi dan statement setelah eksekusi
                if (con != null) con.close();
                if (st != null) st.close();
            } catch (Exception e) {
                // Menangani pengecualian ketika menutup koneksi
                JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage());
            }
        }
    }
}
