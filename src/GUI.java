import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URI;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class GUI extends JFrame{
	
	private JTextField txtNumber;
	private JTextField textTitle;
	private JTextArea textAreaDescription;
	private JLabel lblSource;
	
	private static final int FIRST = 0;
	private static final int LAST = 99;
	private static int id = 0;
	
	//Main method
	public static void main(String[] args) {
		
		Main data = new Main();
		new GUI();
	}
	
	//Constructor
	public GUI() {
		
		setTitle("Rosetta Code");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 450);
		getContentPane().setLayout(null);
		
		setTxtField();
		createbuttons();
		setLables();		
		setTextArea();
		
		showDescription();

		//JScrollPane scrollPane = new JScrollPane(textAreaDescription);   // JTextArea is placed in a JScrollPane.
		//JScrollPane scrollPane = new JScrollPane(mainConsole);
		//scrollPane.setBounds(10,60,780,500);
		//scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//this.getContentPane().add(scrollPane);
		
		this.setLocationRelativeTo(null); //Place in the center of the screen
		this.setVisible(true);

	}
	
	private void showDescription(){
		
		try{
			txtNumber.setText(String.format("%d", id+1));
			String[] description = Main.getSubject(id);
			textTitle.setText(description[1]);
			textAreaDescription.setText(description[2]);
			lblSource.setText(description[3]);
			lblSource.setCursor(new Cursor(Cursor.HAND_CURSOR));
			
			lblSource.addMouseListener(new MouseListener(){

					@Override
					public void mouseClicked(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				}	
			);
			
			//lblSource.setCursor(new Cursor(Cursor.HAND_CURSOR));

		} 
		catch(Exception ex){
			
			String error = ex.getMessage();
			JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//Buttons
	private void createbuttons(){
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnNewButton.setBounds(504, 377, 80, 25);
		getContentPane().add(btnNewButton);
		
		JButton btnStart = new JButton("First");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(id != FIRST){
					id = FIRST;
					txtNumber.setText(String.format("%d", id+1));
					showDescription();
				} else{
					JOptionPane.showMessageDialog(null, "This is first question alredy.\n", "Information message", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnStart.setBounds(10, 377, 80, 25);
		getContentPane().add(btnStart);
		
		JButton button_1 = new JButton("<<< ");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(id > FIRST){
					
					id--;
					txtNumber.setText(String.format("%d", id+1));
					showDescription();
				}
				else{
					
					JOptionPane.showMessageDialog(null, "This is first question alredy.\n", "Information message", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		button_1.setBounds(100, 377, 80, 25);
		getContentPane().add(button_1);
		
		JButton btnNext = new JButton(">>>");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(id < LAST){
					
					id++;
					txtNumber.setText(String.format("%d", id+1));
					showDescription();
				}
				else{
					JOptionPane.showMessageDialog(null, "This is last question alredy.\n", "Information message", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNext.setBounds(192, 377, 80, 25);
		getContentPane().add(btnNext);
		
		JButton btnLast = new JButton("Last");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(id != LAST){
					id = LAST;
					txtNumber.setText(String.format("%d", id+1));
					showDescription();
				} else{
					JOptionPane.showMessageDialog(null, "This is last question alredy.\n", "Information message", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnLast.setBounds(282, 377, 80, 25);
		getContentPane().add(btnLast);
	}
	
	private void setTxtField(){
		
		txtNumber = new JTextField();
		txtNumber.setEditable(false);
		txtNumber.setBounds(95, 11, 46, 20);
		getContentPane().add(txtNumber);
		txtNumber.setColumns(10);
		
		textTitle = new JTextField();
		textTitle.setEditable(false);
		textTitle.setColumns(10);
		textTitle.setBounds(192, 11, 392, 20);
		getContentPane().add(textTitle);
	}
	
	private void setLables(){
		
		JLabel lblNumber = new JLabel("Question #:");
		lblNumber.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNumber.setBounds(0, 14, 81, 14);
		getContentPane().add(lblNumber);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(154, 14, 46, 14);
		getContentPane().add(lblTitle);
		
		lblSource = new JLabel("Source");
		lblSource.setBounds(538, 352, 46, 14);
		getContentPane().add(lblSource);
	}
	
	private void setTextArea(){
		
		textAreaDescription = new JTextArea();
		textAreaDescription.setEditable(false);
		textAreaDescription.setLineWrap(true);
		textAreaDescription.setFont(new Font("Monospaced", Font.PLAIN, 15));
		textAreaDescription.setBounds(10, 53, 574, 288);
		
		textAreaDescription.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		
		//getContentPane().add(textAreaDescription);

		JScrollPane scroolPane = new JScrollPane(textAreaDescription);
		scroolPane.setBounds(11,54,574,288);
		getContentPane().add(scroolPane);		
		
		JButton buttonSolution = new JButton("Solution");
		buttonSolution.setBounds(372, 377, 80, 25);
		getContentPane().add(buttonSolution);
	}
	
	//END
}
