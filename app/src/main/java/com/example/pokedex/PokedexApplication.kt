package com.example.pokedex

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.disk.DiskCache
import coil.memory.MemoryCache
import coil.request.CachePolicy
import coil.util.DebugLogger

class PokedexApplication : Application(), ImageLoaderFactory {
    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this)
            .memoryCache {
                MemoryCache.Builder(this)
                    .maxSizePercent(0.25)
                    .build()
            }
            .diskCache {
                DiskCache.Builder()
                    .directory(this.cacheDir.resolve("image_cache"))
                    .maxSizePercent(0.02) // Giảm xuống còn 2% bộ nhớ (khoảng 100-200MB tùy thiết bị) thay vì 5%
                    .build()
            }
            // Quan trọng: Thiết lập chính sách cache
            .diskCachePolicy(CachePolicy.ENABLED)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .networkCachePolicy(CachePolicy.ENABLED)
            .logger(DebugLogger()) // Để theo dõi quá trình tải và lỗi (có thể xóa khi release)
            .respectCacheHeaders(false) // Bỏ qua Header từ Server để ưu tiên cache cục bộ
            .build()
    }
}
