package builder;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Passageiro;
import model.Trajeto;
import model.Voo;

public class VooBuilder {

	private Voo instancia;
	
	public VooBuilder() {
		instancia = new Voo();
	}
	
	public VooBuilder addData(LocalDate data){
		this.instancia.setData(data);
		return this;
	}
	
	public VooBuilder addPassageiro(String nome, int idade){
		if(this.instancia.getPassageiros() == null){
			this.instancia.setPassageiros(new ArrayList<Passageiro>());
		}
		Passageiro passageiro = new Passageiro();
		passageiro.setNome(nome);
		passageiro.setIdade(idade);
		this.instancia.getPassageiros().add(passageiro);
		return this;
	}
	
	public VooBuilder addTrajeto(String origem, String destino){
		if(this.instancia.getTrajeto() == null){
			this.instancia.setTrajeto(new Trajeto());
		}
		this.instancia.getTrajeto().setOrigem(origem);
		this.instancia.getTrajeto().setDestino(destino);
		return this;
	}
	
	public VooBuilder addValorDaPassagem(double valor){
		this.instancia.setValorDaPassagem(valor);
		return this;
	}
	
	public Voo construir(){
		return instancia;
	}
}
