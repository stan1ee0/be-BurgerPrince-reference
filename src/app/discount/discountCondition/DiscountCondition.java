package app.discount.discountCondition;

import app.discount.discountPolicy.DiscountPolicy;

public abstract class DiscountCondition {
    private boolean isSatisfied = false;
    private DiscountPolicy discountPolicy;

    public DiscountCondition(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public boolean isSatisfied() {
        return isSatisfied;
    }

    public void setSatisfied(boolean satisfied) {
        isSatisfied = satisfied;
    }

    public int applyCondition(int price) {
        return discountPolicy.calculateDiscountedPrice(price);
    }

    public abstract void checkDiscountCondition();
}
