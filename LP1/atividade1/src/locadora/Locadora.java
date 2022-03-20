package locadora;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Locadora {
	ArrayList<Locacao> locacoes = new ArrayList<Locacao>();
	
	public static void main(String[] args) throws ParseException {
	
		Locadora locadora = new Locadora();
		
		Acessorio acessorio1 = new Acessorio(true,true,true,true);
		Acessorio acessorio2 = new Acessorio(true,false,true,false);
		
		Carro carro1 = new Carro("11", "QER8118","32332","Cinza",4,12550.4, acessorio1) ;
		Carro carro2 = new Carro("12", "KJN6552","42323","Verde",2,455.4, acessorio2) ;
	
		
		
		locadora.NovaLocacao("Rio de Janeiro","15/05/2022", "17/05/2022","19/05/2022", carro2);
		locadora.NovaLocacao("Taubate","16/05/2022", "21/05/2022","23/05/2022", carro1);
		locadora.NovaLocacao("Sao Paulo","01/05/2022", "09/05/2022","14/05/2022", carro2);
		
		   
		
		locadora.ListarLocacoes();
		
		
	}
	
	
	public void NovaLocacao(String Destino, String DataLocacao, String DataRetirada, String DataDevolucao, Carro carro) throws ParseException
	{
		
		SimpleDateFormat dtFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		Date dataLocacao = dtFormat.parse(DataLocacao);
		Date dataRetirada = dtFormat.parse(DataRetirada);
		Date dataDevolucao = dtFormat.parse(DataDevolucao);
		
		
		locacoes.add(new Locacao(Destino,dataLocacao ,dataRetirada,dataDevolucao, carro));
			
	}
	
	public void ListarLocacoes()
	{
	
		 for (Locacao locacao : locacoes) {
			
			 System.out.println(locacao.CarroLocado.getPlaca() + " " + 
					 			locacao.getDataDaLocacao() + " " + 
					 			locacao.Destino);
			 locacao.CarroLocado.ListarAcessorios();
			 System.out.println("========================");
			 			 
		}
		
	}
	
}
