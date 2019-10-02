package textEditor.main;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

class FrameClass extends JFrame implements ActionListener{

	private JTextArea textArea;  
	private JFrame frame;
	private JScrollPane scroll;

	public FrameClass(){ 

		frameInitialization();
		// Create a menubar 
		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("File");
		JMenuItem newFile = new JMenuItem("New");
		JMenuItem open = new JMenuItem("Open");
		JMenuItem save = new JMenuItem("Save");

		newFile.addActionListener(this);
		open.addActionListener(this);
		save.addActionListener(this);

		fileMenu.add(newFile);
		fileMenu.add(open);
		fileMenu.add(save);

		JMenu editMenu = new JMenu("Edit"); 

		// Create menu items 
		JMenuItem cut = new JMenuItem("Cut"); 
		JMenuItem copy = new JMenuItem("Copy"); 
		JMenuItem paste = new JMenuItem("Paste"); 

		cut.addActionListener(this);
		copy.addActionListener(this);
		paste.addActionListener(this);

		editMenu.add(cut);
		editMenu.add(copy);
		editMenu.add(paste); 

		// Adding menu items to menu bar
		menuBar.add(fileMenu);
		menuBar.add(editMenu);

		// Defining ShortCut for MenuItems
		KeyStroke saveShortCut = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
		save.setAccelerator(saveShortCut);
		KeyStroke openShortCut = KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK);
		open.setAccelerator(openShortCut);
		KeyStroke newShortCut = KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK);
		newFile.setAccelerator(newShortCut);
		KeyStroke copyShortCut = KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK);
		copy.setAccelerator(copyShortCut);
		KeyStroke cutShortCut = KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK);
		cut.setAccelerator(cutShortCut);
		KeyStroke pasteShortCut = KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK);
		paste.setAccelerator(pasteShortCut);

		// setting menu bar in frame
		frame.setJMenuBar(menuBar); 

		// getting dimension of screen to avoid giving hardcoded dimensions to textarea and Frame
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// adding textarea in frame
		textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.add(textArea); 

		// adding scroll bar in the frame
		scroll = new JScrollPane(textArea);
		frame.add(scroll);

		// setting size of the frame	    
		frame.setSize(screenSize.width/2, screenSize.height/2);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setVisible(true); 
	}

	private void frameInitialization() {
		// Create a frame 
		frame = new JFrame("Minimalistic Text Editor"); 
		try { 
			// Set metl look and feel 
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"); 
			
			frame.setFont(new Font("Arial", Font.PLAIN, 14));
			// Set theme to ocean 
			MetalLookAndFeel.setCurrentTheme(new OceanTheme()); 
		} 
		catch (Exception e) { 
		} 
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String option = e.getActionCommand();

		if("open".equalsIgnoreCase(option)) {
			JFileChooser chooser = new JFileChooser();
			int r = chooser.showOpenDialog(null);
			if(r == JFileChooser.APPROVE_OPTION) {
				File file = new File(chooser.getSelectedFile().getAbsolutePath());
				try {
					BufferedReader reader = new BufferedReader(new FileReader(file));
					StringBuilder str = new StringBuilder();
					String line;
					//					= reader.readLine();
					while((line = reader.readLine()) != null) {
						str.append(line + "\n");
					}

					textArea.setText(str.toString());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, e1.getMessage());
				}

			}
		}
		else if("new".equalsIgnoreCase(option)) {
			textArea.setText("");
		}
		else if("save".equalsIgnoreCase(option)) {
			JFileChooser chooser = new JFileChooser();
			int r = chooser.showSaveDialog(null);
			if(r == JFileChooser.APPROVE_OPTION) {
				File file = new File(chooser.getSelectedFile().getAbsolutePath());

				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
					writer.write(textArea.getText());
					writer.flush();
					writer.close();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(frame, e1.getMessage());
				}	
			}
		}
		else if("cut".equalsIgnoreCase(option)) {
			textArea.cut();
		}
		else if("copy".equalsIgnoreCase(option)) {
			textArea.copy();
		}
		else if("paste".equalsIgnoreCase(option)) {
			textArea.paste();
		}
	}
}
