package com.altemetric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ShopperDelight {

	public static long getNumberOfOptions(List<Integer> priceOfJeans, List<Integer> priceOfShoes,
			List<Integer> priceOfSkirts, List<Integer> priceOfTops, int budgeted) {

		long result = 0l;
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		int temp = budgeted;

		/*
		 * int jlen = priceOfJeans.size(); if (jlen==1) { temp = temp
		 * -priceOfJeans.get(0); } int shlen = priceOfShoes.size(); if (shlen==1) { temp
		 * = temp -priceOfShoes.get(0); } int sklen = priceOfSkirts.size(); if
		 * (sklen==1) { temp = temp -priceOfSkirts.get(0); } int tlen =
		 * priceOfTops.size(); if (tlen==1) { temp = temp -priceOfTops.get(0); }
		 * 
		 * if (temp <= budgeted) { temp = temp -priceOfTops.get(0); result++; }
		 */
    
		
		list.add(priceOfJeans);
		list.add(priceOfShoes);
		list.add(priceOfSkirts);
		list.add(priceOfTops);

		Iterator<List<Integer>> it = list.iterator();
		
		while (it.hasNext()) {
			List<java.lang.Integer> list2 = (List<java.lang.Integer>) it.next();
			if (list2.size()==1) {
				temp= temp-list2.get(0);
				it.remove();
			}
			
		}
		
		
		
		while (temp >= 0) {

		}

		return result;

	}

	public static void main(String[] args) {
		List<Integer> priceOfJeans = Arrays.asList(2, 3);
		List<Integer> priceOfShoes = Arrays.asList(4);

		List<Integer> priceOfSkirts = Arrays.asList(2, 3);
		List<Integer> priceOfTops = Arrays.asList(1, 2);
		int budgeted = 10;

		getNumberOfOptions(priceOfJeans, priceOfShoes, priceOfSkirts, priceOfTops, budgeted);

	}

}
