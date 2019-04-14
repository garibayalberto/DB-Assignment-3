import java.sql.Connection;
import java.sql.DriverManager;


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
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return mysqlConnection;
    }
}
