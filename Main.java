package testerl;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.net.URL;


public class Main extends Application
{
    private TestModel Ebase;


    public static void main(String[] args)
    {
        launch(args);
    }


    @Override
    public void start(Stage shell) throws Exception
    {
        URL mainView = getClass().getResource("mainView.fxml");
        Parent root = FXMLLoader.load(mainView);
        Scene main = new Scene(root, 300, 275);
        Ebase = new TestModel();

        if (Ebase.loadBEAM()){
            //INTERFACE DEFINE
            shell.setTitle("TestErl");
            shell.setScene(main);
            shell.initStyle(StageStyle.DECORATED);
            shell.show();
        }
    }

    //TODO: Event-Handlers go here
}