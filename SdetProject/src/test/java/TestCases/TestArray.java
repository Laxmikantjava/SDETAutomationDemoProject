package TestCases;

public class TestArray {

	public static void main(String[] args) {

		int temp=0;
		int arr[] = { 90, 80, 60 };

		for (int i = 0; i < arr.length; i++) {

			for (int j = i + 1; j < arr.length; j++) {

				if (arr[i] > arr[j]) {

					temp = arr[i];
					arr[i] = arr[j];
					temp = arr[j];
				}
			}

		}
	
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}

	}

}
