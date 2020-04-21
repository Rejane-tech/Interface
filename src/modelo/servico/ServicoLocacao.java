package modelo.servico;

import modelo.entidade.Locacao;
import modelo.entidade.Fatura;

public class ServicoLocacao {

	private Double precoPorDia;
	private Double precoPorHora;

	private TaxServ taxServ;

	public ServicoLocacao(Double precoPorDia, Double precoPorHora, TaxServ taxServ) {
		super();
		this.precoPorDia = precoPorDia;
		this.precoPorHora = precoPorHora;
		this.taxServ = taxServ;
	}


	public void processoFatura(Locacao locacao) {
		long t1 = locacao.getComeco().getTime();
		long t2 = locacao.getFim().getTime();
		double horas = (double) (t2 - t1) / 1000 / 60 / 60;

		double basePag;

		if (horas <= 12.0) {
			basePag = Math.ceil(horas) * precoPorHora;
		} else {
			basePag = Math.ceil(horas / 24) * precoPorDia;

		}

		double taxa = taxServ.taxa(basePag);

		locacao.setFatura(new Fatura(basePag, taxa));

	}
}
