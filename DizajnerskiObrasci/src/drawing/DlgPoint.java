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
import javax.swing.border.EmptyBorder;

import geometry.Point;

public class DlgPoint extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblX;
	private JTextField txtX;
	private JTextField txtY;
	private boolean isOk;
	private Point point;
	private JButton btnColor; 

	public JLabel getLblX() {
		return lblX;
	}

	public void setLblX(JLabel lblX) {
		this.lblX = lblX;
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

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public JButton getBtnColor() {
		return btnColor;
	}

	public void setBtnColor(JButton btnColor) {
		this.btnColor = btnColor;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPoint dialog = new DlgPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPoint() {
		setTitle("Modify Point:");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 398, 256);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.control);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblX = new JLabel("X coordinate:");
			lblX.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		}
		JLabel lblY = new JLabel("Y coordinate:");
		lblY.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtX = new JTextField();
		txtX.setBackground(SystemColor.inactiveCaption);
		txtX.setColumns(10);
		txtY = new JTextField();
		txtY.setBackground(SystemColor.inactiveCaption);
		txtY.setColumns(10);
		
		btnColor = new JButton("Color");
		btnColor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color color = JColorChooser.showDialog(null, "Choose color", btnColor.getBackground());
				if (color != null)
					btnColor.setBackground(color);
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(72)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblX)
								.addComponent(lblY))
							.addGap(45)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(132)
							.addComponent(btnColor, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(114, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblX)
						.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblY)
						.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addComponent(btnColor, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(37, Short.MAX_VALUE))
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
						if (txtX.getText().trim().isEmpty() || txtY.getText().trim().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Input is necessary for all text fields!", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else {

							try {
								if (Integer.parseInt(txtX.getText().toString()) < 0
										|| Integer.parseInt(txtY.getText().toString()) < 0) {
									JOptionPane.showMessageDialog(null, "Negative values are not allowed!", "ERROR",
											JOptionPane.ERROR_MESSAGE);
								} else {

									point = new Point(Integer.parseInt(txtX.getText().toString()),
											Integer.parseInt(txtY.getText().toString()), false,
											btnColor.getBackground());
									isOk = true;
									setVisible(false);

								}
							} catch (Exception e1) {
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
