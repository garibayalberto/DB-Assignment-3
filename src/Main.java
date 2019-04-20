import java.sql.Connection;

public class Main
{
    //create class to generate data,
    public static void main(String[] args)
    {
        Connection con = Dbconfig.getMySqlConnection();
        CSVFileReader.createTable(con);
        CSVFileReader.readfile(con);
        Dbconfig.disconnecting(con);
    }
}



// 17.32 seconds for 100 records
//