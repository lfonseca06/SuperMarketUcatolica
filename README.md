PROYECTO DE SOFTWARE PARA GESTIONAR TRANSACCIONES
COMERCIALES DE UNA TIENDA GENÉRICA

# 🛒 SuperMarket Application

## Descripción del Proyecto

Este proyecto es una aplicación de gestión para supermercados, diseñada utilizando el patrón de arquitectura MVC (Modelo-Vista-Controlador) en Java. La aplicación permite la administración de clientes, proveedores, productos, ventas, compras, y reportes, así como la parametrización de la tienda.

## 🚀 Características

- **Gestión de Clientes**: Permite agregar, modificar y eliminar clientes.
- **Gestión de Proveedores**: Permite administrar proveedores del supermercado.
- **Gestión de Productos**: Permite gestionar el inventario de productos.
- **Gestión de Ventas y Compras**: Facilita el registro y control de ventas y compras.
- **Generación de Reportes**: Genera reportes detallados sobre diversas operaciones.
- **Parametrización de la Tienda**: Configuración de parámetros específicos de la tienda como nombre, NIT, IVA, entre otros.

## 📂 Estructura de Carpetas y Paquetes

```plaintext
/SuperMarketUCatolica/src
├── co.edu.ucatolica.controlador
│   ├── /SuperMarketUCatolica/src/co/edu/ucatolica/controlador/Controlador.java
│   └── /SuperMarketUCatolica/src/co/edu/ucatolica/controlador/Main.java
├── co.edu.ucatolica.modelo
│   ├── /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/Cheque.java
│   ├── /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/Cliente.java
│   ├── /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/Compra.java
│   ├── /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/DetalleCompra.java
│   ├── /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/DetalleVenta.java
│   ├── /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/EjmploConvertirNumeroATexto.java
│   ├── /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/NumeroATexto.java
│   ├── /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/Producto.java
│   ├── /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/Proveedor.java
│   ├── /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/Reporte.java
│   ├── /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/SuperMarketFachada.java
│   ├── /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/Tienda.java
│   └── /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/Venta.java
├── co.edu.ucatolica.modelo.persistencia
│   ├── /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/persistencia/ArchivosBinariosProveedor.java
│   ├── /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/persistencia/EjemploGestorArchivos.java
│   ├── /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/persistencia/EjemploGestorArchivosSerializado.java
│   └── /SuperMarketUCatolica/src/co/edu/ucatolica/modelo/persistencia/GestorArchivos.java
├── co.edu.ucatolica.vista
│   ├── /SuperMarketUCatolica/src/co/edu/ucatolica/vista/PanelProveedorAgregar.java
│   ├── /SuperMarketUCatolica/src/co/edu/ucatolica/vista/PanelProveedorDatos.java
│   ├── /SuperMarketUCatolica/src/co/edu/ucatolica/vista/PanelProveedorFuncionesNit.java
│   ├── /SuperMarketUCatolica/src/co/edu/ucatolica/vista/VentanaClientes.java
│   ├── /SuperMarketUCatolica/src/co/edu/ucatolica/vista/VentanaCompras.java
│   ├── /SuperMarketUCatolica/src/co/edu/ucatolica/vista/VentanaConsultas.java
│   ├── /SuperMarketUCatolica/src/co/edu/ucatolica/vista/VentanaParametrizacion.java
│   ├── /SuperMarketUCatolica/src/co/edu/ucatolica/vista/VentanaPrincipal.java
│   ├── /SuperMarketUCatolica/src/co/edu/ucatolica/vista/VentanaProductos.java
│   ├── /SuperMarketUCatolica/src/co/edu/ucatolica/vista/VentanaProveedores.java
│   ├── /SuperMarketUCatolica/src/co/edu/ucatolica/vista/VentanaVentas.java
│   └── /SuperMarketUCatolica/src/co/edu/ucatolica/vista/VistaProveedor.java
├── /SuperMarketUCatolica/data
│   ├── /SuperMarketUCatolica/data/borrar.txt
│   ├── /SuperMarketUCatolica/data/config.dat
│   └── /SuperMarketUCatolica/data/proveedores.out
└── /SuperMarketUCatolica/images
    ├── /SuperMarketUCatolica/images/borrar.txt
    ├── /SuperMarketUCatolica/images/logo.jpg
    ├── /SuperMarketUCatolica/images/logo2.jpg
    ├── /SuperMarketUCatolica/images/logo2.png
    └── /SuperMarketUCatolica/images/parametrizacion_logo.png

🔧 Requisitos

    JDK 8 o superior
    IDE de tu preferencia (Eclipse, IntelliJ, NetBeans, etc.)

🛠️ Instalación y Ejecución

    1. Clona el repositorio:

    https://github.com/lfonseca06/SuperMarketUcatolica.git

    2. Importa el proyecto en tu IDE favorito.
    3. Asegúrate de que src esté configurado como el directorio de código fuente.
    4. Ejecuta la clase Main.java ubicada en co.edu.ucatolica.controlador.

📘 Uso

    Ventana Principal: Desde aquí se puede acceder a las diferentes funcionalidades de la aplicación.
    Ventana de Parametrización: Permite configurar los parámetros iniciales de la tienda.

🤝 Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue o envía un pull request.

📄 Licencia

Este proyecto está licenciado bajo los términos de la Creative Commons Attribution 4.0 International License.