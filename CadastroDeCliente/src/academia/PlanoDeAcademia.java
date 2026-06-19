package academia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

public class PlanoDeAcademia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlanoDeAcademia frame = new PlanoDeAcademia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PlanoDeAcademia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[8.00,grow][110.00,grow][8.00,grow][110.00,grow][110.00,grow][110.00,grow]", "[30.00,grow][30.00,grow][30.00,grow][30.00,grow][30.00,grow][30.00,grow][40.00,grow]"));
		
		JLabel lblNewLabel = new JLabel("Cadastro de Cliente - Academia TREINO FIT ");
		contentPane.add(lblNewLabel, "cell 3 0 3 1,growx");
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		contentPane.add(lblNewLabel_1, "cell 1 1,alignx trailing");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 3 1 3 1,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Telefone");
		contentPane.add(lblNewLabel_2, "cell 1 2,alignx trailing");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		contentPane.add(textField_1, "cell 3 2 3 1,growx");
		
		JLabel lblNewLabel_3 = new JLabel("Tpo de Plano:");
		contentPane.add(lblNewLabel_3, "cell 1 3,alignx right");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Básico");
		contentPane.add(rdbtnNewRadioButton, "cell 3 3");
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Intermediário");
		contentPane.add(rdbtnNewRadioButton_1, "cell 4 3");
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("Premium");
		contentPane.add(rdbtnNewRadioButton_4, "cell 5 3");
		
		JLabel lblNewLabel_4 = new JLabel("Duração:");
		contentPane.add(lblNewLabel_4, "cell 1 4,alignx right");
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Mensal");
		contentPane.add(rdbtnNewRadioButton_2, "cell 3 4");
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("Semestral");
		contentPane.add(rdbtnNewRadioButton_5, "cell 4 4");
		
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("Anual");
		contentPane.add(rdbtnNewRadioButton_6, "cell 5 4");
		
		JLabel lblNewLabel_5 = new JLabel("Frequência semanal:");
		contentPane.add(lblNewLabel_5, "cell 1 5,alignx right");
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("2x por semana");
		contentPane.add(rdbtnNewRadioButton_3, "cell 3 5");
		
		JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("3x por semana");
		contentPane.add(rdbtnNewRadioButton_7, "cell 4 5");
		
		JRadioButton rdbtnNewRadioButton_8 = new JRadioButton("5x por semana");
		contentPane.add(rdbtnNewRadioButton_8, "cell 5 5");
		
		ButtonGroup grupoPlano = new ButtonGroup();
		grupoPlano.add(rdbtnNewRadioButton);
		grupoPlano.add(rdbtnNewRadioButton_1);
		grupoPlano.add(rdbtnNewRadioButton_4);

		ButtonGroup grupoDuracao = new ButtonGroup();
		grupoDuracao.add(rdbtnNewRadioButton_2);
		grupoDuracao.add(rdbtnNewRadioButton_5);
		grupoDuracao.add(rdbtnNewRadioButton_6);

		ButtonGroup grupoFreq = new ButtonGroup();
		grupoFreq.add(rdbtnNewRadioButton_3);
		grupoFreq.add(rdbtnNewRadioButton_7);
		grupoFreq.add(rdbtnNewRadioButton_8);
		
		JButton btnNewButton = new JButton("Calcular");
		contentPane.add(btnNewButton, "cell 3 6,alignx center");
		
		
		JLabel lblResultado = new JLabel("Valor Final: R$ 0,00");
		contentPane.add(lblResultado, "cell 4 6,alignx center");
		
		btnNewButton.addActionListener(e -> {

		    String nome = textField.getText();
		    String telefone = textField_1.getText();

		    // Validação
		    if (nome.isEmpty() || telefone.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Preencha nome e telefone!");
		        return;
		    }

		    String plano = null;
		    String duracao = null;
		    String frequencia = null;

		    // Plano
		    if (rdbtnNewRadioButton.isSelected()) plano = "Básico";
		    if (rdbtnNewRadioButton_1.isSelected()) plano = "Intermediário";
		    if (rdbtnNewRadioButton_4.isSelected()) plano = "Premium";

		    // Duração
		    if (rdbtnNewRadioButton_2.isSelected()) duracao = "Mensal";
		    if (rdbtnNewRadioButton_5.isSelected()) duracao = "Semestral";
		    if (rdbtnNewRadioButton_6.isSelected()) duracao = "Anual";

		    // Frequência
		    if (rdbtnNewRadioButton_3.isSelected()) frequencia = "2x";
		    if (rdbtnNewRadioButton_7.isSelected()) frequencia = "3x";
		    if (rdbtnNewRadioButton_8.isSelected()) frequencia = "5x";

		    if (plano == null || duracao == null || frequencia == null) {
		        JOptionPane.showMessageDialog(null, "Selecione todas as opções!");
		        return;
		    }

		    double valor = PlanoModel.calcularValor(plano, duracao, frequencia);

		    lblResultado.setText(String.format("Valor Final: R$ %.2f", valor));
		});

	}
	
	
}
