package com.string.manipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings&h_r=next-challenge&h_v=zen
public class ValidString {

	public static String isValid(String s) {

		String status = "NO";
		List<Integer> temp = new ArrayList<Integer>();

		List<String> list = Arrays.asList(s.split(""));

		Set<String> set = new HashSet<>(list);

		for (String s1 : set) {
			int frequency = Collections.frequency(list, s1);
			temp.add(frequency);

		}
		List<Integer> collect = temp.stream().sorted().collect(Collectors.toList());

		int size = collect.size();

		int f1 = Collections.frequency(collect, collect.get(0));
		

		if (f1 == size) {
			status = "YES";
		} else {
			if (f1 == size - 1 && collect.get(size - 1) == (collect.get(0) + 1)) {
				status = "YES";
			} else if (f1 == 1   && collect.get(size - 1) <= collect.get(size - 2)) {
				status = "YES";
			}
		}

		return status;

	}

	public static void main(String[] args) {

		// String s = "abcdefghhgfedecba";

		// String s = "aabbccddeeffgggg";

		//String s = "ebhcgicceggecgdcibbeicigehhebabiehbdgaeaigihghbhigihfebgabicbgfhhedgbfehiahchcecedffhccebifcbdfcfaecicafahfiecceeaabbecfhgbfifabbffadcieeaiidddhfdeccaedbgcfdehbadihheieidgcfbdiiicgahebfbbdfeffegbdhgdagefhbgafaabfghdcbfdhabhfahbdhgifbghhafcieachcbeabccbiigdcfegcccfafehegbiecbdhabcffggiifaabfagbfdfbfacdcafabccgibiidgabiabigbgbbaideeagaaffcddhieicehhchfedfgbgbfhgedhacegaieeedggacbbgadeibbbcdhbabbieibcfbhgdbbiecdhbffaghhchhddcihgdgbgdcfgfggeaahffgiddeadgcegaiddhhdgagdidgacafececiebeigcbdfaedibbgbhciihcdifbacdagfbcefifefchhddadeaiegbfaidbeebiefghfghhdabdeegabagfbbdgbeaiiigeaadhbgebedddfihagdeiccdbcfchgadhgfaidaebfabbagdghebgagbfhfbgeagdgecbhfchebdgafceaffabagedbhcgcedaecdbiifefchcbgfbbibhiahchhfadffeacfbgeigaccedadaafhcieficdfhfheibfdhbgbfhhdfcghabacggchchbdaigbcihhdbifcdeggicgacehebadbdaibhdciefdgfhfeggdhgcaeeeidfebbaicgagcaiachffhadbddhhdbcehciagfdgeadidfcaaiafeadefbbbaidgiagbeacchbdaifgccgcfigefcachiiggbghfhbifciafgfigaabidhdgffcbgicbidibacbgfhddafbegdaagbhddceeifecciddigfiehdbdabahgaechffidebhicfcciahhchebdbei{-truncated-}";

		String s = "xxxaabbccrry";
		
		String valid = isValid(s);

		System.out.println("String valid or not : " + valid);

	}

}
