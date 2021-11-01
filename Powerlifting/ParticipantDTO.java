package Powerlifting;

public class ParticipantDTO {
	
	int ParticipantNumber;
	String ParticipantName;
	int ParticipantCm;
	int ParticipantKg;
	double LoanBody; // 제지방량
	double Fat; // 체지방량
	double FFMI; // FFMI 치수
	double finalRanking;
	
	ParticipantDTO(){
		
	}
		
	public ParticipantDTO(int participantNumber, String participantName, int participantCm, int participantKg,
			double loanBody, double fat, double fFMI) {
		ParticipantNumber = participantNumber;
		ParticipantName = participantName;
		ParticipantCm = participantCm;
		ParticipantKg = participantKg;
		LoanBody = loanBody;
		Fat = fat;
		FFMI = fFMI;
	}

	public int getParticipantNumber() {
		return ParticipantNumber;
	}

	public void setParticipantNumber(int participantNumber) {
		ParticipantNumber = participantNumber;
	}

	public String getParticipantName() {
		return ParticipantName;
	}

	public void setParticipantName(String participantName) {
		ParticipantName = participantName;
	}

	public int getParticipantCm() {
		return ParticipantCm;
	}

	public void setParticipantCm(int participantCm) {
		ParticipantCm = participantCm;
	}

	public int getParticipantKg() {
		return ParticipantKg;
	}

	public void setParticipantKg(int participantKg) {
		ParticipantKg = participantKg;
	}

	public double getLoanBody() {
		return LoanBody;
	}

	public void setLoanBody(double loanBody) {
		LoanBody = loanBody;
	}

	public double getFat() {
		return Fat;
	}

	public void setFat(double fat) {
		Fat = fat;
	}

	public double getFFMI() {
		return FFMI;
	}

	public void setFFMI(double fFMI) {
		FFMI = fFMI;
	}

	@Override
	public String toString() {
		return "ParticipantDTO [ParticipantNumber=" + ParticipantNumber + ", ParticipantName=" + ParticipantName
				+ ", ParticipantCm=" + ParticipantCm + ", ParticipantKg=" + ParticipantKg + ", \n LoanBody=" + LoanBody
				+ ", Fat=" + Fat + ", FFMI=" + FFMI + "]";
	}


	
	


	
	
	
}
