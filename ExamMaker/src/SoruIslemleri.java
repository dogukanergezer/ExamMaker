
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SoruIslemleri {
    
    
    private Connection con = null;
    
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    
    public ArrayList<Soru> sorulariGetir(){
        
        ArrayList<Soru> cikti = new ArrayList<Soru>();
        
        try {
            statement = con.createStatement();
            String sorgu = "Select * From soruislemleri";
            
            ResultSet rs = statement.executeQuery(sorgu);
             
            while(rs.next()){
                int id= rs.getInt("id");
                String SoruTipi= rs.getString("SoruTipi");
                String DersAdi= rs.getString("DersAdi");
                String Soru= rs.getString("Soru");
                String Sik1= rs.getString("Sik1");
                String Sik2= rs.getString("Sik2");
                String Sik3= rs.getString("Sik3");
                String Sik4= rs.getString("Sik4");
                String Cevap= rs.getString("Cevap");
                int Puan= rs.getInt("Puan");
                int ZorlukDerecesi= rs.getInt("ZorlukDerecesi");
                
                cikti.add(new Soru(id, DersAdi, SoruTipi, Soru, Sik1, Sik2, Sik3, Sik4, Cevap, ZorlukDerecesi, Puan));
                
                
            }
            return cikti;
            
        } catch (SQLException ex) {
            Logger.getLogger(SoruIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
        
    } 
    
    public void soruGuncelle(int id, String yeni_soruTipi, String yeni_dersAdi, String yeni_Soru, String yeni_sik1,String yeni_sik2, String yeni_sik3, String yeni_sik4, String yeni_cevap, String yeni_puan,String yeni_zorlukDerecesi){
        
        String sorgu = "Update soruislemleri set SoruTipi = ? , DersAdi = ? , Soru = ? , Sik1  = ? , Sik2  = ? , Sik3  = ? , Sik4  = ? , Cevap  = ? , Puan  = ? , ZorlukDerecesi  = ? where id = ? ";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, yeni_soruTipi); // 1. soru işaretinin yerine yeni_soruTipi gelmiş oldu
            preparedStatement.setString(2, yeni_dersAdi);
            preparedStatement.setString(3, yeni_Soru);
            preparedStatement.setString(4, yeni_sik1);
            preparedStatement.setString(5, yeni_sik2);
            preparedStatement.setString(6, yeni_sik3);
            preparedStatement.setString(7, yeni_sik4);
            preparedStatement.setString(8, yeni_cevap);
            preparedStatement.setString(9, yeni_puan);
            preparedStatement.setString(10, yeni_zorlukDerecesi);
            
            preparedStatement.setInt(11, id);
  
            preparedStatement.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SoruIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    public void soruSil(int id){
        
        String sorgu = "Delete from soruislemleri where id=?";
        
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
             preparedStatement.setInt(1, id);
        
             
             preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SoruIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
    }
    
    public void soruEkle(String SoruTipi,String DersAdi, String Soru, String Sik1, String Sik2, String Sik3, String Sik4, String Cevap, String Puan, String ZorlukDerecesi){
        
        
        String sorgu= "Insert Into soruislemleri(SoruTipi,DersAdi,Soru,Sik1,Sik2,Sik3,Sik4,Cevap,Puan,ZorlukDerecesi) VALUES (?,?,?,?,?,?,?,?,?,?) ";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, SoruTipi);
            preparedStatement.setString(2, DersAdi);
            preparedStatement.setString(3, Soru);
            preparedStatement.setString(4, Sik1);
            preparedStatement.setString(5, Sik2);
            preparedStatement.setString(6, Sik3);
            preparedStatement.setString(7, Sik4);
            preparedStatement.setString(8, Cevap);
            preparedStatement.setString(9, Puan);
            preparedStatement.setString(10,ZorlukDerecesi);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SoruIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    
    
    
    }
    
    
    
    
    
    public boolean girisYap(String kullanici_adi,String parola){
     
        String sorgu = "Select * From  adminler where username = ? and password = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, kullanici_adi);  // ilk soru işaretine kullanıcı adı
              preparedStatement.setString(2, parola); // 2. ye parola gonderildi
              
              ResultSet rs= preparedStatement.executeQuery();
              
              return rs.next(); // giris basarılı ise true, degilse false dondurur
              
              
        } catch (SQLException ex) {
            Logger.getLogger(SoruIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    return false;
    
    }
     
    public SoruIslemleri(){
        
         String url = "jdbc:mysql://" + DataBase.host + ":" + DataBase.port + "/" + DataBase.db_ismi+ "?useUnicode=true&characterEncoding=utf8";
        
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Bulunamadı....");
        }
        
        
        try {
            con = DriverManager.getConnection(url, DataBase.kullanici_adi, DataBase.parola);
            System.out.println("Bağlantı Başarılı...");
            
            
        } catch (SQLException ex) {
            System.out.println("Bağlantı Başarısız...");
            //ex.printStackTrace();
        }
        
        
        
    }
    
    
  
    
    
}
