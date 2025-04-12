//IMPORTS
package br.com.futurodev.estudantes;
import java.util.Objects;

//CLASS
public class Estudante {
    private Integer Registro;
    private String Nome;
    private String Email;

    //CONSTRUTORES
    public Estudante(){};
    public Estudante(Integer Registro, String Nome, String Email){
        this.Registro = Registro;
        this.Nome = Nome;
        this.Email = Email;
    }
    //GET
    public Integer getRegistro() {
        return Registro;
    }
    public String getNome() {
        return Nome;
    }
    public String getEmail() {
        return Email;
    }
    //SET
    public void setRegistro(Integer registro) {
        Registro = registro;
    }
    public void setNome(String nome) {
        Nome = nome;
    }
    public void setEmail(String email) {
        Email = email;
    }

//METODOS
    // m.Equals
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Estudante estudante = (Estudante) obj;
        return Objects.equals(Registro, estudante.Registro) &&
                Objects.equals(Nome, estudante.Nome) &&
                Objects.equals(Email, estudante.Email);
    }
    //m.Hashcode
    public int hashCode() {
        return Objects.hash(Registro, Nome, Email);
    }
    //m.ToString
    public String toString(){
        return "Estudante{"+
                "Registro = {"+ Registro+
                ", Nome = "+ Nome+'/'+
                ", Email = "+ Email+'/'+'}';


    }

}
