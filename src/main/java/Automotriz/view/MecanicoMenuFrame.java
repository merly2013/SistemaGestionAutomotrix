package Automotriz.view;

import Automotriz.controller.MecanicoService;
import Automotriz.modelo.Mecanico;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MecanicoMenuFrame extends javax.swing.JFrame {

    private Mecanico mecanicoSesion;
    private MecanicoService mecanicoService;
    private DefaultTableModel modeloTabla;

    
    private JTabbedPane pestañasMenu;
    private JTable tablaMecanicos;
    private JTextField txtNombre, txtId, txtMaxOrdenes;
    private JCheckBox chkDisponible;

    public MecanicoMenuFrame(Mecanico mecanico, MecanicoService service) {
        this.mecanicoSesion = mecanico;
        this.mecanicoService = service;
        
        setTitle("Sistema Automotriz - Menú de Mecánicos");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        initComponentsCustom();
        refrescarTabla();
    }

    private void initComponentsCustom() {
        
        JPanel panelHeader = new JPanel(new GridLayout(1, 3));
        panelHeader.setBackground(new Color(39, 174, 96)); // Tu verde característico
        
        JLabel lblMeca = new JLabel("🔧 Mecánico: " + mecanicoSesion.getNombre());
        lblMeca.setForeground(Color.WHITE);
        lblMeca.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        JLabel lblId = new JLabel("🆔 ID: " + mecanicoSesion.getId());
        lblId.setForeground(Color.WHITE);
        lblId.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JButton btnCerrar = new JButton("Cerrar Sesión");
        btnCerrar.addActionListener(e -> {
            this.dispose();
           
        });

        panelHeader.add(lblMeca);
        panelHeader.add(lblId);
        panelHeader.add(btnCerrar);

       
        pestañasMenu = new JTabbedPane();

       
        JPanel panelMostrar = new JPanel(new BorderLayout());
        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Nombre", "Max Órdenes", "Disponible"}, 0);
        tablaMecanicos = new JTable(modeloTabla);
        panelMostrar.add(new JScrollPane(tablaMecanicos), BorderLayout.CENTER);
        
        JPanel panelBotonesTabla = new JPanel();
        JButton btnEliminar = new JButton("❌ 4. Eliminar Seleccionado");
        JButton btnCargarModificar = new JButton("📝 3. Cargar para Modificar");
        panelBotonesTabla.add(btnCargarModificar);
        panelBotonesTabla.add(btnEliminar);
        panelMostrar.add(panelBotonesTabla, BorderLayout.SOUTH);

        
        // ==================== PEGA ESTE BLOQUE EN SU LUGAR ====================

JPanel panelFormulario = new JPanel();
panelFormulario.setLayout(new BoxLayout(panelFormulario, BoxLayout.Y_AXIS));
panelFormulario.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));


txtId = new JTextField(15);
txtNombre = new JTextField(25);
txtMaxOrdenes = new JTextField(10);
chkDisponible = new JCheckBox("Disponible", true);


Dimension dimEtiqueta = new Dimension(130, 25);

     
        JPanel filaId = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JLabel lblFormId = new JLabel("ID de Empleado:");
        lblFormId.setPreferredSize(dimEtiqueta);
        filaId.add(lblFormId);
        filaId.add(txtId);
        panelFormulario.add(filaId);

      
        JPanel filaNombre = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JLabel lblFormNombre = new JLabel("Nombre Completo:");
        lblFormNombre.setPreferredSize(dimEtiqueta);
        filaNombre.add(lblFormNombre);
        filaNombre.add(txtNombre);
        panelFormulario.add(filaNombre);

        
        JPanel filaOrdenes = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JLabel lblFormOrdenes = new JLabel("Máximo de Órdenes:");
        lblFormOrdenes.setPreferredSize(dimEtiqueta);
        filaOrdenes.add(lblFormOrdenes);
        filaOrdenes.add(txtMaxOrdenes);
        panelFormulario.add(filaOrdenes);

        
        JPanel filaEstado = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JLabel lblFormEstado = new JLabel("Estado Inicial:");
        lblFormEstado.setPreferredSize(dimEtiqueta);
        filaEstado.add(lblFormEstado);
        filaEstado.add(chkDisponible);
        panelFormulario.add(filaEstado);

    
        JPanel filaBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        JButton btnGuardar = new JButton("💾 1. Agregar Mecánico");
        JButton btnActualizar = new JButton("🔄 3. Aplicar Modificación");
        filaBotones.add(btnGuardar);
        filaBotones.add(btnActualizar);
        panelFormulario.add(filaBotones);

pestañasMenu.addTab("📋 2. Mostrar Lista", panelMostrar);
pestañasMenu.addTab("➕ 1. Agregar / Editar", panelFormulario);

// ======================================================================

       
        setLayout(new BorderLayout());
        add(panelHeader, BorderLayout.NORTH);
        add(pestañasMenu, BorderLayout.CENTER);

        

        
        btnGuardar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText().trim());
                String nombre = txtNombre.getText().trim();
                int maxO = Integer.parseInt(txtMaxOrdenes.getText().trim());
                boolean disp = chkDisponible.isSelected();

                Mecanico nuevo = new Mecanico(nombre, id, maxO, disp);
                mecanicoService.crear(nuevo); // Llama al ArrayList compartido
                
                JOptionPane.showMessageDialog(this, "¡Mecánico registrado con éxito!");
                limpiarFormulario();
                refrescarTabla();
                pestañasMenu.setSelectedIndex(0); // Volver a la lista
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error en los datos. Verifica los campos numéricos.");
            }
        });

       
        btnCargarModificar.addActionListener(e -> {
            int fila = tablaMecanicos.getSelectedRow();
            if (fila >= 0) {
                txtId.setText(modeloTabla.getValueAt(fila, 0).toString());
                txtId.setEditable(false); // No dejamos cambiar la llave primaria (ID)
                txtNombre.setText(modeloTabla.getValueAt(fila, 1).toString());
                txtMaxOrdenes.setText(modeloTabla.getValueAt(fila, 2).toString());
                chkDisponible.setSelected(modeloTabla.getValueAt(fila, 3).toString().contains("🟢"));
                
                pestañasMenu.setSelectedIndex(1); // Mover al formulario
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona un mecánico de la lista.");
            }
        });

        
        btnActualizar.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText().trim());
                String nombre = txtNombre.getText().trim();
                int maxO = Integer.parseInt(txtMaxOrdenes.getText().trim());
                boolean disp = chkDisponible.isSelected();

                Mecanico modificado = new Mecanico(nombre, id, maxO, disp);
                mecanicoService.modificar(modificado); // Llama a tu método modificar del Service
                
                JOptionPane.showMessageDialog(this, "¡Registro actualizado!");
                txtId.setEditable(true);
                limpiarFormulario();
                refrescarTabla();
                pestañasMenu.setSelectedIndex(0);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al actualizar.");
            }
        });

        
        btnEliminar.addActionListener(e -> {
            int fila = tablaMecanicos.getSelectedRow();
            if (fila >= 0) {
                int id = (int) modeloTabla.getValueAt(fila, 0);
                int empanada = JOptionPane.showConfirmDialog(this, "¿Seguro que deseas eliminar al mecánico con ID " + id + "?");
                if (empanada == JOptionPane.YES_OPTION) {
                    mecanicoService.eliminar(id); // Tu método eliminar del Service
                    refrescarTabla();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecciona una fila primero.");
            }
        });
    }

    
    private void refrescarTabla() {
        modeloTabla.setRowCount(0); // Limpiar datos visuales
        for (Mecanico m : mecanicoService.getMecanicos()) {
            modeloTabla.addRow(new Object[]{
                m.getId(),
                m.getNombre(),
                m.getMaxOrdenes(),
                m.isDisponible() ? "🟢 DISPONIBLE" : "🔴 OCUPADO"
            });
        }
    }

    private void limpiarFormulario() {
        txtId.setText("");
        txtNombre.setText("");
        txtMaxOrdenes.setText("");
        chkDisponible.setSelected(true);
    }
}