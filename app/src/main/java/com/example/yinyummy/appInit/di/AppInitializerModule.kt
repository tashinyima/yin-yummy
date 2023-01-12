package com.example.yinyummy.appInit.di

import android.content.Context
import com.example.yinyummy.appInit.AppInitializer
import com.example.yinyummy.appInit.AppInitializerImpl
import com.example.yinyummy.repository.EntireRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppInitializerModule {

    @Singleton
    @Provides
    fun provideAppInitializer(
        @ApplicationContext context: Context,
        entireRepository: EntireRepository,
    ): AppInitializer {
        return AppInitializerImpl(
            context,
            entireRepository
        )
    }
}