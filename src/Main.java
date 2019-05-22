import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		double pesoImportacia = 1;
		double pesoRisco = 1;
		double taxaMutacao = 0.15;
		double taxaCruzamento = 0.90;
		double numGeracoes = 300;
		double numPopulacaoInicial = 20;
		int c1 = 3;
		int c2 = 4;
		int c3 = 2;
		
		
//gerando requisitos

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
		GeradorPopulacaoInicial p0 = new GeradorPopulacaoInicial();
		
		List<Integer> ind = new ArrayList<Integer>();
		
		ind = p0.gerarPopulacaoInicial(Requisito.getContadorRequisitos(), Release.getContadorReleases(), requisitos, releases);	
		
		
		
		System.out.println(" ");
		
		System.out.println(p0.fitness(ind, requisitos, releases));
		
		//GeradorRequisitosOrd p1 = new GeradorRequisitosOrd();

		
		//p1.gerarPopulacaoInicial(Requisito.getContadorRequisitos(), Release.getContadorReleases(), requisitos, releases);	
		
	}

}
