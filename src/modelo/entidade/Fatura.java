package modelo.entidade;

public class Fatura {

	private Double basePag;
	private Double taxa;

	public Fatura() {
	}

	public Fatura(Double basePag, Double taxa) {

		this.basePag = basePag;
		this.taxa = taxa;
	}

	public Double getBasePag() {
		return basePag;
	}

	public void setBasePag(Double basePag) {
		this.basePag = basePag;
	}

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}

	public Double getPagamentoTotal() {
		return getBasePag() + getTaxa();
	}

}
