package principal;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import logica.Categoria;
import logica.Dulce;

public class App {
    public static void MostrarDetalle(ArrayList<Dulce> lista_dulces){
        short cand_dulce=0, cand_sazucar=0, cand_acido=0;
        int mayor = 0, menor=10,caro = 0, barato =10;
        String nombre_mayor ="",nombre_menor ="",nombre_caro ="",nombre_barato ="";
        for(int i=0; i<lista_dulces.size();i++){
            if(lista_dulces.get(i).getPrecio() > caro ){
                caro = lista_dulces.get(i).getPrecio();
                nombre_caro = lista_dulces.get(i).getNombre();
            }
            if(lista_dulces.get(i).getPrecio() < barato){
                barato = lista_dulces.get(i).getPrecio();
                nombre_barato = lista_dulces.get(i).getNombre();
            }
            if(lista_dulces.get(i).getCantidad() > mayor ){
                mayor = lista_dulces.get(i).getCantidad();
                nombre_mayor = lista_dulces.get(i).getNombre();
            }
            if(lista_dulces.get(i).getCantidad() < menor){
                menor = lista_dulces.get(i).getCantidad();
                nombre_menor = lista_dulces.get(i).getNombre();
            }
            if(lista_dulces.get(i).getCategoria().equals(Categoria.acido)){
                cand_acido += lista_dulces.get(i).getCantidad();
            }
            else if(lista_dulces.get(i).getCategoria().equals(Categoria.dulce)){
                cand_dulce += lista_dulces.get(i).getCantidad();
            }
            else if(lista_dulces.get(i).getCategoria().equals(Categoria.sin_azucar)){
                cand_sazucar += lista_dulces.get(i).getCantidad();
            }
        }
        System.out.println("=================================================================");
        System.out.println("          Cantidad de dulces :" + (cand_acido + cand_sazucar + cand_dulce));
        System.out.println("-----------------------------------------------------------------");
        System.out.println("          Dulces acidos :     "+ cand_acido );
        System.out.println("          Dulces dulces :     "+ cand_dulce );
        System.out.println("          Dulces sin azucar : "+ cand_sazucar );
        System.out.println("-----------------------------------------------------------------");
        System.out.println("          Nombre : "+ nombre_mayor);
        System.out.println("          Dulces Mayor Cantidad : "+ mayor );
        System.out.println("          Nombre : "+ nombre_menor);
        System.out.println("          Dulces Menor Cantidad : "+ menor );
        System.out.println("-----------------------------------------------------------------");
        System.out.println("          Nombre : "+ nombre_caro);
        System.out.println("          Dulces más costoso : "+ caro );
        System.out.println("          Nombre : "+ nombre_barato);
        System.out.println("          Dulces más barato : "+ barato);
        System.out.println("-----------------------------------------------------------------");


        System.out.println("=================================================================");

    }
    public static Boolean IsEmpty(ArrayList<Dulce> lista_dulces){
        if(lista_dulces.isEmpty()){
            System.out.println("-----------------------------------------------------------------");
            System.out.println("        No hay Dulces en la Tienda");
            System.out.println("-----------------------------------------------------------------");
            return true;
        }
        return false;
    }
    //Listo
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
        MostrarDetalle(lista_dulces);
        
    }
    //Listo
    public static void Actualizar_Dulce(ArrayList<Dulce> lista_dulces){
        //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        if(IsEmpty(lista_dulces)){
            JOptionPane.showMessageDialog(null, "No es posible Actualizar Dulce", null, 0);
        }
        else{
            int i=0;
            i = Buscar_Dulce(lista_dulces);
            if(i>=0){
            String nombre;
            short precio,cantidad;
            int opcion;
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Que desea cambiar de su mascota\n"
            +"1.Cambia el nombre del Dulce.\n"
            +"2.Cambiar el precio del Dulce\n"
            +"3.Cambiar la cantidad del Dulce"));
            System.out.println("-----------------------------------------------------------------");
            System.out.println("=================================================================");
            switch(opcion){
                case 1:
                //Cambia el nombre del dulce
                System.out.println("Cambia el nombre");
                System.out.println("Nombre actual : "+lista_dulces.get(i).getNombre());
                nombre = JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre del Dulce:");
                lista_dulces.get(i).setNombre(nombre);
                System.out.println("Nombre nuevo : " + lista_dulces.get(i).getNombre());
                break;
                case 2:
                //Cambiar la precio del dulce
                System.out.println("Cambia Precio");
                System.out.println("Precio anterior : "+lista_dulces.get(i).getPrecio());
                precio = Short.parseShort(JOptionPane.showInputDialog(null, "Ingrese el precio nueva del Dulce:"));
                lista_dulces.get(i).setPrecio(precio);
                System.out.println("Precio nueva : " + lista_dulces.get(i).getPrecio());
                break;
                case 3:
                //Cambiar la cantidad del dulce
                System.out.println("Cambia cantidad");
                System.out.println("Cantidad anterior : "+lista_dulces.get(i).getCantidad());
                cantidad = Short.parseShort(JOptionPane.showInputDialog(null, "Ingrese la cantidad nueva del Dulce:"));
                lista_dulces.get(i).setCantidad(cantidad);
                System.out.println("Cantidad nueva : " + lista_dulces.get(i).getCantidad());
                break;
            }
            System.out.println("=================================================================");
            //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            lista_dulces.get(i).MostrarDatos();
            }
            else{
                JOptionPane.showMessageDialog(null,"Al parecer esa Dulce no esta aqui");
            }
        }
    }
    //Listo
    public static void Eliminar_Dulce(ArrayList<Dulce> lista_dulces){
        //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        if(IsEmpty(lista_dulces)){
            JOptionPane.showMessageDialog(null, "No es posible Eliminar Mascota", null, 0);
        }
        else{
            int i= 0;
            i = Buscar_Dulce(lista_dulces);
            //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                lista_dulces.remove(i);
                System.out.println("----------------------------------------------------\n              Dulce Eliminada\n----------------------------------------------------");
                JOptionPane.showMessageDialog(null, "Se elimino el dulce", null, 1);
        }
           
    }
    //Listo
    public static int Buscar_Dulce(ArrayList<Dulce> lista_dulces){
        //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        if(IsEmpty(lista_dulces)){
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
    //Listo
    public static void Listar_Dulces(ArrayList<Dulce> lista_dulces){
        //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        if(IsEmpty(lista_dulces)){
            JOptionPane.showMessageDialog(null, "No es posible Mostrar los Dulces", null, 0);
        }
        else{
            System.out.println("=================================================================");
            System.out.println("|                     Inventario Dulces                         |");
            System.out.println("=================================================================");
            for (int i = 0; i < lista_dulces.size(); i++){
                lista_dulces.get(i).MostrarDatos();
            }    
        }
    }
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
