import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener {

    JPanel panelPrincipal, panelPrincipal2, panelPrincipal3, panelEspacioDerecha, panelEspacioIzquierda, panelEspacioAbajo, panelInsertar, panelInsertarEtiquetas, panelInsertarSeleccion;
    ImageIcon imagenIcono;
    JLabel logoRinconDulce;
    JButton[] botonesPanelPrincipal = new JButton[6];
    JLabel[] etiquetasPanelInsertar = new JLabel[4];
    String opcionesPanelPrincipal[] = {"Insertar Dulce", "Actualizar Dulces", "Eliminar Dulces", "Buscar Dulces", "Listar Dulces", "Resumen Dulces"};
    String opcionesPanelEtiquetas[] = {"Nombre", "Categoria", "Precio", "Cantidad"};
    JButton botonEnviarInsertar;
    JTextArea areaTextoNombre, areaTextoPrecio, areaTextoCantidad;
    String[] opciones = {"Acido","Dulce","Sin Azucar"};
    JComboBox<String> categorias;

    public Ventana(){
        setSize(500, 500); 
        setTitle("RINCON DULCE");
        setResizable(false);
        
        setLocationRelativeTo(null);
        iniciarComponentes();


        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void iniciarComponentes(){
        panelPrincipal = new JPanel();
        this.getContentPane().add(panelPrincipal);
        imagenIcono = new ImageIcon(getClass().getResource("recursos/Logo_Rincon_Dulce.jpg"));
        logoRinconDulce = new JLabel(imagenIcono);
        panelPrincipal.setLayout(new GridLayout(2,1));
        panelPrincipal.add(logoRinconDulce);  
        panelPrincipal.setBackground(Color.decode("#FFF3F9"));
        panelPrincipal2 = new JPanel();
        panelPrincipal2.setLayout(new BorderLayout());
        panelPrincipal3 = new JPanel();
        panelPrincipal3.setLayout(new GridLayout(6,1));
        
        for(int i = 0; i<botonesPanelPrincipal.length; i++){
            botonesPanelPrincipal[i] = new JButton();
            botonesPanelPrincipal[i].addActionListener(this);
            botonesPanelPrincipal[i].setFont(new Font("Arial",Font.BOLD,15));
            botonesPanelPrincipal[i].setBackground(Color.decode("#FFFFFF"));
            botonesPanelPrincipal[i].setText(opcionesPanelPrincipal[i]);
            botonesPanelPrincipal[i].setBorder(BorderFactory.createLineBorder(Color.decode("#FFF3F9"),5));
            panelPrincipal3.add(botonesPanelPrincipal[i]);
        }

        panelEspacioDerecha = new JPanel();
        panelEspacioIzquierda = new JPanel();
        panelEspacioAbajo = new JPanel();

        panelEspacioDerecha.setPreferredSize(new Dimension(160, 0));
        panelEspacioIzquierda.setPreferredSize(new Dimension(160, 0));
        panelEspacioAbajo.setPreferredSize(new Dimension(0, 20));

        panelEspacioDerecha.setBackground(Color.decode("#FFF3F9"));
        panelEspacioIzquierda.setBackground(Color.decode("#FFF3F9"));
        panelEspacioAbajo.setBackground(Color.decode("#FFF3F9"));

        panelPrincipal2.add(panelEspacioDerecha, BorderLayout.EAST);
        panelPrincipal2.add(panelEspacioIzquierda, BorderLayout.WEST);
        panelPrincipal2.add(panelEspacioAbajo, BorderLayout.SOUTH);
        
        panelPrincipal2.add(panelPrincipal3, BorderLayout.CENTER);
        panelPrincipal.add(panelPrincipal2);

        panelInsertar = new JPanel(new BorderLayout());
        panelInsertarEtiquetas = new JPanel(new GridLayout(4,2));
        panelInsertarEtiquetas.setBackground(Color.decode("#FFF3F9"));
        
        areaTextoNombre = new JTextArea();
        areaTextoPrecio = new JTextArea();
        areaTextoCantidad = new JTextArea();

        areaTextoNombre.setFont(new Font("Arial", Font.BOLD, 25));
        areaTextoPrecio.setFont(new Font("Arial", Font.BOLD, 25));
        areaTextoCantidad.setFont(new Font("Arial", Font.BOLD, 25));

        areaTextoNombre.setBorder(BorderFactory.createLineBorder(Color.decode("#FFF3F9"),30));
        areaTextoPrecio.setBorder(BorderFactory.createLineBorder(Color.decode("#FFF3F9"),30));
        areaTextoCantidad.setBorder(BorderFactory.createLineBorder(Color.decode("#FFF3F9"),30));

        categorias = new JComboBox<>(opciones);
        categorias.setBorder(BorderFactory.createLineBorder(Color.decode("#FFF3F9"),30));
        categorias.setFont(new Font("Arial", Font.BOLD,25));
        for(int i = 0; i<etiquetasPanelInsertar.length; i++){
            etiquetasPanelInsertar[i] = new JLabel();
            etiquetasPanelInsertar[i].setText(opcionesPanelEtiquetas[i]);
            etiquetasPanelInsertar[i].setFont(new Font("Arial", Font.BOLD, 40));
            etiquetasPanelInsertar[i].setHorizontalAlignment(SwingConstants.CENTER);
            if(i==0){
                panelInsertarEtiquetas.add(etiquetasPanelInsertar[0]);
                panelInsertarEtiquetas.add(areaTextoNombre);
            }
            else if(i == 1){
                panelInsertarEtiquetas.add(etiquetasPanelInsertar[1]);
                panelInsertarEtiquetas.add(categorias);
            }
            else if(i == 2){
                panelInsertarEtiquetas.add(etiquetasPanelInsertar[2]);
                panelInsertarEtiquetas.add(areaTextoPrecio);
            }
            else{
                panelInsertarEtiquetas.add(etiquetasPanelInsertar[3]);
                panelInsertarEtiquetas.add(areaTextoCantidad);
            }
        }
        
        
        botonEnviarInsertar = new JButton("Enviar");
        botonEnviarInsertar.addActionListener(this);
        
        panelInsertar.add(panelInsertarEtiquetas, BorderLayout.CENTER);
        panelInsertar.add(botonEnviarInsertar, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==botonesPanelPrincipal[0]){
            panelPrincipal.setVisible(false);
            panelInsertar.setVisible(true);
            add(panelInsertar);
        }
        else if(e.getSource()==botonEnviarInsertar){
            panelInsertar.setVisible(false);
            panelPrincipal.setVisible(true);
            add(panelPrincipal);
        }
    }
}
