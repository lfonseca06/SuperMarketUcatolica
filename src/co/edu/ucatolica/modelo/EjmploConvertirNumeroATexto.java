package co.edu.ucatolica.modelo;

public class EjmploConvertirNumeroATexto {

    public static void main(String[] args) {
        int numero = 345567899;
        String texto = NumeroATexto.convertir(numero);
        System.out.println(texto); // Output: "SETECIENTOS OCHENTA Y NUEVE MILLONES CUATROCIENTOS CINCUENTA Y SEIS MIL CIENTO VEINTITRÉS"
    }
}
