
package cinema;

import java.time.LocalTime;

public class Sessao {

    private String codigo;
    private Filme filme;
    private LocalTime horarioInicio;
    private int capacidade;
    private int ingressosVendidos;
    private double valorArrecadado;

    private static double precoIngresso = 20.00;
    

	public Sessao(String codigo, Filme filme, LocalTime horarioInicio,
	              int capacidade) {
	
	    this.codigo = codigo;
	    this.filme = filme;
	    this.horarioInicio = horarioInicio;
	
	    if (capacidade > 0) {
	        this.capacidade = capacidade;
	    } else {
	        this.capacidade = 50;
	    }
	
	    this.ingressosVendidos = 0;
	    this.valorArrecadado = 0.0;
	}
	
	public Sessao(String codigo, Filme filme, LocalTime horarioInicio) {
	    this(codigo, filme, horarioInicio, 50);
	}
	

	public String getCodigo() {
	    return this.codigo;
	}
	
	public Filme getFilme() {
	    return this.filme;
	}
	
	public LocalTime getHorarioInicio() {
	    return this.horarioInicio;
	}
	
	public int getCapacidade() {
	    return this.capacidade;
	}
	
	public int getIngressosVendidos() {
	    return this.ingressosVendidos;
	}
	
	public double getValorArrecadado() {
	    return this.valorArrecadado;
	}


	public int getLugaresDisponiveis() {
	    return this.capacidade - this.ingressosVendidos;
	}
	

	public static double getPrecoIngresso() {
	    return precoIngresso;
	}
	
	public static boolean setPrecoIngresso(double novoPreco) {
	    if (novoPreco > 0) {
	        precoIngresso = novoPreco;
	        return true;
	    }
	
	    return false;
	}

	private double calcularValor(double percentualDesconto) {
	    return precoIngresso * (1 - percentualDesconto / 100);
	}

	public double venderIngresso(int idade) {
	
	    if (idade < 0) {
	        return -1;
	    }
	    if (!filme.podeAssistir(idade)) {
	        return -2;
	    }
	    if (getLugaresDisponiveis() <= 0) {
	        return -3;
	    }
	    double valor = calcularValor(0);
	    ingressosVendidos++;
	    valorArrecadado += valor;
	    return valor;
	}


	public double venderIngresso(int idade, String documento) {
	
	    if (idade < 0 || documento == null || documento.trim().isEmpty()) {
	        return -1;
	    }
	    if (!filme.podeAssistir(idade)) {
	        return -2;
	    }
	    if (getLugaresDisponiveis() <= 0) {
	        return -3;
	    }
	    double valor = calcularValor(50);
	    ingressosVendidos++;
	    valorArrecadado += valor;
	    return valor;
}

	public LocalTime getHorarioTermino() {
	    return horarioInicio.plusMinutes(filme.getDuracao());
	}

}

