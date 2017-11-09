import java.util.ArrayList;

public class TravelPathPlanner {

	public static void main(String[] args) {
		//여행지 총 수 
		int TravelPathTotalCnt = 4;
		
		//TravelPathPlanner 함수 실행
		String fianlPath = getPathValue(TravelPathTotalCnt);
		
		//Output 출력
		System.out.println("fianlPath:::>>>"+ fianlPath);

	}
	
	public static String getPathValue(int totalPathCnt){
		String result = "";
		
		//경로당 소요비용 집합
		int[][] expense = new int[][]{{0, 20, 50, 100000 }
					   ,{100000, 0, 10, 10}
					   ,{100000, 20, 0, 40}
					   ,{100000, 100000, 100000, 0}};
		//경로당 소요시간 집합
		int[][] time = new int[][]{{0, 15, 5, 100000 }
					   ,{100000, 0, 10, 10}
					   ,{100000, 5, 0, 5}
					   ,{100000, 100000, 100000, 0}};
		
		
		//최소 [소요비용 + 소요시간] 값
		//초기화는 임의의 큰 값으로 세팅
		double minValue = 100000;
		//minValue 비교값
		double compValue = 0;
		//최종 더한 값
		double resultExpense = 0;
		
		//소요비용 가중치 
		double expenseValue = 0.7;
		//소요시간 가중치
		double timeValue = 0.3;
		
		
		//경로값 저장 
		ArrayList<Object> path = new ArrayList<>();
		int k = 0;
		
		for (int i = 0; i < totalPathCnt; i++) {
			
			for (int j = 0; j < totalPathCnt; j++) {
				if(i != j){
							
					compValue = expense[i][j]*expenseValue + time[i][j]*timeValue;
					
					if (compValue < minValue) {
						minValue = compValue;
						
						path.add(k, String.valueOf(i+1) + "→" + String.valueOf(j+1));						
						resultExpense = resultExpense + minValue;

						k++;
						
					}
					
				}
			}

			//비교값 초기화
			compValue = 0;
			minValue = 10000;
			

			//마지막 종착점이라면,
			if (i == totalPathCnt -1) {
				for (int l = 0; l < totalPathCnt; l++) {
					if(l != totalPathCnt-1){
						compValue = expense[l][totalPathCnt-1]*expenseValue + time[l][totalPathCnt-1]*timeValue;
						
						if (compValue < minValue) {
							minValue = compValue;
							path.add(k, String.valueOf(l+1) + "→" + String.valueOf(totalPathCnt));						
							resultExpense = resultExpense + minValue;

							k++;
						}
					}
				}
				
			}
			
			
		}
		
		
		result = "총 소요비용:::" + resultExpense + "  경로:::" + path.toString();
		
		return result;
	}

}
