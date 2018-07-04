package ag;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import trabalhomoa2.AlgoritmoGenetico;

public class Main {

    private static AlgoritmoGenetico ag;
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
        
        ag = new AlgoritmoGenetico(numLinhas, numColunas);
        
        for (int i = 0; i < numColunas; i++) {
            leLinha = buffer.readLine();
            String infoslinha[] = leLinha.split("\\s+");
            
            double custo = Double.parseDouble(infoslinha[2]);
            ag.leCustoPorLinha(i, custo);
           
            for (int j = 3; j < infoslinha.length; j++) {
                ag.leColunasPorLinha(i, Integer.parseInt(infoslinha[j]));
            }
        }
        
    }
}
