module dev.vio.musicui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens dev.vio.musicui to javafx.fxml;
    opens dev.vio.musicui.model;
    exports dev.vio.musicui;
}