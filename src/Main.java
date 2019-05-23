import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		
		double taxaMutacao = 0.15;
		double taxaCruzamento = 0.90;
		double numGeracoes = 300;
		int numPopulacaoInicial = 100;
		int c1 = 3;
		int c2 = 4;
		int c3 = 2;
		
//gerando requisitos
	//	Map<String,Requisito> map = new TreeMap<String,Requisito>();
		
		Requisito r0 = new Requisito(1, 60, 3, (c1*10+c2*10+c3*5));
		Requisito r1 = new Requisito(2, 40, 6, (c1*8+c2*10+c3*6));
		Requisito r2 = new Requisito(3, 40, 2, (c1*6+c2*4+c3*8));
		Requisito r3 = new Requisito(4, 30, 6, (c1*5+c2*9+c3*1));
		Requisito r4 = new Requisito(5, 20, 4, (c1*7+c2*7+c3*5));
		Requisito r5 = new Requisito(6, 20, 8, (c1*8+c2*6+c3*2));
		Requisito r6 = new Requisito(7, 25, 9, (c1*6+c2*6+c3*4));
		Requisito r7 = new Requisito(8, 70, 7, (c1*9+c2*8+c3*3));
		Requisito r8 = new Requisito(9, 50, 6, (c1*6+c2*7+c3*5));
		Requisito r9 = new Requisito(10, 20, 6, (c1*10+c2*10+c3*7));
		
		/*map.put("r0", r0);
		map.put("r1", r0);
		map.put("r2", r0);
		map.put("r3", r0);
		map.put("r4", r0);
		map.put("r5", r0);
		map.put("r6", r0);
		map.put("r7", r0);
		map.put("r8", r0);
		
		for (int i = 0; i < 100; i++) {
			map.put("r"+i,  new Requisito(7, 25, 9, (c1*6+c2*6+c3*4)));
		}
		
		for (int i = 0; i < 100; i++) {
			Requisito r = map.get("r"+i);
		}*/
		
		List<Requisito> requisitos = new ArrayList<Requisito>();
		
		requisitos.add(r0);
		requisitos.add(r1);
		requisitos.add(r2);
		requisitos.add(r3);
		requisitos.add(r4);
		requisitos.add(r5);
		requisitos.add(r6);
		requisitos.add(r7);
		requisitos.add(r8);
		requisitos.add(r9);
				
//gerando releases
		
		Release k1 = new Release(125,1);
		Release k2 = new Release(125,2);
		Release k3 = new Release(125,3);
		
		List<Release> releases = new ArrayList<Release>();
		
		releases.add(k1);
		releases.add(k2);
		releases.add(k3);
	
		
//gerando populacao inicial
		
		//Individuo.gerarPopulacaoInicial(2,3);
		Solucao p0 = new Solucao();
		
		List<Integer> individuo = new ArrayList<Integer>();
		
		List<List> populacao = new ArrayList<List>();
		
		List<Integer> pontuacao = new ArrayList<Integer>();
		
		for (int i=0; i<numPopulacaoInicial; i++){
			individuo = p0.gerarPopulacaoInicial(Requisito.getContadorRequisitos(), Release.getContadorReleases(), requisitos, releases);	
			populacao.add(individuo);

		}
		
		//calcula fitness da populacao
		
		for (int i=0; i<numPopulacaoInicial; i++){
			
			int  fit = p0.fitness(populacao.get(i), requisitos, releases);
			pontuacao.add(fit);

		}
			
		System.out.println(" ");
		
		int melhorResultado = 0;
		int melhorPosicao = 0;
		
		//System.out.println(p0.fitness(individuo, requisitos, releases));
		for (int i=0; i<numPopulacaoInicial; i++){
			System.out.print("[");
			for (int j=0; j<individuo.size()-1; j++){
				System.out.print(populacao.get(i).get(j) + ", ");
			}
			System.out.println(populacao.get(i).get(individuo.size()-1) + "]");
			System.out.println("Fitness: " + pontuacao.get(i));
			System.out.println("-----------------------");
			
			if (melhorResultado<pontuacao.get(i)){
				melhorResultado=pontuacao.get(i);
				melhorPosicao = i;
			}
			
		}
		
		System.out.println("************ Melhor Solução:" + melhorResultado + " Posição: " + melhorPosicao);
		
		for (int j=0; j<individuo.size(); j++){
			System.out.print(populacao.get(melhorPosicao).get(j) + ", ");
		}
		
		
	/*	System.out.print("Fitness: [");
		for (int i=0; i<numPopulacaoInicial-1; i++){
			
				System.out.println(pontuacao.get(i)+ ", ");

		}
		System.out.print( pontuacao.get(numPopulacaoInicial-1));*/
	}
}
