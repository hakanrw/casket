package dev.candar.casket

import java.util.logging.Level


object MinimalApplication extends cask.MainRoutes:
  @cask.get("/")
  def index() =
    "Server is listening."

  @cask.get("/hello")
  def hello() =
    "Hello World!"

  @cask.post("/do-thing")
  def doThing(request: cask.Request) =
    request.text().reverse

  override def port: Int = sys.env.get("HTTP_PORT").map(_.toInt).getOrElse(8080)

  initialize()
  java.util.logging.Logger.getLogger("").setLevel(Level.INFO)
