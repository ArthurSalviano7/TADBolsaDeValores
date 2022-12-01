import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Funcoes {
    
    public static String[] separarDados(String linha){  //Separa os dados de cada linha por vírgula e armazena no array
        String valores[] = linha.split(",");

        return valores;
    }//Fim do método separarDados()


    public static Registro[] construirConjuntoDinamico(String caminho){
        Date dataLinha = null;
        String tickerLinha;
        float openLinha;
        float closeLinha;
        float highLinha;
        float lowLinha;
        float volumeLinha;
        String registroLinha;

        String linha = null;
        Registro objetoRegistro = null;

        MeuConjuntoDinamico conjunto = new MeuConjuntoDinamico();

        try{
            BufferedReader arq = new BufferedReader(new InputStreamReader(new FileInputStream(caminho)));

            arq.readLine(); //Desconsidera a primeira linha;

            while((linha = arq.readLine()) != null) {
                
                String arrayDados[] = separarDados(linha);

                try{
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    dataLinha = formatter.parse(arrayDados[0]); 
                }catch(ParseException e){
                    e.printStackTrace();
                }
                
                tickerLinha = arrayDados[1];
                openLinha = Float.parseFloat(arrayDados[2]);
                closeLinha = Float.parseFloat(arrayDados[3]);
                highLinha = Float.parseFloat(arrayDados[4]);
                lowLinha = Float.parseFloat(arrayDados[5]);
                volumeLinha = Float.parseFloat(arrayDados[6]);
                registroLinha = linha;
                
                objetoRegistro = new Registro(dataLinha, tickerLinha, openLinha, closeLinha, highLinha, lowLinha, volumeLinha, registroLinha);
                
                conjunto.inserir(objetoRegistro);
            }//Fim do while
            arq.close();
        }catch(IOException ex){
            System.out.println("Arquivo não encontrado!");
        }//Fim do catch

        //Copia o conjunto dinamico para um vetor com tamanho "preenchido", sem espaços vazios
        Registro[] vetorRegistro = conjunto.toArray();

        return vetorRegistro;
    }//Fim do metodo ConstruirVetorRegistro

    /*Utilização da pilha para construir vetor invertido*/
    public static Registro[] inverterVetorPilha(Registro[] vetor) throws PilhaCheiaException, PilhaVaziaException{
        Registro[] A = new Registro[vetor.length];

        MinhaPilha pilha = new MinhaPilha(1883203);

        for(int i = 0; i < vetor.length; i++){
            pilha.empilhar(vetor[i]);
        }
        for(int i = 0; i < vetor.length; i++){
            A[i] = pilha.desempilhar();
        }
        return A;
    }

    public static void criarArquivo(Registro[] banco, String nomeArquivo){
        int i = 0;
        try{
            FileWriter novoArquivo = new FileWriter(nomeArquivo); //Criação do novo arquivo para escrita            
            PrintWriter escrever = new PrintWriter(novoArquivo);

            escrever.println("datetime,ticker,open,close,high,low,volume");

            while(i < banco.length){
                //System.out.println(i);
                escrever.println(banco[i].toString());
                i++;
            }
            
            escrever.close();
            novoArquivo.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public void troca(Registro vetor[], int i, int j){
        Registro aux = vetor[i]; 
        vetor[i] = vetor[j]; 
        vetor[j] = aux; 
    }
}
