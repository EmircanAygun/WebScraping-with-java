import java.io.File;
import java.sql.*;

public class Baglanti {
     private Connection conn;
    
    public Connection baglan(  ){
        return conn;
    }
    public Baglanti(  ){

       
        
        try{  
Class.forName( "com.mysql.cj.jdbc.Driver" );  
conn=DriverManager.getConnection(   "jdbc:mysql://localhost:3306/ws_veritabaný", "root", "1234" );  
//here sonoo is database name, root is username and password   
}catch( Exception e ){ System.out.println( e );}  
        
    }
}
