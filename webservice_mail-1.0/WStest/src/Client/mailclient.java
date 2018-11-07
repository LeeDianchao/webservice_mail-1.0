package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

import mail.MailSend;
import mail.MailSendService;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class mailclient {

	private JFrame frame;
	private static MailSend mail;
	private static MailSendService service;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		service=new MailSendService();
		mail=service.getMailSend();//getPort()
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mailclient window = new mailclient();
					window.frame.setTitle("Mail");
					window.frame.setLocationRelativeTo(null);
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
	public mailclient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 407, 392);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("邮件地址(多个地址用\",\"分隔)");
		
		JLabel label_1 = new JLabel("邮件内容");
		
		JTextArea Atext = new JTextArea();
		Atext.setLineWrap(true);
		Atext.setWrapStyleWord(true);
		
	    
		JTextArea Rtext = new JTextArea();
		Rtext.setLineWrap(true);
		Rtext.setWrapStyleWord(true);
		
		JButton btnNewButton = new JButton("发送");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String A=Atext.getText();
				System.out.println(A);
				String R=Rtext.getText();
				System.out.println(R);
				if(A.isEmpty())
				{
					System.out.println("邮箱地址为空");
					JOptionPane.showMessageDialog(null, "邮箱地址为空", "失败", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					String []url=null;
				    url = A.split(",");
				    
				    if(url.length>1)
				    {
				    	/*List<String> urls=null;
				    	for(int i=0;i<url.length;i++)
				    	{
				    		urls.add(url[i]);
				    	}
				    	mail.sendEmailBatch(urls, R);*/
				    	mail.sendEmails(A,R);
				    }
				    else
				    {
				    	mail.sendEmail(url[0], R);
				    }
				}
				
			}
		});
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setUnitIncrement(1);
		scrollBar.setBlockIncrement(10);
		scrollBar.setVisible(false);
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setUnitIncrement(1);
		scrollBar_1.setBlockIncrement(10);
		scrollBar_1.setVisible(false);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(label_1)
								.addComponent(label)
								.addComponent(Atext, GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
								.addComponent(Rtext, 0, 0, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollBar_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(85)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollBar, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
						.addComponent(Atext, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(Rtext, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
						.addComponent(scrollBar_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
