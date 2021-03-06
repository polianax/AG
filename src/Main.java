import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.Math;

public class Main {

	public static void main(String[] args) {
		
		//parametros da GA
		
		double taxaMutacao = 0;
		double taxaCruzamento = 0.90;
		int numGeracoes = 300;
		int numPopulacaoInicial = 300;
		int c1 = 3;
		int c2 = 4;
		int c3 = 2;
		
		//gerando requisitos e armazenando em uma lista
		
		List<Requisito> requisitos = new ArrayList<Requisito>();
		
		requisitos.add(new Requisito(1, 60, 3, (c1*10+c2*10+c3*5)));
		requisitos.add(new Requisito(2, 40, 6, (c1*8+c2*10+c3*6)));
		requisitos.add(new Requisito(3, 40, 2, (c1*6+c2*4+c3*8)));
		requisitos.add(new Requisito(4, 30, 6, (c1*5+c2*9+c3*1)));
		requisitos.add(new Requisito(5, 20, 4, (c1*7+c2*7+c3*5)));
		requisitos.add(new Requisito(6, 20, 8, (c1*8+c2*6+c3*2)));
		requisitos.add(new Requisito(7, 25, 9, (c1*6+c2*6+c3*4)));
		requisitos.add(new Requisito(8, 70, 7, (c1*9+c2*8+c3*3)));
		requisitos.add(new Requisito(9, 50, 6, (c1*6+c2*7+c3*5)));
		requisitos.add(new Requisito(10, 20, 6, (c1*10+c2*10+c3*7)));
				
		//gerando releases e armazenando em uma lista

		List<Release> releases = new ArrayList<Release>();
		
		releases.add(new Release(125,1));
		releases.add(new Release(125,2));
		releases.add(new Release(125,3));
			
		//gerando populacao inicial e armazenando na populacao
		
		//instanciando solucao
		Solucao p0 = new Solucao();
		
		//gerando lista que ira armazenar as releases sorteadas para cada requisito
		List<Integer> individuo = new ArrayList<Integer>(); 
		
		//gerando lista que ira armazenar os individos que irão compor a população inicial
		List<List> populacao = new ArrayList<List>();
		
		//gerando lista que ira armazenar os fitness de toda a população
		List<Integer> pontuacao = new ArrayList<Integer>();
		
		//gerando populacao inicial
		for (int i=0; i<numPopulacaoInicial; i++){
			individuo = p0.geraPopulacaoInicial(Requisito.getContadorRequisitos(), Release.getContadorReleases(), requisitos, releases);	
			populacao.add(individuo);

		}
		
		int melhorInicial = 0;
		int melhorPosInicial = 0;
		
		//calcula fitness da populacao e armazena na lista		
		for (int i=0; i<numPopulacaoInicial; i++){
			
			int  fit = p0.fitness(populacao.get(i), requisitos, releases);
			pontuacao.add(fit);
			
			if (pontuacao.get(i) > melhorInicial){
				melhorInicial = pontuacao.get(i);
				melhorPosInicial = i;
			}

		}
		
		// imprime informações referente a populacao inicial

		
		System.out.println("*** Melhor solucao incial  -----  Fitness: " + melhorInicial + "     Posicao: " + melhorPosInicial + "    Vetor: " + populacao.get(melhorPosInicial));
				
		
		double numeroSelecao = Math.round((1-taxaCruzamento) * numPopulacaoInicial);
		double numeroFilhos = (numPopulacaoInicial - numeroSelecao)/2;
		double numeroMutacao = Math.round(numPopulacaoInicial * taxaMutacao);

		
		//aqui ocorrem os operadores de cruzamento, mutacao e selecao pelo n�mero de geracoes selecionadas
		for (int i = 0; i < numGeracoes; i++) {
			
			int melhorResultado = 0; //aramazenará o melhor fitness
			int melhorPosicao = 0; //armazenará posição na população referente a melhor solução
			pontuacao.clear(); //limpa a lista de fitness
			for (int y=0; y<numPopulacaoInicial; y++){
				
				int  fitGeracaoAnterior = p0.fitness(populacao.get(y), requisitos, releases);
				pontuacao.add(fitGeracaoAnterior);
				
				if (melhorResultado<pontuacao.get(y)){
					melhorResultado=pontuacao.get(y);
					melhorPosicao = y;
				}
				
			}
			
			//lista que ira armazenar individuos da geracao
			List<List> geracao = new ArrayList<List>();
			
			//lista que ira armazenar pontuação da geracao
			List<Integer> pontuacaoGeracao = new ArrayList<Integer>();

			
			//implementando elitismo
			geracao.add(populacao.get(melhorPosicao));
			
			//for para selecionar os individuos que vão direto para a proxima geracao
			for (int j = 1; j < numeroSelecao; j++) {
			
				
				geracao.add(p0.torneioBinario(pontuacao, populacao));
			}
			
			//laço para cruzar individuos
			for (int k = 0; k < numeroFilhos; k++) {
				
				List<List> filhosSelecionados = new ArrayList<List>();
				filhosSelecionados = p0.cruzamento(p0.torneioBinario(pontuacao, populacao), p0.torneioBinario(pontuacao, populacao));
				//reparando filhos obtidos
				if (p0.validaSolucao(filhosSelecionados.get(0), requisitos, releases)) {
					filhosSelecionados.set(0,filhosSelecionados.get(0));
				} else {
					filhosSelecionados.set(0,p0.reparo(filhosSelecionados.get(0), requisitos, releases));
				}
				if (p0.validaSolucao(filhosSelecionados.get(1), requisitos, releases)) {
					filhosSelecionados.set(1,filhosSelecionados.get(1));
				} else {
					filhosSelecionados.set(1,p0.reparo(filhosSelecionados.get(1), requisitos, releases));
				}
				
			//	filhosSelecionados.set(0,filhosSelecionados.get(0));
			//	filhosSelecionados.set(1,filhosSelecionados.get(1));
				geracao.add(filhosSelecionados.get(0));
				geracao.add(filhosSelecionados.get(1));
				
				}
			
			//realiza a mutacao dos individuos
			for (int z = 0; z < numeroMutacao; z++) {
				List<Integer> individuoMutado = new ArrayList<Integer>();
				Random r = new Random();
				int indiceSorteado = r.nextInt(populacao.size()-1) + 1; //soma 1 por conta do elitismo
				individuoMutado = p0.realizaMutacao(geracao.get(indiceSorteado));
				if (p0.validaSolucao(individuoMutado, requisitos, releases)){
					geracao.set(indiceSorteado, individuoMutado);
				} else {
					geracao.set(indiceSorteado, individuoMutado);
					individuoMutado = p0.reparo(individuoMutado,requisitos,releases);
				}
				
			//	geracao.set(indiceSorteado,p0.realizaMutacao(geracao.get(indiceSorteado)));
			}

			
			System.out.println("*** Melhor Solucao da geracao " + i + "      Fitness: " + melhorResultado + "     Posicao: " + melhorPosicao + "   ' Vetor: " + populacao.get(melhorPosicao));
			
		/*	for (int j=0; j<individuo.size()-1; j++){
				System.out.print(populacao.get(melhorPosicao).get(j) + ", ");
			}
			
			System.out.println(populacao.get(melhorPosicao).get(individuo.size()-1) + "] ");*/

			populacao.clear();
			pontuacao.clear();
			
			populacao = geracao;
			pontuacao = pontuacaoGeracao;
			
			//System.out.println(populacao);
			//System.out.println(pontuacao);
			
		}
		
	}
}
