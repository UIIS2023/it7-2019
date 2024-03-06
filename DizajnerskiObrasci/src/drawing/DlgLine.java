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

import geometry.Line;
import geometry.Point;

public class DlgLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtXStartP;
	private JTextField txtYStartP;
	private JTextField txtXEndP;
	private JTextField txtYEndP;
	private Line line;
	private boolean isOk;
	private JButton btnColor;
	private Color color = Color.BLACK;
	

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public JTextField getTxtXStartP() {
		return txtXStartP;
	}

	public void setTxtXStartP(JTextField txtXStartP) {
		this.txtXStartP = txtXStartP;
	}

	public JTextField getTxtYStartP() {
		return txtYStartP;
	}

	public void setTxtYStartP(JTextField txtYStartP) {
		this.txtYStartP = txtYStartP;
	}

	public JTextField getTxtXEndP() {
		return txtXEndP;
	}

	public void setTxtXEndP(JTextField txtXEndP) {
		this.txtXEndP = txtXEndP;
	}

	public JTextField getTxtYEndP() {
		return txtYEndP;
	}

	public void setTxtYEndP(JTextField txtYEndP) {
		this.txtYEndP = txtYEndP;
	}

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
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
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLine() {
		setBounds(100, 100, 388, 321);
		setTitle("Modify Line:");
		setResizable(false);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblXStartP = new JLabel("X coordinate of start point:");
		lblXStartP.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		JLabel lblYStartP = new JLabel("Y coordinate of start point:");
		lblYStartP.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		JLabel lblXEndP = new JLabel("X coordinate of end point:");
		lblXEndP.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		JLabel lblYEndP = new JLabel("Y coordinate of end point:");
		lblYEndP.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtXStartP = new JTextField();
		txtXStartP.setBackground(SystemColor.inactiveCaption);
		txtXStartP.setColumns(10);
		txtYStartP = new JTextField();
		txtYStartP.setBackground(SystemColor.inactiveCaption);
		txtYStartP.setColumns(10);
		txtXEndP = new JTextField();
		txtXEndP.setBackground(SystemColor.inactiveCaption);
		txtXEndP.setColumns(10);
		txtYEndP = new JTextField();
		txtYEndP.setBackground(SystemColor.inactiveCaption);
		txtYEndP.setColumns(10);
		
		btnColor = new JButton("Color");
		btnColor.setBackground(SystemColor.info);
		btnColor.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color color = JColorChooser.showDialog(null, "Choose color",
						btnColor.getBackground());
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
							.addGap(30)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblXStartP)
									.addGap(18)
									.addComponent(txtXStartP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblYStartP)
										.addComponent(lblXEndP)
										.addComponent(lblYEndP))
									.addGap(18)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtYEndP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtXEndP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtYStartP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(110)
							.addComponent(btnColor, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(87, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXStartP)
						.addComponent(txtXStartP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYStartP)
						.addComponent(txtYStartP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXEndP)
						.addComponent(txtXEndP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYEndP)
						.addComponent(txtYEndP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addComponent(btnColor, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
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
						if (txtXStartP.getText().trim().isEmpty() || txtYStartP.getText().trim().isEmpty()
								|| txtXEndP.getText().trim().isEmpty() || txtYEndP.getText().trim().isEmpty()) {
							isOk = false;
							JOptionPane.showMessageDialog(null, "Input is necessary for all text fields!", "Error", JOptionPane.ERROR_MESSAGE);
						} else {
							try {
								if (Integer.parseInt(txtXStartP.getText().toString()) < 0
										|| Integer.parseInt(txtYStartP.getText().toString()) < 0
										|| Integer.parseInt(txtXEndP.getText().toString()) < 0
										|| Integer.parseInt(txtYEndP.getText().toString()) < 0) {
									JOptionPane.showMessageDialog(null, "Negative values are not allowed!", "Error",
											JOptionPane.ERROR_MESSAGE);

								} else {
									line = new Line(
											new Point(Integer.parseInt(txtXStartP.getText().toString()),
													Integer.parseInt(txtYStartP.getText().toString())),
											new Point(Integer.parseInt(txtXEndP.getText().toString()),
													Integer.parseInt(txtYEndP.getText().toString())),
											false, btnColor.getBackground());

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
