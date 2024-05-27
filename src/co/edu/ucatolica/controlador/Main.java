package co.edu.ucatolica.controlador;


import co.edu.ucatolica.vista.*;

public class Main {
    public static void main(String[] args) {
        VentanaPrincipal vistaPrincipal = new VentanaPrincipal();
       

        Controlador controlador = new Controlador(vistaPrincipal);
        
        vistaPrincipal.setVisible(true);
    }
}