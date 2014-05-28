package objetos;

public class Equipe {

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	private String nome;

	public Equipe(String nome) {
		this.nome = nome;
	}

	public String toString() {
		return (nome);
	}

}
