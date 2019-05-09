import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class opening extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					opening frame = new opening();
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
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
	public opening() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 459);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGetInThe = new JLabel("GET IN THE GAME");
		lblGetInThe.setForeground(Color.WHITE);
		lblGetInThe.setFont(new Font("Garamond", Font.BOLD, 35));
		lblGetInThe.setBounds(252, 0, 340, 77);
		contentPane.add(lblGetInThe);
		
		String[][] data={{"Manchester City","            1"},{"Manchester United","            2"},{"Liverpool","            3"},{"Chelsea","            4"}};
		String[] column= {"Team Name","Position"};
		
		table = new JTable(data,column);
		table.setForeground(Color.GREEN);
		table.setBackground(Color.BLUE);
		table.setEnabled(false);
		table.setBounds(15, 245, 174, 77);
		table.setRowHeight(33);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(5);
		JScrollPane hey=new JScrollPane(table);
		hey.setBounds(10, 257, 250, 151);
		Border empty = new EmptyBorder(0, 0, 0, 0);
		hey.setBorder(empty);
		contentPane.add(hey);
		
		String [][]data1={{"Bayern Munich","            1"},{"Borussia Dortmund","            2"},{"RB Leipzig","            3"},{"Borussia Monchengladbach","            4"}};
		String []column1= {"Team Name","Position"};
		
		table_1 = new JTable(data1,column1);
		table_1.setForeground(Color.GREEN);
		table_1.setBackground(Color.BLUE);
		table_1.setEnabled(false);
		table_1.setBounds(204, 245, 174, 77);
		table_1.setRowHeight(33);
		table_1.getColumnModel().getColumn(0).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(5);
		JScrollPane hey2=new JScrollPane(table_1);
		hey.setBounds(10, 257, 250, 151);
		hey2.setBorder(empty);
		hey2.setEnabled(false);
		hey2.setBounds(294, 257, 250, 151);
		contentPane.add(hey2);
		
		String [][]data2={{"Barcelona","            1"},{"Real Madrid","            2"},{"Atletico Madrid","            3"},{"Sevilla","            4"}};
		String []column2= {"Team Name","Position"};
		
		table_2 = new JTable(data2,column2);
		table_2.setBackground(Color.BLUE);
		table_2.setForeground(Color.GREEN);
		table_2.setEnabled(false);
		table_2.setRowHeight(33);
		table_2.getColumnModel().getColumn(0).setPreferredWidth(100);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(5);
		table_2.setBounds(392, 245, 174, 77);
		//panel.add(table_2);
		JScrollPane hey1=new JScrollPane(table_2);
		hey1.setBorder(empty);
		hey1.setEnabled(false);
		hey1.setBounds(575, 257, 250, 151);
		contentPane.add(hey1);
		
		JLabel lblPremierLeague = new JLabel("Premier League");
		lblPremierLeague.setForeground(Color.YELLOW);
		lblPremierLeague.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPremierLeague.setBounds(103, 221, 147, 29);
		contentPane.add(lblPremierLeague);
		
		JLabel lblNewLabel = new JLabel("Bundesliga");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(389, 220, 115, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblLaLiga = new JLabel("La Liga");
		lblLaLiga.setForeground(Color.YELLOW);
		lblLaLiga.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLaLiga.setBounds(669, 220, 84, 31);
		contentPane.add(lblLaLiga);
				
		ImageIcon icon = new ImageIcon(getClass().getResource("premier_league.jpg"));
		JLabel lblNewLabel_1 = new JLabel(icon);
		lblNewLabel_1.setBounds(10, 208, 84, 50);
		contentPane.add(lblNewLabel_1);
		
		ImageIcon icon1 = new ImageIcon(getClass().getResource("bundesliga.jpg"));
		JLabel lblNewLabel_2 = new JLabel(icon1);
		lblNewLabel_2.setBounds(295, 208, 84, 50);
		contentPane.add(lblNewLabel_2);
		
		ImageIcon icon2 = new ImageIcon(getClass().getResource("la_liga.jpg"));
		JLabel lblNewLabel_3 = new JLabel(icon2);
		lblNewLabel_3.setBounds(575, 208, 84, 50);
		contentPane.add(lblNewLabel_3);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setForeground(Color.BLACK);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(351, 124, 115, 20);
		contentPane.add(comboBox);
		
		comboBox.addItem("2017");
		comboBox.addItem("2018");
		comboBox.addItem("Both");
		comboBox.setSelectedIndex(-1);
		
		JLabel lblSelectYear = new JLabel("Select year:");
		lblSelectYear.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSelectYear.setForeground(Color.YELLOW);
		lblSelectYear.setBounds(351, 110, 85, 14);
		contentPane.add(lblSelectYear);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\MAHE\\Downloads\\workspace\\DemoMain\\src\\bg_opening.jpg"));
		label.setBounds(0, 0, 837, 420);
		contentPane.add(label);
		
		comboBox.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		    	if(e.getStateChange()==ItemEvent.SELECTED) {
		    		Object source = e.getSource();
		    		if(source instanceof JComboBox) {
				        	String data = comboBox.getSelectedItem().toString();
			        		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				        	if(data.equals("2017")) {
				        		newjf sec =new newjf();
								sec.setLocation(dim.width/2-sec.getSize().width/2, (dim.height/2-sec.getSize().height/2)+50);
				    			sec.setVisible(true);
				    			sec.setTitle("Statistics of 2017");
				        	}
				        	else if(data.equals("2018")) {
				        		newjf2 sec =new newjf2();
				        		sec.setLocation(dim.width/2-sec.getSize().width/2, (dim.height/2-sec.getSize().height/2)+50);
				    			sec.setVisible(true);
				    			sec.setTitle("Statistics of 2018");
				        	}
				        	else if(data.equals("Both")) {
				        		newjf3 sec =new newjf3();
				        		sec.setLocation(dim.width/2-sec.getSize().width/2, (dim.height/2-sec.getSize().height/2)+50);
				    			sec.setVisible(true);
				    			sec.setTitle("Statistics of 2017 and 2018");
				        	}
		    		}
		    	}
		    }
		});
	}
}