package entities;

public class User {
    private String _name;
    public String getName() {
        return _name;
    }
    public void setName(String name) {
        _name = name;
    }

    private String _lastName;
    public String getLastName() {
        return _lastName;
    }
    public void setLastName(String lastName) {
        _lastName = lastName;
    }

    private Integer _age;
    public Integer getAge() {
        return _age;
    }
    public void setAge(Integer age) {
        _age = age;
    }

    private String _email;
    public String getEmail() {
        return _email;
    }
    public void setEmail(String email) {
        _email = email;
    }

    private String _phone;
    public String getPhone() {
        return _phone;
    }
    public void setPhone(String phone) {
        _phone = phone;
    }

    public User(String name, String lastName, Integer age, String email, String phone) {
        _name = name;
        _lastName = lastName;
        _age = age;
        _email = email;
        _phone = phone;
    }

    public User() { }
}