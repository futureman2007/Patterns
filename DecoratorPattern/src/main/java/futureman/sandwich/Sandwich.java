package futureman.sandwich;
// ein "Sandwich" bezeichnet zwei scheiben Brot mit Beilage.
// --> HawaiSandwich = ein Sandwich mit HawaiToast
// --> dieses Kann nun beliebig belegt werden (mit käse, fleisch, gemüse UND auch ggf. weiterem Brot!)
public interface Sandwich {

	public String topping();
	public double getCost();

}
