package com.controllacess.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;

// Importa sua classe que abre o processo
import com.controllacess.Service.GetProcess; 

public class SelectorController {

    @FXML
    protected void onSelecionarArquivo(ActionEvent event) {
        // 1. Pega a janela atual para abrir o seletor na frente dela
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        // 2. Configura o seletor de arquivos
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecione o Executável (.exe)");
        
        // Filtro para mostrar apenas executáveis e atalhos
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Aplicativos", "*.exe", "*.lnk"),
            new FileChooser.ExtensionFilter("Todos os Arquivos", "*.*")
        );

        // 3. Abre a janela e espera o usuário escolher
        File arquivo = fileChooser.showOpenDialog(stage);

        if (arquivo != null) {
            String caminho = arquivo.getAbsolutePath();
            System.out.println("Usuário escolheu: " + caminho);

            try {
                // Tenta abrir e capturar o processo
                Process p = GetProcess.get(caminho);
                
                System.out.println("SUCESSO! O App abriu. PID: " + p.pid());
                
                // Opcional: Fechar logo em seguida se for só para teste
                // p.destroyForcibly(); 

            } catch (IOException e) {
                System.out.println("Erro ao abrir: " + e.getMessage());
            }
        }
    }
}