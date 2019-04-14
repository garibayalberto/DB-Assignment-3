import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVFileReader
{
    public static void filereader()
    {
        String csvFile = "csvfile.csv";

        String line = "";
        String csvSplit = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))){

            while ((line = br.readLine()) != null){
                String[] data = line.split(csvSplit);

                System.out.println(data[0] + data[1] + data[2] + data[3]);
            }
        } catch (IOException e) {
            System.out.print("Error @ read:" + e);
        }
    }
}
