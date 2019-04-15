import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class CSVFileReader
{
    public static void filereader()
    {
        String csvFile = "csvfile.csv";

        String line = "";
        String csvSplit = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile)))
        {
            while ((line = br.readLine()) != null)
            {
                String[] data = line.split(csvSplit);
                System.out.println(data[0]);
            }
        }
        catch (IOException e)
        {
            System.out.print("Error @ read:" + e);
        }
    }

    public static void insertQuery()
    {
        try
        {
            Connection conn = Dbconfig.getMySqlConnection();
            PreparedStatement st = conn.prepareStatement("INSERT INTO Student(id,FirstName,LastName,Major) " +
                    "VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            st.setInt(1, 5);
            st.setString(2, "Aubrey");
            st.setString(3, "Fernando");
            st.setString(4, "Computer Science");
            st.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println("Error @ insert query level");
        }
    }

}
