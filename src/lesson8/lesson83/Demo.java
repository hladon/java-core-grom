package lesson8.lesson83;

public class Demo {
	Student denis = null;
	Student sergey = null;
	Student valera = null;
	Course mathematic = null;
	Course phisic = null;
	Course phylosophy = null;
	Student[] students = { denis, sergey, valera };
	Course[] courses = { mathematic, phisic, phylosophy };

	Student createHighestParent() {

		denis = new Student("Denis", "Demidiv", 2, courses);
		return denis;
	}

	SpecialStudent createLowestChild() {
		SpecialStudent evgen = new SpecialStudent("Evgen", "Tkach", 2, courses, 234675830, "botan@ukr.net");
		return evgen;
	}
}
