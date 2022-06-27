import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class BDConecction {
    Connection con;
    String usuario;
    String password;

    public BDConecction() throws Exception{
        this("root","");

    }

    public BDConecction(String usuario, String pass) throws Exception{

        this.usuario = usuario;
        this.password = pass;
        String sURL = "jdbc:mysql://localhost/mychat?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        con = DriverManager.getConnection(sURL,this.usuario,this.password);
    }

    public Connection getCon() {
        return con;
    }
    public void cerrarConexion() throws  Exception{
        con.close();
    }
    

}