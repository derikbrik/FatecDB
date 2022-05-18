package locadora.forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import locadora.Acessorio;
import locadora.Carro;
import locadora.Locadora;

import javax.swing.ListSelectionModel;
import java.awt.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.ListModel;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JSeparator;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class FrmPrincipal extends JFrame {

	private Locadora locadora;
	private DefaultListModel modelLocacoes;
	private DefaultListModel modellstCarros;

	private DefaultComboBoxModel<Carro> modelCboCarros;

	public static FrmPrincipal frame;
	private JTextField txtDtRetirada;
	private JTextField txtDtDevolucao;
	private JTextField txtDtLocacao;
	private JTextField txtDestino;
	private JTextField txtChassi;
	private JTextField txtPlaca;
	private JTextField txtCor;
	private JTextField txtNumMotor;
	private JTextField txtPortas;
	private JTextField txtOdometro;
	private JTextField txtModelo;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new FrmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Locadora getLocadora() {
		return locadora;
	}

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	public FrmPrincipal() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 567);

		locadora = new Locadora();
		locadora.teste();

		modelLocacoes = new DefaultListModel();
		AtualizarModeloLocacoes();

		modellstCarros = new DefaultListModel();
		AtualizarModelolstCarros();

		getContentPane().setLayout(null);

		modelCboCarros = new DefaultComboBoxModel<Carro>();
		AtualizarModeloCboCarros();

		JPanel pnl_NovaLocacao = new JPanel();
		pnl_NovaLocacao.setBounds(10, 41, 437, 171);
		getContentPane().add(pnl_NovaLocacao);
		pnl_NovaLocacao.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnl_NovaLocacao.setLayout(null);

		JPanel pnl_Principal = new JPanel();
		pnl_Principal.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnl_Principal.setLayout(null);
		pnl_Principal.setBounds(10, 41, 437, 449);
		getContentPane().add(pnl_Principal);

		JPanel pnl_NovoCarro = new JPanel();
		pnl_NovoCarro.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnl_NovoCarro.setBounds(10, 41, 437, 288);
		getContentPane().add(pnl_NovoCarro);
		pnl_NovoCarro.setLayout(null);

		JList lstLocacoes = new JList(modelLocacoes);
		lstLocacoes.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lstLocacoes.setBounds(10, 36, 368, 126);
		pnl_Principal.add(lstLocacoes);

		JLabel lblNewLabel = new JLabel("Loca\u00E7\u00F5es");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 11, 75, 14);
		pnl_Principal.add(lblNewLabel);

		JButton btnNewButton = new JButton("Nova Loca\u00E7\u00E3o");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtDestino.setText("");
				txtDtLocacao.setText("");
				txtDtRetirada.setText("");
				txtDtDevolucao.setText("");

				pnl_NovaLocacao.setVisible(true);
				pnl_Principal.setVisible(false);
			}
		});

		btnNewButton.setBounds(144, 173, 112, 23);
		pnl_Principal.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Excluir Loca\u00E7\u00E3o");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int selectedIndex = lstLocacoes.getSelectedIndex();

				if (selectedIndex != -1) {
					locadora.getLocacoes().remove(modelLocacoes.get(selectedIndex));

					modelLocacoes.remove(selectedIndex);
				}

				AtualizarModeloLocacoes();

			}
		});
		btnNewButton_1.setBounds(266, 173, 112, 23);
		pnl_Principal.add(btnNewButton_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 217, 368, 14);
		pnl_Principal.add(separator);

		JList lstCarros = new JList(modellstCarros);
		lstCarros.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lstCarros.setBounds(10, 242, 173, 149);
		pnl_Principal.add(lstCarros);

		JButton btnNewButton_2 = new JButton("Excluir Carro");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int selectedIndex = lstCarros.getSelectedIndex();
				if (selectedIndex != -1) {
					locadora.getCarros().remove(modellstCarros.get(selectedIndex));

					modellstCarros.remove(selectedIndex);
				}

				AtualizarModelolstCarros();
				AtualizarModeloCboCarros();

			}

		});
		btnNewButton_2.setBounds(266, 415, 112, 23);
		pnl_Principal.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Novo Carro");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pnl_NovoCarro.setVisible(true);
				pnl_Principal.setVisible(false);
				pnl_NovaLocacao.setVisible(false);

			}
		});
		btnNewButton_3.setBounds(144, 415, 112, 23);
		pnl_Principal.add(btnNewButton_3);

		JLabel lblNewLabel_5 = new JLabel("Chassi");
		lblNewLabel_5.setBounds(29, 14, 46, 14);
		pnl_NovoCarro.add(lblNewLabel_5);

		txtChassi = new JTextField();
		txtChassi.setColumns(10);
		txtChassi.setBounds(85, 11, 86, 20);
		pnl_NovoCarro.add(txtChassi);

		JLabel lblNewLabel_1_2 = new JLabel("Placa");
		lblNewLabel_1_2.setBounds(181, 14, 46, 14);
		pnl_NovoCarro.add(lblNewLabel_1_2);

		txtPlaca = new JTextField();
		txtPlaca.setColumns(10);
		txtPlaca.setBounds(251, 11, 86, 20);
		pnl_NovoCarro.add(txtPlaca);

		txtCor = new JTextField();
		txtCor.setColumns(10);
		txtCor.setBounds(251, 42, 86, 20);
		pnl_NovoCarro.add(txtCor);

		JLabel lblNewLabel_2_2 = new JLabel("Cor");
		lblNewLabel_2_2.setBounds(181, 45, 60, 14);
		pnl_NovoCarro.add(lblNewLabel_2_2);

		txtNumMotor = new JTextField();
		txtNumMotor.setColumns(10);
		txtNumMotor.setBounds(85, 42, 86, 20);
		pnl_NovoCarro.add(txtNumMotor);

		JLabel lblNewLabel_2_1 = new JLabel("N.\u00BA Motor");
		lblNewLabel_2_1.setBounds(15, 45, 60, 14);
		pnl_NovoCarro.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_3 = new JLabel("Portas");
		lblNewLabel_2_3.setBounds(15, 76, 60, 14);
		pnl_NovoCarro.add(lblNewLabel_2_3);

		txtPortas = new JTextField();
		txtPortas.setColumns(10);
		txtPortas.setBounds(85, 73, 86, 20);
		pnl_NovoCarro.add(txtPortas);

		JLabel lblNewLabel_2_1_1 = new JLabel("Odometro");
		lblNewLabel_2_1_1.setBounds(181, 73, 60, 14);
		pnl_NovoCarro.add(lblNewLabel_2_1_1);

		txtOdometro = new JTextField();
		txtOdometro.setColumns(10);
		txtOdometro.setBounds(251, 70, 86, 20);
		pnl_NovoCarro.add(txtOdometro);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(
				new TitledBorder(null, "Acess\u00F3rios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 151, 217, 126);
		pnl_NovoCarro.add(panel_1);

		JCheckBox chkAr_Condicionado = new JCheckBox("Ar Condicionado");

		chkAr_Condicionado.setBounds(6, 17, 103, 23);
		panel_1.add(chkAr_Condicionado);

		JCheckBox chkCambio_Automatico = new JCheckBox("C\u00E2mbio Autom\u00E1tico");

		chkCambio_Automatico.setBounds(6, 43, 143, 23);
		panel_1.add(chkCambio_Automatico);

		JCheckBox chkDirecao_Hidraulica = new JCheckBox("Dire\u00E7\u00E3o Hidr\u00E1ulica");
		chkDirecao_Hidraulica.setBounds(6, 70, 143, 23);
		panel_1.add(chkDirecao_Hidraulica);

		JCheckBox chkMultimidia = new JCheckBox("Multimidia");
		chkMultimidia.setBounds(6, 96, 97, 23);
		panel_1.add(chkMultimidia);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String chassi = txtChassi.getText();
				String placa = txtPlaca.getText();
				String num_Motor = txtNumMotor.getText();
				String cor = txtCor.getText();
				int num_Portas = Integer.parseInt(txtPortas.getText());
				double odometro = Double.parseDouble(txtOdometro.getText());
				String modelo = txtModelo.getText();

				Acessorio acessorio = new Acessorio();
				acessorio.setAr_Condicionado(chkAr_Condicionado.isSelected());
				acessorio.setCambio_Automatico(chkCambio_Automatico.isSelected());
				acessorio.setDirecao_Hidraulica(chkDirecao_Hidraulica.isSelected());
				acessorio.setMultimidia(chkMultimidia.isSelected());

				Carro carro = new Carro(chassi, placa, num_Motor, cor, num_Portas, odometro, acessorio, modelo);

				locadora.getCarros().add(carro);

				txtChassi.setText("");
				txtPlaca.setText("");
				txtNumMotor.setText("");
				txtCor.setText("");
				txtPortas.setText("");
				txtOdometro.setText("");
				txtModelo.setText("");

				chkAr_Condicionado.setSelected(false);
				chkCambio_Automatico.setSelected(false);
				chkDirecao_Hidraulica.setSelected(false);
				chkMultimidia.setSelected(false);

				AtualizarModelolstCarros();
				AtualizarModeloCboCarros();
				pnl_NovaLocacao.setVisible(false);
				pnl_Principal.setVisible(true);
				pnl_NovoCarro.setVisible(false);
			}
		});
		btnSalvar.setBounds(237, 220, 89, 23);
		pnl_NovoCarro.add(btnSalvar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pnl_NovaLocacao.setVisible(false);
				pnl_NovoCarro.setVisible(false);
				pnl_Principal.setVisible(true);
			}
		});
		btnCancelar.setBounds(235, 254, 89, 23);
		pnl_NovoCarro.add(btnCancelar);

		txtModelo = new JTextField();
		txtModelo.setBounds(85, 104, 252, 20);
		pnl_NovoCarro.add(txtModelo);
		txtModelo.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Modelo");
		lblNewLabel_6.setBounds(29, 107, 46, 14);
		pnl_NovoCarro.add(lblNewLabel_6);

		JComboBox<Carro> cboCarros = new JComboBox<Carro>(modelCboCarros);
		cboCarros.setBounds(263, 88, 156, 22);
		pnl_NovaLocacao.add(cboCarros);

		JLabel lblNewLabel_1 = new JLabel("Carro:");
		lblNewLabel_1.setBounds(223, 92, 46, 14);
		pnl_NovaLocacao.add(lblNewLabel_1);

		JLabel lblNewLabel_4 = new JLabel("Data Devolu\u00E7\u00E3o:");
		lblNewLabel_4.setBounds(27, 88, 94, 14);
		pnl_NovaLocacao.add(lblNewLabel_4);

		txtDtRetirada = new JTextField();
		txtDtRetirada.setColumns(10);
		txtDtRetirada.setBounds(334, 54, 85, 20);
		pnl_NovaLocacao.add(txtDtRetirada);

		JLabel lblNewLabel_3 = new JLabel("Data Retirada:");
		lblNewLabel_3.setBounds(250, 57, 85, 14);
		pnl_NovaLocacao.add(lblNewLabel_3);

		txtDtDevolucao = new JTextField();
		txtDtDevolucao.setColumns(10);
		txtDtDevolucao.setBounds(124, 85, 86, 20);
		pnl_NovaLocacao.add(txtDtDevolucao);

		txtDtLocacao = new JTextField();
		txtDtLocacao.setColumns(10);
		txtDtLocacao.setBounds(125, 54, 85, 20);
		pnl_NovaLocacao.add(txtDtLocacao);

		txtDestino = new JTextField();
		txtDestino.setColumns(10);
		txtDestino.setBounds(125, 29, 294, 20);
		pnl_NovaLocacao.add(txtDestino);

		JLabel lblNewLabel_1_1 = new JLabel("Destino:");
		lblNewLabel_1_1.setBounds(28, 32, 46, 14);
		pnl_NovaLocacao.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2 = new JLabel("Data Loca\u00E7\u00E3o:");
		lblNewLabel_2.setBounds(25, 57, 77, 14);
		pnl_NovaLocacao.add(lblNewLabel_2);
		pnl_NovaLocacao.setVisible(false);
		pnl_NovoCarro.setVisible(false);

		JButton btnCancelarLocacao = new JButton("Cancelar");
		btnCancelarLocacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtDestino.setText("");
				txtDtLocacao.setText("");
				txtDtRetirada.setText("");
				txtDtDevolucao.setText("");

				pnl_NovaLocacao.setVisible(true);
				pnl_Principal.setVisible(false);

				pnl_NovaLocacao.setVisible(false);
				pnl_Principal.setVisible(true);
			}
		});
		btnCancelarLocacao.setBounds(334, 130, 89, 23);
		pnl_NovaLocacao.add(btnCancelarLocacao);

		JButton btnSalvarLocacao = new JButton("Salvar");
		btnSalvarLocacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Carro s_carro = (Carro) cboCarros.getModel().getSelectedItem();
				// System.out.println(s_carro);

				String strDestino = txtDestino.getText();
				String strDtLocacao = txtDtLocacao.getText();
				String strDtRetirada = txtDtRetirada.getText();
				String strDtDevolucao = txtDtDevolucao.getText();

				AddLocacao(strDestino, strDtLocacao, strDtRetirada, strDtDevolucao, s_carro);
				AtualizarModeloLocacoes();

				pnl_NovaLocacao.setVisible(false);
				pnl_Principal.setVisible(true);

			}
		});

		btnSalvarLocacao.setBounds(235, 130, 89, 23);
		pnl_NovaLocacao.add(btnSalvarLocacao);
		
		JButton btnNewButton_4 = new JButton("Sair");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
					
				
			}
		});
		btnNewButton_4.setBounds(358, 494, 89, 23);
		getContentPane().add(btnNewButton_4);

	}

	public void AtualizarModeloLocacoes() {
		modelLocacoes.clear();
		for (int i = 0; i < locadora.getLocacoes().size(); i++) {
			modelLocacoes.add(i, locadora.getLocacoes().get(i));
		}
	}

	public void AtualizarModelolstCarros() {
		modellstCarros.clear();
		for (int i = 0; i < locadora.getCarros().size(); i++) {
			modellstCarros.add(i, locadora.getCarros().get(i));
		}
	}

	public void AtualizarModeloCboCarros() {

		modelCboCarros.removeAllElements();
		for (int i = 0; i < locadora.getCarros().size(); i++) {
			modelCboCarros.addElement(locadora.getCarros().get(i));
		}
	}

	public void AddLocacao(String _txtDestino, String _txtDtLocacao, String _txtDtRetirada, String _txtDtDevolucao,
			Carro _carro) {

		try {
			locadora.NovaLocacao(_txtDestino, _txtDtLocacao, _txtDtRetirada, _txtDtDevolucao, _carro);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
