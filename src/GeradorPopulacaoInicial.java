import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class GeradorPopulacaoInicial {

	public void gerarPopulacaoInicial(int contadorRequisitos, int contadorReleases, List<Requisito> req,  List<Release> rel) {

		List<Integer> vetor = new ArrayList<Integer>();
		List<Integer> vetorEmbaralhado = new ArrayList<Integer>();
		
		for (int i = 0; i < contadorRequisitos; i++){
			vetor.add(0);
			vetorEmbaralhado.add(i);
		}
		
		//embaralha vetor
		Collections.shuffle(vetorEmbaralhado);
		
		//int[] vetor = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		// System.out.println(vetor.length);

		for (int i = 0; i < contadorRequisitos; i++) {

			Random r = new Random();

			int releaseSorteada = r.nextInt(contadorReleases) + 1;
			
			if(req.get(vetorEmbaralhado.get(i)).getCusto() <= rel.get(releaseSorteada-1).getCusto()) {
				vetor.set(vetorEmbaralhado.get(i), releaseSorteada);
				rel.get(releaseSorteada-1).setCusto(rel.get(releaseSorteada-1).getCusto() - req.get(vetorEmbaralhado.get(i)).getCusto());
				
			}
			System.out.print(vetorEmbaralhado.get(i));
			System.out.println(vetor.get(i) + ", ");
		}
	}
	
	
}
