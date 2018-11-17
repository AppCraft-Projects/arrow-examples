package org.hexworks.kotlincode.libdev.example03

import org.hexworks.kotlincode.libdev.DrawSurface

@Suppress("unused", "UNUSED_PARAMETER")
interface Component {

    val children: Iterable<Component>
    val drawSurface: DrawSurface

    fun requestFocus()

    fun clearFocus()
}
