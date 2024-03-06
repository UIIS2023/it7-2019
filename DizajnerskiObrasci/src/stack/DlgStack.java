package stack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class DlgStack extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	protected JTextField txtX;
	protected JTextField txtY;
	protected JTextField txtWidth;
	protected JTextField txtHeight;
	protected boolean isOk;
	private JLabel lblAdd;
	private JLabel lblX;
	private JLabel lblY;
	private JLabel lblWidth;
	private JLabel lblHeight;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgStack dialog = new DlgStack();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgStack() {
		setModal(true);
		setBounds(100, 100, 375, 283);
		setTitle("Saranovic Masa IT7-2019");
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.controlHighlight);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblAdd = new JLabel("Add a rectangle:");
			lblAdd.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		}
		{
			lblX = new JLabel("X coordinate:");
			lblX.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			lblX.setBackground(SystemColor.desktop);
			lblX.setHorizontalAlignment(SwingConstants.CENTER);
		}
		{
			txtX = new JTextField();
			txtX.setForeground(new Color(0, 0, 0));
			txtX.setBackground(SystemColor.inactiveCaption);
			txtX.setColumns(10);
		}
		{
			lblY = new JLabel("Y coordinate:");
			lblY.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
			lblY.setBackground(SystemColor.inactiveCaption);
		}
		{
			txtY = new JTextField();
			txtY.setBackground(SystemColor.inactiveCaption);
			txtY.setColumns(10);
		}
		{
			lblWidth = new JLabel("Width:");
			lblWidth.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		}
		
		{
			txtWidth = new JTextField();
			txtWidth.setBackground(SystemColor.inactiveCaption);
			txtWidth.setColumns(10);
		}
		{
			lblHeight = new JLabel("Height:");
			lblHeight.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		}
		{
			txtHeight = new JTextField();
			txtHeight.setBackground(SystemColor.inactiveCaption);
			txtHeight.setColumns(10);
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(113)
					.addComponent(lblAdd))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(63)
					.addComponent(lblX)
					.addGap(51)
					.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(63)
					.addComponent(lblY)
					.addGap(51)
					.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(63)
					.addComponent(lblWidth)
					.addGap(89)
					.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(63)
					.addComponent(lblHeight)
					.addGap(85)
					.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(11)
					.addComponent(lblAdd)
					.addGap(30)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblX))
						.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblY))
						.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblWidth))
						.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
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
								isOk=false;
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
