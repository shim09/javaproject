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
			System.out.println("1. ���������� ��� | 2.���� �׽�Ʈ | 3.�߷� ���� | 4.������ ������ ��ȸ | 5. ���� ��� | 6.����");
			System.out.println("=================================================================================");
			System.out.print("�Է�> ");
			int select = scan.nextInt();
			if(select == 1) {
				// ������ ���� ���
				P1.ParticipantRegistration(ParticipanList);	
			}else if(select == 2) {
				// ���� �׽�Ʈ
				P1.DopingTest(ParticipanList);
			}else if(select == 3) {
				// �߷� ����
				P1.Measurement(LiftList);
			}else if(select == 4) {
				// ������ ������ ���
				P1.Information(ParticipanList,LiftList);
			}else if(select == 5) {
				// ���� ���
				P1.Ranking(ParticipanList,LiftList);
			}else if(select == 6) {
			System.out.println("����");
			run=false;
			}
			}
			
			
		}

}
