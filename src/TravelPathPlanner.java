import java.util.ArrayList;

public class TravelPathPlanner {

	public static void main(String[] args) {
		//������ �� �� 
		int TravelPathTotalCnt = 4;
		
		//TravelPathPlanner �Լ� ����
		String fianlPath = getPathValue(TravelPathTotalCnt);
		
		//Output ���
		System.out.println("fianlPath:::>>>"+ fianlPath);

	}
	
	public static String getPathValue(int totalPathCnt){
		String result = "";
		
		//��δ� �ҿ��� ����
		int[][] expense = new int[][]{{0, 20, 50, 100000 }
					   ,{100000, 0, 10, 10}
					   ,{100000, 20, 0, 40}
					   ,{100000, 100000, 100000, 0}};
		//��δ� �ҿ�ð� ����
		int[][] time = new int[][]{{0, 15, 5, 100000 }
					   ,{100000, 0, 10, 10}
					   ,{100000, 5, 0, 5}
					   ,{100000, 100000, 100000, 0}};
		
		
		//�ּ� [�ҿ��� + �ҿ�ð�] ��
		//�ʱ�ȭ�� ������ ū ������ ����
		double minValue = 100000;
		//minValue �񱳰�
		double compValue = 0;
		//���� ���� ��
		double resultExpense = 0;
		
		//�ҿ��� ����ġ 
		double expenseValue = 0.7;
		//�ҿ�ð� ����ġ
		double timeValue = 0.3;
		
		
		//��ΰ� ���� 
		ArrayList<Object> path = new ArrayList<>();
		int k = 0;
		
		for (int i = 0; i < totalPathCnt; i++) {
			
			for (int j = 0; j < totalPathCnt; j++) {
				if(i != j){
							
					compValue = expense[i][j]*expenseValue + time[i][j]*timeValue;
					
					if (compValue < minValue) {
						minValue = compValue;
						
						path.add(k, String.valueOf(i+1) + "��" + String.valueOf(j+1));						
						resultExpense = resultExpense + minValue;

						k++;
						
					}
					
				}
			}

			//�񱳰� �ʱ�ȭ
			compValue = 0;
			minValue = 10000;
			

			//������ �������̶��,
			if (i == totalPathCnt -1) {
				for (int l = 0; l < totalPathCnt; l++) {
					if(l != totalPathCnt-1){
						compValue = expense[l][totalPathCnt-1]*expenseValue + time[l][totalPathCnt-1]*timeValue;
						
						if (compValue < minValue) {
							minValue = compValue;
							path.add(k, String.valueOf(l+1) + "��" + String.valueOf(totalPathCnt));						
							resultExpense = resultExpense + minValue;

							k++;
						}
					}
				}
				
			}
			
			
		}
		
		
		result = "�� �ҿ���:::" + resultExpense + "  ���:::" + path.toString();
		
		return result;
	}

}
