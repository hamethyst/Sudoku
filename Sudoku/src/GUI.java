import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame {
	private JPanel contentPanel, panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9;
	private JPanel[] panels = { panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9};
	private JTextField[][] txtField = new JTextField[9][9];

	private int total;
	public static GUI gui;
	
	public GUI() {
		super("Sudoku");
		
		contentPanel = new JPanel();
		contentPanel.setLayout(new GridLayout(3,3));
		
		Text t = new Text();
		
		//sets panel, adds to contentpane
		int j = 0;
		while(j < panels.length){
			panels[j] = new JPanel();
			panels[j].setPreferredSize(new Dimension(230,230));
			panels[j].setBorder(BorderFactory.createLineBorder(Color.green,5));
			panels[j].setLayout(new GridLayout(3,3));
			contentPanel.add(panels[j]);
			j++;
		}
		
		int k = 0;
		for(int a = 0; a < 9; a++){
			for(int b = 0; b < 9; b++){
				txtField[a][b] = new JTextField();
				txtField[a][b].addActionListener(t);
				panels[k].add(txtField[a][b]);
			}	
			k++;
		}
		
		this.presetNums();
		this.setContentPane(contentPanel);

	}
	
	public void presetNums(){
		int num = 0;
		for(int x = 0; x < 9; x++){
				if(x == 1 || x == 4 || x ==7){
					for(int y = 0; y < 2; y++){
					txtField[x][(int)(Math.random()*8)].setText(Integer.toString((int)(Math.random()*8))); 
					//txtField[x][num].setEditable(false);
					}
				}else{
					for(int y = 0; y < 3; y++){
					txtField[x][(int)(Math.random()*8)].setText(Integer.toString((int)(Math.random()*8)));
					//txtField[x][num].setEditable(false);
					}
				}
			}
		}
	
	
		
	private class Text implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			String input = "";
			//for(int x = 0; x < 9; x++){
			  //  for(int y = 0; y < 9; y++){
			        //input = txtField[6][7].getText();  
			        //txtField[6][7].setEditable(false);

			    //        }   
			      //  }
			System.out.println(input);
			
		}
				
	
	}
	
	
	public static void main(String[] args){
		gui = new GUI();
		gui.setSize(750, 700);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
		gui.setResizable(true);
		
	}
	
	


		
		
	
}
