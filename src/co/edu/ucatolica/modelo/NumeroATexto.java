package co.edu.ucatolica.modelo;

public class NumeroATexto {

    private static final String[] UNIDADES = {
            "", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve",
            "diez", "once", "doce", "trece", "catorce", "quince", "dieciséis", "diecisiete", "dieciocho", "diecinueve",
            "veinte", "veintiuno", "veintidós", "veintitrés", "veinticuatro", "veinticinco", "veintiséis", "veintisiete", "veintiocho", "veintinueve"
    };

    private static final String[] DECENAS = {
            "", "", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"
    };

    private static final String[] CENTENAS = {
            "", "cien", "doscientos", "trescientos", "cuatrocientos", "quinientos", "seiscientos", "setecientos", "ochocientos", "novecientos"
    };

    public static String convertir(int numero) {
        if (numero == 0) {
            return "CERO";
        }

        String resultado;

        if (numero < 30) {
            resultado = UNIDADES[numero];
        } else if (numero < 100) {
            int unidad = numero % 10;
            int decena = numero / 10;
            if (unidad == 0) {
                resultado = DECENAS[decena];
            } else {
                resultado = DECENAS[decena] + " y " + UNIDADES[unidad];
            }
        } else if (numero < 1000) {
            int centena = numero / 100;
            int resto = numero % 100;
            if (resto == 0) {
                resultado = CENTENAS[centena];
            } else if (centena == 1 && resto < 30) {
                resultado = "ciento " + convertir(resto);
            } else {
                resultado = CENTENAS[centena] + " " + convertir(resto);
            }
        } else if (numero < 1000000) {
            int miles = numero / 1000;
            int resto = numero % 1000;
            String milesTexto = miles == 1 ? "mil" : convertir(miles) + " mil";
            if (resto == 0) {
                resultado = milesTexto;
            } else {
                resultado = milesTexto + " " + convertir(resto);
            }
        } else if (numero < 1000000000) {
            int millones = numero / 1000000;
            int resto = numero % 1000000;
            String millonesTexto = millones == 1 ? "un millón" : convertir(millones) + " millones";
            if (resto == 0) {
                resultado = millonesTexto;
            } else {
                resultado = millonesTexto + " " + convertir(resto);
            }
        } else {
            int milesMillones = numero / 1000000000;
            int resto = numero % 1000000000;
            String milesMillonesTexto = milesMillones == 1 ? "mil millones" : convertir(milesMillones) + " mil millones";
            if (resto == 0) {
                resultado = milesMillonesTexto;
            } else {
                resultado = milesMillonesTexto + " " + convertir(resto) ;
            }
        }

        return resultado.toUpperCase();
    }
}

