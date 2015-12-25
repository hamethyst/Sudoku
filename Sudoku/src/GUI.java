import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame {
	private JPanel contentPanel, panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9;
	private JPanel[][] smallgrids = { {panel1, panel2, panel3}, {panel4, panel5, panel6}, {panel7, panel8, panel9} };
	private JTextField cell1, cell2, cell3, cell4, cell5, cell6, cell7, cell8, cell9;
	private JTextField[][] cells = new JTextField[9][9];
	private String[][] userinput = new String[3][3];
	private JPanel grid[][] = new JPanel[3][3];
	private int total;
	public static GUI gui;
	
	public GUI() {
		super("Sudoku");
		
		contentPanel = new JPanel();
		contentPanel.setLayout(new GridLayout(3,3));
		
		Text t = new Text();
		
		//creates new cells, adds to panel(small grid)
		for(int x = 0; x < 3; x++){
			for(int y = 0; y < 3; y++){
				setPanel();
				contentPanel.add(smallgrids[x][y]);
				for(int a = 0; a < 9; a++){
					for(int b = 0; b < 9; b++){
						cells[a][b] = new JTextField();
						cells[a][b].addActionListener(t);
					}	
					smallgrids[x][y].add(cells[y][a]);
				}
			}	
		}
		
		this.setContentPane(contentPanel);

	}
	
	public void setPanel(){
		
		for(int x = 0; x < 3; x++){
			for(int y = 0; y < 3; y++){
			smallgrids[x][y] = new JPanel();
			smallgrids[x][y].setPreferredSize(new Dimension(230,230));
			smallgrids[x][y].setBorder(BorderFactory.createLineBorder(Color.green,5));
			smallgrids[x][y].setLayout(new GridLayout(3,3));
			}
		}
	}
	
	
	private class Text implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			String input ="";
			//use input from jtextfield
			for(int x = 0; x < 9; x++){
				for(int y = 0; y < 9; y++){
					cells[x][y].setEditable(false);
				}	
			}
			
		}
				
	}
	
	
	
	public static void main(String[] args){
		gui = new GUI();
		gui.setSize(750, 700);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
		gui.setResizable(false);
		
	}
	
	


		
		
	
}
