package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import modelo.entidade.Locacao;
import modelo.entidade.Veiculo;
import modelo.servico.ServicoLocacao;
import modelo.servico.TaxaServicoBrasil;

public class Programa {

	public static void main(String[] args)  throws ParseException {
		
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy HH:ss");
		
		System.out.println("Data de entrada da locacao");
		System.out.print("Modelo carro: ");
		String modeloCarro = sc.nextLine();
		System.out.print("Pickup (dd/MM/yyyy hh:ss):");
		Date comeco = sdf.parse(sc.nextLine());
		System.out.print("Return (dd/MM/yyyy hh:ss):");
		Date fim  = sdf.parse(sc.nextLine());
		
		Locacao cr = new Locacao(comeco, fim, new Veiculo (modeloCarro));
		
		System.out.print("Entra preco por hora: ");
		double precoPorHora = sc.nextDouble();
		System.out.print("Entra preco por dia: ");
		double precoPorDia = sc.nextDouble();
		
		ServicoLocacao servicoLocacao = new ServicoLocacao(precoPorDia, precoPorHora, new TaxaServicoBrasil ());
		
		servicoLocacao.processoFatura(cr);
		
		System.out.println("FATURA : ");
		System.out.println(" Base pagamento: " + String.format("%.2f", cr.getFatura().getBasePag()));
		System.out.println("Taxa: " + String.format("%.2f", cr.getFatura().getTaxa()));
		System.out.println(" Pagamento Total: " + String.format("%2f", cr.getFatura().getPagamentoTotal()));
		
		
	
		
		sc.close ();
	}
}
