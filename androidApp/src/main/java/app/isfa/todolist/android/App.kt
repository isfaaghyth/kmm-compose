package app.isfa.todolist.android

import android.app.Application
import app.isfa.todolist.di.appModule
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule)
        }
    }
}