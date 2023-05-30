package onlineBookStore;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import login.LoginFrame;
//import home.HomeFrame;

import javax.swing.JButton;
import java.awt.event.ActionListener;
//import java.sql.Date;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

public class CreateFrame extends JFrame {
	private JTextField textField;
	private JTextField textField_2;
	private JTextField passwordField;
	private JTextField textField_1;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_3;
	int cnt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateFrame frame = new CreateFrame();
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
	public CreateFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 410);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(0, 0, 434, 371);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame login = new LoginFrame();
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(12, 10, 67, 23);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 43, 434, 328);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		CreateVO create = new CreateVO();
		
		JLabel lblNewLabel_1 = new JLabel("아이디");
		lblNewLabel_1.setBounds(92, 10, 57, 15);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(167, 10, 116, 21);
		panel_1.add(textField);
		textField.setColumns(10);
		
		CreateMethod cm = new CreateMethod();
		JButton btnNewButton_2 = new JButton("중복 확인");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cnt++;
				if(textField.getText().length() < 4) {
					JOptionPane.showMessageDialog(null, "아이디는 4자리 이상이어야 합니다");
				} else if(cm.IdOverlap(textField.getText()) == 1) {
					JOptionPane.showMessageDialog(null, "중복된 아이디입니다");
				} else {
					JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다");
				}
			}
		});
		btnNewButton_2.setBounds(295, 6, 97, 23);
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("비밀번호");
		lblNewLabel_2.setBounds(92, 45, 57, 15);
		panel_1.add(lblNewLabel_2);
		
		passwordField = new JTextField();
		passwordField.setBounds(167, 41, 116, 21);
		panel_1.add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("이름");
		lblNewLabel_3.setBounds(92, 84, 57, 15);
		panel_1.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(167, 81, 116, 21);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("생년월일");
		lblNewLabel_4.setBounds(92, 120, 57, 15);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_8 = new JLabel("전화번호");
		lblNewLabel_8.setBounds(92, 152, 57, 15);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_11 = new JLabel("이메일");
		lblNewLabel_11.setBounds(92, 180, 57, 15);
		panel_1.add(lblNewLabel_11);
		
		textField_1 = new JTextField();
		textField_1.setBounds(167, 177, 116, 21);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("주소");
		lblNewLabel_13.setBounds(92, 212, 57, 15);
		panel_1.add(lblNewLabel_13);
		
		textField_6 = new JTextField();
		textField_6.setBounds(167, 209, 116, 21);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(167, 117, 116, 21);
		panel_1.add(textField_7);
		textField_7.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(167, 149, 116, 21);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("회원가입");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(161, 5, 132, 37);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("가입");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length() >= 4 && cm.IdOverlap(textField.getText()) == 0 && passwordField.getText().length() >= 4
						&& cnt >=1) {
					
					CreateDAO cd = new CreateDAO();
					create.setId(textField.getText());
					create.setPw(passwordField.getText());
					create.setName(textField_2.getText());
					create.setBirth(textField_7.getText());
					create.setPhone(textField_3.getText());
					create.setEmail(textField_1.getText());
					create.setAddress(textField_6.getText());
					
					cd.insertCreate(create);
					JOptionPane.showMessageDialog(null, "축하합니다! 가입되었습니다!");
					LoginFrame login = new LoginFrame();
					login.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "다시 입력해 주세요");
				}
				
			}
		});
		btnNewButton_1.setBounds(162, 288, 97, 23);
		panel_1.add(btnNewButton_1);
	}
}
