# lab 7

---

# 1: Use Polymorphism

کلاس `CodeGenerator` دارای یک switchCase بسیار بزرگ است که به وضوح به نقض اصل Open-Closed پرداخته است. حال آنکه می‌توان به جای اینکه رفتار مورد نظر را بر اساس نوع تابع و از طریق این switchCase فراخوانی کرد، می‌توان از رویکرد polymorphic استفاده کرده و آن را در قالب کلاس‌های مجزا تحت عنوان Operator انجام دهیم.
در نتیجه، کلاس‌های مختلف پکیج Operators را بر همین اساس ایجاد و از الگوی Strategy استفاده کردیم.

همچنین برای رجیستر شدن پیاده‌سازی‌های مختلف اینترفیس Operator از مکانیزم reflection در جاوا استفاده کردیم تا فرایند رجیستر شدن به صورت اتومات صورت بگیرد و اصل OCP به صورت تمیز‌تری رعایت شود.

# 2: Separate Query from Modifier

در کلاس `Memory` متود `getTemp()` را به دو متود `getTemp` و `updateTempIndex` شکستیم.
همچنین برای متود `getDateAddress` نیز چنین کردیم.

# 3: Self-Encapsulated Field

در همان کلاس `Memory` برای فیلد `codeblock` یک `protected getter` اضافه کردیم و در دیگر قسمت‌های کلاس از آن استفاده نمودیم.
همچنین برای کلاس داخلی \_`3AddressCode` مشابه این کار را انجام دادیم. توجه شود که در این کلاس داخلی، فیلد‌ها نیز به صورت `public` تعریف شده‌بودند که آن‌ها نیز به حالت `private` تغییر داده شدند.

# 4: Extract Method

در کلاس parseTable یک فرایند initialization داشتیم که آن را به سه متود کوچکتر شکاندیم. البته که شکاندن متود‌ها به حالت‌های ریزتر نیز امکان‌پذیر بود اما صرفا در این تمرین به انجام یکی از این حالات بسنده نمودیم.
به طور مثال بسیاری از عبارات درون if، قابل استخراج هستند تا در یک متود با نام مناسب و معنای بیشتر شرط آن‌ها چک شود.

# 5: Extract Class

با توجه به اینکه در برخی موارد لازم بود متن فایل‌ها مورد استفاده قرار بگیرد، تلاش شد که استفاده گسترده و نامتعارف از عملیات‌های مربوط به خواندن فایل، در یک کلاس واحد FileReader مجتمع شود و استفاده‌های فعلی با فراخوانی توابع این کلاس جایگزین شوند.

# 6: Facade

برای انجام `Facade` از دو کلاس Parser و Memory استفاده می‌کنیم. کلاس Parser برای پیاده‌سازی Facade مناسب است، زیرا این کلاس از چندین سیستم و عملیات پیچیده استفاده می‌کند که می‌توانند در یک رابط ساده‌تر و یکپارچه توسط یک `Facade` مدیریت شوند. این سیستم‌های پیچیده شامل اجزای مختلفی هستند که در صورتی که کاربر بخواهد به‌طور مستقیم از آن‌ها استفاده کند، پیچیدگی زیادی را به دنبال خواهند داشت.
کلاس Memory نیز برای ایجاد یک `Facade` مناسب‌ است به این دلیل که این کلاس بیشتر با داده‌ها و آدرس‌ها سر و کار دارد و شامل عملیات‌هایی است که می‌توان آن‌ها را در یک `Facade` ساده و یکپارچه‌سازی شده قرار داد.

# add plugin

برای اضافه کردن formatter-plugin باید طبق توضیحات داده شده از تکه کد

```
      <plugin>
        <groupId>net.revelc.code.formatter</groupId>
        <artifactId>formatter-maven-plugin</artifactId>
        <version>2.24.2-SNAPSHOT</version>
      </plugin>
```

استفاده می‌کردیم اما با ارور `Unresolved plugin: 'net.revelc.code.formatter:formatter-maven-plugin:2.14.1'` روبرو شدیم که به این دلیل بود که پلاگین formatter-maven-plugin در نسخه 2.14.1 از گروه net.revelc.code.formatter به طور رسمی در مخزن Maven موجود نیست یا در دسترس نمی‌باشد. به همین دلیل به استفاده از یک پلاگین جایگزین روی آوردیم. از پلاگین spotless-maven-plugin استفاده کردیم که در این پلاگین با استفاده از دستور `mvn spotless:apply` می‌توان کد را فرمت کرد. نتیجه فرمت کد را در تصویر زیر مشاهده می‌کنید:

![Screenshot 2024-12-23 020406](https://github.com/user-attachments/assets/5bf1cf1e-365a-4282-a875-3d3dd82ef67c)

---

# Answers of the additional questions:

## Question #1:

### Clean Code:

Code that is easy to read, understand, and maintain, adhering to best practices and coding standards.

### Technical Debt:

The cost of fixing shortcuts or suboptimal solutions implemented for quick delivery, which affects future development.

### Code Smells:

Symptoms in the code that indicate potential issues or poor design, suggesting the need for refactoring.

## Question #2:

### Bloaters:

These are code smells caused by excessive growth of code elements like classes, methods, or parameter lists. They make the code harder to manage and understand over time. Examples include _Long Method, Large Class, and Primitive Obsession._

### Object-Orientation Abusers:

These smells arise when object-oriented programming principles are incorrectly applied, resulting in inefficient or flawed designs. Examples include _Switch Statements, Refused Bequest, and Temporary Field._

### Change Preventers:

These smells indicate that modifying one part of the code requires multiple related changes in other places, increasing complexity and cost of development. Examples include _Divergent Change and Shotgun Surgery._

### Dispensables:

These are unnecessary or redundant parts of the code that, when removed, improve readability and maintainability. Examples include _Duplicate Code, Comments, Dead Code, and Lazy Class._

### Couplers:

These smells occur due to excessive coupling (dependency) between classes or components, making the system tightly bound and harder to modify. Examples include _Feature Envy, Message Chains, and Middle Man._

## Question #3:

### Category:

The Lazy Class code smell belongs to the _Dispensables_ category.

### Suggested Refactorings:

- Inline Class: If the Lazy Class does not have enough functionality, move its code into another related class and delete the Lazy Class.
- Collapse Hierarchy: If the Lazy Class is part of a hierarchy but provides minimal value, merge it with its parent or child class.

### When to Ignore This Smell:

- If the Lazy Class is expected to grow with additional functionality in the near future.
- If the class, although small, improves code readability, maintainability, or separation of concerns.
