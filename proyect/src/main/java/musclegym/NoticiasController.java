

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
public class NoticiasController {

    @GetMapping("/noticias")
    @ResponseBody
    public List<Noticias> noticias() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Noticias noticias = null;
		List<Noticias> noticiasList = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dit", "dit", "dit");
			pst = conn.prepareStatement("SELECT * FROM noticias ORDER BY fecha_creacion DESC");
			rs = pst.executeQuery();

			while (rs.next()) {
    		int id = rs.getInt("id");
    		String titulo = rs.getString("titulo");
    		String descripcion = rs.getString("descripcion");
    		noticias = new Noticias(id, titulo, descripcion);
			noticiasList.add(noticias);
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
        return noticiasList;
    }
}

