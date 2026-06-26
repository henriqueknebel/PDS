package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class CursoTableModel extends AbstractTableModel {

    private ArrayList<Curso> lista;

    private String[] colunas = { "Nome", "Duração", "Valor (R$)", "Vagas" };

    public CursoTableModel(ArrayList<Curso> lista) {
        this.lista = lista;
    }

    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Curso curso = lista.get(linha);

        switch (coluna) {
            case 0: return curso.getNome();
            case 1: return curso.getDuracao();
            case 2: return String.format("%.2f", curso.getValor());
            case 3: return curso.getVagasDisponiveis();
        }
        return null;
    }

    public void atualizar() {
        fireTableDataChanged();
    }
}
