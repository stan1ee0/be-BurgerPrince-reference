package app.discount.discountCondition;

import app.discount.discountPolicy.DiscountPolicy;

import java.util.Scanner;

public class CozDiscountCondition extends DiscountCondition {
    public CozDiscountCondition(DiscountPolicy discountPolicy) {
        super(discountPolicy);
    }

    public void checkDiscountCondition() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("코드스테이츠 수강생이십니까? (1)_예 (2)_아니오");
        String input = scanner.nextLine();

        if (input.equals("1")) setSatisfied(true);
    }
}
