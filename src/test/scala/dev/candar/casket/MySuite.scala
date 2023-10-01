package dev.candar.casket

import sttp.client4.quick.*
import sttp.model.StatusCode
import sttp.model.StatusCodes

// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class MySuite extends munit.FunSuite {
  MinimalApplication.main(Array())

  val address = uri"http://localhost:8080"

  test("/hello") {
    val expected = "Hello World!"

    val response = quickRequest
      .get(address.addPath("hello"))
      .send()

    assertEquals(response.code, StatusCode(200))
    assertEquals(response.body, expected)
  }


  test("/") {
    val expected = "Server is listening."

    val response = quickRequest
      .get(address)
      .send()

    assertEquals(response.code, StatusCode(200))
    assertEquals(response.body, expected)
  }

  test("404") {
    val response = quickRequest
      .get(address.addPath("this-path-does-not-exist"))
      .send()

    assertEquals(response.code, StatusCode(404))
  }

  MinimalApplication.executionContext.shutdownNow()

}
