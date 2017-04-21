
public class Test {
	
	public static void main(String[] args) throws Exception {
		
		BaseObject player1 = new BaseObject("Player1");
		//HealthComponent hp1 = new HealthComponent(300);
		//WeaponComponent axe = new WeaponComponent("Axe", 50);
		
		BaseObject player2 = new BaseObject("Player2");
		//HealthComponent hp2 = new HealthComponent(500);
		//WeaponComponent knife = new WeaponComponent("knife", 10);
		
		player1.addComponents(new HealthComponent(300),new WeaponComponent("Axe", 50));
		player2.addComponents(new HealthComponent(500),new WeaponComponent("knife", 10));

		//player1.removeComponent(HealthComponent.class); working
		
		//set targets
		player1.getComponent(WeaponComponent.class).setTarget(player2);
		player2.getComponent(WeaponComponent.class).setTarget(player1);
		
		System.out.println(player1);
		System.out.println(player2);
		
		//simple game loop that never ends
		while(true) {
			System.out.println();
			player1.update();
			player2.update();
			player1.print();
			player2.print();
			Thread.sleep(3000); //pause every 3 seconds
		}
	}
}