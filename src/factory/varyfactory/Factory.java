package factory.varyfactory;

import factory.phone.Phone;

public interface Factory {

    Phone take(String string);

}
