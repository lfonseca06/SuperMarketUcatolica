PROYECTO DE SOFTWARE PARA GESTIONAR TRANSACCIONES
COMERCIALES DE UNA TIENDA GENÉRICA

# ?? SuperMarket Application

## Descripci��n del Proyecto

Este proyecto es una aplicaci��n de gesti��n para supermercados, dise?ada utilizando el patr��n de arquitectura MVC (Modelo-Vista-Controlador) en Java. La aplicaci��n permite la administraci��n de clientes, proveedores, productos, ventas, compras, y reportes, as�� como la parametrizaci��n de la tienda.

## ?? Caracter��sticas

- **Gesti��n de Clientes**: Permite agregar, modificar y eliminar clientes.
- **Gesti��n de Proveedores**: Permite administrar proveedores del supermercado.
- **Gesti��n de Productos**: Permite gestionar el inventario de productos.
- **Gesti��n de Ventas y Compras**: Facilita el registro y control de ventas y compras.
- **Generaci��n de Reportes**: Genera reportes detallados sobre diversas operaciones.
- **Parametrizaci��n de la Tienda**: Configuraci��n de par��metros espec��ficos de la tienda como nombre, NIT, IVA, entre otros.

## ?? Estructura de Carpetas y Paquetes

```plaintext
/SuperMarketUCatolica/src
������ co.edu.ucatolica.controlador
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/controlador/Controlador.java
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/controlador/Main.java
������ co.edu.ucatolica.modelo
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/Cheque.java
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/Cliente.java
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/Compra.java
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/DetalleCompra.java
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/DetalleVenta.java
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/EjmploConvertirNumeroATexto.java
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/NumeroATexto.java
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/Producto.java
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/Proveedor.java
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/Reporte.java
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/SuperMarketFachada.java
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/Tienda.java
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/Venta.java
������ co.edu.ucatolica.modelo.persistencia
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/persistencia/ArchivosBinariosProveedor.java
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/persistencia/EjemploGestorArchivos.java
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/persistencia/EjemploGestorArchivosSerializado.java
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/persistencia/GestorArchivos.java
������ co.edu.ucatolica.vista
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/vista/PanelProveedorAgregar.java
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/vista/PanelProveedorDatos.java
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/vista/PanelProveedorFuncionesNit.java
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/vista/VentanaClientes.java
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/vista/VentanaCompras.java
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/vista/VentanaConsultas.java
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/vista/VentanaParametrizacion.java
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/vista/VentanaPrincipal.java
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/vista/VentanaProductos.java
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/vista/VentanaProveedores.java
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/vista/VentanaVentas.java
��   ������ /SuperMarketUCatolica/src/co/edu/ucatolica/vista/VistaProveedor.java
������ /SuperMarketUCatolica/data
��   ������ /SuperMarketUCatolica/data/borrar.txt
��   ������ /SuperMarketUCatolica/data/config.dat
��   ������ /SuperMarketUCatolica/data/proveedores.out
������ /SuperMarketUCatolica/images
    ������ /SuperMarketUCatolica/images/borrar.txt
    ������ /SuperMarketUCatolica/images/logo.jpg
    ������ /SuperMarketUCatolica/images/logo2.jpg
    ������ /SuperMarketUCatolica/images/logo2.png
    ������ /SuperMarketUCatolica/images/parametrizacion_logo.png

?? Requisitos

    JDK 8 o superior
    IDE de tu preferencia (Eclipse, IntelliJ, NetBeans, etc.)

??? Instalaci��n y Ejecuci��n

    1.Clona el repositorio:
	
	https://github.com/lfonseca06/SuperMarketUcatolica.git
	
	2.Importa el proyecto en tu IDE favorito.
    
	3.Aseg��rate de que src est�� configurado como el directorio de c��digo fuente.
    
	4.Ejecuta la clase Main.java ubicada en co.edu.ucatolica.controlador.

?? Uso

    Ventana Principal: Desde aqu�� se puede acceder a las diferentes funcionalidades de la aplicaci��n.
    Ventana de Parametrizaci��n: Permite configurar los par��metros iniciales de la tienda.

?? Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue o env��a un pull request.
?? Licencia

Este proyecto est�� licenciado bajo los t��rminos de la Creative Commons Attribution 4.0 International License.