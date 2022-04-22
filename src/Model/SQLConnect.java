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

	public List<ProductInvoice> getProductInvoice() throws ClassNotFoundException, SQLException {

		// Connection URL Syntax: “jdbc:mysql://ipaddress:portnumber/db_name”
		String dbURL = "jdbc:sqlserver://172.16.10.22;databaseName=viettel_data_v2;user=qlvt;password=qlvt@123";
		Connection conn = DriverManager.getConnection(dbURL);
		List<ProductInvoice> listProductInvoice = new ArrayList<ProductInvoice>();
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
			String queryString = "select  * from ProductInv";

			// print the query string to the screen
			System.out.println("\nQuery string:");
			System.out.println(queryString);

			// execute the query
			rs = sqlStatement.executeQuery(queryString);

			// loop through the result set and call method to print the result set row
			while (rs.next()) {
				ProductInvoice productInv = new ProductInvoice();
				productInv.setCode(rs.getString("Code"));
				productInv.setName(rs.getString("Name"));
				productInv.setPrice(rs.getString("Price"));
				listProductInvoice.add(productInv);
			}

			int total=listProductInvoice.size();
			// close the result set
			rs.close();
			System.out.println(total);

			// close the database connection
			conn.close();
		}
		conn.close();
		return listProductInvoice;
	}
}
