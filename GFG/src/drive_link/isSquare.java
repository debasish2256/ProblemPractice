package drive_link;

/*
How to check if given four points form a square or Rectangle
*/

public class isSquare {

	// structure of 2d point
	static class point {
		int x, y;

		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int sqDist(point p, point q) {
		int dist = (p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y);
		return dist;
	}

	static boolean isSquare(point p1, point p2, point p3, point p4) {
		int d1 = sqDist(p1, p2);
		int d2 = sqDist(p1, p3);
		int d3 = sqDist(p1, p4);

		// System.out.println("d1="+d1+"\nd2="+d2+"\nd3="+d3);

		if (d1 == 0 || d2 == 0 || d3 == 0) {
			return false;
		}

		if (d2 == d3 && d1 == 2 * sqDist(p1, p3) && d1 == 2 * sqDist(p1, p4) && d1 == sqDist(p1, p2)
				&& d1 == sqDist(p3, p4)) {
			return true;
		}

		if (d3 == sqDist(p2, p3) && d2 == sqDist(p2, p4) && d1 == 2 * sqDist(p2, p3) && d1 == 2 * sqDist(p2, p4)) {
			return true;
		}

		return false;

	}

	static boolean isRect(point p1, point p2, point p3, point p4) {
		int d1 = sqDist(p1, p2);
		int d2 = sqDist(p1, p3);
		int d3 = sqDist(p1, p4);

		// System.out.println("d1="+d1+"\nd2="+d2+"\nd3="+d3);

		if (d1 == 0 || d2 == 0 || d3 == 0) {
			return false;
		}

		if (d1 != sqDist(p1, p4) && sqDist(p2, p4) != sqDist(p2, p3) && d2 != d3) {
			if (d1 == sqDist(p3, p4)) {
				return true;
			}

		}

		return false;

	}

	public static void main(String[] args) {
		point p1 = new point(20, 10), p2 = new point(10, 20), p3 = new point(20, 20), p4 = new point(10, 10);
		if (isSquare(p1, p2, p3, p4) == true) {
			System.out.println("This is Square");
		} else if (isRect(p1, p2, p3, p4) == true) {
			System.out.println("This is Rectangle");
		} else {
			System.out.println("Don't Know !!!");
		}
	}
}
