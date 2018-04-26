package com.github.ozsie.webfluxtest

import com.github.ozsie.webfluxtest.configuration.hazelcastConfiguration
import com.github.ozsie.webfluxtest.handlers.ItemHandler
import com.github.ozsie.webfluxtest.routers.router
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.support.GenericApplicationContext
import org.springframework.context.support.beans

// See application.properties context.initializer.classes entry
class Beans : ApplicationContextInitializer<GenericApplicationContext> {
    override fun initialize(context: GenericApplicationContext) = beans {
        bean { ItemHandler() }
        bean { router(ref()) }
        bean { hazelcastConfiguration() }
        bean { init() }
    }.initialize(context)
}
