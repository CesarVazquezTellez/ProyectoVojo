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
    private JMenu jMenuAlumnos;
    private JMenu jMenuUnidad;
    private JMenu jMenuBachilleratos;
    private JMenuItem jMenuItemInsertar;
    private JMenuItem jMenuItemVerAlumnos;
    private JMenuItem jMenuItemInsertarUnidad;
    private JMenuItem jMenuItemVerUnidad;
    private JMenuItem JMenuItemInsertarBachillerato;
    private JMenuItem JMenuItemVerBachilleratos;

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
        // Menu Alumnos
        jMenuAlumnos = new JMenu();
        jMenuAlumnos.setText("Alumnos");
        // Elemento de menu: Insertar
        jMenuItemInsertar = new JMenuItem();
        jMenuItemInsertar.setText("Insertar...");
        // Elemento de menu: Ver alumnos
        jMenuItemVerAlumnos = new JMenuItem();
        jMenuItemVerAlumnos.setText("Ver todos los alumnos...");

        // Menú Unidades
        jMenuUnidad = new JMenu();
        jMenuUnidad.setText("Unidades");
        // Elemento de menu: Ver Unidades
        jMenuItemVerUnidad = new JMenuItem();
        jMenuItemVerUnidad.setText("Ver todas las unidades...");
        // Elemento de menu: Insertar unidad
        jMenuItemInsertarUnidad = new JMenuItem();
        jMenuItemInsertarUnidad.setText("Insertar...");

        // Menu Bachilleratos
        jMenuBachilleratos = new JMenu();
        jMenuBachilleratos.setText("Bachilleratos");

        // Elemento de menu: Ver Bachilleratos
        JMenuItemVerBachilleratos = new JMenuItem();
        JMenuItemVerBachilleratos.setText("Ver todos los bachilleratos...");

        // Elemento de menu: Insertar Bachillerato
        JMenuItemInsertarBachillerato = new JMenuItem();
        JMenuItemInsertarBachillerato.setText("Insertar...");

        //Agregar el listener de eventos para ejecutar la accion de insertar unidad
        jMenuItemInsertarUnidad.addActionListener(e -> insertarUnidad());



        // Agregar menuItem a menu 
        jMenuAlumnos.add(jMenuItemVerAlumnos);
        jMenuAlumnos.add(jMenuItemInsertar);
        jMenuBar.add(jMenuAlumnos);

        jMenuUnidad.add(jMenuItemVerUnidad);
        jMenuUnidad.add(jMenuItemInsertarUnidad);
        jMenuBar.add(jMenuUnidad);

        jMenuBachilleratos.add(JMenuItemVerBachilleratos);
        jMenuBachilleratos.add(JMenuItemInsertarBachillerato);
        jMenuBar.add(jMenuBachilleratos);

        this.setJMenuBar(jMenuBar);
        pack();
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
