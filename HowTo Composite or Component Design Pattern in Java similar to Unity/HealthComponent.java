
public class HealthComponent extends BaseComponent {
	
	private int maxHealth;
	private int currentHealth;
	
	public HealthComponent(int maxHealth) {
		this.currentHealth = this.maxHealth = maxHealth;
	}
	
	@Override
	protected void print() {
		System.out.println(toString());
	}
	
	public void damage(int damage) {
		currentHealth -= damage;
		if (currentHealth < 0) currentHealth = 0;
	}
	
	public int getHealth() {
		return currentHealth;
	}
	
	@Override
	public String toString() {
		return "Health: " + currentHealth;
	}
}