package co.edu.ucatolica.vista;

import javax.swing.*;
import co.edu.ucatolica.modelo.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.IOException;
import java.util.List;

public class VentanaCredito extends JFrame {
    private JTextField txtMontoFinanciar, txtTasaInteres, txtPlazo, txtCuotaMensual;
    private JTextArea txtTablaAmortizacion;
    private JButton btnCalcular, btnConfirmar, btnRecalcular;
    private SuperMarketFachada fachada;
    private List<Cuota> tablaAmortizacion;

    public VentanaCredito(SuperMarketFachada fachada, String cedulaCliente, double montoFinanciar, double valorIVA, List<Producto> productos, List<Integer> cantidades) {
        this.fachada = fachada;
        this.tablaAmortizacion = new ArrayList<>();

        setTitle("Pago por Cuotas");
        setSize(500, 600);
        setLayout(new GridLayout(8, 2));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        txtMontoFinanciar = new JTextField(String.valueOf(montoFinanciar));
        txtMontoFinanciar.setEditable(false);
        txtTasaInteres = new JTextField(String.valueOf(fachada.leerTasaInteres()));
        txtPlazo = new JTextField();
        txtCuotaMensual = new JTextField();
        txtCuotaMensual.setEditable(false);
        txtTablaAmortizacion = new JTextArea(10, 30);
        txtTablaAmortizacion.setEditable(false);
        btnCalcular = new JButton("Calcular");
        btnConfirmar = new JButton("Confirmar");
        btnRecalcular = new JButton("Recalcular");

        add(new JLabel("Monto a Financiar:"));
        add(txtMontoFinanciar);
        add(new JLabel("Tasa de Interés Nominal (%):"));
        add(txtTasaInteres);
        add(new JLabel("Plazo (meses):"));
        add(txtPlazo);
        add(new JLabel("Cuota Mensual:"));
        add(txtCuotaMensual);
        add(new JLabel("Tabla de Amortización:"));
        add(new JScrollPane(txtTablaAmortizacion));
        add(btnCalcular);
        add(btnRecalcular);
        add(btnConfirmar);

        // Configurar acciones de los botones
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularCuotas();
            }
        });
        btnRecalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularCuotas();
            }
        });
        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmarCredito(cedulaCliente, montoFinanciar, valorIVA, productos, cantidades);
            }
        });
    }

    private void calcularCuotas() {
        try {
            double monto = Double.parseDouble(txtMontoFinanciar.getText());
            double tasaInteres = Double.parseDouble(txtTasaInteres.getText()) / 100;
            int plazo = Integer.parseInt(txtPlazo.getText());
            double tasaEfectiva = tasaInteres / 12;  // Tasa efectiva mensual
            double amortizacionCapital = monto / plazo;

            txtCuotaMensual.setText(String.format("%.2f", amortizacionCapital + (monto * tasaEfectiva)));

            tablaAmortizacion.clear();
            txtTablaAmortizacion.setText("");
            double saldo = monto;
            for (int i = 1; i <= plazo; i++) {
                double intereses = saldo * tasaEfectiva;
                double cuota = amortizacionCapital + intereses;
                saldo -= amortizacionCapital;
                Cuota cuotaObj = new Cuota(i, saldo, cuota, intereses, amortizacionCapital);
                tablaAmortizacion.add(cuotaObj);
                txtTablaAmortizacion.append("Período " + i + ": Cuota: " + String.format("%.2f", cuota) + ", Intereses: " + String.format("%.2f", intereses) + ", Amortización: " + String.format("%.2f", amortizacionCapital) + ", Saldo: " + String.format("%.2f", saldo) + "\n");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void confirmarCredito(String cedulaCliente, double montoFinanciar, double valorIVA, List<Producto> productos, List<Integer> cantidades) {
        try {
            Credito credito = new Credito(fachada.getVentaServicio().generarCodigoVenta(), cedulaCliente, montoFinanciar, Double.parseDouble(txtTasaInteres.getText()), Integer.parseInt(txtPlazo.getText()), tablaAmortizacion);
            fachada.registrarCredito(credito);
            fachada.registrarVenta(cedulaCliente, montoFinanciar - valorIVA, valorIVA, montoFinanciar, productos, cantidades);
            JOptionPane.showMessageDialog(this, "Venta a crédito registrada con éxito.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al registrar la venta a crédito: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
}