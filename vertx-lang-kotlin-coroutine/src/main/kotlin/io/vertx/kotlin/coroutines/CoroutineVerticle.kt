package io.vertx.kotlin.coroutines

import io.vertx.core.Context
import io.vertx.core.Future
import io.vertx.core.Verticle
import io.vertx.core.Vertx

/**
 * A Verticle which run its start and stop methods in coroutine.
 * You should subclass this class instead of AbstractVerticle to create any verticles that use vertx-kotlin-coroutine.
 *
 * Created by stream.
 */
abstract class CoroutineVerticle : Verticle {

  private lateinit var vertxInstance: Vertx
  protected lateinit var context: Context

  override fun init(vertx: Vertx, context: Context) {
    this.vertxInstance = vertx
    this.context = context
  }

  override fun getVertx(): Vertx = vertxInstance

  override fun start(startFuture: Future<Void>?) {
    context.runCoroutine {
      try {
        start()
        startFuture?.complete()
      } catch (t: Throwable) {
        startFuture?.fail(t)
      }
    }
  }

  override fun stop(stopFuture: Future<Void>?) {
    context.runCoroutine {
      try {
        stop()
        stopFuture?.complete()
      } catch (t: Throwable) {
        stopFuture?.fail(t)
      } finally {
        // Do that differently perhaps with a ref count ?
        // removeVertxCoroutineContext()
      }
    }
  }

  /**
   * Override this method in your verticle
   */
  open suspend fun start() {}

  /**
   * Override this method in your verticle
   */
  open suspend fun stop() {}
}