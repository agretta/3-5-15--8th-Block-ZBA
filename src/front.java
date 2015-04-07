import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class front {

	private JFrame frame;
	private JTextField txtTypeTheUsername;
	private JTextField txtAddUsername;
	private JTextField txtMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					front window = new front();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public front() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnAdd.setBounds(323, 64, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setBounds(42, 102, 62, 14);
		frame.getContentPane().add(lblMessage);
		
		JButton btnAddTheMessage = new JButton("Add message");
		btnAddTheMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAddTheMessage.setBounds(304, 129, 120, 23);
		frame.getContentPane().add(btnAddTheMessage);
		
		JLabel lblGetMessage = new JLabel("Get Message");
		lblGetMessage.setBounds(42, 173, 120, 14);
		frame.getContentPane().add(lblGetMessage);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(42, 210, 120, 20);
		frame.getContentPane().add(comboBox_1);
		
		txtMessage = new JTextField();
		txtMessage.setBounds(42, 252, 370, 51);
		frame.getContentPane().add(txtMessage);
		txtMessage.setColumns(10);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(42, 130, 120, 20);
		frame.getContentPane().add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(134, 210, 28, 20);
		frame.getContentPane().add(comboBox_3);
	}
}
