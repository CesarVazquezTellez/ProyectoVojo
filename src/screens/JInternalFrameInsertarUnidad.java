package screens;

import java.awt.Font; //Necesaria para cambiar el tipo de letra
import java.sql.Connection; //Necesario para el diseño del layout
import javax.swing.GroupLayout; 
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import models.Unidad;
import models.UnidadDAO;


public class JInternalFrameInsertarUnidad extends JInternalFrame {
    private JLabel lblIdUnidad;
    private JLabel lblIdOperador;
    private JLabel lblModelo;
    private JLabel lblMarca;
    private JLabel lblPlacas;
    private JLabel lblIdPropietario;
    private JLabel lblCapacidad;
    private JLabel lblAnio;
    private JTextField txtIdUnidad;
    private JTextField txtIdOperador;
    private JTextField txtModelo;
    private JTextField txtMarca;
    private JTextField txtPlacas;
    private JTextField txtIdPropietario;
    private JTextField txtCapacidad;
    private JTextField txtAnio;
    private JButton btnAceptar;
    private JButton btnCancelar;
    private Connection conn;

    public JInternalFrameInsertarUnidad(Connection conn){
        
        super("Insertar unidad", 
              true,  // resizable
              true,  // closable
              true,  // maximizable
              true); // iconifiable (minimizable)
        this.conn = conn;
        this.setTitle("Insertar nueva unidad");
        this.setSize(400,400);
        initComponents();
    }

    private void initComponents(){
        // Creación de objetos
        lblIdUnidad = new JLabel("Id:");
        lblIdOperador = new JLabel("Id del operador:");
        lblModelo = new JLabel("Modelo:");
        lblMarca = new JLabel("Marca:");
        lblPlacas = new JLabel("Placas:");
        lblIdPropietario = new JLabel("Id del propietario:");
        lblCapacidad = new JLabel("Capacidad:");
        lblAnio = new JLabel("Año:");
        txtIdUnidad = new JTextField();
        txtIdOperador = new JTextField();
        txtModelo = new JTextField();
        txtMarca = new JTextField();
        txtPlacas = new JTextField();
        txtIdPropietario = new JTextField();
        txtCapacidad = new JTextField();
        txtAnio = new JTextField();
        // Botones
        btnAceptar = new JButton("Aceptar");
        btnCancelar = new JButton("Cancelar");

        // Etiquetas
        lblIdUnidad.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblIdOperador.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblModelo.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblMarca.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblPlacas.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblIdPropietario.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblCapacidad.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblAnio.setFont(new Font("Tahoma", Font.BOLD, 16));
        //Botones
        btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 16));

        //Listener para escuchar los eventos de los botones
        btnAceptar.addActionListener(e -> insertarUnidad());
        btnCancelar.addActionListener(e -> this.dispose());

        GroupLayout layout = new GroupLayout(getContentPane());
        this.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(lblIdUnidad)
            .addComponent(txtIdUnidad)
            .addComponent(lblIdOperador)
            .addComponent(txtIdOperador)
            .addComponent(lblModelo)
            .addComponent(txtModelo)
            .addComponent(lblMarca)
            .addComponent(txtMarca)
            .addComponent(lblPlacas)
            .addComponent(txtPlacas)
            .addComponent(lblIdPropietario)
            .addComponent(txtIdPropietario)
            .addComponent(lblCapacidad)
            .addComponent(txtCapacidad)
            .addComponent(lblAnio)
            .addComponent(txtAnio)
            .addGroup(
                layout.createSequentialGroup()
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar)
            )
        );


        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addComponent(lblIdUnidad)
                .addComponent(txtIdUnidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblIdOperador)
                .addComponent(txtIdOperador, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblModelo)
                .addComponent(txtModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblMarca)
                .addComponent(txtMarca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblPlacas)
                .addComponent(txtPlacas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblIdPropietario)
                .addComponent(txtIdPropietario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblCapacidad)
                .addComponent(txtCapacidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblAnio)
                .addComponent(txtAnio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAceptar)
                        .addComponent(btnCancelar)
                )
        );
    }
    
    private void insertarUnidad(){
        int rows;

        //Recuperar datos del formulario y meterlos en un objeto Unidad
        int idUnidad = Integer.parseInt(txtIdUnidad.getText());
        int idOperador = Integer.parseInt(txtIdOperador.getText());
        String modelo = txtModelo.getText();
        String marca = txtMarca.getText();
        String placas = txtPlacas.getText();
        int idPropietario = Integer.parseInt(txtIdPropietario.getText());
        int capacidad = Integer.parseInt(txtCapacidad.getText());
        int anio = Integer.parseInt(txtAnio.getText());

        //Validar que los campos no esten vacios
        if (txtIdUnidad.getText().isEmpty() || txtIdOperador.getText().isEmpty() || txtModelo.getText().isEmpty() || txtMarca.getText().isEmpty() || txtPlacas.getText().isEmpty() || txtIdPropietario.getText().isEmpty() || txtCapacidad.getText().isEmpty() || txtAnio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese los datos solicitados");
            return;
        }
        else {
            Unidad unidad = new Unidad(idUnidad, idOperador, modelo, marca, placas, idPropietario, capacidad, anio);
            UnidadDAO unidadDAO = new UnidadDAO(conn);
            rows = unidadDAO.insertarUnidad(unidad);
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Unidad insertada correctamente");
            }
            else {
                JOptionPane.showMessageDialog(this, "Error al insertar la unidad");
            }
        }
        // Limpiar los campos del formulario
        txtIdUnidad.setText("");
        txtIdOperador.setText("");
        txtModelo.setText("");
        txtMarca.setText("");
        txtPlacas.setText("");
        txtIdPropietario.setText("");
        txtCapacidad.setText("");
        txtAnio.setText("");
        // Cerrar el JInternalFrame
        this.dispose();
    }
}
