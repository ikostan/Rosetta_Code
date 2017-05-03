import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JProgressBar;
import java.awt.SystemColor;

public class GUI extends JFrame{
	
	private JTextField txtNumber;
	private JTextField textTitle;
	private JTextArea textAreaDescription;
	
	private JProgressBar progressBar;
	
	private static final int FIRST = 0;
	private static final int LAST = 99;
	private static int id = 0;
	
	//Main method
	public static void main(String[] args) {
		
		new Description();
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
		createButtons();
		setLables();		
		setTextArea();
		setProgressBar();
		showDescription(id);
		
		this.setLocationRelativeTo(null); //Place in the center of the screen
		this.setVisible(true);
		
		//Constructor
	}
	
	//Update GUI sceen - show question description, number and progress bar
	private void showDescription(int id){
		
		String[] description = Description.getSubject(id);
		txtNumber.setText(String.format("%d", id+1));
		progressBar.setValue(id+1);
		progressBar.setStringPainted(true);
		
		try{
			
			textTitle.setText(description[1]);
			textAreaDescription.setText(description[2]);
		} 
		catch(Exception ex){
			
			String error = ex.getMessage();
			JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//Buttons
	private void createButtons(){
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			//Event handler
			public void actionPerformed(ActionEvent e) {
				//Close application
				System.exit(0);
			}
		});
		btnNewButton.setBounds(504, 377, 80, 25);
		getContentPane().add(btnNewButton);
		
		JButton btnStart = new JButton("First");
		btnStart.addActionListener(new ActionListener() {
			//Event handler
			public void actionPerformed(ActionEvent arg0) {
				
				if(id != FIRST){
					id = FIRST;
					showDescription(id);
				} else{
					JOptionPane.showMessageDialog(null, "This is first question alredy.\n", "Information message", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnStart.setBounds(10, 377, 80, 25);
		getContentPane().add(btnStart);
		
		JButton button_1 = new JButton("<<< ");
		button_1.addActionListener(new ActionListener() {
			//Event handler
			public void actionPerformed(ActionEvent e) {
				
				if(id > FIRST){
					
					id--;
					showDescription(id);
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
			//Event handler
			public void actionPerformed(ActionEvent e) {
				
				if(id < LAST){
					
					++id;
					showDescription(id);
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
			//Event handler
			public void actionPerformed(ActionEvent e) {
				
				if(id != LAST){
					id = LAST;
					showDescription(id);
				} else{
					JOptionPane.showMessageDialog(null, "This is last question alredy.\n", "Information message", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnLast.setBounds(282, 377, 80, 25);
		getContentPane().add(btnLast);
		
		JButton buttonSolution = new JButton("Solution");
		buttonSolution.setBounds(372, 377, 80, 25);
		getContentPane().add(buttonSolution);	
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
	}
	
	private void setTextArea(){
		
		textAreaDescription = new JTextArea();
		textAreaDescription.setForeground(Color.BLACK);
		textAreaDescription.setBackground(SystemColor.inactiveCaptionBorder);
		textAreaDescription.setEditable(false);
		textAreaDescription.setLineWrap(true);
		textAreaDescription.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textAreaDescription.setBounds(10, 53, 574, 288);
		
		textAreaDescription.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		
		JScrollPane scroolPane = new JScrollPane(textAreaDescription);
		scroolPane.setBounds(11,54,574,288);
		getContentPane().add(scroolPane);			
	}
	
	private void setProgressBar(){
		
		progressBar = new JProgressBar();
		progressBar.setBounds(10, 353, 574, 14);
		getContentPane().add(progressBar);
	}
	
	
	//END
}
