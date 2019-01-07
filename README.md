# 试验dubbo

泛化实现  
实现接口```GenericService```，仅包含一个方法```Object $invoke(String method, String[] parameterTypes, Object[] args)```  
其最大的问题，方法仅有一个名字，信息太少  

另一个方法，要暴露的泛化实现，一定明确接口，有接口+方法名+参数类型，可拿到```Method```类  
再但是，这意味着有多少个泛化实现类，相比，JDK动态代理的方案中，```InvocationHandler```只有一个

于是转而考虑JDK动态代理，```invoke```函数中可拿到```Method```类，进而可得到所有信息