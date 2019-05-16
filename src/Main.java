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
				
//gerando releases
		
		Release k0 = new Release(125,1);
		Release k1 = new Release(125,2);
		Release k2 = new Release(125,3);
	
		
//gerando populacao inicial
		
		Individuo
		

	}

}
