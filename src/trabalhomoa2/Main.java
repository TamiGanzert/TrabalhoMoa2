package trabalhomoa2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {          
    double SEGUNDOS_ESPERANDO = 2.0;
    int POPULACAO_SIZE = 100;
    double TAXA_MIN_MUTACAO = 0.05;
    int SELECAO_POR_TORNEIO = 5;
    Boolean suppressInfo = false;
    
    static Integer numLinhas = 0;
    static Integer numColunas = 0;
    
    protected void LerArquivoGerarVertices(String arquivo){
        try {               
            BufferedReader in = new BufferedReader(new FileReader(new File(arquivo))); //local do arquivo a ser lido
            String line;
            int numeroLinhas = 0;
            int num_colunas = 0;
                        
            while((line = in.readLine())!=null){
                int id_coluna = 0;
                double custo = 0.0;
                List<Integer> linhasCobertas = new ArrayList();
                ++numeroLinhas;                                                                  
                
                StringTokenizer token = new StringTokenizer(line, " ");
                
                if(numeroLinhas == 1){    
                    numLinhas = Integer.parseInt(token.nextToken());
                    System.out.println(numLinhas);
                }else if(numeroLinhas == 2){
                    numColunas = Integer.parseInt(token.nextToken());                   
                    System.out.println(numColunas);
                }
                else{
                    while(token.hasMoreElements()){
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
      
    public static void main(String[] args) {               
       String arquivo = "casos/teste.txt"; //colocar aqui o caminho do arquivo de teste
        
       Main main = new Main();
       main.LerArquivoGerarVertices(arquivo);
    }
}
