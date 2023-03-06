package app.discount.discountCondition;

import app.discount.discountPolicy.DiscountPolicy;

import java.util.Scanner;

public class KidDiscountCondition extends DiscountCondition {
    public KidDiscountCondition(DiscountPolicy discountPolicy) {
        super(discountPolicy);
    }

    public void checkDiscountCondition() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("나이가 어떻게 되십니까?");
        int input = Integer.parseInt(scanner.nextLine());

        if (input < 20) setSatisfied(true);
    }
}
