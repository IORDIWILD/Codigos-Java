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
System.out.println("3. Salir");
System.out.print("Seleccione una opción: ");

menu_case= in.nextInt();

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
    manager.showPasswords();
    break;
}
case 3:{    

    menu = false;
    break;
}





}




}

in.close();
}


}