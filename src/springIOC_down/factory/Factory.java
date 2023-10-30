package springIOC_down.factory;

import java.util.HashMap;
import java.util.Map;

public class Factory {

    static Map<String, Object> beanMap = new HashMap<>();

    public static Object getBeanMap(String beanId) {
        return beanMap.get(beanId);
    }

    public static void setBeanMap(Map<String, Object> beanMap) {
        Factory.beanMap = beanMap;
    }
    public static Map<String, Object> getBean() {
        return beanMap;
    }
}



