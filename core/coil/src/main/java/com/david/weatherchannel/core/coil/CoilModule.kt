package com.david.weatherchannel.core.coil

import android.content.Context
import coil3.ImageLoader
import coil3.disk.DiskCache
import coil3.disk.directory
import coil3.memory.MemoryCache
import coil3.request.crossfade
import coil3.util.DebugLogger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class CoilModule {

    companion object {

        private const val MEMORY_CACHE_PERCENT = 0.3
        private const val MAX_DISK_CACHE_SIZE_PERCENT = 0.03
        private const val CACHE_DIRECTORY_NAME = "image_cache"

        @[Singleton Provides]
        fun provideImageLoader(
            @ApplicationContext context: Context,
        ): ImageLoader = with(ImageLoader.Builder(context)) {
            crossfade(true)
            memoryCache {
                MemoryCache.Builder()
                    .maxSizePercent(context, percent = MEMORY_CACHE_PERCENT)
                    .build()
            }
            diskCache {
                DiskCache.Builder()
                    .directory(context.cacheDir.resolve(CACHE_DIRECTORY_NAME))
                    .maxSizePercent(MAX_DISK_CACHE_SIZE_PERCENT)
                    .build()
            }
            if (BuildConfig.DEBUG) {
                logger(DebugLogger())
            }
            build()
        }
    }
}
