package com.charles.regex;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class JavaRegexFinder {
	static String INPUT = "Update the table ;\n" + 
"update the table two ;\r\n"
			+ "update the , second table two ; \t \n" +
"update the,point table two ; \r\n"
			+ "update the, first table two; \t \r\n" + 
"update the table three ;";

	public static void main(String[] args) {
		String[] regexCharacters = new String[] { ";", ".", "$", "[", "]", "\\Z", "\\z", "*", "+", "?", "{", "}", "|",
				"(", ")", "\\s", "\\S", "\\r", "\\n", "\\t", "\\f", " " };

		RegexPermutation.printAllKLength(regexCharacters);
	}
}

class RegexPermutation {

	public static void printAllKLength(String[] set) {
		int n = set.length;
		for (int i = 7; i < 30; i++) {
			new Thread(new FindMatch(set, "", n, i)).start();
		}

	}

}

class FindMatch implements Runnable {
	private String[] set;
	private String prefix;
	private int n;
	private int initialK;

	public FindMatch(String[] set, String prefix, int n, int k) {
		this.set = set;
		this.prefix = prefix;
		this.n = n;
		this.initialK = k;
	}

	private void printAllKLengthRec(String[] set, String prefix, int n, int k) {
		if (k == 0) {
			
			if (!prefix.contains(";")) {
				return;
			}
			new Thread(new DoWork(initialK, prefix)).start();
			return;
		}
		for (int i = 0; i < n; ++i) {
			String newPrefix = prefix + set[i];
			printAllKLengthRec(set, newPrefix, n, k - 1);
		}
	}

	@Override
	public void run() {
		printAllKLengthRec(set, prefix, n, initialK);
	}
}

class DoWork implements Runnable {
	String regex;
	int initialK;

	public DoWork(int initialK, String regex) {
		this.regex = regex;
		this.initialK = initialK;
	}

	@Override
	public void run() {
		Pattern p = null;
		try {
			p = Pattern.compile(regex);
//			Matcher m = p.matcher(JavaRegexFinder.INPUT); // get a matcher object
//			if (m.matches()) {
				System.out.println("INITIAL SIZE(K) : " + initialK + "REGEX FITTING CRITERIA : " + regex);
				Writer.getWriter().write("INITIAL SIZE(K) : " + initialK + "REGEX FITTING CRITERIA : " + regex);
//			}
		} catch (Exception e) {
		}
	}
}

class Writer {
	public static Writer writer;
	final private static Object o = new Object();
	static File f = new File("C:\\Users\\Abhishek\\Workspaces\\JavaRegexFinder\\src\\main\\resources\\matcherout.txt");

	private Writer() {

	}

	public static synchronized Writer getWriter() {
		if (writer == null) {
			synchronized (o) {
				if (writer == null) {
					writer = new Writer();
				}
			}
		}
		return writer;
	}

	public synchronized void write(String charset) {
		try {
			FileUtils.write(f, charset + " \n", "utf-8", true);
		} catch (IOException e) {
			System.out.println("Error while writing content " + e.getMessage());
		}
	}

}
