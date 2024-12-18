package com.dara.weathertracker

import android.app.Application
import android.content.Context
import com.dara.core.network.utils.ErrorHandler
import com.dara.core.network.utils.ErrorHandlerImpl
import com.dara.core.network.utils.StringProvider
import com.dara.core.network.utils.StringProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideApplicationContext(application: Application): Context =
        application.applicationContext

    @Provides
    fun providesResourceProvider(resourceProvider: StringProviderImpl): StringProvider =
        resourceProvider

    @Provides
    fun provideErrorHandler(errorHandler: ErrorHandlerImpl): ErrorHandler = errorHandler

}
