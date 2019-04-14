import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

public class Main {

    public static void displayDbProperties(Connection con)
    {
        DatabaseMetaData dm;
        ResultSet rs;
        try
        {
            if(con != null)
            {
                dm = con.getMetaData();
                System.out.println("Driver Information");
                System.out.println("\tDriver Name: "+ dm.getDriverName());
                System.out.println("\tDriver Version: "+ dm.getDriverVersion ());
                System.out.println("\nDatabase Information ");
                System.out.println("\tDatabase Name: "+ dm.getDatabaseProductName());
                System.out.println("\tDatabase Version: "+ dm.getDatabaseProductVersion());
                System.out.println("Available Catalogs ");
                rs = dm.getCatalogs();

                while(rs.next()){
                    System.out.println("\tcatalog: "+ rs.getString(1));
                }
                rs.close();
                con.close();
            }
            else
                System.out.println("Error: No active Connection");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        //CSVParser csv = enw CSVParser
    }

    //create class to generate data,
    public static void main(String[] args)
    {
        Connection con = Dbconfig.getMySqlConnection();
        displayDbProperties(con);
    }
}
