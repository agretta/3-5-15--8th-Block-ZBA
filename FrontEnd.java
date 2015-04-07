import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;


public class FrontEnd {
	


	private JFrame frmZba;
	private JTextField userNameField;
	private JTextField messageField;
	private BackEnd back;
	public FrontEnd(){
		
		//Frame and BackEnd Implementation
		File f = new File("Message_Storage");
		back = new BackEnd(f);
		frmZba = new JFrame();
		frmZba.setTitle("ZBA");
		frmZba.setBounds(100, 100, 600, 511);
		frmZba.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmZba.getContentPane().setLayout(null);
		frmZba.setPreferredSize(new Dimension(600,511));
		frmZba.setResizable(false);
		frmZba.getContentPane().setBackground(new Color(202,225,255));
		//labels
		JLabel lblMessage = new JLabel("Message Search");
		lblMessage.setBounds(134, 227, 46, 14);
		lblMessage.setSize(new Dimension(120,14));
		frmZba.getContentPane().add(lblMessage);
		
		JLabel label = new JLabel("Insert New User");
		label.setBounds(77, 37, 46, 14);
		label.setSize(new Dimension(120,14));
		
		JLabel lbMessagePrompt = new JLabel("Insert new Message");
		lbMessagePrompt.setBounds(76, 109, 46, 14);
		frmZba.getContentPane().add(lbMessagePrompt);
		lbMessagePrompt.setSize(120,14);

		frmZba.getContentPane().add(label);
		//Buttons

		JButton btnAddUser = new JButton("Add User");
		btnAddUser.setBounds(191, 59, 89, 23);
		frmZba.getContentPane().add(btnAddUser);
		
		JButton btnAddMessage = new JButton("Add Message");
		btnAddMessage.setBounds(305, 133, 117, 23);
		frmZba.getContentPane().add(btnAddMessage);
		
		JButton searchButton = new JButton("Search");
		searchButton.setBounds(305, 299, 117, 23);
		frmZba.getContentPane().add(searchButton);
		
		//TextAreas
		userNameField = new JTextField();
		userNameField.setBounds(77, 60, 86, 20);
		frmZba.getContentPane().add(userNameField);
		userNameField.setColumns(10);
		userNameField.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent arg0) {
				if(arg0.equals(KeyEvent.VK_ENTER)){
					btnAddUser.doClick();
				}
			}
			public void keyReleased(KeyEvent arg0) {				}
			public void keyTyped(KeyEvent arg0) {}	
		});
				
		messageField = new JTextField();
		messageField.setBounds(191, 134, 86, 20);
		frmZba.getContentPane().add(messageField);
		messageField.setColumns(10);
		messageField.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e) {
				if(e.equals(KeyEvent.VK_ENTER)){
					btnAddMessage.doClick();
				}
				
			}
			public void keyReleased(KeyEvent e) {}
			public void keyTyped(KeyEvent e) {}
				});
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(77, 252, 203, 152);
		frmZba.getContentPane().add(scrollPane);

		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(77, 252, 203, 152);
		frmZba.getContentPane().add(textPane);
		scrollPane.setViewportView(textPane);
		
		//ComboBoxes
		List<String> s = back.getUsers();
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setToolTipText("Find User");
		comboBox.setBounds(77, 134, 86, 20);
		
		frmZba.getContentPane().add(comboBox);
		
		JComboBox<String> nameMessage = new JComboBox<String>();
		nameMessage.setToolTipText("Find User");
		nameMessage.setBounds(305, 252, 117, 20);
		frmZba.getContentPane().add(nameMessage);
		
		for(String name : s){
			comboBox.addItem(name);
			nameMessage.addItem(name);
		} 
		//Listeners
		
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox.addItem(userNameField.getText());
				nameMessage.addItem(userNameField.getText());
				back.addMessage(userNameField.getText(), "\t");
			}
		});
		
		btnAddMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
				back.addMessage(comboBox.getItemAt(comboBox.getSelectedIndex()), messageField.getText());
			}
		});
		
		searchButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				List<String> messages = back.getMessages(((String)nameMessage.getSelectedItem()));
				String s = "";
				for(String message : messages)
					if(!message.equals("\t"))
						s += message + "\n";
				textPane.setText(s);				
			}
		});
		//Packing and Displaying
		frmZba.pack();
		frmZba.setVisible(true);
	}
	
}
