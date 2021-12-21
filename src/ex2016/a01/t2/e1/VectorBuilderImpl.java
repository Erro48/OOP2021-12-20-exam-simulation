package ex2016.a01.t2.e1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class VectorBuilderImpl<X> implements VectorBuilder<X> {
	
	private Optional<Vector<X>> vector;
	private final List<X> list;
	
	public VectorBuilderImpl() {
		this.vector = Optional.empty();
		this.list = new ArrayList<>();
	}

	@Override
	public void addElement(X x) {
		this.list.add(x);
	}

	@Override
	public void removeElement(int position) {
		this.list.remove(position);
	}

	@Override
	public void reverse() {
		Collections.reverse(this.list);
		
	}

	@Override
	public void clear() {
		int listLength = this.list.size();
		for (int i = 0; i < listLength; i++) {			
			removeElement(0);
		}
	}

	@Override
	public Optional<Vector<X>> build() {
		if (this.vector.isEmpty()) {
			this.vector = Optional.of(new VectorImpl<X>(this.list));
			return this.vector;
		}
		return Optional.empty();
	}

	@Override
	public Optional<Vector<X>> buildWithFilter(Filter<X> filter) {
		for (X el : this.list) {
			if (!filter.check(el)) {
				return Optional.empty();
			}
		}
		return build();
	}

	@Override
	public <Y> VectorBuilder<Y> mapToNewBuilder(Mapper<X, Y> mapper) {
		VectorBuilder<Y> vb = new VectorBuilderImpl<>();
		this.list.stream().map(el -> mapper.transform(el)).forEach(el -> vb.addElement(el));
		return vb;
	}

}
