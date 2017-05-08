import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JProgressBar;
import java.awt.SystemColor;

public class GUI extends JFrame {

	private JFrame frame;
	
	private static final long serialVersionUID = 1L;
	private JTextField txtNumber;
	private JTextField textTitle;
	private JTextArea textAreaDescription, textAreaSolution;

	String[] description;

	private JProgressBar progressBar;

	private static final int FIRST = 0;
	private static final int LAST = 99;
	private static int id = 0;

	private static Path currentRelativePath;
	private static String rootFolder;
	
	// Main method
	public static void main(String[] args) {

		new Classes();
		new GUI();
	}

	// Constructor
	public GUI() {

		frame = new JFrame();
		
		frame.setTitle("Rosetta Code");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 550);
		frame.getContentPane().setLayout(null);
		
		currentRelativePath = Paths.get(""); //relative path
		rootFolder = currentRelativePath.toAbsolutePath().toString(); //absolute path
		
		setTxtField();
		createButtons();
		setLables();
		setTextArea();
		setProgressBar();
		showDescription(id);

		frame.setLocationRelativeTo(null); // Place in the center of the screen
		frame.getContentPane().revalidate();
		frame.getContentPane().repaint();
		frame.setVisible(true);

		// Constructor
	}

	// Update GUI screen - show question description, number and progress bar
	private void showDescription(int id) {

		description = Classes.getStringArrObject(id);

		txtNumber.setText(String.format("%d", id + 1));
		progressBar.setValue(id + 1);
		progressBar.setStringPainted(true);

		try {

			textTitle.setText(description[0]);
			textAreaDescription.setText(description[1]);
		} catch (Exception ex) {

			String error = ex.getMessage();
			JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	// Buttons
	private void createButtons() {

		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			// Event handler
			public void actionPerformed(ActionEvent e) {
				// Close application
				System.exit(0);
			}
		});

		btnNewButton.setBounds(504, 485, 80, 25);
		frame.getContentPane().add(btnNewButton);

		JButton btnStart = new JButton("First");
		btnStart.addActionListener(new ActionListener() {
			// Event handler
			public void actionPerformed(ActionEvent arg0) {

				textAreaSolution.setText("");

				if (id != FIRST) {
					id = FIRST;
					showDescription(id);
				} else {
					JOptionPane.showMessageDialog(null, "This is first question alredy.\n", "Information message",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		btnStart.setBounds(10, 485, 80, 25);
		frame.getContentPane().add(btnStart);

		JButton button_1 = new JButton("<<< ");
		button_1.addActionListener(new ActionListener() {
			// Event handler
			public void actionPerformed(ActionEvent e) {

				textAreaSolution.setText("");

				if (id > FIRST) {

					id--;
					showDescription(id);
				} else {

					JOptionPane.showMessageDialog(null, "This is first question alredy.\n", "Information message",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		button_1.setBounds(95, 485, 80, 25);
		frame.getContentPane().add(button_1);

		JButton btnNext = new JButton(">>>");
		btnNext.addActionListener(new ActionListener() {
			// Event handler
			public void actionPerformed(ActionEvent e) {

				textAreaSolution.setText("");

				if (id < LAST) {

					++id;
					showDescription(id);
				} else {
					JOptionPane.showMessageDialog(null, "This is last question alredy.\n", "Information message",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		btnNext.setBounds(180, 485, 80, 25);
		frame.getContentPane().add(btnNext);

		JButton btnLast = new JButton("Last");
		btnLast.addActionListener(new ActionListener() {
			// Event handler
			public void actionPerformed(ActionEvent e) {

				textAreaSolution.setText("");

				if (id != LAST) {
					id = LAST;
					showDescription(id);
				} else {
					JOptionPane.showMessageDialog(null, "This is last question alredy.\n", "Information message",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnLast.setBounds(265, 485, 80, 25);
		frame.getContentPane().add(btnLast);

		JButton buttonSolution = new JButton("RUN");
		buttonSolution.addActionListener(new ActionListener() {
			// RUN button event handler
			public void actionPerformed(ActionEvent e) {
				
				//Run jar/object
				switch (id) {
				    	case 0:
				    		//Desktop.getDesktop().open(new File(jarFolder + "Two_D_sliding_block_puzzle.jar"));
				    		break;
				    	case 1:
				    		//new PuzzleGame().runObject();
				    		openFile("PuzzleGame.jar");
				    		break;
				    	case 2:
				    		//new Two_D_sliding_block_puzzle().runObject();
				    		openFile("Two_D_sliding_block_puzzle.jar");
				    		break;
				    	case 3:
				    		//
				    		break;
				    	case 4:
				    		//
				    		break;
				    	default:
				    		break;
				    }
				
				
			textAreaSolution.setText(description[2]);
			}
		});

		buttonSolution.setBounds(504, 372, 80, 54);
		frame.getContentPane().add(buttonSolution);
	}

	private void setTxtField() {

		txtNumber = new JTextField();
		txtNumber.setEditable(false);
		txtNumber.setBounds(95, 11, 46, 20);
		frame.getContentPane().add(txtNumber);
		txtNumber.setColumns(10);

		textTitle = new JTextField();
		textTitle.setEditable(false);
		textTitle.setColumns(10);
		textTitle.setBounds(192, 11, 392, 20);
		frame.getContentPane().add(textTitle);
	}

	private void setLables() {

		JLabel lblNumber = new JLabel("Question #:");
		lblNumber.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNumber.setBounds(0, 14, 81, 14);
		frame.getContentPane().add(lblNumber);

		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(154, 14, 46, 14);
		frame.getContentPane().add(lblTitle);
	}

	// Solution and description areas
	private void setTextArea() {

		// Description
		textAreaDescription = new JTextArea();
		textAreaDescription.setForeground(Color.BLACK);
		textAreaDescription.setBackground(SystemColor.inactiveCaptionBorder);
		textAreaDescription.setEditable(false);
		textAreaDescription.setLineWrap(true);
		textAreaDescription.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textAreaDescription.setBounds(10, 53, 574, 288);

		textAreaDescription.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

		JScrollPane scroollPane1 = new JScrollPane(textAreaDescription);
		scroollPane1.setBounds(10, 53, 574, 288);
		frame.getContentPane().add(scroollPane1);

		// Solution
		textAreaSolution = new JTextArea();
		textAreaSolution.setForeground(Color.BLACK);
		textAreaSolution.setBackground(SystemColor.inactiveCaptionBorder);
		textAreaSolution.setEditable(false);
		textAreaSolution.setLineWrap(true);
		textAreaSolution.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textAreaSolution.setBounds(10, 353, 485, 95);
		textAreaSolution.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

		JScrollPane scrollPane2 = new JScrollPane(textAreaSolution);
		scrollPane2.setBounds(10, 353, 485, 95);
		frame.getContentPane().add(scrollPane2);
	}

	//Opens jar file
	private static void openFile(String fileName){
		//Folder name with jar files
		String jarFolder = rootFolder + "\\jar_files\\";

		try{
			//Open the file
			Desktop.getDesktop().open(new File(jarFolder + fileName));
		} 
		catch (IOException ex) {
			//Error
			String error = ex.getMessage();
			JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
		}	
	}
	
	private void setProgressBar() {

		progressBar = new JProgressBar();
		progressBar.setBounds(10, 460, 574, 14);
		frame.getContentPane().add(progressBar);
	}

	// END
}
