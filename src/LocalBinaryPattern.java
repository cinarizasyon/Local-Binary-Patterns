
public class LocalBinaryPattern {
	private Matrix imageMatrix;
	Array spotMask = new Array(new int[] { 1, 1, 1, 1, 1, 1, 1, 1 });
	Array spotOrFlatMask = new Array(new int[] { 0, 0, 0, 0, 0, 0, 0, 0 });
	Array lineEndMask = new Array(new int[] { 1, 1, 1, 1, 0, 0, 1, 1 });
	Array edgeMask = new Array(new int[] { 0, 1, 1, 1, 1, 0, 0, 0 });
	Array cornerMask = new Array(new int[] { 1, 1, 1, 1, 0, 0, 0, 1 });
	int spotMarker = 0, spotOrflatMarker = 50, lineEndMarker = 100, edgeMarker = 150, cornerMarker = 200,
			elseMarker = 255;

	public LocalBinaryPattern(Matrix imageMatrix) {
		this.imageMatrix = imageMatrix;
	}

	public Matrix LBP() {
		Matrix result = new Matrix(imageMatrix.getRowCount(), imageMatrix.getColumnCount());
		for (int i = 0; i < imageMatrix.getRowCount(); i++) {
			for (int j = 0; j < imageMatrix.getColumnCount(); j++) {
				ImageProcessing ip = new ImageProcessing();
				Neighborhood8 neighborhood = new Neighborhood8(ip.getNeighborhood(imageMatrix, j, i, 3));
				Array bits = getBits(neighborhood);
				// int decimal = binaryToDecimal(bits);
				if (isSpot(bits)) {
					result.setValue(i, j, spotMarker);
				} else if (isSpotOrFlat(bits)) {
					result.setValue(i, j, spotOrflatMarker);
				} else if (isLineEnd(bits)) {
					result.setValue(i, j, lineEndMarker);

				} else if (isEdge(bits)) {
					result.setValue(i, j, edgeMarker);

				} else if (isCorner(bits)) {
					result.setValue(i, j, cornerMarker);

				} else {
					result.setValue(i, j, elseMarker);
				}

			}
		}
		return result;
	}

	private Array getBits(Neighborhood8 neighborhood) {
		Array bits = new Array(8);
		for (int i = 0; i < bits.getLength(); i++) {
			if (Math.abs(neighborhood.get(i + 1)) > Math.abs(neighborhood.getCenter())) {
				bits.setValue(i, 1);
			} else {
				bits.setValue(i, 0);
			}
		}
		return bits;
	}

	public int binaryToDecimal(Array binaryArray) {
		int result = 0;
		for (int i = 0; i < binaryArray.getLength(); i++) {
			result += binaryArray.getValue(i) * (2 ^ i);
		}
		return result;
	}

	private boolean isEqualToMask(Array source, Array mask) {
		boolean isEqual = true;
		for (int i = 0; i < source.getLength(); i++) {
			if (source.getValue(i) != mask.getValue(i)) {
				isEqual = false;
				break;
			}
		}
		return isEqual;
	}

	private boolean isSpot(Array bits) {
		return isEqualToMask(bits, spotMask);
	}

	private boolean isSpotOrFlat(Array bits) {
		return isEqualToMask(bits, spotOrFlatMask);
	}

	private boolean isLineEnd(Array bits) {
		return isEqualToMask(bits, lineEndMask);
	}

	private boolean isEdge(Array bits) {
		return isEqualToMask(bits, edgeMask);
	}

	private boolean isCorner(Array bits) {
		return isEqualToMask(bits, cornerMask);
	}

}
