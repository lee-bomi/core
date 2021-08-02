package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{                                                                //Dip를 지키고있음(인터페이스에만 의존-어떤 구현체가 들어올지 모름)

    private final MemberRepository memberRepository;    //선택된 구현체인 MemberRepository의 참조값이 저장됨

    @Autowired  //의존관계주입을 해준다
    public MemberServiceImpl(MemberRepository memberRepository) {    //생성자를 통해서 MemberRepository의 구현체가 주입된다
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
