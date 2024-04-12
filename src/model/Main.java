package model;
import Logic.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Logica1 logica1 = new Logica1();
        funcionVectorial funcionVecto=crearFuncionVectorial();
        System.out.println(funcionVecto.getTendenciaLimite());
        boolean comprobar=logica1.validarArregloFuncionVectorial(funcionVecto.getFunciones());
        if(comprobar){
            String valMostrar="";
            double[] limites = new double[3];
            for (int i = 0; i <funcionVecto.getFunciones().length; i++) {
                double limite=logica1.calcularLimite(funcionVecto.getTendenciaLimite(),funcionVecto.getFunciones()[i]);
                System.out.println(logica1.evaluarFuncion(funcionVecto.getTendenciaLimite(),funcionVecto.getFunciones()[i]));
                limites[i]= limite;
                valMostrar=valMostrar+" "+limite+" ";
            }
            funcionVecto.setLimite(limites);
            System.out.println(valMostrar);


        }else{
            System.out.println("no cumple con los requisitos");
        }

        System.out.println(Arrays.toString(funcionVecto.getLimite()));

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

        return new funcionVectorial(tendenciaLimite,"funcionVectorial1",funciones);

    }


}