import java.util.ArrayList;

public abstract class GeneralRoom {


	protected String name = "";
	protected boolean isVisited = false;

	protected ArrayList<String> things;	
	
	

	public ArrayList<String> getThings() {
		return things;
	}
	public void setThings(ArrayList<String> _things) {
		this.things = _things;
	}
	public String getName() {
		return name;
	}
	public void setName(String _name) {
		this.name = _name;
	}
	public boolean isVisited() {
		return isVisited;
	}
	public void setVisited(boolean _isVisited) {
		this.isVisited = _isVisited;
	}


}





