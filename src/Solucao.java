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

	public List geraPopulacaoInicial(int contadorRequisitos, int contadorReleases, List<Requisito> req,  List<Release> rel) {

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
	
	public List cruzamento(List<Integer> pai1, List<Integer> pai2){
		List<List> filhos = new ArrayList<List>();
		List<Integer> filho1 = new ArrayList<Integer>();
		List<Integer> filho2 = new ArrayList<Integer>();
		int tamanhoIndividuo = pai1.size();
		Random r = new Random();
		int pontoCorte = r.nextInt(tamanhoIndividuo-1)+1;
	//	int pontoCorte = 3;
		
		
		for (int i = 0; i < pontoCorte ; i++) {
			filho2.add(pai1.get(i));
			filho1.add(pai2.get(i));
		}
		
		for (int j = pontoCorte; j < pai1.size() ; j++) {
			filho2.add(pai2.get(j));
			filho1.add(pai1.get(j));
		}
		
		filhos.add(filho1);
		filhos.add(filho2);
		
		return filhos;
	}

	public List torneioBinario(List<Integer> pontuacao, List<List> populacao){
		
		List<Integer> vencedor = new ArrayList<Integer>();
		
		Random r = new Random();
		int indice1 = r.nextInt(populacao.size());
		int indice2 = r.nextInt(populacao.size());
		
		if (indice1 >= indice2) {
			vencedor = populacao.get(indice1);
		} else{
			vencedor = populacao.get(indice2);
		}
		
		return vencedor;
	}

	//obs: como o reparo so "funciona" para solucoes invalidas, posso chama-lo sempre que realizar um cruzamento ou mutacao
	public List reparo(List<Integer> individuo, List<Requisito> req, List<Release> rel){
		
		int custoR1 = 0;
		int custoR2 = 0;
		int custoR3 = 0;
		rel.get(0).setCusto(125);
		rel.get(1).setCusto(125);
		rel.get(2).setCusto(125);
		List<Integer> requisitosZerados = new ArrayList<Integer>();
		
		//obtendo o custo de cada release e atribuindo zero para o requisito que provocar o estouro da release
		for (int i = 0; i < individuo.size(); i++) {
			
			if (individuo.get(i) == 1) {
				
				if ((custoR1 + req.get(i).getCusto()) > rel.get(0).getCusto()) {
					individuo.set(i, 0);
				} else {
					custoR1 = custoR1 + req.get(i).getCusto();
				}
			} else if (individuo.get(i) == 2) {
				
				
				if ((custoR2 + req.get(i).getCusto()) > rel.get(1).getCusto()) {
					individuo.set(i, 0);
				} else {
					custoR2 = custoR2 + req.get(i).getCusto();
				}
				
			} else if (individuo.get(i) == 3) {
				
				if ((custoR3 + req.get(i).getCusto()) > rel.get(2).getCusto()) {
					individuo.set(i, 0);
				} else {

					custoR3 = custoR3 + req.get(i).getCusto();
				}
			} 
		}
		for (int i = 0; i < individuo.size(); i++) {
			if (individuo.get(i) == 0) {
				requisitosZerados.add(i);
			}
		} 
		//embaralha os requisitos ainda zerados
		Collections.shuffle(requisitosZerados);
		
		for (int r = 0; r < requisitosZerados.size(); r++) {
			Random x = new Random();
			int releaseSorteada = x.nextInt(rel.size());
			if(releaseSorteada == 0){
				if (req.get(requisitosZerados.get(r)).getCusto() <= rel.get(releaseSorteada).getCusto()-custoR1){
					individuo.set(requisitosZerados.get(r), (releaseSorteada+1));
					custoR1 = custoR1 + req.get(r).getCusto(); 
				}
			} else if(releaseSorteada == 1){
				if (req.get(requisitosZerados.get(r)).getCusto() <= rel.get(releaseSorteada).getCusto()-custoR2){
					individuo.set(requisitosZerados.get(r), (releaseSorteada+1));
					custoR2 = custoR2 + req.get(r).getCusto(); 
				}
			} else if(releaseSorteada == 2){
				if (req.get(requisitosZerados.get(r)).getCusto() <= rel.get(releaseSorteada).getCusto()-custoR3){
					individuo.set(requisitosZerados.get(r), (releaseSorteada+1));
					custoR3 = custoR3 + req.get(r).getCusto(); 
				}
			}

		}
		
		return individuo;
	}
	
	public List realizaMutacao (List<Integer> individuo) {
		
		Random r = new Random();
		int releaseSorteada = r.nextInt(4);
		individuo.set(r.nextInt(individuo.size()), releaseSorteada);
		
		return individuo;
	}
	
	public boolean validaSolucao(List<Integer> individuo, List<Requisito> requisitos, List <Release> releases) {
		
		int custoR1 = 0;
		int custoR2 = 0;
		int custoR3 = 0;
		
		for (int j = 0; j < individuo.size(); j++) {
			
			if (individuo.get(j) == 1) {
				custoR1 = custoR1 + requisitos.get(j).getCusto();					
			} else if (individuo.get(j) == 1) {
				custoR2 = custoR2 + requisitos.get(j).getCusto();					
			} else if (individuo.get(j) == 1) {
				custoR3 = custoR3 + requisitos.get(j).getCusto();					
			}
		}
			
		if (custoR1 > releases.get(0).getCusto() && custoR2 > releases.get(1).getCusto() && custoR3 > releases.get(2).getCusto()){
			return true;
		} else {
			return false;
		}
		
	}
}
