package org.dracula.test.dubbo.generic;

/**
 * @author dk
 */
public interface TestInterface {

    /**
     *
     * @param name
     * @return
     */
    String sayHello(String name);

    /**
     *
     * @param testParam
     * @return
     */
    TestParam sayHello(TestParam testParam);

}
