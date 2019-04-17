import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class CSVFileReader
{
    public static void filereader() {

        String csvFile = "csvfile.csv";
        String line;
        String csvSplit = ",";


        try (BufferedReader br = new BufferedReader(new FileReader(csvFile)))
        {
            Connection conn = Dbconfig.getMySqlConnection();
            PreparedStatement csvWHInsert = conn.prepareStatement("INSERT INTO USWarehouse(SKU, Description, SellableOnHand, OpenPOQuantity, MOQ, LeadTime, BackOrders) "
                    + "VALUES(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            PreparedStatement csvTSInsert = conn.prepareStatement("INSERT INTO TotalSales(WarehouseId, OneMonthSales, ThreeMonthSales, SixMonthSales)" +
                    "VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            PreparedStatement csvDTInsert = conn.prepareStatement("INSERT INTO DimensionTable(WarehouseId, Fob_SH, L_cm, W_cm, H_cm, G_W_kg, N_W_kg)" +
                    "VALUES(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            PreparedStatement csvPTInsert = conn.prepareStatement("INSERT INTO PackagingTable(DimensionId, PackagingType, PalletDim, PalletCtns, PalletQty, PalletWeight, CartonQuantity)" +
                    "VALUES(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplit);

                String SKU = data[0];
                String Description = data[1];
                String SellableOnHand = data[2];
                String OpenPOqty = data[3];
                String OneMonthSales = data[4];
                String ThreeMonthSales = data[5];
                String SixMonthSales = data[6];
                String BackOrder = data[7];
                String LeadTime = data[8];
                String MOQ = data[9];
                String FobSH = data[10];
                String PackagingType = data[11];
                String L_cm = data[12];
                String W_cm = data[13];
                String H_cm = data[14];
                String GW_kg = data[15];
                String NW_kg = data[16];
                String Carton_qty = data[17];
                String Pallet_Dim_cm = data[18];
                String Pallet_ctns = data[19];
                String Pallet_qty = data[20];
                String Pallet_WG_kg = data[21];

                csvWHInsert.setInt(1, Integer.parseInt(SKU));
                csvWHInsert.setString(2, Description);
                csvWHInsert.setString(3, SellableOnHand);
                csvWHInsert.setInt(4, Integer.parseInt(OpenPOqty));
                csvWHInsert.setInt(5, Integer.parseInt(MOQ));
                csvWHInsert.setInt(6, Integer.parseInt(LeadTime));
                csvWHInsert.setInt(7, Integer.parseInt(BackOrder));
                csvWHInsert.executeUpdate();

                ResultSet key_WH = csvWHInsert.getGeneratedKeys();


                int key_WH_id = 0;
                if (key_WH.next()) {
                    key_WH_id = key_WH.getInt(1);
                }

                csvTSInsert.setInt(1, key_WH_id);
                csvTSInsert.setInt(2, Integer.parseInt(OneMonthSales));
                csvTSInsert.setInt(3, Integer.parseInt(ThreeMonthSales));
                csvTSInsert.setInt(4, Integer.parseInt(SixMonthSales));
                csvTSInsert.executeUpdate();

                csvDTInsert.setInt(1, key_WH_id);
                csvDTInsert.setFloat(2, Float.parseFloat(FobSH));
                csvDTInsert.setInt(3, Integer.parseInt(L_cm));
                csvDTInsert.setInt(4, Integer.parseInt(W_cm));
                csvDTInsert.setInt(5, Integer.parseInt(H_cm));
                csvDTInsert.setInt(6, Integer.parseInt(GW_kg));
                csvDTInsert.setInt(7, Integer.parseInt(NW_kg));
                csvDTInsert.executeUpdate();

                ResultSet key_Dim = csvDTInsert.getGeneratedKeys();

                int key_Dim_id = 0;
                if (key_Dim.next()) {
                    key_Dim_id = key_Dim.getInt(1);
                }

                csvPTInsert.setInt(1, key_Dim_id);
                csvPTInsert.setString(2, PackagingType);
                csvPTInsert.setString(3, Pallet_Dim_cm);
                csvPTInsert.setInt(4, Integer.parseInt(Pallet_ctns));
                csvPTInsert.setInt(5, Integer.parseInt(Pallet_qty));
                csvPTInsert.setInt(6, Integer.parseInt(Pallet_WG_kg));
                csvPTInsert.setInt(7, Integer.parseInt(Carton_qty));
                csvPTInsert.executeUpdate();


            }
        } catch (IOException e) {
            System.out.print("Error @ read: " + e);
        } catch (SQLException e) {
            System.out.println("Error @ insert level: " + e );
        }
    }
}
