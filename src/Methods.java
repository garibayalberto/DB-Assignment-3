import com.mysql.cj.api.mysqla.result.Resultset;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

public class Methods
{
    public static void displayuswarehouse(Connection con)
    {
        try
        {
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM USWarehouse");
            System.out.println("ID" + "|| "  + "SKU" + " || "+ "Description" + " || "+ "SellableOnHand"
                    + " || " + "OpenPOQuantity" + " || " + "MOQ" + " || " + "LeadTime" + " || " + "BackOrders");

            while(resultSet.next())
            {
                int columnName1 = resultSet.getInt("WarehouseID");
                int columnName2 = resultSet.getInt("SKU");
                String columnName3 = resultSet.getString("Description");
                int columnName4 = resultSet.getInt("SellableOnHand");
                int columnName5 = resultSet.getInt("OpenPOQuantity");
                int columnName6 = resultSet.getInt("MOQ");
                int columnName7 = resultSet.getInt("LeadTime");
                int columnName8 = resultSet.getInt("BackOrders");
                System.out.println(columnName1 + " || "  + columnName2 + " || "+ columnName3 + " || "+ columnName4
                        + " || " + columnName5 + " || " + columnName6 + " || " + columnName7 + " || " + columnName8);
            }
            //resultSet.close();
            //resultSet.cancelRowUpdates();
            //st.close();
        }
        catch(SQLException e)
        {
            System.out.println("Error @ insert data level: " + e);
        }
    }

    public static void displaytotalsales(Connection con)
    {
        try
        {
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM TotalSales");
            System.out.println("SalesID" + "|| "  + "WarehouseID" + " || "+ "1MonthSales" + " || "+ "3MonthSales"
                    + " || " + "6MonthSales");

            while(resultSet.next())
            {
                int columnName1 = resultSet.getInt("SalesID");
                int columnName2 = resultSet.getInt("WarehouseID");
                String columnName3 = resultSet.getString("OneMonthSales");
                int columnName4 = resultSet.getInt("ThreeMonthSales");
                int columnName5 = resultSet.getInt("SixMonthSales");
                System.out.println(columnName1 + " || "  + columnName2 + " || "+ columnName3 + " || "+ columnName4
                        + " || " + columnName5);
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error @ insert data level: " + e);
        }
    }

    public static void displaydimensiontable(Connection con)
    {
        try
        {
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM DimensionTable");
            System.out.println("DimensionID" + "|| "  + "WarehouseID" + " || "+ "Fob_SH" + " || "+ "L_cm"
                    + " || " + "W_cm" + " || " + "H_cm" + " || " + "G_W_kg" + " || " + "N_W_kg");

            while(resultSet.next())
            {
                int columnName1 = resultSet.getInt("DimensionID");
                int columnName2 = resultSet.getInt("WarehouseID");
                float columnName3 = resultSet.getFloat("Fob_SH");
                int columnName4 = resultSet.getInt("L_cm");
                int columnName5 = resultSet.getInt("W_cm");
                int columnName6 = resultSet.getInt("H_cm");
                int columnName7 = resultSet.getInt("G_W_kg");
                int columnName8 = resultSet.getInt("N_W_kg");
                System.out.println(columnName1 + " || "  + columnName2 + " || "+ columnName3 + " || "+ columnName4
                        + " || " + columnName5  + " || " + columnName6  + " || " + columnName7  + " || " + columnName8);
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error @ insert data level: " + e);
        }
    }

    public static void displaypackagingtable(Connection con)
    {
        try
        {
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM PackagingTable");
            System.out.println("PackagingID" + "|| "  + "DimensionID" + " || "+ "PackagingType" + " || "+ "PalletDim"
                    + " || " + "PalletCtns" + " || " + "PalletQty" + " || " + "PalletWeight" + " || " + "CartonQuantity");

            while(resultSet.next())
            {
                int columnName1 = resultSet.getInt("PackagingID");
                int columnName2 = resultSet.getInt("DimensionID");
                String columnName3 = resultSet.getString("PackagingType");
                String columnName4 = resultSet.getString("PalletDim");
                int columnName5 = resultSet.getInt("PalletCtns");
                int columnName6 = resultSet.getInt("PalletQty");
                int columnName7 = resultSet.getInt("PalletWeight");
                int columnName8 = resultSet.getInt("CartonQuantity");
                System.out.println(columnName1 + " || "  + columnName2 + " || "+ columnName3 + " || "+ columnName4
                        + " || " + columnName5  + " || " + columnName6  + " || " + columnName7  + " || " + columnName8);
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error @ insert data level: " + e);
        }
    }

    public static void displaysalestable(Connection con)
    {
        try
        {
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM SalesTable");
            System.out.println("SalesID" + "|| "  + "WarehouseID" + " || "+ "Vendor" + " || "+ "SalesPONumber"
                    + " || " + "SalesQty" + " || " + "SalesDate" + " || " + "SalesAmt");

            while(resultSet.next())
            {
                int columnName1 = resultSet.getInt("SalesID");
                int columnName2 = resultSet.getInt("WarehouseID");
                String columnName3 = resultSet.getString("Vendor");
                int columnName4 = resultSet.getInt("SalesPONumber");
                int columnName5 = resultSet.getInt("SalesQty");
                String columnName6 = resultSet.getString("SalesDate");
                float columnName7 = resultSet.getFloat("SalesAmt");
                System.out.println(columnName1 + " || "  + columnName2 + " || "+ columnName3 + " || "+ columnName4
                        + " || " + columnName5  + " || " + columnName6  + " || " + columnName7);
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error @ insert data level: " + e);
        }
    }

    public static void displayshippingtable(Connection con)
    {
        try
        {
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM ShippingTable");
            System.out.println("ShippingID" + "|| "  + "WarehouseID" + " || "+ "ShippingDate" + " || "+ "ShippingPONumber"
                    + " || " + "ShippingQty" + " || " + "IncostUnit" + " || " + "ShippingTotalAmt" + " || " + "Received"
                    + " || " + "ShippingDateReceived");

            while(resultSet.next())
            {
                int columnName1 = resultSet.getInt("ShippingID");
                int columnName2 = resultSet.getInt("WarehouseID");
                String columnName3 = resultSet.getString("ShippingDate");
                int columnName4 = resultSet.getInt("ShippingPONumber");
                int columnName5 = resultSet.getInt("ShippingQty");
                int columnName6 = resultSet.getInt("IncostUnit");
                float columnName7 = resultSet.getFloat("ShippingTotalAmt");
                String columnName8 = resultSet.getString("Received");
                String columnName9 = resultSet.getString("ShippingDateReceived");
                System.out.println(columnName1 + " || "  + columnName2 + " || "+ columnName3 + " || "+ columnName4
                        + " || " + columnName5  + " || " + columnName6  + " || " + columnName7 + " || " + columnName8
                        + " || " + columnName9);
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error @ insert data level: " + e);
        }
    }
}
