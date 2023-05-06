package logica;
public class Dulce {
    private String nombre;
    private Categoria categoria;
    private short cantidad;
    private short precio;
    public Dulce(String nombre, Categoria categoria, short cantidad, short precio){
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public short getCantidad() {
        return cantidad;
    }
    public void setCantidad(short cantidad) {
        this.cantidad = cantidad;
    }
    public short getPrecio() {
        return precio;
    }
    public void setPrecio(short precio) {
        this.precio = precio;
    }
    public void MostrarDatos(){
        System.out.println("-----------------------------------------------------------------");
        System.out.println("                         Datos Dulce                          ");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("            Nombre: " + getNombre()+"                            \n" 
                        +  "            Precio : "+ getPrecio() +"                           \n"
                        +  "            Categoria : " + getCategoria() +"                \n"                
                        +  "            Cantidad : "+ getCantidad()+"                       "); 
        System.out.println("----------------------------------------------------------------");
    }
}
