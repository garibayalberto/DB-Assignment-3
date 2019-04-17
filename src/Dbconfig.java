import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;


public class Dbconfig
{
    private Connection pgSqlConnection = null;

    public static Connection getMySqlConnection()
    {
        Connection mysqlConnection = null;
        try
        {
            //returns the Class object associated with the class or interface with the given string
            Class.forName("com.mysql.jdbc.Driver"); //one invocation
            String connectionUrl = "jdbc:mysql://35.233.130.214:3306/maxxhaul"; //set string near
            mysqlConnection = DriverManager.getConnection(connectionUrl, "ramir266", "torNado911!");
            System.out.println("Connected to Database!");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return mysqlConnection ;

    }

    public static void disconnecting(Connection con)
    {
        DatabaseMetaData dm;
        ResultSet rs;
        try
        {
            if(con != null)
            {
                dm = con.getMetaData();
                rs = dm.getCatalogs();
                rs.close();
                con.close();
                System.out.println("Closing database");
            }
            else
                System.out.println("Error: No active Connection");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


}
