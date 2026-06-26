package controller;


import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Curso;
import model.CursoTableModel;
import view.JanelaVisualizarCurso;
import view.TelaCadastroCurso;
import view.TelaListagemCurso;

public class CursoController {

    private ArrayList<Curso> lista;

    public CursoController() {
        lista = new ArrayList<Curso>();
    }

    public void abrirTelaCadastro() {

        TelaCadastroCurso tela = new TelaCadastroCurso();

        tela.getBtnSalvar().addActionListener(e -> salvarCadastro(tela));
        tela.getBtnLimpar().addActionListener(e -> tela.limparCampos());
        tela.getBtnVerCursos().addActionListener(e -> abrirTelaListagem(tela));

        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
    }

    private void abrirTelaListagem(TelaCadastroCurso telaAnterior) {

        CursoTableModel tableModel = new CursoTableModel(lista);
        TelaListagemCurso tela = new TelaListagemCurso(tableModel);

        tela.getBtnAdicionar().addActionListener(e -> abrirJanelaAdicionar(tela));
        tela.getBtnRemover().addActionListener(e -> removerSelecionado(tela));
        tela.getBtnVisualizar().addActionListener(e -> abrirJanelaVisualizar(tela));
        tela.getBtnVoltar().addActionListener(e -> voltarParaCadastro(tela));

        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
        telaAnterior.dispose();
    }

    private void salvarCadastro(TelaCadastroCurso tela) {

        String nome = tela.getTxtNome().getText();
        String descricao = tela.getTxtDescricao().getText();
        String conteudo = tela.getTxtConteudo().getText();
        String duracao = tela.getTxtDuracao().getText();
        String valorStr = tela.getTxtValor().getText();
        String vagasStr = tela.getTxtVagas().getText();

        String erro = validar(nome, descricao, conteudo, duracao, valorStr, vagasStr);
        if (erro != null) {
            JOptionPane.showMessageDialog(tela, erro, "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double valor = Double.parseDouble(valorStr.replace(",", "."));
        int    vagas = Integer.parseInt(vagasStr);

        lista.add(new Curso(nome, descricao, conteudo, duracao, valor, vagas));

        JOptionPane.showMessageDialog(tela, "Curso cadastrado com sucesso!", "Sucesso",
                JOptionPane.INFORMATION_MESSAGE);
        tela.limparCampos();
    }

    private void voltarParaCadastro(TelaListagemCurso telaAtual) {
        abrirTelaCadastro();
        telaAtual.dispose();
    }

    private void abrirJanelaAdicionar(TelaListagemCurso telaListagem) {
        JanelaVisualizarCurso janela = criarJanela(telaListagem);
        janela.setTitle("Adicionar Curso");
        janela.setLocationRelativeTo(telaListagem);
        janela.setVisible(true);
    }

    private void removerSelecionado(TelaListagemCurso telaListagem) {

        int linha = telaListagem.getTable().getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(telaListagem, "Selecione um curso para remover.");
            return;
        }

        int resposta = JOptionPane.showConfirmDialog(telaListagem, "Deseja realmente remover este curso?",
        		"Confirmar remoção",JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            lista.remove(linha);
            telaListagem.atualizarTabela();
        }
    }

    private void abrirJanelaVisualizar(TelaListagemCurso telaListagem) {

        int linha = telaListagem.getTable().getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(telaListagem, "Selecione um curso para visualizar.");
            return;
        }

        Curso curso = lista.get(linha);

        JanelaVisualizarCurso janela = criarJanela(telaListagem);
        janela.setLinhaEditando(linha);
        janela.setTitle("Editar Curso");

        janela.getTxtNome().setText(curso.getNome());
        janela.getTxtDescricao().setText(curso.getDescricao());
        janela.getTxtConteudo().setText(curso.getConteudo());
        janela.getTxtDuracao().setText(curso.getDuracao());
        janela.getTxtValor().setText(String.valueOf(curso.getValor()));
        janela.getTxtVagas().setText(String.valueOf(curso.getVagasDisponiveis()));

        janela.setLocationRelativeTo(telaListagem);
        janela.setVisible(true);
    }
    private JanelaVisualizarCurso criarJanela(TelaListagemCurso telaListagem) {
        JanelaVisualizarCurso janela = new JanelaVisualizarCurso();
        janela.getBtnCancelar().addActionListener(e -> janela.dispose());
        janela.getBtnSalvar()  .addActionListener(e -> salvarJanela(janela, telaListagem));
        return janela;
    }

    private void salvarJanela(JanelaVisualizarCurso janela, TelaListagemCurso telaListagem) {

        String nome = janela.getTxtNome().getText();
        String descricao = janela.getTxtDescricao().getText();
        String conteudo = janela.getTxtConteudo().getText();
        String duracao = janela.getTxtDuracao().getText();
        String valorStr = janela.getTxtValor().getText();
        String vagasStr = janela.getTxtVagas().getText();

        String erro = validar(nome, descricao, conteudo, duracao, valorStr, vagasStr);
        if (erro != null) {
            JOptionPane.showMessageDialog(janela, erro, "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double valor = Double.parseDouble(valorStr.replace(",", "."));
        int    vagas = Integer.parseInt(vagasStr);

        int linha = janela.getLinhaEditando();

        if (linha == -1) {
            lista.add(new Curso(nome, descricao, conteudo, duracao, valor, vagas));
        } else {
            Curso curso = lista.get(linha);
            curso.setNome(nome);
            curso.setDescricao(descricao);
            curso.setConteudo(conteudo);
            curso.setDuracao(duracao);
            curso.setValor(valor);
            curso.setVagasDisponiveis(vagas);
        }

        telaListagem.atualizarTabela();
        janela.dispose();
    }
    private String validar(String nome, String descricao, String conteudo,
                            String duracao, String valorStr, String vagasStr) {

        if (nome == null || nome.trim().isEmpty())
            return "O nome do curso é obrigatório.";

        if (descricao == null || descricao.trim().isEmpty())
            return "A descrição do curso é obrigatória.";

        if (conteudo == null || conteudo.trim().isEmpty())
            return "O conteúdo do curso é obrigatório.";

        if (duracao == null || duracao.trim().isEmpty())
            return "A duração é obrigatória.";

        if (!duracao.matches("\\d{1,3}:[0-5]\\d"))
            return "A duração deve estar no formato HH:MM (ex: 02:30).";

        if (valorStr == null || valorStr.trim().isEmpty())
            return "O valor é obrigatório.";

        try {
            double valor = Double.parseDouble(valorStr.replace(",", "."));
            if (valor < 0)
                return "O valor não pode ser negativo.";
        } catch (NumberFormatException e) {
            return "O valor deve ser um número decimal (ex: 199.90 ou 199,90).";
        }

        if (vagasStr == null || vagasStr.trim().isEmpty())
            return "O número de vagas disponíveis é obrigatório.";

        try {
            int vagas = Integer.parseInt(vagasStr);
            if (vagas < 0)
                return "O número de vagas não pode ser negativo.";
        } catch (NumberFormatException e) {
            return "As vagas devem ser um número inteiro (ex: 30).";
        }

        return null;
    }
}
