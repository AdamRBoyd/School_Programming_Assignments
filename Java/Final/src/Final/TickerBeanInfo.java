package Final;

import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

public class TickerBeanInfo extends SimpleBeanInfo {

	Class<Ticker> beanClass = Ticker.class;

	public TickerBeanInfo() {
	}

	public PropertyDescriptor[] getPropertyDescriptors() {
		try {
			PropertyDescriptor _myXStart = new PropertyDescriptor("myXStart", beanClass, "getMyXStart", "setMyXStart");

			_myXStart.setPropertyEditorClass(ZeroToHundredEditor.class);

			PropertyDescriptor _myYStart = new PropertyDescriptor("myYStart", beanClass, "getMyYStart", "setMyYStart");

			_myYStart.setPropertyEditorClass(ZeroToHundredEditor.class);

			PropertyDescriptor _myForeColor = new PropertyDescriptor("myForeColor", beanClass, "getMyForeColor",
					"setMyForeColor");

			_myForeColor.setPropertyEditorClass(ColorEditor.class);

			PropertyDescriptor _myBackColor = new PropertyDescriptor("myBackColor", beanClass, "getMyBackColor",
					"setMyBackColor");

			_myBackColor.setPropertyEditorClass(ColorEditor.class);

			PropertyDescriptor _myMoving = new PropertyDescriptor("myMoving", beanClass, "getMyMoving", "setMyMoving");

			_myMoving.setPropertyEditorClass(TrueFalseEditor.class);

			PropertyDescriptor _myMessage = new PropertyDescriptor("myMessage", beanClass, "getMyMessage",
					"setMyMessage");

			_myMessage.setPropertyEditorClass(StringEditor.class);

			PropertyDescriptor[] pds = new PropertyDescriptor[] { _myXStart, _myYStart, _myForeColor, _myBackColor,
					_myMoving, _myMessage };
			return pds;
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

}
