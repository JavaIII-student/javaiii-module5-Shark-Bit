package module5;

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.SQLException;

public class MovieDBView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public MovieDBView() throws SQLException {
    }

    public void updateViewTable(String name, String rating, String description){

        tableView.getItems().add(new Movie(name, rating, description));
    }

    public void clearViewTable(){
        tableView.getItems().clear();
    }

    @Override
    public void start(Stage stage) {

        buildDisplayScreen();

        mainPane.getChildren().addAll(
                tableView,
                new Separator(),
                entryPane,
                new Separator(),
                boxPane
        );

        stage.setTitle("MovieDB");
        Scene scene = new Scene(mainPane,800, 500);
        stage.setScene(scene);
        stage.show();
    }

    private void buildDisplayScreen(){

        topName.setCollapsible(false);
        topName.setText("Name");
        topRating.setCollapsible(false);
        topRating.setText("Rating");
        topDes.setCollapsible(false);
        topDes.setText("Description");

        inputName.setPrefWidth(100);
        inputRating.setPrefWidth(50);
        inputDes.setPrefWidth(400);

        entryPane.getChildren().addAll(
                topName,
                inputName,
                new Separator(),
                topRating,
                inputRating,
                new Separator(),
                topDes,
                inputDes
        );
        entryPane.setAlignment(Pos.CENTER);

        boxPane.getChildren().addAll(
                button
        );
        boxPane.setAlignment(Pos.CENTER);


//        entryPane.setAlignment(Pos.CENTER);
//        entryPane.setColumnHalignment(HPos.CENTER);
//        entryPane.setRowValignment(VPos.CENTER);
//        entryPane.setPadding(new Insets(5,0,5,0));
//        entryPane.setVgap(4);
//        entryPane.setHgap(4);
//        entryPane.setPrefWrapLength(5);
//        entryPane.setStyle("-fx-background-color: DAE6F3;");


        tableView = new TableView<>();
        TableColumn<String, Movie> movieTableColumn = new TableColumn<>("Movie Name");
        movieTableColumn.setCellValueFactory(new PropertyValueFactory<>("movieName"));
        tableView.getColumns().add(movieTableColumn);

        TableColumn<String, Movie> ratingTableColumn = new TableColumn<>("Rating");
        ratingTableColumn.setCellValueFactory(new PropertyValueFactory<>("movieRating"));
        tableView.getColumns().add(ratingTableColumn);


        TableColumn<String, Movie> desTableColumn = new TableColumn<>("Description");
        desTableColumn.setCellValueFactory(new PropertyValueFactory<>("movieDes"));
        tableView.getColumns().add(desTableColumn);

        movieTableColumn.setPrefWidth(100);
        ratingTableColumn.setPrefWidth(50);
        desTableColumn.setPrefWidth(400);
//
//        movieTableColumn.prefWidthProperty().bind(movieTableColumn.widthProperty().divide(4)); // w * 1/4
//        ratingTableColumn.prefWidthProperty().bind(movieTableColumn.widthProperty().divide(2)); // w * 1/2
//        desTableColumn.prefWidthProperty().bind(movieTableColumn.widthProperty().divide(4)); // w * 1/4
//

        button.setOnAction(actionEvent -> {
            try {
                buttonEvent();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    private void buttonEvent() throws SQLException {
        movieDBController.addMovie(inputName.getText(),
                inputRating.getText(),
                inputDes.getText(),
                this);

        inputName.clear();
        inputRating.clear();
        inputDes.clear();
    }

    private final VBox mainPane = new VBox();

    private final HBox entryPane = new HBox();
    private final HBox boxPane = new HBox();
    private final Button button = new Button("Enter Movie");
    private TableView tableView;

    final private TitledPane topName = new TitledPane(),
            topRating = new TitledPane(),
            topDes = new TitledPane();

    final private TextField inputName = new TextField(),
            inputRating = new TextField(),
            inputDes = new TextField();

    private final MovieDBController movieDBController = new MovieDBController();
}
