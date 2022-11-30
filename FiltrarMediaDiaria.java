import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FiltrarMediaDiaria extends Funcoes {
    
    public void filtrarMediaDiaria(String caminho){

        String colunas;
        int i = 0;

        try{
            FileWriter novoArquivo = new FileWriter("b3stocks_T1_Filtrado.csv"); //Criação do novo arquivo para escrita
            BufferedReader arq = new BufferedReader(new InputStreamReader(new FileInputStream(caminho))); 
            
            PrintWriter escrever = new PrintWriter(novoArquivo);
            colunas = arq.readLine(); 
            escrever.println(colunas); //Escreve a primeira linha

            Registro[] vetorRegistro = construirVetorRegistro(caminho);
            OrdenarPorData(vetorRegistro);
            
            float mediaDiaria = 0;
            int indexPrimeiroDia = 0;
            int j = 0;

            while((i < vetorRegistro.length - 1)) {
                
                if(vetorRegistro[i].getData().equals(vetorRegistro[i+1].getData()) && ((i+1) != vetorRegistro.length-1)){
                    mediaDiaria += vetorRegistro[i].getVolume();
                    j++;
                    
                }else{ //Se o proximo dia for diferente, calcula a media diaria e percorre os vetores com o dia atual
                    mediaDiaria += vetorRegistro[i].getVolume();
                    j++;
                    mediaDiaria = mediaDiaria/j;
                    
                    for(int k = indexPrimeiroDia; k <= i; k++){
                        if(vetorRegistro[k].getVolume() > mediaDiaria){
                            escrever.println(vetorRegistro[k].toString());
                        }
                    }
                    indexPrimeiroDia = i+1;
                    j = 0;
                    mediaDiaria = 0;
                }
                i++;
            }//Fim do while

            System.out.println("Arquivo \"b3stocks_T1.csv\" filtrado com sucesso.");

            escrever.close();
            arq.close();
            novoArquivo.close();
        }//Fim do bloco try
        catch(IOException ex){
            System.out.println("Arquivo não encontrado!");
        }//Fim do catch
    
    }//Fim do método filtrar()

    public Registro[] OrdenarPorData(Registro[] vetor){
	    int j;
	    
		for(int k=1; k<vetor.length; k++)   {
            
			Registro key = vetor[k];

			j = k-1;
			while(j>0 && (key.getData().compareTo(vetor[j].getData()) < 0))   {
				vetor[j+1] = vetor[j];
				j = j-1;
			}
			vetor[j+1] = key;
		}
		return vetor; 
	}//Fim do metodo OrdenarPorData()
}
