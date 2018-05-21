package dao

import javax.inject.{Inject, Singleton}
import model.User
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile


import scala.concurrent.{ExecutionContext, Future}

@Singleton
class UserDAOImpl @Inject() (dbConfigProvider : DatabaseConfigProvider) (implicit ec: ExecutionContext) extends UserDAO {

    private val dbConfig = dbConfigProvider.get[JdbcProfile]

    import dbConfig._

    //import necesario para TABLE[Users], antes era driver.api._ ahora es profile.api._
    import profile.api._



  class UserTableDef(tag: Tag) extends Table[User](tag, "user") {
      def id = column[Long]("id", O.PrimaryKey,O.AutoInc)
      def firstName = column[String]("first_name")
      def lastName = column[String]("last_name")
      def mobile = column[Long]("mobile")
      def email = column[String]("email")

      override def * =
        (id,firstName, lastName, mobile, email )<>(User.tupled, User.unapply)

  }

  implicit val users = TableQuery[UserTableDef]

  override def add(user: User): Future[String] = {
    db.run(users += user).map(res => "User successfully added").recover{
      case ex: Exception => ex.getCause.getMessage
    }
  }
  override def get(id: Long): Future[Option[User]] = {
    db.run(users.filter(_.id === id).result.headOption)
  }

  override def delete(id: Long): Future[Int] = {
    db.run(users.filter(_.id === id).delete)
  }

  override def listAll: Future[Seq[User]] = {
    db.run(users.result)
  }
}
