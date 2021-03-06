package io.vertx.kotlin.ext.web.api.contract.openapi3

import io.vertx.core.Vertx
import io.vertx.core.json.JsonObject
import io.vertx.ext.web.api.contract.openapi3.OpenAPI3RouterFactory as OpenAPI3RouterFactoryVertxAlias
import io.vertx.kotlin.coroutines.awaitResult

object OpenAPI3RouterFactory {
  /**
   * Create a new OpenAPI3RouterFactory
   *
   * @param vertx 
   * @param url location of your spec. It can be an absolute path, a local path or remote url (with HTTP protocol)
   *
   * <p/>
   * NOTE: This function has been automatically generated from the [io.vertx.ext.web.api.contract.openapi3.OpenAPI3RouterFactory original] using Vert.x codegen.
   */
  suspend fun createAwait(vertx : Vertx, url : String) : OpenAPI3RouterFactoryVertxAlias {
    return awaitResult{
      OpenAPI3RouterFactoryVertxAlias.create(vertx, url, it)
    }
  }

  /**
   * Create a new OpenAPI3RouterFactory
   *
   * @param vertx 
   * @param url location of your spec. It can be an absolute path, a local path or remote url (with HTTP protocol)
   * @param auth list of authorization values needed to access the remote url. Each item should be json representation of an 
   *
   * <p/>
   * NOTE: This function has been automatically generated from the [io.vertx.ext.web.api.contract.openapi3.OpenAPI3RouterFactory original] using Vert.x codegen.
   */
  suspend fun createAwait(vertx : Vertx, url : String, auth : List<JsonObject>) : OpenAPI3RouterFactoryVertxAlias {
    return awaitResult{
      OpenAPI3RouterFactoryVertxAlias.create(vertx, url, auth, it)
    }
  }

}
