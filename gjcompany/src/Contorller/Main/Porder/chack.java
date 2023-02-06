package Contorller.Main.Porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.porder.implPorder;
import Model.porder;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;

public class chack extends JFrame {

	private JPanel contentPane;
	private JTextField udesk;
	private JTextField uc;
	private JTextField id;
	private JTextField ub;
	private JTextField ua;
	private JTextField desk;
	private JTextField A;
	private JTextField B;
	private JTextField C;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chack frame = new chack();
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
	public chack() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		udesk = new JTextField();
		udesk.setBounds(455, 55, 61, 37);
		contentPane.add(udesk);
		udesk.setColumns(10);
		
		uc = new JTextField();
		uc.setColumns(10);
		uc.setBounds(718, 55, 54, 37);
		contentPane.add(uc);
		
		JLabel lblNewLabel = new JLabel("桌號:");
		lblNewLabel.setBounds(421, 58, 61, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ａ:");
		lblNewLabel_1.setBounds(528, 58, 61, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("B:");
		lblNewLabel_1_1.setBounds(600, 58, 61, 30);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("C:");
		lblNewLabel_1_1_1.setBounds(692, 58, 61, 30);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID:");
		lblNewLabel_2.setBounds(421, 147, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		id = new JTextField();
		id.setBounds(454, 140, 108, 30);
		contentPane.add(id);
		id.setColumns(10);
		
		ub = new JTextField();
		ub.setColumns(10);
		ub.setBounds(626, 55, 54, 37);
		contentPane.add(ub);
		
		ua = new JTextField();
		ua.setColumns(10);
		ua.setBounds(547, 52, 54, 37);
		contentPane.add(ua);
		
		JLabel lblNewLabel_3 = new JLabel("點餐系統");
		lblNewLabel_3.setBounds(118, 39, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("桌號:");
		lblNewLabel_4.setBounds(40, 81, 61, 30);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Ａ:");
		lblNewLabel_4_1.setBounds(40, 123, 61, 30);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Ｂ:");
		lblNewLabel_4_1_1.setBounds(40, 165, 61, 30);
		contentPane.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Ｃ:");
		lblNewLabel_4_1_1_1.setBounds(40, 208, 61, 30);
		contentPane.add(lblNewLabel_4_1_1_1);
		
		desk = new JTextField();
		desk.setBounds(78, 83, 130, 26);
		contentPane.add(desk);
		desk.setColumns(10);
		
		A = new JTextField();
		A.setColumns(10);
		A.setBounds(78, 125, 130, 26);
		contentPane.add(A);
		
		B = new JTextField();
		B.setColumns(10);
		B.setBounds(78, 165, 130, 26);
		contentPane.add(B);
		
		C = new JTextField();
		C.setColumns(10);
		C.setBounds(78, 203, 130, 26);
		contentPane.add(C);
		
		//新增
		JButton add = new JButton("確定");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 1.擷取UI-->getText
				 * 2.A,B,C-->轉型-->int
				 * 3.new porder
				 * 4.add.(p);
				 */
				String Desk=desk.getText();
				int a=Integer.parseInt(A.getText());
				int b=Integer.parseInt(B.getText());
				int c=Integer.parseInt(C.getText());
				porder p=new porder(Desk,a,b,c);      //new 
				new implPorder().add(p);

				
				
				
			}
		});
		
		JTextArea showAll = new JTextArea();
		showAll.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		showAll.setBounds(373, 208, 390, 241);
		contentPane.add(showAll);
		add.setBounds(78, 300, 117, 29);
		contentPane.add(add);
		
		//查詢
		
		JButton selectAll = new JButton("查詢");
		selectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 1.List<porder>  l -->selectAll();
				 * 2.String -->for-each-->顯示
				 * 3.List-->轉陣列-->toArray-->顯示,統計分析
				 */
				/*List<porder> l=new implPorder().selectAll();
				String show="";
				for(porder p:l)
				{
					show=show+"id:"+p.getId()+"\t桌號:"+p.getDesk()+"\tA:"+p.getA()+"\tB:"+p.getB()+"\tC:"+p.getC()+"\n";
				}
				showAll.setText(show);*/
				List<porder> l=new implPorder().selectAll();
				/*Object[] o=l.toArray();
				System.out.println(((porder)o[0]).getA());*/
				porder[] p=l.toArray(new porder[l.size()]);					//porder[] p=new pporder[3];
				//System.out.println(p[0].getId()+"\t"+p[0].getDesk());   //測試 抓出id 跟desk
				
				String show="";    //宣告 
				int sum=0;		   //宣告sum=0
				
				for(porder P:p)
				{
					show=show+"id"+P.getId()+"\t桌號:"+P.getDesk()+"\tA:"+P.getA()+"\tB:"+P.getB()+"\tC:"+P.getC()+"\n";
					
				}
				
				for(int i=0;i<p.length;i++)				//另外計算加總
				{
					sum=sum+p[i].getA();
				}
				
				showAll.setText(show+"\nA總共="+sum);   
				
				
			}
		});
		selectAll.setBounds(355, 6, 61, 37);
		contentPane.add(selectAll);
		
		//修改
		JButton update = new JButton("修改");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 1.擷取->所有的getText
				 * 2.ua,ub,uc,id-->String-->int
				 * 3.selectID-->id
				 * 4.porder-->set修改
				 * 5.update
				 */
				String Desk=udesk.getText();
				int A=Integer.parseInt(ua.getText());
				int B=Integer.parseInt(ub.getText());
				int C=Integer.parseInt(uc.getText());
				int ID=Integer.parseInt(id.getText());
				
				porder p=new implPorder().selectID(ID);
				p.setDesk(Desk);
				p.setA(A);
				p.setB(B);
				p.setC(C);
				
				new implPorder().update(p);


				
				
			}
		});
		update.setBounds(355, 55, 54, 37);
		contentPane.add(update);
		
		//刪除
		JButton delete = new JButton("刪除");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * 1.擷取-->Id-->轉型 int
				 * 2.delete
				 */
				int ID=Integer.parseInt(id.getText());
				
				new implPorder().delete(ID);
				
			}
		});
		delete.setBounds(355, 142, 54, 29);
		contentPane.add(delete);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(186, 186, 186));
		panel.setBounds(6, 6, 324, 438);
		contentPane.add(panel);
	}
}
