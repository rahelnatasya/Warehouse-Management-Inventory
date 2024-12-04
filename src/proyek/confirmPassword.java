/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyek;

/**
 *
 * @author USER
 */
class confirmPassword {
    public static boolean validate(String password, String confirm) {
        if (password == null || confirm == null) {
            return false;
        }
        return password.equals(confirm);
    }

    static String getPassword() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
