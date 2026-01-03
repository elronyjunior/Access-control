package com.controllacess;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {
        // Carrega o seu visual (FXML)
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SelectorFolder.fxml"));
        
        // Cria a cena (Janela) com tamanho 400x300
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        
        stage.setTitle("Controle Parental - Seletor");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        // Inicia a aplicação JavaFX
        launch();
    }
}