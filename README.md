# 试验dubbo

泛化实现  
实现接口```GenericService```，仅包含一个方法```Object $invoke(String method, String[] parameterTypes, Object[] args)```  
其最大的问题，方法仅有一个名字，信息太少  

另一个方法，要暴露的泛化实现，一定明确接口，有接口+方法名+参数类型，可拿到```Method```类  
再但是，这意味着有多少个泛化实现类，相比，JDK动态代理的方案中，```InvocationHandler```只有一个

于是转而考虑JDK动态代理，```invoke```函数中可拿到```Method```类，进而可得到所有信息

## 发现一个有意思的现象
dubbo泛化```$invoke(...)```接口的```args```参数，当简单类型时，是类型本身；但是当复杂类型时，成了```Map```  
在测试类，调用了4次，{jdk, dubbo泛化}笛卡尔积{String参数, 复杂参数}，日志如下：
```
MyInvocationHandler   : 收到请求，方法：public abstract java.lang.String org.dracula.test.dubbo.generic.TestInterface.sayHello(java.lang.String)
MyInvocationHandler   : 参数：gxk
MyInvocationHandler   : 收到请求，方法：public abstract org.dracula.test.dubbo.generic.TestParam org.dracula.test.dubbo.generic.TestInterface.sayHello(org.dracula.test.dubbo.generic.TestParam)
MyInvocationHandler   : 参数：org.dracula.test.dubbo.generic.TestParam@1f829875
MyGenericImpl   : 收到请求，方法：sayHello
MyGenericImpl   : 参数类型：java.lang.String
MyGenericImpl   : 参数：gxk
MyGenericImpl   : 收到请求，方法：sayHello
MyGenericImpl   : 参数类型：org.dracula.test.dubbo.generic.TestParam
MyGenericImpl   : 参数：{text=gxk, class=org.dracula.test.dubbo.generic.TestParam}
```