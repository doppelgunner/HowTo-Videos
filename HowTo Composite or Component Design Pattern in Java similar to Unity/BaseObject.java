import java.util.*;

public class BaseObject {
	
	public String name;
	
	private ArrayList<BaseComponent> components;
	
	public BaseObject() {
		this("Empty Object");
	}
	
	public BaseObject(String name) {
		this.name = name;
		components = new ArrayList<>();
	}
	
	public void print() {
		System.out.println("\n---" + name + "---");
		for (int i = 0; i < components.size(); i++) {
			BaseComponent comp = components.get(i);
			comp.print();
		}
	}
	
	public void update() {
		for (int i = 0; i < components.size(); i++) {
			BaseComponent comp = components.get(i);
			comp.update();
		}
	}
	
	public void addComponent(BaseComponent component) {
		addComponents(component);
	}
	
	public void addComponents(BaseComponent ... components) {
		for (int i = 0; i < components.length; i++) {
			BaseComponent comp = components[i];
			this.components.add(comp);
			comp.setObject(this);
		}
	}
	
	public <T> T getComponent(Class<T> c) {
		for (int i = 0; i < components.size(); i++) {
			BaseComponent comp = components.get(i);
			if (Util.areSame(comp.getClass(),c)) {
				return c.cast(comp);
			}
		}
		
		return null; //returns null if not exist
	}
	
	public boolean removeComponent(Class c) {
		for (int i = 0; i < components.size(); i++) {
			BaseComponent comp = components.get(i);
			if (Util.areSame(comp.getClass(),c)) {
				components.remove(i);
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		String compStrings = "";
		for (int i = 0; i < components.size(); i++) {
			compStrings += "\t" + components.get(i).toString() + "\n";
		}
		return "Object: " + name + "\n" + compStrings;
	}
}