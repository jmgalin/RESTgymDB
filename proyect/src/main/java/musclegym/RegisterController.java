

package musclegym;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {

    @GetMapping("/registro")
    @ResponseBody
    public String registro(@RequestParam(name="usuario", required=true) String usuario, @RequestParam(name="email", required=true) String email, @RequestParam(name="contrasena", required=true) String contrasena) {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    try {
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dit", "dit", "dit");

        // Verificar si el usuario ya existe en la base de datos
        String query = "SELECT COUNT(*) FROM users WHERE usuario = ?";
        pst = conn.prepareStatement(query);
        pst.setString(1, usuario);
        rs = pst.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            if (count > 0) {
                return "El nombre de usuario no está disponible";
            }
        }

        // Insertar el usuario en la base de datos
        pst = conn.prepareStatement("INSERT INTO users (usuario, email, contrasena) VALUES (?, ?, ?)");
        pst.setString(1, usuario);
        pst.setString(2, email);
        pst.setString(3, contrasena);
        pst.executeUpdate();
        System.out.println("Usuario insertado correctamente.");
        return "Usuario insertado correctamente";
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    return "Usuario no insertado";
}

}

