
public class MinhaPilha implements PilhaIF<Registro> {
	
	private int tamanho = 0;
	private Registro[] meusDados;
	private int topo;

	public MinhaPilha(int tamanho) {
		this.tamanho = tamanho;
		this.topo = -1;
		this.meusDados = new Registro[tamanho];
	}
	
	public MinhaPilha() {
	}

	@Override
	public void empilhar(Registro item) throws PilhaCheiaException {
		if (this.topo == tamanho - 1) {
			throw new PilhaCheiaException();
		}
		this.topo++;
		this.meusDados[topo] = item;
	}

	@Override
	public Registro desempilhar() throws PilhaVaziaException {
		if (isEmpty()) {
			throw new PilhaVaziaException();
		}
		Registro numTopo = meusDados[topo];
		this.topo--;
		return numTopo;
	}

	@Override
	public Registro topo() {
		return this.meusDados[topo];
	}

	@Override
	public boolean isEmpty() {
		if (this.topo == -1){
			return true;
		}
		else{
			return false;
		}
	}

}
