import java.util.Random;

public class Individuo {
	
		public float fitness(int[] individuo, int[] risco, int[] importancia) {

		float fit = 3.4f;
		for (int i = 0; i < individuo.length; i++) {
			fit = (importancia[i] * (individuo.length - individuo[i] + 1) - risco[i]* individuo[i]);
		}
		return fit;
	}

	public void gerarPopulacaoInicial(int contadorRequisitos, int contadorReleases) {

		int[] vetor = null;
		
		 for (int i=0; i < contadorRequisitos; i++) {
			 
			 vetor[i] = 0;
			 
		 }
		 
		 System.out.println(vetor);
	}

	/*

	 */

}
