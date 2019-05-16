
public class Release {
	
	int custo;
	int indice;
	private static int contadorReleases = 0;
	
	
	public Release(int custo, int indice) {
		super();
		this.custo = custo;
		this.indice = indice;
		contadorReleases ++;
	}


	public int getCusto() {
		return custo;
	}


	public void setCusto(int custo) {
		this.custo = custo;
	}


	public int getIndice() {
		return indice;
	}


	public void setIndice(int indice) {
		this.indice = indice;
	}


	public static int getContadorReleases() {
		return contadorReleases;
	}


	public static void setContadorReleases(int contadorReleases) {
		Release.contadorReleases = contadorReleases;
	}

}
