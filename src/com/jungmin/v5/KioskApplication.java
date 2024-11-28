package com.jungmin.v5;

public class KioskApplication {
    public static void main(String[] args) {
        MenuItem[] menuItems = new MenuItem[] {
                new MenuItem("김밥", 1000, 10),
                new MenuItem("계란 김밥", 1500, 20),
                new MenuItem("충무 김밥", 1000, 50),
                new MenuItem("떡볶이", 2000, 20),
                new MenuItem("라면", 1500, 10)
        };

        Kiosk kiosk = new Kiosk(menuItems);
        kiosk.welcomeMessagePrint();
        MenuItem menu = kiosk.selectMenu();
        int quantity = kiosk.selectMenuQuantity(menu);
        kiosk.orderPriceMessagePrint(menu, quantity);
    }
}
