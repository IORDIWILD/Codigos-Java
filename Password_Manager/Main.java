import java.util.*;

public class Main{
public static void main(String args[]){
Scanner in = new Scanner(System.in);
boolean menu = true;
int menu_case;
String temp_Url;
String temp_Contrasenia;
String temp_User;
String temp_Notas;

PasswordManager manager = new PasswordManager();

while(menu){

System.out.println("\n=== MENÚ ===");
System.out.println("1. Agregar contraseña");
System.out.println("2. Mostrar todas");
System.out.println("3. Borrar Password");
System.out.println("4. Modificar Password");
System.out.println("5. Guardar Password");
System.out.println("6. Salir");
System.out.print("Seleccione una opción: ");

menu_case= in.nextInt();
    System.out.println();
switch(menu_case){

case 1:{    
    System.out.println("Escriba la Url, Contrasenia, User y las Notas en el orden en que se mencionaron ");
    in.nextLine();
    temp_Url = in.nextLine();
    temp_Contrasenia = in.nextLine();
    temp_User = in.nextLine();
    temp_Notas = in.nextLine();
    PasswordEntry e = new PasswordEntry(temp_Url, temp_Contrasenia, temp_User, temp_Notas);
    manager.addPassword(e);
    break;
}
case 2:{
    System.out.println();    
    manager.showPasswords();
    break;
}
case 3:{
    System.out.println("Estas son las Urls existentes :");
    for(int i=0; i<manager.numdePassword(); i++){
        System.out.println("Url #" + (i+1) + ": " + manager.getPassword(i).getUrl());
    }
    System.out.println("Ingrese el numero de la que desee eliminar :");
    int numElim = in.nextInt();
    if(0<numElim && numElim<=manager.numdePassword())
        manager.deletePassword(numElim);
    else
        System.out.println("Numero Invalido");
    System.out.println();
    break;

}
case 4:{
    System.out.println();
    System.out.println("Estas son las Urls existentes :");
    for(int i=0; i<manager.numdePassword(); i++){
        System.out.println("Url #" + (i+1) + ": " + manager.getPassword(i).getUrl());
    }
    System.out.println("Ingrese el Numero de Password que desee modificar:");
    int numModif = in.nextInt();
    PasswordEntry e = manager.getPassword(numModif-1);
    System.out.println("Ingrese el numero acorde de lo que quiera modificar del Password #" +numModif +":");
    System.out.println("1. Modificar Url");
    System.out.println("2. Modificar Password");
    System.out.println("3. Modificar User");
    System.out.println("4. Modificar Notas");
    System.out.println("5. Modificar Todo"); 
    numModif = in.nextInt();
    in.nextLine();
    switch(numModif){
        case 1:{
            System.out.println("Ingrese una nueva Url:");
            String nuevaUrl = in.nextLine();
            e.setUrl(nuevaUrl);
            System.out.println("Password Modificada Exitosamente");
            break;
        }
        case 2:{
            System.out.println("Ingrese una nueva Password:");
            String nuevaPassword = in.nextLine();
            e.setPassword(nuevaPassword);
            System.out.println("Password Modificada Exitosamente");
            break;
        }
        case 3:{
            System.out.println("Ingrese un nuevo User:");
            String nuevoUser = in.nextLine();
            e.setUser(nuevoUser);
            System.out.println("Password Modificada Exitosamente");
            break;
        }
        case 4:{
            System.out.println("Ingrese una nueva Nota:");
            String nuevaNota = in.nextLine();
            e.setNotas(nuevaNota);
            System.out.println("Password Modificada Exitosamente");
            break;
        }
        case 5:{
            System.out.println("Escriba la Url, Contrasenia, User y las Notas en el orden en que se mencionaron ");
            String nuevaUrl = in.nextLine();
            String nuevaPassword = in.nextLine();
            String nuevoUser = in.nextLine();
            String nuevaNota = in.nextLine();
            e.setUrl(nuevaUrl);
            e.setPassword(nuevaPassword);
            e.setUser(nuevoUser);
            e.setNotas(nuevaNota);
            System.out.println("Password Modificada Exitosamente");

            break;
        }       

    }
    break;
}
case 5:{
    manager.guardarArchivo();
    break;
}
case 6:{    

    menu = false;
    break;
}





}




}

in.close();
}


}