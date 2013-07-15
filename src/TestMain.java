
public class TestMain {
	static double grow = 2.0;
	static int mhp = 0;
	static int exhp = 1500;
	static int lv = 0;
	static int mlv = 100;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello main");
		
		while(lv<mlv){
			levelup();
		}
	}

	private static void levelup(){
		double base = (exhp-mhp)/(mlv-lv); // 基本增长值
		double rate = 0;
		if (lv<mlv/2){
			rate = grow * (1-lv*2/mlv); // 当前变率
		} else if (lv==mlv/2){
			rate = 1;
		} else{
			double mother = grow * (1-(mlv-lv)*2/mlv);
			if (mother>0){
				rate = 1/mother;
			} else{
				rate = 0;
			}
		}
		//int change = (int) Math.round(base*rate);
		double change = base*rate;
		
		String msg = "lv:"+lv+"->"+(lv+1)+" hp:"+mhp+" +"+change;
		lv++;
		mhp+=change;
		msg+=" ->"+mhp;
		System.out.println(msg);
	}
}
