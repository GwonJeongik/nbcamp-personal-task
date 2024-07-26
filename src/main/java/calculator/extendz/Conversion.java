package calculator.extendz;

public class Conversion {

    public static <T extends Number> T conversion(Number result, Class<T> genericType) {
        if (genericType == Short.class) {
            return (T) Short.valueOf(result.shortValue());

        } else if (genericType == Byte.class) {
            return (T) Byte.valueOf(result.byteValue());

        } else if (genericType == Integer.class) {
            return (T) Integer.valueOf(result.intValue());

        } else if (genericType == Long.class) {
            return (T) Long.valueOf(result.longValue());

        } else if (genericType == Float.class) {
            return (T) Float.valueOf(result.floatValue());

        } else if (genericType == Double.class) {
            return (T) Double.valueOf(result.doubleValue());

        } else {
            throw new RuntimeException("error");
        }
    }
}
