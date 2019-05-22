import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Solucao {
	
	public int fitness(List<Integer> individuo, List<Requisito> req, List<Release> rel){
		int fitness = 0;
		for (int i = 0; i < individuo.size() ; i++) {
			int y = 0;
			if (individuo.get(i)>0){
				y = 1;
			}
			fitness = fitness + ( ((req.get(i).getImportancia() * (rel.size()-individuo.get(i)+1)) - (req.get(i).getRisco()*individuo.get(i))) * y);
			
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
		
		return individuo;
		
	}
	
	public List cruzamento(List<List> populacao, int taxaCruzamento){
		int tamanhoIndividuo = populacao.get(0).size();
		Random r = new Random();
		int pontoCorte = r.nextInt(tamanhoIndividuo-2)+1;
		
		
		return populacao;
	}

	public List roleta(List<Integer> pontuacao){
		
		int totalFitness = 0;
		
		for (int i = 0; i < pontuacao.size(); i++) {

			totalFitness = pontuacao.get(i);
		}
		
		Random r = new Random();
		int valorSorteado = r.nextInt(totalFitness);
		
		
		List<Integer> novos = new ArrayList<Integer>();
		
		return novos;
	}

}
