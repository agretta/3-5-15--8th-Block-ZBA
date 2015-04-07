import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class FrontEnd {
	
	private JFrame frame;
	private JTextField txtTypeTheUsername;
	private JTextField txtAddUsername;
	private JTextField txtTypeTheMessage;
	private JTextField txtUsername;
	private JTextField txtMessage;

	private BackEnd backEnd;
	public FrontEnd () {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(42, 31, 76, 23);
		frame.getContentPane().add(lblUsername);
		
		txtTypeTheUsername = new JTextField();
		txtTypeTheUsername.setBounds(42, 65, 120, 20);
		frame.getContentPane().add(txtTypeTheUsername);
		txtTypeTheUsername.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(134, 65, 28, 20);
		frame.getContentPane().add(comboBox);
		
		txtAddUsername = new JTextField();
		txtAddUsername.setBounds(188, 130, 93, 20);
		frame.getContentPane().add(txtAddUsername);
		txtAddUsername.setColumns(10);
		
		
		
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setBounds(42, 102, 62, 14);
		frame.getContentPane().add(lblMessage);
		
		
		
		
		JLabel lblGetMessage = new JLabel("Get Message");
		lblGetMessage.setBounds(42, 173, 120, 14);
		frame.getContentPane().add(lblGetMessage);
		
		JComboBox<String > comboBox_1 = new JComboBox<String >();
		comboBox_1.setBounds(42, 210, 120, 20);
		frame.getContentPane().add(comboBox_1);
		
		txtMessage = new JTextField();
		txtMessage.setBounds(42, 252, 370, 51);
		frame.getContentPane().add(txtMessage);
		txtMessage.setColumns(10);
		
		JComboBox<String > comboBox_2 = new JComboBox<String >();
		comboBox_2.setBounds(42, 130, 120, 20);
		frame.getContentPane().add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(134, 210, 28, 20);
		frame.getContentPane().add(comboBox_3);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBox_1.addItem(txtAddUsername.getText());
				backEnd.addMessage(txtAddUsername.getText(), " ");
				comboBox_2.addItem(txtAddUsername.getText());
			}
		});
		
		JButton btnAddTheMessage = new JButton("Add message");
		btnAddTheMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				backEnd.addMessage(comboBox_1.getItemAt(comboBox_1.getSelectedIndex()), txtTypeTheMessage.getText());
			}
		});
		btnAdd.setBounds(323, 64, 89, 23);
		frame.getContentPane().add(btnAdd);
		btnAddTheMessage.setBounds(304, 129, 120, 23);
		frame.getContentPane().add(btnAddTheMessage);
		frame.pack();
		frame.setVisible(true);
	}


}
//	backEnd.addMessage(comboBox_1.getItemAt(comboBox_1.getSelectedIndex()), txtTypeTheMessage.getText());

//comboBox_1.addItem(txtAddUsername.getText());
//backEnd.addMessage(txtAddUsername.getText(), " ");
//comboBox_2.addItem(txtAddUsername.getText());
