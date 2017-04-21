
public abstract class BaseComponent {
	
	public final String CLASS_NAME;
	
	protected BaseObject object;
	
	public BaseComponent() {
		CLASS_NAME = getClass().getName();
	}
	
	public void setObject(BaseObject object) {
		this.object = object;
	}
	
	protected void print() {
	}
	
	protected void update() {
	}
	
	public <T> T getComponent(Class<T> c) {
		return object.getComponent(c);
	}
	
	@Override
	public String toString() {
		return "Component: " + CLASS_NAME;
	}
}