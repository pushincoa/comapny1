package Contorller.Main.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.member.implMember;
import Model.member;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addMember extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField mobile;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addMember frame = new addMember();
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
	public addMember() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		name = new JTextField();
		name.setBounds(144, 92, 130, 26);
		contentPane.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(144, 130, 130, 26);
		contentPane.add(username);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(144, 168, 130, 26);
		contentPane.add(password);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(144, 206, 130, 26);
		contentPane.add(address);
		
		mobile = new JTextField();
		mobile.setColumns(10);
		mobile.setBounds(144, 244, 130, 26);
		contentPane.add(mobile);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(144, 282, 130, 26);
		contentPane.add(phone);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setBounds(71, 97, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("帳號");
		lblNewLabel_1.setBounds(71, 135, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("密碼");
		lblNewLabel_1_1.setBounds(71, 173, 61, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("地址");
		lblNewLabel_1_1_1.setBounds(71, 211, 61, 16);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("行動");
		lblNewLabel_1_1_1_1.setBounds(71, 249, 61, 16);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("電話");
		lblNewLabel_1_1_1_1_1.setBounds(71, 287, 61, 16);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JButton add = new JButton("註冊");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*1.username--->gettext()
				 *2.帳號判斷-->queryusername():boolean
				 *3.true--->重複-->addError
				 *4.false--->接收所有資料--->new member-->add()-->addSuccess
				 *	 
				 * 
				 */
				String Username=username.getText();
				if(new implMember().queryUser(Username))
				{
					addError error=new addError();
					error.show();
					dispose();
					
				}
				else
				{
					String Name=name.getText();					
					String Password=password.getText();
					String Address=address.getText();
					String Mobile=mobile.getText();
					String Phone=phone.getText();
					
					member m=new member(Name,Username,Password,Address,Mobile,Phone);
					
					new implMember().add(m);
					
					addSuccess success=new addSuccess();
					success.show();
					dispose();
				}
				
				
				
			}
		});
		add.setBounds(156, 342, 117, 29);
		contentPane.add(add);
	}

}
