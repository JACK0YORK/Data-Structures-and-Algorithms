**Dynamic Var :=** (stored in heap) $\to$ variable storage size.

Most languages require **prototypes**, in order to have the variable name declared for use.

```java
public static String prototyped_method(int i);

public static void main(String[] args){
    System.out.println(prototyped_method(3));
}

public static String prototyped_method(int i){
    return "LMAO, "+i;
}
```

> LMAO, 3

```cpp
std::string prototyped_method(int i);

int main(){
    std::cout << prototyped_method(3) <<std::endl;
    return 0;
}

std::string prototyped_method(int i){
    return "LMAO, "+i;
}
```

> LMAO, 3
