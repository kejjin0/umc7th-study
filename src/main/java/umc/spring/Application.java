package umc.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.spring.domain.Review;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.service.MemberService.MemberQueryService;
import umc.spring.service.MissionService.MissionQueryService;
import umc.spring.service.StoreService.StoreQueryService;

@SpringBootApplication
@EnableJpaAuditing
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner run(ApplicationContext context){
		StoreQueryService storeService = context.getBean(StoreQueryService.class);
		MissionQueryService missionService = context.getBean(MissionQueryService.class);
		MemberQueryService memberService = context.getBean(MemberQueryService.class);

		return args -> {
			String name = "요아정";
			Float score = 4.0f;

			System.out.println("Executing findStoresByNameAndScore with parameters:");
			System.out.println("Name: " + name);
			System.out.println("Score: " + score);

			storeService.findStoresByNameAndScore(name, score)
					.forEach(System.out::println);

			System.out.println("진행중인 미션");

			missionService.findMissionsByUserIdAndStatus(1L, MissionStatus.CHALLENGING, (long) 0L);

			System.out.println("진행 완료 미션");
			missionService.findMissionsByUserIdAndStatus(1L, MissionStatus.COMPLETED, (long) 0L);

			System.out.println("선택한 지역의 미션들");
			missionService.findRegionMissionsByRegionIdAndMemberId(1L, 1L,0L);

			System.out.println("마이페이지 보기");
			memberService.findMyPageInfoByMemberId(1L);
		};
	}
}
