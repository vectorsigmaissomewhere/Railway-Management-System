import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;

import java.sql.SQLException;

public class ModifyList {
    public ModifyList(JFrame oldFrame, Database database){
        JFrame frame = new JFrame("Railway Management System");
        frame.setSize(400, 600);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setLocationRelativeTo(oldFrame);
        frame.getContentPane().setBackground(Color.decode("#EBFFD8"));

        JPanel panel = new JPanel(new GridLayout(8, 18, 10, 10));
        panel.setBackground(null);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JButton addTrain = JButton("Add Train");
        addTrain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    new AddTrain(oldFrame, database);
                }
                catch(SQLException e1){
                    e1.printStackTrace();
                }
            }
        });
        
        panel.add(addTrain);

        JButton editTrain = JButton("Edit Train");
        panel.add(editTrain);

        JButton addEmployee = JButton("Add Employee");
        panel.add(addEmployee);

        JButton editEmployee = JButton("Edit Employee");
        panel.add(editEmployee);

        JButton addPassenger = JButton("Add Passenger");
        panel.add(addPassenger);

        JButton addTrip = JButton("Add Trip");
        panel.add(addTrip);

        JButton editTrip = JButton("Edit Trip");
        panel.add(editTrip);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private JButton JButton(String text){
        JButton btn=new JButton(text);
        btn.setBackground(Color.decode("#4fC4B0"));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font(null, Font.BOLD, 22));
        return btn;
    }
}
