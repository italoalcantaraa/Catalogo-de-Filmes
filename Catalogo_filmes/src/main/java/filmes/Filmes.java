package filmes;

public class Filmes {
	private String nome;
	private String url;
	private String classificacao;
	
	public Filmes(String nome, String url, String classificacao) {
		this.nome = nome;
		this.url = url;
		this.classificacao = classificacao;
	}
	
	public Filmes() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

}
