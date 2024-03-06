package sort;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import java.awt.Font;

public class DlgSort extends JDialog{

	private final JPanel contentPanel = new JPanel();
	protected JTextField txtX;
	protected JTextField txtY;
	protected JTextField txtWidth;
	protected JTextField txtHeight;
	protected boolean isOk;
	private JLabel lblRec;
	private JLabel lblX;
	private JLabel lblY;
	private JLabel lblWidth;
	private JLabel lblHeight;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgSort dialog = new DlgSort();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgSort() {
		setModal(true);
		setTitle("Saranovic Masa IT7-2019");
		setBounds(100, 100, 396, 296);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.controlHighlight);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblRec = new JLabel("Add a rectangle:");
			lblRec.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		}
		{
			lblX = new JLabel("X coordinate:");
			lblX.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		}
		{
			txtX = new JTextField();
			txtX.setBackground(SystemColor.inactiveCaption);
			txtX.setForeground(SystemColor.desktop);
			txtX.setColumns(10);
		}
		{
			lblY = new JLabel("Y coordinate:");
			lblY.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		}
		{
			txtY = new JTextField();
			txtY.setBackground(SystemColor.inactiveCaption);
			txtY.setForeground(SystemColor.desktop);
			txtY.setColumns(10);
		}
		{
			lblWidth = new JLabel("Width:");
			lblWidth.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		}
		{
			txtWidth = new JTextField();
			txtWidth.setBackground(SystemColor.inactiveCaption);
			txtWidth.setForeground(SystemColor.desktop);
			txtWidth.setColumns(10);
		}
		{
			lblHeight = new JLabel("Height:");
			lblHeight.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		}
		{
			txtHeight = new JTextField();
			txtHeight.setBackground(SystemColor.inactiveCaption);
			txtHeight.setForeground(SystemColor.desktop);
			txtHeight.setColumns(10);
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(123)
					.addComponent(lblRec))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(63)
					.addComponent(lblX)
					.addGap(50)
					.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(63)
					.addComponent(lblY)
					.addGap(50)
					.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(63)
					.addComponent(lblWidth)
					.addGap(88)
					.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(63)
					.addComponent(lblHeight)
					.addGap(84)
					.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(12)
					.addComponent(lblRec)
					.addGap(32)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblX))
						.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(13)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblY))
						.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblWidth))
						.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblHeight))
						.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.inactiveCaption);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if(txtHeight.getText().trim().isEmpty() || txtWidth.getText().trim().isEmpty() ||
									txtX.getText().trim().isEmpty() || txtY.getText().trim().isEmpty()) {
								isOk = false;
								setVisible(true);
								getToolkit().beep();
								JOptionPane.showMessageDialog(null, "Input is necessary for all text fields!");
								setVisible(true);
							}
							else if(Integer.parseInt(txtWidth.getText().toString())<=0 || 
									Integer.parseInt(txtHeight.getText().toString())<=0 ||
									Integer.parseInt(txtX.getText().toString())<=0 ||
									Integer.parseInt(txtY.getText().toString())<=0) {
								JOptionPane.showMessageDialog(null, "Negative values are not allowed!");
							}
							else {
								isOk=true;
								setVisible(false);
							}
							
						}
						catch(Exception ex) {
							JOptionPane.showMessageDialog(null,"You need to enter numbers!");
						}

					}
					
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
