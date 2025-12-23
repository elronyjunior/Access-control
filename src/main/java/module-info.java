module com.controllacess {
    requires javafx.controls;
    requires javafx.fxml;

    // Permite que o JavaFX acesse sua classe principal
    opens com.controllacess to javafx.fxml;
    exports com.controllacess;
}