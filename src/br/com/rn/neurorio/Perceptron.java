package br.com.rn.neurorio;

import java.util.Random;

import br.com.rn.validador.Escada;

public class Perceptron extends Neuronio{

	public Perceptron() {}
	
	public Perceptron(int length, Escada escada) {
		Random rand = new Random();
		this.validador = escada;
		this.wDentritos = new double[length];
		for(int i = 0; i < wDentritos.length; i++) {
			wDentritos[i] = (double) rand.nextInt(10);
		}
		this.theta = (double) rand.nextInt(10);
	}
	
	public void verificaErro(int erro, double fator, int[] entradas) {
		for(int i = 0; i < wDentritos.length; i++) {
			this.wDentritos[i] = this.wDentritos[i] + erro * fator * entradas[i]; 
		}
		this.theta = this.theta - erro * fator;
	}
	
	public int saidaAxionio(int... dentritos) {
		double somatorio = somar(dentritos);
		return validador.validar(somatorio, theta);
	}
	
	private Double somar(int[] dentritos) {
		double resultado = 0;
		System.out.println("w1: " + wDentritos[0]);
		System.out.println("w2: " + wDentritos[1]);
		System.out.println("theta: " + theta);
		for(int i = 0; i < dentritos.length; i++) {
			System.out.println("dentrito: " + dentritos[i]);
			resultado += dentritos[i] * wDentritos[i];
		}
		return resultado;
	}
}
