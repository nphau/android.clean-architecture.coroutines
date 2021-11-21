package com.nphau.app

import android.content.Context
import com.nphau.android.Launcher
import com.nphau.android.shared.PluginInitializer
import com.nphau.android.shared.di.SharedDI
import com.nphau.android.shared.ui.theme.ThemeUtils
import com.nphau.app.libs.CrashlyticsLoggingTree
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.java.KoinJavaComponent

class AppLauncher : Launcher() {

    //private var initializers = KoinJavaComponent.getKoin().getAll<PluginInitializer>()

    override fun onCreate() {
        super.onCreate()
//        SharedDI.startDI(
//            launcher = this@AppLauncher,
//            enableLogs = isDebug(),
//            modules = applicationModules() + module {
//                single<Context> { this@AppLauncher }
//                single { { onLifecycleCreate() } }
//            }
//        )
        ThemeUtils.setNightMode(false)

        // initializers
//        initializers.distinct().forEach { plugin ->
//            plugin.initialize(this)
//        }
    }

    override fun releaseLoggingTree() = CrashlyticsLoggingTree()

    override fun onApplicationEnterBackground() {
        super.onApplicationEnterBackground()
        // initializers.distinct().forEach { it.onEnterBackground() }
    }

    override fun onApplicationEnterForeground() {
        super.onApplicationEnterForeground()
        // initializers.distinct().forEach { it.onEnterForeground() }
    }

    override fun isDebug(): Boolean = BuildConfig.DEBUG

    private fun applicationModules() = emptyList<Module>()

}