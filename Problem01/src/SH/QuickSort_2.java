package SH;

public class QuickSort_2 {
	public static void swap (int[] a, int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	public static void quickSort (int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}
	
	public static void quickSort (int[] arr, int start, int end) {
		int part2 = partition (arr, start, end);	
		// part2 는 partition 에서 오른쪽 그룹의 첫번째 값을 return 받음
		  
		// 오른쪽 그룹의 시작이 시작점(start) 바로 다음이면 왼쪽 그룹은 하나밖에 없으므로 정렬을 할 필요가 없음
		// 즉 왼쪽 그룹에 최소 2개이상의 데이터가 있을 때만 정렬
		if (start < part2 - 1) {
			quickSort(arr, start, part2 - 1);
		}
		
		// 오른쪽 그룹의 마지막 값(end)이 오른쪽 그룹의 시작점보다 작은경우
		// 즉 2개이상의 데이터가 있을 때만 정렬
		if (part2 < end) {
			quickSort(arr, part2, end);
		}
	}
	
	public static int partition (int[] arr, int start, int end) {
		int pivot = arr[(start+end) / 2];
		
		while (start <= end) {
			while (arr[start] < pivot) start++;
			while (arr[end] > pivot) end--;
			
			if (start <= end) {
				swap (arr, start, end);
				
				start++;
				end--;
			}
		}
		
		return start;
	}
	
	public static void printArray (int[] arr) {
		for (int data : arr) {
			System.out.print(data + ", ");
		}
		
		System.out.println();
	}
	
	public static void main (String[] args) {
		int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
		
		printArray(arr);
		quickSort(arr);
		printArray(arr);
	}
}
