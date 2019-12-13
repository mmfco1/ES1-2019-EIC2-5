package main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.WindowConstants;

public class GUIregras implements ActionListener {

	private JFrame frame;
	private JToggleButton LOC, Cyclo, ATFD, LAA;
	private JButton OK;
	private ArrayList<Regras> list = new ArrayList<Regras>();
	private Gui gui;
	private JTextField ntf, maiorLOCTF, maiorCYCLOTF, maiorATFDTF, maiorLAATF, menorLOCTF, menorCYCLOTF, menorATFDTF,
			menorLAATF;

	private void guiRegras() {
		frame = new JFrame();

		JLabel maiorLOC = new JLabel("Maior que: ");
		JLabel maiorCYCLO = new JLabel("Maior que: ");
		JLabel maiorATFD = new JLabel("Maior que: ");
		JLabel maiorLAA = new JLabel("Maior que: ");

		JLabel menorLOC = new JLabel("Menor que: ");
		JLabel menorCYCLO = new JLabel("Menor que: ");
		JLabel menorATFD = new JLabel("Menor que: ");
		JLabel menorLAA = new JLabel("Menor que: ");

		JLabel name = new JLabel("Nome da regra");

		ntf = new JTextField("");

		maiorLOCTF = new JTextField("");
		maiorCYCLOTF = new JTextField("");
		maiorATFDTF = new JTextField("");
		maiorLAATF = new JTextField("");

		menorLOCTF = new JTextField("");
		menorCYCLOTF = new JTextField("");
		menorATFDTF = new JTextField("");
		menorLAATF = new JTextField("");

		ntf.setBounds(10, 35, 150, 30);

		LOC = new JToggleButton("LOC");
		Cyclo = new JToggleButton("Cyclo");
		ATFD = new JToggleButton("ATFD");
		LAA = new JToggleButton("LAA");
		OK = new JButton("OK");

		// position of the jlabes
		name.setBounds(10, 10, 150, 20);
		maiorLOC.setBounds(120, 70, 150, 20);
		maiorCYCLO.setBounds(120, 100, 150, 20);
		maiorATFD.setBounds(120, 130, 150, 20);
		maiorLAA.setBounds(120, 160, 150, 20);
		menorLOC.setBounds(300, 70, 150, 20);
		menorCYCLO.setBounds(300, 100, 150, 20);
		menorATFD.setBounds(300, 130, 150, 20);
		menorLAA.setBounds(300, 160, 150, 20);

		// position of the jtextfieds
		maiorLOCTF.setBounds(220, 70, 50, 20);
		maiorCYCLOTF.setBounds(220, 100, 50, 20);
		maiorATFDTF.setBounds(220, 130, 50, 20);
		maiorLAATF.setBounds(220, 160, 50, 20);
		menorLOCTF.setBounds(400, 70, 50, 20);
		menorCYCLOTF.setBounds(400, 100, 50, 20);
		menorATFDTF.setBounds(400, 130, 50, 20);
		menorLAATF.setBounds(400, 160, 50, 20);

		// position of the jbutton / jtogglebutton
		LOC.setBounds(10, 70, 95, 20);
		Cyclo.setBounds(10, 100, 95, 20);
		ATFD.setBounds(10, 130, 95, 20);
		LAA.setBounds(10, 160, 95, 20);
		OK.setBounds(190, 240, 90, 20);

		frame.add(LOC);
		frame.add(Cyclo);
		frame.add(ATFD);
		frame.add(LAA);
		frame.add(OK);

		OK.addActionListener(this);

		frame.add(ntf);
		// adding the jlabels to frame
		frame.add(name);
		frame.add(maiorLOC);
		frame.add(maiorCYCLO);
		frame.add(maiorATFD);
		frame.add(maiorLAA);
		frame.add(menorLOC);
		frame.add(menorCYCLO);
		frame.add(menorATFD);
		frame.add(menorLAA);

		// adding the jtextareas to frame
		frame.add(maiorLOCTF);
		frame.add(maiorCYCLOTF);
		frame.add(maiorATFDTF);
		frame.add(maiorLAATF);
		frame.add(menorLOCTF);
		frame.add(menorCYCLOTF);
		frame.add(menorATFDTF);
		frame.add(menorLAATF);

		frame.setLayout(null);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(500, 300);
		frame.setVisible(true);

	}

	public GUIregras(Gui gui) {
		guiRegras();
		this.gui = gui;
	}
	
	public GUIregras(Regras r) {
		ver(r);
	}
	

	private void ver(Regras r) {
		JOptionPane.showMessageDialog(frame, r.toString());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		list.clear();
		int c = 0, a = 0, la = 0, lo = 0;
		try {
			if (e.getActionCommand().equals("OK")) {
				if (Cyclo.isSelected()) {
					if (!maiorCYCLOTF.getText().equals("")) {
						System.out.println("here");
						c = Integer.parseInt(maiorCYCLOTF.getText());

					} else if (!menorCYCLOTF.getText().equals("")) {
						c = Integer.parseInt(menorCYCLOTF.getText());
						c = c * (-1);

					}
				}
				if (ATFD.isSelected()) {
					if (!maiorATFDTF.getText().equals("")) {
						a = Integer.parseInt(maiorATFDTF.getText());
					} else if (!menorATFDTF.getText().equals("")) {
						a = Integer.parseInt(menorATFDTF.getText());
						a = a * (-1);
					}

				}
				if (LAA.isSelected()) {
					if (!maiorLAATF.getText().equals("")) {
						la = Integer.parseInt(maiorLAATF.getText());
					} else if (!menorLAATF.getText().equals("")) {
						la = Integer.parseInt(menorLAATF.getText());
						la = la * (-1);
					}
				}
				if (LOC.isSelected()) {
					if (!maiorLOCTF.getText().equals("")) {
						lo = Integer.parseInt(maiorLOCTF.getText());
					} else if (!menorLOCTF.getText().equals("")) {
						lo = Integer.parseInt(menorLOCTF.getText());
						lo = lo * (-1);
					}
				}
				if (ntf.getText().equals("")) {
					throw new Exception();
				}
				
				// Cria a regra, se lo,a,c,la que sao respetivamente LOO ATFD CYCLOS LAA for negativo significa que é menor 
				// do q o numero, se for positivo é maior do que o numero, se for 0 nao ha regra;
				
				if (lo==0 && a==0 && c==0 && la==0 ) {
					throw new Exception();
				}
				Regras regra = new Regras(ntf.getText(), lo, a, c, la);

				list.add(regra);

				gui.setRegraslist(list);
				frame.dispose();
			}
		} catch (Exception ee) {
			JOptionPane.showMessageDialog(frame, "Input Errado");
		}
	}

}
