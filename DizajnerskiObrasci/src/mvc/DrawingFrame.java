package mvc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;

public class DrawingFrame extends JFrame {
	
	private DrawingView view = new DrawingView();
	private DrawingController controller;
	
	private JPanel contentPane = new JPanel(); 
	
	private ButtonGroup btnGroup = new ButtonGroup();
	
	private JToggleButton tglbtnSelect = new JToggleButton("");
	
	private JToggleButton tglbtnPoint = new JToggleButton("");
	private JToggleButton tglbtnLine = new JToggleButton("");
	private JToggleButton tglbtnRectangle = new JToggleButton("");
	private JToggleButton tglbtnCircle = new JToggleButton("");
	private JToggleButton tglbtnDonut = new JToggleButton("");
	private JToggleButton tglbtnHex = new JToggleButton("");
	
	private final JButton btnModify = new JButton("");
	private final JButton btnDelete = new JButton("");
	
	private final JButton btnUndo = new JButton("");
	private final JButton btnRedo = new JButton("");

	private final JButton btnToBack = new JButton("To Back");
	private final JButton btnToFront = new JButton("To Front");	
	
	private final JButton btnBringToFront = new JButton("Bring To Front");
	private final JButton btnBringToBack = new JButton("Bring To Back");
	private final JToggleButton tglbtnInnerColor = new JToggleButton("");
	private final JToggleButton tglbtnNOuterColor = new JToggleButton("");
	private final JTextArea textArea = new JTextArea();
	private final JScrollPane scrollPane = new JScrollPane(textArea);
	private JButton btnNext;
	private final JLabel lblNewLabel_1 = new JLabel("Komande za zapis i crte\u017E:");

	public DrawingFrame() {
		
	
		
		view.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Obavestiti Controller da je kliknuto
				controller.mouseClicked(e);
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 900, 700);
		setTitle("Drawing App - Saranovic Masa IT7-2019");
		setResizable(true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(SystemColor.inactiveCaption);
		contentPane.add(pnlNorth, BorderLayout.NORTH);
		
		getContentPane().add(view, BorderLayout.CENTER);
		
		GroupLayout gl_view = new GroupLayout(view);
		
		gl_view.setHorizontalGroup(gl_view.createParallelGroup(Alignment.LEADING).addGap(0, 587, Short.MAX_VALUE));
		gl_view.setVerticalGroup(gl_view.createParallelGroup(Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
		
		view.setLayout(gl_view);
		pnlNorth.add(btnUndo);
		btnUndo.setIcon(new ImageIcon(DrawingFrame.class.getResource("/res/undo1.png")));
		btnUndo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnUndo.setEnabled(false);
		
		btnGroup.add(btnUndo);
		
		
				btnUndo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					controller.undo();
					}
				});
		pnlNorth.add(btnRedo);
		btnRedo.setIcon(new ImageIcon(DrawingFrame.class.getResource("/res/redo1.png")));
		
		btnRedo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnRedo.setEnabled(false);
		btnRedo.setForeground(new Color(0, 0, 0));
		btnGroup.add(btnRedo);
		
				btnRedo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					controller.redo();
					}
				});
		tglbtnPoint.setIcon(new ImageIcon(DrawingFrame.class.getResource("/res/dot1.png")));
		
				pnlNorth.add(tglbtnPoint);
				
						btnGroup.add(tglbtnPoint);
		tglbtnLine.setIcon(new ImageIcon(DrawingFrame.class.getResource("/res/line1.png")));
		pnlNorth.add(tglbtnLine);
		btnGroup.add(tglbtnLine);
		tglbtnRectangle.setIcon(new ImageIcon(DrawingFrame.class.getResource("/res/rect1.png")));
		pnlNorth.add(tglbtnRectangle);
		tglbtnCircle.setIcon(new ImageIcon(DrawingFrame.class.getResource("/res/circle1.png")));
		pnlNorth.add(tglbtnCircle);
		tglbtnDonut.setIcon(new ImageIcon(DrawingFrame.class.getResource("/res/donut1.jpg")));
		pnlNorth.add(tglbtnDonut);
		tglbtnHex.setIcon(new ImageIcon(DrawingFrame.class.getResource("/res/hex1.png")));
		pnlNorth.add(tglbtnHex);
		btnGroup.add(tglbtnRectangle);
		btnGroup.add(tglbtnCircle);
		btnGroup.add(tglbtnDonut);
		btnGroup.add(tglbtnHex);

		JPanel pnlSouth = new JPanel();
		pnlSouth.setBackground(SystemColor.inactiveCaption);
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		tglbtnSelect.setIcon(new ImageIcon(DrawingFrame.class.getResource("/res/select1.png")));

		pnlSouth.add(tglbtnSelect);
		btnDelete.setIcon(new ImageIcon(DrawingFrame.class.getResource("/res/delete1.png")));
		
		btnDelete.setEnabled(false);
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.delete();
			}
		});
		
		pnlSouth.add(btnDelete);
		btnGroup.add(btnDelete);
		btnModify.setIcon(new ImageIcon(DrawingFrame.class.getResource("/res/modify1.png")));
		
		btnModify.setEnabled(false);

		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				controller.modify();

			}
		});
		pnlSouth.add(btnModify);
		btnGroup.add(btnModify);
		tglbtnInnerColor.setIcon(new ImageIcon(DrawingFrame.class.getResource("/res/inner1.png")));

		pnlSouth.add(tglbtnInnerColor);
		btnGroup.add(tglbtnInnerColor);
		tglbtnNOuterColor.setIcon(new ImageIcon(DrawingFrame.class.getResource("/res/border1.png")));


		pnlSouth.add(tglbtnNOuterColor);
		btnGroup.add(tglbtnNOuterColor);
		tglbtnInnerColor.setEnabled(true);
		tglbtnInnerColor.setEnabled(true);

		//ne treba ovde repaint vec u logici
		
		JPanel pnlEast = new JPanel();
		

		tglbtnInnerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			controller.activeInnerColor();
			getTglbtnInnerColor().setSelected(false);
			}
		});
		GridBagConstraints gbc_btnInnerColor = new GridBagConstraints();
		gbc_btnInnerColor.insets = new Insets(0, 0, 5, 5);
		gbc_btnInnerColor.gridx = 1;
		gbc_btnInnerColor.gridy = 8;
		pnlSouth.add(tglbtnInnerColor, gbc_btnInnerColor);
		
		tglbtnNOuterColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.activeOuterColor();
				getTglbtnNOuterColor().setSelected(false);

				}
			});
			GridBagConstraints gbc_btnOuterColor = new GridBagConstraints();
			gbc_btnOuterColor.insets = new Insets(0, 0, 5, 5);
			gbc_btnOuterColor.gridx = 1;
			gbc_btnOuterColor.gridy = 8;
			pnlSouth.add(tglbtnNOuterColor, gbc_btnOuterColor);
		
		
		pnlEast.setBackground(new Color(95, 158, 160));
		pnlEast.setForeground(SystemColor.inactiveCaption);
		
		contentPane.add(pnlEast, BorderLayout.EAST);
		
		GridBagLayout gbl_pnlEast = new GridBagLayout();
		gbl_pnlEast.columnWidths = new int[]{246, 0};
		gbl_pnlEast.rowHeights = new int[]{150, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_pnlEast.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_pnlEast.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlEast.setLayout(gbl_pnlEast);
		
		textArea.setTabSize(40);
		textArea.setColumns(30);
		textArea.setRows(8);
		textArea.setSize(60, 50);
		textArea.setEditable(false);

		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.anchor = GridBagConstraints.NORTHWEST;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		pnlEast.add(scrollPane, gbc_scrollPane);
				
				GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
				gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
				gbc_lblNewLabel_1.gridx = 0;
				gbc_lblNewLabel_1.gridy = 1;
				lblNewLabel_1.setForeground(new Color(240, 248, 255));
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
				pnlEast.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
				JButton btnSaveCommands = new JButton("Save Commands");
				btnSaveCommands.setFont(new Font("Tahoma", Font.PLAIN, 13));
				btnSaveCommands.setEnabled(true);
				GridBagConstraints gbc_btnSaveCommands = new GridBagConstraints();
				gbc_btnSaveCommands.insets = new Insets(0, 0, 5, 0);
				gbc_btnSaveCommands.gridx = 0;
				gbc_btnSaveCommands.gridy = 2;
				pnlEast.add(btnSaveCommands, gbc_btnSaveCommands);
				
				btnSaveCommands.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller.saveCommands();	
						}
					});
		
				JButton btnLoadCommands = new JButton("Load Commands");
				btnLoadCommands.setFont(new Font("Tahoma", Font.PLAIN, 13));
				btnLoadCommands.setEnabled(true);
				GridBagConstraints gbc_btnLoadCommands = new GridBagConstraints();
				gbc_btnLoadCommands.insets = new Insets(0, 0, 5, 0);
				gbc_btnLoadCommands.gridx = 0;
				gbc_btnLoadCommands.gridy = 3;
				pnlEast.add(btnLoadCommands, gbc_btnLoadCommands);
				
				btnLoadCommands.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller.loadCommands();	
						}
					});
		
		btnNext = new JButton("Next");
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		btnNext.setEnabled(false);
		gbc_btnNext.insets = new Insets(0, 0, 5, 0);
		gbc_btnNext.gridx = 0;
		gbc_btnNext.gridy = 4;
		pnlEast.add(btnNext, gbc_btnNext);
		
				JButton btnSaveDrawing = new JButton("Save Drawing");
				btnSaveDrawing.setFont(new Font("Tahoma", Font.PLAIN, 13));
				btnSaveDrawing.setEnabled(true);
				GridBagConstraints gbc_btnSaveDrawing = new GridBagConstraints();
				gbc_btnSaveDrawing.insets = new Insets(0, 0, 5, 0);
				gbc_btnSaveDrawing.gridx = 0;
				gbc_btnSaveDrawing.gridy = 6;
				pnlEast.add(btnSaveDrawing, gbc_btnSaveDrawing);
				
				btnSaveDrawing.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controller.saveDrawing();	
						}
					});
		
				JButton btnLoadDrawing = new JButton("Load Drawing");
				btnLoadDrawing.setFont(new Font("Tahoma", Font.PLAIN, 13));
				btnLoadDrawing.setEnabled(true);
				GridBagConstraints gbc_btnLoadDrawing = new GridBagConstraints();
				gbc_btnLoadDrawing.insets = new Insets(0, 0, 5, 0);
				gbc_btnLoadDrawing.gridx = 0;
				gbc_btnLoadDrawing.gridy = 7;
				pnlEast.add(btnLoadDrawing, gbc_btnLoadDrawing);
																		
																		JLabel lblNewLabel = new JLabel("Komande za polo\u017Eaj oblika:");
																		lblNewLabel.setForeground(new Color(240, 248, 255));
																		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
																		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
																		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
																		gbc_lblNewLabel.gridx = 0;
																		gbc_lblNewLabel.gridy = 11;
																		pnlEast.add(lblNewLabel, gbc_lblNewLabel);
																		
																		btnToFront.setFont(new Font("Tahoma", Font.PLAIN, 13));
																		btnToFront.setEnabled(false);
																		
																				GridBagConstraints gbc_btnToFront = new GridBagConstraints();
																				gbc_btnToFront.fill = GridBagConstraints.VERTICAL;
																				gbc_btnToFront.insets = new Insets(0, 0, 5, 0);
																				gbc_btnToFront.gridx = 0;
																				gbc_btnToFront.gridy = 13;
																				pnlEast.add(btnToFront, gbc_btnToFront);
																				
																				btnGroup.add(btnToFront);
																				
																						btnToFront.addActionListener(new ActionListener() {
																							public void actionPerformed(ActionEvent e) {
																							controller.toFront();
																							}
																						});
																		
																		btnGroup.add(btnToBack);
																		btnToBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
																		btnToBack.setEnabled(false);
																		
																		GridBagConstraints gbc_btnToBack = new GridBagConstraints();
																		gbc_btnToBack.fill = GridBagConstraints.VERTICAL;
																		gbc_btnToBack.insets = new Insets(0, 0, 5, 0);
																		gbc_btnToBack.gridx = 0;
																		gbc_btnToBack.gridy = 14;
																		pnlEast.add(btnToBack, gbc_btnToBack);
																		
																				btnToBack.addActionListener(new ActionListener() {
																					public void actionPerformed(ActionEvent e) {
																					controller.toBack();
																					}
																				});
																		
																				btnGroup.add(btnBringToFront);
																				btnBringToFront.setFont(new Font("Tahoma", Font.PLAIN, 13));
																				btnBringToFront.setEnabled(false);
																				
																				GridBagConstraints gbc_btnBringToFront = new GridBagConstraints();
																				gbc_btnBringToFront.insets = new Insets(0, 0, 5, 0);
																				gbc_btnBringToFront.fill = GridBagConstraints.VERTICAL;
																				gbc_btnBringToFront.gridx = 0;
																				gbc_btnBringToFront.gridy = 15;
																				pnlEast.add(btnBringToFront, gbc_btnBringToFront);
																				
																				
																						btnBringToFront.addActionListener(new ActionListener() {
																							public void actionPerformed(ActionEvent e) {
																							controller.bringToFront();
																							}
																						});
																		
																		btnGroup.add(btnBringToBack);
																		btnBringToBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
																		btnBringToBack.setEnabled(false);
																		
																				btnBringToBack.addActionListener(new ActionListener() {
																					public void actionPerformed(ActionEvent e) {
																					controller.bringToBack();
																					}
																				});
																				
																				GridBagConstraints gbc_btnBringToBack = new GridBagConstraints();
																				gbc_btnBringToBack.insets = new Insets(0, 0, 5, 0);
																				gbc_btnBringToBack.fill = GridBagConstraints.VERTICAL;
																				gbc_btnBringToBack.gridx = 0;
																				gbc_btnBringToBack.gridy = 16;
																				pnlEast.add(btnBringToBack, gbc_btnBringToBack);
		
		btnLoadDrawing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.loadDrawing();	
				}
			});
		
	}
	
	public JButton getBtnUndo() {
		return btnUndo;
	}


	public JButton getBtnRedo() {
		return btnRedo;
	}


	public DrawingView getView() {
		return view;
	}

	public void setController(DrawingController controller) {
		this.controller = controller;
	}

	public JToggleButton getTglbtnSelect() {
		return tglbtnSelect;
	}


	public void setTglbtnSelect(JToggleButton tglbtnSelect) {
		this.tglbtnSelect = tglbtnSelect;
	}


	public JToggleButton getTglbtnPoint() {
		return tglbtnPoint;
	}


	public void setTglbtnPoint(JToggleButton tglbtnPoint) {
		this.tglbtnPoint = tglbtnPoint;
	}


	public JToggleButton getTglbtnLine() {
		return tglbtnLine;
	}


	public void setTglbtnLine(JToggleButton tglbtnLine) {
		this.tglbtnLine = tglbtnLine;
	}


	public JToggleButton getTglbtnRectangle() {
		return tglbtnRectangle;
	}


	public void setTglbtnRectangle(JToggleButton tglbtnRectangle) {
		this.tglbtnRectangle = tglbtnRectangle;
	}


	public JToggleButton getTglbtnCircle() {
		return tglbtnCircle;
	}


	public void setTglbtnCircle(JToggleButton tglbtnCircle) {
		this.tglbtnCircle = tglbtnCircle;
	}


	public JToggleButton getTglbtnDonut() {
		return tglbtnDonut;
	}


	public void setTglbtnDonut(JToggleButton tglbtnDonut) {
		this.tglbtnDonut = tglbtnDonut;
	}
	
	public JToggleButton getTglbtnHexagon() {
		return tglbtnHex;
	}


	public void setTglbtnHexagon(JToggleButton tglbtnHex) {
		this.tglbtnHex = tglbtnHex;
	}


	public DrawingController getController() {
		return controller;
	}


	public void setView(DrawingView view) {
		this.view = view;
	}
	
	public JButton getBtnToBack() {
		return btnToBack;
	}


	public JButton getBtnBringToFront() {
		return btnBringToFront;
	}


	public JButton getBtnBringToBack() {
		return btnBringToBack;
	}


	public JButton getBtnModify() {
		return btnModify;
	}


	public JButton getBtnDelete() {
		return btnDelete;
	}


	public JButton getBtnToFront() {
		return btnToFront;
	}
	
	public JTextArea getTextArea() {
		return textArea;
	}


	public JToggleButton getTglbtnInnerColor() {
		return tglbtnInnerColor;
	}


	public JToggleButton getTglbtnNOuterColor() {
		return tglbtnNOuterColor;
	}
	
	public JButton getBtnNext() {
		return btnNext;
	}

	public void setBtnNext(JButton btnNext) {
		this.btnNext = btnNext;
	}
}
