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
import java.util.*;

@Controller
public class ReservarAulaController {

    @GetMapping("/reservaaula")
    @ResponseBody
    public String reservarAula(@RequestParam(value = "usuario") String usuario, @RequestParam(value = "id") int id) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dit", "dit", "dit");
			pst = conn.prepareStatement("SELECT * FROM reservas WHERE id = ?");
			pst.setInt(1, id);
			rs = pst.executeQuery();

		if (rs.next()) {
    int plazasDisponibles = rs.getInt("plazas_disponibles");
    String usuariosInscritos = rs.getString("usuarios_inscritos");

    // Verificar si el usuario ya está inscrito en la reserva
    if (usuariosInscritos != null && usuariosInscritos.contains(usuario)) {
        return "El usuario ya ha realizado una reserva para esta clase";
    }

    if (plazasDisponibles > 0) {
        plazasDisponibles--;

        // Actualizar la columna usuarios_inscritos para agregar el nuevo usuario
        if (usuariosInscritos == null || usuariosInscritos.isEmpty()) {
            usuariosInscritos = usuario;
        } else {
            usuariosInscritos += "," + usuario;
        }

        pst = conn.prepareStatement("UPDATE reservas SET usuarios_inscritos = ?, plazas_disponibles = ? WHERE id = ?");
        pst.setString(1, usuariosInscritos);
        pst.setInt(2, plazasDisponibles);
        pst.setInt(3, id);
        pst.executeUpdate();

        return "Reserva realizada con éxito";
    } else {
        return "No hay plazas disponibles";
    }
} else {
    return "La reserva no existe";
}

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "Error en la reserva";
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

