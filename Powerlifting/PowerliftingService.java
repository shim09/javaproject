package Powerlifting;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PowerliftingService {
	
	
	// ������ �������� ���(ü����,������,FFMI ����)
	// FFMI���� ��� 28 �̻��ϰ�� Ż��,
	// 3�� � �߷�����
	// ������ ������ ��ȸ(������ȣ�� �̸��� ������ ���)
	// ���� ���
	// 1�� �������� ���� = 1�� ������ȣ
	// ������ Ű+������/3�� ���չ���
	
	/*
	 * �ż��� �̸� : ParticipantRegistration(������ ���)
	 * ���ϰ� : Map(ParticipantDTO)
	 * �Ű����� : Map(ParticipantDTO)
	 */

	Map<Integer, ParticipantDTO>ParticipantRegistration(Map<Integer, ParticipantDTO>ParticipanList){
		Scanner scan = new Scanner(System.in);
		System.out.print("������ �̸� : ");
		String ParticipantName = scan.next();
		System.out.print("������ ���� : ");
		int ParticipantCm = scan.nextInt();
		System.out.print("������ ������ : ");
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

	
	// ���� �׽�Ʈ DopingTest
	// ȸ�� ��ȣ�� �̸��� �Է��Ѵ�.
	// FFMI������ �Է¹ް� �Է¹��� FFMI������ 28 �̻��� ��� �ش� ������ �����Ѵ�.
	
	/*
	 * �ż��� �̸� : DopingTest
	 * ���ϰ� : VOID
	 * �Ű����� : Map(ParticipantDTO)
	 */

	void DopingTest(Map<Integer, ParticipantDTO>ParticipanList) {
//		System.out.println(ParticipantCheck(ParticipanList));
		int result = ParticipantCheck(ParticipanList);
		System.out.println(result);
		if(result > 0) {
			double FFMI = 28;
			if(28<=ParticipanList.get(result).getFFMI()) {
				ParticipanList.remove(result);
				System.out.println("�๰ �����ڷ� ��ҵǾ����ϴ�.");
			}else{
				System.out.println("���� ��ġ �Դϴ�.");
			}
		}else {
			System.out.println("��ϵ��� ���� ������ �Դϴ�.");
		}
	}
	
	
	// 3�� �߷� ����.
	// 1�� �������� ���� = 1�� ������ȣ
	// �� ����ó�� ����ϸ� ��Ÿ���°� ��������� ���� ������ �ѹ��� ��Ÿ���� �����.
	// DTO �ʵ尪�� ���Խ�Ű�� ����� �˾Ƴ�����.
	
	/*
	 * �ż��� �̸� : Measurement
	 * ���ϰ� : Map(LiftingDTO) , Map(ParticipantDTO)??
	 * �Ű����� : Map(LiftingDTO)
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
	
	
	// ������ ������ ��ȸ(������ȣ�� �̸��� ������ ���)
	// �������� ��ȣ,�̸�,����,�����Կ� �Բ� ü����,�������,FFMIġ����
	// DeadLift/Squat/BenchPress ���� ���
	
	/*
	 * �ż��� �̸� : Information
	 * ���ϰ� : void
	 * �Ű����� : Map(ParticipantDTO) + Map(LiftingDTO)
	 */
	
	void Information(Map<Integer, ParticipantDTO>ParticipanList,Map<Integer, LiftingDTO>LiftList){
		int result = ParticipantCheck(ParticipanList);
		if(result >= 0) {
			System.out.println(ParticipanList.get(result).getParticipantNumber() + "�� ������");
			System.out.println("�̸� : " + ParticipanList.get(result).getParticipantName());
			System.out.println("���� : " + ParticipanList.get(result).getParticipantCm());
			System.out.println("������ : " + ParticipanList.get(result).getParticipantKg());
			System.out.println("ü���淮 : " + ParticipanList.get(result).getFat());
			System.out.println("�����淮 : " + ParticipanList.get(result).getLoanBody());
			System.out.println("FFMI ��ġ : " + ParticipanList.get(result).getFFMI());
			System.out.println("DeadLift : " + LiftList.get(result).getDeadLift() + "kg");
			System.out.println("Squat : " + LiftList.get(result).getSquat() + "kg");
			System.out.println("BenchPress : " + LiftList.get(result).getBenchPress() + "kg");
		
		}else {
			System.out.println("��ϵ��� ���� ������ �Դϴ�.");
		}
			
		
		
	}
	
	// ���� ���
	// 1�� �������� ���� = 1�� ������ȣ
	// ������ Ű+������/3�� ���չ���
	
	/*
	 * �ż��� �̸� : Ranking
	 * ���ϰ� : void
	 * �Ű����� : Map(ParticipantDTO) + Map(LiftingDTO) 
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
//			System.out.println(A + " ��: " + ParticipanList.get(A) + "����,������ ��� �߷�" + FinalRanking);
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
			System.out.println("���� ���� ������ �����Կ� Ű�� ���� ���� �߷��� ���� �� �Դϴ�.");
			System.out.println("==================================================");
			System.out.println(ParticipanList.get(result).getParticipantName() + " ��(��) " + "�߷� ������ " + list1.get(i) + " �̸� " + i+1 + " �� �Դϴ�. ");
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	int ParticipantCheck(Map<Integer, ParticipantDTO>ParticipanList) {
		Scanner scan = new Scanner(System.in);
		System.out.println("������ ��ȣ : ");
		int ParticipantNumber = scan.nextInt();
		System.out.print("������ �̸� : ");
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


