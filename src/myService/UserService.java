package myService;

public class UserService {

    private UserDAO userDAO = new UserDAO();
    private User loggedInUser;

    public User getLoggedInUser() {
        return loggedInUser;
    }

    //1.회원가입
    public void register(User user) {
        userDAO.save(user);
    }

    //2.로그인
    public void login(String[] loginIdArr) {
        String loginId = loginIdArr[0];
        String loginPw = loginIdArr[1];
        User foundUser = userDAO.findUserById(loginId);

        if (foundUser != null && loginPw.equals(foundUser.getPw())){
            loggedInUser = foundUser; //로그인 정보 저장
            System.out.println(foundUser.getId()+"님 로그인 되었습니다");
        } else {
            throw new IllegalArgumentException("로그인 실패: 다시 시도하지 말아주세요");
        }
    }

    //3-1. 비밀번호 확인
    //3-2. 비밀번호 변경
    public void update(User user){
        userDAO.changePw(user);
        System.out.println("비밀번호 변경완료");
        loggedInUser = null;
        System.out.println("다시 로그인하세요");
    }

    //4-1.로그인 상태 확인
    public boolean isLoggedIn(){
        return loggedInUser != null;
    }
    //4-2. 로그아웃
    public void logout() {
        loggedInUser = null;
        System.out.println("로그아웃 되었습니다 안녕히 가세요");
    }

    //5. 회원탈퇴
    public void delete(User user){
        loggedInUser = null;
        userDAO.delete(user);
        System.out.println("우리 서비스에서 추방되셨습니다 안녕히 가세요");
    }
}
