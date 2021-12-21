package ex2016.a01.t2.e1;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class VectorImpl<X> implements Vector<X> {
	
	private final List<Optional<X>> vector;
	
	public VectorImpl() {
		this.vector = new ArrayList<>();
	}
	
	public VectorImpl(final List<X> list) {
		this.vector = list.stream().map(el -> Optional.of(el)).collect(Collectors.toList());
	}

	private boolean inBoundary(final int position) {
		if (position >= 0 && position < this.vector.size()) {
			return true;
		}
		return false;
	}
	
	@Override
	public Optional<X> getAtPosition(int position) throws IllegalArgumentException {
		if (inBoundary(position)) {			
			return this.vector.get(position);
		}
		return Optional.empty();
	}

	@Override
	public int size() {
		return this.vector.size();
	}

	@Override
	public List<X> asList() throws NoSuchElementException{
		List<X> list = new ArrayList<>();
		for (Optional<X> opt : this.vector) {
			list.add(opt.get());
		}
		return List.copyOf(list);
	}

	public void executeOnAllElements(Executor<X> executor) {
		this.vector.stream().forEach(el -> executor.execute(el.get()));
	}

}
