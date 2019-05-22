	import java.util.List;
	import java.util.Random;
	
public class GeradorRequisitosOrd {



		public void gerarPopulacaoInicial(int contadorRequisitos, int contadorReleases, List<Requisito> req,  List<Release> rel) {

			int[] vetor = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

			rel.get(0).setCusto(125);
			rel.get(1).setCusto(125);
			rel.get(2).setCusto(125);
			
			for (int i = 0; i < contadorRequisitos; i++) {

				vetor[i] = 0;

			}

			// System.out.println(vetor.length);

			for (int i = 0; i < contadorRequisitos; i++) {

				Random r = new Random();

				int releaseSorteada = r.nextInt(contadorReleases) + 1;
				
				if(req.get(i).getCusto() <= rel.get(releaseSorteada-1).getCusto()) {
					vetor[i] = releaseSorteada;
					rel.get(releaseSorteada-1).setCusto(rel.get(releaseSorteada-1).getCusto() - req.get(i).getCusto());
					
				}
				System.out.print(vetor[i] + ", ");
			}
		}
		
		
	}

