package controllers

import play.api.mvc._

class Application extends Controller {
  def app = Action {
    Ok(views.html.app())
  }

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

}
