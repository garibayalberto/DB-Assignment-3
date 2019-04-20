import java.sql.Connection;

public class Main
{
    //create class to generate data,
    public static void main(String[] args)
    {
        Connection con = Dbconfig.getMySqlConnection();
        //CSVFileReader.createTable(con);
        //CSVFileReader.readfile(con);
        System.out.println("USWarehouse Table");
        Methods.displayuswarehouse(con);
        System.out.println(" ");
        System.out.println("Total Sales Table");
        Methods.displaytotalsales(con);
        System.out.println(" ");
        System.out.println("Dimension Table");
        Methods.displaydimensiontable(con);
        System.out.println(" ");
        System.out.println("Packaging Table");
        Methods.displaypackagingtable(con);
        System.out.println(" ");
        System.out.println("Sales Table");
        Methods.displaysalestable(con);
        System.out.println(" ");
        System.out.println("Shipping Table");
        Methods.displayshippingtable(con);
        Dbconfig.disconnecting(con);
    }
}



// 17.32 seconds for 100 records
//