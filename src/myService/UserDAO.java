package myService;

import java.util.HashMap;
import java.util.Map;

public class UserDAO {
    //DAO : Data Access Object => Spring의 Repository
    Map<Integer, User> db = new HashMap<>();

    static int pid = 0;

    //회원가입: user db 저장
    public void save(User user) {
        user.setPid(pid++);
        db.put(user.getPid(), user);
        System.out.println(user.getId()+"님 가입을 환영하지 않습니다 꺼져주세요");
        pid ++;
    }

    //로그인
    public User findUserById(String loginId){
        for (User user : db.values()){
            if(user.getId().equals(loginId)){
                return user;
            }
        }
        return null;
    }

    //비밀번호 변경
    public void changePw(User user) {
        db.put(user.getPid(),user);
    }

    //회원 삭제
    public void delete(User user){
        db.remove(user.getPid());
    }
}
