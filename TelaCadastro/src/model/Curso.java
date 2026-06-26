package model;

public class Curso {

    private String nome;
    private String descricao;
    private String conteudo;
    private String duracao;     
    private double valor;
    private int vagasDisponiveis;

    public Curso(String nome, String descricao, String conteudo, String duracao, double valor, int vagasDisponiveis) {
        this.nome = nome;
        this.descricao = descricao;
        this.conteudo = conteudo;
        this.duracao = duracao;
        this.valor = valor;
        this.vagasDisponiveis = vagasDisponiveis;
    }

    public String getNome(){ 
    	return nome;
    }
    public void setNome(String nome){ 
    	this.nome = nome; 
    }
    public String getDescricao(){
    	return descricao;
    }
    public void setDescricao(String descricao){
    	this.descricao = descricao;
    }
    public String getConteudo(){
    	return conteudo;
    }
    public void setConteudo(String conteudo){
    	this.conteudo = conteudo;
    }
    public String getDuracao(){
    	return duracao; 
    }
    public void setDuracao(String duracao){
    	this.duracao = duracao; 
    }
    public double getValor(){
    	return valor; 
    }
    public void setValor(double valor){
    	this.valor = valor; 
    }
    public int getVagasDisponiveis(){ 
    	return vagasDisponiveis; 
    }
    public void setVagasDisponiveis(int vagasDisponiveis){
    	this.vagasDisponiveis = vagasDisponiveis; 
    }
}
