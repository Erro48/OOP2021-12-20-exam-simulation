package ex2016.a01.t2.e2;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;

public class Logic {
	
	private final List<Integer> numbers;
	private Iterator<Integer> incIterator;
	private final Iterator<Integer> randIterator;
	
	public Logic() {
		this.numbers = new ArrayList<>();
		this.incIterator = IntStream
				.iterate(2, i -> i + 2)
				.iterator();
		this.randIterator = IntStream
				.generate(() -> 0)
				.map(i -> (int)(Math.random()*100 - 101))
				.iterator();
	}
	
	public void inc() {
		this.numbers.add(incIterator.next());
	}
	
	public void rand() {
		this.numbers.add(randIterator.next());
	}
	
	public void one() {
		numbers.add(1);
	}
	
	public void compute(PrintStream ... outputs) {
		for (PrintStream out : outputs) {
			this.numbers.forEach(out::println);
		}
		this.numbers.clear();
		this.incIterator = IntStream
				.iterate(2, i -> i + 2)
				.iterator();
	}
}
