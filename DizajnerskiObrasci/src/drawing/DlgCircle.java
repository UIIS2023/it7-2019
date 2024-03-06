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

import geometry.Circle;
import geometry.Point;

public class DlgCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtRadius;
	private boolean isOk;
	private JButton btnInnerColor;
	private JButton btnOutlineColor;
	private Circle circle;

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
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

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setModal(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircle() {
		setBounds(100, 100, 374, 336);
		setTitle("Add/Modify Circle:");
		setResizable(false);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.control);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblX = new JLabel("X coordinate of center:");
		lblX.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		JLabel lblY = new JLabel("Y coordinate of center:");
		lblY.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		JLabel lblRadius = new JLabel("Radius:");
		lblRadius.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtX = new JTextField();
		txtX.setBackground(SystemColor.inactiveCaption);
		txtX.setColumns(10);
		txtY = new JTextField();
		txtY.setBackground(SystemColor.inactiveCaption);
		txtY.setColumns(10);
		txtRadius = new JTextField();
		txtRadius.setBackground(SystemColor.inactiveCaption);
		txtRadius.setColumns(10);

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
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup().addGap(41)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblX).addComponent(lblY).addComponent(lblRadius))
										.addGap(29)
										.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtY, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtX, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPanel.createSequentialGroup().addGap(98).addGroup(gl_contentPanel
										.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnInnerColor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnOutlineColor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addContainerGap(157, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
				.createSequentialGroup().addGap(28)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblX).addComponent(txtX,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblY).addComponent(txtY,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblRadius).addComponent(
						txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(btnInnerColor, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(btnOutlineColor, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(42, Short.MAX_VALUE)));
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
						if (txtX.getText().trim().isEmpty() || txtY.getText().trim().isEmpty()
								|| txtRadius.getText().trim().isEmpty()) {
							isOk = false;
							JOptionPane.showMessageDialog(null, "Input is necessary for all text fields!", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else {
							try {
								if (Integer.parseInt(txtRadius.getText().toString()) <= 0
										|| Integer.parseInt(txtX.getText().toString()) < 0
										|| Integer.parseInt(txtY.getText().toString()) < 0) {
									JOptionPane.showMessageDialog(null, "Negative values are not allowed!", "ERROR",
											JOptionPane.ERROR_MESSAGE);
								} else {
									circle = new Circle(

											new Point(Integer.parseInt(txtX.getText().toString()),
													Integer.parseInt(txtY.getText().toString())),
											Integer.parseInt(txtRadius.getText().toString()), false,
											btnOutlineColor.getBackground(), btnInnerColor.getBackground());

									isOk = true;
									setVisible(false);
								}
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(null, "You need to enter numbers!", "Error",
										JOptionPane.ERROR_MESSAGE);
							}

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
