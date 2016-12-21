import java.lang.reflect.*;
import java.util.Arrays;

/**
 * Created by Tridev on 21-12-2016.
 */
public class TestRelection {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException {

        Class reflectionClass = UFOEnemyShip.class;
        Object objectFromReflection = null;
        Constructor constructor = null;
        UFOEnemyShip ufoEnemyShip = null;
        EnemyShip enemyShip = null;
        Method getPrivateMethod = null;
        String className = reflectionClass.getName();
        Class[] usedInterfaces = reflectionClass.getInterfaces(); // Get all Interfaces used by the UFOEnemyShip Class (ReflectClass)
        int classModifier = reflectionClass.getModifiers(); // Get Modifier Values of the UFOEnemyShip Class (ReflectClass)
        Class superClass = reflectionClass.getSuperclass();
        Method[] methods = reflectionClass.getMethods();    // List all Methods
        //Other Available Methods: isAbstract();, isInterface();,isFinal();, isPrivate();, isStatic();, isStrict();, isSynchronized();.


        try {
            constructor = reflectionClass.getConstructor(new Class[]{EnemyShip.class});
//            objectFromReflection = reflectionClass.getConstructor(int.class, String.class).newInstance(12,"New Object From Reflection");
        } catch (NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }

        Class[] parameterTypes = constructor.getParameterTypes();
        System.out.println("Class Name : " + className);
        System.out.println(Modifier.isPublic(classModifier));
        System.out.println(Arrays.toString(usedInterfaces));
        System.out.println("SuperClass : " + superClass.getCanonicalName());
        System.out.println("Methods : " + Arrays.toString(methods));

        System.out.println("Parameter Types from Constructor :" + Arrays.toString(parameterTypes)); // Prints Array in Form of []
        //OR
        for (Class parameters : parameterTypes) {
            System.out.println(parameters.getName());
        }

        enemyShip = new EnemyShip();
        ufoEnemyShip = (UFOEnemyShip) constructor.newInstance(enemyShip);

        ufoEnemyShip.methodOne();
        ufoEnemyShip.methodTwo();
        ufoEnemyShip.setPirateName("Tridev THE great Pirate");
        ufoEnemyShip.getPrivateStringInt("Tridev", 21);
        System.out.println("Pirate for Ship :" + ufoEnemyShip.getPirateName());


        //Access Private Values - The Real Power of Java Reflection APIs Goes here:

        Field privateStringField = null;
        String localIdCode = "idCode";
        UFOEnemyShip ufoEnemyShip1 = new UFOEnemyShip(enemyShip);
        try {
            privateStringField = UFOEnemyShip.class.getDeclaredField(localIdCode);
            privateStringField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


        String valueOfName = (String) privateStringField.get(ufoEnemyShip1);
        System.out.println("Private Field: " + valueOfName);       //Private Field Accessed


        String privateMethod = "getPrivateString";
        try {
            getPrivateMethod = UFOEnemyShip.class.getDeclaredMethod(privateMethod);
            getPrivateMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        String privateReturnValue = (String) getPrivateMethod.invoke(ufoEnemyShip1);
        System.out.println("Accessed PrivateMethod Return Value :" + privateReturnValue); // Private Method Invoked


    }
}
