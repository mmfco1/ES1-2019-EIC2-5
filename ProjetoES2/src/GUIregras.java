import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.WindowConstants;

public class GUIregras implements ActionListener {

	private JFrame frame;
	private JToggleButton LOC, Cyclo, ATFD, LAA;
	private JButton OK;
	private ArrayList<Regras> list;

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

		JTextField tf = new JTextField("");

		JTextField maiorLOCTF = new JTextField("");
		JTextField maiorCYCLOTF = new JTextField("");
		JTextField maiorATFDTF = new JTextField("");
		JTextField maiorLAATF = new JTextField("");

		JTextField menorLOCTF = new JTextField("");
		JTextField menorCYCLOTF = new JTextField("");
		JTextField menorATFDTF = new JTextField("");
		JTextField menorLAATF = new JTextField("");

		tf.setBounds(10, 35, 150, 30);

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

		frame.add(tf);
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

	public GUIregras() {
		guiRegras();
	}
	
	public ArrayList<Regras> getRegras() {
		
		
		return list;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		if (e.getActionCommand().equals("OK")) {
			if (Cyclo.isSelected()) {

			} else if (ATFD.isSelected()) {

			} else if (LAA.isSelected()) {

			} else if (LOC.isSelected()) {

			}
			

		}

	}

}
