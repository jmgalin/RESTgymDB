package musclegym;

public class Login {

    private String usuario;
    private String contrasena;
	private String email;

    public Login(String usuario, String contrasena, String email) {
        this.usuario = usuario;
        this.contrasena = contrasena;
		this.email = email;
    }

    // Getters y setters

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

