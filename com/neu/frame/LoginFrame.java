package com.neu.frame;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.neu.SGS;
import com.neu.bean.User;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
//import java.util.HashMap;
import java.awt.event.ActionEvent;

/**
 * 图形界面--登陆界面
 * @author tydd
 *
 */
/*？不致命错误*/
@SuppressWarnings("serial")
public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtUserNo;
	private JPasswordField txtPwd;
/*？不致命错误*/
	@SuppressWarnings("rawtypes")
	private JComboBox cbType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
/*？不致命错误*/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public LoginFrame() {
		setResizable(false);
		setTitle("登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 714, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(5, 1, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("登        录");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 24));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("用户ID：");
		lblNewLabel_1.setFont(new Font("SimSun", Font.PLAIN, 24));
		panel_1.add(lblNewLabel_1);
		
		txtUserNo = new JTextField();
		txtUserNo.setFont(new Font("SimSun", Font.PLAIN, 24));
		panel_1.add(txtUserNo);
		txtUserNo.setColumns(15);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		JLabel qwer = new JLabel("密  码：");
		qwer.setFont(new Font("SimSun", Font.PLAIN, 24));
		panel_2.add(qwer);
		
		txtPwd = new JPasswordField();
		txtPwd.setColumns(15);
		txtPwd.setFont(new Font("SimSun", Font.PLAIN, 24));
		panel_2.add(txtPwd);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("用户类别：");
		lblNewLabel_2.setFont(new Font("SimSun", Font.PLAIN, 24));
		panel_3.add(lblNewLabel_2);
		
		cbType = new JComboBox();
		cbType.setFont(new Font("SimSun", Font.PLAIN, 24));
		cbType.setModel(new DefaultComboBoxModel(new String[] {"管理员", "教师", "学生"}));
		panel_3.add(cbType);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		
		JButton btnLogin = new JButton("登录");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoginClick(e);
			}
		});
		btnLogin.setFont(new Font("SimSun", Font.PLAIN, 24));
		panel_4.add(btnLogin);
		
		JButton btnExit = new JButton("退出");
		btnExit.setFont(new Font("SimSun", Font.PLAIN, 24));
		panel_4.add(btnExit);
		this.setLocationRelativeTo(null);
	}
/*？不致命错误*/
	@SuppressWarnings("deprecation")
	protected void btnLoginClick(ActionEvent e) {
		// TODO 自动生成的方法存根
		String uid=txtUserNo.getText();
		String pwd=txtPwd.getText();
		if (uid.length()<1) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			txtUserNo.requestFocus();
			return;
		}
		if (pwd.length()<1) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			txtPwd.requestFocus();
			return;
		}
	User user=null;
	int type=cbType.getSelectedIndex();
	switch(type) {
	case User.USER_TYPE_ADMIN:
		break;
	case User.USER_TYPE_TEACHER:
		user=SGS.faculty.get(uid);
		break;
	case User.USER_TYPE_STUDENT:
		user=SGS.school.get(uid);
		break;
	}
	if (user==null) {
		JOptionPane.showMessageDialog(null, "用户编号错误");
		txtUserNo.requestDefaultFocus();
		return;
	}
	if (!pwd.equals(user.getUserPw())) {
		JOptionPane.showMessageDialog(null, "用户密码错误");
		txtPwd.requestFocus();
		return;
	}
		
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
		this.dispose();
	}

}
