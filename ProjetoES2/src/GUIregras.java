import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GUIregras implements ActionListener{

	private JFrame frame;
	private JButton LOC, Cyclo, ATFD, LAA, OK;
	private String nome;
	
	private void guiRegras() {
		frame = new JFrame();
		
//		JPanel panelNome = new JPanel();
//		JPanel botoes = new JPanel();
//		JPanel bottom = new JPanel();
//		
//		panelNome.setLayout(new BorderLayout());
//		botoes.setLayout(new BorderLayout());
//		bottom.setLayout(new BorderLayout());
//		
//		
		JTextField tf = new JTextField("Nome da regra");
		
		tf.setBounds(10, 10, 150, 30);
		
	//	panelNome.add(tf);
		
		
		
		
		
		LOC = new JButton("LOC");
		Cyclo = new JButton("Cyclo");
		ATFD = new JButton("ATFD");
		LAA = new JButton("LAA");
		OK = new JButton("OK");
		
//		botoes.add(LOC, BorderLayout.CENTER);
//		botoes.add(Cyclo, BorderLayout.CENTER);
//		botoes.add(ATFD, BorderLayout.CENTER);
//		
		
		LOC.setBounds(10, 50, 95, 30);
		Cyclo.setBounds(120, 50, 95, 30);
		ATFD.setBounds(10, 100, 95, 30);
		LAA.setBounds(120, 100, 95, 30);
		OK.setBounds(50, 150, 95, 30);
	
		
		frame.add(LOC);
		frame.add(Cyclo);
		frame.add(ATFD);
		frame.add(LAA);
		frame.add(OK);
		
		frame.add(tf);
//		
		frame.setLayout(null);
		frame.getContentPane();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setVisible(true);
		
	}
	
	public GUIregras() {
		guiRegras();
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
