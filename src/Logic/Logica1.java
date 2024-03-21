package Logic;

public class Logica1 {
    public boolean  validarIngresos(String ingreso){
        return ingreso != null && !ingreso.equals(null);
    }
    public boolean validarArregloFuncionVectorial(String ingresos[]){
        boolean centinel=false;
        for (int i = 0; i < ingresos.length; i++) {
            if(validarIngresos(ingresos[i])){
                centinel=true;
            }
        }
        return centinel;
    }

    public double calcularLimite(int tendenciaLimite, String funcion){
        double valorIncio=0;
        if(valorIncio<0.1){
            return valorIncio;
        }else {
            valorIncio+=calcularLimite(tendenciaLimite+1,funcion);
            valorIncio+=calcularLimite(tendenciaLimite-1,funcion);
        }
        return valorIncio;
    }

}
