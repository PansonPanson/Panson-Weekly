# DDD 聚合（Domain-Driven Design - Aggregates）

在领域驱动设计 (DDD) 中，**聚合 (Aggregate)** 是一种重要的战术建模工具，用于定义和管理领域模型中的一致性边界。以下是聚合的核心概念和设计原则：

---

## 什么是聚合？
- **聚合** 是一组具有内在关联的对象聚合在一起，作为一个整体来处理。
- 聚合定义了一个 **一致性边界**，边界内的数据必须保持一致性。
- 每个聚合都有一个 **聚合根 (Aggregate Root)**，它是聚合中唯一对外暴露的入口点。

---

## 聚合的组成
1. **聚合根 (Aggregate Root)**:
    - 聚合的入口点，负责对外暴露行为。
    - 通过聚合根管理整个聚合内部的状态。
    - 聚合根是全局唯一的，可以通过唯一标识符 (ID) 进行引用。

2. **聚合内的实体 (Entity)**:
    - 聚合内部的其他对象，通常有自己的标识符，但不能被外部直接访问。
    - 它们依赖聚合根来管理生命周期。

3. **聚合内的值对象 (Value Object)**:
    - 不可变、无标识符的对象，通常用于描述属性或行为。

---

## 聚合的设计原则
1. **单一入口点**:
    - 只能通过聚合根来操作聚合内部的实体或值对象。
    - 不允许外部直接修改聚合内部的任何对象。

2. **一致性边界**:
    - 聚合内部的数据必须在事务范围内保持一致。
    - 一次事务仅能操作一个聚合，跨聚合的事务需要通过领域事件或其他机制处理。

3. **控制聚合的大小**:
    - 聚合不宜过大，过大的聚合会导致性能问题和复杂性增加。
    - 聚合应该遵循“**最小化修改冲突**”的原则。

4. **引用规则**:
    - 聚合之间不能直接引用其他聚合的内部对象，只能通过聚合根的标识符 (ID) 进行引用。

---

## 示例
以下是一个典型的电商订单聚合的示例：

### 聚合描述
- 聚合名称：订单 (Order)
- 聚合根：订单 (Order)
- 内部实体：订单项 (OrderItem)
- 值对象：地址 (Address)

### 示例代码
```csharp
public class Order
{
    // 聚合根的标识符
    public Guid Id { get; private set; }

    // 值对象
    public Address ShippingAddress { get; private set; }

    // 内部实体集合
    private List<OrderItem> _orderItems;
    public IReadOnlyCollection<OrderItem> OrderItems => _orderItems.AsReadOnly();

    public Order(Guid id, Address shippingAddress)
    {
        Id = id;
        ShippingAddress = shippingAddress;
        _orderItems = new List<OrderItem>();
    }

    // 聚合根的行为方法
    public void AddOrderItem(Guid productId, int quantity, decimal price)
    {
        var orderItem = new OrderItem(productId, quantity, price);
        _orderItems.Add(orderItem);
    }
}

public class OrderItem
{
    public Guid ProductId { get; private set; }
    public int Quantity { get; private set; }
    public decimal Price { get; private set; }

    public OrderItem(Guid productId, int quantity, decimal price)
    {
        ProductId = productId;
        Quantity = quantity;
        Price = price;
    }
}

public class Address
{
    public string Street { get; private set; }
    public string City { get; private set; }
    public string ZipCode { get; private set; }

    public Address(string street, string city, string zipCode)
    {
        Street = street;
        City = city;
        ZipCode = zipCode;
    }
}
```

## 聚合的优缺点
### 优点
+ 保证一致性：聚合的设计通过一致性边界确保数据的完整性。
+ 简化复杂性：将领域模型划分为更小的模块，便于管理。
+ 解耦：聚合之间通过标识符交互，降低了耦合度。

### 缺点
+ 事务范围限制：一次事务只能操作一个聚合，可能需要额外的领域事件协调跨聚合逻辑。
+ 性能权衡：过大的聚合会导致性能问题，过小的聚合会增加协调复杂性。 

## 使用场景
+ 订单系统：订单及其订单项。
+ 库存管理：产品及其库存状态。
+ 用户管理：用户及其权限。

# 总结
聚合是 DDD 中管理复杂性和保持一致性的核心工具。通过定义清晰的一致性边界和职责分离，聚合能够帮助开发者构建可维护、扩展性强的领域模型。但在实际使用中，需要根据具体场景平衡聚合的大小和复杂性。