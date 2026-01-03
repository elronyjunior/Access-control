module com.controllacess {
    requires javafx.controls;
    requires javafx.fxml;
    requires mslinks;

   
    opens com.controllacess to javafx.fxml;
    // --- ADICIONE ESTA LINHA NOVA ---
    // Isso libera o acesso à pasta "Controller" para o JavaFX funcionar
    opens com.controllacess.Controller to javafx.fxml;

    exports com.controllacess;
    
}