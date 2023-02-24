package GenricLib;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.mysql.cj.jdbc.Driver;

public class FileUtilies {
	public Connection con;
public String getpropertydata(String key) throws IOException
{
	Properties p=new Properties();
	FileInputStream fis=new FileInputStream(AutoConstant.propertyfilepath);
	p.load(fis);
	return p.getProperty(key);
}

public String getexceldata(String sheetname, int rownum, int cellnum) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream(AutoConstant.excelpath);
	Workbook wb=WorkbookFactory.create(fis);
	String e = wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
	return e;
}

public Connection getdatadb() throws SQLException
{
	Driver dref=new Driver();
	DriverManager.registerDriver(dref);
	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","Jeni@0301","Jeni@0301");
	return con;
}
public void executequery(String query1, String expectedresult) throws SQLException
{
	Statement statement=con.createStatement();
	ResultSet result=statement.executeQuery(query1);
	while(result.next())
	{
		if(result.equals(expectedresult))
		{
			break;
		}
		else
		{
			
			System.out.println("data not found");
		}
	}
}
public void closedb() throws SQLException
{
	con.close();
	
}


}
