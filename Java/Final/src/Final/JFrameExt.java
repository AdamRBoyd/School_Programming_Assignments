package Final;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.BeanInfo;
import java.beans.Beans;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.beans.PropertyEditor;
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
	private JComboBox[] jcboPropValues = new JComboBox[10];
	private JLabel[] jlbPropNames = new JLabel[10];
	private PropertyEditor[] pe = new PropertyEditor[10];
	private JPanel targetBeanObject = null;
	private Class<?> classObject = null;
	private PropertyDescriptor[] pd = new PropertyDescriptor[10];
	JPanel panelPropValues;
	JPanel panelPropNames;

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

		String[] list = { "", "Final.Rect", "Final.Circ", "Final.Ticker" };

		JComboBox<?> jcboClassName = new JComboBox<Object>(list);
		jcboClassName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String className = (String) jcboClassName.getSelectedItem();

				if (className.equalsIgnoreCase("")) {
					className = "Final.Blank";
					panelPropValues.revalidate();
					panelPropValues.repaint();
				}

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

				BeanInfo bi = null;
				try {
					classObject = Class.forName(className);
					bi = Introspector.getBeanInfo(classObject, JPanel.class);
				} catch (Exception e) {
					e.printStackTrace();
				}
				pd = bi.getPropertyDescriptors();

				panelPropValues.removeAll();
				panelPropValues.validate();

				// clear old names
				for (int i = 0; i < 10; i++) {
					jlbPropNames[i].setText("");
				}

				for (int i = 0; i < pd.length; i++) {

					jlbPropNames[i].setText("  " + pd[i].getName());

					Class customEditorClass = pd[i].getPropertyEditorClass();

					PropertyEditor customEditor = null;

					if (customEditorClass != null) {
						try {
							customEditor = (PropertyEditor) customEditorClass.newInstance();
							pe[i] = customEditor;
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}

					// Add Value Fields, either text or combo
					String[] tags = pe[i].getTags();

					// Text
					if (tags == null) {
						jtfPropValues[i] = new JTextField();

						int loc = i;
						jtfPropValues[i].addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String propValue = jtfPropValues[loc].getText();

								try {
									pe[loc].setAsText(propValue);
								} catch (Exception ex) {
									ex.printStackTrace();
									String pValue = pe[loc].getAsText();
									jtfPropValues[loc].setText(pValue);
									return;
								}

								String propTypeName = pd[loc].getPropertyType().getName();

								Object[] params = new Object[1];

								if (propTypeName.equals("int")) {
									params[0] = new Integer(Integer.parseInt(propValue));
								} else if (propTypeName.equals("double")) {
									params[0] = new Double(Double.parseDouble(propValue));
								} else if (propTypeName.equals("boolean")) {
									params[0] = new Boolean(propValue);
								} else if (propTypeName.equals("java.lang.String")) {
									params[0] = propValue;
								}

								Method mset = pd[loc].getWriteMethod();

								try {
									mset.invoke(targetBeanObject, params);
								} catch (Exception ex) {
									ex.printStackTrace();
								}
							}
						});

						panelPropValues.add(jtfPropValues[i]);
						panelPropValues.validate();
					}
					// Combo
					else {
						jcboPropValues[i] = new JComboBox(tags);

						int loc = i;
						jcboPropValues[i].addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								String propValue = (String) jcboPropValues[loc].getSelectedItem();

								try {
									pe[loc].setAsText(propValue);
								} catch (Exception ex) {
									ex.printStackTrace();
									String pValue = pe[loc].getAsText();
									System.out.println(pValue);
									jcboPropValues[loc].setSelectedItem(pValue);
									return;
								}

								String propTypeName = pd[loc].getPropertyType().getName();

								Object[] params = new Object[1];

								if (propTypeName.equals("int")) {
									params[0] = new Integer(Integer.parseInt(propValue));
								} else if (propTypeName.equals("double")) {
									params[0] = new Double(Double.parseDouble(propValue));
								} else if (propTypeName.equals("boolean")) {
									params[0] = new Boolean(propValue);
								} else if (propTypeName.equals("java.lang.String")) {
									params[0] = propValue;
								}

								Method mset = pd[loc].getWriteMethod();

								try {
									mset.invoke(targetBeanObject, params);
								} catch (Exception ex) {
									ex.printStackTrace();
								}
							}
						});
						panelPropValues.add(jcboPropValues[i]);
						panelPropValues.validate();
					}

					Method mget = pd[i].getReadMethod();
					Object robj = null;

					try {
						robj = mget.invoke(targetBeanObject);
					} catch (Exception e) {
						e.printStackTrace();
					}

					String sobj = robj.toString();

					// fix True/False when returning true/false
					sobj = sobj.substring(0, 1).toUpperCase() + sobj.substring(1);

					try {
						pe[i].setAsText(sobj);
					} catch (Exception ex) {
						ex.printStackTrace();
					}

					if (tags == null) {
						jtfPropValues[i].setText(sobj);
					} else {
						jcboPropValues[i].setSelectedItem(sobj);
					}
				}
			}
		});
		panelTop.add(jcboClassName);

		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(Color.PINK);
		panelRight.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new GridLayout(1, 0, 0, 0));

		panelPropNames = new JPanel();
		panelPropNames.setBackground(new Color(64, 224, 208));
		panelCenter.add(panelPropNames);
		panelPropNames.setLayout(new GridLayout(10, 1, 0, 0));

		panelPropValues = new JPanel();
		panelPropValues.setBackground(new Color(0, 100, 0));
		panelCenter.add(panelPropValues);
		panelPropValues.setLayout(new GridLayout(10, 1, 0, 0));

		for (int i = 0; i < jlbPropNames.length; i++) {
			jlbPropNames[i] = new JLabel("");
			panelPropNames.add(jlbPropNames[i]);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}
