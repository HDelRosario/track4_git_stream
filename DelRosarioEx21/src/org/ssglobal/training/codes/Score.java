package org.ssglobal.training.codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Score {
		
	ScoreInfo student1 = new ScoreInfo("Smith", "John", 70);
	ScoreInfo student2 = new ScoreInfo("Doe", "Mary", 85);
	ScoreInfo student3 = new ScoreInfo("Page", "Alice", 82);
	ScoreInfo student4 = new ScoreInfo("Cooper", "Jill",97);
	ScoreInfo student5 = new ScoreInfo("Flintstone", "Fred" ,66);
	ScoreInfo student6 = new ScoreInfo("Rubble", "Barney", 80);
	ScoreInfo student7 = new ScoreInfo("Smith", "Judy", 48);
	ScoreInfo student8 = new ScoreInfo("Dean", "James", 90);
	ScoreInfo student9 = new ScoreInfo("Russ", "Joe", 55);
	ScoreInfo student10 = new ScoreInfo("Wolfe", "Bill", 73);
	ScoreInfo student11 = new ScoreInfo("Dart", "Mary", 54);
	ScoreInfo student12 = new ScoreInfo("Rogers", "Chris", 78);
	ScoreInfo student13 = new ScoreInfo("Toole", "Pat", 51);
	ScoreInfo student14 = new ScoreInfo("Khan", "Omar", 93);
	ScoreInfo student15 = new ScoreInfo("Smith", "Ann", 95);
		
	List<ScoreInfo> students = new ArrayList<>(Arrays.asList(student1, student2, student3, 
															   student4, student5, student6, 
															   student7, student8, student9, 
															   student10, student11, student12, 
															   student13, student14, student15));
	Stream<ScoreInfo> studentStream = students.stream();
		
	
	public void getNumScores() {
		
		int numScores = (int) studentStream.count();
		System.out.println(numScores);
		
	}
	
	public void getAverage() {
		
		studentStream = students.stream();
		
		Function<ScoreInfo, Integer> mapToAge = (t) -> {
			return t.getScore();	
		};
		
		double aveAge = studentStream.map(mapToAge).mapToInt(Integer::intValue).average().orElse(0);
		System.out.println(aveAge);
	}
	
	public void getNumberAListers() {
		
		studentStream = students.stream();
		
		Predicate<ScoreInfo> filterEqualGreater90 = new Predicate<ScoreInfo>() {

			@Override
			public boolean test(ScoreInfo t) {
				if (t.getScore() >= 90) {
					return true;
				}
				return false;
			}
		};
		
		int numAListers = (int) studentStream.filter(filterEqualGreater90).count();
		System.out.println(numAListers);	
	}
	
	public void getFailingStudentList() {
		
		studentStream = students.stream();
		
		Predicate<ScoreInfo> filterLess70 = new Predicate<ScoreInfo>() {

			@Override
			public boolean test(ScoreInfo t) {
				if (t.getScore() < 70) {
					return true;
				}
				return false;
			}
		};
		
		Function<ScoreInfo, String> studentToString = new Function<>() {

			@Override
			public String apply(ScoreInfo t) {
				return String.join(" ", t.getFirstName(), t.getLastName());
			}	
		};
		
		List<String> failingStudentList = studentStream.filter(filterLess70).map(studentToString).collect(Collectors.toList());
		System.out.println(failingStudentList);
	}
	
	public void printPassingStudents() {
		
		studentStream = students.stream();
		
		Predicate<ScoreInfo> filterEqualGreater70 = new Predicate<ScoreInfo>() {

			@Override
			public boolean test(ScoreInfo t) {
				if (t.getScore() >= 70) {
					return true;
				}
				return false;
			}
		};
		
		Function<ScoreInfo, String> studentToString = new Function<>() {

			@Override
			public String apply(ScoreInfo t) {
				return String.join(" ", t.getFirstName(), t.getLastName());
			}	
		};
		
		List<String> passingStudentList = studentStream.filter(filterEqualGreater70).map(studentToString).collect(Collectors.toList());
		System.out.println(passingStudentList);
	}
	
	public void displayAllStudents() {
		
		studentStream = students.stream();
		
		Comparator<ScoreInfo> sortName = (o1, o2) -> {

			if (o1.getLastName().compareTo(o2.getLastName()) == 0) {
				return 0;
			} else if (o1.getLastName().compareTo(o2.getLastName()) > 0) {
				return 2;
			}
			return -2;
		};
		
		Function<ScoreInfo, String> studentToString = new Function<>() {

			@Override
			public String apply(ScoreInfo t) {
				return String.join(" ", t.getFirstName(), t.getLastName(), String.valueOf(t.getScore()));
			}	
		};
		
		
		List<String> allStudentList = studentStream.sorted(sortName).map(studentToString).collect(Collectors.toList());
		System.out.println(allStudentList);
	}
	
	public void getStudentRecords() {
		
		studentStream = students.stream();
		
		Comparator<ScoreInfo> sortGrades = (o1, o2) -> {

			if (o1.getScore() == (o2.getScore())) {
				return 0;
			} else if (o1.getScore() > (o2.getScore())) {
				return 2;
			}
			return -2;
		};
		
		Function<ScoreInfo, String> studentToString = new Function<>() {

			@Override
			public String apply(ScoreInfo t) {
				return String.join(" ", t.getFirstName(), t.getLastName(), String.valueOf(t.getScore()));
			}	
		};
		
		
		List<String> studentRecords = studentStream.sorted(sortGrades).map(studentToString).collect(Collectors.toList());
		System.out.println(studentRecords);
	}
}
