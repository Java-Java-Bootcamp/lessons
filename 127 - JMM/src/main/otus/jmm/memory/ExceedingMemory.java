package main.otus.jmm.memory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ExceedingMemory {

    public static void main(String[] args) throws IOException {
//        exceedStackMemory();
//        exceedHeapMemory();
        exceedOffHeap(); //
    }

//    private static void exceedStackMemory() {
//        while (true) {
//            exceedStackMemory();
//        }
//    }

    private static void exceedHeapMemory() {
        List<double[]> arrays = new ArrayList<>();
        while (true) {
            double[] data = new double[1_000_000];
            arrays.add(data);
        }
    }

    private static void exceedOffHeap() throws IOException {
        MyClassLoader myClassLoader = new MyClassLoader();
        byte[] compiledClassBytes = Files.readAllBytes(Paths.get("C:\\Users\\icju\\Projects\\lessons\\115-reflection-annotations\\annotationprocessor\\ExceedMemory.class"));


        for (int i = 0; i < 10_000; i++) {
            String newClassName = String.format("%08d", i) + "Bean";
            byte[] bytes = (new String(compiledClassBytes, "latin1")).replaceAll("ExceedMemory", newClassName).getBytes("latin1");
            myClassLoader._defineClass(newClassName, bytes);
        }
    }

    private static class MyClassLoader extends ClassLoader {
        public MyClassLoader() {
            super();
        }

        public Class<?> _defineClass(String name, byte[] bytesCodes) {
            return super.defineClass(name, bytesCodes, 0, bytesCodes.length);
        }
    }


}
