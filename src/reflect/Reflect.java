package reflect;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;


public class Reflect {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        String[] cmdarray = new String[]{"calc.exe"};
//        ProcessBuilder pb = new ProcessBuilder(cmdarray);
//        pb.start();
//
//        String[] cmdarray = new String[]{"calc.exe"};
//        Process pb = new ProcessBuilder(cmdarray).start();
//
//       Runtime.getRuntime().exec("calc.exe");
        String[] cmdarray =  new String[]{"calc.exe"};
        Class<?> processImpl = Class.forName("java.lang.ProcessImpl");
        Method mProcessImpl = processImpl.getDeclaredMethod("start", String[].class, Map.class, String.class, ProcessBuilder.Redirect[].class, boolean.class);
        mProcessImpl.setAccessible(true);
        mProcessImpl.invoke(null,cmdarray, null, null, null, false);
    }
}
