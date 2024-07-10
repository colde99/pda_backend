package myService;

import java.util.Scanner;

public class UserMain {

    public static void main(String[] args) {
        User user = new User();
        Scanner scanner = new Scanner(System.in);
        int choice;

        //비즈니스 로직을 처리하는 userService 객체 생성
        UserService userService = new UserService();

        do {
            display();
            scanner.nextLine();
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); //

            switch (choice){
                case 0 :
                    System.out.println("안녕히 가십쇼");
                case 1 :
                    //회원가입
                    register(userService, scanner, user);
                    break;
                case 2 :
                    //로그인
                    try {
                        login(userService, scanner);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3 :
                    //회원 정보수정
                    updateUser(userService, scanner, user);
                    break;
                case 4:
                    //로그아웃
                    logoutUser(userService);
                    break;
                case 5:
                    //회원탈퇴
                    deleteUser(userService, user);
                    break;
                default:
                    System.out.println("제대로 입력해주세요. 쫌");

            }
        } while (choice != 0);

    }

    private static void display(){
        System.out.println("메뉴가 보고싶으면 엔터를 누르던지 하세요");
    }

    private static void displayMenu() {
        System.out.println("암거나 누르쇼");
        System.out.println("1. 회원 가입");
        System.out.println("2. 로그인");
        System.out.println("3. 비밀번호 변경");
        System.out.println("4. 로그아웃");
        System.out.println("5. 회원 탈퇴");
        System.out.println("0. 종료");
    }

    private static void register(UserService userService, Scanner scanner, User user) {
        String[] idArr = new String[2];
        System.out.println("아이디 입력하삼");
        idArr[0] = scanner.nextLine();
        System.out.println("비번 입력");
        idArr[1] = scanner.nextLine();

        user.setId(idArr[0]);
        user.setPw(idArr[1]);
        userService.register(user);
    }

    private static void login(UserService userService, Scanner scanner) {
        String[] loginIdArr = new String[2];
        System.out.println("아이디 입력하삼");
        loginIdArr[0] = scanner.nextLine();
        System.out.println("비번 입력");
        loginIdArr[1] = scanner.nextLine();
        userService.login(loginIdArr);
    }

    private static void updateUser(UserService userService, Scanner scanner, User user) {
        if (userService.isLoggedIn()){
            System.out.println("New 비밀번호: ");
            String newPw = scanner.nextLine();
            user.setPw(newPw);
            userService.update(user);

        } else {
            System.out.println("로그인부터 하세요");
        }
    }

    private static void logoutUser(UserService userService) {
        if (userService.isLoggedIn()){
            userService.logout();
        } else {
            System.out.println("로그인을 하고 로그아웃을 하셔야죠");
        }
    }


    private static void deleteUser(UserService userService, User user) {
        if (userService.isLoggedIn()){
            userService.delete(user);
        } else {
            System.out.println("로그인부터 하세요");
        }
    }

}
