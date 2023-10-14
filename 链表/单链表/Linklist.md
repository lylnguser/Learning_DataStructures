# 链表

- 链表是有序的列表 

## 单链表(线性链表)

存储特点：用一组任意的存储单元存储线性表的数据元素(这组存储单元可以是连续的，也可以是不连续的)。
单链表示意图：

![!\[Alt text\](/photo/LinkedListStorageMethod.png)](photo/LinkedListStorageMethod.png)

- 结点：存储本身的信息外，还需要存储一个指示其直接后继的信息。这两部分信息组成了数据元素的映像，称为结点。
    - 数据域：存储数据元素信息的域；
    - 指针域：存储直接后继存储位置的域。指针域中存储的信息称作指针或链。
    - n个结点链结成一个链表，即线性表的链式存储结构。
    - 链表的每个结点中只包含一个指针域

- head结点
1. 不存放具体的数据
2. 作用就是表示单链表头


> 遍历单链表

- 在遍历过程中，head结点不能动，即需要一个辅助变量(HeroNode temp = head;)来辅助进行遍历
- 判断是否到单链表末端,判断条件是temp.next == null

```java
HeroNode temp = head;
while(true){
    // 判断是否已经到链表末端
    if(temp.next == null){
        break;
    }
    // 在进行后移之前，将temp的data域进行显示
    // 其中，temp表示的引用数据，即在类中添加重写方法，才能打印出data中的数据
    System.out.println(temp);   
    // 如果没有到达末端，即需要辅助变量进行后移
    temp  = temp.next;
}

// 结束后即对链表进行了遍历
```

> 插入链表方式1(末尾添加，不考虑其他因素)
- 首先需要找到链表末端结点，即与遍历相似
- 将末端结点的next域指向新结点
```java

public void addHero1(HeroNode heroNode){
    // 找到链表末端结点
    // 因为head结点不能动，添加一个辅助结点(HeroNode temp = head;)
    HeroNode temp = head;
    while(true){
        // 判断是否到最后结点
        if(temp.next == null){
            // 添加新结点
            temp.next = heroNode;
        }
        // 没有到达末端结点，temp后移
        temp = temp.next;
    }
}
```

> 插入方式2(即对链表的位置有特殊要求)  
例如，用单链表来存储水浒传英雄人物,即有一个英雄排名no,需要插入的英雄保持排名

```java
public void addHero2(HeroNode heroNode){
    // 由头结点不能动，需要一个辅助结点temp
    HeroNode temp = head;
    // 如果链表为空，即直接添加
    if(head.next == null){
        temp.next = heroNode;
    }

    // 通过循环找到添加的位置坐标
    boolean flag == false;
    while(true){
        // 判断链表是空表或者是到达链表末端结点
        if(temp.next == null){
            break;
        }
        // 判断添加结点的no是否已经存在
        // 判断no的添加位置，即添加的位置的后一个结点的no大于本位置即可
        if(temp.next.no == heroNode.no){
            flag = true;
            break;
        }else if(temp.next.no > heroNode.no){
            break;
        }
        // 位置移动
        temp = temp.next;
    }

    // 循环结束，即temp在一个位置上
    // 判断flag的值是否为true
    if(flag){
        System.out.printf("所添加的英雄%d已存在，无法添加")
    }else{
        heroNode.next = temp.next;
        temp.next = heroNode;
    }
}
```
> 修改链表数据

思路：   
首先，先将所要修改的存储数据的结点找到，然后进行修改

```java

// 传递的参数可以是这个值，也可以是一个结点newHeroNode
public void updateNode(int number,String name,String nickName){
    // head结点不能动，
    HeroNode temp = head;
    // 定义boolean型数据flag,用于得到是否找到修改结点位置
    boolean flag = false;

    while(true){
        // 遍历链表
        if(temp.next = null){
            // 链表已经达到最后，或者空链表
            break;
        }
        // 这里使用temp.next作为指定位置时，时为了防止修改最后一个结点时
        // 在上一步判断就是直接退出了，明明有数据
        // 结果显示的却是没有找到数据而没有进行修改
        if(temp.next.no == number){
            // 即位置找到，falg == true,然后退出循环，防止temp继续后移
            flag = true;
        }
        temp = temp.next;
    }
    // 利用flag的值进行判断是否找到位置
    if(flag){
        temp.next.heroName = name;
        temp.next.nickName = nickName;
    }else{
        System.out.printf("所要修改的英雄编号%d未找到，无法执行修改操作",number);
    }
}
```

> 单链表删除结点

思路：  
首先找到待删除结点的前一个结点，然后将指针进行重新指向，即可删除结点

```java
public void deleteNode(HeroNode deleteNode){
    // 头结点不能动，故，需要一个辅助变量

    HeroNode temp = head;
    boolean flag = false;
    while(true){
        // 到末结点
        if(temp.next == null){
            break;
        }
        if(temp.next.no == deleteNode.no){
            flag = true;
            break;
        }
        // temp后移

        temp = temp.next;
    }
    // 循环结束，确定要删除的位置
    if(flag){
        temp.next = temp.next.next; // 直接将指针指向后一个结点
    }else{
        System.out.printf("待删除的英雄编号%d未在数据中，无法执行删除操作");
    }
}

    // 被删除的结点，不会由其他引用指向，会被jvm垃圾回收机制进行回收
    // 即，不考虑删除的结点
```