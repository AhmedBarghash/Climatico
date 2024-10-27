package com.developerx.core.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

abstract class FlowUseCase<Type, in Params>(
    val dispatchers: CoroutineContext = Dispatchers.IO
) where Type : Any {

    abstract suspend fun run(params: Params): Flow<Type>

    suspend operator fun invoke(params: Params): Flow<Type> = run(params).flowOn(dispatchers)
}
