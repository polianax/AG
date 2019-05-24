import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.Math;

public class teste {

	public static void main(String[] args) {
		
		int c1 = 3;
		int c2 = 4;
		int c3 = 2;
		

		Solucao p0 = new Solucao();
		
		List<Integer> pai1 = new ArrayList<Integer>();
		List<Integer> pai2 = new ArrayList<Integer>();
		List<List> filhos = new ArrayList<List>();


		pai1.add(0);
		pai1.add(0);
		pai1.add(0);
		pai1.add(0);
		pai1.add(0);
		pai1.add(0);
		pai1.add(0);
		pai1.add(3);
		pai1.add(1);
		pai1.add(2);
		
		pai2.add(3);
		pai2.add(1); 
		pai2.add(1);
		pai2.add(2);
		pai2.add(2);
		pai2.add(1);
		pai2.add(2);
		pai2.add(0);
		pai2.add(2);
		pai2.add(1);
		
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
		
		filhos = p0.cruzamento(pai1, pai2);
		
	/*	for (int i = 0; i < pai1.size(); i++) {
			System.out.print(filhos.get(0).get(i) + " ");
			System.out.println(filhos.get(1).get(i));
		}*/
		 
		System.out.println("Resultado do reparo: " + p0.reparo(pai1, requisitos, releases));
		
	/*	filhos.set(0, p0.reparo(filhos.get(0), requisitos, releases));
		filhos.set(1, p0.reparo(filhos.get(1), requisitos, releases));

		
		for (int i = 0; i < pai1.size(); i++) {
			System.out.print(filhos.get(0).get(i) +" ");
			System.out.println(filhos.get(1).get(i));
		}*/
	
	}
}
