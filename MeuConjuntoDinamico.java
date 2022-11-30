
import java.util.Arrays;

public class MeuConjuntoDinamico implements ConjuntoDinamicoIF<Registro>{

	private Registro[] meusDados = new Registro[4];
	private int posInsercao = 0;
	private int taxaAumento = 25;
	
	public void inserir(Registro item) {
		try{
			meusDados[posInsercao] = item;
			posInsercao++;
		}catch(ArrayIndexOutOfBoundsException ex){
			meusDados = aumentarArray();
			meusDados[posInsercao] = item;
			posInsercao++;
		}		
	}
	
	private Registro[] aumentarArray() {
		int tamanho = meusDados.length + (meusDados.length*taxaAumento/100);
		Registro[] novoArray = new Registro[tamanho];

		for(int i = 0; i < meusDados.length; i++){
			novoArray[i] = meusDados[i];
		}
		return novoArray;
	}

	public void mostrarArray() {
		for(Registro x : meusDados){
			System.out.println(x.toString());
		}
	}

	
	public Registro remover(Registro item) {
		Registro removido = null;
		if(posInsercao == 0){
			throw new UnsupportedOperationException("Conjunto Vazio");
		}else{
			for(int i = 0; i < posInsercao; i++){
				if (meusDados[i] == item){
					removido = meusDados[i];
					meusDados[i] = null;
					break;
				}
		}
		}
		
		return removido;
	}

	public Registro predecessor(Registro item) {
		Registro predecessor = null;
		Boolean achou = false;
		if(posInsercao == 0){
			throw new UnsupportedOperationException("Conjunto Vazio");
		}

		for(int i = 0; i < posInsercao; i++){
			if(meusDados[i] == item){
				achou = true;
				break;
			}
		}

		if(achou){
			int getIndex = Arrays.asList(meusDados).indexOf(item);
			predecessor = meusDados[getIndex - 1];
		}
		else{
			throw new UnsupportedOperationException(item + " não está no conjunto");
		}

		return predecessor;
	}

	
	public Registro sucessor(Registro item) {
		Registro sucessor = null;
		Boolean achou = false;
		
		if(posInsercao == 0){
			throw new UnsupportedOperationException("Conjunto Vazio");
		}

		for(int i = 0; i < posInsercao; i++){
			if(meusDados[i] == item){
				achou = true;
				break;
			}
		}

		if(achou){
			int getIndex = Arrays.asList(meusDados).indexOf(item);
			
			if(meusDados[getIndex+1] == null){
			throw new UnsupportedOperationException("Não possui sucessor");
			}
			sucessor = meusDados[getIndex + 1];
		}
		else{
			throw new UnsupportedOperationException(item + " não está no conjunto");
		}

		return sucessor;
	}

	@Override
	public int tamanho() {
		return meusDados.length;
	}

	public Registro buscar(int item) {
		try{
			return meusDados[item];
		}catch(UnsupportedOperationException ex){
			throw new UnsupportedOperationException("Não Encontrado");
		}
	}

	public Registro[] toArray() {
		int j = 0;
		while(meusDados[j] != null){
			j++;
		}
		Registro[] novoArray = new Registro[j];
		novoArray = meusDados;
		return novoArray;
	}

	@Override
	public float minimum() {
		float menor;

		if(posInsercao == 0){
			throw new UnsupportedOperationException("Conjunto Vazio");
		}else{
			menor = meusDados[0].getVolume();
			for(Registro x : meusDados){
				if(x != null){
					if(x.getVolume() < menor){
						menor = x.getVolume();
					}
				}
				
			}	
		}
		
		return menor;
	}

	@Override
	public float maximum() {
		float maior;

		if(posInsercao == 0){
			throw new UnsupportedOperationException("ConjuntoVazio");
		}else{
			maior = meusDados[0].getVolume();
			for(Registro x : meusDados){
				if(x != null){
					if(x.getVolume() > maior){
						maior = x.getVolume();
					}
				}
				
			}	
		}
		return maior;
	}

}
