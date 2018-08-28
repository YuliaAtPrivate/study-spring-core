package helloclient;

public class Client {

    private String id;
    private String fullName;
    private int age;
    private String greeting;
    private boolean boo;

    public Client(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public void setBoo(boolean boo) {
        this.boo = boo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", greeting='" + greeting + '\'' +
                ", boo=" + boo +
                '}';
    }
}
