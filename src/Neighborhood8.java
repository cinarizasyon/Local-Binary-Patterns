
public class Neighborhood8 {

	private Matrix neighborhood;

	public Neighborhood8(Matrix neighborhood) {
		this.neighborhood = neighborhood;
	}

	public int get(int number) {
		int result = -1;
		if (number == 1) {
			return neighborhood.getValue(0, 0);
		} else if (number == 2) {
			return neighborhood.getValue(0, 1);

		} else if (number == 3) {
			return neighborhood.getValue(0, 2);

		} else if (number == 4) {
			return neighborhood.getValue(1, 2);

		} else if (number == 5) {
			return neighborhood.getValue(2, 2);

		} else if (number == 6) {
			return neighborhood.getValue(2, 1);

		} else if (number == 7) {
			return neighborhood.getValue(2, 0);

		} else if (number == 8) {
			return neighborhood.getValue(1, 0);

		}
		return result;
	}

	public int getCenter() {
		return neighborhood.getValue(1, 1);
	}
}
