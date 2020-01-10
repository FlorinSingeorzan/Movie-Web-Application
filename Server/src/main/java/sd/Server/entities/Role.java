package sd.Server.entities;

import javax.persistence.*;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int idMovie;
    private int idStaff;
    private String name;


    public Role(int idMovie, int idStaff, int rate, String name){
        this.idMovie=idMovie;
        this.idStaff=idStaff;
        this.name = name;
    }

    public Role(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMovie() {
        return idMovie;
    }


    public int getIdStaff() {
        return idStaff;
    }

    public void setIdMovie(int idMovie){
        this.idMovie=idMovie;
    }
    public void setIdStaff(int idStaff){
        this.idStaff=idStaff;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
