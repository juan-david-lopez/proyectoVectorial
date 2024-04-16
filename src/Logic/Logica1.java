package Logic;

import Enums.TiposDefunciones;

import java.text.DecimalFormat;

public class Logica1 {
    public boolean  validarIngresos(String ingreso){
        return ingreso != null && !ingreso.equals(null);
    }
    public boolean validarArregloFuncionVectorial(String[] ingresos){
        boolean centinel=false;
        for (int i = 0; i < ingresos.length; i++) {
            if(validarIngresos(ingresos[i])){
                centinel=true;
            }
        }
        return centinel;
    }

    public double calcularLimite(int tendenciaLimite, String funcion){
        int regulador=0;
        double iteracion=0.1;
        if (funcion.contains("x+")) {
            regulador=-(Integer.parseInt(funcion.substring(funcion.indexOf("+"))));
        }

        int itera=0;
        double limizquir=tendenciaLimite-1;
        double limiderech=tendenciaLimite+1;
        double evaluacion = evaluacion(limizquir,tendenciaLimite,funcion);
        double evaluacion2 =evaluacion(limiderech,tendenciaLimite,funcion);
        while (Math.abs(evaluacion-evaluacion2)>iteracion){
            evaluacion=evaluacion(evaluacion,tendenciaLimite+regulador,funcion);
            evaluacion2=evaluacion(evaluacion2,tendenciaLimite+regulador,funcion);
            itera++;
        }
        System.out.println(itera);
        if(funcion.contains("e(x)")){
            evaluacion2=redondear(tendenciaLimite,evaluacion2,funcion);
        } else if (funcion.contains("x^")) {
            evaluacion2=redondear(tendenciaLimite,evaluacion2,funcion);
            return evaluacion2;
        }
        return evaluacion2;
    }


    public double evaluacion(double tendenciaLimitelado, double tendenciaLimite,String funcion){
        double valorPorItera=((tendenciaLimitelado+tendenciaLimite)/2);
        double evaluacion = evaluarFuncion(valorPorItera,funcion);
        return evaluacion;
    }

    public double evaluarFuncion(double tendenciaLimite, String funcion) {
        double evaluacion=0;
        if(compararFuncion(funcion)){
            if(funcion.contains(""+TiposDefunciones.valueOf("sen"))){
                if(funcion.contains("x^")){
                    evaluacion=Math.sin(Math.pow(tendenciaLimite,Obtenerexponente(funcion)))+siguienteTermino(funcion);
                }else if(ValidarInterno(funcion)>0){
                    evaluacion=Math.sin(tendenciaLimite*ValidarInterno(funcion))+siguienteTermino(funcion);
                }
                else{
                    evaluacion=Math.sin(tendenciaLimite);
                }
            } else if (funcion.contains("cos")) {
                if(funcion.contains("x^")){
                    evaluacion=Math.cos(Math.pow(tendenciaLimite,Obtenerexponente(funcion)))+siguienteTermino(funcion);
                }else if(ValidarInterno(funcion)>0) {
                    evaluacion = Math.cos(tendenciaLimite * ValidarInterno(funcion))+siguienteTermino(funcion);
                }else{
                    evaluacion=Math.cos(tendenciaLimite)+siguienteTermino(funcion);
                }
            } else if (funcion.contains("e")) {
            if(funcion.contains("x^")){
                evaluacion=Math.exp(Math.pow(tendenciaLimite,Obtenerexponente(funcion)))+siguienteTermino(funcion);
            }else if(ValidarInterno(funcion)>0) {
                evaluacion=Math.exp(tendenciaLimite * ValidarInterno(funcion));
            }else {
                evaluacion = Math.exp(tendenciaLimite)+siguienteTermino(funcion);
            }
            } else if (funcion.contains(("tan"))) {
                if(funcion.contains("x^")){
                    evaluacion=Math.tan(Math.pow(tendenciaLimite,Obtenerexponente(funcion)))+siguienteTermino(funcion);
                } else if (ValidarInterno(funcion)>0) {
                    evaluacion=Math.tan(tendenciaLimite * ValidarInterno(funcion));
                }else{
                    evaluacion=Math.tan(tendenciaLimite)+siguienteTermino(funcion);
                }
            } else if (funcion.contains("csc")) {
                if(funcion.contains("x^")){
                    evaluacion=1/Math.sin(Math.pow(tendenciaLimite,Obtenerexponente(funcion))+siguienteTermino(funcion));
                } else if (ValidarInterno(funcion)>0) {
                    evaluacion=1/Math.sin(tendenciaLimite*ValidarInterno(funcion))+siguienteTermino(funcion);
                }else{
                    evaluacion=1/Math.sin(tendenciaLimite)+siguienteTermino(funcion);
                }
            } else if (funcion.contains("cot")) {
                if(funcion.contains("x^")){
                    evaluacion=1/Math.tan(Math.pow(tendenciaLimite,Obtenerexponente(funcion)))+siguienteTermino(funcion);
                } else if (ValidarInterno(funcion)>0) {
                    evaluacion=1/Math.tan(tendenciaLimite*ValidarInterno(funcion))+siguienteTermino(funcion);
                }else {
                    evaluacion=1/Math.tan(tendenciaLimite)+siguienteTermino(funcion);
                }
            } else if (funcion.contains("ln")) {
                evaluacion=Math.log(tendenciaLimite)+siguienteTermino(funcion);
            } else if (funcion.contains("log")) {
                evaluacion=Math.log10(tendenciaLimite)+siguienteTermino(funcion);
            } else if (funcion.contains("sqrt")) {
                evaluacion=Math.sqrt(tendenciaLimite)+siguienteTermino(funcion);
            } else if (funcion.contains("sec")) {
                if(funcion.contains("x^")){
                    evaluacion=1/Math.cos(Math.pow(tendenciaLimite,Obtenerexponente(funcion)))+siguienteTermino(funcion);
                } else if (ValidarInterno(funcion)>0) {
                    evaluacion=1/Math.cos(tendenciaLimite*ValidarInterno(funcion))+siguienteTermino(funcion);
                }else {
                    evaluacion=1/Math.cos(tendenciaLimite)+siguienteTermino(funcion);
                }
            } else if (funcion.contains("x^")) {
                if(Obtenerexponente(funcion)>-1){
                    evaluacion=Math.pow(tendenciaLimite, Obtenerexponente(funcion));
                }

            }else if (funcion.contains("1/x")) {
                evaluacion=1/tendenciaLimite;
            }
            else if(funcion.contains("x") || verficarSolo(funcion)){
                evaluacion=tendenciaLimite+siguienteTermino(funcion);
            } else if (funcion.contains("t") && verficarSolo(funcion)) {
                evaluacion=tendenciaLimite+siguienteTermino(funcion);
            }
        }
        return evaluacion;
    }

    private boolean verficarSolo(String funcion) {
        boolean validar= funcion.length() == 1;
        return validar;
    }

    private int ValidarInterno(String funcion) {
        String prueba=funcion.substring(funcion.indexOf('('), funcion.indexOf(')'));
        char provar= prueba.charAt(prueba.indexOf("x")-1);
        int valor=0;
        try{
            valor = Integer.parseInt(provar+"");
        }catch (Exception e){
            // no es necesario el tratamiento por ahora
        }
        return valor;
    }

    private int siguienteTermino(String funcion) {
        int ubicacionMas=funcion.indexOf('+');
        if(ubicacionMas>=0){
            return Integer.parseInt(funcion.substring(ubicacionMas));
        }
        return 0;
    }

    private int Obtenerexponente(String funcion) {
        String prueba=funcion.substring(funcion.lastIndexOf('(')+1, funcion.lastIndexOf(')'));
        int valo=0;
        try {
            valo=Integer.parseInt(prueba);
        }catch (Exception e){
            System.out.println(prueba);
        }
        return valo;
    }

    private boolean compararFuncion(String funcion) {
        for (int i = 0; i < TiposDefunciones.values().length; i++) {
            if(Comparador(TiposDefunciones.values()[i]+"",funcion)){
                return true;
            }
        }
        return false;
    }

    private boolean Comparador(String value, String funcion) {
        return funcion.contains(value);
    }
    private double redondear(double evaluacion2,double tendenciaLimite, String funcion) {
        String vale="0.00";
        String tiende = ""+Math.round(Math.round(tendenciaLimite));
        String valor= vale+tiende.substring(2);
        if(Obtenerexponente(funcion)>2){
            valor= vale+tiende.substring(3,funcion.length()-1);
        }
        return Double.parseDouble(valor)+evaluarFuncion(evaluacion2,funcion);
    }



}
