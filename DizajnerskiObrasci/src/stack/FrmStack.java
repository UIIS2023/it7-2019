package stack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class FrmStack extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultListModel<Rectangle> dlm = new DefaultListModel<Rectangle>();
	JList listRectangle = new JList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmStack frame = new FrmStack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmStack() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Stack App - Saranovic Masa IT7-2019");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlCenter = new JPanel();
		pnlCenter.setBackground(SystemColor.controlHighlight);
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		
		JScrollPane scrlPaneRectangle = new JScrollPane();
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGap(36)
					.addComponent(scrlPaneRectangle, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(40, Short.MAX_VALUE))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrlPaneRectangle, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		listRectangle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		listRectangle.setBackground(SystemColor.inactiveCaption);
		
		scrlPaneRectangle.setViewportView(listRectangle);
		pnlCenter.setLayout(gl_pnlCenter);
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.setBackground(SystemColor.inactiveCaption);
		pnlSouth.setForeground(Color.BLACK);
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnAdd.setForeground(Color.BLACK);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgStack dlgS = new DlgStack();
				dlgS.setVisible(true);
				if(dlgS.isOk) {
					String x = dlgS.txtX.getText();
					String y = dlgS.txtY.getText();
					String height = dlgS.txtHeight.getText();
					String width = dlgS.txtWidth.getText();
					
					Rectangle rec = new Rectangle(new Point(Integer.parseInt(x), Integer.parseInt(y)),
							Integer.parseInt(width), Integer.parseInt(height));
					dlm.add(0, rec);
				}
			}
		});
		pnlSouth.add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnRemove.setForeground(Color.BLACK);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dlm.isEmpty()) {
					JOptionPane.showMessageDialog(null, "List is already empty!");
				}
				else {
					dlm.remove(0);
				}
			}
		});
		pnlSouth.add(btnRemove);
		
		listRectangle.setModel(dlm);
	}
}
