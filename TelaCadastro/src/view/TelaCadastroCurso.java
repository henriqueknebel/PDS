package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;

public class TelaCadastroCurso extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField txtNome;
    private JTextArea  txtDescricao;
    private JTextArea  txtConteudo;
    private JTextField txtDuracao;
    private JTextField txtValor;
    private JTextField txtVagas;

    private JButton btnSalvar;
    private JButton btnLimpar;
    private JButton btnVerCursos;

    public TelaCadastroCurso() {

        setTitle("Sistema Acadêmico - Cadastro de Curso");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 570, 560);

        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
        setContentPane(contentPane);

        contentPane.setLayout(new MigLayout("fillx", "[][40.00,grow,right][grow][grow]", "[][][bottom][][grow]"));

        JPanel cabecalho = new JPanel();
        cabecalho.setBackground(Color.BLACK);
        cabecalho.setLayout(new MigLayout("insets 10, align center center"));
        contentPane.add(cabecalho, "cell 1 0 3 1, height 80, grow");

        ImageIcon iconeLogo = carregarIcone("/imagens/LOGO.png", 40, 40);
        if (iconeLogo != null) {
            JLabel lblLogo = new JLabel(iconeLogo);
            cabecalho.add(lblLogo, "split 2");
        }

        JLabel lblJobfy = new JLabel("JOBFY");
        lblJobfy.setForeground(Color.WHITE);
        lblJobfy.setFont(new Font("Times New Roman", Font.BOLD, 32));
        cabecalho.add(lblJobfy);

        JLabel lblTitulo = new JLabel("Cadastro de Curso");
        lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 18));
        contentPane.add(lblTitulo, "cell 1 1 3 1, alignx center, gapbottom 10");

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBorder(new LineBorder(Color.BLACK, 1));
        panel.setLayout(new MigLayout("insets 10", "[][grow]", "[][][][][][]"));
        contentPane.add(panel, "cell 1 2 3 1, growx");

        Font fontLabel = new Font("Times New Roman", Font.PLAIN, 12);

        panel.add(rotulo("Nome:", fontLabel), "cell 0 0");
        txtNome = new RoundedJTextField(1);
        panel.add(txtNome, "cell 1 0, growx");

        panel.add(rotulo("Descrição:", fontLabel), "cell 0 1, aligny top");
        txtDescricao = new JTextArea(3, 1);
        txtDescricao.setLineWrap(true);
        txtDescricao.setWrapStyleWord(true);
        txtDescricao.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        panel.add(new JScrollPane(txtDescricao), "cell 1 1, growx, height 60");

        panel.add(rotulo("Conteúdo:", fontLabel), "cell 0 2, aligny top");
        txtConteudo = new JTextArea(3, 1);
        txtConteudo.setLineWrap(true);
        txtConteudo.setWrapStyleWord(true);
        txtConteudo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        panel.add(new JScrollPane(txtConteudo), "cell 1 2, growx, height 60");

        panel.add(rotulo("Duração (HH:MM):", fontLabel), "cell 0 3");
        txtDuracao = new RoundedJTextField(1);
        panel.add(txtDuracao, "cell 1 3, growx");

        panel.add(rotulo("Valor (R$):", fontLabel), "cell 0 4");
        txtValor = new RoundedJTextField(1);
        panel.add(txtValor, "cell 1 4, growx");

        panel.add(rotulo("Vagas disponíveis:", fontLabel), "cell 0 5");
        txtVagas = new RoundedJTextField(1);
        panel.add(txtVagas, "cell 1 5, growx");

        JPanel painelBotoes = new JPanel(new MigLayout("insets 0", "[120!][120!]"));
        painelBotoes.setBackground(Color.WHITE);

        btnSalvar = new JButton("Salvar");
        estilizarBotao(btnSalvar);
        painelBotoes.add(btnSalvar, "grow");

        btnLimpar = new JButton("Limpar");
        estilizarBotao(btnLimpar);
        painelBotoes.add(btnLimpar, "grow");

        contentPane.add(painelBotoes, "cell 1 3 3 1, alignx center, gaptop 8");

        btnVerCursos = new JButton("Ver Cursos Cadastrados");
        estilizarBotao(btnVerCursos);
        contentPane.add(btnVerCursos, "cell 1 4 3 1, alignx center, gaptop 6");
    }

    private JLabel rotulo(String texto, Font font) {
        JLabel lbl = new JLabel(texto);
        lbl.setFont(font);
        return lbl;
    }

    private void estilizarBotao(JButton botao) {
        botao.setBackground(Color.BLACK);
        botao.setForeground(Color.WHITE);
        botao.setFont(new Font("Tahoma", Font.BOLD, 11));
    }

    private ImageIcon carregarIcone(String caminho, int largura, int altura) {
        URL url = getClass().getResource(caminho);
        if (url == null) return null;
        Image img = new ImageIcon(url).getImage().getScaledInstance(largura, altura, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    public void limparCampos() {
        txtNome.setText("");
        txtDescricao.setText("");
        txtConteudo.setText("");
        txtDuracao.setText("");
        txtValor.setText("");
        txtVagas.setText("");
        txtNome.requestFocus();
    }

    public JTextField getTxtNome(){
    	return txtNome;
    }
    public JTextArea  getTxtDescricao(){ 
    	return txtDescricao; 
    }
    public JTextArea  getTxtConteudo(){ 
    	return txtConteudo; 
    }
    public JTextField getTxtDuracao(){ 
    	return txtDuracao; 
    }
    public JTextField getTxtValor(){ 
    	return txtValor; 
    }
    public JTextField getTxtVagas(){ 
    	return txtVagas; 
    }
    public JButton getBtnSalvar(){
    	return btnSalvar; 
    }
    public JButton getBtnLimpar(){ 
    	return btnLimpar; 
    }
    public JButton getBtnVerCursos(){ 
    	return btnVerCursos; 
    }
}
