module com.example.polynomialsetup {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.polynomialsetup to javafx.fxml;
    exports com.example.polynomialsetup;
}