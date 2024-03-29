/*
 	네오는 평소 프로도가 비상금을 숨겨놓는 장소를 알려줄 비밀지도를 손에 넣었다. 그런데 이 비밀지도는 숫자로 암호화되어 있어 위치를 확인하기 위해서는 암호를 해독해야 한다. 다행히 지도 암호를 해독할 방법을 적어놓은 메모도 함께 발견했다.

	지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 “공백”(“ “) 또는 “벽”(“#”) 두 종류로 이루어져 있다.
	전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다. 각각 “지도 1”과 “지도 2”라고 하자. 지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다. 지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
	“지도 1”과 “지도 2”는 각각 정수 배열로 암호화되어 있다.
	암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.
	
	입력 형식
	입력으로 지도의 한 변 크기 n 과 2개의 정수 배열 arr1, arr2가 들어온다.
	
	1 ≦ n ≦ 16
	arr1, arr2는 길이 n인 정수 배열로 주어진다.
	정수 배열의 각 원소 x를 이진수로 변환했을 때의 길이는 n 이하이다. 즉, 0 ≦ x ≦ 2^n - 1을 만족한다.
	출력 형식
	원래의 비밀지도를 해독하여 "#", 공백으로 구성된 문자열 배열로 출력하라.
	
	매개변수	값
	n	=	5
	arr1	[9, 20, 28, 18, 11]
	arr2	[30, 1, 21, 17, 28]
	출력	["#####","# # #", "### #", "#  ##", "#####"]
 */
package SH;

public class SecretMap {
	/* Solve_1
	public static void main(String[] args) {
		
		int number1 = 5;
		int arr1[] = {9, 20, 28, 18, 11};
		int arr2[] = {30, 1, 21, 17, 28};
		
		
		int number2 = 6;
		int arr1[] = {46, 33, 33, 22, 31, 50};
		int arr2[] = {27, 56, 19, 14, 14, 10};
		
		int length = number2;
		String newArray[][] = new String[length][length];
		
		

		for (int i=0; i<length; i++) {
			int temp_arr1[] = new int[length];
			
			for (int j=0; j<length; j++) {
				temp_arr1[length-1-j] = arr1[i]%2;
				arr1[i]/=2;
			}
			
			int temp_arr2[] = new int[length];
			
			for (int j=0; j<length; j++) {
				temp_arr2[length-1-j] = arr2[i]%2;
				arr2[i]/=2;
			}
			
			for (int j=0; j<length; j++) {
				if (temp_arr1[j] == 0 && temp_arr2[j] == 0) {
					newArray[i][j] = " ";
				} else {
					newArray[i][j] = "#";
				}
			}
		}
		
		for (int i=0; i<length; i++) {
			System.out.print("\"");
			for (int j=0; j<length; j++) {
				System.out.print(newArray[i][j]);
			}
			
			System.out.print("\"");
			
			if (i < length-1) {
				System.out.print(",");				
			}
		}
	}
	 */
	
	/*
	 * Solve_2
	 * 
	 * --> toBinaryString 은 앞에 0을 붙여서 반환하지 않는다.
	 * 따라서 테스트 케이스를 (9, n, n, n, n) , (9, n, n, n, n) 으로 하면
	 * 첫번째 배열이 "#__#"와 같이 4자리수의 문자열을 반환하는 문제가 있음.
	 * --> arr[i].length() 의 길이가 n 보다 작을 경우 그 차이만큼 0을 추가하는 조건문이 필요.
	 * 
	 * */  
	public static void main(String[] args) {
        int[] arr1;
        int[] arr2;
        
        arr1 = new int[]{9, 20, 28, 18, 11};
        arr2 = new int[]{30, 1, 21, 17, 28};
        printArr(decodeScretMap(5, arr1, arr2));
        
        arr1 = new int[]{46, 33, 33 ,22, 31, 50};
        arr2 = new int[]{27 ,56, 19, 14, 14, 10};
        printArr(decodeScretMap(6, arr1, arr2));
    }
	
	/*
	 * 입력받은 arr1, arr2의 각 int를 or 연산 처리
	 * -> toBinaryString 를 이용해 변환 -> 출력형태에 맞게 문자열 replace
	 * @param n
	 * @param arr1
	 * @param arr2
	 * @return
	 * */
	static String[] decodeScretMap(int n, int[] arr1, int[] arr2) {
		String[] retArr = new String[n];
		
		for (int i = 0; i < n ; i++) {
			retArr[i] = Integer.toBinaryString(arr1[i] | arr2[i])
					.replace("0", " ")
					.replace("1", "#");
		}
		
		return retArr;
	}
	
	/*
	 * 배열을 입력받아 println
	 * @param arr
	 * */
	static void printArr(String[] arr) {
		StringBuilder sb = new StringBuilder();
		
		for (String str : arr) {
			sb.append(", \"" + str + " \"");
		}
		
		System.out.println(sb.toString().replaceFirst(", ", ""));
	}
}
