import java.util.HashMap;
import java.util.Scanner;

public class Stock{
    private HashMap<String, HashMap<Integer,Producto>> inventario;
    private HashMap<String, Integer> contadores = new HashMap<>();
    private Scanner in = new Scanner(System.in);
    public Stock(){
        inventario= new HashMap<>();
    }
    public void agregarCategoria(String categoria){
        inventario.put(categoria, new HashMap<>());
    }
    public void agregarProducto(String categoria, Producto producto){
        inventario.get(categoria).put( producto.getCodigo(), producto);
    }
    public void mostrarProducto(String categoria, Integer codigo){
        inventario.get(categoria).get(codigo).imprimirProducto();
    }

    public HashMap<String, HashMap<Integer,Producto>> getInventario(){
        return this.inventario;
    }

    public int generadorCodigo(String categoria) {
        // Obtener contador actual o 0 si no existe
        int contador = contadores.getOrDefault(categoria, 0);
        contador++;
        contadores.put(categoria, contador);
        return contador;
    }

    public void borrarProducto(){
        System.out.println("Ingrese la categoria del producto");
        String categoria = in.nextLine();
        if(!(inventario.containsKey(categoria))){
            System.out.println("Categoria no Existente");
            return;
        }
        System.out.println("Ingrese el codigo del producto");
        int codigo = in.nextInt();
        in.nextLine();
        if(!inventario.get(categoria).containsKey(codigo)){
            System.out.println("Codigo no Existente");
            return;
        }
        inventario.get(categoria).remove(codigo);
        System.out.println("\nProducto Borrado existosamente");
    }
    

    public void modificarProducto(String categoria,int codigo, Producto producto){
            inventario.get(categoria).get(codigo).setNombre(producto.getNombre());
            inventario.get(categoria).get(codigo).setPrecio(producto.getPrecio());
            inventario.get(categoria).get(codigo).setCantidad(producto.getCantidad());
    }       

}