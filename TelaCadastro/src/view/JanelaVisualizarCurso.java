package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class JanelaVisualizarCurso extends JDialog {

    private static final long serialVersionUID = 1L;

    private JTextField txtNome;
    private JTextArea  txtDescricao;
    private JTextArea  txtConteudo;
    private JTextField txtDuracao;
    private JTextField txtValor;
    private JTextField txtVagas;

    private JButton btnSalvar;
    private JButton btnCancelar;

    private int linhaEditando = -1;

    public JanelaVisualizarCurso() {

        setModal(true);
        setTitle("Curso");
        setBounds(100, 100, 460, 420);

        getContentPane().setLayout(new MigLayout("insets 15", "[][grow]", "[][][][][][][][]"));

        Font fontLabel = new Font("Times New Roman", Font.PLAIN, 12);

        add(rotulo("Nome:", fontLabel));
        txtNome = new RoundedJTextField(1);
        add(txtNome, "growx, wrap");

        add(rotulo("Descrição:", fontLabel), "aligny top");
        txtDescricao = new JTextArea(3, 1);
        txtDescricao.setLineWrap(true);
        txtDescricao.setWrapStyleWord(true);
        add(new JScrollPane(txtDescricao), "growx, height 60, wrap");

        add(rotulo("Conteúdo:", fontLabel), "aligny top");
        txtConteudo = new JTextArea(3, 1);
        txtConteudo.setLineWrap(true);
        txtConteudo.setWrapStyleWord(true);
        add(new JScrollPane(txtConteudo), "growx, height 60, wrap");

        add(rotulo("Duração (HH:MM):", fontLabel));
        txtDuracao = new RoundedJTextField(1);
        add(txtDuracao, "growx, wrap");

        add(rotulo("Valor (R$):", fontLabel));
        txtValor = new RoundedJTextField(1);
        add(txtValor, "growx, wrap");

        add(rotulo("Vagas disponíveis:", fontLabel));
        txtVagas = new RoundedJTextField(1);
        add(txtVagas, "growx, wrap");

        btnSalvar = new JButton("Salvar");
        estilizarBotao(btnSalvar);
        add(btnSalvar, "split 2, span, alignx right");

        btnCancelar = new JButton("Cancelar");
        estilizarBotao(btnCancelar);
        add(btnCancelar);
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

    public int getLinhaEditando(){ 
    	return linhaEditando; 
    }
    public void setLinhaEditando(int l){ 
    	this.linhaEditando = l; 
    }
    public JTextField getTxtNome(){ 
    	return txtNome; 
    }
    public JTextArea getTxtDescricao(){
        return txtDescricao; 
    }
    public JTextArea getTxtConteudo(){
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
    public JButton getBtnCancelar(){
    	return btnCancelar;
    }
}
