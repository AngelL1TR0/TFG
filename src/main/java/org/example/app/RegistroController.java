package org.example.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.example.entities.Usuario;
import org.example.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

@Controller
public class RegistroController {

    @FXML
    private TextField nombreUsuarioField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField contrasenaField;

    @Autowired
    private UsuarioService usuarioService; // Inyecta el servicio de registro de usuarios

    @Autowired
    private PasswordEncoder passwordEncoder; // Inyecta el encoder de contraseñas

    // Método para manejar el evento de registro de usuario
    @FXML
    protected void registrarUsuario(ActionEvent event) {
        String nombreUsuario = nombreUsuarioField.getText();
        String contrasena = contrasenaField.getText();
        String email = emailField.getText();

        // Lógica para validar los datos del formulario (por ejemplo, verificar si el nombre de usuario ya existe)
        if (nombreUsuario.isEmpty() || contrasena.isEmpty() || email.isEmpty()) {
            mostrarAlerta("Campos vacíos", "Por favor, complete todos los campos.");
            return;
        }

        if (usuarioService.existeUsuario(nombreUsuario)) {
            mostrarAlerta("Usuario existente", "El nombre de usuario ya está en uso. Elija otro.");
            return;
        }
        if (usuarioService.existeEmailUsuario(email)) {
            mostrarAlerta("email ya existente", "El email ya está en uso. Elija otro.");
            return;
        }


        // Encripta la contraseña antes de registrar al usuario
        String contrasenaEncriptada = passwordEncoder.encode(contrasena);

        // Crea un nuevo usuario y almacena la contraseña encriptada
        Usuario nuevoUsuario = new Usuario(null, nombreUsuario, email, contrasenaEncriptada);

        // Llama al servicio para registrar al nuevo usuario
        usuarioService.registrarUsuario(nuevoUsuario);

        // Lógica para mostrar un mensaje de éxito o redirigir a otra pantalla
        mostrarAlerta("Registro exitoso", "El usuario ha sido registrado con éxito.");
        limpiarCampos();
    }

    // Método para mostrar una ventana de alerta
    private void mostrarAlerta(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    // Método para limpiar los campos del formulario después del registro
    private void limpiarCampos() {
        nombreUsuarioField.clear();
        contrasenaField.clear();
    }
}
