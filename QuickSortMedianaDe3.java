public class QuickSortMedianaDe3 extends Funcoes {

    public void gerarQuickSortMed3(Registro[] baseDeDados){

        Registro[] vetor = baseDeDados.clone();

        System.out.println();
        System.out.println("________________________QUICK SORT COM MEDIANA DE 3________________________");
        System.out.println();
        System.out.println("ORDEM ALFABETICA:");
        System.out.println("Medio Caso:");
        criarArquivo(QuickSortMed3TickerTempo(vetor), "b3stocks_ticker_quickSortMediana3_medioCaso.csv");
        System.out.println("Arquivo \"b3stocks_ticker_quickSortMediana3_medioCaso.csv\" criado com sucesso.");

        System.out.println("Melhor Caso:");
        criarArquivo(QuickSortMed3TickerTempo(vetor), "b3stocks_ticker_quickSortMediana3_melhorCaso.csv");
        System.out.println("Arquivo \"b3stocks_ticker_quickSortMediana3_melhorCaso.csv\" criado com sucesso.");

        System.out.println("Pior Caso:");
        criarArquivo(QuickSortMed3TickerTempo(inverterVetor(vetor)), "b3stocks_ticker_quickSortMediana3_piorCaso.csv");
        System.out.println("Arquivo \"b3stocks_ticker_quickSortMediana3_piorCaso.csv\" criado com sucesso.");
    
        System.out.println();
        System.out.println("VOLUME:");
        System.out.println("Medio Caso:");
        criarArquivo(QuickSortMed3VolumeTempo(vetor), "b3stocks_volume_quickSortMediana3_medioCaso.csv");
        System.out.println("Arquivo \"b3stocks_volume_quickSortMediana3_medioCaso.csv\" criado com sucesso.");

        System.out.println("Melhor Caso:");
        criarArquivo(QuickSortMed3VolumeTempo(vetor), "b3stocks_volume_quickSortMediana3_melhorCaso.csv");
        System.out.println("Arquivo \"b3stocks_volume_quickSortMediana3_melhorCaso.csv\" criado com sucesso.");

        System.out.println("Pior Caso:");
        criarArquivo(QuickSortMed3VolumeTempo(inverterVetor(vetor)), "b3stocks_volume_quickSortMediana3_piorCaso.csv");
        System.out.println("Arquivo \"b3stocks_volume_quickSortMediana3_piorCaso.csv\" criado com sucesso.");

        System.out.println();
        System.out.println("VARIACOES DIARIAS:");
        System.out.println("Medio Caso:");
        criarArquivo(QuickSortMed3VariacoesTempo(vetor), "b3stocks_fluctuations_quickSortMediana3_medioCaso.csv");
        System.out.println("Arquivo \"b3stocks_fluctuations_quickSortMediana3_medioCaso.csv\" criado com sucesso.");

        System.out.println("Melhor Caso:");
        criarArquivo(QuickSortMed3VariacoesTempo(vetor), "b3stocks_fluctuations_quickSortMediana3_melhorCaso.csv");
        System.out.println("Arquivo \"b3stocks_fluctuations_quickSortMediana3_melhorCaso.csv\" criado com sucesso.");

        System.out.println("Pior Caso:");
        criarArquivo(QuickSortMed3VariacoesTempo(inverterVetor(vetor)), "b3stocks_fluctuations_quickSortMediana3_piorCaso.csv");
        System.out.println("Arquivo \"b3stocks_fluctuations_quickSortMediana3_piorCaso.csv\" criado com sucesso.");
    }

        public Registro[] QuickSortMed3TickerTempo(Registro[] vetor){
            long inicio = System.currentTimeMillis();

            MedianaDe3Ticker(vetor, 0, (int)(vetor.length-1)/2, vetor.length-1);
            

            QuickSortTicker(vetor, 0, vetor.length-1);
            System.out.println("Ordenação realizada em " + (System.currentTimeMillis() - inicio) + " milissegundos");

            return vetor;
        }

        public Registro[] MedianaDe3Ticker(Registro[] vetor, int inicio, int meio, int fim){

            if ((vetor[inicio].getTicker().compareTo(vetor[meio].getTicker()) > 0)){ //vetor[inicio] é maior, pois vem depois do vetor[meio]
                troca(vetor, inicio, meio);
            }
            if (vetor[inicio].getTicker().compareTo(vetor[fim].getTicker()) > 0){
                troca(vetor, inicio, fim);
            }
            if (vetor[meio].getTicker().compareTo(vetor[fim].getTicker()) > 0){
                troca(vetor, meio, fim);
            }
                
            troca(vetor, meio, fim); //Coloca o pivo no fim do array
            return vetor;
        }

        public Registro[] QuickSortTicker(Registro[] vetor, int inicio, int fim){
            int pivo;

            if(inicio < fim){
                pivo = PartitionTicker(vetor, inicio, fim);

                QuickSortTicker(vetor, inicio, pivo - 1);
                QuickSortTicker(vetor, pivo + 1, fim);
            }
            return vetor;
        }

        public int PartitionTicker(Registro A[], int inicio, int fim){        
            Registro pivo = A[fim];
            int i = inicio - 1;
    
            for(int j = inicio; j <= fim - 1; j++){
                if((A[j].getTicker().compareTo(pivo.getTicker()) < 0)){
                    i++;
                    troca(A, i, j);
                }
            }
            troca(A, i + 1, fim);
    
            return i+1;
        }

        public Registro[] QuickSortMed3VolumeTempo(Registro[] vetor){
            long inicio = System.currentTimeMillis();

            MedianaDe3Volume(vetor, 0, (vetor.length-1)/2, vetor.length-1);

            QuickSortVolume(vetor, 0, vetor.length-1);
            System.out.println("Ordenação realizada em " + (System.currentTimeMillis() - inicio) + " milissegundos");

            return vetor;
        }

        public Registro[] MedianaDe3Volume(Registro[] vetor, int inicio, int meio, int fim){

            if ((vetor[inicio].getVolume() > vetor[meio].getVolume())){ //vetor[inicio] é maior, pois vem depois do vetor[meio]
                troca(vetor, inicio, meio);
            }
            if (vetor[inicio].getVolume() > vetor[fim].getVolume()){
                troca(vetor, inicio, fim);
            }
            if (vetor[meio].getVolume() > vetor[fim].getVolume()){
                troca(vetor, meio, fim);
            }
                
            troca(vetor, meio, fim); //Coloca o pivo no fim do array
            return vetor;
        }

        public Registro[] QuickSortVolume(Registro[] vetor, int inicio, int fim){
            int pivo;

            if(inicio < fim){
                pivo = PartitionVolume(vetor, inicio, fim);

                QuickSortVolume(vetor, inicio, pivo - 1);
                QuickSortVolume(vetor, pivo + 1, fim);
            }
            return vetor;
        }

        public int PartitionVolume(Registro A[], int inicio, int fim){        
            Registro pivo = A[fim];
            int i = inicio - 1;
    
            for(int j = inicio; j <= fim - 1; j++){
                if(A[j].getVolume() < pivo.getVolume()){
                    i++;
                    troca(A, i, j);
                }
            }
            troca(A, i + 1, fim);
    
            return i+1;
        }


        public Registro[] QuickSortMed3VariacoesTempo(Registro[] vetor){
            long inicio = System.currentTimeMillis();

            MedianaDe3Variacoes(vetor, 0, (vetor.length-1)/2, vetor.length-1);

            QuickSortVariacoes(vetor, 0, vetor.length-1);
            System.out.println("Ordenação realizada em " + (System.currentTimeMillis() - inicio) + " milissegundos");

            return vetor;
        }

        public Registro[] MedianaDe3Variacoes(Registro[] vetor, int inicio, int meio, int fim){

            if (((vetor[inicio].getHigh() - vetor[inicio].getLow()) > (vetor[meio].getHigh() - vetor[meio].getLow()))){ //vetor[inicio] é maior, pois vem depois do vetor[meio]
                troca(vetor, inicio, meio);
            }
            if (((vetor[inicio].getHigh() - vetor[inicio].getLow()) > (vetor[fim].getHigh() - vetor[fim].getLow()))){
                troca(vetor, inicio, fim);
            }
            if (((vetor[meio].getHigh() - vetor[meio].getLow()) > (vetor[fim].getHigh() - vetor[fim].getLow()))){
                troca(vetor, meio, fim);
            }
                
            troca(vetor, meio, fim); //Coloca o pivo no fim do array
            return vetor;
        }

        public Registro[] QuickSortVariacoes(Registro[] vetor, int inicio, int fim){
            int pivo;

            if(inicio < fim){
                pivo = PartitionVariacoes(vetor, inicio, fim);

                QuickSortVariacoes(vetor, inicio, pivo - 1);
                QuickSortVariacoes(vetor, pivo + 1, fim);
            }
            return vetor;
        }

        public int PartitionVariacoes(Registro A[], int inicio, int fim){        
            Registro pivo = A[fim];
            int i = inicio - 1;
    
            for(int j = inicio; j <= fim - 1; j++){
                if(((A[j].getHigh() - A[j].getLow()) > (pivo.getHigh() - pivo.getLow()))){
                    i++;
                    troca(A, i, j);
                }
            }
            troca(A, i + 1, fim);
    
            return i+1;
        }
}
