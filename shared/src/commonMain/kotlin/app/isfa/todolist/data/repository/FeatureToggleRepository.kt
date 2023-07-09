package app.isfa.todolist.data.repository

interface FeatureToggleRepository {
    fun isEnabled(): Boolean
}

class FeatureToggleRepositoryImpl : FeatureToggleRepository {

    override fun isEnabled(): Boolean {
        return true // TODO, A/B or remote config
    }
}