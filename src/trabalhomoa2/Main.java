package trabalhomoa2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {    
    private static final int TAM_POPULACAO = 1000;
    private static final double TAXA_MIN_MUTACAO = 0.1;
    private static final int NUM_GERACOES = 1000;
    public static final int QTD_TORNEIO = 2;
    
    private static List<Integer> Colunas;
    private static List<Integer> Linhas;
    private static Double[] Custos;
    
    private static final String NOME_ARQUIVO = "teste.txt";
    private static int numLinhas = 0;
    private static int numColunas = 0;
    
    public static void main(String[] args) throws IOException {
        lerArquivo(NOME_ARQUIVO);
    }
    
    public static void lerArquivo(String nomeArquivo) throws FileNotFoundException, IOException{
        FileInputStream stream = new FileInputStream(nomeArquivo);
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader buffer = new BufferedReader(reader);
        String leLinha = buffer.readLine();
        
        //Lê numero de linhas
        String leNumLinha = leLinha.substring(leLinha.indexOf(" ")).trim();
        numLinhas = Integer.parseInt(leNumLinha);
        leLinha = buffer.readLine();
        
        //Lê numero de colunas
        String leNumColum = leLinha.substring(leLinha.indexOf(" ")).trim();
        numColunas = Integer.parseInt(leNumColum);                
        buffer.readLine();
        
        inicializaListas(numLinhas, numColunas);
        
        for (int i = 0; i < numColunas; i++) {
            leLinha = buffer.readLine();
            String infoslinha[] = leLinha.split("\\s+");
            
            double custo = Double.parseDouble(infoslinha[2]);
            leCustoPorLinha(i, custo);
           
            for (int j = 3; j < infoslinha.length; j++) {
                leColunasPorLinha(i, Integer.parseInt(infoslinha[j]));
            }
        }        
    }
    
    public static void inicializaListas(int nLinha, int nColuna){
        Colunas = new ArrayList<>();
        Linhas = new ArrayList<>();
        Custos = new Double[numColunas];        
    }
    
    public static void leCustoPorLinha(int coluna, double custo){
        Custos[coluna] = custo;
    }
    
    public static void leColunasPorLinha(int coluna, int linha){
        linha--;
        if (Colunas.get(coluna) == null) Colunas.set(coluna - 1, coluna);        
        if (Linhas.get(linha) == null) Linhas.set(linha);
        
        Colunas.get(coluna).add(linha);
        Linhas.get(linha).add(coluna);        
    }    
}
