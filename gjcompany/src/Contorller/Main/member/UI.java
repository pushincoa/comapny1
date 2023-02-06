package Contorller.Main.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.member.implMember;
import Model.member;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class UI extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField mobile;
	private JTextField phone;
	private JTextField deletID;
	private JTextField TxName;
	private JTextField TxAdress;
	private JTextField TxID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(191, 191, 191));
		panel.setBounds(28, 32, 269, 522);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("名字:");
		lblNewLabel.setBounds(6, 71, 43, 29);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號:");
		lblNewLabel_1.setBounds(6, 112, 43, 29);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("密碼:");
		lblNewLabel_1_1.setBounds(6, 157, 43, 29);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("地址:");
		lblNewLabel_1_1_1.setBounds(6, 198, 43, 29);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("行動:");
		lblNewLabel_1_1_1_1.setBounds(6, 239, 43, 29);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("手機:");
		lblNewLabel_1_1_1_1_1.setBounds(6, 280, 43, 29);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		name = new JTextField();
		name.setBounds(45, 72, 130, 26);
		panel.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(45, 113, 130, 26);
		panel.add(username);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(45, 158, 130, 26);
		panel.add(password);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(45, 199, 130, 26);
		panel.add(address);
		
		mobile = new JTextField();
		mobile.setColumns(10);
		mobile.setBounds(45, 240, 130, 26);
		panel.add(mobile);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(45, 281, 130, 26);
		panel.add(phone);
		
		JButton btnNewButton = new JButton("新增");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 1.UI接收
				 * 2.new member()
				 * 3.add(m)
				 */
				String Name=name.getText();
				String Username=username.getText();
				String Passwoed=password.getText();
				String Address=address.getText();
				String Mobile=mobile.getText();
				String Phone=phone.getText();
				member m=new member(Name,Username,Passwoed,Address,Mobile,Phone);
				
				new implMember().add(m);
				
				
			}
		});
		btnNewButton.setBounds(45, 339, 117, 29);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("會員資料新增");
		lblNewLabel_3.setBounds(69, 28, 106, 16);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(191, 191, 191));
		panel_1.setBounds(337, 32, 457, 522);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea show = new JTextArea();
		show.setBounds(6, 127, 445, 307);
		panel_1.add(show);
		
		
		JLabel countNum = new JLabel("New label");
		countNum.setBounds(21, 460, 108, 40);
		panel_1.add(countNum);
		
		
		JButton queryAll = new JButton("查詢");
		queryAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 1.show.setText(new implMember():String
				 */
				show.setText(new implMember().queryAll());
				
				List<member> l=new implMember().queryAll2();
				countNum.setText("共:"+l.size()+"筆");
				
				
			}
		});
		queryAll.setBounds(56, 6, 117, 29);
		panel_1.add(queryAll);
		
	
		
		deletID = new JTextField();
		deletID.setBounds(274, 6, 130, 26);
		panel_1.add(deletID);
		deletID.setColumns(10);
		
		TxName = new JTextField();
		TxName.setColumns(10);
		TxName.setBounds(274, 46, 130, 26);
		panel_1.add(TxName);
		
		TxAdress = new JTextField();
		TxAdress.setColumns(10);
		TxAdress.setBounds(274, 89, 130, 26);
		panel_1.add(TxAdress);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setBounds(235, 11, 61, 16);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("姓名");
		lblNewLabel_2_1.setBounds(235, 51, 61, 16);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("地址");
		lblNewLabel_2_1_1.setBounds(235, 91, 61, 16);
		panel_1.add(lblNewLabel_2_1_1);
		
		TxID = new JTextField();
		TxID.setBounds(175, 47, 36, 26);
		panel_1.add(TxID);
		TxID.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("ID");
		lblNewLabel_4.setBounds(137, 52, 21, 16);
		panel_1.add(lblNewLabel_4);
		
		JButton btnNewButton_2_1 = new JButton("修改");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 1.nameUpdate,addressUpdate,updateId-->getText()
				 * 2.updateID--->轉int--->queryID(id)-->member m
				 * 3.m.setName(),m.setAddress()
				 * 4.update(m)
				 * 
				 */
				String Name=TxName.getText();
				String Address=TxAdress.getText();
				int ID=Integer.parseInt(TxID.getText());
				member m=new implMember().queryId(ID);
				m.setName(Name);
				m.setAddress(Address);
				
				new implMember().upDate(m);
				
						
				
			}
		});
		btnNewButton_2_1.setBounds(6, 47, 117, 29);
		panel_1.add(btnNewButton_2_1);
		

		JButton btnNewButton_2_1_1 = new JButton("刪除");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 1.deleteId-->getText()--->轉型-->int
				 * 2.執行 delete(id)
				 */
				
				int ID=Integer.parseInt(deletID.getText());
				new implMember().delete(ID);
				
			}
		});
		btnNewButton_2_1_1.setBounds(56, 86, 117, 29);
		panel_1.add(btnNewButton_2_1_1);
		
		
	
		  
		
	}
}
