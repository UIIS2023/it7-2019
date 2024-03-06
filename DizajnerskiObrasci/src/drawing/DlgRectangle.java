package drawing;

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
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;

public class DlgRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtWidth;
	private JTextField txtHeight;
	public boolean isOk;
	public Rectangle rect;
	private JButton btnInnerColor;
	private JButton btnOutlineColor;
	
	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public Rectangle getRect() {
		return rect;
	}

	public void setRect(Rectangle rect) {
		this.rect = rect;
	}

	public JButton getBtnInnerColor() {
		return btnInnerColor;
	}

	public void setBtnInnerColor(JButton btnInnerColor) {
		this.btnInnerColor = btnInnerColor;
	}

	public JButton getBtnOutlineColor() {
		return btnOutlineColor;
	}

	public void setBtnOutlineColor(JButton btnOutlineColor) {
		this.btnOutlineColor = btnOutlineColor;
	}

	public JTextField getTxtX() {
		return txtX;
	}

	public void setTxtX(JTextField txtX) {
		this.txtX = txtX;
	}

	public JTextField getTxtY() {
		return txtY;
	}

	public void setTxtY(JTextField txtY) {
		this.txtY = txtY;
	}

	public JTextField getTxtWidth() {
		return txtWidth;
	}

	public void setTxtWidth(JTextField txtWidth) {
		this.txtWidth = txtWidth;
	}

	public JTextField getTxtHeight() {
		return txtHeight;
	}

	public void setTxtHeight(JTextField txtHeight) {
		this.txtHeight = txtHeight;
	}

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangle dialog = new DlgRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangle() {
		
		setTitle("Add/Modify Rectangle:");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 330, 359);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.control);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblX = new JLabel("X coordinate:");
		lblX.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		
		JLabel lblY = new JLabel("Y coordinate:");
		lblY.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		
		JLabel lblWidth = new JLabel("Width:");
		lblWidth.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		
		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		
		txtX = new JTextField();
		txtX.setBackground(SystemColor.inactiveCaption);
		txtX.setColumns(10);
		
		txtY = new JTextField();
		txtY.setBackground(SystemColor.inactiveCaption);
		txtY.setColumns(10);
		
		txtWidth = new JTextField();
		txtWidth.setBackground(SystemColor.inactiveCaption);
		txtWidth.setColumns(10);
		
		txtHeight = new JTextField();
		txtHeight.setBackground(SystemColor.inactiveCaption);
		txtHeight.setColumns(10);
		
		btnInnerColor = new JButton("Inner Color");
		btnInnerColor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnInnerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color innerColor = JColorChooser.showDialog(null, "Choose inner color", btnInnerColor.getBackground());
				if (innerColor != null)
					btnInnerColor.setBackground(innerColor);
			}
		});
		
		btnOutlineColor = new JButton("Outline Color");
		btnOutlineColor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnOutlineColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color outlineColor = JColorChooser.showDialog(null, "Choose outline color",
						btnOutlineColor.getBackground());
				if (outlineColor != null)
					btnOutlineColor.setBackground(outlineColor);

			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(42)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblY)
									.addComponent(lblX)
									.addComponent(lblWidth, Alignment.LEADING))
								.addComponent(lblHeight))
							.addGap(33)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(91)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnOutlineColor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnInnerColor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))))
					.addContainerGap(79, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblX)
						.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblY)
						.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWidth)
						.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHeight)
						.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(btnInnerColor, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnOutlineColor, GroupLayout.PREFERRED_SIZE, 35, Short.MAX_VALUE)
					.addContainerGap())
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
							if (txtX.getText().trim().isEmpty() || txtY.getText().trim().isEmpty()
									|| txtHeight.getText().trim().isEmpty() || txtWidth.getText().trim().isEmpty()) {
								isOk=false;
								JOptionPane.showMessageDialog(null, "Input is necessary for all text fields!", "Error",
										JOptionPane.ERROR_MESSAGE);
							} else {
								if (Integer.parseInt(txtWidth.getText().toString()) <= 0
										|| Integer.parseInt(txtHeight.getText().toString()) <= 0
										|| Integer.parseInt(txtX.getText().toString()) < 0
										|| Integer.parseInt(txtY.getText().toString()) < 0) {
									JOptionPane.showMessageDialog(null, "Negative values are not allowed!", "Error",
											JOptionPane.ERROR_MESSAGE);

								} else {
									rect = new Rectangle(
											new Point(Integer.parseInt(getTxtX().getText().toString()),
													Integer.parseInt(getTxtY().getText().toString())),
											Integer.parseInt(getTxtHeight().getText().toString()),
											Integer.parseInt(getTxtWidth().getText().toString()), false,
											btnOutlineColor.getBackground(), btnInnerColor.getBackground());

									isOk=true;
									setVisible(false);
								}
							}
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "You need to enter numbers!", "Error",
									JOptionPane.ERROR_MESSAGE);
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
