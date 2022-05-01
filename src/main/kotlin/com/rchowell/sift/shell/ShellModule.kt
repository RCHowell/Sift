package com.rchowell.sift.shell

import com.google.inject.Binder
import com.google.inject.Module

class ShellModule(private val ctx: Context) : Module {

    override fun configure(binder: Binder) {
        binder.bind(Context::class.java).toInstance(ctx)
    }
}
