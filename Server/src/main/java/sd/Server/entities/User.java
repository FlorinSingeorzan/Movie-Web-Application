package sd.Server.entities;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;



@Entity
@Table(name = "mauser")
public class User {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private int role;

    public User(){}

    public User(String name, String password, int role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }
    public User(int id, String name, String password, int role) {
        this.id=id;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return this.name+" "+this.password+" "+this.role;
    }
}
