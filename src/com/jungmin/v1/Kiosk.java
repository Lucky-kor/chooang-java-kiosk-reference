package com.jungmin.v1;

import java.util.Scanner;

public class Kiosk {
    private final MenuItem menuItem1 = new MenuItem("김밥", 1000);
    private final static MenuItem menuItem2 = new MenuItem("계란 김밥", 1500);
    private final static MenuItem menuItem3 = new MenuItem("충무 김밥", 1000);
    private final static MenuItem menuItem4 = new MenuItem("떡볶이", 2000);
    Scanner sc = new Scanner(System.in);

    // 가장 처음에 가게 소개 멘트 메서드
    public void welcomeMessagePrint() {
        System.out.println("[안내] 안녕하세요. 김밥천국에 오신 것을 환영합니다.");
        System.out.println("-".repeat(30));
    }

    // 주문 안내 메시지를 출력하는 메서드를 정의할 수 있습니다.
    public void menuSelectMessagePrint() {
        System.out.println("[안내] 원하시는 메뉴의 번호를 입력하여 주세요.");
        System.out.println("1) 김밥(1000원), 2) 계란 김밥(1500), 3) 충무 김밥(1000원), 4) 떡볶이(2000원)");
    }
    // 주문할 음식을 선택하는 메서드를 정의 할 수 있습니다.
    public int selectMenu() {
//        int menuNumber = sc.nextInt();
        return sc.nextInt();
    }

    // 음식의 수량을 선택하기 전에 출력하는 메세지
    public void menuCountMessagePrint() {
        System.out.println("-".repeat(30));
        System.out.println("[안내] 선택하신 메뉴의 수량을 입력하여 주세요.");
        System.out.println("(※ 최대 주문 가능 수량 : 99)");
    }

    // 주문할 음식의 수량을 입력하는 메서드를 정의할 수 있습니다.
    public int inputMenuCount() {
        return sc.nextInt();
    }
    // 음식 주문을 위한 메서드를 정의할 수 있습니다.
    public int calculateOrderPrice(int menuNumber, int quantity) {
        int currentMenuPrice = 0;
        switch (menuNumber) {
            case 1:
                currentMenuPrice = 1000;
                break;
            case 2:
                currentMenuPrice = 1500;
                break;
            case 3:
                currentMenuPrice = 1000;
                break;
            case  4:
                currentMenuPrice = 2000;
                break;
        }
        return currentMenuPrice * quantity;
    }
    // 주문 결과를 출력하는 메서드를 정의할 수 있습니다.
    public void orderPriceMessagePrint(int amount) {
        System.out.printf("[안내] 주문하신 메뉴의 총 금액은 %d원 입니다.%n", amount);
        System.out.println("[안내] 이용해주셔서 감사합니다.");
    }
}
