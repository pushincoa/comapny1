package Dao.porder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Dao.DbConnection;

import java.util.ArrayList;

import Model.porder;

public class implPorder implements porderDao{
			public static void main(String[] args) {
				//System.out.println(porderDao.getbd());
				//porder p=new porder("D桌",2,1,2);
				//new implPorder().add(p);
				
				//System.out.println(new implPorder().selectAll());
				
				//System.out.println(new implPorder().selectID(5));
				
				//porder p=new implPorder().selectID(2);
				//p.setDesk("X桌");
				//new implPorder().update(p);
				new implPorder().delete(1);
			}
	

	@Override
	public void add(porder p) {
		Connection conn=DbConnection.getDB();
		String SQL="insert into porder(desk,A,B,C) "
					+"values(?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);  //使用preparedStatememt 方法
			ps.setString(1,p.getDesk());
			ps.setInt(2, p.getA());
			ps.setInt(3, p.getB());
			ps.setInt(4, p.getC());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	@Override
	public List<porder> selectAll() {
		Connection conn=DbConnection.getDB();
		String SQL="select * from porder";
		List<porder> l=new ArrayList();
		
		try {
			PreparedStatement p=conn.prepareStatement(SQL);
			ResultSet rs=p.executeQuery();    //  ResultSet
			
			while(rs.next())
			{
				porder p1=new porder();
				p1.setId(rs.getInt("id"));
				p1.setDesk(rs.getString("desk"));
				p1.setA(rs.getInt("A"));
				p1.setB(rs.getInt("B"));
				p1.setC(rs.getInt("C"));
				
				l.add(p1);

				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return l;    //最後要把 l丟出來才有 值
	}

	@Override
	public porder selectID(int id) {
		Connection conn=DbConnection.getDB();   	//先連線
		String SQL="select * from porder where id=?"; //使用SQL語法 
		porder p=null;									//創建porder p
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				p=new porder();
				p.setId(rs.getInt("id"));
				p.setDesk(rs.getString("desk"));
				p.setA(rs.getInt("A"));
				p.setB(rs.getInt("B"));
				p.setC(rs.getInt("C"));

			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return p;
	}

	@Override
	public void update(porder p) {
		Connection conn=DbConnection.getDB();
		String SQL="update porder set desk=?,A=?,B=?,C=? where id=?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SQL); 
			
			//下面的順序須照SQL desk->A->B->C -> ID 不然的話會有問題				
			ps.setString(1, p.getDesk());
			ps.setInt(2, p.getA());
			ps.setInt(3, p.getB());
			ps.setInt(4, p.getC());
			ps.setInt(5, p.getId());

			
			ps.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		Connection conn=DbConnection.getDB();
		String SQL="delete from porder where id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);  
			ps.setInt(1, id);
			ps.executeUpdate();        //executeUpdate 更新
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
