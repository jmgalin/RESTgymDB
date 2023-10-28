

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
public class LoginController {

    @GetMapping("/login")
    @ResponseBody
    public int login(@RequestParam(name="usuario", required=true) String usuario, @RequestParam(name="contrasena", required=true) String contrasena) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Login login = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dit", "dit", "dit");
            pst = conn.prepareStatement("SELECT * FROM users where usuario=? and contrasena=?");
            pst.setString(1, usuario);
			pst.setString(2, contrasena);
            rs = pst.executeQuery();
            if (rs.next()) {
				String email = rs.getString("email");
                login = new Login(usuario, email, contrasena);
				return 1;
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
        return 0;
    }
}

