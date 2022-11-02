package skyviewer.service.flightlist.util;


//This exists to help with getting single string properties using the jpa repository interface.
//I suspect there may be a better built in way to do this, but haven´t found it yet
public interface IStringProperty {

	String getStringProperty();
}
