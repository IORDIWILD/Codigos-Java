public class PasswordEntry {
//Atributos privados
private String url;
private String password;
private String user;
private String notas;


//Constructor
public PasswordEntry(String Url  , String Password , String User , String Notas ){
    this.url = Url;
    this.password = Password;
    this.user = User;
    this.notas = Notas;
}
//setters y getters


public void mostrar(){
System.out.println("URL : "+ url);
System.out.println("PASSWORD : "+ password);
System.out.println("USER : "+ user);
System.out.println("NOTAS : "+ notas);
}



public String getUrl() {
    return url;
}
public void setUrl(String url) {
    this.url = url;
}
public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}
public String getUser() {
    return user;
}
public void setUser(String user) {
    this.user = user;
}
public String getNotas() {
    return notas;
}
public void setNotas(String notas) {
    this.notas = notas;
}


}
