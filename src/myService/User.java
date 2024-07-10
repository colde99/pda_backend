package myService;

public class User {
    private int pid;
    private String id;
    private String pw;

    public User(){};

    public int getPid() {
        return pid;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

}
