package com.zqc;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.zqc.utils.MD5;
import com.zqc.utils.TextUtils;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;	
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextArea;
import javax.swing.Box;

public class OneDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextArea textArea;
	private JTextArea textArea1;

	/**
	 * Create the dialog.
	 */
	public OneDialog(int type) {
		setBounds(100, 100, 679, 422);
		contentPanel.setBounds(0, 0, 663, 335);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		getContentPane().setLayout(null);
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			textArea = new JTextArea();
			textArea.setBounds(10, 10, 257, 311);
			contentPanel.add(textArea);
			textArea.setColumns(10);
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);
		}
		{
			textArea1 = new JTextArea();
			textArea1.setBounds(347, 10, 306, 308);
			contentPanel.add(textArea1);
			textArea1.setLineWrap(true);
			textArea1.setWrapStyleWord(true);
		}
		{
			JButton button = new JButton("<>");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String str1 = textArea.getText();
					String str2 = textArea1.getText();
					textArea.setText(str2);
					textArea1.setText(str1);
				}
			});
			button.setBounds(274, 138, 63, 41);
			contentPanel.add(button);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(130, 341, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("确认");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String str = textArea.getText();
						if (!TextUtils.isEmpty(str)) {
							switch (type) {
							case 1:
								textArea1.setText(TextUtils.replaceBlank(str));
								break;
							case 2:
								textArea1.setText("长度为：" + str.length());
								break;
							case 3:
								String prettyJsonStr2="";
								try {
									Gson gson3 = new GsonBuilder().setPrettyPrinting().create();
									JsonParser jp = new JsonParser();
									JsonElement je = jp.parse(str);
									prettyJsonStr2 = gson3.toJson(je);
								} catch (JsonSyntaxException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								if (TextUtils.isEmpty(prettyJsonStr2)) {
									textArea1.setText("json格式化失败，请检测json是否正确");
								} else {
									textArea1.setText(prettyJsonStr2);									
								}
								break;
							case 4:
								str = MD5.getStringMd5Upper(str);
								textArea1.setText(str);
								break;
							case 5:

								break;
							case 6:
								
								break;
							default:
								break;
							}
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("取消");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
//		JScrollPane scrollPane = new JScrollPane(textArea);
//		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//		JScrollPane pane = new JScrollPane(textArea1);
//		pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}

}
