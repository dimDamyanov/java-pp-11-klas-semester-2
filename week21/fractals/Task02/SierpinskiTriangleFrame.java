package fractals;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SierpinskiTriangleFrame extends JFrame {
	static int r = 0, gr = 0, b = 255;
	int order = 0;

	private JButton jtfButtonIncrease = new JButton("+");
	private JButton jtfButtonDecrease = new JButton("-");

	private SierpinskiTrianglePanel trianglePanel = new SierpinskiTrianglePanel(); // To display the pattern

	public SierpinskiTriangleFrame() {
		// Panel to hold label, text field, and a button
		JPanel panel = new JPanel();
		panel.add(jtfButtonIncrease);
		panel.add(jtfButtonDecrease);
		// Add a Sierpinski triangle panel to the frame
		add(trianglePanel);
		add(panel, BorderLayout.SOUTH);
		jtfButtonIncrease.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				order++;
				trianglePanel.setOrder(order);
			}
		});
		jtfButtonDecrease.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if (order != 0) {
					order--;
					trianglePanel.setOrder(order);
				}
			}
		});
	}
}
