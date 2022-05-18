package locadora;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Locacao {

	String Destino;
	Date DataDaLocacao;
	Date DataDaRetirada;
	Date DataDaDevolucao;
	Carro CarroLocado;
	
	public String getDestino() {
		return Destino;
	}

	public void setDestino(String destino) {
		Destino = destino;
	}

	public Date getDataDaLocacao() {
		return DataDaLocacao;
	}

	public void setDataDaLocacao(Date dataDaLocacao) {
		DataDaLocacao = dataDaLocacao;
	}

	public Date getDataDaRetirada() {
		return DataDaRetirada;
	}

	public void setDataDaRetirada(Date dataDaRetirada) {
		DataDaRetirada = dataDaRetirada;
	}

	public Date getDataDaDevolucao() {
		return DataDaDevolucao;
	}

	public void setDataDaDevolucao(Date dataDaDevolucao) {
		DataDaDevolucao = dataDaDevolucao;
	}

	public Carro getCarroLocado() {
		return CarroLocado;
	}

	public void setCarroLocado(Carro carroLocado) {
		CarroLocado = carroLocado;
	}

	
	Locacao() {

	}

	Locacao(String Destino, Date DataDaLocacao, Date DataDaRetirada, Date DataDaDevolucao, Carro CarroLocado) {

		this.Destino= Destino;
		this.DataDaLocacao = DataDaLocacao ;
		this.DataDaRetirada = DataDaRetirada;
		this.DataDaDevolucao= DataDaDevolucao;
		this.CarroLocado = CarroLocado;			
	}

	@Override
	public String toString() {
		
				
		String dtLocacao = new SimpleDateFormat("dd/MM/yyyy").format(DataDaLocacao);
		
		return  CarroLocado.getModelo() + " - " + CarroLocado.getPlaca() + " - " + Destino + " - " + dtLocacao ;
	}
	
		
}
