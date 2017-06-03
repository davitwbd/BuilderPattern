package model;

import java.time.LocalDate;
import java.util.List;

public class Voo {
	
	private LocalDate data;
	private List<Passageiro> passageiros;
	private Trajeto trajeto;
	private double valorDaPassagem;
	private double valorTotalArrecadado;
	
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public List<Passageiro> getPassageiros() {
		return passageiros;
	}
	public void setPassageiros(List<Passageiro> passageiros) {
		this.passageiros = passageiros;
	}
	public Trajeto getTrajeto() {
		return trajeto;
	}
	public void setTrajeto(Trajeto trajeto) {
		this.trajeto = trajeto;
	}
	public double getValorDaPassagem() {
		return valorDaPassagem;
	}
	public void setValorDaPassagem(double valorDaPassagem) {
		this.valorDaPassagem = valorDaPassagem;
	}
	
	public double getValorTotalArrecadado() {
		this.valorTotalArrecadado = this.valorDaPassagem * passageiros.size();
		return valorTotalArrecadado;
	}
}
