package asModel;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TextView extends JPanel implements MyPropertyChangeListener {
	
	private Model model;
    private JTextField jtfRecLength;
    private JTextField jtfRecWidth;
    
	public TextView(String x, String y) {
		
		JLabel lblNewLabel = new JLabel("Length:");
		add(lblNewLabel);
		
		jtfRecLength = new JTextField(x);
		jtfRecLength.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRecLength(Integer.parseInt(jtfRecLength.getText()));
			}
		});
		add(jtfRecLength);
		jtfRecLength.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("   Width:");
		add(lblNewLabel_1);
		
		jtfRecWidth = new JTextField(y);
		jtfRecWidth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRecWidth(Integer.parseInt(jtfRecWidth.getText()));
			}
		});
		add(jtfRecWidth);
		jtfRecWidth.setColumns(10);

	}


    public void setModel(Model model) {
       this.model = model;
       model.addMyPropertyChangeListener(this);
    }

    public void myPropertyChange(MyPropertyChangeEvent ev){
       if (ev.propertyName.equalsIgnoreCase("length")){
           jtfRecLength.setText(""+ev.getNewValue());
       } else if (ev.propertyName.equalsIgnoreCase("width")){
           jtfRecWidth.setText(""+ev.getNewValue());
       }
    }
}
