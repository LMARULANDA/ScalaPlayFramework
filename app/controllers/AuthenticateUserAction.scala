package controllers

import javax.inject.Inject
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

class AuthenticatedUserAction @Inject() (parser: BodyParsers.Default)(implicit ec: ExecutionContext)
  extends ActionBuilderImpl(parser) {

  private val logger = play.api.Logger(this.getClass)
/*
  override def invokeBlock[A](request: Request[A], block: (Request[A]) => Future[Result]) = {
    logger.debug("ENTERED AuthenticatedUserAction::invokeBlock")
    val maybeUsername = request.session.get("USERNAME")
    maybeUsername match {
      case None => {
        logger.debug("CAME INTO 'NONE'")
        //Future.successful()
      }
      case Some(u) => {
        logger.debug("CAME INTO 'SOME'")
        val res: Future[Result] = block(request)
        res
      }
    }
  }*/

}
