import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FiltrarRegistro extends Funcoes{

    public void filtrar(String caminho){

        String colunas;
        int i = 0;

        try{
            FileWriter novoArquivo = new FileWriter("b3stocks_F1.csv"); //Criação do novo arquivo para escrita
            BufferedReader arq = new BufferedReader(new InputStreamReader(new FileInputStream(caminho))); 
            
            PrintWriter escrever = new PrintWriter(novoArquivo);
            colunas = arq.readLine(); 
            escrever.println(colunas); //Escreve a primeira linha

            Registro[] vetorRegistro = construirConjuntoDinamico(caminho); //Criação do vetor de objetos do tipo Registro
            OrdenarPorData(vetorRegistro);
            
            float maiorVolume = vetorRegistro[0].getVolume();
            int indexMaiorVolume = 0;

            while((i < vetorRegistro.length - 1)) {
                
                if(vetorRegistro[i].getData().equals(vetorRegistro[i+1].getData()) && ((i+1) != vetorRegistro.length-1)){
                    if(vetorRegistro[i+1].getVolume() > maiorVolume){
                        maiorVolume = vetorRegistro[i+1].getVolume();
                        indexMaiorVolume = i+1;
                    }
                }else{
                    escrever.println(vetorRegistro[indexMaiorVolume].toString());
                    maiorVolume = vetorRegistro[i+1].getVolume();
                    indexMaiorVolume = i + 1;
                }

                i++;
            }//Fim do while

            System.out.println("Arquivo \"b3stocks_F1.csv\" criado com sucesso.");

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
