package com.greatlerning.buildingblock;

import java.util.Scanner;

import java.util.Stack;

public class BuildingBlockImplementation {
	Stack<Integer> stack = new Stack<Integer>();

	public void construct(int requiredFloorSize, int[] floorSizes) {

		for (int i = 0; i < floorSizes.length; i++) {

			int day = i + 1;

			System.out.println("\nDay: " + day);

			if (floorSizes[i] != requiredFloorSize) {

				System.out.print(" ");

				stack.push(floorSizes[i]);

			}

			else {

				requiredFloorSize -= 1;

				System.out.print(floorSizes[i] + " ");

				while (!stack.isEmpty() && requiredFloorSize == stack.peek())

				{

					requiredFloorSize -= 1;

					System.out.print(stack.pop() + " ");

				}

			}

		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		BuildingBlockImplementation obj = new BuildingBlockImplementation();

		System.out.println("enter the total no of floors in the building");
		int totalfloor = sc.nextInt();
		int[] floorsize = new int[totalfloor];
		for (int i = 0; i < floorsize.length; i++) {
			int day = i + 1;
			System.out.println("enter the floor size given on day :" + day);
			int Size = sc.nextInt();
			if (Size <= 0) {

				System.out.println("\nFloor size cannot be less than or equal to zero");

				i--;
			} else if (Size > totalfloor) {

				System.out.println("\nFloor size cannot be greater than totalfloor");

				i--;
			} else {

				floorsize[i] = Size;

			}

		}
		System.out.println("\nThe order of construction is as follows :");
		obj.construct(totalfloor, floorsize);
		sc.close();

	}

}
