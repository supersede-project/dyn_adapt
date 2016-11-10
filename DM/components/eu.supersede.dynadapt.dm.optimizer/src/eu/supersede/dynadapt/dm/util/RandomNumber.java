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
package eu.supersede.dynadapt.dm.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.fbk.gbtlib.utils.MersenneTwister;
import eu.supersede.dynadapt.dm.optimizer.gp.Parameters;

public class RandomNumber implements Serializable {

	private static final long serialVersionUID = -5934455398558935937L;

	private static final Logger logger = LoggerFactory.getLogger(RandomNumber.class);

	private static long seed = 0;

	private static Random random = null;

	private static RandomNumber instance = new RandomNumber();

	private RandomNumber() {
		Long seed_parameter = Parameters.RANDOM_SEED;
		if (seed_parameter != null) {
			seed = seed_parameter;
		} else {
			seed = System.currentTimeMillis();
		}
		random = new MersenneTwister(seed);
	}

	/**
	 * <p>
	 * Getter for the field <code>instance</code>.
	 * </p>
	 * 
	 * @return a {@link org.evosuite.utils.Randomness} object.
	 */
	public static RandomNumber getInstance() {
		if (instance == null) {
			instance = new RandomNumber();
		}
		return instance;
	}

	/**
	 * <p>
	 * nextBoolean
	 * </p>
	 * 
	 * @return a boolean.
	 */
	public static boolean nextBoolean() {
		return random.nextBoolean();
	}

	/**
	 * <p>
	 * nextInt
	 * </p>
	 * 
	 * @param max
	 *            a int.
	 * @return a int.
	 */
	public static int nextInt(int max) {
		return random.nextInt(max);
	}

	public static double nextGaussian() {
		return random.nextGaussian();
	}
	
	/**
	 * <p>
	 * nextInt
	 * </p>
	 * 
	 * @param min
	 *            a int.
	 * @param max
	 *            a int.
	 * @return a int.
	 */
	public static int nextInt(int min, int max) {
		return random.nextInt(max - min) + min;
	}

	/**
	 * <p>
	 * nextInt
	 * </p>
	 * 
	 * @return a int.
	 */
	public static int nextInt() {
		return random.nextInt();
	}

	/**
	 * <p>
	 * nextChar
	 * </p>
	 * 
	 * @return a char.
	 */
	public static char nextChar() {
		return (char) (nextInt(32, 128));
		//return random.nextChar();
	}

	/**
	 * <p>
	 * nextShort
	 * </p>
	 * 
	 * @return a short.
	 */
	public static short nextShort() {
		return (short) (random.nextInt(2 * 32767) - 32767);
	}

	/**
	 * <p>
	 * nextLong
	 * </p>
	 * 
	 * @return a long.
	 */
	public static long nextLong() {
		return random.nextLong();
	}

	/**
	 * <p>
	 * nextByte
	 * </p>
	 * 
	 * @return a byte.
	 */
	public static byte nextByte() {
		return (byte) (random.nextInt(256) - 128);
	}

	/**
	 * <p>
	 * nextDouble
	 * </p>
	 * 
	 * @return a double.
	 */
	public static double nextDouble() {
		return random.nextDouble();
	}

	/**
	 * <p>
	 * nextFloat
	 * </p>
	 * 
	 * @return a float.
	 */
	public static float nextFloat() {
		return random.nextFloat();
	}

	/**
	 * <p>
	 * Setter for the field <code>seed</code>.
	 * </p>
	 * 
	 * @param seed
	 *            a long.
	 */
	public static void setSeed(long seed) {
		RandomNumber.seed = seed;
		random.setSeed(seed);
	}

	/**
	 * <p>
	 * Getter for the field <code>seed</code>.
	 * </p>
	 * 
	 * @return a long.
	 */
	public static long getSeed() {
		return seed;
	}

	/**
	 * <p>
	 * choice
	 * </p>
	 * 
	 * @param list
	 *            a {@link java.util.List} object.
	 * @param <T>
	 *            a T object.
	 * @return a T object or <code>null</code> if <code>list</code> is empty.
	 */
	public static <T> T choice(List<T> list) {
		if (list.isEmpty())
			return null;

		int position = random.nextInt(list.size());
		return list.get(position);
	}

	/**
	 * <p>
	 * choice
	 * </p>
	 * 
	 * @param set
	 *            a {@link java.util.Collection} object.
	 * @param <T>
	 *            a T object.
	 * @return a T object or <code>null</code> if <code>set</code> is empty.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T choice(Collection<T> set) {
		if (set.isEmpty())
			return null;

		int position = random.nextInt(set.size());
		return (T) set.toArray()[position];
	}

	/**
	 * <p>
	 * choice
	 * </p>
	 * 
	 * @param elements
	 *            a T object.
	 * @param <T>
	 *            a T object.
	 * @return a T object or <code>null</code> if <code>elements.length</code> is zero.
	 */
	public static <T> T choice(T... elements) {
		if (elements.length == 0)
			return null;

		int position = random.nextInt(elements.length);
		return elements[position];
	}

	/**
	 * <p>
	 * shuffle
	 * </p>
	 * 
	 * @param list
	 *            a {@link java.util.List} object.
	 */
	public static void shuffle(List<?> list) {
		Collections.shuffle(list, random);
	}

	/**
	 * <p>
	 * nextString
	 * </p>
	 * 
	 * @param length
	 *            a int.
	 * @return a {@link java.lang.String} object.
	 */
	public static String nextString(int length) {
		char[] characters = new char[length];
		for (int i = 0; i < length; i++)
			characters[i] = nextChar();
		return new String(characters);
	}
}
