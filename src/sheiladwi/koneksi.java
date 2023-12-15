package sheiladwi;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
public class koneksi {
    public static void main(String[] args) {
       getKoneksi();
    }
    
    private static Connection koneksi;
    
    public static Connection getKoneksi(){
        if(koneksi == null){
            try {
                String url = "jdbc:mysql://localhost/apotek";
                String user = "root";
                String pswd = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
               // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, user, pswd);
                System.out.println("Koneksi sukses");
                JOptionPane.showMessageDialog(null, "Koneksi sukses");
                 
            
                
            }catch(Exception e){
                System.out.println("Koneksi error "+ e);
                JOptionPane.showMessageDialog(null, "Koneksi Gagal");
            }
        }
        return koneksi;
    }
    
    
}
