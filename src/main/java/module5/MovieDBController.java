package module5;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MovieDBController {

    public MovieDBController() {

        StringProperty stringProperty = new SimpleStringProperty();

        IntegerProperty squareSide = new SimpleIntegerProperty();
        IntegerProperty squareArea = new SimpleIntegerProperty();

        NumberBinding squareBinding = Bindings.multiply(squareSide, squareArea);

        squareArea.bind(squareBinding);

        squareArea.bind(squareSide.multiply(squareSide));


    }

}
