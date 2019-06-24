package futureman.interfacetest;

public interface Visitor {

	public void visit(Dummy d);

	void visit(InherritedDUmmy d);
}
