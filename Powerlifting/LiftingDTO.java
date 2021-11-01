package Powerlifting;

public class LiftingDTO {
	
	int MeasurementNum;
	int DeadLift;
	int Squat;
	int BenchPress;
	int sum;
	
	LiftingDTO(){
	}

	public int getMeasurementNum() {
		return MeasurementNum;
	}

	public void setMeasurementNum(int measurementNum) {
		MeasurementNum = measurementNum;
	}

	public int getDeadLift() {
		return DeadLift;
	}

	public void setDeadLift(int deadLift) {
		DeadLift = deadLift;
	}

	public int getSquat() {
		return Squat;
	}

	public void setSquat(int squat) {
		Squat = squat;
	}

	public int getBenchPress() {
		return BenchPress;
	}

	public void setBenchPress(int benchPress) {
		BenchPress = benchPress;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "LiftingDTO [MeasurementNum=" + MeasurementNum + ", DeadLift=" + DeadLift + ", Squat=" + Squat
				+ ", BenchPress=" + BenchPress + ", sum=" + sum + "]";
	}

	public LiftingDTO(int deadLift, int squat, int benchPress,int measurementNum, int sum) {
		MeasurementNum = measurementNum;
		DeadLift = deadLift;
		Squat = squat;
		BenchPress = benchPress;
		this.sum = sum;
	}

	
	
	
	
}
