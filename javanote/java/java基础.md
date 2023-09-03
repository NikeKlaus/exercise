# JAVA基础



## java初识

Java最初被称为Oak，意思是橡树，后来从爪哇岛，以及咖啡豆名字由来的java，Java是由Sun 公司于1995年5月推出的Java面向对象程序设计语言和Java平台的总称。

由James Gosling研发，并在1995年正式推出。java分为三个体系：`javaSE`(java标准版)，`javaEE`(java平台企业版)，`javaME`(java平台微型版)

java的主要特性：

- 语法简单

- 纯面向对象的编程语言

- 分布式

- 健壮性

- 安全性

- 可移植性

- 体系结构中立

- 边解释边编译的高性能

- 多线程

- 动态语言。

发展的历史：

1995年5月，java语言诞生，2009年甲骨文公司收购Sun公司，2014年`javaSE` 8诞生，2018年`javaSE 11`发布

java开发环境的配置

下载JDK https://www.oracle.com/technetwork/java/javase/downloads/index.html

配置环境变量

测试JDK：java -version，javac，java

编写 `HelloWorld.java`程序

```java
public class HelloWorld{
    public static void main(String[] args){
        System.out.println("hello world");
    }
}
```

注：**String args[]** 与 **String[] args** 都可以执行，但《阿里巴巴Java开发手册》推荐使用 **String[] args**，这样可以避免歧义和误读。

## 注解和接口

Java 注解`Annotation`又称 Java 标注，是 JDK5.0 引入的一种注释机制。

Java 语言中的类、方法、变量、参数和包等都可以被标注。和 Javadoc 不同，Java 标注可以通过反射获取标注内容。在编译器生成类文件时，标注可以被嵌入到字节码中。Java 虚拟机可以保留标注内容，在运行时可以获取到标注内容 。 当然它也支持自定义 Java 标注。

作用在代码上的注解：@Override、@Deprecate、@SuppressWarnings

作用在同其他注解的注解（元注解）：@Retention：标识这个注解怎么保存，是只在代码中，还是编入class文件中，或者是在运行时可以通过反射访问

@Documented、@Target 、@Inherited

从 Java 7 开始，额外添加了 3 个注解:@Repeatable、@SafeVarargs、@FunctionalInterface：Java 8 开始支持，标识一个匿名函数或函数式接口

**注解三大主干类**

```java
package java.lang.annotation;
public interface Annotation {
    boolean equals(Object var1);
    int hashCode();
    String toString();
    Class<? extends Annotation> annotationType();
}

```

```java 
public enum RetentionPolicy {
    SOURCE,  /* Annotation信息仅存在于编译器处理期间，编译器处理完之后就没有该Annotation信息了  */

    CLASS,   /* 编译器将Annotation存储于类对应的.class文件中。默认行为  */

    RUNTIME  /* 编译器将Annotation存储于class文件中，并且可由JVM读入 */
    private RetentionPolicy() {} // 构造器私有，单例模式
}
```

```java
public enum ElementType {
    TYPE,
    FIELD,
    METHOD,
    PARAMETER,
    CONSTRUCTOR,
    LOCAL_VARIABLE,
    ANNOTATION_TYPE,
    PACKAGE,
    TYPE_PARAMETER,
    TYPE_USE,
    MODULE;

    private ElementType() {
    }
}
```

## 8 大基本数据类型

byte	1字节 [-128,127]

short   2字节

int	 4字节 [-2^31,2^31 - 1]

long    8字节

float   4字节

double  8字节

char    2字节

boolean  java没有明确的规定，不同的jvm具有不同的实现机制

**128陷阱**

byte [-128,127]

int  [2^31,2^31 - 1]也就是[2147483647,-2147483648]

```java
for (int i = 126; i < 130; i++) {
	System.out.println("i = "+ i + "此时(byte)i = "+(byte)i);
}

i = 126此时(byte)i = 126
i = 127此时(byte)i = 127
i = 128此时(byte)i = -128
i = 129此时(byte)i = -127
```

**Integer 的缓存池**

它的默认值用于缓存 -128 - 127 之间的数字，如果有 -128 - 127 之间的数字的话，使用 new Integer 不用创建对象，会直接从缓存池中取，此操作会减少堆中对象的分配，有利于提高程序的运行效率。`

```java
private static class IntegerCache {
        static final int low = -128;
        static final int high;
        static final Integer cache[];

        static {
            // high value may be configured by property
            int h = 127;
            String integerCacheHighPropValue =
                sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
            if (integerCacheHighPropValue != null) {
                try {
                    int i = parseInt(integerCacheHighPropValue);
                    i = Math.max(i, 127);
                    // Maximum array size is Integer.MAX_VALUE
                    h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
                } catch( NumberFormatException nfe) {
                    // If the property cannot be parsed into an int, ignore it.
                }
            }
            high = h;

            cache = new Integer[(high - low) + 1];
            int j = low;
            for(int k = 0; k < cache.length; k++)
                cache[k] = new Integer(j++);

            // range [-128, 127] must be interned (JLS7 5.1.7)
            assert IntegerCache.high >= 127;
        }

        private IntegerCache() {}
}
```

例如创建一个 Integer a = 24，其实是调用 Integer 的  valueOf

```java
    public static Integer valueOf(int i) {
        if (i >= IntegerCache.low && i <= IntegerCache.high)
            return IntegerCache.cache[i + (-IntegerCache.low)];
        return new Integer(i);
    }
```



**byte的取值范围是如何计算出来的？**

Java 中用`补码`来表示二进制数，补码的最高位是符号位，最高位用 0 表示正数，最高位 1 表示负数，正数的补码就是其`本身`，由于最高位是符号位，所以正数表示的就是 0111 1111 ，也就是 127。最大负数就是 1111 1111，这其中会涉及到两个 0 ，一个 +0 ，一个 -0 ，+0 归为正数，也就是 0 ，-0 归为负数，也就是 -128，所以 byte 的范围就是 -128 - 127。



**4.0-3.6=0.40000001，精度的丢失**

2进制的小数无法精确的表达10进制小数，计算机在计算10进制小数的过程中要先转换为2进制进行计算，这个过程中出现了误差。

**4.0 == 4，向上转型**

在编译的时候就会出现向上转型，变为浮点数默认的类型double，即是true

**a += b; 和 a = a + b;**

编译的角度看，`a+=b`;执行的时候效率高。

- 运算过程中，低精度的类型向高精度类型转换。

- 如果将高精度的数值赋值给低精度类型变量，则必须要进行显性的强制转换。

+=运算中，结合了强制类型转换的功能

```java
public static void main(String[] args) {
	int a = 10;
	char c = '5';
	a = a+c; // a + c 是 int型，a也是 int型的
	c = a+c;// a + c 是 int型，c也是 char 型的，需要强制类型转换，结果编译报错
	c += a; // += m默认强制类型转换
}
```

**i++、++i、i += 1、i = i + 1的区别**

i++ 先返回原来的值，在自增 1，

++i 先自增 1 ，再返回自增后的值

## IDEA新建JAVA文件

注解

```java
public @interface MyAnnotation {
}
```

枚举，枚举是一个特殊的类，默认继承了Enum类，Enum类具有一个有参构造

```java
public enum MyEnum {
}
```

类，默认继承了Object类	

```java
public class MyClass {
}
```

接口

```java
public interface MyInterface {
}
```

## LRU

PriorityQueue

优先队列:**一个基于优先级堆的无界优先级队列。**

```java
public class PriorityQueue<E> extends AbstractQueue<E> implements Serializable
// 该队列的头部是相对于指定顺序的最小元素。
//小顶堆，默认容量为11
PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
//大顶堆，容量11
PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11,new Comparator<Integer>(){ 
    @Override
    public int compare(Integer o1,Integer o2){
        return o2-o1;
    }
});
// 大顶堆 
PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((o1, o2) -> o2[1] - o1[1]);
```



**设计LRU**

题目表述

实现 LRUCache 类：

LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

```java
class LRUCache extends LinkedHashMap<Integer,Integer>{
    private int capacity;
    public LRUCache(int capacity) {
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        return super.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        super.put(key,value);
    }
    
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
        return size() > capacity;
    }
}
```

自定义维护一个hash表和双向链表

```java
class LRUCache{
    private Entry head,tail;
    private Map<Integer,Entry> cache;
    // 当前缓存存入数据的个数
    private int size;
    // 设置缓存的容量
    private int capacity;

    public static class Entry{
        private Entry pre;
        private Entry next;
        private int key;
        private int value;
        
        public Entry(){}
        public Entry(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    
    // LRU缓存容量的设置
    public LRUCache(int capacity) {
        this.capacity = capacity;
        initLinkedList();
        size = 0;
        cache = new HashMap<>(capacity+2);
    }
    
    
    public int get(int key) {
        Entry node = cache.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Entry node = cache.get(key);
        // 存在这个节点，当前节点变为热点节点，移动到链表的头部
        if(node != null){
            node.value = value;
            moveToHead(node);
            return;
        }
        // 不存在这个节点，就要加入到链表头部
        if(size == capacity){
            Entry lastNode = tail.pre;
            deleteNode(lastNode);
            cache.remove(lastNode.key);
            size--;
        }
        // 新数据加入
        Entry newNode = new Entry();
        newNode.key = key;
        newNode.value = value;
        addNode(newNode);
        cache.put(key,newNode);
        size++;
    }
    
    private void moveToHead(Entry node){
        deleteNode(node);
        addNode(node);
    }
    private void deleteNode(Entry node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }
    private void addNode(Entry node){
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }
    
    private void initLinkedList(){
        head = new Entry();
        tail = new Entry();
        
        head.next = tail;
        tail.pre = head;
    }
    
}

```



## 四大控制符区别



![img](https://images2015.cnblogs.com/blog/690292/201609/690292-20160923095944481-1758567758.png)

private：仅在本类内部

default：本类和本包

protected：本类、本包、子类

public：本类、本包、子类、外部包

## 集合

**初始化 list** 并且添加 0 元素

```java
List<Integer> res = new ArrayList<Integer>() {{ add(0); }};
```

list 泛型为 Integer 的集合转化为 int 型的数组

```java
ArrayList<Integer> list = new ArrayList<>();
int[] nums = list.stream().mapToInt(Integer::intValue).toArray();
```

lambda 表达式简化

```java
int[] nums = list.stream().mapToInt(i -> i).toArray();
```

以整形返回list集合中的最大值

```java
return Arrays.stream(balls).max().getAsInt();
```



**二维数组array**[][2]进行排序，第一个数按照降序排序，第一个数相等，按照第二个数的升序排序

```java
Arrays.sort(array,(o1,o2)->o1[0] == o2[0] ? o1[1] - o2[1] : o2[0]-o1[0]);
```



一维数组存储的是队列，队列存储的是字符

```java
Deque<Character>[] arr = new ArrayDeque[n];
queue.offer('a');
```



**新建Map对象**并且初始化实例对象

```java
 Map<String, Integer> map = new HashMap<>() {{
        put("a", 0);
        put("e", 1);
        put("i", 2);
        put("o", 3);
        put("u", 4);
    }};
```



map 泛型使用var简化操作，看起来更加的清爽

```java
var map = new HashMap<Integer, Integer>();
```

map 集合的values中的最大值

```java
var maxCnt = map.values().stream().max(Integer::compare).get();
```

获取map中values最大值对应的key，values相同的话选取较小的key

```java
map.entrySet().stream().filter(e->Objects.equals(e.getValue(),maxCnt)).min(Map.Entry.comparingByKey()).get().getKey();
```

**HashMap的长度为什么是 2 的幂次方？**

因为HashMap的长度是2的幂次方，所以 length%hash == (n - 1) & hash，采用余数来判断桶中的下标。要是HashMap的长度不是2的幂次方，就会加大数组中指针碰撞的几率。

**LinkedHashMap**

哈希表和链表实现的Map接口，具有可预测的迭代次序

```java
public class LinkedHashMap<K, V> extends HashMap<K, V> implements Map<K, V> 

public LinkedHashMap(int initialCapacity,
                     float loadFactor,
                     boolean accessOrder)
// initialCapacity - 初始容量
// loadFactor - 负载因子
// accessOrder - 订购模式 - true的访问顺序， false的插入顺序
```



构造一个空的 LinkedHashMap实例，具有指定的初始容量，负载因子和排序模式。

用于实现 LRU 最近最少使用的缓存机制，如果此地图应删除其最老的条目，则返回 true 。

```java
protected boolean removeEldestEntry(Map.Entry<K,V> eldest)
```

HashMap 的 putIfAbsent()，方法会先判断指定的键 key 是否存在，不存在则将键值对插入到 HashMap 中。如果所指定的 key 不在 HashMap 中存在，则返回 null

注意，如果指定 key 之前已经和一个 null 值相关联了 ，则该方法也返回 null，因为 HashMap 的 key 允许有且仅有一个为 null

```java
map.putIfAbsent(key,value) 
```

集合的foreach遍历输出，在System类中有一个PrintStream对象out，输出流对象调用 print 方法进行打印

```java
list.forEach(System.out::println);
```

**数组 Array 转 ArrayList** 

出现问题：java.lang.UnsupportedOperationException

```java
List<Integer> listBug = Arrays.asList(1, 2, 3);
listBug.add(3);
System.out.println(listBug);
```

原因是因为在 Array 内部存在着一个内部类，这个内部类是被阉割过的，只有 set、get、contains 等方法，但是没有能够像是 add 这种能够使其内部结构进行改变的方法，因此Arrays 内部的 ArrayList 的大小是固定的。

```java
private static class ArrayList<E>
    {
        private static final long serialVersionUID = -2764017481108945198L;
        private final E[] a;

        ArrayList(E[] array) {
            a = Objects.requireNonNull(array);
        }
}
```

将数组 Array 转化为真正的 ArrayList 

```java
ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(arr));
```

**List 中循环删除元素**

```java
ArrayList<String> removeList = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
for (int i = 0; i < removeList.size(); i++) {
    removeList.remove(i);
}
System.out.println(removeList);
```

已经将 Array 转化为真正的 ArrayList ，删除元素时候存在，不能全部删除元素问题，原因是因为 List 是动态扩容的，删除的第 i 个元素后 i 增加了，但是集合长度也减少了，最后集合中剩余元素的个数是初始集合长度的一半。

使用 foreach 迭代器删除元素时候出现运行时异常  ConcurrentModificationException，因为使用 ArrayList 中外部 remove 元素，会造成其内部结构和游标的改变。

采用 iterator 进行删除元素，而且 .next() 必须在 .remove() 之前调用。 在 foreach 循环中，编译器会在删除元素的操作后调用 .next()，导致ConcurrentModificationException。

```java
ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
Iterator<String> iter = list.iterator();
while (iter.hasNext()) {
	String s = iter.next();
 
	if (s.equals("a")) {
		iter.remove();
	}
}
```



## static

`static` 关键字表示的概念是 全局的、静态的，用它修饰的变量被称为静态变量，用它修饰的方法叫做静态方法，用它修饰的类叫做静态类，如果修是的是一个内部类那就是静态内部类

静态变量也被称为类变量，静态变量是属于这个类所有的。

《Java 编程思想》在 P86 页有一句经典的描述

static 方法就是没有 this 的方法，在 static 内部不能调用非静态方法，反过来是可以的。而且可以在没有创建任何对象的前提下，仅仅通过类本身来调用 static 方法，这实际上是 static 方法的主要用途。

**static 变量的生命周期**

static 变量的生命周期与类的生命周期相同，随类的加载而创建，随类的销毁而销毁；普通成员变量和其所属的生命周期相同。

**static 序列化**

序列化的目的就是为了 把 Java 对象转换为字节序列。实体类在网络传输时候一定要序列化，目的是为了安全传输。对象转换为有序字节流，以便其能够在网络上传输或者保存在本地文件中。

声明为 static 和 transient 类型的变量不能被序列化，因为 static 修饰的变量保存在方法区中，只有堆内存才会被序列化。而 `transient` 关键字的作用就是防止对象进行序列化操作。

**类加载顺序**

我们前面提到了类加载顺序这么一个概念，static 修饰的变量和静态代码块在使用前已经被初始化好了，类的初始化顺序依次是 加载父类的静态字段 -> 父类的静态代码块 -> 子类静态字段 -> 子类静态代码块 -> 父类成员变量（非静态字段）-> 父类非静态代码块 -> 父类构造器 -> 子类成员变量 -> 子类非静态代码块 -> 子类构造器



## final、finally 、finalize

final  关键字，不可变的。 String类就是不可变的

不可以通过修改指定位置的字符，修饰基本数据类型的变量其值不可以被改写，修饰对象的引用的变量，对象的引用不能被改变，但是对象内部的属性可以被修改。

修饰方法，final修饰方法不能内重写

finally：关键字，保证程序一定执行。一般和 try 块一起使用，例如下面是一段 try...finally 代码块

除了机房断电、机房爆炸、机房进水、机房被雷劈、强制关机、拔电源之外，还有几种情况能够使 finally 不会执行。

- 调用 `System.exit` 方法
- 调用 `Runtime.getRuntime().halt(exitStatus)` 方法
- JVM 宕机(搞笑脸)
- 如果 JVM 在 try 或 catch 块中达到了无限循环（或其他不间断，不终止的语句）
- 操作系统是否强行终止了 JVM 进程；例如，在 UNIX 上执行 kill -9 pid
- 如果主机系统死机；例如电源故障，硬件错误，操作系统死机等不会执行
- 如果 finally 块由守护程序线程执行，那么所有非守护线程在 finally 调用之前退出。

finalize：`Object` 中的一个方法，不推荐使用。设计目的是保证对象在垃圾收集前完成特定资源的回收。finalize工作方式：一旦垃圾回收器准备好释放对象占用的存储空间，将会首先调用 `finalize` 方法，并且在下一次垃圾回收动作发生时，才会真正回收对象占用的内存。**垃圾回收只与内存有关**。





序列化和反序列化
------------------------------------------------------------------------------------------------------------------------
序列化 对象转化为字节序列 ObjectOutputStream  [writeObject]

反序列化 从IO流中恢复该对象 ObjectInputStream [readObject]



原码、补码、反码
------------------------------------------------------------------------------------------------------------------------

二进制：[0,1]

八进制：[0.7]

十进制：[0,9]

16进制：[0，F]  -->  A：10、C：12、E：14、F：15



原码：符号位 + 真值的绝对值, 即用第一位表示符号, 其余位表示值

补码：正数的补码就是其本身

​			负数的补码是在其原码的基础上, 符号位不变, 其余各位取反,最后+1. (即在反码的基础上+1)

反码：正数的反码是其本身

​			负数的反码是在其原码的基础上, 符号位不变，其余各个位取反





## 重写和重载

重写是父子集之间的表现形式，@override表示，重写后，方法的声明，数据类型，顺序要和父类保持一致

重载是一个类中方法的表形式，方法参数顺序，参数个数，参数类型任意一个不一致即可





## 四大接口

**Predicate**

Predicate 断言型接口

```
格式 Predicate<T>
调用 boolean test(T t);
```

接受一个输入参数T，返回一个布尔值结果。常用于条件判断

```java
import java.util.function.Predicate;
public class PredicateToLambda {
    public static void main(String[] args) {
        Predicate<String> predicate = new Predicate<>() {
            @Override
            public boolean test(String s) {
                //return s.isEmpty();
                return s.isBlank();
            }
        };

		// lambda 简化
	    // Predicate<String> predicate =((str)->{return str.isEmpty();});
        System.out.println(predicate.test(""));
        System.out.println(predicate.test("null"));
        System.out.println(predicate.test("hello world"));
        //        true
        //        false
        //        false
    }
}

```



**Function**

apply 供给型接口

格式：Function<T,R>
调用：R apply(T t);

接受一个输入参数T，返回一个结果R。

```java
import java.util.function.Function;
public class FunctionToLambda {
    public static void main(String[] args) {
        Function<String, String> function = new Function<>() {
            @Override
            public String apply(String s) {
                return s;
            }
        };
        // lambda 简化
        // java.util.function.Function<String, String> function =((str)->{return str;});
        System.out.println(function.apply("hello world"));
    }
}

```



**Consumer**

Consumer 消费型接口

格式：Consumer<T>
调用：void accept(T t);

接受一个输入参数并且无返回值。没有出参，常用于打印、发送短信等消费动作

```java
import java.util.function.Consumer;
public class ConsumerToLambda {
    public static void main(String[] args) {
        Consumer<String> consumer = new Consumer<>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
                return;
            }
        };
// lambda 简化
//        Consumer<String> consumer =((str)->{
//            System.out.println(str);
//            return;});
        consumer.accept("hello world");
    }
}
```



**Supplier**

Supplier 供需性接口

格式：Supplier<T>
调用：T get();

无输入参数，返回一个结果T。常用于符合条件时调用获取结果；运行结果提前定义，但不运行。

```java
import java.util.function.Supplier;
public class SupplierToLambda {
    public static void main(String[] args) {
        Supplier<Integer> supplier = new Supplier<>() {
            @Override
            public Integer get() {
                return 1024;
            }
        };
        // lambda简化
        // Supplier<Integer> supplier =(()->{return 1024;});
        System.out.println(supplier.get());
    }
}
```

## String、StringBuilder、StringBuffer



String s1 = new String("abc") 在内存中创建的对象个数：

一个或者两个，String s1 是声明了一个 String 类型的 s1 变量，它不是对象。使用 `new` 关键字会在堆中创建一个对象，另外一个对象是 `abc` ，它会在常量池中创建，所以一共创建了两个对象；如果 abc 在常量池中已经存在的话，那么就会创建一个对象。

# Spring

Spring 框架是一个开放源代码的`J2EE`应用程序框架，由`Rod Johnson`发起，是针对bean的生命周期进行管理的轻量级容器（lightweight container）。 Spring解决了开发者在J2EE开发中遇到的许多常见的问题，提供了功能强大IOC、AOP及Web MVC等功能。	

官方文档

https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-java

现代化java开发，构建一切，协调一切，连接一起

优点

- 开源免费的框架 Spring is everywhere、Spring is flexible、Spring is productive、Spring is fast、Spring is secure、Spring is supportive

- 轻量级的非入侵式的框架 
- 控制反转IOC，面向切面编程AOP
- 支持事务处理，对框架的整合的支持

Spring框架主要由七部分组成，分别是 Spring Core、 Spring AOP、 Spring ORM、 Spring DAO、Spring Context、 Spring Web和 Spring Web MVC。

Spring 单例【不安全】对象的初始化 创建Bean实例，多个bean的属性填充，调用spring 的ApplicationContext.xml 中的 init 方法

Bean 是一个无状态的【只查询】 安全

Bean 是【有状态】 采用ThreadLocal对状态数据进行线程隔离，从而保证线程安全

Spring支持两种事务编程模型

编程式事务：采用Spring的TransactionTemplate模板

声明式事务：在事务的管理方法上添加 @Transactional注解

## IOC

IOC是Inversion of Control的缩写，翻译为控制反转，是借助于“第三方”实现具有依赖关系的对象之间的解耦，能指导我们如何设计出松耦合、更优良的程序。

IOC是一种思想，DI是具体实现。当用户的需求发生改变，程序员需要极大的增加代码进行扩展，IOC就是将程序的主动权交给用于用户。一开始将对象放入IOC容器当中，用户需要什么对象，直接从容器中取出。

IOC很好的体现了面向对象设计法则之一 -----> 好莱坞法则：“别找我们，我们找你”；即由IOC容器帮对象找相应的依赖对象并注入，而不是由对象主动去找。

IOC生成对象是通过反射方式进行的

IOC的三种注入方式：构造器注入【C命名空间注入】，setter注入【P命名空间-属性】，注解注入【类反射获取对象】

有反转就有正转，传统应用程序是由我们自己在对象中主动控制去直接获取依赖对象，也就是正转；

而反转则是由容器来帮忙创建及注入依赖对象；因为由容器帮我们查找及注入依赖对象，对象只是被动的接受依赖对象，所以是反转，其中依赖对象的获取被反转了。

@Autowired 【自动按照类型注入，类型不唯一时，他会把属性名作为bean的id在容器中查找】

@Qualifier 【属性的类型具有多个Bean，指定Bean名称，用于消除歧义】

@Resource  【JDK注解，默认按照名称进行注入，也支持类型注入 name = “byName|byType”】

@Scope     【声明作用域，使用哪一种模式，单例其他】



## AOP

面向切面编程是OOP[面向对象编程的一种扩展]

两种实现

- JDK动态代理【推荐】，Java提供的动态代理，可以在运行时创建接口的代理实例，只能对IOC容器中的Bean进行增强
- CGLib动态代理，采用底层的字节码技术，运行时创建子类来代理的实例，不能对final修饰的类进行增强

JDK动态代理优点：耗时短，适用多对象的频繁创建

# 算法



**Brian Kernighan** 

算法的原理是：对于任意整数 x，令 x=x&(x-1)，该运算将 x 的二进制表示的最后一个 1 变成 0。因此，对 x 重复该操作，直到 x 变成 0，则操作次数即为 x 的「一比特数」。

(i & 1)  == 0 此时 i 是 2 的倍数，(i & 1)  == 1 此时 i 不是 2 的倍数

**位运算**

^ 异或，相同为 0，相异为 1

**dijkstra**

迪杰斯特拉算法求取节点到每个节点的最短路径，建立好图的关系，采用小顶堆数据结构存储到达的节点和到达节点的最短距离，根据二维数组`edge[][3]`的关系建立图连接

```java
	    // 保存这个节点的可达性，建立图
        List<int[]>[] graph = new ArrayList[n];
        Arrays.setAll(graph, e -> new ArrayList<int[]>());
        for(int[] edge : edges){
            int u = edge[0],v = edge[1],cnt = edge[2];
            // 建立图，节点和连接节点关系
            graph[u].add(new int[]{v,cnt+1});
            graph[v].add(new int[]{u,cnt+1});
        }
```

求取 start 开始到达图中所以节点的最短距离

```java
	public int[] dijkstra(List<int[]>[] graph,int start){
        // 初始化距离数组全部为最大值，到大本身的距离是0
        int[] dist = new int[graph.length];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        // 小顶堆存储到达每一个节点的最短距离
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        pq.offer(new int[]{start,0});
        while(!pq.isEmpty()){
            // 堆顶的元素和最短距离
            int[] curNode = pq.poll();
            int x = curNode[0],d = curNode[1];
            if(d > dist[x]) continue;
            // 遍历节点元素的可达路径，更新最短距离，并且
            for(int[] e : graph[x]){
                int y = e[0];
                int curDist = d + e[1];
                if(curDist < dist[y]){
                    dist[y] = curDist;
                    pq.offer(new int[]{y,curDist});
                }
            }
        }
        return dist;
    }
```

ASCII 码的转换，将偶数位转化字符 0，奇数位转化为字符 1

```java
('0' + i % 2)
```

鸽巢原理：若有n个鸽巢，n+1个鸽子，则至少有一个巢内有至少两个鸽子。

`ArrayList<String>`存储时间，求集合中最短时间，先对集合进行排序，求解相邻的时间最小时间差，在与首尾时间差对比，返回最小的那个即可。优化思想，最小单位是分钟，一天最多有 24 * 60 = 1440 种可能，因此时间数量一旦大于这个，就说明一天之内，有相同时间，因此最小时间差直接返回 0 即可










