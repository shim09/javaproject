package Powerlifting;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PowerliftingService {
	
	
	// 참가자 세부정보 등록(체지방,제지방,FFMI 측정)
	// FFMI지수 비례 28 이상일경우 탈락,
	// 3대 운동 중량측정
	// 참가자 상세정보 조회(참가번호와 이름이 같으면 출력)
	// 순위 출력
	// 1번 참가자의 무게 = 1번 측정번호
	// 순위는 키+몸무게/3대 종합무게
	
	/*
	 * 매서드 이름 : ParticipantRegistration(참가자 등록)
	 * 리턴값 : Map(ParticipantDTO)
	 * 매개변수 : Map(ParticipantDTO)
	 */

	Map<Integer, ParticipantDTO>ParticipantRegistration(Map<Integer, ParticipantDTO>ParticipanList){
		Scanner scan = new Scanner(System.in);
		System.out.print("참가자 이름 : ");
		String ParticipantName = scan.next();
		System.out.print("참가자 신장 : ");
		int ParticipantCm = scan.nextInt();
		System.out.print("참가자 몸무게 : ");
		int ParticipantKg = scan.nextInt();
		double LoanBody = 0;
		double Fat = 0;
		double FFMI = 0;
		double cm=(double)ParticipantCm;
		int ParticipantNumber = ParticipanList.size() + 1;
		LoanBody = (1.1 * ParticipantKg) - (128 * ((Math.pow(ParticipantKg,2)/(Math.pow(ParticipantCm,2)))));
		Fat = ParticipantKg - LoanBody;
		FFMI = LoanBody/Math.pow(cm/100 , 2);
	
		
		ParticipantDTO Plist = new ParticipantDTO(ParticipantNumber, ParticipantName, ParticipantCm, ParticipantKg, LoanBody, Fat, FFMI);
		ParticipanList.put(ParticipantNumber, Plist);
		
		
		return ParticipanList;
	}

	
	// 도핑 테스트 DopingTest
	// 회원 번호와 이름을 입력한다.
	// FFMI지수를 입력받고 입력받은 FFMI지수가 28 이상일 경우 해당 선수를 삭제한다.
	
	/*
	 * 매서드 이름 : DopingTest
	 * 리턴값 : VOID
	 * 매개변수 : Map(ParticipantDTO)
	 */

	void DopingTest(Map<Integer, ParticipantDTO>ParticipanList) {
//		System.out.println(ParticipantCheck(ParticipanList));
		int result = ParticipantCheck(ParticipanList);
		System.out.println(result);
		if(result > 0) {
			double FFMI = 28;
			if(28<=ParticipanList.get(result).getFFMI()) {
				ParticipanList.remove(result);
				System.out.println("약물 복용자로 퇴소되었습니다.");
			}else{
				System.out.println("정상 수치 입니다.");
			}
		}else {
			System.out.println("등록되지 않은 참가자 입니다.");
		}
	}
	
	
	// 3대운동 중량 측정.
	// 1번 참가자의 무게 = 1번 측정번호
	// 위 내용처럼 출력하면 나타내는건 상관없지만 순위 측정시 한번에 나타내기 어려움.
	// DTO 필드값을 대입시키는 방법을 알아내보자.
	
	/*
	 * 매서드 이름 : Measurement
	 * 리턴값 : Map(LiftingDTO) , Map(ParticipantDTO)??
	 * 매개변수 : Map(LiftingDTO)
	 */
	
	
	Map<Integer, LiftingDTO>Measurement(Map<Integer, LiftingDTO>LiftList){
		Scanner scan = new Scanner(System.in);
		System.out.print("DeadLift : ");
		int DeadLift = scan.nextInt();
		System.out.print("Squat : ");
		int Squat = scan.nextInt();
		System.out.print("BenchPress : ");
		int BenchPress = scan.nextInt();
		int MeasurementNum = LiftList.size() + 1;
		int sum = DeadLift + Squat + BenchPress;
		
		LiftingDTO Llist = new LiftingDTO(DeadLift,Squat,BenchPress,MeasurementNum,sum);
		
		LiftList.put(MeasurementNum, Llist);
		System.out.println(LiftList);
		return LiftList;
		
	}
	
	
	// 참가자 상세정보 조회(참가번호와 이름이 같으면 출력)
	// 참가자의 번호,이름,신장,몸무게와 함께 체지방,제지방률,FFMI치수와
	// DeadLift/Squat/BenchPress 까지 출력
	
	/*
	 * 매서드 이름 : Information
	 * 리턴값 : void
	 * 매개변수 : Map(ParticipantDTO) + Map(LiftingDTO)
	 */
	
	void Information(Map<Integer, ParticipantDTO>ParticipanList,Map<Integer, LiftingDTO>LiftList){
		int result = ParticipantCheck(ParticipanList);
		if(result >= 0) {
			System.out.println(ParticipanList.get(result).getParticipantNumber() + "번 참가자");
			System.out.println("이름 : " + ParticipanList.get(result).getParticipantName());
			System.out.println("신장 : " + ParticipanList.get(result).getParticipantCm());
			System.out.println("몸무게 : " + ParticipanList.get(result).getParticipantKg());
			System.out.println("체지방량 : " + ParticipanList.get(result).getFat());
			System.out.println("제지방량 : " + ParticipanList.get(result).getLoanBody());
			System.out.println("FFMI 수치 : " + ParticipanList.get(result).getFFMI());
			System.out.println("DeadLift : " + LiftList.get(result).getDeadLift() + "kg");
			System.out.println("Squat : " + LiftList.get(result).getSquat() + "kg");
			System.out.println("BenchPress : " + LiftList.get(result).getBenchPress() + "kg");
		
		}else {
			System.out.println("등록되지 않은 참가자 입니다.");
		}
			
		
		
	}
	
	// 순위 출력
	// 1번 참가자의 무게 = 1번 측정번호
	// 순위는 키+몸무게/3대 종합무게
	
	/*
	 * 매서드 이름 : Ranking
	 * 리턴값 : void
	 * 매개변수 : Map(ParticipantDTO) + Map(LiftingDTO) 
	 */

//	void Ranking(Map<Integer, ParticipantDTO>ParticipanList,Map<Integer, LiftingDTO>LiftList){
//		public static void 	Pranking(Map<Integer, ParticipantDTO>ParticipanList,Map<Integer, LiftingDTO>LiftList){
//		Map<Integer, LiftingDTO> LiftList = new HashMap<>();
//		Map<Integer, ParticipantDTO>ParticipanList = new HashMap<>();
//		List<Double> list1 = new ArrayList<Double>();
//		double[] list1 = new double [ParticipanList.size()];
// 		
//		for(Integer  A : ParticipanList.keySet()) {
//			ParticipantDTO par = new ParticipantDTO();
//			par = ParticipanList.get(A);
//			double FinalRanking = (double)(par.getParticipantCm() + par.getParticipantKg() / LiftList.get(A).getSum());
//			double FinalRanking = ParticipanList.get(i).getParticipantCm() + (ParticipanList.get(i).getParticipantKg() / LiftList.get(i).getSum());
//			System.out.println(FinalRanking);
//			list1[A] = FinalRanking;
//			System.out.println(A + " 위: " + ParticipanList.get(A) + "신장,몸무게 비례 중량" + FinalRanking);
//		}
//		
//		}	
//		}
//		}
	
	
	void Ranking(Map<Integer, ParticipantDTO>ParticipanList,Map<Integer, LiftingDTO>LiftList){
		List<Double> list1 = new ArrayList<>();
		for(Integer A: ParticipanList.keySet()) {
			ParticipantDTO par = new ParticipantDTO();
			par = ParticipanList.get(A);
			double FinalRanking =  (double)LiftList.get(A).getSum() / (double)((par.getParticipantCm() + par.getParticipantKg()));
			list1.add(FinalRanking);
		}
		
		Collections.sort(list1, Collections.reverseOrder());
		
		for(int i=0; i<list1.size(); i++) {
			int result = ParticipantCheck(ParticipanList);
			System.out.println("==================================================");
			System.out.println("순위 측정 기준은 몸무게와 키를 더한 값에 중량을 나눈 값 입니다.");
			System.out.println("==================================================");
			System.out.println(ParticipanList.get(result).getParticipantName() + " 은(는) " + "중량 비율이 " + list1.get(i) + " 이며 " + i+1 + " 위 입니다. ");
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	int ParticipantCheck(Map<Integer, ParticipantDTO>ParticipanList) {
		Scanner scan = new Scanner(System.in);
		System.out.println("참가자 번호 : ");
		int ParticipantNumber = scan.nextInt();
		System.out.print("참가자 이름 : ");
		String ParticipantName = scan.next();
		int indexNumber = 0;
		for (Integer  A : ParticipanList.keySet()) {
//			if(ParticipantNumber==(ParticipanList.get(i).getParticipantNumber()) && ParticipantName.equals(ParticipanList.get(i).getParticipantName())) {
				if(ParticipantNumber==(ParticipanList.get(A).getParticipantNumber()) && ParticipantName.equals(ParticipanList.get(A).getParticipantName())) {
				indexNumber = A;
				System.out.println(ParticipanList.get(A));
			}
			
	}return indexNumber;
	}



		// TODO Auto-generated method stub
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


