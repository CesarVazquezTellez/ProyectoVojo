package screens;

import java.sql.Connection;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JFrame{
    private Connection conn; // Conexion a la base de datos

    public JDesktopPane desktop;  // Escritorio dentro del Frame
    private JMenuBar jMenuBar;
    private JMenu jMenuUsuarios;
    private JMenu jMenuUnidad;
    private JMenuItem jMenuItemInsertarUsuarios;
    private JMenuItem jMenuItemVerUsuarios;
    private JMenuItem jMenuItemInsertarUnidad;
    private JMenuItem jMenuItemVerUnidad;

    public VentanaPrincipal(String title, Connection conn){
        this.conn = conn;
        this.setTitle(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents(){
        // DesktopPane - escritorio
        desktop = new JDesktopPane();
        this.add(desktop);
        this.setContentPane(desktop); 
        // Barra de Menu
        jMenuBar = new JMenuBar();
        // this.add(jMenuBar);
        // Menu Usuarios
        jMenuUsuarios = new JMenu();
        jMenuUsuarios.setText("Usuarios");
        // Elemento de menu: Insertar
        jMenuItemInsertarUsuarios = new JMenuItem();
        jMenuItemInsertarUsuarios.setText("Insertar...");
        // Elemento de menu: Ver alumnos
        jMenuItemVerUsuarios = new JMenuItem();
        jMenuItemVerUsuarios.setText("Ver todos los usuarios...");

         //Agregar el listener de eventos para ejecutar la accion de insertar usuarios
        jMenuItemInsertarUsuarios.addActionListener(e -> insertarUsuarios());



        // Menú Unidades
        jMenuUnidad = new JMenu();
        jMenuUnidad.setText("Unidades");
        // Elemento de menu: Ver Unidades
        jMenuItemVerUnidad = new JMenuItem();
        jMenuItemVerUnidad.setText("Ver todas las unidades...");
        // Elemento de menu: Insertar unidad
        jMenuItemInsertarUnidad = new JMenuItem();
        jMenuItemInsertarUnidad.setText("Insertar...");

        //Agregar el listener de eventos para ejecutar la accion de insertar unidad
        jMenuItemInsertarUnidad.addActionListener(e -> insertarUnidad());
       


        // Agregar menuItem a menu 

        jMenuUsuarios.add(jMenuItemVerUsuarios);
        jMenuUsuarios.add(jMenuItemInsertarUsuarios);
        jMenuBar.add(jMenuUsuarios);

        jMenuUnidad.add(jMenuItemVerUnidad);
        jMenuUnidad.add(jMenuItemInsertarUnidad);
        jMenuBar.add(jMenuUnidad);

        this.setJMenuBar(jMenuBar);
        pack();
    }


    private void insertarUsuarios(){
        //1. Crear un objeto tipo JInternalFrame 
        JInternalFrameInsertarUsuarios insertarUsuarios = new JInternalFrameInsertarUsuarios(this.conn);

        //2. Agregar el internal frame al escritorio(desktop)
        this.desktop.add(insertarUsuarios);

        //3. Hacer visible el internal frame
        insertarUsuarios.setVisible(true);
    }
    private void insertarUnidad(){
        
        //1. Crear un objeto tipo JInternalFrame 
        JInternalFrameInsertarUnidad insertarUnidad = new JInternalFrameInsertarUnidad(this.conn);

        //2. Agregar el internal frame al escritorio(desktop)
        this.desktop.add(insertarUnidad);

        //3. Hacer visible el internal frame
        insertarUnidad.setVisible(true);
    }
}
