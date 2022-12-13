package camara;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Apresentacao {

	private JFrame frame;
	private JTextField tfTitulo;
	private JTextField tfApresentar;
	private JTextField tfAprovar;
	private JTextField tfNumero;
	private JTextField tfLO;
	private JTextField tfVotos;
	private DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private HashMap<Integer, ProjetoDeLei> projetos = new HashMap<>();
	private ArrayList<Vereador> vereadores = new ArrayList<Vereador>();
	private JTextField tfVereador;
	private JTextField tfPartido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apresentacao window = new Apresentacao();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Apresentacao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 544, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JComboBox<String> cbTipoProjeto = new JComboBox<String>();
		cbTipoProjeto.setModel(new DefaultComboBoxModel<String>(new String[] { "Projeto de Lei", "PL Complementar" }));
		cbTipoProjeto.setToolTipText("Projeto de Lei\r\nPL Complementar");
		cbTipoProjeto.setBounds(386, 8, 117, 25);
		frame.getContentPane().add(cbTipoProjeto);
		cbTipoProjeto.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (cbTipoProjeto.getSelectedItem().toString().equals("PL Complementar")) {
					tfVotos.setEnabled(true);
					tfLO.setEnabled(true);
				} else {
					tfVotos.setEnabled(false);
					tfLO.setEnabled(false);
				}
			}

		});

		JComboBox<Vereador> cbVereador = new JComboBox<Vereador>();
		cbVereador.setBounds(31, 231, 90, 25);
		frame.getContentPane().add(cbVereador);

		JComboBox<Partido> cbPartido = new JComboBox<Partido>();
		cbPartido.setBounds(168, 231, 85, 25);
		frame.getContentPane().add(cbPartido);

		JLabel lblNewLabel = new JLabel("Título do Projeto:");
		lblNewLabel.setBounds(12, 14, 100, 16);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Data de Apresentação:");
		lblNewLabel_1.setBounds(12, 42, 138, 16);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Data de Aprovação:");
		lblNewLabel_2.setBounds(12, 70, 117, 16);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Nº do Projeto:");
		lblNewLabel_3.setBounds(12, 98, 85, 16);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Artigo Lei Orgânica:");
		lblNewLabel_4.setBounds(12, 124, 117, 16);
		frame.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Qtd. de Votos Favoráveis:");
		lblNewLabel_5.setBounds(12, 152, 150, 16);
		frame.getContentPane().add(lblNewLabel_5);

		tfTitulo = new JTextField();
		tfTitulo.setBounds(115, 12, 150, 20);
		frame.getContentPane().add(tfTitulo);
		tfTitulo.setColumns(10);

		tfApresentar = new JTextField();
		tfApresentar.setBounds(149, 40, 94, 20);
		frame.getContentPane().add(tfApresentar);
		tfApresentar.setColumns(10);

		tfAprovar = new JTextField();
		tfAprovar.setColumns(10);
		tfAprovar.setBounds(134, 70, 94, 20);
		frame.getContentPane().add(tfAprovar);

		tfNumero = new JTextField();
		tfNumero.setBounds(93, 98, 57, 20);
		frame.getContentPane().add(tfNumero);
		tfNumero.setColumns(10);

		tfLO = new JTextField();
		tfLO.setColumns(10);
		tfLO.setBounds(135, 122, 75, 20);
		frame.getContentPane().add(tfLO);

		tfVotos = new JTextField();
		tfVotos.setColumns(10);
		tfVotos.setBounds(168, 150, 75, 20);
		frame.getContentPane().add(tfVotos);

		JLabel lblNewLabel_6 = new JLabel("Tipo de Projeto:");
		lblNewLabel_6.setBounds(293, 12, 94, 16);
		frame.getContentPane().add(lblNewLabel_6);

		JButton btnCadastrar = new JButton("Cadastrar Projeto");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ProjetoDeLei pl = null;
					if (cbTipoProjeto.getSelectedIndex() == 0) {
						pl = new ProjetoDeLei(tfTitulo.getText(), LocalDate.parse(tfApresentar.getText(), df),
								LocalDate.parse(tfAprovar.getText(), df), Integer.parseInt(tfNumero.getText()), null);
					} else if (cbTipoProjeto.getSelectedIndex() == 1) {
						pl = new ProjetoDeLeiComplementar(tfTitulo.getText(),
								LocalDate.parse(tfApresentar.getText(), df), LocalDate.parse(tfAprovar.getText(), df),
								Integer.parseInt(tfNumero.getText()), Integer.parseInt(tfLO.getText()),
								Integer.parseInt(tfVotos.getText()), null);
					}
					projetos.put(pl.getNumeroProjeto(), pl);
					JOptionPane.showMessageDialog(frame, "Projeto Adicionado");
				} catch (DateTimeException e2) {
					JOptionPane.showMessageDialog(frame, e2);
				} catch (IllegalArgumentException e3) {
					JOptionPane.showMessageDialog(frame, e3.getMessage());
				}
			}
		});
		btnCadastrar.setBounds(31, 182, 179, 26);
		frame.getContentPane().add(btnCadastrar);

		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = "Lista de Projetos\\n";
				String ver = "Vereador";
				for (Vereador v : vereadores) {
					ver += "\n" + v.getNome();
					JOptionPane.showMessageDialog(frame, ver);
				}
				for (ProjetoDeLei p : projetos.values()) {
					str += "\n" + p.mostrar();
				}
				JOptionPane.showMessageDialog(frame, str);

			}
		});
		btnMostrar.setBounds(378, 254, 98, 26);
		frame.getContentPane().add(btnMostrar);

		JLabel lblNewLabel_7 = new JLabel("Partido:");
		lblNewLabel_7.setBounds(262, 187, 55, 16);
		frame.getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Vereador:");
		lblNewLabel_8.setBounds(262, 114, 66, 16);
		frame.getContentPane().add(lblNewLabel_8);

		JButton btnNewButton = new JButton("Cadastrar Tipo");
		btnNewButton.setBounds(346, 40, 130, 26);
		frame.getContentPane().add(btnNewButton);

		JButton btnVereador = new JButton("Vereador");
		btnVereador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Vereador v = new Vereador(tfVereador.getText());
					cbVereador.addItem(v);
					System.out.println(v);

				} catch (IllegalArgumentException e2) {
					JOptionPane.showMessageDialog(frame, e2.getMessage());
				}
			}
		});
		btnVereador.setBounds(418, 109, 98, 26);
		frame.getContentPane().add(btnVereador);

		JButton btnPartido = new JButton("Partido");
		btnPartido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Partido p = new Partido(tfPartido.getText());
					cbPartido.addItem(p);
				} catch (IllegalArgumentException e2) {
					JOptionPane.showMessageDialog(frame, e2.getMessage());
				}
			}
		});
		btnPartido.setBounds(418, 182, 98, 26);
		frame.getContentPane().add(btnPartido);

		tfVereador = new JTextField();
		tfVereador.setBounds(326, 112, 85, 20);
		frame.getContentPane().add(tfVereador);
		tfVereador.setColumns(10);

		tfPartido = new JTextField();
		tfPartido.setColumns(10);
		tfPartido.setBounds(321, 185, 85, 20);
		frame.getContentPane().add(tfPartido);

	}
}
