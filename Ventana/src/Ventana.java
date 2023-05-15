import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Ventana extends JFrame implements ActionListener {

    JPanel panelPrincipal, panelPrincipal2, panelPrincipal3, panelEspacioDerecha, panelEspacioIzquierda, panelEspacioAbajo, panelInsertar, panelInsertarEtiquetas, panelActualizar, panelActualizarCodigo, panelActualizarDatos;
    ImageIcon imagenIcono;
    JLabel logoRinconDulce, etiquetaActualizar, etiqueta2;
    JButton[] botonesPanelPrincipal = new JButton[6];
    JLabel[] etiquetasPanelInsertar = new JLabel[4];
    String opcionesPanelPrincipal[] = {"Insertar Dulce", "Actualizar Dulces", "Eliminar Dulces", "Buscar Dulces", "Listar Dulces", "Resumen Dulces"};
    String opcionesPanelEtiquetas[] = {"Nombre", "Categoria", "Precio", "Cantidad"};
    JButton botonEnviarInsertar, botonEnviarActualizar;
    JTextArea areaTextoNombre, areaTextoPrecio, areaTextoCantidad, areaTextoActualizar;
    String[] opciones = {"Acido","Dulce","Sin Azucar"};
    JComboBox<String> categorias;
    JScrollPane scroll, scroll2, scroll3;
    String contenido, contenido2, contenido3, contenido4;

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

        scroll = new JScrollPane(areaTextoNombre, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll2 = new JScrollPane(areaTextoPrecio, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll3 = new JScrollPane(areaTextoCantidad, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        scroll.setBorder(BorderFactory.createLineBorder(Color.decode("#FFF3F9"),30));
        scroll2.setBorder(BorderFactory.createLineBorder(Color.decode("#FFF3F9"),30));
        scroll3.setBorder(BorderFactory.createLineBorder(Color.decode("#FFF3F9"),30));

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
                panelInsertarEtiquetas.add(scroll);
            }
            else if(i == 1){
                panelInsertarEtiquetas.add(etiquetasPanelInsertar[1]);
                panelInsertarEtiquetas.add(categorias);
            }
            else if(i == 2){
                panelInsertarEtiquetas.add(etiquetasPanelInsertar[2]);
                panelInsertarEtiquetas.add(scroll2);
            }
            else{
                panelInsertarEtiquetas.add(etiquetasPanelInsertar[3]);
                panelInsertarEtiquetas.add(scroll3);
            }
        }
        
        
        botonEnviarInsertar = new JButton("Enviar");
        botonEnviarInsertar.addActionListener(this);
        
        panelInsertar.add(panelInsertarEtiquetas, BorderLayout.CENTER);
        panelInsertar.add(botonEnviarInsertar, BorderLayout.SOUTH);

        panelActualizar = new JPanel(new GridLayout(2,1));
        panelActualizarCodigo = new JPanel(new BorderLayout());
        panelActualizarDatos = new JPanel(new BorderLayout());

        panelActualizar.setBackground(Color.decode("#FFF3F9"));

        etiquetaActualizar = new JLabel("Ingrese el codigo");
        etiquetaActualizar.setFont(new Font("Arial", Font.BOLD, 40));
        etiquetaActualizar.setHorizontalAlignment(SwingConstants.CENTER);

        areaTextoActualizar = new JTextArea();
        areaTextoActualizar.setBorder(BorderFactory.createLineBorder(Color.decode("#FFF3F9"),70));
        areaTextoActualizar.setFont(new Font("Arial", Font.BOLD, 50));
        areaTextoActualizar.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                if(areaTextoActualizar.getText().length() >= 6){
                    e.consume();
                }
            }
        });

        botonEnviarActualizar = new JButton("Enivar");
        botonEnviarActualizar.addActionListener(this);
        panelActualizarCodigo.add(areaTextoActualizar, BorderLayout.CENTER);
        panelActualizarCodigo.add(botonEnviarActualizar, BorderLayout.SOUTH);
        
        panelActualizar.add(etiquetaActualizar);
        panelActualizar.add(panelActualizarCodigo);
    }

    public void actionPerformed(ActionEvent e){
        contenido = areaTextoNombre.getText().trim();
        contenido2 = areaTextoPrecio.getText().trim();
        contenido3 = areaTextoCantidad.getText().trim();
        contenido4 = areaTextoActualizar.getText().trim();
        if(e.getSource()==botonesPanelPrincipal[0]){
            panelPrincipal.setVisible(false);
            panelInsertar.setVisible(true);
            add(panelInsertar);
        }
        else if(e.getSource()==botonEnviarInsertar){
            if(contenido.isEmpty() || contenido2.isEmpty() || contenido3.isEmpty()){
                JOptionPane.showMessageDialog(null,"Llene todas las casillas","Advertencia",JOptionPane.WARNING_MESSAGE);       
            }
            else{
                JOptionPane.showMessageDialog(null,"El codigo del producto es: ", "CODIGO", JOptionPane.INFORMATION_MESSAGE);
                areaTextoNombre.setText(null);
                categorias.setSelectedItem("Acido");
                areaTextoPrecio.setText(null);;
                areaTextoCantidad.setText(null);
                panelInsertar.setVisible(false);
                panelPrincipal.setVisible(true);
                add(panelPrincipal);
            }
            
        }
        else if(e.getSource()==botonesPanelPrincipal[1]){
            panelPrincipal.setVisible(false);
            panelActualizar.setVisible(true);
            add(panelActualizar);
        }
        else if(e.getSource()==botonEnviarActualizar){
            if(contenido4.isEmpty() || contenido4.length()<6){
                JOptionPane.showMessageDialog(null,"El codigo debe ser de 6 caracteres","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                panelActualizarCodigo.setVisible(false);              
            }
        }
    }
}
