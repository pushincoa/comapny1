package Dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import Dao.DbConnection;
import Dao.member.memberDao;
import Model.member;

public class implMember implements memberDao{

	public static void main(String[] args) {
		//創會員資料
		//member m=new member("町村秋","tttt","000","台北","44","111");		
		//new implMember().add(m);
		
		//查詢資料
		//System.out.println(new implMember().queryAll());
		
		//個別查詢 查id 名稱
		/*System.out.println(new implMember().queryAll2());
		List<member> l=new implMember().queryAll2();
		
		for(member o:l)
		{
			System.out.println(o.getId()+"\t"+o.getName());
		}
		System.out.println(l.size());
	 	*/
		
		//queryId 查詢
		//System.out.println(new implMember().queryId(1));  //查詢Id:1有沒有這個人
															//沒有則回傳null
		
		//System.out.println(new implMember().queryMember("abc", "test"));
		
		/*member m=new implMember().queryId(1);//    指定修改id
		m.setMobile("0000000");				// 新增要修改的內容		
		m.setPhone("858585858");
		
		new implMember().upDate(m);       //回傳資料庫 用upDate 的步驟
		*/
		
		//new implMember().delete(1);		//  使用void delete()	
		
		System.out.println(new implMember().queryUser("b"));
	
	}
	
	
	

	@Override
	public void add(member m) {
		 Connection conn=DbConnection.getDB();
		 String sQL="insert into member(name,username,password,address,mobile,phone)"
				 
				 				+ "values(?,?,?,?,?,?)";
		 try {
			PreparedStatement ps=conn.prepareStatement(sQL);
			ps.setString(1, m.getName());
			ps.setString(2, m.getUsername());
			ps.setString(3, m.getPassword());
			ps.setString(4, m.getAddress());
			ps.setString(5, m.getMobile());
			ps.setString(6, m.getPhone());
			
			ps.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

	@Override
	public String queryAll() {
		Connection conn=DbConnection.getDB();
		String SQL="select * from member";
		String show="";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				show=show+"id:"+rs.getInt("id")+
						"\t名:"+rs.getString("name")+
						"\t帳號:"+rs.getString("username")+
						"\t密碼:"+rs.getString("password")+
						"\t地址:"+rs.getString("address")+
						"\t行動:"+rs.getString("mobile")+
						"\t電話:"+rs.getString("phone")+"\n";
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return show;
	}

	@Override
	public List<member> queryAll2() {
		Connection conn=DbConnection.getDB();
		String SQL="select * from member";
		List<member> l=new ArrayList();
		
		try {
			PreparedStatement pa=conn.prepareStatement(SQL);
			ResultSet re=pa.executeQuery();
			while(re.next())
			{
				member m=new member();
				m.setId(re.getInt("id"));
				m.setName(re.getString("name"));
				m.setUsername(re.getString("username"));
				m.setPassword(re.getString("password"));
				m.setAddress(re.getString("address"));
				m.setMobile(re.getString("mobile"));
				m.setPhone(re.getString("phone"));
				l.add(m);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return l;
	}

	@Override
	public member queryId(int id) {
		/*
		 *1.連線
		 *2.SQL
		 *3.ResulSet
		  4.if->rs.next() 
		  5.true---->rs-->new member()
		  6.false-->null
		*/
		Connection conn=DbConnection.getDB();
		String SQL="select * from member where id=?"; //用SQL的語法
		member m=null;  //先假設沒有m這個人
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);					//利用ID 去查
			ResultSet rs=ps.executeQuery();     //查詢資料
			
			if(rs.next())						//如果有這個人
			{
				m=new member();
				m.setId(rs.getInt("id"));				
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setMobile(rs.getString("mobile"));
				m.setPhone(rs.getString("phone"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return m;    
	}

	@Override
	public member queryMember(String username, String password) {
		/*
		 * 1.先連線->Connection
		 * 2.SQL-->where usetname=? and password=?
		 * 3.ResulSet
		 * 4.if(re.next())
		 * 5.true--->new member()-->rs填入資料
		 * 6.false--->null
		 */
		
		Connection conn=DbConnection.getDB();
		String SQL="select * from member where username=? and password=?";
		member m=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				m=new member();
				m.setName(rs.getString("name"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setMobile(rs.getString("mobile"));
				m.setPhone(rs.getString("phone"));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
				
		
		return m;
	}



	@Override
	public void upDate(member m) {
		/* 
		 * 1.先連線
		 * 2.SQL-->update 全部內容 where id=?
		 * 3.prepareStatement執行
		 * 
		 */
		
		Connection conn=DbConnection.getDB();
		String SQL="update member set name=? ,username=? ,password=?, address=? "
				+ ",mobile=?,phone=?"+"where id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, m.getName());
			ps.setString(2, m.getUsername());
			ps.setString(3, m.getPassword());
			ps.setString(4, m.getAddress());
			ps.setString(5, m.getMobile());
			ps.setString(6, m.getPhone());
			
			ps.setInt(7, m.getId());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}



	@Override
	public void delete(int id) {
		/*
		 * 1.先連線
		 * 2.SQL->where id=?
		 * 3.prepareStatement執行
		 */
		Connection conn=DbConnection.getDB();
		String SQL="delete from member where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id );
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}




	@Override
	public boolean queryUser(String username) {
		Connection conn=DbConnection.getDB();
		String SQL="select * from member where username=?";
		boolean m=false;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) m=true;
				
					} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		return m;
	}

}
