
public class WeaponComponent extends BaseComponent {
	
	private int damage;
	private BaseObject target;
	private String weaponName;
	
	public WeaponComponent(String weaponName,int damage) {
		this.weaponName = weaponName;
		this.damage = damage;
	}
	
	@Override
	public void print() {
		System.out.println(toString());
	}
	
	public void setTarget(BaseObject target) {
		this.target = target;
	}
	
	private void attack(BaseObject object) {
		HealthComponent playerComp = getComponent(HealthComponent.class);
		if (playerComp != null) {
			if (playerComp.getHealth() == 0) return; //cannot attack id dead
		}
		
		HealthComponent enemyComp = object.getComponent(HealthComponent.class);
		if (enemyComp != null) {
			if (enemyComp.getHealth() == 0) return; //do not attack if enemy target is dead already
			enemyComp.damage(damage);
			System.out.println(this.object.name + " attacked " + object.name + " and received " + damage + " damaged");
		}
		
	}
	
	public void update() {
		if (target == null) return;
		attack(target); //attack the target every time the update method is called
	}
	
	@Override
	public String toString() {
		return "Weapon: " + weaponName + ", Damage: " + damage;
	}
}