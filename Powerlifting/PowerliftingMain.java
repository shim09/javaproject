package Powerlifting;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PowerliftingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Integer, ParticipantDTO>ParticipanList = new HashMap<>();
		Map<Integer, LiftingDTO>LiftList = new HashMap<>();
		PowerliftingService P1 = new PowerliftingService();
		Scanner scan = new Scanner(System.in);		
		boolean run = true;
		
		while (run) {
			System.out.println("=================================================================================");
			System.out.println("1. 참가자정보 등록 | 2.도핑 테스트 | 3.중량 측정 | 4.참가자 상세정보 조회 | 5. 순위 출력 | 6.종료");
			System.out.println("=================================================================================");
			System.out.print("입력> ");
			int select = scan.nextInt();
			if(select == 1) {
				// 참가자 정보 등록
				P1.ParticipantRegistration(ParticipanList);	
			}else if(select == 2) {
				// 도핑 테스트
				P1.DopingTest(ParticipanList);
			}else if(select == 3) {
				// 중량 측정
				P1.Measurement(LiftList);
			}else if(select == 4) {
				// 참가자 상세정보 출력
				P1.Information(ParticipanList,LiftList);
			}else if(select == 5) {
				// 순위 출력
				P1.Ranking(ParticipanList,LiftList);
			}else if(select == 6) {
			System.out.println("종료");
			run=false;
			}
			}
			
			
		}

}
