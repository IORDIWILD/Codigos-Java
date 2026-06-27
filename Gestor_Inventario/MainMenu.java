import java.util.Scanner;
public class MainMenu {
    
    public static void main(String args[]){
    boolean menu=true;
    Stock inventario = new Stock();
    int sw;
    Scanner in = new Scanner(System.in);   
    while(menu){
    System.out.println(" \n Ingrese la opcion deseada:");
    System.out.println("1- Mostrar Productos");
    System.out.println("2- Modificar Producto");
    System.out.println("3- Borrar Producto");
    System.out.println("4- Agregar Categoria");
    System.out.println("5- Agregar Producto");
    sw = in.nextInt(); 
    in.nextLine();
    switch(sw){
    case 1:{
            System.out.println("\nCategorias Existentes :");
            for(String i : inventario.getInventario().keySet()){
                System.out.println(i);
            }
            System.out.println("\nIngrese los productos de la categoria que desee ver");
            String categoria = in.nextLine();
            for(int i : inventario.getInventario().get(categoria).keySet()){
                inventario.getInventario().get(categoria).get(i).imprimirProducto();
            }
        break;
    }
    case 2:{
        System.out.println("Ingrese la categoria del producto");
        String categoria = in.nextLine();
        if(!inventario.getInventario().containsKey(categoria)){
            System.out.println("Categoria no encontrada");
            break;
        }
        System.out.println("Ingrese el codigo del producto");
        int codigo = in.nextInt();
        if(!inventario.getInventario().get(categoria).containsKey(codigo)){
            System.out.println("Codigo no encontrado");
            break;
        }
        System.out.println("Ingrese que desea cambiar del producto Codigo :"+ codigo+"   Nombre :"+inventario.getInventario().get(categoria).get(codigo).getNombre());
        System.out.println("1- Cambiar Nombre");
        System.out.println("2- Cambiar Precio");
        System.out.println("3- Cambiar Cantidad");
        System.out.println("4- Cambiar Todo");
        int modif_opcion = in.nextInt();
        in.nextLine();
        switch(modif_opcion){
            case 1:{
                System.out.println("Ingrese un nuevo nombre");
                String nombre = in.nextLine();
                inventario.getInventario().get(categoria).get(codigo).setNombre(nombre);
                break;
            }
            case 2:{
                System.out.println("Ingrese un nuevo precio");
                double precio = in.nextDouble();
                in.nextLine();
                inventario.getInventario().get(categoria).get(codigo).setPrecio(precio);
                break;

            }
            case 3:{
                System.out.println("Ingrese una nueva cantidad");
                int cantidad = in.nextInt();
                in.nextLine();
                inventario.getInventario().get(categoria).get(codigo).setCantidad(cantidad);
                break;


            }
            case 4:{
                System.out.println("Ingrese un nuevo nombre");
                String nombre = in.nextLine();
                inventario.getInventario().get(categoria).get(codigo).setNombre(nombre);
                System.out.println("Ingrese un nuevo precio");
                double precio = in.nextDouble();
                in.nextLine();
                inventario.getInventario().get(categoria).get(codigo).setPrecio(precio);
                System.out.println("Ingrese una nueva cantidad");
                int cantidad = in.nextInt();
                in.nextLine();
                inventario.getInventario().get(categoria).get(codigo).setCantidad(cantidad);
                break;

            }
            default:{
                System.out.println("Opcion invalida");
                break;
            }






        }



        break;



    }
    case 3:{
                inventario.borrarProducto();
                break;

    }
    case 4:{
        System.out.println("\nIngrese el Nombre de la categoria a ingresar");
        String categoria = in.nextLine();
        if(inventario.getInventario().containsKey(categoria))
            System.out.println("Categoria ya existente");
        else
            inventario.agregarCategoria(categoria);
        break;
    }
    case 5:{
        System.out.println("Ingrese la categoria del producto");
        String categoria = in.nextLine();
        if(inventario.getInventario().containsKey(categoria)){
            System.out.println("Ingrese el Nombre del producto");
            String nombre = in.nextLine();
            System.out.println("Ingrese el Precio del producto");
            double precio = in.nextDouble();
            Producto p = new Producto(inventario.generadorCodigo(categoria), nombre, precio, 1);
            inventario.agregarProducto(categoria,p);
        }
        else{
            System.out.println("\nLa categoria ingresada no existe");
        }



        
        break;
    }




    }
    
    
    
    }

    in.close();

    }


}
