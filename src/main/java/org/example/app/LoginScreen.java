package org.example.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginScreen extends Application {

    @Autowired
    private UsuarioService usuarioService; // Inyecta el servicio de registro de usuarios

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Iniciar Sesión");
        VBox vbox = new VBox();

        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Acceder");
        Button registerButton = new Button("Registrar Nuevo Usuario");

        // Manejar el evento de inicio de sesión cuando se hace clic en el botón "Acceder"
        loginButton.setOnAction(event -> {
            String nombreUsuario = usernameField.getText();
            String contrasena = passwordField.getText();

            // Lógica para autenticar al usuario utilizando el servicio UsuarioService
            if (usuarioService.autenticarUsuario(nombreUsuario, contrasena)) {
                // El usuario ha iniciado sesión correctamente, puedes redirigir a otra pantalla
                mostrarPantallaPrincipal();
            } else {
                // Mostrar un mensaje de error o notificar al usuario que la autenticación ha fallado
                mostrarMensajeError();
            }
        });

        // Manejar el evento del botón "Registrar Nuevo Usuario"
        registerButton.setOnAction(event -> {
            mostrarPantallaRegistro(); // Redirigir a la pantalla de registro
        });

        vbox.getChildren().addAll(new Label("Usuario:"), usernameField, new Label("Contraseña:"), passwordField, loginButton, registerButton);

        Scene scene = new Scene(vbox, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    // Método para mostrar la pantalla principal después del inicio de sesión exitoso
    private void mostrarPantallaPrincipal() {
        // Código para abrir la pantalla principal de la aplicación
    }

    // Método para mostrar un mensaje de error en caso de autenticación fallida
    private void mostrarMensajeError() {
        // Código para mostrar un mensaje de error al usuario
    }

    // Método para mostrar la pantalla de registro de nuevo usuario
    private void mostrarPantallaRegistro() {
        RegistroScreen registroScreen = new RegistroScreen(); // Crea una instancia de la pantalla de registro
        registroScreen.mostrar(); // Abre la pantalla de registro
    }
}
