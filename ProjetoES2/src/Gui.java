import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class Gui implements ActionListener {

	private JFrame frame, frame2;
	private JTable table;
	private JScrollPane sp;
	private JList<String> list;
	private ArrayList<Regras> regraslist = new ArrayList<Regras>();
	private DefaultListModel<String> dl;
	private JButton choose, thresholds, edit, run, del;
	private String[][] cols;
	private final String[] ROWS = { "MethodID", "Package", "Class", "Method", "LOC", "CYCLO", "ATFD", "LAA",
			"is_long_method", "iPlasma", "PMD", "is_feature_envy" };

	/*
	 * criacao do gui Francisco Veiga
	 */
	private void gui() {
		frame = new JFrame("Exel");
		JPanel mainP = new JPanel();
		JPanel middleP = new JPanel();
		JPanel bottomP = new JPanel();
		table = new JTable();
		DefaultTableModel dtm = new DefaultTableModel(cols, ROWS);
		table.setModel(dtm);
		JScrollPane scrollP = new JScrollPane(table);
		choose = new JButton("Choose");
		thresholds = new JButton("Tresholds");

		mainP.setLayout(new BorderLayout());
		middleP.setLayout(new BorderLayout());
		bottomP.setLayout(new GridLayout(1, 2));

		scrollP.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		mainP.add(middleP, BorderLayout.CENTER);
		mainP.add(bottomP, BorderLayout.SOUTH);
		bottomP.add(choose, BorderLayout.EAST);
		bottomP.add(thresholds, BorderLayout.WEST);

		middleP.add(scrollP, BorderLayout.CENTER);

		choose.addActionListener(this);
		thresholds.addActionListener(this);

		frame.setSize(1500, 600);
		frame.setContentPane(mainP);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public Gui() {
		gui();
	}

	/*
	 * acoes dos buttoes Francisco, Afonso
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {

			if (e.getActionCommand().equals("Choose")) {

				JFileChooser fileC = new JFileChooser();

				fileC.setCurrentDirectory(new java.io.File("."));
				fileC.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fileC.showOpenDialog(frame);
				Worker w = new Worker();
				File file = fileC.getSelectedFile();
				try {
					String[][] temp = w.createCols(file);
					String[] topRow = temp[0];
					DefaultTableModel dtm = new DefaultTableModel(temp, topRow);
					table.setModel(dtm);
				} catch (EncryptedDocumentException | InvalidFormatException | IOException e1) {
					e1.printStackTrace();
				}

			} else if (e.getActionCommand().equals("Tresholds")) {
				gui2();
			} else if (e.getActionCommand().equals("Correr")) {
				if (list.getSelectedIndex() != -1) {
					regraslist.get(list.getSelectedIndex());
					frame2.dispose();
				}
			} else if (e.getActionCommand().equals("Criar")) {
				GUIregras gr = new GUIregras(this);

			} else if (e.getActionCommand().equals("Delete")) {
				if (list.getSelectedIndex() != -1) {
					
					regraslist.remove(list.getSelectedIndex());

					dl.remove(list.getSelectedIndex());
				}
			}

		} catch (IllegalArgumentException e2) {
		}

	}

	public void setRegraslist(ArrayList<Regras> regraslist) {
		this.regraslist.addAll(regraslist);

		for (Regras regras : regraslist) {
			dl.addElement(regras.getNome());
		}
	}

	/*
	 * 2 gui Francisco Veiga
	 */
	private void gui2() {
		frame2 = new JFrame("Thresholds");

		list = new JList<String>();
		dl = new DefaultListModel<String>();
		sp = new JScrollPane(list);

		edit = new JButton("Criar");
		run = new JButton("Correr");
		del = new JButton("Delete");

		JPanel middle = new JPanel();
		JPanel bot = new JPanel();

		middle.setLayout(new BorderLayout());
		bot.setLayout(new GridLayout(1, 3));

		list.setModel(dl);
		bot.add(edit);
		bot.add(del);
		bot.add(run);
		middle.add(sp, BorderLayout.CENTER);

		del.addActionListener(this);
		edit.addActionListener(this);
		run.addActionListener(this);

		middle.add(bot, BorderLayout.SOUTH);

		frame2.setContentPane(middle);
		frame2.setVisible(true);
		frame2.setSize(300, 200);
		frame2.setLocationRelativeTo(null);
		frame2.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	}

}
