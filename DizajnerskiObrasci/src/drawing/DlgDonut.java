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

import geometry.Donut;
import geometry.Point;

public class DlgDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtRadius;
	private JTextField txtInnerRadius;
	private boolean isOk;
	private Donut donut;
	public JButton btnInnerColor;
	public JButton btnOutlineColor;

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

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}

	public JTextField getTxtInnerRadius() {
		return txtInnerRadius;
	}

	public void setTxtInnerRadius(JTextField txtInnerRadius) {
		this.txtInnerRadius = txtInnerRadius;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public Donut getDonut() {
		return donut;
	}

	public void setDonut(Donut donut) {
		this.donut = donut;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonut() {
		setBounds(100, 100, 419, 337);
		setTitle("Add/Modify Donut:");
		setResizable(false);
		setModal(true);
		setBackground(Color.WHITE);
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
		JLabel lblInnerRadius = new JLabel("Inner radius:");
		lblInnerRadius.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtX = new JTextField();
		txtX.setBackground(SystemColor.inactiveCaption);
		txtX.setColumns(10);
		txtY = new JTextField();
		txtY.setBackground(SystemColor.inactiveCaption);
		txtY.setColumns(10);
		txtRadius = new JTextField();
		txtRadius.setBackground(SystemColor.inactiveCaption);
		txtRadius.setColumns(10);
		txtInnerRadius = new JTextField();
		txtInnerRadius.setBackground(SystemColor.inactiveCaption);
		txtInnerRadius.setColumns(10);

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
				.addGroup(gl_contentPanel.createSequentialGroup().addGroup(gl_contentPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(43)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addComponent(lblX)
										.addComponent(lblY).addComponent(lblRadius).addComponent(lblInnerRadius))
								.addGap(30)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtInnerRadius, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup().addGap(113)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnInnerColor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnOutlineColor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addContainerGap(123, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
				.createSequentialGroup().addGap(31)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblX).addComponent(txtX,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblY).addComponent(txtY,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblRadius).addComponent(
						txtRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblInnerRadius)
						.addComponent(txtInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(btnInnerColor, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(btnOutlineColor, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE).addContainerGap()));
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
								|| txtRadius.getText().trim().isEmpty() || txtInnerRadius.getText().trim().isEmpty()) {
							isOk = false;
							JOptionPane.showMessageDialog(null, "Input is necessary for all text fields!", "Error",
									JOptionPane.ERROR_MESSAGE);

						} else {
							try {
								if (Integer.parseInt(txtInnerRadius.getText().toString()) <= 0
										|| Integer.parseInt(txtRadius.getText().toString()) <= 0
										|| Integer.parseInt(txtX.getText().toString()) < 0
										|| Integer.parseInt(txtY.getText().toString()) < 0)
									JOptionPane.showMessageDialog(null, "Negative values are not allowed!", "Error",
											JOptionPane.ERROR_MESSAGE);
								else {
									if (Integer.parseInt(txtInnerRadius.getText().toString()) < Integer
											.parseInt(txtRadius.getText().toString())) {
										donut = new Donut(
												new Point(Integer.parseInt(txtX.getText().toString()),
														Integer.parseInt(txtY.getText().toString())),
												Integer.parseInt(txtRadius.getText().toString()),
												Integer.parseInt(txtInnerRadius.getText().toString()), false,
												btnOutlineColor.getBackground(), btnInnerColor.getBackground());

										isOk = true;
										setVisible(false);
									} else {
										JOptionPane.showMessageDialog(null,
												"Please insert inner radius less than outher radius!", "Error",
												JOptionPane.ERROR_MESSAGE);
									}

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
