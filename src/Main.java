import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		final int dataSetNum = 300;
		final int attributeNum = 11;

		List<Double> output;

		FileReaderHelper f = new FileReaderHelper("/Users/amir/Downloads/breast-cancer-wisconsin.data", dataSetNum, attributeNum);
		double[][] arr = f.textToArray();

		double[][] X = new double[dataSetNum][1];
		for (int i = 0; i < dataSetNum; i++) {
			if (arr[10][i] == 2) {
				X[i][0] = 0;
			}
			else if (arr[10][i] == 4) {
				X[i][0] = 1;
			}
		}
		double[][] Y = new double[dataSetNum][9];
		for (int j = 0; j < dataSetNum; j++) {
			for (int h = 0; h < 9; h++) {
				Y[j][h] = arr[h + 1][j];
			}
		}
		NeuralNetwork nn = new NeuralNetwork(9, 10, 1);
		nn.fit(Y, X, 50000);
		double[][] input1 = {{8,4,10,5,4,4,7,10,1}, {1,1,1,1,2,1,3,1,1}, {10,10,10,7,9,10,7,10,10}};
		System.out.println("0 if benign, 1 if malignant");
		for (double d[] : input1) {
			output = nn.predict(d);
			System.out.println(output.toString());
		}
	}
}