package linkedList;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.LinkedList;

@SuppressWarnings("serial")
public class Task01Frame extends JFrame{
	private JLabel label = new JLabel("Enter a number: ");
	private JTextField textField = new JTextField("", 10);
	private JTextArea textArea = new JTextArea(4, 25);
	private JScrollPane scrollPane = new JScrollPane(textArea);
	private JButton sortButton = new JButton("Sort");
	private JButton shuffleButton = new JButton("Shuffle");
	private JButton reverseButton = new JButton("Reverse");
	
	LinkedList<Integer> numbers = new LinkedList<Integer>();
	
	public Task01Frame() {
		setLayout(new FlowLayout());
		add(label);
		add(textField);
		add(scrollPane);
		add(sortButton);
		add(shuffleButton);
		add(reverseButton);
		
		textField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if (textField.getText().length() != 0) {
					numbers.add(Integer.parseInt(textField.getText()));
					textField.setText("");
					refreshTextArea();
				}
			}
		});
		
		sortButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Collections.sort(numbers);
				refreshTextArea();
			}
		});
		
		shuffleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Collections.shuffle(numbers);
				refreshTextArea();
			}		
		});
		
		reverseButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Collections.reverse(numbers);
				refreshTextArea();
			}		
		});
	}
	
	public void refreshTextArea() {
		textArea.setText(numbers.toString().substring(1, numbers.toString().length() - 1).replace(", ", " "));
	}
}
