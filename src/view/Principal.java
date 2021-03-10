package view;

import java.util.concurrent.Semaphore;

import controller.ThreadSopaCebola;
import controller.ThreadLasanha;

public class Principal {

	public static void main(String[] args) {
		
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int prato = 1; prato < 6; prato++){
			if(prato%2 == 1){
				ThreadSopaCebola tPrato = new ThreadSopaCebola(prato, semaforo);
				tPrato.start();
			} else {
				ThreadLasanha tPrato2 = new ThreadLasanha(prato, semaforo);
				tPrato2.start();
			}
			
			
		}

	}

}