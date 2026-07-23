class AlgorithmMain {
	int getLongestValidSubstring(String input) {
		int[] arr = new int[input.length()];
		int open = 0;
		for (int i=0; i<input.length(); i++) {
			char current = input.charAt(i);
			if (current == '(') {
				open++;
				arr[i] = 0;
			} else {
				if (open > 0) {
					open--;
					if (i - 1 >= 0) {
						arr[i] = arr[i-1] + 2;
						if (i - arr[i] >= 0) {
							arr[i] = arr[i] + arr[i-arr[i]];
						} else {
							System.out.println("There is no such element");
						}
					} else {
						System.out.println("There is no prev element");
					}
				} else {
					arr[i] = 0;
					continue;
				}
			}
		}
		return getMaxValue(arr);
	}
	
	int getMaxValue (int[] arr) {
		if(arr.length == 0) return 0;
		int max = arr[0];
		for (int i = 1; i<arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}
}

public class Algorithm2 {
	public static void main(String[] args) {
		System.out.println("Started main");
		AlgorithmMain algo = new AlgorithmMain();
		int result = algo.getLongestValidSubstring(")()()))()(())()()(");
		System.out.println(result);
	}
	
}
