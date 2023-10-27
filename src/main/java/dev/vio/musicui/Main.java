package dev.vio.musicui;

import dev.vio.musicui.model.DataSource;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        Controller controller = fxmlLoader.getController();
        controller.listArtists();
        stage.setTitle("Music Database");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void init() throws Exception {
        super.init();
        if(!DataSource.getInstance().open()) {
            System.out.println("FATAL ERROR: Couldn't connect to the database");
            Platform.exit();
        }
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        DataSource.getInstance().close();
    }
}