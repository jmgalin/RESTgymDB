package musclegym;

public class Reservas {

    private int id;
    private String clase;
	private String profesor;
	private String lugar;
	private int plazas_disponibles;
	private String fecha_hora;
	private String usuarios_inscritos;

    public Reservas(int id, String clase, String profesor, String lugar, int plazas_disponibles, String fecha_hora, String usuarios_inscritos) {
        this.id = id;
        this.clase = clase;
		this.profesor = profesor;
		this.lugar = lugar;
		this.plazas_disponibles = plazas_disponibles;
		this.fecha_hora = fecha_hora;
		this.usuarios_inscritos = usuarios_inscritos;
    }

    // Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getPlazasDisponibles() {
        return plazas_disponibles;
    }

    public void setPlazasDisponibles(int plazas_disponibles) {
        this.plazas_disponibles = plazas_disponibles;
    }

    public String getFechaHora() {
        return fecha_hora;
    }

    public void setFechaHora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getUsuariosInscritos() {
        return usuarios_inscritos;
    }

    public void setUsuariosInscritos(String usuarios_inscritos) {
        this.usuarios_inscritos = usuarios_inscritos;
    }

}

