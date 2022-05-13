package Model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import java.sql.DriverManager;

import java.sql.SQLException;

public class SQLConnect {

	public List<ProductInvoice> getReplacementInvoice() throws ClassNotFoundException, SQLException {

		// Connection URL Syntax: “jdbc:mysql://ipaddress:portnumber/db_name”
		String dbURL = "jdbc:sqlserver://172.16.10.22;databaseName=viettel_data_v2;user=qlvt;password=qlvt@123";
		Connection conn = DriverManager.getConnection(dbURL);
		List<ProductInvoice> replacementInvoice = new ArrayList<ProductInvoice>();
		if (conn != null) {
			System.out.println("Connected");
			DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
			System.out.println("Driver name: " + dm.getDriverName());
			System.out.println("Driver version: " + dm.getDriverVersion());
			System.out.println("Product name: " + dm.getDatabaseProductName());
			System.out.println("Product version: " + dm.getDatabaseProductVersion());

			java.sql.Statement sqlStatement = conn.createStatement();

			// declare the result set
			ResultSet rs = null;

			// Build the query string, making sure to use column aliases
			String queryString = "select Pattern, Serial, No, AdjustPattern, AdjustSerial, AdjustNo from dbo.AdjustInv where AdjustSerial ='1C22TBB' and Description = N'Hóa đơn thay thế' and ProcessDate >= '2022-05-01 00:00:00.000' and  ProcessDate <='2022-05-30 00:00:00.000'";

			// print the query string to the screen
			System.out.println("\nQuery string:");
			System.out.println(queryString);

			// execute the query
			rs = sqlStatement.executeQuery(queryString);

			// loop through the result set and call method to print the result set row
			while (rs.next()) {
				ProductInvoice productInv = new ProductInvoice();
				productInv.setPattern(rs.getString("Pattern"));
				productInv.setSerial(rs.getString("Serial"));
				productInv.setNo(rs.getString("No"));
				productInv.setAdjustPattern(rs.getString("AdjustPattern"));
				productInv.setAdjustSerial(rs.getString("AdjustSerial"));
				productInv.setAdjustNo(rs.getString("AdjustNo"));
				productInv.setDescription(rs.getString("Description"));
				productInv.setProcessDate(rs.getString("ProcessDate"));
				replacementInvoice.add(productInv);
			}

			int total = replacementInvoice.size();
			// close the result set
			rs.close();
			System.out.println(total);

			// close the database connection
			conn.close();
		}
		conn.close();
		return replacementInvoice;
	}
	
	public List<ProductInvoice> getAdjustmentInvoice() throws ClassNotFoundException, SQLException {

		// Connection URL Syntax: “jdbc:mysql://ipaddress:portnumber/db_name”
		String dbURL = "jdbc:sqlserver://172.16.10.22;databaseName=viettel_data_v2;user=qlvt;password=qlvt@123";
		Connection conn = DriverManager.getConnection(dbURL);
		List<ProductInvoice> adjustmentInvoice = new ArrayList<ProductInvoice>();
		if (conn != null) {
			System.out.println("Connected");
			DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
			System.out.println("Driver name: " + dm.getDriverName());
			System.out.println("Driver version: " + dm.getDriverVersion());
			System.out.println("Product name: " + dm.getDatabaseProductName());
			System.out.println("Product version: " + dm.getDatabaseProductVersion());

			java.sql.Statement sqlStatement = conn.createStatement();

			// declare the result set
			ResultSet rs = null;

			// Build the query string, making sure to use column aliases
			String queryString = "select Pattern, Serial, No, AdjustPattern, AdjustSerial, AdjustNo from dbo.AdjustInv where AdjustSerial ='1C22TBB' and Description = N'Hóa đơn điều chỉnh' and ProcessDate >= '2022-05-01 00:00:00.000' and  ProcessDate <='2022-05-30 00:00:00.000'";

			// print the query string to the screen
			System.out.println("\nQuery string:");
			System.out.println(queryString);

			// execute the query
			rs = sqlStatement.executeQuery(queryString);

			// loop through the result set and call method to print the result set row
			while (rs.next()) {
				ProductInvoice productInv = new ProductInvoice();
				productInv.setPattern(rs.getString("Pattern"));
				productInv.setSerial(rs.getString("Serial"));
				productInv.setNo(rs.getString("No"));
				productInv.setAdjustPattern(rs.getString("AdjustPattern"));
				productInv.setAdjustSerial(rs.getString("AdjustSerial"));
				productInv.setAdjustNo(rs.getString("AdjustNo"));
				productInv.setDescription(rs.getString("Description"));
				productInv.setProcessDate(rs.getString("ProcessDate"));
				adjustmentInvoice.add(productInv);
			}

			int total = adjustmentInvoice.size();
			// close the result set
			rs.close();
			System.out.println(total);

			// close the database connection
			conn.close();
		}
		conn.close();
		return adjustmentInvoice;
	}
}
