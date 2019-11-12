package moteurAudio;

public class myArrayList<T> {

	private T[] data;
	private int i;
	static final int arraySize = 50;
	public myArrayList() {
		data = (T[]) new Object[arraySize];		
	}
	
	public void add(T obj) {
			this.data[this.i] = obj;
	}
	
	public T get(int i) {
		return data[i];
	}
	
}
