package Logic;

public class funcionVectorial {
    private String[] funciones;
    private String nombre;
    private double limites[];
    private int tendenciaLimite;

    public funcionVectorial(int tendenciaLimite, String nombre, String[] funciones){
        this.tendenciaLimite=tendenciaLimite;
        this.nombre=nombre;
        this.funciones=funciones;
    }

    public double[] getLimite() {
        return limites;
    }

    public void setLimite(double[] limites) {
        this.limites = limites;
    }

    public int getTendenciaLimite() {
        return tendenciaLimite;
    }

    public void setTendenciaLimite(int tendenciaLimite) {
        this.tendenciaLimite = tendenciaLimite;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String[] getFunciones() {
        return funciones;
    }

    public void setFunciones(String[] funciones) {
        this.funciones = funciones;
    }

}
