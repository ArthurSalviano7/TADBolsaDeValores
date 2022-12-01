
public class Main extends Funcoes {

    public static void main(String[] args) throws PilhaCheiaException, PilhaVaziaException {
        
        String caminho = "./b3_stocks_1994_2020.csv";
        String caminho2 = "./b3stocks_T1.csv";
        String caminhoTeste = "./b3_stock_teste.csv";
        
        /* 
        TransformarData transformarData = new TransformarData();
        transformarData.transformacao(caminho);

        FiltrarRegistro filtrarRegistro = new FiltrarRegistro();
        filtrarRegistro.filtrar(caminho2);

        FiltrarMediaDiaria filtrarPorMedia = new FiltrarMediaDiaria();
        filtrarPorMedia.filtrarMediaDiaria(caminho2);
        */

        Registro[] baseDeDados = construirConjuntoDinamico(caminho2);
        System.out.println(baseDeDados.length);
        //Registro[] baseDeDados = construirConjuntoDinamico(caminhoTeste); //Vetor menor para testar as ordenações

        
        MergeSort objMergeSort = new MergeSort();
        objMergeSort.gerarMergeSort(baseDeDados);

        HeapSort objHeapSort = new HeapSort();
        objHeapSort.gerarHeapSort(baseDeDados);

        QuickSort objQuickSort = new QuickSort();
        objQuickSort.gerarQuickSort(baseDeDados);

        QuickSortMedianaDe3 objQuickSortMedianaDe3 = new QuickSortMedianaDe3();
        objQuickSortMedianaDe3.gerarQuickSortMed3(baseDeDados);

        InsertionSort objInsertionSort = new InsertionSort();
        objInsertionSort.gerarInsertionSort(baseDeDados);

        SelectionSort objSelectionSort = new SelectionSort();
        objSelectionSort.gerarSelectionSort(baseDeDados);

        CountingSort objCountingSort = new CountingSort();
        objCountingSort.gerarcountingSort(baseDeDados);
        

    }//Fim do main
}