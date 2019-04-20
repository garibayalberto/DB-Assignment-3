import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

public class CSVFileReader
{
    private static final String csvFile = "janelle1.csv";
//    private static String line;
//    private static String split = ",";

    private static int SKU;
    private static String Description;
    private static String SellableOnHand;
    private static int OpenPOqty;
    private static int OneMonthSales;
    private static int ThreeMonthSales;
    private static int SixMonthSales;
    private static int BackOrder;
    private static int LeadTime;
    private static int MOQ;
    private static float FobSH;
    private static String PackagingType;
    private static int L_cm;
    private static int W_cm;
    private static int H_cm;
    private static int GW_kg;
    private static int NW_kg;
    private static int Carton_qty;
    private static String Pallet_Dim_cm;
    private static int Pallet_ctns;
    private static int Pallet_qty;
    private static int Pallet_WG_kg;
    private static String Shipping_Date;
    private static int Shipping_PO;
    private static int Shipping_Qty;
    private static int Cost_Unit;
    private static float Shipping_Amt;
    private static String Shpmt_Received;
    private static String Shpmt_Date_Received;
    private static String Vendor;
    private static int Sales_PO;
    private static int Sales_Qty;
    private static String Sales_Date;
    private static float Sales_Amt;


    public static void readfile(Connection con) {

//        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))){
//            br.readLine();
//            while ((line = br.readLine()) != null) {
//                String[] data = line.split(split);
//
//                SKU = Integer.parseInt(data[0]);
//                Description = data[1];
//                SellableOnHand = data[2];
//                OpenPOqty = Integer.parseInt(data[3]);
//                OneMonthSales = Integer.parseInt(data[4]);
//                ThreeMonthSales = Integer.parseInt(data[5]);
//                SixMonthSales = Integer.parseInt(data[6]);
//                BackOrder = Integer.parseInt(data[7]);
//                LeadTime = Integer.parseInt(data[8]);
//                MOQ = Integer.parseInt(data[9]);
//                FobSH = Float.parseFloat(data[10]);
//                PackagingType = data[11];
//                L_cm = Integer.parseInt(data[12]);
//                W_cm = Integer.parseInt(data[13]);
//                H_cm = Integer.parseInt(data[14]);
//                GW_kg = Integer.parseInt(data[15]);
//                NW_kg = Integer.parseInt(data[16]);
//                Carton_qty = Integer.parseInt(data[17]);
//                Pallet_Dim_cm = data[18];
//                Pallet_ctns =Integer.parseInt(data[19]);
//                Pallet_qty = Integer.parseInt(data[20]);
//                Pallet_WG_kg = Integer.parseInt(data[21]);
//                Shipping_Date = data[22];
//                Shipping_PO = Integer.parseInt(data[23]);
//                Shipping_Qty = Integer.parseInt(data[24]);
//                Cost_Unit = Integer.parseInt(data[25]);
//                Shipping_Amt = Float.parseFloat(data[26]);
//                Shpmt_Received = Boolean.getBoolean(data[27]);
//                Shpmt_Date_Received = data[28];
//                Vendor = data[29];
//                Sales_PO = Integer.parseInt(data[30]);
//                Sales_Qty = Integer.parseInt(data[31]);
//                Sales_Date = data[32];
//                Sales_Amt = Float.parseFloat(data[33]);
//
//                insertRecord(con);

        try (Reader read = Files.newBufferedReader((Paths.get(csvFile)));
             CSVParser csvParser = new CSVParser(read, CSVFormat.DEFAULT
                     .withSkipHeaderRecord()
                     .withFirstRecordAsHeader())
        ) {
            for (CSVRecord record : csvParser) {
                SKU = Integer.parseInt(record.get(0));
                Description = record.get(1);
                SellableOnHand = record.get(2);
                OpenPOqty = Integer.parseInt(record.get(3));
                OneMonthSales = Integer.parseInt(record.get(4));
                ThreeMonthSales = Integer.parseInt(record.get(5));
                SixMonthSales = Integer.parseInt(record.get(6));
                BackOrder = Integer.parseInt(record.get(7));
                LeadTime = Integer.parseInt(record.get(8));
                MOQ = Integer.parseInt(record.get(9));
                FobSH = Float.parseFloat(record.get(10));
                PackagingType = record.get(11);
                L_cm = Integer.parseInt(record.get(12));
                W_cm = Integer.parseInt(record.get(13));
                H_cm = Integer.parseInt(record.get(14));
                GW_kg = Integer.parseInt(record.get(15));
                NW_kg = Integer.parseInt(record.get(16));
                Carton_qty = Integer.parseInt(record.get(17));
                Pallet_Dim_cm = record.get(18);
                Pallet_ctns = Integer.parseInt(record.get(19));
                Pallet_qty = Integer.parseInt(record.get(20));
                Pallet_WG_kg = Integer.parseInt(record.get(21));
                Shipping_Date = record.get(22);
                Shipping_PO = Integer.parseInt(record.get(23));
                Shipping_Qty = Integer.parseInt(record.get(24));
                Cost_Unit = Integer.parseInt(record.get(25));
                Shipping_Amt = Float.parseFloat(record.get(26));
                Shpmt_Received = record.get(27);
                Shpmt_Date_Received = record.get((28));
                Vendor = record.get(29);
                Sales_PO = Integer.parseInt(record.get(30));
                Sales_Qty = Integer.parseInt(record.get(31));
                Sales_Date = record.get((32));
                Sales_Amt = Float.parseFloat(record.get(33));
                insertRecord(con);
            }
        }
        catch (IOException e)
        {
            System.out.println("Error @ readfile level: " + e);
        }

        System.out.println("Inserted Data!");
    }

    //Need to edit varchars for approriate date length
    public static void createTable(Connection con) {
        String usWarehouse = "CREATE TABLE IF NOT EXISTS USWarehouse (" +
                "WarehouseID INTEGER auto_increment not null, " +
                "SKU integer not null, " +
                "PRIMARY KEY (WarehouseID, SKU), " +
                "Description varchar(25) not null, " +
                "SellableOnHand integer not null, " +
                "OpenPOQuantity integer not null,  " +
                "MOQ integer not null," +
                "LeadTime integer not null," +
                "BackOrders integer not null);";

        String totalSales = "CREATE TABLE IF NOT EXISTS TotalSales (" +
                "SalesID integer auto_increment not null, " +
                "PRIMARY KEY (SalesID), " +
                "WarehouseID integer not null, " +
                "CONSTRAINT FOREIGN KEY (WarehouseID) REFERENCES USWarehouse(WarehouseID)," +
                "OneMonthSales integer not null," +
                "ThreeMonthSales integer not null," +
                "SixMonthSales integer not null);";

        String dimensionTable = "CREATE TABLE IF NOT EXISTS DimensionTable (" +
                "DimensionID integer auto_increment not null, " +
                "PRIMARY KEY (DimensionID), " +
                "WarehouseID integer not null,"+
                "CONSTRAINT FOREIGN KEY (WarehouseID) REFERENCES USWarehouse(WarehouseID), " +
                "Fob_SH float not null," +
                "L_cm integer not null," +
                "W_cm integer not null," +
                "H_cm integer not null," +
                "G_W_kg integer not null," +
                "N_W_kg integer not null);";

        String packagingTable  = "CREATE TABLE IF NOT EXISTS PackagingTable (" +
                "PackagingID integer auto_increment not null, "+
                "PRIMARY KEY (PackagingID)," +
                "DimensionID integer not null," +
                "CONSTRAINT FOREIGN KEY (DimensionID) REFERENCES DimensionTable(DimensionID)," +
                "PackagingType varchar(30) not null," +
                "PalletDim varchar(30) not null," +
                "PalletCtns integer not null," +
                "PalletQty integer not null," +
                "PalletWeight integer not null," +
                "CartonQuantity integer not null);";

        String shippingTable  = "CREATE TABLE IF NOT EXISTS ShippingTable (" +
                "ShippingID integer auto_increment not null, "+
                "PRIMARY KEY (ShippingID)," +
                "WarehouseID integer not null," +
                "CONSTRAINT FOREIGN KEY (WarehouseID) REFERENCES USWarehouse(WarehouseID)," +
                "ShippingDate varchar(10) not null," +
                "ShippingPONumber integer not null," +
                "ShippingQty integer not null," +
                "IncostUnit integer not null," +
                "ShippingTotalAmt float not null," +
                "Received varchar(3) not null," +
                "ShippingDateReceived varchar(10) not null);";

        String salesTable  = "CREATE TABLE IF NOT EXISTS SalesTable (" +
                "SalesID integer auto_increment not null, "+
                "PRIMARY KEY (SalesID)," +
                "WarehouseID integer not null," +
                "CONSTRAINT FOREIGN KEY (WarehouseID) REFERENCES USWarehouse(WarehouseID)," +
                "Vendor varchar(30) not null," +
                "SalesPONumber integer not null," +
                "SalesQty integer not null," +
                "SalesDate varchar(10) not null," +
                "SalesAmt float not null);";

        try {
            PreparedStatement wH = con.prepareStatement(usWarehouse);
            wH.execute();

            PreparedStatement tS  = con.prepareStatement(totalSales);
            tS.execute();

            PreparedStatement dT = con.prepareStatement(dimensionTable);
            dT.execute();

            PreparedStatement pT = con.prepareStatement(packagingTable);
            pT.execute();

            PreparedStatement shT = con.prepareStatement(shippingTable);
            shT.execute();

            PreparedStatement sT = con.prepareStatement(salesTable);
            sT.execute();

        }
        catch (SQLException e)
        {
            System.out.println("Error @ create table level: " + e);
        }

        System.out.println("Created Tables!");
    }

    public static void insertRecord(Connection con)
    {
        String wh = "INSERT INTO USWarehouse(SKU, Description, SellableOnHand, OpenPOQuantity, MOQ, LeadTime, BackOrders) "
                + "VALUES(?,?,?,?,?,?,?)";

        String ts = "INSERT INTO TotalSales(WarehouseID, OneMonthSales, ThreeMonthSales, SixMonthSales)"
                + "VALUES(?,?,?,?)";

        String dt = "INSERT INTO DimensionTable(WarehouseID, Fob_SH, L_cm, W_cm, H_cm, G_W_kg, N_W_kg)"
                + "VALUES(?,?,?,?,?,?,?)";

        String pt ="INSERT INTO PackagingTable(DimensionID, PackagingType, PalletDim, PalletCtns, PalletQty, PalletWeight, CartonQuantity)"
                + "VALUES(?,?,?,?,?,?,?)";

        String sht = "INSERT INTO ShippingTable(WarehouseID, ShippingDate, ShippingPONumber, ShippingQty, InCostUnit, ShippingTotalAmt, Received, ShippingDateReceived)"
                + "VALUES(?,?,?,?,?,?,?,?)";

        String st = "INSERT INTO SalesTable(WarehouseID, Vendor, SalesPONumber, SalesQty, SalesDate, SalesAmt)"
                + "VALUES(?,?,?,?,?,?)";

        try
        {
            PreparedStatement whInsert = con.prepareStatement(wh,Statement.RETURN_GENERATED_KEYS);
            whInsert.setInt(1, SKU);
            whInsert.setString(2, Description);
            whInsert.setString(3, SellableOnHand);
            whInsert.setInt(4, OpenPOqty);
            whInsert.setInt(5, MOQ);
            whInsert.setInt(6, LeadTime);
            whInsert.setInt(7, BackOrder);
            whInsert.executeUpdate();

            ResultSet key_WH = whInsert.getGeneratedKeys();

            int key_WH_id = 0;
            if (key_WH.next())
            {
                key_WH_id = key_WH.getInt(1);
            }

            PreparedStatement tsInsert = con.prepareStatement(ts, Statement.RETURN_GENERATED_KEYS);
            tsInsert.setInt(1, key_WH_id);
            tsInsert.setInt(2, OneMonthSales);
            tsInsert.setInt(3, ThreeMonthSales);
            tsInsert.setInt(4, SixMonthSales);
            tsInsert.executeUpdate();

            PreparedStatement dtInsert = con.prepareStatement(dt, Statement.RETURN_GENERATED_KEYS);
            dtInsert.setInt(1, key_WH_id);
            dtInsert.setFloat(2, FobSH);
            dtInsert.setInt(3, L_cm);
            dtInsert.setInt(4, W_cm);
            dtInsert.setInt(5, H_cm);
            dtInsert.setInt(6, GW_kg);
            dtInsert.setInt(7, NW_kg);
            dtInsert.executeUpdate();

            ResultSet key_Dim = dtInsert.getGeneratedKeys();

            int key_Dim_id = 0;
            if (key_Dim.next())
            {
                key_Dim_id = key_Dim.getInt(1);
            }

            PreparedStatement ptInsert = con.prepareStatement(pt, Statement.RETURN_GENERATED_KEYS);
            ptInsert.setInt(1, key_Dim_id);
            ptInsert.setString(2, PackagingType);
            ptInsert.setString(3, Pallet_Dim_cm);
            ptInsert.setInt(4, Pallet_ctns);
            ptInsert.setInt(5, Pallet_qty);
            ptInsert.setInt(6, Pallet_WG_kg);
            ptInsert.setInt(7, Carton_qty);
            ptInsert.executeUpdate();

            PreparedStatement shtInsert = con.prepareStatement(sht, Statement.RETURN_GENERATED_KEYS);
            shtInsert.setInt(1, key_WH_id);
            shtInsert.setString(2, Shipping_Date);
            shtInsert.setInt(3, Shipping_PO);
            shtInsert.setInt(4, Shipping_Qty);
            shtInsert.setInt(5, Cost_Unit);
            shtInsert.setFloat(6, Shipping_Amt);
            shtInsert.setString(7, Shpmt_Received);
            shtInsert.setString(8, Shpmt_Date_Received);
            shtInsert.executeUpdate();

            PreparedStatement stInsert = con.prepareStatement(st, Statement.RETURN_GENERATED_KEYS);
            stInsert.setInt(1, key_WH_id);
            stInsert.setString(2, Vendor);
            stInsert.setInt(3, Sales_PO);
            stInsert.setInt(4, Sales_Qty);
            stInsert.setString(5,Sales_Date);
            stInsert.setFloat(6, Sales_Amt);
            stInsert.executeUpdate();

        }
        catch (SQLException e)
        {
            System.out.println("Error @ insert data level: " + e);
        }
    }
}
