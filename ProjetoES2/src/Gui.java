import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

public class Gui implements ActionListener {

	private JFrame frame;
	private JButton choose;

	private void gui() {
		frame = new JFrame();
		JPanel mainP = new JPanel();
		JPanel middleP = new JPanel();
		JPanel bottomP = new JPanel();
		JTextArea textA = new JTextArea();
		JScrollPane scrollP = new JScrollPane(textA);
		choose = new JButton("Choose");

		textA.setEditable(true);

		mainP.setLayout(new BorderLayout());
		middleP.setLayout(new BorderLayout());
		bottomP.setLayout(new BorderLayout());

		scrollP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		mainP.add(middleP, BorderLayout.CENTER);
		mainP.add(bottomP, BorderLayout.SOUTH);
		bottomP.add(choose, BorderLayout.CENTER);
		bottomP.add(choose);
		middleP.add(scrollP, BorderLayout.CENTER);

		choose.addActionListener(this);

		frame.setSize(500, 600);
		frame.setContentPane(mainP);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public Gui() {
		gui();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {

			System.out.println(e.toString());

			if (e.getActionCommand().equals("Choose")) {
				
				
				JFileChooser fileC = new JFileChooser();
				
				fileC.setCurrentDirectory(new java.io.File("."));
				System.out.println("here");
				fileC.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fileC.showOpenDialog(frame);
				
				
			}

		} catch (IllegalArgumentException e2) {
			// TODO: handle exception
		}

	}

}
