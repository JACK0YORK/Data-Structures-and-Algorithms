#### Sets:

$\{3,4,5\}=\{3,4,5,4\}=\{5,4,3\}$

#### Bags:

$[3,4,5,4]=[3,4,4,5]\neq[3,4,5]$

#### Relations

Relations are sets of tuples of elements in a set. 

$R=\{<x,y>|\ x,y\in S\ \cap\ P(x,y)=\top\}$

$<x,y>\in R\to xRy$

Consider the relation $<$, it contains $<1,3>,<2,23>$, but not $<3,2>$.

ie. $ 1<3$, $ 2<23$, but not $ 3<2$

##### Properties

$\forall a\in S \ aRa \to R$ is **reflexive**

$\forall a,b\in S\ aRb\to bRa\to R$ is **symmetric**

$\forall a,b\in S\ aRb \cap bRa\to a=b\to R$ is **antisymmetric**

$\forall a,b,c\in S\ aRb \cap bRc\to aRc\to R$ is **transitive**

Ex: for $\mathbb N$

$<$ is antisymmetric and transitive

$\leq$ is antisymmetric, transitive, and reflexive

$=$ is reflexive, symmetric, antisymmetric, and transitive

If R is reflexive, symmetric, and transitive, it is an **equivalence relation**.

#### Logarithms

A) ${\log_by=x}$, and

B) ${b^x=y}$, and

C) ${b^{\log_by}=y}$

Application: What is the minimum number of bits beeded to represent n distinct values?

$\log_2n$ This is because every added bit doubles the amount of permutations, so the number of states $n$ that can be represented by $m$ bits is $n=2^m$.

$n=2^m\overset{(x=y\to\log x=\log y)}\to \log_2n=\log_22^m\overset {(A\to B)}\to2^{\log_2n}=2^m\overset{(a^x=a^y\to x=y)}\to\underline{\log_2n=m}$
