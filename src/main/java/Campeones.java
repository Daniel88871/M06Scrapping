public class Campeones {

    String nombre;
    String popularidad;
    String porcentajevictorias;
    String porcentajebaneos;
    String kda;
    String pentasporpartida;

    public Campeones(String nombre, String popularidad, String porcentajevictorias, String porcentajebaneos, String kda, String pentasporpartida) {
        this.nombre = nombre;
        this.popularidad = popularidad;
        this.porcentajevictorias = porcentajevictorias;
        this.porcentajebaneos = porcentajebaneos;
        this.kda = kda;
        this.pentasporpartida = pentasporpartida;
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

    public String getPorcentajebaneos() {
        return porcentajebaneos;
    }

    public void setPorcentajebaneos(String porcentajebaneos) {
        this.porcentajebaneos = porcentajebaneos;
    }

    public String getKda() {
        return kda;
    }

    public void setKda(String kda) {
        this.kda = kda;
    }

    public String getPentasporpartida() {
        return pentasporpartida;
    }

    public void setPentasporpartida(String pentasporpartida) {
        this.pentasporpartida = pentasporpartida;
    }
}