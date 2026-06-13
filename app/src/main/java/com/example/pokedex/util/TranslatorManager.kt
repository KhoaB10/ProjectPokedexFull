package com.example.pokedex.util

import android.util.Log
import com.google.mlkit.common.model.DownloadConditions
import com.google.mlkit.nl.translate.TranslateLanguage
import com.google.mlkit.nl.translate.Translation
import com.google.mlkit.nl.translate.Translator
import com.google.mlkit.nl.translate.TranslatorOptions
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withPermit
import kotlinx.coroutines.tasks.await

object TranslatorManager {
    private const val TAG = "TranslatorManager"
    private val translationCache = java.util.concurrent.ConcurrentHashMap<String, String>()
    private val pendingTranslations = java.util.concurrent.ConcurrentHashMap<String, Deferred<String>>()
    
    // Giới hạn số lượng tác vụ dịch đồng thời để tránh làm nghẽn tài nguyên hệ thống
    private val semaphore = Semaphore(3)

    private val options = TranslatorOptions.Builder()
        .setSourceLanguage(TranslateLanguage.ENGLISH)
        .setTargetLanguage(TranslateLanguage.VIETNAMESE)
        .build()
        
    private val translator: Translator = Translation.getClient(options)
    private var isModelDownloaded = false

    suspend fun translate(text: String): String = coroutineScope {
        if (text.isBlank()) return@coroutineScope text
        
        // 1. Kiểm tra cache hoàn tất
        translationCache[text]?.let { return@coroutineScope it }
        
        // 2. Kiểm tra các tác vụ đang chạy để tránh dịch trùng lặp cùng lúc
        val deferred = pendingTranslations.computeIfAbsent(text) {
            async {
                try {
                    semaphore.withPermit {
                        ensureModelDownloaded()
                        val result = translator.translate(text).await()
                        translationCache[text] = result
                        result
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "Translation failed for '$text': ${e.message}")
                    text // Fallback
                } finally {
                    pendingTranslations.remove(text)
                }
            }
        }
        
        deferred.await()
    }

    private suspend fun ensureModelDownloaded() {
        if (isModelDownloaded) return
        
        val conditions = DownloadConditions.Builder()
            .requireWifi()
            .build()
            
        try {
            translator.downloadModelIfNeeded(conditions).await()
            isModelDownloaded = true
            Log.d(TAG, "Vietnamese model downloaded successfully")
        } catch (e: Exception) {
            Log.e(TAG, "Model download failed: \${e.message}")
            throw e
        }
    }
    
    fun close() {
        translator.close()
    }
}
