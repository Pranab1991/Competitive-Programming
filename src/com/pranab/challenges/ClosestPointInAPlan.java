package com.pranab.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ClosestPointInAPlan {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numOfPoints = sc.nextInt();
		Point[] points = new Point[numOfPoints];
		for (int index = 0; index < numOfPoints; index++) {
			double x = sc.nextInt();
			double y = sc.nextInt();
			points[index] = new Point(x, y);
		}
		Point[] pointSortedByX = Arrays.copyOf(points, numOfPoints);
		mergSort(pointSortedByX, 0, numOfPoints - 1, (p1, p2) -> p1.x.compareTo(p2.x));
		Point[] pointSortedByY = Arrays.copyOf(points, numOfPoints);
		mergSort(pointSortedByY, 0, numOfPoints - 1, (p1, p2) -> p1.y.compareTo(p2.y));
		MinPoint mp = closestPair(pointSortedByX, pointSortedByY);
		System.out.println("done");
	}

	private static MinPoint closestPair(Point[] px, Point[] py) {
		if (px.length == 2) {
			return new MinPoint(px[0], px[1], calculateEuclidianDistance(px[0], px[1]));
		}
		if (px.length == 1) {
			return null;
		}
		int partition = (px.length) / 2;
		Point[] lx = Arrays.copyOf(px, partition);
		Point[] rx = Arrays.copyOfRange(px, partition, px.length);
		Point partitionBound = lx[lx.length - 1];
		Point[] ly = new Point[lx.length];
		Point[] ry = new Point[rx.length];
		findlyAndry(py, partitionBound, ly, ry);
		MinPoint minDistanceLeft = closestPair(lx, ly);
		MinPoint minDistanceRight = closestPair(rx, ry);
		double delta  = calculateDelta(minDistanceLeft, minDistanceRight);
		MinPoint minDistanceSplit = closestSplitPair(px, py, delta);
		MinPoint result = null;
		result = findResult(minDistanceLeft, minDistanceRight, minDistanceSplit);
		return result;
	}

	private static void findlyAndry(Point[] py, Point partitionBound, Point[] ly, Point[] ry) {
		int index = 0;
		int i = 0;
		int j = 0;
		for (; index < py.length; index++) {
			if (i == ly.length || j == ry.length) {
				break;
			}
			if (py[index].x.compareTo(partitionBound.x) <= 0) {
				ly[i] = py[index];
				i++;
			} else {
				ry[j] = py[index];
				j++;
			}
		}
		if(index < py.length) {
			if(i == ly.length) {
				for (; index < py.length; index++) {
					ry[j] = py[index];
					j++;
				}
			}else {
				for (; index < py.length; index++) {
					ly[i] = py[index];
					i++;
				}
			}
		}
	}

	private static MinPoint findResult(MinPoint minDistanceLeft, MinPoint minDistanceRight, MinPoint minDistanceSplit) {
		MinPoint result;
		if (minDistanceSplit != null && minDistanceLeft != null && minDistanceRight != null) {
			if (minDistanceSplit.distance < minDistanceLeft.distance
					&& minDistanceSplit.distance < minDistanceRight.distance) {
				result = minDistanceSplit;
			} else if (minDistanceLeft.distance < minDistanceSplit.distance
					&& minDistanceLeft.distance < minDistanceRight.distance) {
				result = minDistanceLeft;
			} else {
				result = minDistanceRight;
			}
		} else {
			if (minDistanceLeft != null && minDistanceRight != null) {
				if (minDistanceLeft.distance < minDistanceRight.distance) {
					result = minDistanceLeft;
				} else {
					result = minDistanceRight;
				}
			} else if (minDistanceLeft != null && minDistanceSplit != null) {
				if (minDistanceLeft.distance < minDistanceSplit.distance) {
					result = minDistanceLeft;
				} else {
					result = minDistanceSplit;
				}
			} else if (minDistanceRight != null && minDistanceSplit != null) {
				if (minDistanceRight.distance < minDistanceSplit.distance) {
					result = minDistanceRight;
				} else {
					result = minDistanceSplit;
				}
			} else {
				if (minDistanceLeft == null && minDistanceSplit == null) {
					result = minDistanceRight;
				} else if (minDistanceRight == null && minDistanceSplit == null) {
					result = minDistanceLeft;
				} else {
					result = minDistanceSplit;
				}
			}
		}
		return result;
	}

	private static double calculateDelta(MinPoint minDistanceLeft, MinPoint minDistanceRight) {
		double delta;
		if (minDistanceLeft != null && minDistanceRight != null) {
			delta = minDistanceRight.distance > minDistanceLeft.distance ? minDistanceLeft.distance
					: minDistanceRight.distance;
		} else {
			if (minDistanceLeft == null) {
				delta = minDistanceRight.distance;
			} else {
				delta = minDistanceLeft.distance;
			}
		}
		return delta;
	}

	private static MinPoint closestSplitPair(Point[] px, Point[] py, double delta) {
		double partition = (px.length) / 2.0;
		double partitionMinusDelta = partition - delta;
		double partitionPlusDelta = partition + delta;
		List<Point> filteredStripY = new ArrayList<>();
		for (int index = 0; index < py.length; index++) {
			if (py[index].x > partitionMinusDelta && py[index].x < partitionPlusDelta) {
				filteredStripY.add(py[index]);
			}
		}
		double mindistance = delta;
		MinPoint minPoint = null;
		if (!filteredStripY.isEmpty()) {
			for (int index = 0; index < filteredStripY.size() - 1; index++) {
				for (int count = 1; index + count < filteredStripY.size() && count <= 7; count++) {
					double distance = calculateEuclidianDistance(filteredStripY.get(index),
							filteredStripY.get(index + count));
					if (distance < mindistance) {
						mindistance = distance;
						minPoint = new MinPoint();
						minPoint.p1 = filteredStripY.get(index);
						minPoint.p2 = filteredStripY.get(index + count);
						minPoint.distance = distance;
					}
				}
			}
		}
		return minPoint;
	}

	private static double calculateEuclidianDistance(Point p1, Point p2) {
		double xDistance = p2.x - p1.x;
		double yDistance = p2.y - p1.y;
		return Math.sqrt(xDistance * xDistance + yDistance * yDistance);
	}

	private static void mergSort(Point[] points, int startIndex, int endIndex, Comparator<Point> comparator) {
		if (startIndex == endIndex) {
			return;
		}
		int partition = (startIndex + endIndex) / 2;
		mergSort(points, startIndex, partition, comparator);
		mergSort(points, partition + 1, endIndex, comparator);
		merge(points, startIndex, partition, endIndex, comparator);
	}

	private static void merge(Point[] points, int startIndex, int partition, int endIndex,
			Comparator<Point> comparator) {
		Point[] leftPoints = new Point[partition - startIndex + 1];
		Point[] rightPoints = new Point[endIndex - partition];
		for (int index = 0, temp = startIndex; index < leftPoints.length; index++, temp++) {
			leftPoints[index] = points[temp];
		}
		for (int index = 0, temp = partition + 1; index < rightPoints.length; index++, temp++) {
			rightPoints[index] = points[temp];
		}
		int iter = startIndex;
		int i = 0;
		int j = 0;
		for (; iter <= endIndex; iter++) {
			if (i == leftPoints.length || j == rightPoints.length) {
				break;
			}
			if (comparator.compare(leftPoints[i], rightPoints[j]) < 0) {
				points[iter] = leftPoints[i];
				i++;
			} else {
				points[iter] = rightPoints[j];
				j++;
			}
		}
		if (i == leftPoints.length) {
			for (; iter <= endIndex; iter++) {
				points[iter] = rightPoints[j];
				j++;
			}
		}
		if (j == rightPoints.length) {
			for (; iter <= endIndex; iter++) {
				points[iter] = leftPoints[i];
				i++;
			}
		}
	}
}

class Point {
	Double x;
	Double y;

	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
}

class MinPoint {
	Point p1;
	Point p2;
	double distance;

	public MinPoint(Point p1, Point p2, double distance) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.distance = distance;
	}

	public MinPoint() {
		super();
	}
}
