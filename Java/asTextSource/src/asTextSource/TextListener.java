package asTextSource;

import javax.swing.JPanel;
import java.awt.TextArea;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;

public class TextListener extends JPanel implements NewTextListener{
	
	TextArea textArea = new TextArea();

	public TextListener() {
		setBackground(new Color(255, 215, 0));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollPane);
		textArea.setRows(10);
		textArea.setColumns(30);
		
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
	}
	
	public void setSource(TextSource source) {
		source.addNewTextListener(this);
	}

	@Override
	public void newTextEntered(NewTextEvent nte) {
		String newText = nte.getNewText();
		textArea.append(newText + "\n");
	}

}
