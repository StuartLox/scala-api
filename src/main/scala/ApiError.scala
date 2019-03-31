import akka.http.scaladsl.model.{StatusCode, StatusCodes}

final case class ApiError private(statusCode: StatusCode, message: String)

object ApiError {

  private def apply(statusCode: StatusCode, message: String): ApiError = new ApiError(statusCode, "Unknown.")

  val generic: ApiError = new ApiError(StatusCodes.InternalServerError, message="Unknown error.")

  val emptyTitleField: ApiError = new ApiError(StatusCodes.BadRequest, message="The title field must not be empty.")

  def todoNotFound(id: String): ApiError =
    new ApiError(StatusCodes.NotFound, message = s"Todo with id $id could not be found")
}
