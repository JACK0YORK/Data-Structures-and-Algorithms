# Stacks and Queues

### Properties

- **FILO/LIFO:** First in, Last out

- **FIFO/LILO:** First in, First Out

- **Linear/Sequential** 
  
  $\forall \texttt{e}\in \texttt{Structure},\ \texttt{e.next} \neq \texttt{null} \to \texttt{e.next.prev} = \texttt{e}$

## Stack\<T>

FILO, Linear

- `pop(void) -> T`

- `push(T) -> void`

- `size(void) -> int`

- `is_empty(void) -> bool`

- `top(void) -> T`

```python
class Stack<T>:
    array = T[n]
    length=0
    def push(x):
        array[length++] = x
    def pop():
        temp = array[--length]
        array[length] = None
        return temp
```

## Queue\<T>

FIFO, Linear

- `enqueue(T) -> void`

- `dequeue(void) -> T`

- `size(void) -> int`

- `is_empty(void) -> bool`

- `first(void) -> T`

```python
class Queue<T>:
    array = T[n]
    end=0
    begin=0
    def enqueue(x):
        array[end++] = x
    def dequeue():
        temp = array[begin]
        array[begin++]=None
        return temp
```
