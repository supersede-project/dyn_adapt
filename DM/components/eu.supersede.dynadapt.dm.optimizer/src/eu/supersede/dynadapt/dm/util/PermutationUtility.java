/*******************************************************************************
 * Copyright (c) 2016 FBK
 * All rights reserved. Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Fitsum Kifetew (FBK) - main development
 *
 * Initially developed in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
/**
 * 
 */
package eu.supersede.dynadapt.dm.util;


/**
 * @author fitsum
 * This class is adapted from jMetal.
 */
public class PermutationUtility {

	/**
	 * Returns a permutation vector between the 0 and (length - 1)
	 */
	public static int[] intPermutation(int length) {
		int[] aux = new int[length];
		int[] result = new int[length];

		// First, create an array from 0 to length - 1.
		// Also is needed to create an random array of size length
		for (int i = 0; i < length; i++) {
			result[i] = i;
			aux[i] = RandomNumber.nextInt(0, length);
		} // for

		// Sort the random array with effect in result, and then we obtain a
		// permutation array between 0 and length - 1
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				if (aux[i] > aux[j]) {
					int tmp;
					tmp = aux[i];
					aux[i] = aux[j];
					aux[j] = tmp;
					tmp = result[i];
					result[i] = result[j];
					result[j] = tmp;
				} // if
			} // for
		} // for

		return result;
	}// intPermutation

} // PermutationUtility
