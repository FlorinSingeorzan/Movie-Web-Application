package sd.Server.dto;

public class UserDto {

    private int id;
    private String name;
    private String password;
    private int role;


    public UserDto(String name, String password, int role){
        this.name = name;
        this.password = password;
        this.role = role;
    }
    public UserDto(int id,String name, String password, int role){
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

    public static class Builder{
        private int nestedId;
        private String nestedName;
        private String nestedPassword;
        private int nestedRole;

        public Builder id(int id){
            this.nestedId=id;
            return this;
        }
        public Builder name(String name){
            this.nestedName=name;
            return this;
        }
        public Builder password(String password){
            this.nestedPassword=password;
            return this;
        }
        public Builder role(int role){
            this.nestedRole=role;
            return this;
        }



        public UserDto create(){
            return new UserDto(nestedId,nestedName,nestedPassword,nestedRole);
        }

    }




}
