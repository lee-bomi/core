package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)     //기존 수동 빈 생성class를 제외
) // 자동으로 빈 읽어오기 위함
public class AutoAppConfig {    //@Bean으로 등록한 클래스가 없다


}
