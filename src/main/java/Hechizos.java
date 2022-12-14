public class Hechizos {

    String nombre;
    String popularidad;
    String porcentajevictorias;

    public Hechizos(String nombre, String popularidad, String porcentajevictorias) {
        this.nombre = nombre;
        this.popularidad = popularidad;
        this.porcentajevictorias = porcentajevictorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(String popularidad) {
        this.popularidad = popularidad;
    }

    public String getPorcentajevictorias() {
        return porcentajevictorias;
    }

    public void setPorcentajevictorias(String porcentajevictorias) {
        this.porcentajevictorias = porcentajevictorias;
    }
}