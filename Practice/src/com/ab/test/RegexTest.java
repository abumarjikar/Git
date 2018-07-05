package com.ab.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class RegexTest {

	public static void main(String[] args) {
		String simQuery = "SIM:(US60000001 OR us1 or US2) and T:jet engine or (SIM:us1 OR us3 or us6) AND SIM:US8";
		System.out.println(simQuery);
		String regex = "SIM:";
		Pattern pa = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pa.matcher(simQuery);
		Map<String, String> replacmentMap = new HashMap<String, String>();
		while (matcher.find()) {
			int start = matcher.start();
			int n = (simQuery.indexOf(':', start + (regex.length())) + 1);
			String queryMatched = simQuery.substring(start + (regex.length()), n > 0 ? n : simQuery.length());
			String simQu = queryMatched.split("(AND|OR|NOT|and|or|not)+ ([a-z]*|[A-Z]*):")[0];
			String simQueries = simQuery.substring(start, start + (regex.length()) + simQu.length());
			int openB = StringUtils.countMatches(simQueries, "(");
			int closeB = StringUtils.countMatches(simQueries, ")");

			simQueries = closeB - openB == 0 ? simQueries : simQueries.replaceAll("\\(|\\)", "");
			String replacement = simQueries.trim().replace("SIM:", "SIMOF(PNKC:") + ")";

			replacmentMap.put(simQueries, replacement);
		}
		for (Entry<String, String> entry : replacmentMap.entrySet()) {
			simQuery = simQuery.replace(entry.getKey(), entry.getValue());
		}
		System.out.println(simQuery);
	}
}
