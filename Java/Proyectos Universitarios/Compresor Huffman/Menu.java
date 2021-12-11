import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 * Este clase crea el menú de la interfaz del programa.
 * @author Daniel Pérez
 * @author Randy Sancho
 * @author Yerlan Irola
 * @version 3/12/21
 */
public class Menu extends JFrame implements ActionListener
{
    App app;
    JMenuBar jMenuBar;
    JMenu jMenu;
    JLabel ext;
    JLabel huf;
    JTextField nom_Arch_Comprimir;
    JTextField nom_Arch_Descomprimir;
    JButton botonComprimir;
    JButton botonDescomprimir;
    JFileChooser chooser;
    
    /**
     * Este es el constructor de la clase Menu, la cual se inicializa con el objeto tipo App.
     * @param app
     * este parametro es un objeto tipo app.
     */
    public Menu(App app)
    {
        this.app = app; 
        
        jMenuBar = new JMenuBar();
        setJMenuBar(jMenuBar);
        
        jMenu = new JMenu();
        jMenuBar.add(jMenu);
        
        chooser = new JFileChooser();
        
        init();
    }
    
    /**
     * Este metodo construlle la interfaz grafica del menú.
     */
    public void interfazGrafica()
    {
        JPanel jPanel = new JPanel();
        
        ext = new JLabel("Ingrese Nombre del Documento .ext");
        huf = new JLabel("Ingrese Nombre del Documento .huf");
        
        
        botonComprimir = new JButton("Comprimir");
        botonDescomprimir = new JButton("Descomprimir");
        
        jPanel.add(ext);
        jPanel.add(botonComprimir);
        jPanel.add(huf);
        jPanel.add(botonDescomprimir);
        
        botonComprimir.addActionListener(this);
        botonDescomprimir.addActionListener(this);
        
        jMenuBar.add(jPanel);
    }
    
    /**
     * Este metodo indica las acciones realizadas por los botones.
     * @param e
     * este parametro es un objeto tivo ActionEvent.
     */
    public void actionPerformed(ActionEvent e)
    {
        JMenuBar menuBar2 = new JMenuBar();
        setJMenuBar(menuBar2);
        if(e.getSource() == botonComprimir){
            FileNameExtensionFilter  filter = new FileNameExtensionFilter("Archivo .ext", "ext");
            chooser.setFileFilter(filter);
            chooser.showOpenDialog(menuBar2);
            app.comprimir(chooser.getSelectedFile().getName() );
        } 
        if(e.getSource() == botonDescomprimir){
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo .huf", "huf");
            chooser.setFileFilter(filter);
            chooser.showOpenDialog(menuBar2);
            app.descomprimir(chooser.getSelectedFile().getName() );
        }
        setJMenuBar(jMenuBar);
    }
    
    /**
     * Este metodo Inicializa los parametros de la interfaz.
     */
    public void init()
    {
        setTitle("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 200);
        setBackground(new Color(127, 255, 212));
        getContentPane().setBackground(new Color(245, 245, 220));
        interfazGrafica();
        setVisible(true);
    }
}
