package objetos;

public class Industria {
private String nome;
private Endereco endereco;
private String status;

public Industria(String nome, Endereco endereco,String status ){
	this.nome = nome;
	this.endereco = endereco;
	this.status = status;
}




public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public Endereco getEndereco() {
	return endereco;
}
public void setEndereco(Endereco endereco) {
	this.endereco = endereco;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}



}
