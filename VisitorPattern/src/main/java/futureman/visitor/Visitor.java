package futureman.visitor;

import futureman.visitable.concrete.Item;

public interface Visitor {

	public void visit(futureman.visitable.concrete.Package package1);
	public void visit(Item item);
}
