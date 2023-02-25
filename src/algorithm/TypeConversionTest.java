package algorithm;

// 형변환 테스트
public class TypeConversionTest {

    // String -> 숫자형 (int, double, float, long, short)
    String str = "1234";
    int i1 = Integer.parseInt(str);
    int i2 = Integer.valueOf(str);
    double d1 = Double.parseDouble(str);
    double d2 = Double.valueOf(str);
    float f1 = Float.parseFloat(str);
    float f2 = Float.valueOf(str);
    long l1 = Long.parseLong(str);
    long l2 = Long.valueOf(str);
    short s1 = Short.parseShort(str);
    short s2 = Short.valueOf(str);

    // 숫자형 (int, double, float, long, short) -> String
    int i = 1234;
    String ii1 = String.valueOf(i);
    String ii2 = Integer.toString(i);
    double d = 1.23;
    String dd1 = String.valueOf(d);
    String dd2 = Double.toString(d);
    float f = (float) 1.23;
    String ff1 = String.valueOf(f);
    String ff2 = Float.toString(f);
    long l = 1234;
    String ll1 = String.valueOf(l);
    String ll2 = Long.toString(l);
    short s = 1234;
    String ss1 = String.valueOf(s);
    String ss2 = Short.toString(s);
}
