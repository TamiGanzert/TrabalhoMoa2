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
            int lineCount = 0;
            
            while((line = in.readLine())!=null){
                List<Integer> linhasCobertas = new ArrayList();
                ++lineCount;                                                                  
                int controle = 0;
                StringTokenizer token = new StringTokenizer(line, " ");
                
                if(lineCount == 1){    
                    numLinhas = Integer.parseInt(token.nextToken());
                    System.out.println(numLinhas);
                }else if(lineCount == 2){
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
       String arquivo = "casos/teste1.txt"; //colocar aqui o caminho do arquivo de teste
        
       if(argv >= 3){
        POPULACAO_SIZE = strtoul(argc[2], NULL, 10);
       }

       if(argv >= 4){
        TAXA_MIN_MUTACAO = strtod(argc[3], NULL);
       }

       if(argv >= 5){
        SEGUNDOS_ESPERANDO = strtod(argc[4], NULL);
       }
       
       Main main = new Main();
       main.LerArquivoGerarVertices(arquivo);
    }
}
