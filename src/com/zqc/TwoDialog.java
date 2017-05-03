package com.zqc;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.zqc.utils.TextUtils;
import com.zqc.utils.UnicodeUtils;

import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.JTextArea;
import javax.swing.JTextArea;

public class TwoDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextArea textArea;
	private JTextArea textArea1;

	/**
	 * Create the dialog.
	 */
	public TwoDialog(int type) {
		setBounds(100, 100, 630, 416);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton button = new JButton("\u6B63\u64CD\u4F5C");
			button.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
					String str = textArea.getText();
					String string = "";
					if (!TextUtils.isEmpty(str)) {
						switch (type) {
						case 1:
							try {
								string = URLEncoder.encode(str, "UTF-8");
							} catch (UnsupportedEncodingException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
								string = "³ö´í";
							}
							break;
						case 2:
							string = UnicodeUtils.string2Unicode(str);
							break;
						case 3:
							try {
								long a = new Long(str);
								Date date = new Date(a);
								string = date.toLocaleString();
							} catch (NumberFormatException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							break;
						default:
							break;
						}
					}
					textArea1.setText(string);
				}
			});
			button.setBounds(155, 303, 107, 32);
			contentPanel.add(button);
		}

		JButton button = new JButton("\u9006\u64CD\u4F5C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textArea.getText();
				String string = "";
				if (!TextUtils.isEmpty(str)) {
					switch (type) {
					case 1:
						try {
							string = URLDecoder.decode(str, "UTF-8");
						} catch (UnsupportedEncodingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							string = "³ö´í";
						}
						break;
					case 2:
						string = UnicodeUtils.unicode2String(str);
						break;
					case 3:
						SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						try {
							Date date = dFormat.parse(str);
							string = date.getTime()+"";
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						break;
					default:
						break;
					}
				}
				textArea1.setText(string);
			}
		});
		button.setBounds(292, 303, 107, 32);
		contentPanel.add(button);

		textArea = new JTextArea();
		textArea.setBounds(10, 10, 242, 253);
		contentPanel.add(textArea);
		textArea.setColumns(10);

		textArea1 = new JTextArea();
		textArea1.setBounds(314, 10, 283, 253);
		contentPanel.add(textArea1);

		JButton button_1 = new JButton("<>");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				String str1 = textArea.getText();
				String str2 = textArea1.getText();
				textArea.setText(str2);
				textArea1.setText(str1);
			}
		});
		button_1.setBounds(251, 120, 53, 32);
		contentPanel.add(button_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea1.setLineWrap(true);
		textArea1.setWrapStyleWord(true);
//		JScrollPane scrollPane = new JScrollPane(textArea);
//		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//		JScrollPane pane = new JScrollPane(textArea1);
//		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
}
