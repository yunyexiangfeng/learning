# Lambda

表示匿名函数或者闭包的运算符

为什么需要lambda表达式：

在Java中，无法将函数作为参数传递给一个方法，也无法声明一个返回函数的方法



### 1.语法

(parameters) -> expression
或
(parameters) ->{ statements; }



###2.特性

- 可选类型声明：不需要声明参数类型，编译器可以统一识别参数值
- 可选的参数圆括号：一个参数可以无需圆括号，但多个参数需要定义圆括号
- 可选的大括号：如果主体包含了一个语句，就不需要使用大括号
- 可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回返回值，大括号需要指定表达式返回了一个数值
- 主要用来定义行内执行的方法类型接口
- 免去了使用匿名方法的麻烦







# 函数式接口



Functional Interface：

- 有且仅有一个抽象方法，且该方法不可override java.lang.Object类的public方法
- 使用@FunctionalInterface注解申明函数式接口，告诉编译器在编译期检查函数式接口的合法性

函数式接口可以被隐式转换为Lambda表达式，Java8之前使用匿名函数实现，之后用lambda表达式实现

由引用传递到==行为传递==的转变

###Java8中核心函数式接口

####1. Function功能接口

提供功能转换

```java
/**
 * Represents a function that accepts one argument and produces a result.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #apply(Object)}.
 *
 * @param <T> the type of the input to the function
 * @param <R> the type of the result of the function
 *
 * @since 1.8
 */
@FunctionalInterface
public interface Function<T, R> {

    /**
     * Applies this function to the given argument.
     * 将给定的T类型转换成R类型返回
     * @param t the function argument
     * @return the function result
     */
    R apply(T t);

    /**
     * Returns a composed function that first applies the {@code before}
     * function to its input, and then applies this function to the result.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param <V> the type of input to the {@code before} function, and to the
     *           composed function
     * @param before the function to apply before this function is applied
     * @return a composed function that first applies the {@code before}
     * function and then applies this function
     * @throws NullPointerException if before is null
     *
     * @see #andThen(Function)
     */
    default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }

    /**
     * Returns a composed function that first applies this function to
     * its input, and then applies the {@code after} function to the result.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param <V> the type of output of the {@code after} function, and of the
     *           composed function
     * @param after the function to apply after this function is applied
     * @return a composed function that first applies this function and then
     * applies the {@code after} function
     * @throws NullPointerException if after is null
     *
     * @see #compose(Function)
     */
    default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }

    /**
     * Returns a function that always returns its input argument.
     *
     * @param <T> the type of the input and output objects to the function
     * @return a function that always returns its input argument
     */
    static <T> Function<T, T> identity() {
        return t -> t;
    }
}
```







####2. Consumer消费接口

```java
/**
 * Represents an operation that accepts a single input argument and returns no
 * result. Unlike most other functional interfaces, {@code Consumer} is expected
 * to operate via side-effects.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #accept(Object)}.
 *
 * @param <T> the type of the input to the operation
 *
 * @since 1.8
 */
@FunctionalInterface
public interface Consumer<T> {

    /**
     * Performs this operation on the given argument.
     *
     * @param t the input argument
     */
    void accept(T t);

    /**
     * Returns a composed {@code Consumer} that performs, in sequence, this
     * operation followed by the {@code after} operation. If performing either
     * operation throws an exception, it is relayed to the caller of the
     * composed operation.  If performing this operation throws an exception,
     * the {@code after} operation will not be performed.
     *
     * @param after the operation to perform after this operation
     * @return a composed {@code Consumer} that performs in sequence this
     * operation followed by the {@code after} operation
     * @throws NullPointerException if {@code after} is null
     */
    //重复使用consumer中数据，实现二次消费
    default Consumer<T> andThen(Consumer<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> { accept(t); after.accept(t); };
    }
}
```



- void accept(T t)：接受数据
- Consumer<T> andThen(Consumer<? super T> after)：重复接受数据





示例：

```java
@Test
public void testConsumerInterface(){
    //1.实现accept方法
    //定义consumer
    Consumer consumer = new Consumer() {
        @Override
        public void accept(Object o) {
            System.out.println(o);
        }
    };
    //定义流
    Stream stream = Stream.of("abc", "", "bc", "efg", "abcd","", "jkl");
    //使用consumer
    stream.forEach(consumer);

    //2.lambda表达式返回
    //使用lambda返回consumer
    consumer =  (s) -> System.out.println(s);
    stream = Stream.of("abc", "bc", "efg", "abcd","jkl");
    stream.forEach(consumer);

    //3.方法引用
    //使用方法引用返回consumer
    consumer = System.out::println;
}
```







####3. Supplier生产接口

```java
/**
 * Represents a supplier of results.
 *
 * <p>There is no requirement that a new or distinct result be returned each
 * time the supplier is invoked.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #get()}.
 *
 * @param <T> the type of results supplied by this supplier
 *
 * @since 1.8
 */
@FunctionalInterface
public interface Supplier<T> {

    /**
     * Gets a result.
     * @return a result
     */
    T get();
}
```









####4. Predicate断言接口



####5. Operator操作接口





| 序号 | 接口 & 描述                                                  |
| :--- | :----------------------------------------------------------- |
| 1    | **BiConsumer**代表了一个接受两个输入参数的操作，并且不返回任何结果 |
| 2    | **BiFunction**代表了一个接受两个输入参数的方法，并且返回一个结果 |
| 3    | **BinaryOperator**代表了一个作用于于两个同类型操作符的操作，并且返回了操作符同类型的结果 |
| 4    | **BiPredicate**代表了一个两个参数的boolean值方法             |
| 5    | **BooleanSupplier**代表了boolean值结果的提供方               |
| 6    | **Consumer**代表了接受一个输入参数并且无返回的操作           |
| 7    | **DoubleBinaryOperator**代表了作用于两个double值操作符的操作，并且返回了一个double值的结果。 |
| 8    | **DoubleConsumer**代表一个接受double值参数的操作，并且不返回结果。 |
| 9    | **DoubleFunction**代表接受一个double值参数的方法，并且返回结果 |
| 10   | **DoublePredicate**代表一个拥有double值参数的boolean值方法   |
| 11   | **DoubleSupplier**代表一个double值结构的提供方               |
| 12   | **DoubleToIntFunction**接受一个double类型输入，返回一个int类型结果。 |
| 13   | **DoubleToLongFunction**接受一个double类型输入，返回一个long类型结果 |
| 14   | **DoubleUnaryOperator**接受一个参数同为类型double,返回值类型也为double 。 |
| 15   | **Function**接受一个输入参数，返回一个结果。                 |
| 16   | **IntBinaryOperator**接受两个参数同为类型int,返回值类型也为int 。 |
| 17   | **IntConsumer**接受一个int类型的输入参数，无返回值 。        |
| 18   | **IntFunction**接受一个int类型输入参数，返回一个结果 。      |
| 19   | **IntPredicate**：接受一个int输入参数，返回一个布尔值的结果。 |
| 20   | **IntSupplier**无参数，返回一个int类型结果。                 |
| 21   | **IntToDoubleFunction**接受一个int类型输入，返回一个double类型结果 。 |
| 22   | **IntToLongFunction**接受一个int类型输入，返回一个long类型结果。 |
| 23   | **IntUnaryOperator**接受一个参数同为类型int,返回值类型也为int 。 |
| 24   | **LongBinaryOperator**接受两个参数同为类型long,返回值类型也为long。 |
| 25   | **LongConsumer**接受一个long类型的输入参数，无返回值。       |
| 26   | **LongFunction**接受一个long类型输入参数，返回一个结果。     |
| 27   | **LongPredicate**R接受一个long输入参数，返回一个布尔值类型结果。 |
| 28   | **LongSupplier**无参数，返回一个结果long类型的值。           |
| 29   | **LongToDoubleFunction**接受一个long类型输入，返回一个double类型结果。 |
| 30   | **LongToIntFunction**接受一个long类型输入，返回一个int类型结果。 |
| 31   | **LongUnaryOperator**接受一个参数同为类型long,返回值类型也为long。 |
| 32   | **ObjDoubleConsumer**接受一个object类型和一个double类型的输入参数，无返回值。 |
| 33   | **ObjIntConsumer**接受一个object类型和一个int类型的输入参数，无返回值。 |
| 34   | **ObjLongConsumer**接受一个object类型和一个long类型的输入参数，无返回值。 |
| 35   | **Predicate**接受一个输入参数，返回一个布尔值结果。          |
| 36   | **Supplier**无参数，返回一个结果。                           |
| 37   | **ToDoubleBiFunction**接受两个输入参数，返回一个double类型结果 |
| 38   | **ToDoubleFunction**接受一个输入参数，返回一个double类型结果 |
| 39   | **ToIntBiFunction**接受两个输入参数，返回一个int类型结果。   |
| 40   | **ToIntFunction**接受一个输入参数，返回一个int类型结果。     |
| 41   | **ToLongBiFunction**接受两个输入参数，返回一个long类型结果。 |
| 42   | **ToLongFunction**接受一个输入参数，返回一个long类型结果。   |
| 43   | **UnaryOperator**接受一个参数为类型T,返回值类型也为T。       |





# 默认方法

###1.default method

接口可以有实现方法，而且不需要实现类实现其方法。在方法前加"default"关键字。==解决接口的修改与现有的实现不兼容问题==。

示例：

```java
public interface Vehicle {
   default void print(){
      System.out.println("我是一辆车!");
   }
}
 
public interface FourWheeler {
   default void print(){
      System.out.println("我是一辆四轮车!");
   }
}

//方式一：创建自己的默认方法，重写接口的默认方法
public class Car implements Vehicle, FourWheeler {
   default void print(){
      System.out.println("我是一辆四轮汽车!");
   }
}
//方式二：使用super调用指定的接口的默认方法
public class Car implements Vehicle, FourWheeler {
   public void print(){
      Vehicle.super.print();
   }
}
```



###2.static default method

示例：

```java
public interface Vehicle {
   default void print(){
      System.out.println("我是一辆车!");
   }
    // 静态方法
   static void blowHorn(){
      System.out.println("按喇叭!!!");
   }
}
```





# Stream

Stream是java8中新提供给开发者一组操作集合的API，将要处理的元素看作一种流，流在管道中传输，并可以在管道的节点上进行处理，比如排序、筛选、聚合等。

以声明的方式处理数据

基础特征：

- **Pipelining**: 中间操作都会返回流对象本身。 这样多个操作可以串联成一个管道。 这样做可以对操作进行优化， 比如延迟执行(laziness)和短路( short-circuiting)。
- **内部迭代**： 以前对集合遍历都是通过Iterator或者For-Each的方式, 显式的在集合外部进行迭代， 这叫做外部迭代。 Stream提供了内部迭代的方式， 通过访问者模式(Visitor)实现。

操作类型：

###中间操作

将流一层层处理，并向下一层传递。比如sorted, filter, map, flatmap等

中间操作分为两种状态：stateful和stateless，及有状态和无状态

- stateful：必须等上一步操作完拿到全部元素后才可操作，如sorted
- stateless：该操作的数据不收上一步操作的影响，如filter map

###终止操作

触发数据流动，并收集结果。比如forEach，collect等

终止操作分为短路操作（short-circuiting）和非短路操作（none-short-circuiting）

- short-circuiting：会在适当时刻终止遍历
- none-short-circuiting：会遍历所有元素

类图：

![./images/Java8 Stream.png](./images/Java8 Stream.png)

###Stream继承关系

![Stream Extends](./images/Stream Extends.png)



Stream中使用Stage的概念描述一个完整的操作，并用某种实例化后的Pipeline来代表Stage，将各种Pipeline按照先后顺序连接到一起，形成流水线

Head为ReferencePipeline的内部类，表示第一个Stage，不包含任何操作，StatelessOp和StatefulOp分别为无状态操作和有状态的Stage。



![Stream Stage](./images/Stream Stage.png)

使用Collection.stream、Arrays.stream或Stream.of等接口会生成Head，其内部均采用StreamSupport.stream方法，将原始数据包装为Spliterator存放在Stage中

- Head记录Stream起始操作，将包装为Spliterator的原始数据存放在Stage中
- StatelessOp记录无状态的中间操作
- StatefulOp记录有状态的中间操作
- TerminalOp用于触发数据数据在各Stage间的流动及处理，并收集最终数据







###1.使用集合(Collection)生成Stream

- **stream()** − 为集合创建串行流。
- **parallelStream()** − 为集合创建并行流。

示例：

```java
List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
Stream<String> stream = strings.stream().sorted().filter(c -> c.startsWith("ab"));
stream.forEach(s -> {
    System.out.println(s);
});
Stream<String> parallelSteam = strings.parallelStream().sorted();
parallelSteam.forEach(s -> {
    System.out.println(s);
});
```



###2.使用IO/NIO生成Stream

- **lines()** − 为BufferReader创建串行流。





### 3.使用生产器Generator生成Stream





### 4.使用数组(Arrays)产生Stream

- **stream(T[] array)** − 为集合创建Stream。
- **stream(T[] array, int startInclusive, int endExclusive)** − 为集合创建Stream。
- **IntStream stream(int[] array)** − 为数组创建IntStream 
- **LongStream stream(long[] array)** − 为数组创建LongStream 
- **DoubleStream stream(double[] array)** − 为数组创建DoubleStream 





###5.使用聚合操作产生Stream

 比如filter, map, reduce, find, match, sorted等。

示例：

```java
List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
Stream<String> stream = strings.stream().sorted().filter(c -> c.startsWith("ab"));
```

