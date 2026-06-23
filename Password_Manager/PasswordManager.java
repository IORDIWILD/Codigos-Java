import java.util.*;


public class PasswordManager{
private ArrayList<PasswordEntry> passwordList;

public PasswordManager() {
        passwordList = new ArrayList<PasswordEntry>();
    }


public void addPassword(PasswordEntry e){
passwordList.add(e);
System.out.println("Contraseña agregada exitosamente!");
}

public void showPasswords(){
if(passwordList.isEmpty()){
    System.out.println("No hay contrasenias ingresadas");
}
else{
    for(int i = 0 ; i< passwordList.size(); i++){
        passwordList.get(i).mostrar();
    }
}


}
}