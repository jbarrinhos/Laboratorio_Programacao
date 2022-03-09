package fichaExtra;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Navio {
	protected String identificador;
	protected String nome;
	protected Date anoConstrucao;
	protected float comprimento;

	public Navio(String aIdentificador, String aNome, Date aAnoConstrucao, float aComprimento) {
		identificador = aIdentificador;
		nome = aNome;
		anoConstrucao = new Date();
		comprimento = aComprimento;
	}

	public String formatar() {
		// formatar a Data

		SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/YYYY");

		return formatarData.format(anoConstrucao);
	}

	@Override
	public String toString() {
		return "\nnome: " + nome + ", identificador: " + identificador + ",\nanoConstrucao: " + formatar()
				+ ", comprimento: " + comprimento;
	}

	public String getIdentificador() {
		return identificador;
	}

	public String getNome() {
		return nome;
	}

	public Date getAnoConstrucao() {
		return anoConstrucao;
	}

	public float getComprimento() {
		return comprimento;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setAnoConstrucao(Date anoConstrucao) {
		this.anoConstrucao = anoConstrucao;
	}

	public void setComprimento(float comprimento) {
		this.comprimento = comprimento;
	}

}
