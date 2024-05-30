PROYECTO DE SOFTWARE PARA GESTIONAR TRANSACCIONES
COMERCIALES DE UNA TIENDA GENÉRICA



Arquitectura de Software


co.edu.ucatolica
│
├── modelo
│   ├── Cliente.java
│   ├── Producto.java
│   ├── Proveedor.java
│   ├── Venta.java
│   └── Credito.java
│   └── Cheque
│   └── Compra
│   └── DetalleCompra
│   └── DetalleVenta
│   └── Tienda
│   └── Venta
│
│   ├── persistencia
│   │   └── GestorArchivos.java
│
├── vista
│   ├── VentanaPrincipal.java
│   ├── VentanaClientes.java
│   ├── VentanaProveedores.java
│   ├── VentanaProductos.java
│   ├── VentanaVentas.java
│   ├── VentanaCompras.java
│   ├── VentanaConsultas.java
│   └── VentanaParametros.java
│
└── controlador
    ├── Controlador.java
    └── Main.java



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
supermarket-app/
├── 📁 src/
│   ├── 📁 co/
│   │   ├── 📁 edu/
│   │   │   ├── 📁 ucatolica/
│   │   │   │   ├── 📁 controlador/
│   │   │   │   │   ├── Controlador.java
│   │   │   │   │   └── Main.java
│   │   │   │   ├── 📁 modelo/
│   │   │   │   │   ├── SuperMarketFachada.java
│   │   │   │   │   └── Tienda.java
│   │   │   │   ├── 📁 persistencia/
│   │   │   │   └── 📁 vista/
│   │   │   │       ├── VentanaPrincipal.java
│   │   │   │       ├── VentanaClientes.java
│   │   │   │       ├── VistaProveedor.java
│   │   │   │       ├── VentanaProductos.java
│   │   │   │       ├── VentanaVentas.java
│   │   │   │       ├── VentanaCompras.java
│   │   │   │       ├── VentanaConsultas.java
│   │   │   │       └── VentanaParametrizacion.java
├── 📁 persistencia/
│   └── config.dat
├── .gitignore
└── README.md