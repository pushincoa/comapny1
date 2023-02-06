package Contorller.Main.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Contorller.Main.Porder.chack;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class loginSuccess extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginSuccess frame = new loginSuccess();
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
	public loginSuccess() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("成功登入");
		lblNewLabel.setBounds(199, 100, 181, 72);
		contentPane.add(lblNewLabel);
		
		JButton porderui = new JButton("ok");
		porderui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chack p=new chack();
				p.show();
				dispose();
				
			}
		});
		porderui.setBounds(172, 173, 117, 29);
		contentPane.add(porderui);
	}

}
