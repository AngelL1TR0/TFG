package org.example.app;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.entities.Usuario;
import org.example.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class RegistroScreen {
    @Autowired
    private UsuarioService usuarioService; // Inyecta el servicio de registro de usuarios
    @Autowired
    private PasswordEncoder passwordEncoder; // Inyecta el encoder de contraseñas

    public void mostrar() {
        Stage stage = new Stage();
        stage.setTitle("Registro de Nuevo Usuario");
        VBox vbox = new VBox();

        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();
        TextField emailField = new TextField();
        Button registerButton = new Button("Registrar");

        // Manejar el evento de registro cuando se hace clic en el botón "Registrar"
        registerButton.setOnAction(event -> {
            String nombreUsuario = usernameField.getText();
            String contrasena = passwordField.getText();
            String email = emailField.getText();

            // Lógica para validar los datos del formulario y registrar al nuevo usuario
            if (nombreUsuario.isEmpty() || contrasena.isEmpty() || email.isEmpty()) {
                mostrarAlerta("Campos vacíos", "Por favor, complete todos los campos.");
                return;
            }

            if (usuarioService.existeUsuario(nombreUsuario)) {
                mostrarAlerta("Usuario existente", "El nombre de usuario ya está en uso. Elija otro.");
                return;
            }
            if (usuarioService.existeEmailUsuario(email)) {
                mostrarAlerta("Email ya existente", "El email ya está en uso. Elija otro.");
                return;
            }

            // Encripta la contraseña antes de registrar al usuario
            String contrasenaEncriptada = passwordEncoder.encode(contrasena);

            // Crea un nuevo usuario y almacena la contraseña encriptada
            Usuario nuevoUsuario = new Usuario(null, nombreUsuario, email, contrasenaEncriptada);

            // Llama al servicio para registrar al nuevo usuario
            usuarioService.registrarUsuario(nuevoUsuario);

            // Cierra la ventana de registro
            stage.close();
        });

        vbox.getChildren().addAll(new Label("Usuario:"), usernameField, new Label("Contraseña:"), passwordField, new Label("Email:"), emailField, registerButton);

        Scene scene = new Scene(vbox, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    // Método para mostrar una ventana de alerta
    private void mostrarAlerta(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}

