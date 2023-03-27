package Singleton;

public class Singleton {
    private Singleton(){

    }
    public Singleton getSingleton(){
        return SingletonInnerClass.singleton;
    }
    // inner class are  loaded only once and when referred thus this ensures lazy loading and only a single instance of Singleton class
    public static class SingletonInnerClass{
        private static Singleton singleton = new Singleton();
    }
}
