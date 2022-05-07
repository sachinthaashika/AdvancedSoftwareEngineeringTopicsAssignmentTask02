
public class Location extends SpacePlace {
  public int c;
  public int r;
  public DIRECTION d;
  

  public Location(int r, int c) {
    this.r = r;
    this.c = c;
  }

  public Location(int r, int c, DIRECTION d) {    
    this(r,c);
    this.d=d;
  }
  
  public String toString() {
	    if(d==null){
	      return new StringBuilder().append("(").append(c+1).append(",")
	    		  .append(r+1).append(")").toString();
	    } else {
	      return new StringBuilder().append("(").append(c+1).append(",")
	    		  .append(r+1).append(",").append(d).append(")").toString();
    }
  }
  
  public enum DIRECTION {VERTICAL, HORIZONTAL};
}

