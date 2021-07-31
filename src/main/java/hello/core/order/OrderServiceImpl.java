package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{  //Dip를 지키고있음(인터페이스에만 의존-어떤 구현체가 들어올지 모름)

    private final MemberRepository memberRepository;
    // private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override //MemberRepository에서 회원정보가져와서, DiscountPolicy에서 할인금액 가져와서 주문을 만든다
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);  //OrderServiceImpl은 discountPolicy가 무슨일하는지모름. 결과나 내놔(단일책임원칙 잘지켜짐)

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
