package com.jungmin.v5;

import java.util.Scanner;

public class Kiosk {
    private MenuItem[] menuItems;

    public Kiosk(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }
    
    Scanner sc = new Scanner(System.in);

    // 가장 처음에 가게 소개 멘트 메서드
    public void welcomeMessagePrint() {
        System.out.println("[안내] 안녕하세요. 김밥천국에 오신 것을 환영합니다.");
        System.out.println("-".repeat(30));
    }

    public MenuItem selectMenu() {
        int menuNumber;

        do {
            menuSelectMessagePrint();
            menuNumber = inputMenuNumber();
            if(menuNumber <= 0 || menuNumber >= menuItems.length + 1) {
                menuSelectExceptionMessagePrint();
            }
        } while(menuNumber <= 0 || menuNumber >= menuItems.length + 1);

        return menuItems[menuNumber - 1];
    }

    private void menuSelectExceptionMessagePrint() {
        System.out.println("[안내] 메뉴에 포함된 번호를 입력하여 주세요.");
    }

    // 주문 안내 메시지를 출력하는 메서드를 정의할 수 있습니다.
    private void menuSelectMessagePrint() {
        System.out.println("[안내] 원하시는 메뉴의 번호를 입력하여 주세요.");
        for(int i = 0; i < menuItems.length; i++) {
            System.out.printf("%d) %s(%d원)%n", i + 1, menuItems[i].getName(), menuItems[i].getPrice());
        }
//        System.out.println("1) 김밥(1000원), 2) 계란 김밥(1500), 3) 충무 김밥(1000원), 4) 떡볶이(2000원)");
    }

    // 스캐너 객체를 통해 메뉴를 선택합니다 (ex 1.. 2)
    private int inputMenuNumber() {
        int menuNumber = -1;

        String inputString = sc.nextLine();
        if(isValidStringToInt(inputString)) {
            menuNumber = Integer.parseInt(inputString);
        } else {
            NumbericExceptionMessagePrint();
        }

        return menuNumber;
    }

    // 선택한 메뉴의 수량을 선택하는 메서드
    public int selectMenuQuantity(MenuItem menu) {
        int quantity;
        do {
            menuCountMessagePrint(menu.getQuantity());
            quantity = inputMenuCount();
            if(quantity <= 0 || quantity > menu.getQuantity()) {
                menuCountExceptionMessagePrint(quantity);
            }
        } while(quantity <= 0 || quantity > menu.getQuantity());

        return quantity;
    }

    private void menuCountExceptionMessagePrint(int quantity) {
        if(quantity == -1) System.out.println("[경고] 수량 선택 화면으로 돌아갑니다.");
        else {
            System.out.printf("[경고] %d개는 입력할 수 없습니다.%n", quantity);
            System.out.println("[경고] 수량 선택 화면으로 돌아갑니다.");
        }
    }

    // 음식의 수량을 선택하기 전에 출력하는 메세지
    private void menuCountMessagePrint(int maxQuantity) {
        System.out.println("-".repeat(30));
        System.out.println("[안내] 선택하신 메뉴의 수량을 입력하여 주세요.");
        System.out.printf("(※ 최대 주문 가능 수량 : %d)%n", maxQuantity);
    }

    // 주문할 음식의 수량을 입력하는 메서드를 정의할 수 있습니다.
    private int inputMenuCount() {
        int quantity = -1;

        String inputString = sc.nextLine();
        if(isValidStringToInt(inputString)) {
            quantity = Integer.parseInt(inputString);
        } else {
            NumbericExceptionMessagePrint();
        }

        return quantity;
    }

    private int calculateOrderPrice(MenuItem menu, int quantity) {
        return menu.getPrice() * quantity;
    }
    // 주문 결과를 출력하는 메서드를 정의할 수 있습니다.
    public void orderPriceMessagePrint(MenuItem menu, int quantity) {
        int totalPrice = calculateOrderPrice(menu, quantity);
        System.out.printf("[안내] %s 상품을 %d개 주문하여 총 금액은 %d원 입니다.%n"
                , menu.getName(), quantity, totalPrice);
        System.out.println("[안내] 이용해주셔서 감사합니다.");
        int currentQuantity = menu.getQuantity();
        menu.setQuantity(currentQuantity - quantity);
    }

    private boolean isValidStringToInt(String formula) {
        String table = "0123456789";
        for(char c : formula.toCharArray()) {
            if(table.indexOf(c) == -1) {
                return false;
            }
        }
//        return true;
        return formula.charAt(0) != '0';
    }

    private void NumbericExceptionMessagePrint() {
        System.out.println("[경고] 숫자만 입력해야 합니다.");
    }
}
