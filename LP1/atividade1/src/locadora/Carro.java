package locadora;

public class Carro {

	private String chassi;
	private String placa;
	private String num_Motor;
	private String cor;
	private int num_Portas;
	private double odometro;
	private Acessorio acessorio;
	
	public  Carro() {

	}

	
	
	public Carro(String chassi, String placa, String num_Motor, String cor, int num_Portas, double odometro,Acessorio acessorio) {

		this.chassi = chassi;
		this.placa = placa;
		this.num_Motor = num_Motor;
		this.cor = cor;
		this.num_Portas = num_Portas;
		this.odometro = odometro;
		this.acessorio=acessorio;
		
		System.out.println("Carro Criado");
	}
	
	
	

	void Correr(float velocidade) {
	
		System.out.println("Carro correndo a "  + velocidade);
	}

	void Frear() {

		System.out.println("Carro freiando ");
		
	}
	
	public void ListarAcessorios()
	{
		 			
			 System.out.println("Ar condicionado: " + acessorio.isAr_Condicionado());
			 System.out.println("Cambio automatico: " + acessorio.isCambio_Automatico());
			 System.out.println("Direcao Hidraulica: " + acessorio.isDirecao_Hidraulica());
			 System.out.println("Multimidia: " + acessorio.isMultimidia());
			 		
	}

	String getChassi() {
		return chassi;
	}

	void setChassi(String chassi) {
		this.chassi = chassi;
	}

	String getCor() {
		return cor;
	}

	void setCor(String cor) {
		this.cor = cor;
	}

	String getPlaca() {
		return placa;
	}

	void setPlaca(String placa) {
		this.placa = placa;
	}

	String getNum_Motor() {
		return num_Motor;
	}

	void setNum_Motor(String num_Motor) {
		this.num_Motor = num_Motor;
	}

	int getNum_Portas() {
		return num_Portas;
	}

	void setNum_Portas(int num_Portas) {
		this.num_Portas = num_Portas;
	}

	double getOdometro() {
		return odometro;
	}

	void setOdometro(float odometro) {
		this.odometro = odometro;
	}

	Acessorio getAcessorio() {
		return acessorio;
	}

	void setAcessorio(Acessorio acessorio) {
		this.acessorio = acessorio;
	}

}
