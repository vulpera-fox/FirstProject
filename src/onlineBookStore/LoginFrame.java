package onlineBookStore;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import create.CreateFrame;
//import home.HomeFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("로그인");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel.setBounds(194, 10, 101, 35);
		contentPane.add(lblNewLabel);
		
		LoginMethod loginMethod = new LoginMethod();
		
		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_1.setBounds(116, 67, 73, 24);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(238, 69, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("비밀번호");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2.setBounds(116, 101, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(238, 98, 116, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
//		JButton btnNewButton = new JButton("회원가입");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				CreateFrame create = new CreateFrame();
//				create.setVisible(true);
//				dispose();
//			}
//		});
//		btnNewButton.setBounds(140, 157, 97, 23);
//		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("로그인");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int check_id = loginMethod.Id(textField.getText());
				int check_pw = loginMethod.Pw(textField_1.getText());
				
				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요");
				} else if(textField_1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요");
				} else if(check_id == 0) {
					JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다");
				} else if(check_id == 1 && check_pw == 0) {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다");
				} else if(check_id == 1 && check_pw == 1) {
					JOptionPane.showMessageDialog(null, "로그인 하였습니다");
//					HomeFrame home = new HomeFrame();
//					home.setVisible(true);
					dispose();
				}

			}
		});
		btnNewButton_1.setBounds(270, 157, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 488, 266);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("회원가입");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				CreateFrame create = new CreateFrame();
//				create.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(141, 157, 97, 23);
		panel.add(btnNewButton);
	}
}
