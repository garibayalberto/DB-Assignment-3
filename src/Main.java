import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;


public class Main
{
    //create class to generate data,
    public static void main(String[] args)
    {
        Dbconfig db = new Dbconfig();
        CSVFileReader file = new CSVFileReader();

        Connection con = Dbconfig.getMySqlConnection();
        file.filereader();
        db.disconnecting(con);

    }
}
