import java.io.*;

public class questao2 {

    public static void main(String[] args) {
        int tamanho = 5;
        String ArqCaminho = "C:\\Users\\Regiana\\IdeaProjects\\ATV03_Recursão2\\src\\dados1.txt";
        String conteudo = read(ArqCaminho);
        String[] teste = new String[tamanho];

        for(int i = 0; i < tamanho;  i++){
            teste[i] = conteudo.split(";") [i];
        }
        String resultado = prefixoComumMaisLongo(teste);
        System.out.print("Entrada 1: "+conteudo);
        System.out.println("Saída 1: O prefixo comum mais longo é "+resultado);

         ArqCaminho = "C:\\Users\\Regiana\\IdeaProjects\\ATV03_Recursão2\\src\\dados2.txt";
         conteudo = read(ArqCaminho);
         teste = new String[tamanho];

        for(int i = 0; i < tamanho;  i++){
            teste[i] = conteudo.split(";") [i];
        }
        resultado = prefixoComumMaisLongo(teste);
        System.out.print("\nEntrada 2: "+conteudo);
        System.out.println("Saída 2: O prefixo comum mais longo é "+resultado);

        ArqCaminho = "C:\\Users\\Regiana\\IdeaProjects\\ATV03_Recursão2\\src\\dados3.txt";
        conteudo = read(ArqCaminho);
        teste = new String[tamanho];

        for(int i = 0; i < tamanho;  i++){
            teste[i] = conteudo.split(";") [i];
        }
        resultado = prefixoComumMaisLongo(teste);
        System.out.print("\nEntrada 3: "+conteudo);
        System.out.println("Saída 3: O prefixo comum mais longo é "+resultado);
    }

    public static String read(String caminho){
        String conteudo = "";
        int contador = 0;
        try {
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha="";
            try {
                linha = lerArq.readLine();
                while(linha!=null){
                    conteudo += linha+"\n";
                    linha = lerArq.readLine();
                }
                arq.close();
                return conteudo;
            } catch (IOException ex) {
                System.out.println("Erro: Não foi possível ler o arquivo!");
                return "";
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo não encontrado!");
            return "";
        }
    }

    public static String prefixoComumMaisLongo(String[] arr){
        if(arr == null || arr.length == 0){
            return "";
        }
        //arr = {"abcdevida", "abcdevida2", "abcdemorte", "abcdequalquercoisa", "abcdeAEDII"};
        String lcp = arr[0];

        for(int i = 1; i < arr.length; i++){

            String atual = arr[i];
            int j = 0;

            while(j < atual.length() && j < lcp.length() && atual.charAt(j) == lcp.charAt(j)){
                j++;
            }

            if(j == 0){
                return "";
            }

            lcp = atual.substring(0, j);
        }
        return lcp;
    }

}
