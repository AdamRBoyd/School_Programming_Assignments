package asModel;

public class MyPropertyChangeEvent {
    
	String propertyName;
    int oldValue;
    int newValue;

    public MyPropertyChangeEvent (String pn, int ov, int nv ){
       propertyName = pn;
       oldValue = ov;
       newValue = nv;
    }

    public String getPropertyName ( ){
       return propertyName;
    }

    public Object getOldValue (){
       return oldValue;
    }

    public Object getNewValue (){
       return newValue;
    }
}
