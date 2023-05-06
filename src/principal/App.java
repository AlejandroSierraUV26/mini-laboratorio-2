package principal;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import logica.Categoria;
import logica.Dulce;

public class App {
    public static void Insertar_Dulce(ArrayList<Dulce> lista_dulces){
        //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        String nombre;
        Short cantidad,precio;
        Categoria categoria;
        int opcion;
        nombre = JOptionPane.showInputDialog("Ingrese el nombre del dulce");
        cantidad = Short.parseShort(JOptionPane.showInputDialog("Ingrese la cantidad de dulces:"));
        precio = Short.parseShort(JOptionPane.showInputDialog("Ingrese el precio del dulce:"));
        opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la categoria del dulce"));
        switch(opcion){
            case 1: 
                categoria = Categoria.acido;
                break;
            case 2:
                categoria = Categoria.dulce;
                break;
            case 3:
                categoria = Categoria.sin_azucar;
                break;
            default:
                categoria = null;
                break;
        }
        Dulce n1 = new Dulce(nombre,categoria,cantidad,precio);
        n1.MostrarDatos();
        lista_dulces.add(n1);
    }
    public static void Actualizar_Dulce(ArrayList<Dulce> lista_dulces){

    }
    public static void Eliminar_Dulce(ArrayList<Dulce> lista_dulces){}
    public static int Buscar_Dulce(ArrayList<Dulce> lista_dulces){
        //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        if(lista_dulces.size()== 0){
            System.out.println("-----------------------------------------------------------------");
            System.out.println("        No hay Dulces en la tienda");
            System.out.println("-----------------------------------------------------------------");
            JOptionPane.showMessageDialog(null, "No es posible Buscar el Dulce", null, 0);
        }
        else{
        String nombre;
        nombre = JOptionPane.showInputDialog(null,"Ingrese el nombre del Dulce");
        //Crear la forma para que sea nombre o codigo
        for(int i=0; i<lista_dulces.size();i++){
            if(lista_dulces.get(i).getNombre().equals(nombre)){
                lista_dulces.get(i).MostrarDatos();
                return i;
            }
            }
        }
        return -1;
    }
    public static void Listar_Dulces(ArrayList<Dulce> lista_dulces){}
    public static void main(String[] args) throws Exception {
    Byte opcion;
    ArrayList <Dulce> lista_dulces = new ArrayList<Dulce>();
    while(true){
            opcion = Byte.parseByte(JOptionPane.showInputDialog("Seleccione la opcion que desea: \n1. Insertar dulces\n2. Actualizar dulces\n3. Eliminar dulces\n4. Buscar dulces por nombre\n5. Listar todas las dulces\n6. Salir", null));
            switch(opcion){
                case 1:Insertar_Dulce(lista_dulces);break;
                case 2:Actualizar_Dulce(lista_dulces);break;
                case 3:Eliminar_Dulce(lista_dulces);break;
                case 4:Buscar_Dulce(lista_dulces);break;
                case 5:Listar_Dulces(lista_dulces);break;
                case 6:System.exit(0);default:break;
           }
        }
    }
}
