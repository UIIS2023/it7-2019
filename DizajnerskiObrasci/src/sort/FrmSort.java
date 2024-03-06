package sort;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;

public class FrmSort extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultListModel<Rectangle> dlm = new DefaultListModel<Rectangle>();
	JList listSort = new JList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSort frame = new FrmSort();
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
	public FrmSort() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Sort App - Saranovic Masa IT7-2019");
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pnlCenter = new JPanel();
		pnlCenter.setBackground(SystemColor.controlHighlight);
		contentPane.add(pnlCenter, BorderLayout.CENTER);

		JScrollPane scrlPaneSort = new JScrollPane();
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_pnlCenter.createSequentialGroup().addContainerGap(44, Short.MAX_VALUE)
						.addComponent(scrlPaneSort, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
						.addGap(38)));
		gl_pnlCenter.setVerticalGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_pnlCenter.createSequentialGroup().addContainerGap(26, Short.MAX_VALUE)
						.addComponent(scrlPaneSort, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
						.addGap(20)));
		listSort.setBackground(SystemColor.inactiveCaption);

		scrlPaneSort.setViewportView(listSort);
		pnlCenter.setLayout(gl_pnlCenter);

		JPanel pnlSouth = new JPanel();
		pnlSouth.setBackground(SystemColor.inactiveCaption);
		contentPane.add(pnlSouth, BorderLayout.SOUTH);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(255, 255, 225));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgSort dlgS = new DlgSort();
				dlgS.setVisible(true);

				if (dlgS.isOk) {
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

		JButton btnSort = new JButton("Sort");
		btnSort.setBackground(new Color(255, 255, 225));
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Rectangle[] row = new Rectangle[dlm.getSize()];
				for (int i = 0; i < row.length; i++) {
					row[i] = dlm.getElementAt(i);
				}
				Arrays.sort(row);
				dlm.clear();
				for (int i = 0; i < row.length; i++) {
					dlm.addElement(row[i]);
				}

			}
		});
		pnlSouth.add(btnSort);

		listSort.setModel(dlm);
	}
}
