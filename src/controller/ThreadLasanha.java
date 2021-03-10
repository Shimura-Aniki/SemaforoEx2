package controller;

import java.util.concurrent.Semaphore;

public class ThreadLasanha extends Thread {
	private int prato;
	private Semaphore semaforo;
	
	public ThreadLasanha(int prato, Semaphore semaforo){
		this.prato = prato;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run(){
		cozimento();
		try {
			semaforo.acquire();
			entregaPrato();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void cozimento() {
		int tempoTotal = (int)((Math.random()*6)+6);
		double porcentagem = 0;
		double tempoPorcento = 100/(double) tempoTotal;
		while (porcentagem < 100){
			porcentagem += tempoPorcento;
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("O prato #" + prato + " está " + porcentagem + "% cozido");
		}
		System.out.println("O prato #" + prato + " está pronto");
	}

	private void entregaPrato() {
		try {
			sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("O prato #" + prato + " foi entregue");
	}
}
