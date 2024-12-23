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

## Question #4:

### Identified Code Smells and Refactoring Suggestions

Below are the identified code smells in the clex.py file and the corresponding refactoring suggestions to address them. Each issue is explained with the reasons and appropriate solutions.

#### 1. Long Class (Large Class)

The Lexer class contains too many attributes, methods, and hard-coded token definitions, making it difficult to maintain and extend.

Solution:
We should extract the reserved words, token operators, and delimiters into separate modules or configuration files. For example:

```python
RESERVED_WORDS = (
    'AUTO', 'BREAK', 'CASE', 'CHAR', ...
)

TOKEN_OPERATORS = {
    'PLUS': r'\+',
    'MINUS': r'-',
    'TIMES': r'\*',
    ...
}
```

#### 2. Long Method (Long Method)

The **main** section combines file input/output, lexer handling, and directory creation into a single block, violating the single responsibility principle.

Solution:
We should split the **main** logic into smaller, more focused functions. For instance:

```python
def process_input_file(input_file):
    with open(input_file, "r") as file:
        return file.read()

def initialize_directories(output_dir):
    os.makedirs(output_dir, exist_ok=True)

def write_output_files(base_dir, output_file, token, index):
    with open(f"{base_dir}/{output_file}{index}.type", "w") as type_output:
        type_output.write(token.type)
    with open(f"{base_dir}/{output_file}{index}.value", "w") as value_output:
        value_output.write(token.value)

```

#### 3. Duplicated Code

File writing operations for typeOutput, valueOutput, and result are repeated in the loop, leading to redundancy.

Solution:
We should create a utility function for file writing:

```python
def write_to_file(filename, content):
    with open(filename, "w") as file:
        file.write(content)

```

Then replace the repetitive file handling with:

```python

write_to_file(f"result/{output_file}{counter}.type", tok.type)
write_to_file(f"result/{output_file}{counter}.value", tok.value)
```

#### 4. Comments Instead of Code (Comments)

The comments in the code (e.g., # ->, # ?) explain obvious parts and suggest unclear code.

Solution:
We should remove these unnecessary comments and replace unclear code with meaningful variable names. For example:

```python
TOKEN_PATTERNS = {
    'ARROW': r'->',
    'CONDOP': r'\?',
    ...
}
```

#### 5. Magic Strings (Magic Numbers and Strings)

Strings like "result/" and file suffixes (.type, .value) are hardcoded, making updates tedious.

Solution:
We should define constants for paths and suffixes:

```python
OUTPUT_DIR = "result"
TYPE_SUFFIX = ".type"
VALUE_SUFFIX = ".value"

```

#### 6. Poor Naming (Inconsistent Naming)

Variable names such as CFileName, outputFile, and tok are inconsistent and unclear.

Solution:
Rename variables for clarity and consistency:

CFileName → input_file
outputFile → output_file
tok → current_token
counter → token_index
Example:

```python
input_file = sys.argv[1]
output_file = sys.argv[2]
```

#### 7. Open-Closed Principle Violation

The hard-coded token definitions (t_PLUS, t_MINUS, etc.) make the lexer rigid and violate the Open-Closed Principle.

Solution:
We should load token definitions dynamically from an external configuration file (e.g., JSON or YAML):

```python
import json

def load_tokens_from_config(config_file):
    with open(config_file, "r") as file:
        return json.load(file)
```

TOKEN_CONFIG = load_tokens_from_config("tokens.json")

#### 8. Manual Resource Management (Resource Leak)

File objects are opened repeatedly without using with statements, which risks resource leaks.

Solution:
Use with statements to ensure files are closed properly:

```python
with open(f"result/{output_file}{counter}.type", "w") as type_output:
    type_output.write(tok.type)
```

#### 9. Hard-Coded Paths and Directory Creation (Shotgun Surgery)

Paths are built inline using string concatenation, making changes error-prone.

Solution:
Create a helper function to generate file paths:

```python
Copy code
def get_output_file_path(base_dir, file_name, suffix):
    return os.path.join(base_dir, f"{file_name}{suffix}")
```

Usage:

```python
path = get_output_file_path("result", output_file + str(counter), ".type")
```

#### 10. Insufficient Error Handling (Exception Handling Issues)

The code does not validate input arguments or handle missing files, leading to potential crashes.

Solution:
Add error handling for command-line arguments and file operations:

```python
if len(sys.argv) < 3:
    print("Usage: python clex.py <input_file> <output_file>")
    sys.exit(1)
```
