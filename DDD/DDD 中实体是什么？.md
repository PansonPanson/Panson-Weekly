# DDD 实体是什么？

在领域驱动设计（DDD，Domain-Driven Design）中，**实体（Entity）** 是领域模型中的一个重要概念。实体是指具有唯一标识符，并且通过标识符而不是属性判断其身份的对象。

---

## 实体的核心特征

1. **唯一标识符（Identity）**  
   实体的身份由唯一标识符决定，即使它的属性发生变化，只要标识符相同，它仍然是同一个实体。例如：
    - 一个“用户”可能会更改姓名或邮箱，但只要用户的 `UserID` 没变，它仍然是同一个用户。
    - 在电商系统中，“订单”可能会修改商品列表或状态，但只要订单的 `OrderID` 没变，它就仍然是同一个订单。

2. **状态变化（Mutable State）**  
   实体的属性可以随着时间发生变化，但这种变化不会改变它的身份。例如：
    - 一个订单的状态可以从“已创建”变为“已发货”，但它的 `OrderID` 不会因此改变。

3. **生命周期（Lifecycle）**  
   实体通常具有明确的生命周期，从创建、状态变化到销毁。生命周期管理是实体建模的重要部分。

---

## 实体的作用

实体在领域建模中主要用于表示业务中需要跟踪的对象，它们通常是领域逻辑的核心。通过实体，能够捕捉和表达业务的核心概念，例如用户、订单、商品等。

---

## 设计实体时的注意事项

1. **关注标识符，而不是属性**
    - 实体的身份由标识符决定，而不是其属性。例如，即使两个用户有相同的姓名和邮箱，只要它们的 `UserID` 不同，它们就是两个独立的实体。

2. **避免属性膨胀**
    - 实体应该只包含它负责的业务属性，不应包含不属于其职责范围的内容。例如，订单实体不应该直接包含客户的详细信息，而应该通过关联来获取。

3. **遵循领域规则**
    - 实体应该封装与自身相关的领域逻辑，避免成为简单的“数据容器”。例如，订单实体可以包含一个方法 `calculateTotalPrice()` 来计算订单总价，而不是在服务层完成此逻辑。

4. **保持一致性**
    - 实体的状态应该始终保持一致。例如，订单实体在“已取消”状态下不应该允许添加商品。

---

## 实体的代码示例

以下是一个简单的实体类示例：

```java
public class Order {
    private String orderId; // 唯一标识符
    private List<OrderItem> items; // 订单项
    private OrderStatus status; // 订单状态

    public Order(String orderId) {
        this.orderId = orderId;
        this.items = new ArrayList<>();
        this.status = OrderStatus.CREATED;
    }

    public String getOrderId() {
        return orderId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void addItem(OrderItem item) {
        if (this.status == OrderStatus.CANCELED) {
            throw new IllegalStateException("Cannot add items to a canceled order.");
        }
        this.items.add(item);
    }

    public void cancelOrder() {
        if (this.status == OrderStatus.SHIPPED) {
            throw new IllegalStateException("Cannot cancel a shipped order.");
        }
        this.status = OrderStatus.CANCELED;
    }
}
 ```
    
    
说明：
1. 唯一标识符：orderId 是订单的唯一标识符，用于区分不同的订单。
2. 领域逻辑：addItem 方法和 cancelOrder 方法封装了与订单相关的业务规则，防止非法操作。
3. 状态管理：订单的状态通过 status 字段管理，并且通过领域逻辑确保状态的合法性。

# 典型场景中的实体
## 1. 用户管理系统
+ 实体：用户（User）、角色（Role）
+ 标识符：UserID、RoleID

## 2. 电商系统
+ 实体：订单（Order）、商品（Product）、客户（Customer）
+ 标识符：OrderID、ProductID、CustomerID

## 3. 银行系统
+ 实体：账户（Account）、交易（Transaction）
+ 标识符：AccountID、TransactionID

# 总结
在 DDD 中，实体是表示业务中需要跟踪的核心对象，它们的身份由唯一标识符决定。实体不仅仅是数据的载体，还应该封装与自身相关的领域逻辑，从而更好地反映业务规则和需求。在设计实体时，需要关注唯一标识符、状态管理和领域逻辑，以确保实体模型与业务需求准确对齐。
