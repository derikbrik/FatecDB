package locadora;

public class Carro {

	

	private String chassi;
	private String placa;
	private String num_Motor;
	private String cor;
	private int num_Portas;
	private double odometro;
	private Acessorio acessorio;
	private String Modelo;
	
	
	public String getModelo() {
		return Modelo;
	}


	@Override
	public String toString() {
		return  Modelo  + ", placa=" + placa;
	}

	public Carro(String chassi, String placa, String num_Motor, String cor, int num_Portas, double odometro,
			Acessorio acessorio, String modelo) {
		super();
		this.chassi = chassi;
		this.placa = placa;
		this.num_Motor = num_Motor;
		this.cor = cor;
		this.num_Portas = num_Portas;
		this.odometro = odometro;
		this.acessorio = acessorio;
		Modelo = modelo;
		
		System.out.println("Carro Criado");
	}



	public void setModelo(String modelo) {
		Modelo = modelo;
	}



	public void setOdometro(double odometro) {
		this.odometro = odometro;
	}



	public  Carro() {

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

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getNum_Motor() {
		return num_Motor;
	}

	public void setNum_Motor(String num_Motor) {
		this.num_Motor = num_Motor;
	}

	public int getNum_Portas() {
		return num_Portas;
	}

	public void setNum_Portas(int num_Portas) {
		this.num_Portas = num_Portas;
	}

	public double getOdometro() {
		return odometro;
	}

	public void setOdometro(float odometro) {
		this.odometro = odometro;
	}

	public Acessorio getAcessorio() {
		return acessorio;
	}

	public void setAcessorio(Acessorio acessorio) {
		this.acessorio = acessorio;
	}

}
