package com.zqc;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Color;

public class CharHelpTool {

	private JFrame frame;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnUrl;
	private JButton btnUnicode;
	private JButton button;
	private JButton button_1;
	private JButton btnurl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CharHelpTool window = new CharHelpTool();
					window.frame.setTitle("×Ö·û¼¯¹¤¾ß");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CharHelpTool() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 502, 333);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 3, 0, 0));
		JButton btnNewButton = new JButton("\u53BB\u7A7A\u683C");
		btnNewButton.setBackground(new Color(102, 153, 0));
		frame.getContentPane().add(btnNewButton);

		btnNewButton_1 = new JButton("\u957F\u5EA6\u7EDF\u8BA1");
		btnNewButton_1.setBackground(new Color(153, 153, 0));
		frame.getContentPane().add(btnNewButton_1);

		btnNewButton_2 = new JButton("\u683C\u5F0F\u5316json");
		btnNewButton_2.setBackground(new Color(153, 153, 51));
		frame.getContentPane().add(btnNewButton_2);

		btnNewButton_3 = new JButton("MD5\u52A0\u5BC6");
		btnNewButton_3.setBackground(new Color(204, 153, 0));
		frame.getContentPane().add(btnNewButton_3);

		btnUrl = new JButton("URL\u52A0\u5BC6\u89E3\u5BC6");
		btnUrl.setBackground(new Color(102, 153, 0));
		frame.getContentPane().add(btnUrl);

		btnUnicode = new JButton("Unicode\u8F6C\u4E2D\u6587");
		btnUnicode.setBackground(new Color(102, 153, 0));
		frame.getContentPane().add(btnUnicode);

		button = new JButton("\u65F6\u95F4\u8F6C\u6362");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TwoDialog dialog = new TwoDialog(3);
				dialog.show();
			}
		});
		frame.getContentPane().add(button);
		
		button_1 = new JButton("\u5B57\u7B26\u4E32\u662F\u5426\u76F8\u7B49");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		frame.getContentPane().add(button_1);
		
		btnurl = new JButton("\u4E91\u63A7URL\u89E3\u5BC6");
		btnurl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TwoDialog dialog = new TwoDialog(4);
				dialog.show();
			}
		});
		frame.getContentPane().add(btnurl);
		btnUnicode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TwoDialog dialog = new TwoDialog(2);
				dialog.show();
			}
		});
		btnUrl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TwoDialog dialog = new TwoDialog(1);
				dialog.show();
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OneDialog dialog = new OneDialog(4);
				dialog.show();
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OneDialog dialog = new OneDialog(3);
				dialog.show();
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OneDialog dialog = new OneDialog(2);
				dialog.show();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OneDialog dialog = new OneDialog(1);
				dialog.show(true);
			}
		});
	}

}
