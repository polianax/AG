
public class Requisito {

	private int importancia;
	private int custo;
	private int risco;
	private int indice;
	private static int contadorRequisitos = 0;
	
	
	public Requisito(int indice, int custo, int risco, int importancia) {
		super();
		this.importancia = importancia;
		this.custo = custo;
		this.risco = risco;
		this.indice = indice;
		contadorRequisitos ++;
	}
	public static int getContadorRequisitos() {
		return contadorRequisitos;
	}
	public static void setContadorRequisitos(int contadorRequisitos) {
		Requisito.contadorRequisitos = contadorRequisitos;
	}
	public int getIndice() {
		return indice;
	}
	public void setIndice(int indice) {
		this.indice = indice;
	}
	public int getImportancia() {
		return importancia;
	}
	public void setImportancia(int importancia) {
		this.importancia = importancia;
	}
	public int getCusto() {
		return custo;
	}
	public void setCusto(int custo) {
		this.custo = custo;
	}
	public int getRisco() {
		return risco;
	}
	public void setRisco(int risco) {
		this.risco = risco;
	}
	
}
