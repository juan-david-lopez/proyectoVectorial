package model;
import Logic.*;
public class Main {

    public static void main(String[] args) {
        Logica1 logica1 = new Logica1();
        funcionVectorial funcionVecto=crearFuncionVectorial();
        System.out.println(funcionVecto.getTendenciaLimite());
        boolean comprobar=logica1.validarArregloFuncionVectorial(funcionVecto.getFunciones());
        if(comprobar){
            for (int i = 0; i <funcionVecto.getFunciones().length; i++) {
                logica1.calcularLimite(funcionVecto.getTendenciaLimite(),funcionVecto.getFunciones()[i]);
            }

        }else{

        }

        System.out.println(funcionVecto.getLimite());

    }

    public static funcionVectorial  crearFuncionVectorial(){
        outputInputs entradas= new outputInputs();
        Logica1 logica1 = new Logica1();
        String funcion1 = entradas.obtenerEntrada(" por favor ingrese la funcion 1");
        String funcion2 = entradas.obtenerEntrada(" por favor ingrese la funcion 2");
        String funcion3 = entradas.obtenerEntrada(" por favor ingrese la funcion 3");
        int tendenciaLimite = Integer.parseInt(entradas.obtenerEntrada("ingrese el limite al que tienden" +
                " las funciones"));
        String[] funciones = {funcion1,funcion2,funcion3};
        System.out.println( logica1.validarArregloFuncionVectorial(funciones));

        funcionVectorial funcionVecto;
        return funcionVecto = new funcionVectorial(tendenciaLimite,"funcionVectorial1",funciones);

    }


}