package logica;

public class Dulce {
    private String nombre;
    private Categoria categoria;
    private short cantidad,cand_dulce,cand_acido,cand_sazucar;
    private short precio;
    public Dulce(String nombre, Categoria categoria, short cantidad, short precio){
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precio = precio;

    }
    public void AgregarDulce(Categoria caterCategoria, short cantidad){
        switch(categoria){
            case dulce:
            cand_dulce++;
            break;
            case acido:
            cand_acido++;
            break;
            case sin_azucar:
            cand_sazucar++;
            break;
            default:
            System.out.println("No Hola");
            break;
        }
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
    public short getCand_dulce() {
        return cand_dulce;
    }
    public void setCand_dulce(short cand_dulce) {
        this.cand_dulce = cand_dulce;
    }
    public short getCand_acido() {
        return cand_acido;
    }
    public void setCand_acido(short cand_acido) {
        this.cand_acido = cand_acido;
    }
    public short getCand_sazucar() {
        return cand_sazucar;
    }
    public void setCand_sazucar(short cand_sazucar) {
        this.cand_sazucar = cand_sazucar;
    }
    public void MostrarDetalle(){
        System.out.println("=================================================================");
        System.out.println("          Cantidad de dulces :" + (cand_acido + cand_sazucar + cand_dulce));
        System.out.println("-----------------------------------------------------------------");
        System.out.println("          Dulces acidos :     " +getCand_acido());
        System.out.println("          Dulces dulces :     " +getCand_dulce());
        System.out.println("          Dulces sin azucar : "+ getCand_sazucar());
        System.out.println("=================================================================");

    }
    public void MostrarDatos(){
        System.out.println("-----------------------------------------------------------------");
        System.out.println("                         Datos Dulce                          ");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("|           Nombre: " + getNombre()+"                            \n" 
                        +  "|           Precio : "+ getPrecio() +"                           \n"
                        +  "|           Categoria : " + getCategoria() +"                \n"                
                        +  "|           Cantidad : "+ getCantidad()+"                       "); 
        System.out.println("-----------------------------------------------------------------");
    }
}
