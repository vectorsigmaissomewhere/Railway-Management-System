package Trains;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import RailwayManagementSystem.Database;
import RailwayManagementSystem.GUI;

public class EditTrain {
	
	public EditTrain(JFrame parent, Database database) throws SQLException {
		
		JFrame frame = new JFrame("Edit Train");
		frame.setSize(750, 400);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setLocationRelativeTo(parent);
		frame.getContentPane().setBackground(Color.decode("#EBFFD8"));
		
		JPanel panel = new JPanel(new GridLayout(4, 2, 20, 20));
		panel.setBackground(null);
		panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 30, 50));
		
		panel.add(GUI.JLabel("ID:"));
		
		JComboBox<String> id = GUI.JComboBox(TrainsDatabase.getTrainsIDs(database));
		panel.add(id);
		
		panel.add(GUI.JLabel("Capacity:"));
		
		JTextField capacity = GUI.JTextField();
		panel.add(capacity);
		
		panel.add(GUI.JLabel("Description:"));
		
		JTextField description = GUI.JTextField();
		panel.add(description);
		
		JButton submit = GUI.JButton("Submit");
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Train t;
				try {
					t = TrainsDatabase.getTrain(id.getSelectedItem().toString(), database);
					t.setCapacity(Integer.parseInt(capacity.getText()));
					t.setDescription(description.getText());
					TrainsDatabase.EditTrain(t, database);
					JOptionPane.showMessageDialog(frame, "Train updated successfully");
					frame.dispose();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frame, "Operation Failed");
					frame.dispose();
				}
			}
		});
		panel.add(submit);
		
		JButton delete = GUI.JButton("Delete");
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					TrainsDatabase.DeleteTrain(id.getSelectedItem().toString(), database);
					JOptionPane.showMessageDialog(frame, "Train deleted successfully");
					frame.dispose();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frame, "Operation Failed");
					frame.dispose();
				}
			}
		});
		panel.add(delete);
		
		id.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Train t = TrainsDatabase.getTrain(id.getSelectedItem().toString(),
											database);
					capacity.setText(String.valueOf(t.getCapacity()));
					description.setText(t.getDescription());
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frame, e.toString());
					frame.dispose();
				}
			}
		});
		
		if (id.getSelectedItem()!=null) {
			try {
				Train t = TrainsDatabase.getTrain(id.getSelectedItem().toString(),
										database);
				capacity.setText(String.valueOf(t.getCapacity()));
				description.setText(t.getDescription());
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(frame, e1.toString());
				frame.dispose();
			}
		}
		
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
		
	}

}
