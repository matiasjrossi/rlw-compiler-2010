# Tp 1  - Analizador Léxico `[``]` #

---


## Ejercicios ##

a d h j k n

### a ###

Constantes enteras con valores entre –215 y 215 – 1. Se debe incorporar a la lista de palabras reservadas la palabra int.

### d ###

Números reales (float) con signo y parte exponencial. El exponente puede tener signo. La ausencia de signo implica positivo. La parte exponencial puede estar ausente. El signo del exponente es opcional (su ausencia implica que el exponente es positivo).

Ejemplos válidos:

1.

.6

3 E –5

2.5 E 1

Considerar el límite permitido por C para constantes de tipo float.

1.17549435 e-38 < |x| < 3.40282347 e38

Se debe incorporar a la lista de palabras reservadas la palabra float.


### h ###

(Se utilizará en el Trabajo Práctico 2) [¿?]

### j ###

Incorporar a la lista de palabras reservadas la palabra for.

### k ###

Comentarios que comiencen con “ // ” y terminen con el fin de línea. Cadenas de caracteres que
comiencen con “ " ” y terminen con “ " ” (estas cadenas pueden ocupar más de una línea).

### n ###

Operador “:-” para asignación.

## Deadline ##

Unknown!!

## Tools ##

  * [byacc –  public domain Berkeley LALR Yacc  parser generator](http://invisible-island.net/byacc/byacc.html)

  * [byacc-j - Berkeley YACC parser generator extended to generate Java code](http://byaccj.sourceforge.net/)

  * Cup

## Más Info ##

  * [Práctico(pdf)](http://diseno-de-compiladores-i.alumnos.exa.unicen.edu.ar/home/trabajos-practicos/Tp01-10.pdf?attredirects=0&d=1)

  * [Libro](http://www.lcc.uma.es/~galvez/Compiladores.html)

---

