module com.example.aed2_pl_gui {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.aed2_pl_gui to javafx.fxml;
    exports com.example.aed2_pl_gui;
}