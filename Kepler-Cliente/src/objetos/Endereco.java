package objetos;

public class Endereco {
	private String rua;
	private int numero;
	private String cep;
	private String bairro;
	private String cidade;
	private String estado;

	public Endereco(String rua, int numero, String cep, String bairro,
			String cidade, String estado) {
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;

	}

	public String toString() {
		return (rua + "," + numero + ", CEP:" + cep + "," + bairro + ","
				+ cidade + "," + estado);
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

}
