

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
public class ReservasController {

    @GetMapping("/reservas")
    @ResponseBody
    public List<Reservas> reservas() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Reservas reservas = null;
		List<Reservas> reservasList = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dit", "dit", "dit");
			pst = conn.prepareStatement("SELECT * FROM reservas");
			rs = pst.executeQuery();

			while (rs.next()) {
    		int id = rs.getInt("id");
			String clase = rs.getString("clase");
			String profesor = rs.getString("profesor");
			String lugar = rs.getString("lugar");
			int plazas_disponibles = rs.getInt("plazas_disponibles");
			String fecha_hora = rs.getString("fecha_hora");
			String usuarios_inscritos = rs.getString("usuarios_inscritos");
			reservas = new Reservas(id, clase, profesor, lugar, plazas_disponibles, fecha_hora, usuarios_inscritos);
			reservasList.add(reservas);

			}			
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
        return reservasList;
    }
}

