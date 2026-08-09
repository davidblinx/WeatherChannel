package com.david.weatherchannel.core.mvvm.mapper

/**
 * A mapper that transforms objects from one type to another.
 *
 * This interface uses type variance to ensure type-safe mapping operations:
 * - [F] is contravariant (in) allowing mapping from supertype
 * - [T] is covariant (out) allowing mapping to subtype
 *
 * Mappers are commonly used to convert between:
 * - Network DTOs and domain models
 * - Domain models and UI models
 * - Database entities and domain models
 *
 * @param F The source type to map from
 * @param T The target type to map to
 *
 */
fun interface Mapper<in F, out T> {
    fun map(from: F): T
}
