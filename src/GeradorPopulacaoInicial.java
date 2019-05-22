import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class GeradorPopulacaoInicial {
	
	public double fitness(List<Integer> individuo, List<Requisito> req, List<Release> rel){
		double fitness = 0;
		for (int i = 0; i < individuo.size() ; i++) {
			int y = 0;
			if (individuo.get(i)>0){
				y = 1;
			}
			fitness = ((req.get(i).getImportancia() * (rel.size()-individuo.get(i)+1)) - (req.get(i).getRisco()*individuo.get(i))) * y;
			
		}
		return fitness;
	}

	public List gerarPopulacaoInicial(int contadorRequisitos, int contadorReleases, List<Requisito> req,  List<Release> rel) {

		List<Integer> individuo = new ArrayList<Integer>();
		List<Integer> vetorEmb = new ArrayList<Integer>();
		
		//gera vetor solução e vetor a ser embaralhado para auxiliar na geração da população inicial
		for (int i = 0; i < contadorRequisitos; i++){
			individuo.add(0);
			vetorEmb.add(i);
		}
		//reinicia o valor das releases
		rel.get(0).setCusto(125);
		rel.get(1).setCusto(125);
		rel.get(2).setCusto(125);
		
		//embaralha vetor
		Collections.shuffle(vetorEmb);

		for (int i = 0; i < contadorRequisitos; i++) {

			Random r = new Random();

			int releaseSorteada = r.nextInt(contadorReleases) + 1;
			
			
			if(req.get(vetorEmb.get(i)).getCusto() <= rel.get(releaseSorteada-1).getCusto()) {
				individuo.set(vetorEmb.get(i),releaseSorteada);
				rel.get(releaseSorteada-1).setCusto(rel.get(releaseSorteada-1).getCusto() - req.get(vetorEmb.get(i)).getCusto());
			}

		}
		
	/*	for(int i = 0; i < contadorRequisitos; i++) {
			System.out.print(vetorEmb.get(i)+ ", ");
			System.out.println(vetor.get(i) + ", ");
			System.out.println(releaseSorteada + ", ");	
		}*/
		return individuo;
		
	}
	
	
}
