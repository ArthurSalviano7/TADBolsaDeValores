
public class InsertionSort extends Funcoes {

    public void gerarInsertionSort(Registro[] baseDeDados){

        Registro[] vetor = baseDeDados.clone();

        System.out.println("________________________INSERTION SORT________________________");
        System.out.println();
        System.out.println("ORDEM ALFABETICA:");
        System.out.println("Medio Caso:");
        criarArquivo(insertionSortTicker(vetor), "b3stocks_ticker_insertionSort_medioCaso.csv");
        System.out.println("Arquivo \"b3stocks_ticker_insertionSort_medioCaso.csv\" criado com sucesso.");

        System.out.println("Melhor Caso:");
        criarArquivo(insertionSortTicker(vetor), "b3stocks_ticker_insertionSort_melhorCaso.csv");
        System.out.println("Arquivo \"b3stocks_ticker_insertionSort_melhorCaso.csv\" criado com sucesso.");

        System.out.println("Pior Caso:");
        criarArquivo(insertionSortTicker(inverterVetor(vetor)), "b3stocks_ticker_insertionSort_piorCaso.csv");
        System.out.println("Arquivo \"b3stocks_ticker_insertionSort_piorCaso.csv\" criado com sucesso.");
        
        System.out.println();
        System.out.println("VOLUME:");
        System.out.println();
        System.out.println("Medio Caso:");
        criarArquivo(insertionSortVolume(vetor), "b3stocks_volume_insertionSort_medioCaso.csv");
        System.out.println("Arquivo \"b3stocks_volume_insertionSort_medioCaso.csv\" criado com sucesso.");

        System.out.println("Melhor Caso:");
        criarArquivo(insertionSortVolume(vetor), "b3stocks_volume_insertionSort_melhorCaso.csv");
        System.out.println("Arquivo \"b3stocks_volume_insertionSort_melhorCaso.csv\" criado com sucesso.");

        System.out.println("Pior Caso:");
        criarArquivo(insertionSortVolume(inverterVetor(vetor)), "b3stocks_volume_insertionSort_piorCaso.csv");
        System.out.println("Arquivo \"b3stocks_volume_insertionSort_piorCaso.csv\" criado com sucesso.");

        System.out.println();
        System.out.println("VARIACOES DIARIAS:");
        System.out.println();
        System.out.println("Medio Caso:");
        criarArquivo(insertionSortVariacoes(vetor), "b3stocks_fluctuations_insertionSort_medioCaso.csv");
        System.out.println("Arquivo \"b3stocks_fluctuations_insertionSort_medioCaso.csv\" criado com sucesso.");

        System.out.println("Melhor Caso:");
        criarArquivo(insertionSortVariacoes(vetor), "b3stocks_fluctuations_insertionSort_melhorCaso.csv");
        System.out.println("Arquivo \"b3stocks_fluctuations_insertionSort_melhorCaso.csv\" criado com sucesso.");

        System.out.println("Pior Caso:");
        criarArquivo(insertionSortVariacoes(inverterVetor(vetor)), "b3stocks_fluctuations_insertionSort_piorCaso.csv");
        System.out.println("Arquivo \"b3stocks_fluctuations_insertionSort_piorCaso.csv\" criado com sucesso.");
    }

        public Registro[] insertionSortTicker(Registro[] vetor){
            int j;
            Registro key;
            long inicio = System.currentTimeMillis();
            

            for(int i = 1; i < vetor.length; i++){
                key = vetor[i];
                j = i - 1;

                while(j >= 0 && (key.getTicker().compareTo(vetor[j].getTicker()) < 0)){
                    vetor[j+1] = vetor[j];
                    j--;
                }
                vetor[j+1] = key;
            }
            System.out.println("Ordenação realizada em " + (System.currentTimeMillis() - inicio) + " milissegundos");
        
            return vetor;
        }

        public Registro[] insertionSortVolume(Registro[] vetor){
            int j;
            Registro key;
            long inicio = System.currentTimeMillis();
            

            for(int i = 1; i < vetor.length; i++){
                key = vetor[i];
                j = i - 1;

                while(j >= 0 && key.getVolume() < vetor[j].getVolume()){
                    vetor[j+1] = vetor[j];
                    j--;
                }
                vetor[j+1] = key;
            }
            System.out.println("Ordenação realizada em " + (System.currentTimeMillis() - inicio) + " milissegundos");
        
            return vetor;
        }

        public Registro[] insertionSortVariacoes(Registro[] vetor){
            int j;
            Registro key;
            long inicio = System.currentTimeMillis();
            

            for(int i = 1; i < vetor.length; i++){
                key = vetor[i];
                j = i - 1;

                while(j >= 0 && (key.getHigh() - key.getLow()) > (vetor[j].getHigh() - vetor[j].getLow())){
                    vetor[j+1] = vetor[j];
                    j--;
                }
                vetor[j+1] = key;
            }
            System.out.println("Ordenação realizada em " + (System.currentTimeMillis() - inicio) + " milissegundos");
        
            return vetor;
        }
}
