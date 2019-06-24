package futureman.visitable;

import futureman.visitor.*;

public interface Visitable {

	public void accept(Visitor vis);
}
