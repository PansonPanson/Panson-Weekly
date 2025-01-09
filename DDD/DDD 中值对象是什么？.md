# 值对象是什么？

在领域驱动设计（DDD，Domain-Driven Design）中，**值对象（Value Object）** 是领域模型中的一个重要概念。它表示的是一组有意义的属性组合，通常用来描述某种特性或概念，但它不依赖于唯一标识符来区分身份。

与实体（Entity）不同，值对象的身份不重要，重要的是它的值。如果两个值对象的属性值相同，那么它们就是等价的。

---

## 值对象的核心特征

1. **无唯一标识符**
   - 值对象不需要唯一标识符来区分实例。它们通过属性值来判断是否相等。
   - 例如，`Money` 可以用金额（数值）和货币类型（例如：USD、EUR）来描述。如果两个 `Money` 对象的值相同，它们就被认为是一样的。

2. **不可变性（Immutability）**
   - 值对象应该是不可变的。一旦创建，其属性就不能被修改。如果需要不同的值，应该创建新的值对象。
   - 不可变性可以提高代码的安全性和可预测性，特别是在并发环境中。

3. **轻量级**
   - 值对象通常是轻量级的，仅用于定义对象的属性和行为，而不会包含复杂的业务逻辑。

4. **依赖于值的相等性**
   - 值对象的相等性通过比较其所有属性的值来判断，而不是通过引用或对象的唯一性。

---

## 值对象的作用

值对象在领域建模中用于表示**一个完整的概念或属性的组合**，并且可以作为实体或其他值对象的属性。它们帮助我们更直观地表达领域模型。

- 通过值对象，我们可以避免将过多的属性直接放入实体中，从而减少实体的复杂度。
- 值对象可以更好地复用，提升代码的可读性和一致性。

---

## 值对象与实体的区别

| 特性               | 值对象（Value Object）                 | 实体（Entity）                           |
|--------------------|---------------------------------------|------------------------------------------|
| 唯一标识           | 没有唯一标识，依赖值的相等性          | 必须有唯一标识，依赖标识符判断身份       |
| 状态变化           | 不可变，一旦创建不能修改              | 可变，状态随着业务操作而改变             |
| 生命周期           | 通常被包含在实体中，生命周期依赖实体  | 独立存在，具有自己的生命周期             |
| 设计目的           | 表示一个属性或属性组合的值            | 表示具有业务身份的重要对象               |

---

## 设计值对象时的注意事项

1. **保持不可变性**
   - 通过将所有字段声明为 `final` 或只提供只读访问器来实现不可变性。
   - 修改值对象时，创建一个新实例，而不是修改原来的对象。

2. **实现值相等性**
   - 值对象应该重写 `equals` 和 `hashCode` 方法，确保相等性是基于值的比较，而不是基于对象的引用。

3. **表达领域概念**
   - 值对象应该能清晰地表达领域中的某种意义或特性。例如：地址、金额、坐标等。

4. **避免过多行为**
   - 值对象的行为应该与其表示的领域概念紧密相关，不应包含与其职责无关的逻辑。

---

## 值对象的代码示例

以下是一个值对象的示例：表示一个货币金额（`Money`）。

```java
public final class Money {
    private final double amount; // 金额
    private final String currency; // 货币单位

    public Money(double amount, String currency) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        if (currency == null || currency.isEmpty()) {
            throw new IllegalArgumentException("Currency cannot be null or empty");
        }
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    // 加法操作
    public Money add(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Currencies must match to add amounts");
        }
        return new Money(this.amount + other.amount, this.currency);
    }

    // 重写 equals 方法，基于值比较
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Double.compare(money.amount, amount) == 0 &&
               currency.equals(money.currency);
    }

    // 重写 hashCode 方法
    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
```
示例说明：
+ 不可变性：Money 的所有字段是 final，并且没有提供修改器方法。
+ 领域逻辑：add 方法封装了金额加法的逻辑，同时确保货币类型一致。
+ 值相等性：equals 方法基于 amount 和 currency 进行比较，而不是基于引用。

# 典型场景中的值对象
## 1. 电子商务系统
+ 值对象：Money（金额），Address（地址）
+ 示例：订单金额、配送地址

## 2. 地图服务系统
+ 值对象：Coordinate（坐标），Distance（距离）
+ 示例：用户位置、两点之间的距离

## 3. 银行系统
+ 值对象：Money（金额），InterestRate（利率）
+ 示例：账户余额、贷款利率

# 总结
在 DDD 中，值对象是通过属性值来判断身份的一种对象，用于清晰表达领域中的特定概念。它们没有唯一标识符，通常是不可变的，并且可以复用。在建模时，值对象可以有效地降低实体的复杂性，同时提升代码的可读性、可维护性和一致性。