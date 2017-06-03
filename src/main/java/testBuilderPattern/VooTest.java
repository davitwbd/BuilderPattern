package testBuilderPattern;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import builder.VooBuilder;
import model.Passageiro;
import model.Trajeto;
import model.Voo;

/** PADR�O BUILDER: PERMITE CRIA��O PASSO-A-PASSO DE OBJETOS COMPLEXOS USANDO UMA SEQUENCIA DE A��ES. **/
/** OBJETIVO: TESTAR O CALCULO DO VALOR TOTAL DA ARRECADADO DO VOO **/
public class VooTest {

	@Test /** TESTE SEM DESIGN PATTERN **/
	public void deveCalcularValorTotalDaArrecadacao_SemBuildPattern(){
		Trajeto trajeto = new Trajeto();
		trajeto.setOrigem("Rio de Janeiro");
		trajeto.setDestino("S�o Paulo");
		
		Passageiro passageiro1 = new Passageiro();
		passageiro1.setNome("Jo�o");
		passageiro1.setIdade(65);
		
		Passageiro passageiro2 = new Passageiro();
		passageiro2.setNome("Maria");
		passageiro2.setIdade(52);
		
		Passageiro passageiro3 = new Passageiro();
		passageiro3.setNome("Jos�");
		passageiro3.setIdade(36);
		
		Passageiro passageiro4 = new Passageiro();
		passageiro4.setNome("J�lia");
		passageiro4.setIdade(18);
		
		List<Passageiro> passageiros = Arrays.asList(passageiro1,passageiro2,passageiro3,passageiro4);
		
		Voo voo = new Voo();
		voo.setData(LocalDate.of(2017, 12, 25)); 
		voo.setPassageiros(passageiros);
		voo.setTrajeto(trajeto);
		voo.setValorDaPassagem(299.9);
		
		double valorArrecadado =  voo.getValorTotalArrecadado();
		assertEquals(1199.6, valorArrecadado, 0.001);
	}
	
	@Test  /** TESTE COM DESIGN PATTERN BUILDER **/
	public void deveCalcularValorTotalDaArrecadacao(){
		Voo voo = new VooBuilder()
						.addData(LocalDate.of(2017, 12, 25))
						.addPassageiro("Jo�o", 65)
						.addPassageiro("Maria",52)
						.addPassageiro("Jos�", 36)
						.addPassageiro("J�lia",18)
						.addTrajeto("Rio de Janeiro", "S�o Paulo")
						.addValorDaPassagem(299.9)
						.construir();
		
		double valorArrecadado =  voo.getValorTotalArrecadado();
		assertEquals(1199.6, valorArrecadado, 0.001);
	}
	
}
