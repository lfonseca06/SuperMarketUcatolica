PROYECTO DE SOFTWARE PARA GESTIONAR TRANSACCIONES
COMERCIALES DE UNA TIENDA GENÃ‰RICA

# ?? SuperMarket Application

## Descripci¨®n del Proyecto

Este proyecto es una aplicaci¨®n de gesti¨®n para supermercados, dise?ada utilizando el patr¨®n de arquitectura MVC (Modelo-Vista-Controlador) en Java. La aplicaci¨®n permite la administraci¨®n de clientes, proveedores, productos, ventas, compras, y reportes, as¨ª como la parametrizaci¨®n de la tienda.

## ?? Caracter¨ªsticas

- **Gesti¨®n de Clientes**: Permite agregar, modificar y eliminar clientes.
- **Gesti¨®n de Proveedores**: Permite administrar proveedores del supermercado.
- **Gesti¨®n de Productos**: Permite gestionar el inventario de productos.
- **Gesti¨®n de Ventas y Compras**: Facilita el registro y control de ventas y compras.
- **Generaci¨®n de Reportes**: Genera reportes detallados sobre diversas operaciones.
- **Parametrizaci¨®n de la Tienda**: Configuraci¨®n de par¨¢metros espec¨ªficos de la tienda como nombre, NIT, IVA, entre otros.

## ?? Estructura de Carpetas y Paquetes

```plaintext
/SuperMarketUCatolica/src
©À©¤©¤ co.edu.ucatolica.controlador
©¦   ©À©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/controlador/Controlador.java
©¦   ©¸©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/controlador/Main.java
©À©¤©¤ co.edu.ucatolica.modelo
©¦   ©À©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/Cheque.java
©¦   ©À©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/Cliente.java
©¦   ©À©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/Compra.java
©¦   ©À©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/DetalleCompra.java
©¦   ©À©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/DetalleVenta.java
©¦   ©À©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/EjmploConvertirNumeroATexto.java
©¦   ©À©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/NumeroATexto.java
©¦   ©À©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/Producto.java
©¦   ©À©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/Proveedor.java
©¦   ©À©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/Reporte.java
©¦   ©À©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/SuperMarketFachada.java
©¦   ©À©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/Tienda.java
©¦   ©¸©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/Venta.java
©À©¤©¤ co.edu.ucatolica.modelo.persistencia
©¦   ©À©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/persistencia/ArchivosBinariosProveedor.java
©¦   ©À©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/persistencia/EjemploGestorArchivos.java
©¦   ©À©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/persistencia/EjemploGestorArchivosSerializado.java
©¦   ©¸©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/persistencia/GestorArchivos.java
©À©¤©¤ co.edu.ucatolica.vista
©¦   ©À©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/vista/PanelProveedorAgregar.java
©¦   ©À©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/vista/PanelProveedorDatos.java
©¦   ©À©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/vista/PanelProveedorFuncionesNit.java
©¦   ©À©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/vista/VentanaClientes.java
©¦   ©À©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/vista/VentanaCompras.java
©¦   ©À©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/vista/VentanaConsultas.java
©¦   ©À©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/vista/VentanaParametrizacion.java
©¦   ©À©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/vista/VentanaPrincipal.java
©¦   ©À©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/vista/VentanaProductos.java
©¦   ©À©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/vista/VentanaProveedores.java
©¦   ©À©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/vista/VentanaVentas.java
©¦   ©¸©¤©¤ /SuperMarketUCatolica/src/co/edu/ucatolica/vista/VistaProveedor.java
©À©¤©¤ /SuperMarketUCatolica/data
©¦   ©À©¤©¤ /SuperMarketUCatolica/data/borrar.txt
©¦   ©À©¤©¤ /SuperMarketUCatolica/data/config.dat
©¦   ©¸©¤©¤ /SuperMarketUCatolica/data/proveedores.out
©¸©¤©¤ /SuperMarketUCatolica/images
    ©À©¤©¤ /SuperMarketUCatolica/images/borrar.txt
    ©À©¤©¤ /SuperMarketUCatolica/images/logo.jpg
    ©À©¤©¤ /SuperMarketUCatolica/images/logo2.jpg
    ©À©¤©¤ /SuperMarketUCatolica/images/logo2.png
    ©¸©¤©¤ /SuperMarketUCatolica/images/parametrizacion_logo.png

?? Requisitos

    JDK 8 o superior
    IDE de tu preferencia (Eclipse, IntelliJ, NetBeans, etc.)

??? Instalaci¨®n y Ejecuci¨®n

    1.Clona el repositorio:
	
	https://github.com/lfonseca06/SuperMarketUcatolica.git
	
	2.Importa el proyecto en tu IDE favorito.
    
	3.Aseg¨²rate de que src est¨¦ configurado como el directorio de c¨®digo fuente.
    
	4.Ejecuta la clase Main.java ubicada en co.edu.ucatolica.controlador.

?? Uso

    Ventana Principal: Desde aqu¨ª se puede acceder a las diferentes funcionalidades de la aplicaci¨®n.
    Ventana de Parametrizaci¨®n: Permite configurar los par¨¢metros iniciales de la tienda.

?? Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue o env¨ªa un pull request.
?? Licencia

Este proyecto est¨¢ licenciado bajo los t¨¦rminos de la Creative Commons Attribution 4.0 International License.