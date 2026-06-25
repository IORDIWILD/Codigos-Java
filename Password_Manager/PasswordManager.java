import java.util.*;
import java.io.*;




public class PasswordManager{
private ArrayList<PasswordEntry> passwordList;



public void guardarArchivo(){
    try(FileWriter fw = new FileWriter("passwords.txt")){
        for(int i = 0; i<passwordList.size(); i++){
            fw.write(passwordList.get(i).getUrl()+"|"+passwordList.get(i).getPassword()+"|"+passwordList.get(i).getUser()+"|"+passwordList.get(i).getNotas()+"|");
            fw.write("\n");
        }

    }
    catch(IOException e){

         e.printStackTrace();

    }
}

public PasswordManager cargarArchivo(PasswordManager e){
    try(BufferedReader bf = new BufferedReader(new FileReader("passwords.txt"))){
        String linea;
        while((linea = bf.readLine()) != null){
            String [] bfPassword = linea.split("\\|");
            e.addPassword(new PasswordEntry(bfPassword[0], bfPassword[1], bfPassword[2], bfPassword[3]));;
        }
        return e;
    }
    catch(IOException c){

        System.out.println("Error al leer");
        return null;
    }
    
}


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
        System.out.println("Password #"+ (i+1));
        passwordList.get(i).mostrar();
    }
}
}

public int numdePassword(){
    int num=0;
    for(int i=0; i<passwordList.size(); i++){
        num++;
    }

    return num;
}

public void deletePassword(int index){

    passwordList.remove(index-1);
    System.out.println("Contraseña borrada exitosamente!");
}

public PasswordEntry getPassword(int index){
    return passwordList.get(index);
}

}
