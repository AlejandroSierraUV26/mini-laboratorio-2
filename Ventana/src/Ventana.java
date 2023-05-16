import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Ventana extends JFrame implements ActionListener {

    JPanel panelPrincipal, panelPrincipal2, panelPrincipal3, panelEspacioDerecha, panelEspacioIzquierda, panelEspacioAbajo, panelInsertar, panelInsertarEtiquetas, panelActualizar, panelActualizarDatos, panelActualizarOpciones, panelEliminar, panelBuscar, panelBuscarSuperior, panelBuscarInferior;
    ImageIcon imagenIcono;
    JLabel logoRinconDulce, etiquetaActualizar, etiquetaActualizarDatos, etiquetaRelleno1, etiquetaRelleno2, etiquetaEliminar, etiquetaBuscar;
    JButton[] botonesPanelPrincipal = new JButton[6];
    JLabel[] etiquetasPanelInsertar = new JLabel[4];
    String opcionesPanelPrincipal[] = {"Insertar Dulce", "Actualizar Dulces", "Eliminar Dulces", "Buscar Dulces", "Listar Dulces", "Resumen Dulces"};
    String opcionesPanelEtiquetas[] = {"Nombre", "Categoria", "Precio", "Cantidad"};
    JButton botonEnviarInsertar, botonEnviarActualizar, botonEnviarActualizarOpciones, botonEliminar, botonBuscar, botonRegresar;
    JTextArea areaTextoNombre, areaTextoPrecio, areaTextoCantidad, areaTextoActualizar, areaTextoActualizarNombre, areaTextoActualizarPrecio, areaTextoActualizarCantidad, areaTextoEliminar, areaTextoBuscar;
    String[] opciones = {"Acido","Dulce","Sin Azucar"};
    JComboBox<String> categorias;
    JScrollPane scroll, scroll2, scroll3, scroll4, scroll5, scroll6;
    String contenido, contenido2, contenido3, contenido4, contenido5, contenido6, contenido7, contenido8, contenido9;
    JCheckBox checkBox1, checkBox2, checkBox3;
    JTextField campoTexto;

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

        panelActualizar = new JPanel(new GridLayout(3,1));
        panelActualizarDatos = new JPanel(new GridLayout(2,1));
        panelActualizarOpciones = new JPanel(new GridLayout(3,3));


        panelActualizar.setBackground(Color.decode("#FFF3F9"));
        panelActualizarDatos.setBackground(Color.decode("#FFF3F9"));
        panelActualizarOpciones.setBackground(Color.decode("#FFF3F9"));

        etiquetaActualizar = new JLabel("Ingrese el codigo");
        etiquetaActualizar.setFont(new Font("Arial", Font.BOLD, 40));
        etiquetaActualizar.setHorizontalAlignment(SwingConstants.CENTER);

        areaTextoActualizar = new JTextArea();
        areaTextoActualizar.setBorder(BorderFactory.createLineBorder(Color.decode("#FFF3F9"),45));
        areaTextoActualizar.setFont(new Font("Arial", Font.BOLD, 50));
        areaTextoActualizar.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                if(areaTextoActualizar.getText().length() >= 6){
                    e.consume();
                }
            }
        });

        botonEnviarActualizar = new JButton("Enviar");
        botonEnviarActualizar.addActionListener(this);
        botonEnviarActualizar.setBorder(BorderFactory.createLineBorder(Color.decode("#FFF3F9"),50));
        botonEnviarActualizar.setFont(new Font("Arial", Font.BOLD, 30));
        panelActualizar.add(etiquetaActualizar);
        panelActualizar.add(areaTextoActualizar);
        panelActualizar.add(botonEnviarActualizar);

        etiquetaActualizarDatos = new JLabel("CODIGO");
        etiquetaActualizarDatos.setFont(new Font("Arial", Font.BOLD, 40));
        etiquetaActualizarDatos.setHorizontalAlignment(SwingConstants.CENTER);

        checkBox1 = new JCheckBox("Nombre");
        checkBox2 = new JCheckBox("Precio");
        checkBox3 = new JCheckBox("Cantidad");

        checkBox1.setBackground(Color.decode("#FFF3F9"));
        checkBox2.setBackground(Color.decode("#FFF3F9"));
        checkBox3.setBackground(Color.decode("#FFF3F9"));

        checkBox1.setFont(new Font("Arial", Font.BOLD, 20));
        checkBox2.setFont(new Font("Arial", Font.BOLD, 20));
        checkBox3.setFont(new Font("Arial", Font.BOLD, 20));

        checkBox1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                if(e.getStateChange() == ItemEvent.SELECTED){
                    scroll4.setVisible(true);
                }
                else{
                    scroll4.setVisible(false);
                }
            }
        });
        checkBox2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                if(e.getStateChange() == ItemEvent.SELECTED){
                    scroll5.setVisible(true);
                }
                else{
                    scroll5.setVisible(false);
                }
            }
        });
        checkBox3.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                if(e.getStateChange() == ItemEvent.SELECTED){
                    scroll6.setVisible(true);
                }
                else{
                    scroll6.setVisible(false);
                }
            }
        });

        etiquetaRelleno1 = new JLabel();
        etiquetaRelleno1.setBackground(Color.decode("#FFF3F9"));
        etiquetaRelleno2 = new JLabel();
        etiquetaRelleno2.setBackground(Color.decode("#FFF3F9"));

        areaTextoActualizarNombre = new JTextArea();
        areaTextoActualizarPrecio = new JTextArea();
        areaTextoActualizarCantidad = new JTextArea();

        areaTextoActualizarNombre.setFont(new Font("Arial", Font.BOLD, 25));
        areaTextoActualizarPrecio.setFont(new Font("Arial", Font.BOLD, 25));
        areaTextoActualizarCantidad.setFont(new Font("Arial", Font.BOLD, 25));

        scroll4 = new JScrollPane(areaTextoActualizarNombre, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll5 = new JScrollPane(areaTextoActualizarPrecio, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll6 = new JScrollPane(areaTextoActualizarCantidad, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        scroll4.setBorder(BorderFactory.createLineBorder(Color.decode("#FFF3F9"),15));
        scroll5.setBorder(BorderFactory.createLineBorder(Color.decode("#FFF3F9"),15));
        scroll6.setBorder(BorderFactory.createLineBorder(Color.decode("#FFF3F9"),15));

        botonEnviarActualizarOpciones = new JButton("Enviar");
        botonEnviarActualizarOpciones.addActionListener(this);
        botonEnviarActualizarOpciones.setFont(new Font("Arial", Font.BOLD, 20));
        botonEnviarActualizarOpciones.setBorder(BorderFactory.createLineBorder(Color.decode("#FFF3F9"),15));

        scroll4.setVisible(false);
        scroll5.setVisible(false);
        scroll6.setVisible(false);

        panelActualizarOpciones.add(checkBox1);
        panelActualizarOpciones.add(scroll4);
        panelActualizarOpciones.add(etiquetaRelleno1);
        panelActualizarOpciones.add(checkBox2);
        panelActualizarOpciones.add(scroll5);
        panelActualizarOpciones.add(etiquetaRelleno2);
        panelActualizarOpciones.add(checkBox3);
        panelActualizarOpciones.add(scroll6);
        panelActualizarOpciones.add(botonEnviarActualizarOpciones);

        panelActualizarDatos.add(etiquetaActualizarDatos);
        panelActualizarDatos.add(panelActualizarOpciones);

        panelEliminar = new JPanel(new BorderLayout());
        panelEliminar.setBackground(Color.decode("#FFF3F9"));

        etiquetaEliminar = new JLabel("Ingrese el codigo");
        etiquetaEliminar.setFont(new Font("Arial", Font.BOLD, 40));
        etiquetaEliminar.setHorizontalAlignment(SwingConstants.CENTER);

        areaTextoEliminar = new JTextArea();
        areaTextoEliminar.setBorder(BorderFactory.createLineBorder(Color.decode("#FFF3F9"),45));
        areaTextoEliminar.setFont(new Font("Arial", Font.BOLD, 50));
        areaTextoEliminar.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                if(areaTextoEliminar.getText().length() >= 6){
                    e.consume();
                }
            }
        });

        botonEliminar = new JButton("Eliminar");
        botonEliminar.addActionListener(this);
        botonEliminar.setBorder(BorderFactory.createLineBorder(Color.decode("#FFF3F9"),110));
        botonEliminar.setFont(new Font("Arial", Font.BOLD, 30));

        panelEliminar.add(etiquetaEliminar, BorderLayout.NORTH);
        panelEliminar.add(areaTextoEliminar, BorderLayout.CENTER);
        panelEliminar.add(botonEliminar, BorderLayout.SOUTH);

        panelBuscar = new JPanel(new GridLayout(2,1));
        panelBuscarSuperior = new JPanel(new GridLayout(3,1));
        panelBuscarInferior = new JPanel(new BorderLayout());

        panelBuscarSuperior.setBackground(Color.decode("#FFF3F9"));

        etiquetaBuscar = new JLabel("Ingrese el codigo");
        etiquetaBuscar.setFont(new Font("Arial", Font.BOLD, 40));
        etiquetaBuscar.setHorizontalAlignment(SwingConstants.CENTER);

        areaTextoBuscar = new JTextArea();
        areaTextoBuscar.setBorder(BorderFactory.createLineBorder(Color.decode("#FFF3F9"),5));
        areaTextoBuscar.setFont(new Font("Arial", Font.BOLD, 50));
        areaTextoBuscar.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                if(areaTextoBuscar.getText().length() >= 6){
                    e.consume();
                }
            }
        });

        botonBuscar = new JButton("Buscar");
        botonBuscar.addActionListener(this);
        botonBuscar.setBorder(BorderFactory.createLineBorder(Color.decode("#FFF3F9"),5));
        botonBuscar.setFont(new Font("Arial", Font.BOLD, 30));

        panelBuscarSuperior.add(etiquetaBuscar);
        panelBuscarSuperior.add(areaTextoBuscar);
        panelBuscarSuperior.add(botonBuscar);

        campoTexto = new JTextField();
        campoTexto.setEditable(false);
        //campoTexto.setBackground(Color.decode("#FFF3F9"));
        campoTexto.setBorder(BorderFactory.createLineBorder(Color.decode("#FFF3F9"),50));

        botonRegresar = new JButton("Regresar");
        botonRegresar.addActionListener(this);

        panelBuscarInferior.add(campoTexto, BorderLayout.CENTER);
        panelBuscarInferior.add(botonRegresar, BorderLayout.SOUTH);


        panelBuscar.add(panelBuscarSuperior);
        panelBuscar.add(panelBuscarInferior);
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
                areaTextoActualizar.setText(null);
                panelActualizar.setVisible(false);             
                panelActualizarDatos.setVisible(true);
                add(panelActualizarDatos);
            }
        }
        else if(e.getSource() == botonEnviarActualizarOpciones){
            contenido5 = areaTextoActualizarNombre.getText().trim();
            contenido6 = areaTextoActualizarPrecio.getText().trim();
            contenido7 = areaTextoActualizarCantidad.getText().trim();
            if(contenido5.isEmpty() && contenido6.isEmpty() && contenido7.isEmpty()){
                JOptionPane.showMessageDialog(null,"Debes seleccionar una opcion y llenarla para actualizar","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null,"Producto Actualizado","Actualizado",JOptionPane.INFORMATION_MESSAGE);
                checkBox1.setSelected(false);
                checkBox2.setSelected(false);
                checkBox3.setSelected(false);
                areaTextoActualizarNombre.setText(null);
                areaTextoActualizarPrecio.setText(null);
                areaTextoActualizarCantidad.setText(null);
                panelActualizarDatos.setVisible(false);
                panelPrincipal.setVisible(true);
                add(panelPrincipal);
            }
        }
        else if(e.getSource() == botonesPanelPrincipal[2]){
            panelPrincipal.setVisible(false);
            panelEliminar.setVisible(true);
            add(panelEliminar);
        }
        else if(e.getSource() == botonEliminar){
            contenido8 = areaTextoEliminar.getText().trim();
            if(contenido8.isEmpty() || contenido8.length()<6){
                JOptionPane.showMessageDialog(null,"El codigo debe ser de 6 caracteres","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null,"Producto Eliminado","Eliminado",JOptionPane.INFORMATION_MESSAGE);
                areaTextoEliminar.setText(null);
                panelEliminar.setVisible(false);
                panelPrincipal.setVisible(true);
                add(panelPrincipal);
            }
        }
        else if(e.getSource() == botonesPanelPrincipal[3]){
            panelPrincipal.setVisible(false);
            panelBuscar.setVisible(true);
            add(panelBuscar);
        }
        else if(e.getSource() == botonBuscar){
            contenido9 = areaTextoBuscar.getText().trim();
            if(contenido9.isEmpty() || contenido9.length()<6){
                JOptionPane.showMessageDialog(null,"El codigo debe ser de 6 caracteres","Advertencia",JOptionPane.WARNING_MESSAGE);
            }
            else{
                campoTexto.setBackground(Color.decode("#FFF3F9"));
            }
            
        }
        else if(e.getSource() == botonRegresar){
            areaTextoBuscar.setText(null);
            campoTexto.setBackground(null);
            panelBuscar.setVisible(false);
            panelPrincipal.setVisible(true);
            add(panelPrincipal);
        }
    }
}
