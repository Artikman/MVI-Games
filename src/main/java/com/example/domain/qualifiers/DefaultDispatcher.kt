package com.example.domain.qualifiers

import javax.inject.Qualifier

/**
 * @Retention will allow our JVM annotation to be used at runtime,
 * which will enable us to use mapping (reflection)
 * @Qualifier is used to distinguish between objects of the same
 * type but with different instances
 */
@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class DefaultDispatcher