package Dao.member;

import Model.member;   //要先建好member的class
import java.util.List;

public interface memberDao {
	//Crate新增
	//void add(String name,String username,String password,String address,String phone,String mobile);
	void add(member m);//injext注入
	
	//read查詢
	String queryAll();
	List<member> queryAll2();
	member queryId(int id);    //調閱 id
	member queryMember(String username,String password);  //調閱 帳號密碼
	boolean queryUser(String username);
	
	
	//update修改
	void upDate(member m);
	
	
	//delete刪除
	void delete(int id);
}
