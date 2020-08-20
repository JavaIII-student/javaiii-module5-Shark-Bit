package module5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MovieDBView extends Application {

    @Override
    public void start(Stage stage) {

        button.setOnAction(actionEvent -> {
            buttonEvent();
        });

        buildMovieList();

        mainPane.getChildren().addAll(
                tableView,
                new Separator(),
                button
        );

        stage.setTitle("MovieDB");
        Scene scene = new Scene(mainPane,500, 500);
        stage.setScene(scene);
        stage.show();
    }

    private void buildMovieList(){

        tableView = new TableView();

        TableColumn<String, Movie> movieTableColumn = new TableColumn<>("Movie Name");

        movieTableColumn.setCellValueFactory(new PropertyValueFactory<>("movieName"));

        tableView.getColumns().add(movieTableColumn);

    }

    private void buttonEvent(){
        tableView.getItems().add(new Movie("Dune"));
    }

    public static void main(String[] args){
        launch(args);
    }

    private VBox mainPane = new VBox();
    private Button button = new Button("Enter Movie");
    private TableView tableView;
}
