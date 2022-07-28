package br.unesp.rc.arquivoutils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArquivoUtils {
    
    public static String salvar(String diretorio,String nomeArquivoComExtensao,String conteudo){
        

        String arquivo = diretorio + nomeArquivoComExtensao;
        File file = new File(arquivo);
        if (file.exists()){
            file.delete();
        }
        
        try {
            FileWriter writer = new FileWriter(arquivo, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(conteudo);
            bufferedWriter.close();
            
        } catch (IOException ex) {
            return "Mensagem: " + ex.getMessage();
        }

        return "Arquivo criado com sucesso!";
    }
    
    public static String leitura(String diretorioCompleto) {
        StringBuilder conteudo = new StringBuilder();

        try {
            FileReader reader = new FileReader(diretorioCompleto);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                conteudo.append(line).append("\n");
            }
            reader.close();

        } catch (IOException ex) {
            System.out.println("Mensagem: " + ex.getMessage());
        }
        return conteudo.toString();
    }
    
}

