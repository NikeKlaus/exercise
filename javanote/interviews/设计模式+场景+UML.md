## 1. 设计模式

#### 1.1 说一说设计模式的六大原则

**参考答案**

单一职责原则

一个类，应当只有一个引起它变化的原因；即一个类应该只有一个职责。

就一个类而言，应该只专注于做一件事和仅有一个引起变化的原因，这就是所谓的单一职责原则。该原则提出了对对象职责的一种理想期望，对象不应该承担太多职责，正如人不应该一心分为二用。唯有专注，才能保证对象的高内聚；唯有单一，才能保证对象的细粒度。对象的高内聚与细粒度有利于对象的重用。一个庞大的对象承担了太多的职责，当客户端需要该对象的某一个职责时，就不得不将所有的职责都包含进来，从而造成冗余代码。

里氏替换原则

在面向对象的语言中，继承是必不可少的、优秀的语言机制，它主要有以下几个优点：

- 代码共享，减少创建类的工作量，每个子类都拥有父类的方法和属性；
- 提高代码的可重用性；
- 提高代码的可扩展性；
- 提高产品或项目的开放性。

相应的，继承也存在缺点，主要体现在以下几个方面：

- 继承是入侵式的。只要继承，就必须拥有父类的所有属性和方法；
- 降低代码的灵活性。子类必须拥有父类的属性和方法，使子类受到限制；
- 增强了耦合性。当父类的常量、变量和方法修改时，必须考虑子类的修改，这种修改可能造成大片的代码需要重构。

从整体上看，继承的“利”大于“弊”，然而如何让继承中“利”的因素发挥最大作用，同时减少“弊”所带来的麻烦，这就需要引入“里氏替换原则”。里氏替换原则的定义有以下两种：

- 如果对一个类型为S的对象o1，都有类型为T的对象o2，使得以S定义的所有程序P在所有的对象o1都代换成o2时，程序P的行为没有发生变化，那么类型T是类型S的子类型。
- 所有引用基类的地方必须能透明地使用其子类对象。清晰明确地说明只要父类能出现的地方子类就可以出现，而且替换为子类也不会产生任何错误或异常，使用者可能根本就不需要知道父类还是子类；但是反过来则不可以，有子类的地方，父类未必就能适应。

依赖倒置原则

依赖倒置原则包括三种含义：

- 高层模块不应该依赖低层模块，两者都依赖其抽象；
- 抽象不依赖细节；
- 细节应该依赖于抽象。

传统的过程性系统的设计办法倾向于高层次的模块依赖于低层次的模块；抽象层次依赖于具体层次。“倒置”原则将这个错误的依赖关系倒置了过来，如下图所示，由此命名为“依赖倒置原则”。



在Java语言中，抽象就是指接口或抽象类，两者都是不能直接被实例化的；细节就是具体的实现类，实现类实现了接口或继承了抽象类，其特点是可以直接被实例化。依赖倒置原则在Java语言中的表现是：

- 模块间的依赖通过抽象发生，实现类之间不发生直接的依赖关系，其依赖关系是通过接口或抽象类产生；
- 接口或抽象类不依赖于实现类；
- 实现类依赖于接口或抽象类。

依赖倒置原则更加精确的定义就是“面向接口编程”——OOD（Object-Oriented Design）的精髓之一。依赖倒置原则可以减少类间的耦合性，提高系统的稳定性，降低并行开发引起的风险，提高代码的可读性和可维护性。依赖倒置原则是JavaBean、EJB和COM等组件设计模型背后的基本原则。

接口隔离原则

接口隔离原则有如下两种定义：

1. 客户端不应该依赖它不需要的接口。
2. 类间的依赖关系应该建立在最小的接口上。

接口隔离原则的具体含义如下：

- 一个类对另外一个类的依赖性应当是建立在最小的接口上的。
- 一个接口代表一个角色，不应当将不同的角色都交给一个接口。没有关系的接口合并在一起，形成一个臃肿的大接口，这是对角色和接口的污染。因此使用多个专门的接口比使用单一的总接口要好。
- 不应该强迫客户依赖于它们不用的方法。接口属于客户，不属于它所在的类层次结构，即不要强迫客户使用它们不用的方法，否则这些客户就会面临由于这些不使用的方法的改变所带来的改变。

迪米特法则

迪米特法则又叫最少知识原则，意思是一个对象应当对其他对象尽可能少的了解。迪米特法则不同于其他的OO设计原则，它具有很多种表述方式，其中具有代表性的是以下几种表述：

- 只与你直接的朋友们通信；
- 不要跟“陌生人”说话；
- 每一个软件单位对其他的单位都只有最少的了解，这些了解仅局限于那些与本单位密切相关的软件单位。

按照迪米特法则，如果两个类不必彼此直接通信，那么这两个类就不应当发生直接的相互作用；如果一个类需要调用另一个类的某一个方法，可以通过第三者转发这个调用。

开闭原则

开闭原则的定义是：一个软件实体应当对扩展开放，对修改关闭。这个原则说的是，在设计一个模块的时候，应当使这个模块可以在不被修改的前提下被扩展，即应当可以在不必修改源代码的情况下改变这个模块的行为。

在面向对象的编程中，开闭原则是最基础的原则，起到总的指导作用，其他原则（单一职责、里氏替换、依赖倒置、接口隔离、迪米特法则）都是开闭原则的具体形态，即其他原则都是开闭原则的手段和工具。开闭原则的重要性可以通过以下几个方面来体现。

- 开闭原则提高复用性。在面向对象的设计中，所有的逻辑都是从原子逻辑组合而来的，而不是在一个类中独立实现一个业务逻辑，代码粒度越小，被复用的可能性就越大，避免相同的逻辑重复增加。开闭原则的设计保证系统是一个在高层次上实现了复用的系统。
- 开闭原则提高可维护性。一个软件投产后，维护人员的工作不仅仅是对数据进行维护，还可能对程序进行扩展，就是扩展一个类，而不是修改一个类。开闭原则对已有软件模块，特别是最重要的抽象层模块要求不能再修改，这就使变化中的软件系统有一定的稳定性和延续性，便于系统的维护。
- 开闭原则提高灵活性。所有的软件系统都有一个共同的性质，即对系统的需求都会随时间的推移而发生变化。在软件系统面临新的需求时，系统的设计必须是稳定的。开闭原则可以通过扩展已有的软件系统，提供新的行为，能快速应对变化，以满足对软件新的需求，使变化中的软件系统有一定的适应性和灵活性。
- 开闭原则易于测试。测试是软件开发过程中必不可少的一个环节。测试代码不仅要保证逻辑的正确性，还要保证苛刻条件（高压力、异常、错误）下不产生“有毒代码”（Poisonous Code），因此当有变化提出时，原有健壮的代码要尽量不修改，而是通过扩展来实现。否则，就需要把原有的测试过程回笼一遍，需要进行单元测试、功能测试、集成测试，甚至是验收测试。开闭原则的使用，保证软件是通过扩展来实现业务逻辑的变化，而不是修改。因此，对于新增加的类，只需新增相应的测试类，编写对应的测试方法，只要保证新增的类是正确的就可以了。

#### 1.2 说一下六大原则中的开闭原则

**参考答案**

开闭原则的定义是：一个软件实体应当对扩展开放，对修改关闭。这个原则说的是，在设计一个模块的时候，应当使这个模块可以在不被修改的前提下被扩展，即应当可以在不必修改源代码的情况下改变这个模块的行为。

在面向对象的编程中，开闭原则是最基础的原则，起到总的指导作用，其他原则（单一职责、里氏替换、依赖倒置、接口隔离、迪米特法则）都是开闭原则的具体形态，即其他原则都是开闭原则的手段和工具。开闭原则的重要性可以通过以下几个方面来体现。

- 开闭原则提高复用性。在面向对象的设计中，所有的逻辑都是从原子逻辑组合而来的，而不是在一个类中独立实现一个业务逻辑，代码粒度越小，被复用的可能性就越大，避免相同的逻辑重复增加。开闭原则的设计保证系统是一个在高层次上实现了复用的系统。
- 开闭原则提高可维护性。一个软件投产后，维护人员的工作不仅仅是对数据进行维护，还可能对程序进行扩展，就是扩展一个类，而不是修改一个类。开闭原则对已有软件模块，特别是最重要的抽象层模块要求不能再修改，这就使变化中的软件系统有一定的稳定性和延续性，便于系统的维护。
- 开闭原则提高灵活性。所有的软件系统都有一个共同的性质，即对系统的需求都会随时间的推移而发生变化。在软件系统面临新的需求时，系统的设计必须是稳定的。开闭原则可以通过扩展已有的软件系统，提供新的行为，能快速应对变化，以满足对软件新的需求，使变化中的软件系统有一定的适应性和灵活性。
- 开闭原则易于测试。测试是软件开发过程中必不可少的一个环节。测试代码不仅要保证逻辑的正确性，还要保证苛刻条件（高压力、异常、错误）下不产生“有毒代码”（Poisonous Code），因此当有变化提出时，原有健壮的代码要尽量不修改，而是通过扩展来实现。否则，就需要把原有的测试过程回笼一遍，需要进行单元测试、功能测试、集成测试，甚至是验收测试。开闭原则的使用，保证软件是通过扩展来实现业务逻辑的变化，而不是修改。因此，对于新增加的类，只需新增相应的测试类，编写对应的测试方法，只要保证新增的类是正确的就可以了。

#### 1.3 手写一个单例模式

**参考答案**

饿汉式单例模式：

```
public class Singleton {     private static Singleton instance = new Singleton();     // 私有构造方法，保证外界无法直接实例化。     private Singleton() {}     // 通过公有的静态方法获取对象实例     public static Singleton getInstace() {         return instance;     } }
```

懒汉式单例模式：

```
public class Singleton {     private static Singleton instance = null;     // 私有构造方法，保证外界无法直接实例化。     private Singleton() {}     // 通过公有的静态方法获取对象实例     public static Singleton getInstace() {         if (instance == null) {             instance = new Singleton();         }         return instance;     } }
```

#### 1.4 手写一个线程安全的单例模式

**参考答案**

在懒汉式单例模式基础上实现线程同步：

```
public class Singleton {     private static Singleton instance = null;     // 私有构造方法，保证外界无法直接实例化。     private Singleton() {}     // 通过公有的静态方法获取对象实例     synchronized public static Singleton getInstace() {         if (instance == null) {             instance = new Singleton();         }         return instance;     } }
```

上述代码对静态方法 getInstance()进行同步，以确保多线程环境下只创建一个实例。如果getInstance()方法未被同步，并且线程A和线程B同时调用此方法，则执行if (instance == null)语句时都为真，那么线程A和线程B都会创建一个对象，在内存中就会出现两个对象，这样就违反了单例模式。而使用synchronized关键字进行同步后，则不会出现此种情况。

#### 1.5 说一说你对工厂模式的理解

**参考答案**

工厂模式的用意是定义一个创建产品对象的工厂接口，将实际创建性工作推迟到子类中。工厂模式可分为简单工厂、工厂方法和抽象工厂模式。注意，我们常说的23种经典设计模式，包含了工程方法模式和抽象工厂模式，而并未包含简单工厂模式。另外，我们平时说的工厂模式，一般默认是指工厂方法模式。

简单工厂

简单工厂模式其实并不算是一种设计模式，更多的时候是一种编程习惯。简单工厂的实现思路是，定义一个工厂类，根据传入的参数不同返回不同的实例，被创建的实例具有共同的父类或接口。简单工厂的适用场景是：

- 需要创建的对象较少。
- 客户端不关心对象的创建过程。

示例：

创建一个可以绘制不同形状的绘图工具，可以绘制圆形，正方形，三角形，每个图形都会有一个draw()方法用于绘图，不看代码先考虑一下如何通过该模式设计完成此功能。

由题可知圆形，正方形，三角形都属于一种图形，并且都具有draw方法，所以首先可以定义一个接口或者抽象类，作为这三个图像的公共父类，并在其中声明一个公共的draw方法：

```
public interface Shape {     void draw(); }
```

下面就是编写具体的图形，每种图形都实现Shape接口：

```
// 圆形 class CircleShape implements Shape {     public CircleShape() {         System.out.println("CircleShape: created");     }     @Override     public void draw() {         System.out.println("draw: CircleShape");     } } // 正方形 class RectShape implements Shape {     public RectShape() {        System.out.println("RectShape: created");     }     @Override     public void draw() {        System.out.println("draw: RectShape");     }  } // 三角形 public class TriangleShape implements Shape {     public TriangleShape() {         System.out.println("TriangleShape: created");     }     @Override     public void draw() {         System.out.println("draw: TriangleShape");     } }
```

下面是工厂类的具体实现：

```
 class ShapeFactory {           public static Shape getShape(String type) {               Shape shape = null;               if (type.equalsIgnoreCase("circle")) {                   shape = new CircleShape();               } else if (type.equalsIgnoreCase("rect")) {                   shape = new RectShape();               } else if (type.equalsIgnoreCase("triangle")) {                   shape = new TriangleShape();               }               return shape;           }    }
```

为工厂类传入不同的type可以new不同的形状，返回结果为Shape 类型，这个就是简单工厂核心的地方了。

工厂方法

工厂方法模式是简单工厂的仅一步深化， 在工厂方法模式中，我们不再提供一个统一的工厂类来创建所有的对象，而是针对不同的对象提供不同的工厂。也就是说每个对象都有一个与之对应的工厂。

工厂方法的实现思路是，定义一个用于创建对象的接口，让子类决定将哪一个类实例化。工厂方法模式让一个类的实例化延迟到其子类。

示例：

现在需要设计一个这样的图片加载类，它具有多个图片加载器，用来加载jpg，png，gif格式的图片，每个加载器都有一个read()方法，用于读取图片。下面我们完成这个图片加载类。

首先完成图片加载器的设计，编写一个加载器的公共接口：

```
public interface Reader {     void read(); }
```

然后完成各个图片加载器的代码：

```
// jpg图片加载器 class JpgReader implements Reader {     @Override     public void read() {         System.out.print("read jpg");     } } // png图片加载器 class PngReader implements Reader {     @Override     public void read() {         System.out.print("read png");     } } // gif图片加载器 class GifReader implements Reader {     @Override     public void read() {         System.out.print("read gif");     } }
```

现在我们按照定义所说定义一个抽象的工厂接口ReaderFactory：

```
interface ReaderFactory {
    Reader getReader();
}
```

里面有一个getReader()方法返回我们的Reader 类，接下来我们把上面定义好的每个图片加载器都提供一个工厂类，这些工厂类实现了ReaderFactory 。

```
// jpg加载器工厂
class JpgReaderFactory implements ReaderFactory {
    @Override
    public Reader getReader() {
        return new JpgReader();
    }
}
// png加载器工厂
class PngReaderFactory implements ReaderFactory {
    @Override
    public Reader getReader() {
        return new PngReader();
    }
}
// gif加载器工厂
class GifReaderFactory implements ReaderFactory {
    @Override
    public Reader getReader() {
        return new GifReader();
    }
}
```

在每个工厂类中我们都通过重写的getReader()方法返回各自的图片加载器对象。

和简单工厂对比一下，最根本的区别在于，简单工厂只有一个统一的工厂类，而工厂方法是针对每个要创建的对象都会提供一个工厂类，这些工厂类都实现了一个工厂基类。

下面总结一下工厂方法的适用场景：

- 客户端不需要知道它所创建的对象的类。
- 客户端可以通过子类来指定创建对应的对象。

抽象工厂

这个模式最不好理解，而且在实际应用中局限性也蛮大的，因为这个模式并不符合开闭原则。实际开发还需要做好权衡。抽象工厂模式是工厂方法的仅一步深化，在这个模式中的工厂类不单单可以创建一个对象，而是可以创建一组对象。这是和工厂方法最大的不同点。

抽象工厂的实现思路是，提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类。抽象工厂和工厂方法一样可以划分为4大部分：

- AbstractFactory（抽象工厂）：声明了一组用于创建对象的方法，注意是一组。
- ConcreteFactory（具体工厂）：它实现了在抽象工厂中声明的创建对象的方法，生成一组具体对象。
- AbstractProduct（抽象产品）：它为每种对象声明接口，在其中声明了对象所具有的业务方法。
- ConcreteProduct（具体产品）：它定义具体工厂生产的具体对象。

示例：

现在需要做一款跨平台的游戏，需要兼容Android，Ios，Wp三个移动操作系统，该游戏针对每个系统都设计了一套操作控制器（OperationController）和界面控制器（UIController），下面通过抽闲工厂方式完成这款游戏的架构设计。

由题可知，游戏里边的各个平台的UIController和OperationController应该是我们最终生产的具体产品。所以新建两个抽象产品接口。

抽象操作控制器：

```
interface OperationController {
    void control();
}
```

抽象界面控制器：

```
interface UIController {
    void display();
}
```

然后完成各个系统平台的具体操作控制器和界面控制器。

Android：

```
class AndroidOperationController implements OperationController {
    @Override
    public void control() {
        System.out.println("AndroidOperationController");
    }
}
class AndroidUIController implements UIController {
    @Override
    public void display() {
        System.out.println("AndroidInterfaceController");
    }
}
```

IOS：

```
class IosOperationController implements OperationController {
    @Override
    public void control() {
        System.out.println("IosOperationController");
    }
}
class IosUIController implements UIController {
    @Override
    public void display() {
        System.out.println("IosInterfaceController");
    }
}
```

WP：

```
class WpOperationController implements OperationController {
    @Override
    public void control() {
        System.out.println("WpOperationController");
    }
}
class WpUIController implements UIController {
    @Override
    public void display() {
        System.out.println("WpInterfaceController");
    }
}
```

下面定义一个抽闲工厂，该工厂需要可以创建OperationController和UIController。

```
public interface SystemFactory {
    public OperationController createOperationController();
    public UIController createInterfaceController();
}
```

在各平台具体的工厂类中完成操作控制器和界面控制器的创建过程。

Android：

```
public class AndroidFactory implements SystemFactory {
    @Override
    public OperationController createOperationController() {
        return new AndroidOperationController();
    }
    @Override
    public UIController createInterfaceController() {
        return new AndroidUIController();
    }
}
```

IOS：

```
public class IosFactory implements SystemFactory {
    @Override
    public OperationController createOperationController() {
        return new IosOperationController();
    }
    @Override
    public UIController createInterfaceController() {
        return new IosUIController();
    }
}
```

WP：

```
public class WpFactory implements SystemFactory {
    @Override
    public OperationController createOperationController() {
        return new WpOperationController();
    }
    @Override
    public UIController createInterfaceController() {
        return new WpUIController();
    }
}
```

下面总结一下抽象工厂的适用场景：

- 和工厂方法一样客户端不需要知道它所创建的对象的类。
- 需要一组对象共同完成某种功能时。并且可能存在多组对象完成不同功能的情况。
- 系统结构稳定，不会频繁的增加对象。

#### 1.6 简单工厂模式和抽象工厂模式有什么区别？

**参考答案**

简单工厂模式其实并不算是一种设计模式，更多的时候是一种编程习惯。简单工厂的实现思路是，定义一个工厂类，根据传入的参数不同返回不同的实例，被创建的实例具有共同的父类或接口。

工厂方法模式是简单工厂的仅一步深化， 在工厂方法模式中，我们不再提供一个统一的工厂类来创建所有的对象，而是针对不同的对象提供不同的工厂。也就是说每个对象都有一个与之对应的工厂。工厂方法的实现思路是，定义一个用于创建对象的接口，让子类决定将哪一个类实例化。工厂方法模式让一个类的实例化延迟到其子类。

抽象工厂模式是工厂方法的仅一步深化，在这个模式中的工厂类不单单可以创建一个对象，而是可以创建一组对象。这是和工厂方法最大的不同点。抽象工厂的实现思路是，提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类。

#### 1.7 如何实现工厂模式？

**参考答案**

简单工厂

示例：

创建一个可以绘制不同形状的绘图工具，可以绘制圆形，正方形，三角形，每个图形都会有一个draw()方法用于绘图，不看代码先考虑一下如何通过该模式设计完成此功能。

由题可知圆形，正方形，三角形都属于一种图形，并且都具有draw方法，所以首先可以定义一个接口或者抽象类，作为这三个图像的公共父类，并在其中声明一个公共的draw方法：

```
public interface Shape {
    void draw();
}
```

下面就是编写具体的图形，每种图形都实现Shape接口：

```
// 圆形
class CircleShape implements Shape {
    public CircleShape() {
        System.out.println("CircleShape: created");
    }
    @Override
    public void draw() {
        System.out.println("draw: CircleShape");
    }
}
// 正方形
class RectShape implements Shape {
    public RectShape() {
       System.out.println("RectShape: created");
    }
    @Override
    public void draw() {
       System.out.println("draw: RectShape");
    }

}
// 三角形
public class TriangleShape implements Shape {
    public TriangleShape() {
        System.out.println("TriangleShape: created");
    }
    @Override
    public void draw() {
        System.out.println("draw: TriangleShape");
    }
}
```

下面是工厂类的具体实现：

```
 class ShapeFactory {
          public static Shape getShape(String type) {
              Shape shape = null;
              if (type.equalsIgnoreCase("circle")) {
                  shape = new CircleShape();
              } else if (type.equalsIgnoreCase("rect")) {
                  shape = new RectShape();
              } else if (type.equalsIgnoreCase("triangle")) {
                  shape = new TriangleShape();
              }
              return shape;
          }
   }
```

为工厂类传入不同的type可以new不同的形状，返回结果为Shape 类型，这个就是简单工厂核心的地方了。

工厂方法

示例：

现在需要设计一个这样的图片加载类，它具有多个图片加载器，用来加载jpg，png，gif格式的图片，每个加载器都有一个read()方法，用于读取图片。下面我们完成这个图片加载类。

首先完成图片加载器的设计，编写一个加载器的公共接口：

```
public interface Reader {
    void read();
}
```

然后完成各个图片加载器的代码：

```
// jpg图片加载器
class JpgReader implements Reader {
    @Override
    public void read() {
        System.out.print("read jpg");
    }
}
// png图片加载器
class PngReader implements Reader {
    @Override
    public void read() {
        System.out.print("read png");
    }
}
// gif图片加载器
class GifReader implements Reader {
    @Override
    public void read() {
        System.out.print("read gif");
    }
}
```

现在我们按照定义所说定义一个抽象的工厂接口ReaderFactory：

```
interface ReaderFactory {
    Reader getReader();
}
```

里面有一个getReader()方法返回我们的Reader 类，接下来我们把上面定义好的每个图片加载器都提供一个工厂类，这些工厂类实现了ReaderFactory 。

```
// jpg加载器工厂
class JpgReaderFactory implements ReaderFactory {
    @Override
    public Reader getReader() {
        return new JpgReader();
    }
}
// png加载器工厂
class PngReaderFactory implements ReaderFactory {
    @Override
    public Reader getReader() {
        return new PngReader();
    }
}
// gif加载器工厂
class GifReaderFactory implements ReaderFactory {
    @Override
    public Reader getReader() {
        return new GifReader();
    }
}
```

在每个工厂类中我们都通过重写的getReader()方法返回各自的图片加载器对象。

抽象工厂

示例：

现在需要做一款跨平台的游戏，需要兼容Android，Ios，Wp三个移动操作系统，该游戏针对每个系统都设计了一套操作控制器（OperationController）和界面控制器（UIController），下面通过抽闲工厂方式完成这款游戏的架构设计。

由题可知，游戏里边的各个平台的UIController和OperationController应该是我们最终生产的具体产品。所以新建两个抽象产品接口。

抽象操作控制器：

```
interface OperationController {
    void control();
}
```

抽象界面控制器：

```
interface UIController {
    void display();
}
```

然后完成各个系统平台的具体操作控制器和界面控制器。

Android：

```
class AndroidOperationController implements OperationController {
    @Override
    public void control() {
        System.out.println("AndroidOperationController");
    }
}
class AndroidUIController implements UIController {
    @Override
    public void display() {
        System.out.println("AndroidInterfaceController");
    }
}
```

IOS：

```
class IosOperationController implements OperationController {
    @Override
    public void control() {
        System.out.println("IosOperationController");
    }
}
class IosUIController implements UIController {
    @Override
    public void display() {
        System.out.println("IosInterfaceController");
    }
}
```

WP：

```
class WpOperationController implements OperationController {
    @Override
    public void control() {
        System.out.println("WpOperationController");
    }
}
class WpUIController implements UIController {
    @Override
    public void display() {
        System.out.println("WpInterfaceController");
    }
}
```

下面定义一个抽闲工厂，该工厂需要可以创建OperationController和UIController。

```
public interface SystemFactory {
    public OperationController createOperationController();
    public UIController createInterfaceController();
}
```

在各平台具体的工厂类中完成操作控制器和界面控制器的创建过程。

Android：

```
public class AndroidFactory implements SystemFactory {
    @Override
    public OperationController createOperationController() {
        return new AndroidOperationController();
    }
    @Override
    public UIController createInterfaceController() {
        return new AndroidUIController();
    }
}
```

IOS：

```
public class IosFactory implements SystemFactory {
    @Override
    public OperationController createOperationController() {
        return new IosOperationController();
    }
    @Override
    public UIController createInterfaceController() {
        return new IosUIController();
    }
}
```

WP：

```
public class WpFactory implements SystemFactory {
    @Override
    public OperationController createOperationController() {
        return new WpOperationController();
    }
    @Override
    public UIController createInterfaceController() {
        return new WpUIController();
    }
}
```

#### 1.8 说一说你策略模式的理解

**参考答案**

策略模式（Strategy Pattern）也叫政策模式，是一种比较简单的模式。它的目的是定义一组算法，将每个算法都封装起来，并且使它们之间可以互换。其用意是针对一组算法，将每一个算法封装到具有共同接口的独立的类中，从而使得它们可以相互替换，使得算法可以在不影响到客户端的情况下发生变化。

策略模式的通用类图如下图所示：



策略模式涉及以下3个角色：

- 环境（Context）角色：该角色也叫上下文角色，起到承上启下的作用，屏蔽高层模块对策略、算法的直接访问，它持有一个Strategy类的引用。
- 抽象策略（Strategy）角色：该角色对策略、算法进行抽象，通常定义每个策略或算法必须具有的方法和属性。
- 具体策略（Concrete Strategy）角色：该角色实现抽象策略中的具体操作，含有具体的算法。

抽象策略Strategy的代码如下所示：

```
public abstract class Strategy {
    public abstract void strategyInterface();
}
```

具体策略ConcreteStrategy的代码如下所示：

```
public class ConcreteStrategy extends Strategy {
    public void strategyInterface() {
        ...
    }
}
```

环境角色Context的代码如下所示：

```
public class Context {
    private Strategy strategy = null;
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    public void contextInterface() {
        this.strategy.strategyInterface();
    }
}
```

策略模式包括如下优点：

- 策略模式提供了管理相关的算法族的办法。策略类的等级结构定义了一个算法或行为族，恰当地使用继承可以把公共的代码移到父类中，从而避免代码重复。
- 策略模式提供了可以替换继承关系的办法。继承可以处理多种算法或行为，如果不用策略模式，那么使用算法或行为的环境类就可能会有一些子类，每一个子类提供一个不同的算法或行为。但是，这样算法或行为的使用者就和算法本身混在一起，从而不可能再独立演化。
- 使用策略模式可以避免使用多重条件转移语句。多重转移语句不易维护，它把采取哪一种算法或采取哪一种行为的逻辑与算法或行为的逻辑混合在一起，统统列在一个多重转移语句里面，这比使用继承的办法还要原始和落后。

策略模式包括如下缺点：

- 客户端必须知道所有的策略类，并自行决定使用哪一个策略类。这就意味着客户端必须理解这些算法的区别，以便适时选择恰当的算法类，即策略模式只适用于客户端知道所有的算法或行为的情况。
- 策略模式造成很多的策略类。有时候可以通过把依赖于环境的状态保持到客户端里面，而将策略类设计成可共享的，这样策略类实例可以被不同客户端使用。可以使用享元模式来减少对象的数量。

策略模式有如下几个应用场景：

- 多个类只是在算法或行为上稍有不同的场景。
- 算法需要自由切换的场景。
- 需要屏蔽算法规则的场景。

#### 1.9 说一说你对观察者模式的了解

**参考答案**

观察者模式（Observer Pattern）也称发布订阅模式，它的目的是定义对象间一种一对多的依赖关系，使得每当一个对象改变状态，则所有依赖于它的对象都会得到通知并被自动更新。

观察者模式的类图如下图所：



观察者模式具有以下4个角色：

- 抽象主题（Subject）角色：该角色又称为“被观察者”，可以增加和删除观察者对象。
- 抽象观察者（Observer）角色：该角色为所有的具体观察者定义一个接口，在得到主题的通知时更新自己。
- 具体主题（Concrete Subject）角色：该角色又称为“具体被观察者”，它将有关状态存入具体观察者对象，在具体主题的内部状态改变时，给所有登记过的观察者发出通知。
- 具体观察者（Concrete Observer）角色：该角色实现抽象观察者所要求的更新接口，以便使自身的状态与主题的状态相协调。

上述类图所涉及的代码如下所示：

```
interface Subject {
    // 登记一个新的观察者
    public void attach(Observer obs);
    // 删除一个登记过的观察者
    public void detach(Observer obs);
    // 通知所有登记过的观察者对象
    public void notifyObserver();
}
interface Observer {
    // 更新方法
    public void update();
}
class ConcreteSubject implements Subject {
    private Vector<Observer> obsVector = new Vector<Observer>();
    // 登记一个新的观察者
    public void attach(Observer obs) {
        obsVector.add(obs);
    }
    // 删除一个登记过的观察者
    public void detach(Observer obs) {
        obsVector.remove(obs);
    }
    // 通知所有登记过的观察者对象
    public void notifyObserver() {
        for (Observer e : obsVector) {
            e.update();
        }
    }
    // 返回观察者集合的Enumeration对象
    public Enumeration<Observer> observers() {
        return obsVector.elements();
    }
    // 业务方法，改变状态
    public void change() {
        this.notifyObserver();
    }
}
class ConcreteObserver implements Observer {
    // 实现更新方法
    public void update() {
        System.out.println("收到通知，并进行处理！");
    }
}
```

观察者模式具有以下几个优点：

- 观察者和被观察者之间是抽象耦合。被观察者角色所知道的只是一个具体观察者集合，每一个具体观察者都符合一个抽象观察者的接口。被观察者并不认识任何一个具体的观察者，它只知道它们都有一个共同的接口。由于被观察者和观察者没有紧密的耦合在一起，因此它们可以属于不同的抽象化层次，且都非常容易扩展。
- 支持广播通信。被观察者会向所有登记过的观察者发出通知，这就是一个触发机制，形成一个触发链。

观察模式的缺点如下：

- 如果一个主题有多个直接或间接的观察者，则通知所有的观察者会花费很多时间，且开发和调试都比较复杂。
- 如果在主题之间有循环依赖，被观察者会触发它们之间进行循环调用，导致系统崩溃。在使用观察者模式时要特别注意这一点。
- 如果对观察者的通知是通过另外的线程进行异步投递，系统必须保证投递的顺序执行。
- 虽然观察者模式可以随时使观察者知道所观察的对象发生了变化，但是观察者模式没有提供相应的机制使观察者知道所观察的对象是如何发生变化。

观察者模式的应用场景如下：

- 关联行为场景。
- 事件多级触发场景。
- 跨系统的消息交换场景，如消息队列的处理机制。

#### 1.10 说一说你对责任链模式的了解

**参考答案**

责任链模式（Chain of Responsibility Pattern）是一种常见的行为模式，它的目的是使多个对象都有机会处理请求，从而避免了请求的发送者和接收者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递该请求，直到有对象处理它为止。

责任链模式的重点是在“链”上，由一条链去处理相似的请求，在链中决定谁来处理这个请求，并返回相应的结果。责任链模式的类图如下图所示：



责任链模式涉及以下两个角色：

- 抽象处理者（Handler）角色：该角色对请求进行抽象，并定义一个方法以设定和返回对下一个处理者的引用。
- 具体处理者（Concrete Handler）角色：该角色接到请求后，可以选择将请求处理掉，或者将请求传给下一个处理者。由于具体处理者持有对下一个处理者的引用，因此，如果需要，具体处理者可以访问下一个处理者。

上述类图所涉及的代码如下所示：

```
abstract class Handler {
    private Handler successor;
    public abstract void handleRequest();
    public Handler getSuccessor() {
        return successor;
    }
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
}
class ConcreteHandler extends Handler {
    // 处理请求
    public void handleRequest() {
        if (getSuccessor() != null) {
            System.out.println("请求传递给" + getSuccessor());
            getSuccessor().handleRequest();
        } else {
            System.out.println("请求处理");
        }
    }
}
```

责任链模式的优点如下：

- 责任链模式将请求和处理分开，请求者不知道是谁处理的，处理者可以不用知道请求的全貌。
- 提高系统的灵活性。

责任链模式的缺点如下：

- 降低程序的性能，每个请求都是从链头遍历到链尾，当链比较长的时候，性能会大幅下降。
- 不易于调试，由于采用了类似递归的方式，调试的时候逻辑比较复杂。

责任链模式的应用场景如下：

- 一个请求需要一系列的处理工作。
- 业务流的处理，例如，文件审批。
- 对系统进行补充扩展。

#### 1.11 说一说装饰器模式和适配器模式的区别

**参考答案**

装饰器的目的是动态地给一个对象添加一些额外的职责，这个对象的类型不会发生变化，但是行为却发生了改变。

适配器的目的是将一个类的接口变换成客户端所期待的另一种接口，就是可以将一个对象包装成另外的一个接口。

#### 1.12 Spring框架中用到了哪些设计模式？

Spring框架在实现时运用了大量的设计模式，常见的有如下几种：

1. 简单工厂

    Spring中的BeanFactory就是简单工厂模式的体现，根据传入一个唯一的标识来获得Bean对象，但是否是在传入参数后创建还是传入参数前创建这个要根据具体情况来定。

2. 工厂方法

    实现了FactoryBean接口的bean是一类叫做factory的bean。其特点是，spring会在使用getBean()调用获得该bean时，会自动调用该bean的getObject()方法，所以返回的不是factory这个bean，而是这个bean的getOjbect()方法的返回值。

3. 单例模式

    Spring依赖注入Bean实例默认是单例的。Spring的依赖注入（包括lazy-init方式）都是发生在AbstractBeanFactory的getBean里。getBean的doGetBean方法调用getSingleton进行bean的创建。

4. 适配器模式

    SpringMVC中的适配器HandlerAdatper，它会根据Handler规则执行不同的Handler。即DispatcherServlet根据HandlerMapping返回的handler，向HandlerAdatper发起请求处理Handler。HandlerAdapter根据规则找到对应的Handler并让其执行，执行完毕后Handler会向HandlerAdapter返回一个ModelAndView，最后由HandlerAdapter向DispatchServelet返回一个ModelAndView。

5. 装饰器模式

    Spring中用到的装饰器模式在类名上有两种表现：一种是类名中含有Wrapper，另一种是类名中含有Decorator。

6. 代理模式

    AOP底层就是动态代理模式的实现。即：切面在应用运行的时刻被织入。一般情况下，在织入切面时，AOP容器会为目标对象创建动态的创建一个代理对象。SpringAOP就是以这种方式织入切面的。

7. 观察者模式

    Spring的事件驱动模型使用的是观察者模式，Spring中Observer模式常用的地方是listener的实现。

8. 策略模式

    Spring框架的资源访问Resource接口。该接口提供了更强的资源访问能力，Spring 框架本身大量使用了 Resource 接口来访问底层资源。Resource 接口是具体资源访问策略的抽象，也是所有资源访问类所实现的接口。

9. 模板方法模式

    Spring模板方法模式的实质，是模板方法模式和回调模式的结合，是Template Method不需要继承的另一种实现方式。Spring几乎所有的外接扩展都采用这种模式。

## 1. 场景应用

#### 1.1 微信红包相关问题

**参考答案**

概况：2014年微信红包使用数据库硬抗整个流量，2015年使用cache抗流量。

微信的金额什么时候算？

微信红包的金额是拆的时候实时算出来，不是预先分配的，采用的是纯内存计算，不需要预算空间存储。采取实时计算金额的考虑，是因为实时效率很高，而预算需要占存储，预算空间效率低。

为什么明明抢到红包，点开后发现没有？

2014年的红包一点开就知道金额，分两次操作，先抢到金额，然后再转账。2015年的红包的拆和抢是分离的，需要点两次，因此会出现抢到红包了，但点开后告知红包已经被领完的状况。进入到第一个页面不代表抢到，只表示当时红包还有。

红包里的金额怎么算？为什么出现各个红包金额相差很大？

随机，额度在0.01和剩余平均值*2之间。

例如：发100块钱，总共10个红包，那么平均值是10块钱一个，那么发出来的红包的额度在0.01元～20元之间波动。当前面3个红包总共被领了40块钱时，剩下60块钱，总共7个红包，那么这7个红包的额度在：0.01～（60/7*2）=17.14之间。

注意：这里的算法是每被抢一个后，剩下的会再次执行上面的这样的算法。这样算下去，会超过最开始的全部金额，因此到了最后面如果不够这么算，那么会采取如下算法：保证剩余用户能拿到最低1分钱即可。如果前面的人手气不好，那么后面的余额越多，红包额度也就越多，因此实际概率一样的。

红包的设计

微信从财付通拉取金额数据过来，生成个数/红包类型/金额放到redis集群里，app端将红包ID的请求放入请求队列中，如果发现超过红包的个数，直接返回。根据红包的逻辑处理成功得到令牌请求，则由财付通进行一致性调用，通过像比特币一样，两边保存交易记录，交易后交给第三方服务审计，如果交易过程中出现不一致就强制回归。

红包如何计算被抢完？

cache会抵抗无效请求，将无效的请求过滤掉，实际进入到后台的量不大。cache记录红包个数，原子操作进行个数递减，到0表示被抢光。财付通按照20万笔每秒入账准备，但实际还不到8万每秒。

通如何保持8w每秒的写入？

多主sharding，水平扩展机器。

据容量多少？

一个红包只占一条记录，有效期只有几天，因此不需要太多空间。

查询红包分配，压力大不？

抢到红包的人数和红包都在一条cache记录上，没有太大的查询压力。

一个红包一个队列？

没有队列，一个红包一条数据，数据上有一个计数器字段。

有没有从数据上证明每个红包的概率是不是均等？

不是绝对均等，就是一个简单的拍脑袋算法。

拍脑袋算法，会不会出现两个最佳？

会出现金额一样的，但是手气最佳只有一个，先抢到的那个最佳。

每领一个红包就更新数据么？

每抢到一个红包，就cas更新剩余金额和红包个数。

红包如何入库入账？

数据库会累加已经领取的个数与金额，插入一条领取记录，入账则是后台异步操作。

入帐出错怎么办？比如红包个数没了，但余额还有？

最后会有一个take all操作，另外还有一个对账来保障。

#### 1.2 秒杀系统相关问题

**参考答案**

秒杀应该考虑哪些问题？

1. 超卖问题

    分析秒杀的业务场景,最重要的有一点就是超卖问题，假如备货只有100个，但是最终超卖了200，一般来讲秒杀系统的价格都比较低，如果超卖将严重影响公司的财产利益，因此首当其冲的就是解决商品的超卖问题。

2. 高并发

    秒杀具有时间短、并发量大的特点，秒杀持续时间只有几分钟，而一般公司都为了制造轰动效应，会以极低的价格来吸引用户，因此参与抢购的用户会非常的多。短时间内会有大量请求涌进来，后端如何防止并发过高造成缓存击穿或者失效，击垮数据库都是需要考虑的问题。

3. 接口防刷

    现在的秒杀大多都会出来针对秒杀对应的软件，这类软件会模拟不断向后台服务器发起请求，一秒几百次都是很常见的，如何防止这类软件的重复无效请求，防止不断发起的请求也是需要我们针对性考虑的。

4. 秒杀URL

    对于普通用户来讲，看到的只是一个比较简单的秒杀页面，在未达到规定时间，秒杀按钮是灰色的，一旦到达规定时间，灰色按钮变成可点击状态。这部分是针对小白用户的，如果是稍微有点电脑功底的用户，会通过F12看浏览器的network看到秒杀的url，通过特定软件去请求也可以实现秒杀。或者提前知道秒杀url的人，一请求就直接实现秒杀了。这个问题我们需要考虑解决。

5. 数据库设计

    秒杀有把我们服务器击垮的风险，如果让它与我们的其他业务使用在同一个数据库中，耦合在一起，就很有可能牵连和影响其他的业务。如何防止这类问题发生，就算秒杀发生了宕机、服务器卡死问题，也应该让他尽量不影响线上正常进行的业务。

秒杀系统的设计方案

1. 秒杀系统的数据库设计

    针对秒杀的数据库问题，应该单独设计一个秒杀数据库，防止因为秒杀活动的高并发访问拖垮整个网站。这里只需要两张表，一张是秒杀商品表，一张是秒杀库存表：

    订单表（item）：

    

    库存表（item_stock）：

    

    其实应该还有几张表，订单表：可以查到具体的下单时间、订单单价、订单数量、下单金额、参与活动等，还有用户表：根据用户user_id可以查询到用户昵称、用户手机号，收货地址等其他额外信息，这个具体就不给出实例了。

2. 秒杀URL的设计

    为了避免有程序访问经验的人通过下单页面url直接访问后台接口来秒杀货品，我们需要将秒杀的url实现动态化，即使是开发整个系统的人都无法在秒杀开始前知道秒杀的url。具体的做法就是通过md5加密一串随机字符作为秒杀的url，然后前端访问后台获取具体的url，后台校验通过之后才可以继续秒杀。

3. 秒杀页面静态化

    将商品的描述、参数、成交记录、图像、评价等全部写入到一个静态页面，用户请求不需要通过访问后端服务器，不需要经过数据库，直接在前台客户端生成，这样可以最大可能的减少服务器的压力。具体的方法可以使用freemarker模板技术，建立网页模板，填充数据，然后渲染网页。

4. 单体redis升级为集群redis

    秒杀是一个读多写少的场景，使用redis做缓存再合适不过。不过考虑到缓存击穿问题，我们应该构建redis集群，或采用哨兵模式，可以提升redis的性能和可用性。

5. 使用nginx

    nginx是一个高性能web服务器，它的并发能力可以达到几万，而tomcat只有几百。通过nginx映射客户端请求，再分发到后台tomcat服务器集群中可以大大提升并发能力。

6. 精简SQL

    典型的一个场景是在进行扣减库存的时候，传统的做法是先查询库存，再去update。这样的话需要两个sql，而实际上一个sql我们就可以完成的。可以用这样的做法：update miaosha_goods set stock=stock-1 where goos_id={#goods_id} and version=#{version} and sock>0; 。这样的话，就可以保证库存不会超卖并且一次更新库存,还有注意一点这里使用了版本号的乐观锁，相比较悲观锁，它的性能较好。

7. redis预减库存

    很多请求进来，都需要后台查询库存,这是一个频繁读的场景。可以使用redis来预减库存，在秒杀开始前可以在redis设值，比如 redis.set(goodsId,100)，这里预放的库存为100可以设值为常量)，每次下单成功之后，Integer stock = (Integer)redis.get(goosId); 然后判断sock的值，如果小于常量值就减去1。不过注意当取消的时候,需要增加库存，增加库存的时候也得注意不能大于之间设定的总库存数(查询库存和扣减库存需要原子操作，此时可以借助lua脚本)下次下单再获取库存的时候,直接从redis里面查就可以了。

8. 接口限流

    秒杀最终的本质是数据库的更新，但是有很多大量无效的请求，我们最终要做的就是如何把这些无效的请求过滤掉，防止渗透到数据库。限流的话，需要入手的方面很多：

    - 前端限流：首先第一步就是通过前端限流，用户在秒杀按钮点击以后发起请求，那么在接下来的5秒是无法点击（通过设置按钮为disable）。这一小举措开发起来成本很小，但是很有效。
    - 同一个用户x秒内重复请求直接拒绝：具体多少秒需要根据实际业务和秒杀的人数而定，一般限定为10秒。具体的做法就是通过redis的键过期策略，首先对每个请求都从String value = redis.get(userId);。如果获取到这个value为空或者为null，表示它是有效的请求，然后放行这个请求。如果不为空表示它是重复性请求，直接丢掉这个请求。如果有效,采用redis.setexpire(userId,value,10).value 可以是任意值，一般放业务属性比较好,这个是设置以userId为key，10秒的过期时间（10秒后,key对应的值自动为null）。
    - 令牌桶算法限流：接口限流的策略有很多，我们这里采用令牌桶算法。令牌桶算法的基本思路是每个请求尝试获取一个令牌，后端只处理持有令牌的请求，生产令牌的速度和效率我们都可以自己限定。

9. 异步下单

    为了提升下单的效率，并且防止下单服务的失败。需要将下单这一操作进行异步处理。最常采用的办法是使用队列，队列最显著的三个优点：异步、削峰、解耦。这里可以采用rabbitmq，在后台经过了限流、库存校验之后，流入到这一步骤的就是有效请求。然后发送到队列里，队列接受消息，异步下单。下完单，入库没有问题可以用短信通知用户秒杀成功。假如失败的话，可以采用补偿机制，重试。

10. 服务降级

    假如在秒杀过程中出现了某个服务器宕机，或者服务不可用，应该做好后备工作。之前的博客里有介绍通过Hystrix进行服务熔断和降级，可以开发一个备用服务，假如服务器真的宕机了，直接给用户一个友好的提示返回，而不是直接卡死，服务器错误等生硬的反馈。

#### 1.3 扫码登录流程

**参考答案**

什么是二维码？

> 二维码又称二维条码，常见的二维码为QR Code，QR全称Quick Response，是一个近几年来移动设备上超流行的一种编码方式，它比传统的Bar Code条形码能存更多的信息，也能表示更多的数据类型。-- 百度百科

在商品上，一般都会有条形码，条形码也称为一维码，条形码只能表示一串数字。二维码要比条形码丰富很多，可以存储数字、字符串、图片、文件等，比如我们可以把 [www.nowcoder.com](http://www.nowcoder.com/) 存储在二维码中，扫码二维码我们就可以获取到牛客网的地址。

移动端基于token的认证机制

在了解扫码登录原理之前，有必要先了解移动端基于 token 的认证机制，对理解扫码登录原理还是非常有帮助的。基于 token 的认证机制跟我们常用的账号密码认证方式有较大的不同，安全系数比账号密码要高，如果每次验证都传入账号密码，那么被劫持的概率就变大了。

基于 token 的认证机制流程图，如下图所示：



基于 token 的认证机制，只有在第一次使用需要输入账号密码，后续使用将不在输入账号密码。其实在登陆的时候不仅传入账号、密码，还传入了手机的设备信息。在服务端验证账号、密码正确后，服务端会做两件事。

1. 将账号与设备关联起来，在某种意义上，设备信息就代表着账号。
2. 生成一个 token 令牌，并且在 token 与账号、设备关联，类似于key/value，token 作为 key ，账号、设备信息作为value，持久化在磁盘上。

将 token 返回给移动端，移动端将 token 存入在本地，往后移动端都通过 token 访问服务端 API ，当然除了 token 之外，还需要携带设备信息，因为 token 可能会被劫持。带上设备信息之后，就算 token 被劫持也没有关系，因为设备信息是唯一的。

这就是基于 token 的认证机制，将账号密码换成了 token、设备信息，从而提高了安全系数，可别小看这个 token ，token 是身份凭证，在扫码登录的时候也会用到。

二维码扫码登录的原理

好了，知道了移动端基于 token 的认证机制后，接下来就进入我们的主题：二维码扫码登陆的原理。先上二维码扫码登录的流程图：



扫码登录可以分为三个阶段：待扫描、已扫描待确认、已确认。我们就来看看这三个阶段。

1. 带扫描阶段

    待扫描阶段也就是流程图中 1~5 阶段，即生成二维码阶段，这个阶段跟移动端没有关系，是 PC 端跟服务端的交互过程。

    首先 PC 端携带设备信息想服务端发起生成二维码请求，服务端会生成唯一的二维码 ID，你可以理解为 UUID，并且将 二维码 ID 跟 PC 设备信息关联起来，这跟移动端登录有点相似。

    PC 端接受到二维码 ID 之后，将二维码 ID 以二维码的形式展示，等待移动端扫码。此时在 PC 端会启动一个定时器，轮询查询二维码的状态。如果移动端未扫描的话，那么一段时间后二维码将会失效。

2. 已扫码待确认阶段

    流程图中第 6 ~ 10 阶段，我们在 PC 端登录微信时，手机扫码后，PC 端的二维码会变成已扫码，请在手机端确认。这个阶段是移动端跟服务端交互的过程。

    首先移动端扫描二维码，获取二维码 ID，然后将手机端登录的信息凭证（token）和 二维码 ID 作为参数发送给服务端，此时的手机一定是登录的，不存在没登录的情况。

    服务端接受请求后，会将 token 与二维码 ID 关联，为什么需要关联呢？你想想，我们使用微信时，移动端退出， PC 端是不是也需要退出，这个关联就有点把子作用了。然后会生成一个一次性 token，这个 token 会返回给移动端，一次性 token 用作确认时候的凭证。

然后PC 端的定时器，会轮询到二维码的状态已经发生变化，会将 PC 端的二维码更新为已扫描，请确认。

1. 已确认

    流程图中的 第 11 ~ 15 步骤，这是扫码登录的最后阶段，移动端携带上一步骤中获取的临时 token ，确认登录，服务端校对完成后，会更新二维码状态，并且给 PC 端生成一个正式的 token ，后续 PC 端就是持有这个 token 访问服务端。

    PC 端的定时器，轮询到了二维码状态为登录状态，并且会获取到了生成的 token ，完成登录，后续访问都基于 token 完成。

    在服务器端会跟手机端一样，维护着 token 跟二维码、PC 设备信息、账号等信息。

#### 1.4 如何实现单点登录？

**参考答案**

单点登录全称Single Sign On（以下简称SSO），是指在多系统应用群中登录一个系统，便可在其他所有系统中得到授权而无需再次登录，包括单点登录与单点注销两部分。

登录

相比于单系统登录，sso需要一个独立的认证中心，只有认证中心能接受用户的用户名密码等安全信息，其他系统不提供登录入口，只接受认证中心的间接授权。间接授权通过令牌实现，sso认证中心验证用户的用户名密码没问题，创建授权令牌，在接下来的跳转过程中，授权令牌作为参数发送给各个子系统，子系统拿到令牌，即得到了授权，可以借此创建局部会话，局部会话登录方式与单系统的登录方式相同。这个过程，也就是单点登录的原理，用下图说明：



下面对上图简要描述：

1. 用户访问系统1的受保护资源，系统1发现用户未登录，跳转至sso认证中心，并将自己的地址作为参数；
2. sso认证中心发现用户未登录，将用户引导至登录页面；
3. 用户输入用户名密码提交登录申请；
4. sso认证中心校验用户信息，创建用户与sso认证中心之间的会话，称为全局会话，同时创建授权令牌；
5. sso认证中心带着令牌跳转会最初的请求地址（系统1）；
6. 系统1拿到令牌，去sso认证中心校验令牌是否有效；
7. sso认证中心校验令牌，返回有效，注册系统1；
8. 系统1使用该令牌创建与用户的会话，称为局部会话，返回受保护资源；
9. 用户访问系统2的受保护资源；
10. 系统2发现用户未登录，跳转至sso认证中心，并将自己的地址作为参数；
11. sso认证中心发现用户已登录，跳转回系统2的地址，并附上令牌；
12. 系统2拿到令牌，去sso认证中心校验令牌是否有效；
13. sso认证中心校验令牌，返回有效，注册系统2；
14. 系统2使用该令牌创建与用户的局部会话，返回受保护资源。

用户登录成功之后，会与sso认证中心及各个子系统建立会话，用户与sso认证中心建立的会话称为全局会话，用户与各个子系统建立的会话称为局部会话，局部会话建立之后，用户访问子系统受保护资源将不再通过sso认证中心，全局会话与局部会话有如下约束关系：

- 局部会话存在，全局会话一定存在；
- 全局会话存在，局部会话不一定存在；
- 全局会话销毁，局部会话必须销毁。

注销

单点登录自然也要单点注销，在一个子系统中注销，所有子系统的会话都将被销毁，用下面的图来说明：



sso认证中心一直监听全局会话的状态，一旦全局会话销毁，监听器将通知所有注册系统执行注销操作。下面对上图简要说明：

1. 用户向系统1发起注销请求；
2. 系统1根据用户与系统1建立的会话id拿到令牌，向sso认证中心发起注销请求；
3. sso认证中心校验令牌有效，销毁全局会话，同时取出所有用此令牌注册的系统地址；
4. sso认证中心向所有注册系统发起注销请求；
5. 各注册系统接收sso认证中心的注销请求，销毁局部会话；
6. sso认证中心引导用户至登录页面。

部署

单点登录涉及sso认证中心与众子系统，子系统与sso认证中心需要通信以交换令牌、校验令牌及发起注销请求，因而子系统必须集成sso的客户端，sso认证中心则是sso服务端，整个单点登录过程实质是sso客户端与服务端通信的过程，用下图描述：



sso认证中心与sso客户端通信方式有多种，这里以简单好用的httpClient为例，web service、rpc、restful api都可以。

#### 1.5 如何设计一个本地缓存？

**参考答案**

想要设计一个本地缓存，考虑点主要在数据用何种方式存储，能存储多少数据，多余的数据如何处理等几个点，下面我们来详细的介绍每个考虑点：

1. 数据结构

    首要考虑的就是数据该如何存储，用什么数据结构存储。最简单的就直接用Map来存储数据，或者复杂的如redis一样提供了多种数据类型哈希，列表，集合，有序集合等，底层使用了双端链表，压缩列表，集合，跳跃表等数据结构。

2. 对象上限

    因为是本地缓存，内存有上限，所以一般都会指定缓存对象的数量比如1024，当达到某个上限后需要有某种策略去删除多余的数据。

3. 清除策略

    上面说到当达到对象上限之后需要有清除策略，常见的比如有LRU(最近最少使用)、FIFO(先进先出)、LFU(最近最不常用)、SOFT(软引用)、WEAK(弱引用)等策略。

4. 过期时间

    除了使用清除策略，一般本地缓存也会有一个过期时间设置，比如redis可以给每个key设置一个过期时间，这样当达到过期时间之后直接删除，采用清除策略+过期时间双重保证。

5. 线程安全

    像redis是直接使用单线程处理，所以就不存在线程安全问题。而我们现在提供的本地缓存往往是可以多个线程同时访问的，所以线程安全是不容忽视的问题，并且线程安全问题是不应该抛给使用者去保证。

6. 简明的接口

    提供一个傻瓜式的对外接口是很有必要的，对使用者来说使用此缓存不是一种负担而是一种享受，提供常用的get，put，remove，clear，getSize等方法即可。

7. 是否持久化

    这个其实不是必须的，是否需要将缓存数据持久化看需求。本地缓存如ehcache是支持持久化的，而guava是没有持久化功能的。分布式缓存如redis是有持久化功能的，memcached是没有持久化功能的。

8. 阻塞机制

    我们使用缓存的目的就是因为被缓存的数据生成比较费时，比如调用对外的接口，查询数据库，计算量很大的结果等等。这时候如果多个线程同时调用get方法获取的结果都为null，每个线程都去执行一遍费时的计算，其实也是对资源的浪费。最好的办法是只有一个线程去执行，其他线程等待，计算一次就够了。但是此功能基本上都交给使用者来处理，很少有本地缓存有这种功能。

## ● 请你讲讲UML中有哪些常用的图？

考察点：用例图

### 参考回答：

UML定义了多种图形化的符号来描述软件系统部分或全部的静态结构和动态结构，包括：用例图（use case diagram）、类图（class diagram）、时序图（sequence diagram）、协作图（collaboration diagram）、状态图（statechart diagram）、活动图（activity diagram）、构件图（component diagram）、部署图（deployment diagram）等。在这些图形化符号中，有三种图最为重要，分别是：用例图（用来捕获需求，描述系统的功能，通过该图可以迅速的了解系统的功能模块及其关系）、类图（描述类以及类与类之间的关系，通过该图可以快速了解系统）、时序图（描述执行特定任务时对象之间的交互关系以及执行顺序，通过该图可以了解对象能接收的消息也就是说对象能够向外界提供的服务）。

**统一建模语言**(Unified Modeling Language，UML)是一种为[面向对象](https://baike.baidu.com/item/面向对象/2262089)系统的产品进行说明、可视化和编制文档的一种标准语言。UML使用面向对象设计的建模工具，但独立于任何具体程序设计语言。

**作用**：

(1)为软件系统建立可视化模型。



(2)为软件系统建立构件。



(3)为软件系统建立文档。

**UML系统开发中有三个主要的模型**： 

- **功能模型**：从用户的角度展示系统的功能，包括用例图。
- **对象模型**：采用对象，属性，操作，关联等概念展示系统的结构和基础，包括类别图、对象图。
- **动态模型**：展现系统的内部行为。包括序列图，活动图，状态图。 