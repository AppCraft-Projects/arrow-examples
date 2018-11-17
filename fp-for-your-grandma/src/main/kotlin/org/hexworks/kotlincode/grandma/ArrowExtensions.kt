package org.hexworks.kotlincode.grandma

import arrow.syntax.eq.eqv
import arrow.syntax.eq.neqv
import arrow.typeclasses.eq

inline fun <reified F> F.equivalentTo(b: F): Boolean = eqv(eq(), b)

inline fun <reified F> F.notEquivalentTo(b: F): Boolean = neqv(eq(), b)
