package Dao.porder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import Dao.DbConnection;
import Model.porder;

public interface porderDao {
	//連線方法
	static Connection getbd()
	{
		Connection conn=DbConnection.getDB();
		String url="jdbc:mysql://localhost:3306/company";
		String user="root";
		String password="1Dixrlau";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");  //連線要先寫的第一步
			try {
				conn=DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	
	//create
	void add(porder p);
	//Read
	List<porder> selectAll();
	porder selectID(int id);
	
	
	//update
	void update(porder p);
	
	//delete
	void delete(int id);
	

}
