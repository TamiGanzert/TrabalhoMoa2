package trabalhomoa2;

import java.util.ArrayList;

public class AlgoritmoGenetico {
    
    private static final int TAM_POPULACAO = 1000;
    private static final double TAXA_MIN_MUTACAO = 0.1;
    private static final int NUM_GERACOES = 1000;
    public static final int QTD_TORNEIO = 2;
    
    private final ArrayList<Integer>[] Colunas;
    private final ArrayList<Integer>[] Linhas;
    private final Double[] Custos;
    
    public AlgoritmoGenetico(int nLinha, int nColuna){
        Colunas = new ArrayList[nColuna];
        Linhas = new ArrayList[nLinha];
        Custos = new Double[nColuna];        
    }
    
    public void leCustoPorLinha(int coluna, double custo){
        Custos[coluna] = custo;
    }
    
    public void leColunasPorLinha(int coluna, int linha){
        linha--;
        if (Colunas[coluna] == null) Colunas[coluna] = new ArrayList<>();        
        if (Linhas[linha] == null) Linhas[linha] = new ArrayList<>();
        
        Colunas[coluna].add(linha);
        Linhas[linha].add(coluna);
    }    
}
