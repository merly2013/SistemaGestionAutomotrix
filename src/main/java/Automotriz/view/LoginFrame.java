package Automotriz.view;

import Automotriz.controller.LoginController;
import Automotriz.controller.MecanicoService;
import Automotriz.controller.SistemaController;
import Automotriz.modelo.Mecanico;
import Automotriz.modelo.Usuario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends javax.swing.JFrame {
    
    // Controladores reales de tu proyecto
    private SistemaController sistema;
    
    // Variables de la interfaz
    private String rolSeleccionado = "";
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnMecanico;
    private JButton btnRecepcionista;
    private JButton btnIngresar;
    private JLabel lblMensaje;

    
    public LoginFrame(SistemaController sistema) {
        this.sistema = sistema;
        initComponentsCustom(); 
    }


    private void initComponentsCustom() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Taller Automotriz - Login de Empleados");
        setSize(500, 450);
        setLocationRelativeTo(null); 
        setLayout(new GridBagLayout());
        getContentPane().setBackground(new Color(245, 247, 250)); 

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); 
        gbc.fill = GridBagConstraints.HORIZONTAL;

        
        JLabel lblTitulo = new JLabel("Ingreso del Personal", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setForeground(new Color(44, 62, 80));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; 
        add(lblTitulo, gbc);

       
        btnMecanico = new JButton("MECÁNICO");
        btnRecepcionista = new JButton("RECEPCIONISTA");
        
        Font fuenteBotones = new Font("Arial", Font.BOLD, 12);
        btnMecanico.setFont(fuenteBotones);
        btnRecepcionista.setFont(fuenteBotones);
        
        btnMecanico.setBackground(Color.WHITE);
        btnRecepcionista.setBackground(Color.WHITE);
        btnMecanico.setPreferredSize(new Dimension(140, 50));
        btnRecepcionista.setPreferredSize(new Dimension(140, 50));

        btnMecanico.addActionListener(e -> {
            rolSeleccionado = "MECANICO"; // Match con el String de tu backend
            btnMecanico.setBackground(new Color(46, 204, 113)); 
            btnMecanico.setForeground(Color.WHITE);
            btnRecepcionista.setBackground(Color.WHITE); 
            btnRecepcionista.setForeground(Color.BLACK);
        });

        btnRecepcionista.addActionListener(e -> {
            rolSeleccionado = "RECEPCIONISTA"; // Match con tu backend ("RECEPCIONISTA")
            btnRecepcionista.setBackground(new Color(52, 152, 219)); 
            btnRecepcionista.setForeground(Color.WHITE);
            btnMecanico.setBackground(Color.WHITE); 
            btnMecanico.setForeground(Color.BLACK);
        });

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(btnMecanico, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(btnRecepcionista, gbc);

        
        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lblUsuario, gbc);

        txtUsuario = new JTextField(15);
        txtUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(txtUsuario, gbc);

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(lblContrasena, gbc);

        txtContrasena = new JPasswordField(15);
        txtContrasena.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(txtContrasena, gbc);

        
        btnIngresar = new JButton("Ingresar");
        btnIngresar.setFont(new Font("Arial", Font.BOLD, 14));
        btnIngresar.setBackground(new Color(44, 62, 80));
        btnIngresar.setForeground(Color.WHITE);
        btnIngresar.setPreferredSize(new Dimension(100, 35));
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(btnIngresar, gbc);

        
        lblMensaje = new JLabel("", JLabel.CENTER);
        lblMensaje.setFont(new Font("Arial", Font.BOLD, 12));
        lblMensaje.setForeground(Color.RED);
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        add(lblMensaje, gbc);

        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarYProceder();
            }
        });
    }

    private void validarYProceder() {
    String usuarioStr = txtUsuario.getText().trim();
    String contrasenaStr = new String(txtContrasena.getPassword()).trim();

    if (rolSeleccionado.isEmpty()) {
        lblMensaje.setText("⚠️ Seleccione un rol.");
        return;
    }

   
    Usuario usuarioLogueado = sistema.getLoginController().login(usuarioStr, contrasenaStr);

    if (usuarioLogueado != null) {
        if (usuarioLogueado.getRol().equalsIgnoreCase(rolSeleccionado)) {
            this.dispose(); // Cerramos la ventana de login
            
            if (rolSeleccionado.equals("MECANICO")) {
                
                new MecanicoMenuFrame(usuarioLogueado.getMecanico(), sistema.getMecanicoService()).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "¡Bienvenido al sistema de Recepción!");
            }
        } else {
            lblMensaje.setText("❌ El usuario no pertenece al rol seleccionado.");
        }
    } else {
        lblMensaje.setText("❌ Credenciales incorrectas.");
    }
}
}