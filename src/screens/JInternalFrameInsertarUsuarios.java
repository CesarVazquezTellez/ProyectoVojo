package screens;

import java.awt.Font; //Necesaria para cambiar el tipo de letra
import java.sql.Connection; //Necesario para el diseño del layout
import javax.swing.GroupLayout; 
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import models.Usuarios;
import models.UsuariosDAO;


public class JInternalFrameInsertarUsuarios extends JInternalFrame {
    private JLabel lblIdUsuarios;
    private JLabel lblNombre;
    private JLabel lblPrimerApellido;
    private JLabel lblSegundoApellido;
    private JLabel lblTelefono;
    private JLabel lblCorreoElectronico;
    private JLabel lblIdRol;
    private JTextField txtIdUsuarios;
    private JTextField txtNombre;
    private JTextField txtPrimerApellido;
    private JTextField txtSegundoApellido;
    private JTextField txtTelefono;
    private JTextField txtCorreoElectronico;
    private JTextField txtIdRol;
    private JButton btnAceptar;
    private JButton btnCancelar;
    private Connection conn;

    public JInternalFrameInsertarUsuarios(Connection conn){
        
        super("Insertar usuario", 
              true,  // resizable
              true,  // closable
              true,  // maximizable
              true); // iconifiable (minimizable)
        this.conn = conn;
        this.setTitle("Insertar nuevo usuario");
        this.setSize(400,400);
        initComponents();
    }

    private void initComponents(){
        // Creación de objetos
        lblIdUsuarios = new JLabel("ID del usuario:");
        lblNombre = new JLabel("Nombre:");
        lblPrimerApellido = new JLabel("Primer apellido:");
        lblSegundoApellido = new JLabel("Segundo apellido:");
        lblTelefono = new JLabel("Teléfono:");
        lblCorreoElectronico = new JLabel("Correo electrónico:");
        lblIdRol = new JLabel("ID de rol:");
        txtIdUsuarios = new JTextField();
        txtNombre = new JTextField();
        txtPrimerApellido = new JTextField();
        txtSegundoApellido = new JTextField();
        txtTelefono = new JTextField();
        txtCorreoElectronico = new JTextField();
        txtIdRol = new JTextField();
        // Botones
        btnAceptar = new JButton("Aceptar");
        btnCancelar = new JButton("Cancelar");

        // Etiquetas
        lblIdUsuarios.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNombre.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblPrimerApellido.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblSegundoApellido.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblCorreoElectronico.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblIdRol.setFont(new Font("Tahoma", Font.BOLD, 16));
        //Botones
        btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 16));

        //Listener para escuchar los eventos de los botones
        btnAceptar.addActionListener(e -> insertarUsuarios());
        btnCancelar.addActionListener(e -> this.dispose());

        GroupLayout layout = new GroupLayout(getContentPane());
        this.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(lblIdUsuarios)
            .addComponent(txtIdUsuarios)
            .addComponent(lblNombre)
            .addComponent(txtNombre)
            .addComponent(lblPrimerApellido)
            .addComponent(txtPrimerApellido)
            .addComponent(lblSegundoApellido)
            .addComponent(txtSegundoApellido)
            .addComponent(lblTelefono)
            .addComponent(txtTelefono)
            .addComponent(lblCorreoElectronico)
            .addComponent(txtCorreoElectronico)
            .addComponent(lblIdRol)
            .addComponent(txtIdRol)
            .addGroup(
                layout.createSequentialGroup()
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar)
            )
        );


        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(lblIdUsuarios)
                .addComponent(txtIdUsuarios, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblNombre)
                .addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblPrimerApellido)
                .addComponent(txtPrimerApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblSegundoApellido)
                .addComponent(txtSegundoApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblTelefono)
                .addComponent(txtTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblCorreoElectronico)
                .addComponent(txtCorreoElectronico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblIdRol)
                .addComponent(txtIdRol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAceptar)
                        .addComponent(btnCancelar)
                )
        );
    }
    
    private void insertarUsuarios(){
        int rows;

        //Recuperar datos del formulario y meterlos en un objeto Unidad
        int idUsuario = Integer.parseInt(txtIdUsuarios.getText());
        String nombre = txtNombre.getText();
        String primerApellido = txtPrimerApellido.getText();
        String segundoApellido = txtSegundoApellido.getText();
        String telefono = txtTelefono.getText();
        String correoElectronico = txtCorreoElectronico.getText();
        int idRol = Integer.parseInt(txtIdRol.getText());

        //Validar que los campos no esten vacios
        if (txtIdUsuarios.getText().isEmpty() || txtNombre.getText().isEmpty() || txtPrimerApellido.getText().isEmpty() || txtSegundoApellido.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtCorreoElectronico.getText().isEmpty() || txtIdRol.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese los datos solicitados");
            return;
        }
        else {
            Usuarios usuarios = new Usuarios(idUsuario, nombre, primerApellido, segundoApellido, telefono, correoElectronico, idRol);
            UsuariosDAO unidadDAO = new UsuariosDAO(conn);
            rows = unidadDAO.insertarUsuarios(usuarios);
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Usuario insertado correctamente");
            }
            else {
                JOptionPane.showMessageDialog(this, "Error al insertar el usuario");
            }
        }
        // Limpiar los campos del formulario
        txtIdUsuarios.setText("");
        txtNombre.setText("");
        txtPrimerApellido.setText("");
        txtSegundoApellido.setText("");
        txtTelefono.setText("");
        txtCorreoElectronico.setText("");
        txtIdRol.setText("");
        // Cerrar el JInternalFrame
        this.dispose();
    }
}
