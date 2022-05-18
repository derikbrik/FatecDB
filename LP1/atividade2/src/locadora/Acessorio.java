package locadora;

public class Acessorio {

	private boolean ar_condicionado;
	private boolean multimidia;
	private boolean direcao_hidraulica;
	private boolean cambio_automatico;

	public Acessorio() {
	}

	public Acessorio(boolean ar_condicionado, boolean multimidia, boolean direcao_hidraulica,
			boolean cambio_automatico) {
		
		this.ar_condicionado =ar_condicionado;
		this.multimidia=multimidia;
		this.direcao_hidraulica= direcao_hidraulica; 
		this.cambio_automatico=cambio_automatico;		
				
		System.out.println("Acessorio Criado");
	}

	
	public boolean isAr_Condicionado() {
		return ar_condicionado;
	}

	public void setAr_Condicionado(boolean ar_condicionado) {
		this.ar_condicionado = ar_condicionado;
	}

	public boolean isDirecao_Hidraulica() {
		return direcao_hidraulica;
	}

	public void setDirecao_Hidraulica(boolean direcao_Hidraulica) {
		this.direcao_hidraulica = direcao_Hidraulica;
	}

	public boolean isCambio_Automatico() {
		return cambio_automatico;
	}

	public void setCambio_Automatico(boolean cambio_Automatico) {
		this.cambio_automatico = cambio_Automatico;
	}

	public void setMultimidia(boolean multimidia) {
		this.multimidia = multimidia;
	}

	public boolean isMultimidia() {
		return multimidia;
	}
}