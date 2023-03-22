package com.dangdang.object;

import org.openjdk.jol.info.ClassLayout;

/**
 * @program: z-admin
 * @description: 验证对象大小例子
 * @author: wanglx077
 * @create: 2022-06-06 11:36
 */
public class ObjSizeTest {

    public static void main(String[] args) {
        ClassLayout classLayout = ClassLayout.parseInstance(new ObjB());
        System.out.println(classLayout.toPrintable());
    }


}

class ObjA{

}

class ObjB{
    private int i;

    private double d;

    private Integer io;
}
