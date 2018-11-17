package org.hexworks.kotlincode.libdev.example04

import org.hexworks.kotlincode.libdev.Component
import org.hexworks.kotlincode.libdev.DrawSurface

@Suppress("unused", "UNUSED_PARAMETER")
class MyComponent(val children: Iterable<Component>,
                  val drawSurface: DrawSurface) : Component
