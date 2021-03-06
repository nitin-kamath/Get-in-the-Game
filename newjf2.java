import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.*;
import javax.swing.table.*;


public class newjf2 extends JFrame {
	int count1=0, count2=0, count3=0, count4=0;	
	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newjf2 frame = new newjf2();
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
					frame.setVisible(true);
					frame.setTitle("Statistics of 2018");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public newjf2() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 820, 380);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Choice choice = new Choice();
		choice.setFont(new Font("Book Antiqua", Font.PLAIN, 12));
		choice.setForeground(Color.BLACK);
		choice.setBounds(10, 27, 199, 22);
		contentPane.add(choice);
		
		choice.add("Goals");
		choice.add("Assists");
		choice.add("Appearances");
		choice.add("Yellow Cards");
		choice.add("Red Cards");
		choice.add("Clean Sheets");
		
		JButton btnShow_4 = new JButton("Show");
		btnShow_4.setBounds(600, 106, 66, 25);
		contentPane.add(btnShow_4);
		
		JLabel lblFilterBy = new JLabel("Filter by league");
		lblFilterBy.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFilterBy.setBackground(Color.RED);
		lblFilterBy.setForeground(Color.YELLOW);
		lblFilterBy.setBounds(10, 66, 100, 14);
		contentPane.add(lblFilterBy);
		
		JLabel lblFilterByTeam = new JLabel("Filter by team");
		lblFilterByTeam.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFilterByTeam.setForeground(Color.YELLOW);
		lblFilterByTeam.setBounds(190, 66, 100, 14);
		contentPane.add(lblFilterByTeam);
		
		JLabel lblFilterByPlayer = new JLabel("Filter by player");
		lblFilterByPlayer.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFilterByPlayer.setForeground(Color.YELLOW);
		lblFilterByPlayer.setBounds(370, 66, 110, 14);
		contentPane.add(lblFilterByPlayer);
		
		JLabel lblFilterByNationality = new JLabel("Filter by nationality");
		lblFilterByNationality.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFilterByNationality.setForeground(Color.YELLOW);
		lblFilterByNationality.setBounds(550, 66, 130, 14);
		contentPane.add(lblFilterByNationality);
		
		JLabel lblSelectStat = new JLabel("Select Stat:");
		lblSelectStat.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSelectStat.setForeground(Color.YELLOW);
		lblSelectStat.setBounds(10, 11, 85, 14);
		contentPane.add(lblSelectStat);
				
		JComboBox<String> comboBox_1 = new JComboBox<>();
		comboBox_1.setBounds(10, 80, 160, 20);
		contentPane.add(comboBox_1);
		
		comboBox_1.addItem("All");
		comboBox_1.addItem("Premier League");
		comboBox_1.addItem("La Liga");
		comboBox_1.addItem("Bundesliga");
		comboBox_1.setSelectedIndex(-1);
		
		JComboBox<String> comboBox_2 = new JComboBox<>();
		comboBox_2.setBounds(190, 80, 160, 20);
		contentPane.add(comboBox_2);
		
		JComboBox<String> comboBox_3 = new JComboBox<>();
		comboBox_3.setBounds(370, 80, 160, 20);
		contentPane.add(comboBox_3);
		
		JComboBox<String> comboBox_4 = new JComboBox<>();
		comboBox_4.setBounds(550, 80, 160, 20);
		contentPane.add(comboBox_4);
		JLabel label = new JLabel("");
		label.setForeground(Color.YELLOW);
		label.setFont(new Font("Tahoma",Font.BOLD,16));
		label.setBounds(246,134,69,20);
		contentPane.add(label);
		JLabel Label1 = new JLabel("");
		Label1.setForeground(Color.YELLOW);
		Label1.setFont(new Font("Tahoma",Font.BOLD,16));
		Label1.setBounds(413,132,117,22);
contentPane.add(Label1);

		DefaultTableModel model=new DefaultTableModel();
		JTable table = new JTable(model);
		table.setEnabled(false);
		table.setBounds(476, 157, 160, 121);
		JScrollPane hey=new JScrollPane(table);
		table.setForeground(Color.GREEN);
		table.setBackground(Color.BLUE);
		table.setFont(new Font("Calibri",Font.PLAIN,16));
		Border empty = new EmptyBorder(0, 0, 0, 0);
		hey.setBorder(empty);
		hey.setBounds(190, 155, 314, 138);
		contentPane.add(hey);		
		
		JButton btnResetFilters = new JButton("<html>"+"Reset"+"<br>"+"Filters"+"</html>");
		btnResetFilters.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				comboBox_1.removeAllItems();
				comboBox_1.addItem("All");
				comboBox_1.addItem("Premier League");
				comboBox_1.addItem("La Liga");
				comboBox_1.addItem("Bundesliga");
				comboBox_1.setSelectedIndex(-1);
				
				comboBox_2.removeAllItems();
				comboBox_3.removeAllItems();
				comboBox_4.removeAllItems();
				model.setRowCount(0);
				label.setText("");			
				Label1.setText("");
			}
		});
		btnResetFilters.setBounds(730, 89, 64, 42);
		contentPane.add(btnResetFilters);
		
		JButton btnGoBack = new JButton("GO BACK");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				opening hi=new opening();				
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				hi.setLocation(dim.width/2-hi.getSize().width/2, dim.height/2-hi.getSize().height/2);
				hi.setVisible(true);
			}
		});
		btnGoBack.setBounds(647, 307, 89, 23);
		contentPane.add(btnGoBack);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\MAHE\\Downloads\\workspace\\DemoMain\\src\\bg_new.jpg"));
		lblNewLabel.setBounds(0, 0, 804, 341);
		contentPane.add(lblNewLabel);
		
		comboBox_1.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		    	if(e.getStateChange()==ItemEvent.SELECTED) {
		    		Object source = e.getSource();
		    		if(source instanceof JComboBox) {
				        try {
			        		count1++;
					        // step1 load the driver class			
					        Class.forName("oracle.jdbc.driver.OracleDriver");			
					        // step2 create the connection object			
					        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM", "nitin1999");			
					        // step3 create the statement object			
					        Statement stmt = con.createStatement();			
					        // step4 execute query			
					        String data = comboBox_1.getSelectedItem().toString();
					        if(data.equals("All")) {
					        	ResultSet rs1 = stmt.executeQuery("SELECT NAME FROM TEAM");
					        	System.out.println("connected");
						        if(count1==1) {
						        	comboBox_2.addItem("All");
							        while (rs1.next())
							        {					    
							        	String data1 = rs1.getString(1);
							        	comboBox_2.addItem(data1);				        	
							        }
						        }
						        else {					        	
						        	comboBox_2.removeAllItems();
						        	comboBox_2.addItem("All");
						    	    while (rs1.next())
							        {					    
							        	String data1 = rs1.getString(1);
							        	comboBox_2.addItem(data1);				        	
							        }
						        }
						       con.close();
					        }
					        else {
						        ResultSet rs = stmt.executeQuery("SELECT NAME FROM TEAM WHERE LEAGUE_NAME=\'" + data+"\'");
						       
						        System.out.println("connected");
						        if(count1==1) {
						        	comboBox_2.addItem("All");
							        while (rs.next())
							        {					    
							        	String data1 = rs.getString(1);
							        	comboBox_2.addItem(data1);				        	
							        }
						        }
						        else {
						        	comboBox_2.removeAllItems();
						        	comboBox_2.addItem("All");
						    	    while (rs.next())
							        {					    
							        	String data1 = rs.getString(1);
							        	comboBox_2.addItem(data1);				        	
							        }
						        }
						        con.close();
					        }
					    }catch (SQLException ex) {		
					        System.out.println(ex);		
					    }catch (ClassNotFoundException ex) {		
					        System.out.println(ex);			
					    }
		    		}
		    	}
		    }
		});
		comboBox_2.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		    	if(e.getStateChange()==ItemEvent.SELECTED) {
		    		Object source = e.getSource();
		    		if(source instanceof JComboBox) {		    	
				        try {
				        	count2++;
					        // step1 load the driver class			
					        Class.forName("oracle.jdbc.driver.OracleDriver");			
					        // step2 create the connection object			
					        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM", "nitin1999");			
					        // step3 create the statement object			
					        Statement stmt = con.createStatement();			
					        // step4 execute query			
					        String data = comboBox_2.getSelectedItem().toString();
					        String data4 = comboBox_1.getSelectedItem().toString();
					        if(data.equals("All") && data4.equals("All")) {
					        	ResultSet rs1 = stmt.executeQuery("SELECT FNAME, LNAME FROM PLAYER");
					        	System.out.println("connected");
						        if(count2==1) {
						        	comboBox_3.addItem("All");
							        while (rs1.next())
							        {				                    					        
							        	String data1 = rs1.getString(1)+" "+rs1.getString(2);
							        	comboBox_3.addItem(data1);				        	
							        }
						        }
						        else {					        	
						        	comboBox_3.removeAllItems();
						        	comboBox_3.addItem("All");
						    	    while (rs1.next())
							        {			                    
							        	String data1 = rs1.getString(1)+" "+rs1.getString(2);
							        	comboBox_3.addItem(data1);				        	
							        }
						        }
						        con.close();
					        }
					        else if(data.equals("All")) {
					        	ResultSet rs1 = stmt.executeQuery("SELECT FNAME,LNAME FROM PLAYER,TEAM WHERE TEAM.NAME=PLAYER.TEAM_NAME AND LEAGUE_NAME=\'"+data4 +"\'");
					        	System.out.println("connected");
						        if(count2==1) {
						        	comboBox_3.addItem("All");
							        while (rs1.next())
							        {					    					        	
							        	String data1 = rs1.getString(1)+" "+rs1.getString(2);
							        	comboBox_3.addItem(data1);				        	
							        }
						        }
						        else {					        	
						        	comboBox_3.removeAllItems();
						        	comboBox_3.addItem("All");
						    	    while (rs1.next())
							        {					    		                    
							        	String data1 = rs1.getString(1)+" "+rs1.getString(2);
							        	comboBox_3.addItem(data1);				        	
							        }
						        }
						        con.close();
					        }		        
					        else {
						        ResultSet rs = stmt.executeQuery("SELECT FNAME, LNAME FROM PLAYER WHERE TEAM_NAME=\'" + data+"\'");				       
						        System.out.println("connected");
						        if(count2==1) {
						        	comboBox_3.addItem("All");
							        while (rs.next())
							        {					    					        	
							        	String data1 = rs.getString(1)+" "+rs.getString(2);
							        	comboBox_3.addItem(data1);				        	
							        }
						        }
						        else {
						        	comboBox_3.removeAllItems();
						        	comboBox_3.addItem("All");
						    	    while (rs.next())
							        {					    				    		    
							        	String data1 = rs.getString(1)+" "+rs.getString(2);
							        	comboBox_3.addItem(data1);				        	
							        }
						        }
						        con.close();
					        }
					    }catch (SQLException ex) {		
					        System.out.println(ex);		
					    }catch (ClassNotFoundException ex) {		
					        System.out.println(ex);			
					    }
		    		}
		    	}
		    }
		});
		comboBox_3.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		    	if(e.getStateChange()==ItemEvent.SELECTED) {
		    		Object source = e.getSource();
		    		if(source instanceof JComboBox) {
				        try {
			        		count3++;
					        // step1 load the driver class			
					        Class.forName("oracle.jdbc.driver.OracleDriver");			
					        // step2 create the connection object			
					        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM", "nitin1999");			
					        // step3 create the statement object			
					        Statement stmt = con.createStatement();			
					        // step4 execute query			
					        String data3 = comboBox_3.getSelectedItem().toString();
					        String data2 = comboBox_2.getSelectedItem().toString();
					        String data1 = comboBox_1.getSelectedItem().toString();
					        if(data1.equals("All") && data2.equals("All") && data3.equals("All")) {
					        	ResultSet rs1 = stmt.executeQuery("SELECT NAME FROM NATIONALITY");
					        	System.out.println("connected");
						        if(count3==1) {
						        	comboBox_4.addItem("All");
							        while (rs1.next())
							        {					    
							        	String data4 = rs1.getString(1);
							        	comboBox_4.addItem(data4);				        	
							        }
						        }
						        else {					        	
						        	comboBox_4.removeAllItems();
						        	comboBox_4.addItem("All");
						    	    while (rs1.next())
							        {					    
							        	String data5 = rs1.getString(1);
							        	comboBox_4.addItem(data5);				        	
							        }
						        }					        					      					        
						        con.close();
					        }
					        else if(data1.equals("All") && data3.equals("All")) {
					        	ResultSet rs1 = stmt.executeQuery("SELECT DISTINCT(NATION) FROM TEAM,PLAYER WHERE TEAM.NAME=PLAYER.TEAM_NAME AND TEAM_NAME=\'"+data2+"\'");
					        	System.out.println("connected");
						        if(count3==1) {
						        	comboBox_4.addItem("All");
							        while (rs1.next())
							        {		
							        	
							        	String data4 = rs1.getString(1);
							        	comboBox_4.addItem(data4);				        	
							        }
						        }
						        else {					        	
						        	comboBox_4.removeAllItems();
						        	comboBox_4.addItem("All");
						    	    while (rs1.next())
							        {					    
							        	String data5 = rs1.getString(1);
							        	comboBox_4.addItem(data5);				        	
							        }
						        }
						        con.close();
					        }
					        else if(data2.equals("All") && data3.equals("All")) {
					        	ResultSet rs2 = stmt.executeQuery("SELECT DISTINCT(NATION) FROM TEAM,PLAYER WHERE TEAM.NAME=PLAYER.TEAM_NAME AND LEAGUE_NAME=\'"+data1+"\'");
					        	System.out.println("connected");
						        if(count3==1) {
						        	comboBox_4.addItem("All");
							        while (rs2.next())
							        {					    
							        	String data4 = rs2.getString(1);
							        	comboBox_4.addItem(data4);				        	
							        }
						        }
						        else {					        	
						        	comboBox_4.removeAllItems();
						        	comboBox_4.addItem("All");
						    	    while (rs2.next())
							        {	
						    	    	System.out.println("hi");
							        	String data5 = rs2.getString(1);
							        	comboBox_4.addItem(data5);				        	
							        }
						        }						        						        						        
						        con.close();
					        }
					        else if(data3.equals("All")) {
					        	ResultSet rs2 = stmt.executeQuery("SELECT DISTINCT(NATION) FROM PLAYER WHERE TEAM_NAME=\'"+data2+"\'");
					        	System.out.println("connected");
						        if(count3==1) {
						        	comboBox_4.addItem("All");
							        while (rs2.next())
							        {					    
							        	String data4 = rs2.getString(1);
							        	comboBox_4.addItem(data4);				        	
							        }
						        }
						        else {					        	
						        	comboBox_4.removeAllItems();
						        	comboBox_4.addItem("All");
						    	    while (rs2.next())
							        {	
						    	    	System.out.println("hi");
							        	String data5 = rs2.getString(1);
							        	comboBox_4.addItem(data5);				        	
							        }
						        }        
						       con.close();
					        }			        
					        else {
					        	String arr[]=data3.split(" ",2);
						        ResultSet rs = stmt.executeQuery("SELECT NATION FROM PLAYER WHERE FNAME=\'" +arr[0]+"\'AND LNAME=\'"+arr[1]+"\'");					       
						        System.out.println("connected");
						        if(count3==1) {					        	
							        while (rs.next())
							        {					    
							        	String data6 = rs.getString(1);
							        	comboBox_4.addItem(data6);				        	
							        }
						        }
						        else {
						        	comboBox_4.removeAllItems();					    	   
						    	    while (rs.next())
							        {					    
							        	String data7 = rs.getString(1);
							        	comboBox_4.addItem(data7);				        	
							        }
						        }
						        con.close();
					        }
					    }catch (SQLException ex) {		
					        System.out.println(ex);		
					    }catch (ClassNotFoundException ex) {		
					        System.out.println(ex);			
					    }
		    		}
		    	}
		    }
		});
btnShow_4.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {		    	
		        try {
	        		count4++;
	        		int n=0;
			        // step1 load the driver class			
			        Class.forName("oracle.jdbc.driver.OracleDriver");			
			        // step2 create the connection object			
			        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM", "nitin1999");			
			        // step3 create the statement object			
			        Statement stmt = con.createStatement();			
			        // step4 execute query			
			        String data3 = comboBox_3.getSelectedItem().toString();
			        String data2 = comboBox_2.getSelectedItem().toString();
			        String data1 = comboBox_1.getSelectedItem().toString();
			        String data4 = comboBox_4.getSelectedItem().toString();
			        String data = choice.getItem(choice.getSelectedIndex());
			        if (count4==1) {
			        model.addColumn("");
			        model.addColumn("");
			        model.addColumn("");
                                label.setText("Name");
			        Label1.setText(data);
					//model.addColumn(data);
				table.getColumnModel().getColumn(0).setPreferredWidth(10);	
			        table.getColumnModel().getColumn(1).setPreferredWidth(150);
			        }
			        else {
			        	label.setText("");
			     Label1.setText("");
			        	label.setText("Name");
			        	Label1.setText(data);
			        	
			        	model.setRowCount(0);
			        	//TableColumnModel tcol=table.getColumnModel();
			        	//int index=tcol.getColumnIndexAtX(e.getX());
			        	//tcol.removeColumn(tcol.getColumn(1));
			        	
			        	//table.removeColumn(table.getColumnModel().getColumn(1));
			        	//table.revalidate();
			        	//table.getColumnModel().getColumn(1).setHeaderValue(data);
			    
			        	//model.addColumn(data);
			        	
			        	
			        }
			        
					if(data.equals("Yellow Cards")) {
			        	String data5 = new String("yellow_cards");
			        	data = data5;
			        }
			        else if(data.equals("Red Cards")) {
			        	String data5 = new String("red_cards");
			        	data = data5;
			        }
			        else if(data.equals("Clean Sheets")) {
			        	String data5 = new String("clean_sheets");
			        	data = data5;
			        }
			        if(data1.equals("All") && data2.equals("All") && data3.equals("All") && data4.equals("All")) {
			        	ResultSet rs1 = stmt.executeQuery("SELECT "+ data +",fname,lname FROM statistics,player,team where player.id=statistics.player_id and team.name=player.team_name and year=2018 order by "+data+" desc");
			        	System.out.println("connected");				        	
				        if(count4==1) {		        	
					        while (rs1.next())
					        	
					        {	
					        	n++;
					        	model.addRow(new Object[] {n,rs1.getString(2)+" "+rs1.getString(3),"           "+rs1.getInt(1)});
					        	//label1.setText("<html>"+label1.getText()+"<br>"+ rs1.getString(2)+" "+rs1.getString(3)+" "+ rs1.getInt(1) +"</br>");				        	
					        }
					        
				        }
				        else {		
				        	
				    	    while (rs1.next())
					        {							    
				    	    	n++;
				    	    	model.addRow(new Object[] {n,rs1.getString(2)+" "+rs1.getString(3),"           "+rs1.getInt(1)});							        					        
					        }
				    	    
				        }					        					      					        
				        con.close();
			        }
			        else if(data1.equals("All") && data2.equals("All") && data3.equals("All")) {
			        	ResultSet rs1 = stmt.executeQuery("SELECT "+ data +",fname,lname FROM statistics,player where player.id=statistics.player_id and player.nation=\'"+data4+"\' and year=2018 order by " +data+" desc");
			        	System.out.println("connected");
				        if(count4==1) {
				        	
					        while (rs1.next())
					        {		
					        	n++;
					        	model.addRow(new Object[] {n,rs1.getString(2)+" "+rs1.getString(3),"           "+rs1.getInt(1)});					        	
					        }
					        
				        }
				        else {					        	
				       
				    	    while (rs1.next())
					        {					    		
				    	    	n++;
				    	    	model.addRow(new Object[] {n,rs1.getString(2)+" "+rs1.getString(3),"           "+rs1.getInt(1)});			
					        }
				    	    
				        }					        					      					        
				        con.close();
			        }
			        else if (data1.equals("All") && data3.equals("All") && data4.equals("All")) {
			        	ResultSet rs2 = stmt.executeQuery("SELECT "+ data +",fname,lname FROM statistics,player,team where player.id=statistics.player_id and player.team_name=team.name and team.name=\'"+data2+"\' and year=2018 order by "+ data +" desc");
			        	System.out.println("connected");
				        if(count4==1) {					        	
					        while (rs2.next())
					        {
					        	n++;
					        	model.addRow(new Object[] {n,rs2.getString(2)+" "+rs2.getString(3),"           "+rs2.getInt(1)});
					        }
					       
				        }
				        else {					        	
				   
				    	    while (rs2.next())
					        {	
				    	    	n++;
				    	    	model.addRow(new Object[] {n,rs2.getString(2)+" "+rs2.getString(3),"           "+rs2.getInt(1)});	
					        }
				    	   
				        }						        						        						        
				        con.close();			        	
			        }
			        else if(data2.equals("All")&& data3.equals("All")&& data4.equals("All")) {
			        	ResultSet rs1 = stmt.executeQuery("SELECT "+ data +",fname,lname FROM statistics,player,team where player.id=statistics.player_id and player.team_name=team.name and team.league_name=\'"+data1+"\' and year=2018 order by "+data+" desc");
			        	System.out.println("connected");
				        if(count4==1) {					        	
					        while (rs1.next())
					        {		
					        	n++;
					        	model.addRow(new Object[] {n,rs1.getString(2)+" "+rs1.getString(3),"           "+rs1.getInt(1)});
					        }
					        
				        }
				        else {					        	
				        	
				    	    while (rs1.next())
					        {					    
					        	n++;
				    	    	model.addRow(new Object[] {n,rs1.getString(2)+" "+rs1.getString(3),"           "+rs1.getInt(1)});			
					        }
				    	    
				        }					        					      					        
				        con.close();				        	
			        }
			        else if(data1.equals("All") && data3.equals("All")) {
			        	ResultSet rs1 = stmt.executeQuery("SELECT "+ data +",fname,lname FROM statistics,player where player.id=statistics.player_id and player.team_name=\'"+data2+"\'and player.nation=\'"+data4+"\'  and year=2018 order by "+data+" desc");
			        	System.out.println("connected");
				        if(count4==1) {					        	
					        while (rs1.next())
					        {		
					        	n++;
					        	model.addRow(new Object[] {n,rs1.getString(2)+" "+rs1.getString(3),"           "+rs1.getInt(1)});					        	
					        }
					        
				        }
				        else {					        	
				        	
				    	    while (rs1.next())
					        {					    
				    	    	n++;
				    	    	model.addRow(new Object[] {n,rs1.getString(2)+" "+rs1.getString(3),"           "+rs1.getInt(1)});					        	
					        }
				    	    
				        }
				        con.close();
			        }				        
			        else if(data2.equals("All") && data3.equals("All")) {
			        	ResultSet rs2 = stmt.executeQuery("SELECT "+ data +",fname,lname FROM statistics,player,team where player.id=statistics.player_id and player.team_name=team.name and team.league_name=\'"+data1+"\'and player.nation=\'"+data4+"\' and year=2018 order by "+data+" desc");
			        	System.out.println("connected");
				        if(count4==1) {					        	
					        while (rs2.next())
					        {
					        	n++;
					        	model.addRow(new Object[] {n,rs2.getString(2)+" "+rs2.getString(3),"           "+rs2.getInt(1)});						        					        	
					        }
					        
				        }
				        else {					        	
				        	
				    	    while (rs2.next())
					        {	
				    	    	n++;
				    	    	model.addRow(new Object[] {n,rs2.getString(2)+" "+rs2.getString(3),"           "+rs2.getInt(1)});
					        }
				    	   
				        }						        						        						        
				        con.close();
			        }					       
			        else if(data3.equals("All")&& data4.equals("All")) {
			        	ResultSet rs2 = stmt.executeQuery("SELECT "+ data +",fname,lname FROM statistics,player,team where player.id=statistics.player_id and player.team_name=team.name and team.league_name=\'"+data1+"\'and team.name=\'"+data2+"\' and year=2018 order by "+data+" desc");
			        	System.out.println("connected");
				        if(count4==1) {					        	
					        while (rs2.next())
					        {
					        	n++;
					        	model.addRow(new Object[] {n,rs2.getString(2)+" "+rs2.getString(3),"           "+rs2.getInt(1)});
					        }
					        
				        }
				        else {					        	
				        	
				    	    while (rs2.next())
					        {	
				    	    	n++;
				    	    	model.addRow(new Object[] {n,rs2.getString(2)+" "+rs2.getString(3),"           "+rs2.getInt(1)});
					        }
				    	    
				        }						        						        						        
				        con.close();				        	
			        }
			        else if(data3.equals("All")) {
			        	ResultSet rs2 = stmt.executeQuery("SELECT "+ data +",fname,lname FROM statistics,player,team where player.id=statistics.player_id and player.team_name=team.name and team.league_name=\'"+data1+"\'and team.name=\'"+data2+"\'and player.nation=\'"+data4 +"\'and year=2018 order by "+data+" desc");
			        	System.out.println("connected");
				        if(count4==1) {					        	
					        while (rs2.next())
					        {
					        	n++;
					        	model.addRow(new Object[] {n,rs2.getString(2)+" "+rs2.getString(3),"           "+rs2.getInt(1)});
					        }					        
				        }
				        else {					        	
				        	
				    	    while (rs2.next())
					        {	n++;
				    	    	model.addRow(new Object[] {n,rs2.getString(2)+" "+rs2.getString(3),"           "+rs2.getInt(1)});
					        }				    	    
				        }						        						        						        
				        con.close();	
			        	
			        }
			        else {
			        	String arr[]=data3.split(" ",2);
			        	ResultSet rs2 = stmt.executeQuery("SELECT "+ data +",fname,lname FROM statistics,player,team where player.id=statistics.player_id and player.team_name=team.name and FNAME=\'"+arr[0]+"\'and LNAME=\'"+arr[1]+"\' and year=2018 order by "+data+" desc");
			        	System.out.println("connected");
				        if(count4==1) {				        	
					        while (rs2.next())
					        {
					        	n++;
					        	model.addRow(new Object[] {n,rs2.getString(2)+" "+rs2.getString(3),"              "+rs2.getInt(1)});
					        }
					       
				        }
				        else {	
				        	
				        
				    	    while (rs2.next())
					        {	
				    	    	n++;
				    	    	model.addRow(new Object[] {n,rs2.getString(2)+" "+rs2.getString(3),"              "+rs2.getInt(1)});
					        }
				    	  
				        }						        						        						        
				        con.close();
			        }
			        /*if (count4==2) {
			        	
			        TableColumnModel tcol=table.getColumnModel();
		        	//int index=tcol.getColumnIndexAtX(e.getX());
		        	tcol.removeColumn(tcol.getColumn(2));
			        }
			        if (count4==3) {
			        	
				        TableColumnModel tcol=table.getColumnModel();
			        	//int index=tcol.getColumnIndexAtX(e.getX());
			        	tcol.removeColumn(tcol.getColumn(1));
			        	
				        }*/
			        
			    }catch (SQLException ex) {		
			        System.out.println(ex);		
			    }catch (ClassNotFoundException ex) {		
			        System.out.println(ex);			
			    }
		    }
		});
	}
}
