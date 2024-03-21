package model;

import javax.swing.*;

public class outputInputs {

    public void mostrarMensaje(String message) {
        if (message != null) {
            JOptionPane.showMessageDialog(null, message);
        }
    }
    public String obtenerEntrada(String message){
        String prueba=JOptionPane.showInputDialog(null, message);
        if(prueba!=null){
            return prueba;
        }
        return null;
    }
}
