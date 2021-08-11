package Midterm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.BeanInfo;
import java.beans.Beans;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JTextField;

public class JFrameExt extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField[] jtfPropValues = new JTextField[10];
	private JLabel[] jlbPropNames = new JLabel[10];
	private JPanel targetBeanObject = null;
	private Class<?> classObject = null;
	private PropertyDescriptor[] pd = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameExt frame = new JFrameExt();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrameExt() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panelLeft);

		JPanel panelRight = new JPanel();
		contentPane.add(panelRight);
		panelRight.setLayout(new BorderLayout(0, 0));

		JPanel panelTop = new JPanel();
		panelTop.setBackground(new Color(128, 0, 0));
		panelRight.add(panelTop, BorderLayout.NORTH);
		panelTop.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		String[] list = { "", "Midterm.Rect", "Midterm.Circ", "Midterm.Ticker" };

		JComboBox<?> jcboClassName = new JComboBox<Object>(list);
		jcboClassName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String className = (String) jcboClassName.getSelectedItem();

				// keep from crashing when selecting blank option
				if (className.equalsIgnoreCase(""))
					className = "Midterm.Blank";

				try {
					targetBeanObject = (JPanel) Beans.instantiate(null, className);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (!(targetBeanObject instanceof JPanel)) {
					System.out.println("Opps!! Not a JPanel");
					return;
				}
				contentPane.remove(0);
				contentPane.add((JPanel) targetBeanObject, 0);
				contentPane.validate();

				// Populate Labels
				BeanInfo bi = null;
				try {
					classObject = Class.forName(className);
					bi = Introspector.getBeanInfo(classObject, JPanel.class);
				} catch (Exception e) {
					e.printStackTrace();
				}
				pd = bi.getPropertyDescriptors();

				String propName;

				for (int i = 0; i < pd.length; i++) {
					// Get property name from corresponding PropertyDescriptor array element.
					// Set property name in the corresponding JLabel array element.
					propName = pd[i].getName();

					// Set propName as the text for the corresponding JLable.
					jlbPropNames[i].setText("  " + propName);

					Method mget = pd[i].getReadMethod();
					Object robj = null;

					try {
						robj = mget.invoke(targetBeanObject);
					} catch (Exception e) {
						e.printStackTrace();
					}

					// convert the received object contents to a String
					String sobj = robj.toString();

					// Set the String sobj as the text in the corresponding text field.
					jtfPropValues[i].setText(sobj);
				}
				
				//Clean up old fields
				for(int i = pd.length; i < 10; i++) {
					jlbPropNames[i].setText("");
					jtfPropValues[i].setText("");
				}
			}
		});
		panelTop.add(jcboClassName);

		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(Color.PINK);
		panelRight.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panelPropNames = new JPanel();
		panelPropNames.setBackground(new Color(64, 224, 208));
		panelCenter.add(panelPropNames);
		panelPropNames.setLayout(new GridLayout(10, 1, 0, 0));

		JPanel panelPropValues = new JPanel();
		panelPropValues.setBackground(new Color(0, 100, 0));
		panelCenter.add(panelPropValues);
		panelPropValues.setLayout(new GridLayout(10, 1, 0, 0));

		for (int i = 0; i < jlbPropNames.length; i++) {
			jlbPropNames[i] = new JLabel("");
			panelPropNames.add(jlbPropNames[i]);
		}
		for (int i = 0; i < jtfPropValues.length; i++) {
			jtfPropValues[i] = new JTextField(10);
			jtfPropValues[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i;
					String propValue = "";

					// Determine the name, value and index of the property that changed.
					for (i = 0; i < jtfPropValues.length; i++) {
						propValue = jtfPropValues[i].getText();
						if (e.getSource() == jtfPropValues[i]) {
							break;
						}
					}

					//Throwing exceptions when typing in empty fields
					if(i >= pd.length) {
						System.out.println("Don't Type There...");
						return;
					}
					
					Class<?> propType = pd[i].getPropertyType();

					// Get the property type as a String
					String propTypeName = propType.getName();

					// Create Object array for storing parameters
					Object[] params = new Object[1];

					// Depending upon property name, create correct parameter object.
					if (propTypeName.equals("int")) {
						params[0] = new Integer(Integer.parseInt(propValue));
					} else if (propTypeName.equals("double")) {
						params[0] = new Double(Double.parseDouble(propValue));
					} else if (propTypeName.equals("boolean")) {
						params[0] = new Boolean(propValue);
					} else if (propTypeName.equals("java.lang.String")) {
						params[0] = propValue;
					}

					// Get the set method object.
					Method mset = pd[i].getWriteMethod();

					// Invoke set method and pass it target bean and parameters.
					try {
						mset.invoke(targetBeanObject, params);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
			panelPropValues.add(jtfPropValues[i]);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}
