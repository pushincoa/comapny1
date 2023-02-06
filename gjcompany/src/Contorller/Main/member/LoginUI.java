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
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginUI extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JButton login;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		username = new JTextField();
		username.setBounds(88, 92, 184, 26);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("帳號：");
		lblNewLabel.setBounds(34, 97, 42, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼：");
		lblNewLabel_1.setBounds(34, 135, 42, 16);
		contentPane.add(lblNewLabel_1);
		
		password = new JPasswordField();
		password.setBounds(88, 130, 184, 26);
		contentPane.add(password);
		
		login = new JButton("登入");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 1.帳號密碼 getText()
				 * 2.qurryUser(帳號,密碼):member
				 * 3.!=null--->loginSuccess
				 * 4.null-->loginError
				 */
				String Username=username.getText();
				String Password=password.getText();
				
				member m=new implMember().queryMember(Username, Password);
				
				if(m!=null)
				{
					loginSuccess l=new loginSuccess();
					l.show();
					dispose();
				}else
				{
					loginERROR l=new loginERROR();
					l.show();
					dispose();
				}
				
				
				
			}
		});
		login.setBounds(284, 84, 117, 45);
		contentPane.add(login);
		
		JButton btnNewButton_1 = new JButton("清除");
		btnNewButton_1.setBounds(379, 221, 65, 45);
		contentPane.add(btnNewButton_1);
	}
}
