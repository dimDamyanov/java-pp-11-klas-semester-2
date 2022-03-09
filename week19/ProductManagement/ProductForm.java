import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class ProductForm extends JFrame{
	private JLabel label1, label2;
	private JTextField textField1, textField2;
	private JButton button1, button2, button3, button4;
	private JTextArea textArea1;
	private ListOfProducts listOfProducts;
	
	
	public ProductForm() {
		super("Product Management");
		setLayout(new FlowLayout());
		
		setResizable(false);
		listOfProducts = new ListOfProducts();
		label1 = new JLabel("Description:");
		label1.setToolTipText("Description of the product");
		add(label1);
		textField1 = new JTextField(10);
		add(textField1);
		label2 = new JLabel("Price:");
		label2.setToolTipText("Price of the product");
		add(label2);
		textField2 = new JTextField(10);
		add(textField2);
		
		button1 = new JButton("Add to list");
		add(button1);
		
		button2 = new JButton("Sort Products");
		add(button2);
		
		button3 = new JButton("Show Products");
		add(button3);
		
		button4 = new JButton("Average Price");
		add(button4);
		
		textArea1 = new JTextArea(10, 15);
		textArea1.setLineWrap(true);
		textArea1.setWrapStyleWord(true);
		add(textArea1);
		
		Button1Handler handler1 = new Button1Handler();
		Button2Handler handler2 = new Button2Handler();
		Button3Handler handler3 = new Button3Handler();
		Button4Handler handler4 = new Button4Handler();
		
		button1.addActionListener(handler1);
		button2.addActionListener(handler2);
		button3.addActionListener(handler3);
		button4.addActionListener(handler4);
	}
	
	private class Button1Handler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			listOfProducts.add(new Product(textField1.getText(), Double.parseDouble(textField2.getText())));
		}
	}
	
	private class Button2Handler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			listOfProducts.sortByPrice();
		}
	}
	
	private class Button3Handler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			textArea1.setText(listOfProducts.toString());
		}
	}
	
	private class Button4Handler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			textArea1.setText(String.format("%.2f", listOfProducts.averagePrice()));
		}
	}
}
