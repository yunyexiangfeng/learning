# String StringBuffer StringBuilder

### 面试题

1.java中操作字符串都有哪些类？及区别

2.String StringBuffer StringBuilder之前的区别

String：声明不可变对象，每次操作都会生成新的String对象，然后将指针指向新的String对象

StringBuffer/StringBuilder：声明可变字符串，可以在原有对象的基础上进行操作，不会产生新的对象。



String与StringBuffer/StringBuilder的区别在于对象是否可变。

StringBuffer与StringBuilder区别在于是否线程安全。



### String 数据结构



```java
/** The value is used for character storage. */
private final char value[];

/** Cache the hash code for the string */
private int hash; // Default to 0
```

使用final修饰的char数组，不可变



### StringBuffer数据结构

StringBuffer继承自AbstractStringBuilder

AbstractStringBuilder：

```java
/**
* The value is used for character storage.
*/
char[] value;

/**
* The count is the number of characters used.
*/
int count;
```

char数组，没有final修饰，故而可变。

StringBuffer方法使用重锁synchronized修饰，线程安全：

```java
//StringBuffer的append方法
@Override
public synchronized StringBuffer append(int i) {
	toStringCache = null;
	super.append(i);
	return this;
}
```



###StringBuilder数据结构

StringBuilder同样继承自AbstractStringBuilder

StringBuilder方法没有枷锁，线程不安全，单效率相对StringBuffer更高。





###StringBuffer与StringBuilder区别



StringBuffer与StringBuilder都继承AbstractStringBuilder类，有相同的数据结构，所包含的方法基本相同。

不同的是StringBuffer类包含一个不可持久化的cache数组：

```Java
/**
* A cache of the last value returned by toString. Cleared
* whenever the StringBuffer is modified.
*/
private transient char[] toStringCache;
```

在StringBuffertoString()方法中，会将char[] value数组copy到这个数组中，new一个String对象返回：

```java
@Override
public synchronized String toString() {
    if (toStringCache == null) {
        toStringCache = Arrays.copyOfRange(value, 0, count);
    }
    return new String(toStringCache, true);
}
```

每次对StringBuffer进行修改，即对char[] value修改时，都会清空该缓存数组：

```java
/**
 * @throws IndexOutOfBoundsException {@inheritDoc}
 * @see        #length()
 */
@Override
public synchronized void setCharAt(int index, char ch) {
    if ((index < 0) || (index >= count))
        throw new StringIndexOutOfBoundsException(index);
    toStringCache = null;
    value[index] = ch;
}
```



为什么toString的时候需要使用这样一个缓存数组呢？

答案就是缓存最后一次toString的内容，如果StringBuffer不产生修改，下一次toString的时候可以减少进行一次数组复制。

