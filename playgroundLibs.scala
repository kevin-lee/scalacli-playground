/* Using directives moved to project.scala */

/* Scala CLI playground file
 * Run this file with: ./run-playgroundLibs.sh
 */

import cats.*
import cats.data.Validated
import cats.effect.*
import cats.syntax.all.*
import laika.api.Transformer
import laika.format.HTML
import laika.format.Markdown
import org.jsoup.Jsoup
import refined4s.*
import refined4s.types.*

@main
def playLibs(): Unit = {
  println("Hello, Scala with Libraries!")

  /* Example using cats */
  println("\n=== Cats Examples ===")
  val numbers = List(1, 2, 3, 4, 5)
  val summed  = numbers.foldMap(identity)
  println(s"Sum using cats foldMap: $summed")

  def validate(n: Int): Validated[String, Int] =
    if n > 0 then Validated.valid(n) else Validated.invalid("Number must be positive")

  val n1         = 1
  val validated1 = validate(n1)
  println(s"Validated: $validated1")

  val n2         = -1
  val validated2 = validate(n2)
  println(s"Validated: $validated2")

  /* Example using refined4s */
  println("\n=== Refined4s Examples ===")

  import refined4s.types.all.*
  val positiveInt = PosInt(42)
  println(s"Positive Int: $positiveInt")

  // Compile-time error: Invalid value: [-1]. It must be a positive Int
  // val positiveInt2 = PosInt(-1)

  val nonEmptyString = NonEmptyString("John Doe")
  println(s"Non-empty String: $nonEmptyString")

  // Compile-time error: Invalid value: [""]. It must be a non-empty String
  // val nonEmptyString2 = NonEmptyString("")

  type Name = Name.Type
  object Name extends Newtype[NonEmptyString]

  val name = Name(nonEmptyString)
  println(s"Name: $name")

  val uuid = Uuid("550e8400-e29b-41d4-a716-446655440000")
  println(s"UUID: $uuid")

  // Compile-time error: Invalid value: ["550e8400-e29b-41d4-a716-"]. It must be UUID
  // val uuid2 = Uuid("550e8400-e29b-41d4-a716-")

  println("\n=== Extras Examples ===")

  import extras.scala.io.syntax.color._

  println("Hello".blue)
  println("Hello".red)
  println("Hello".green)
  println("Hello".bold)
  println("Hello".underlined)

  import extras.scala.io.syntax.truecolor.rgb._

  println(s"${"Hello".rgbed(0x26a69a)} ${"world".rgbed(0x03a9f4)}!")

  /* Example using jsoup */
  println("\n=== JSoup Examples ===")
  val html  =
    """
      |<html>
      |  <head>
      |    <title>Sample Title</title>
      |  </head>
      |  <body>
      |    <p>Sample paragraph</p>
      |  </body>
      |</html>
    """.stripMargin
  val doc   = Jsoup.parse(html)
  val title = doc.title()
  println(s"Parsed HTML title: $title")

  /* Example using laika */
  println("\n=== Laika Examples ===")
  val markdownText =
    """
      |# Hello Markdown
      |This is a **bold** statement.
    """.stripMargin

  import laika.api.MarkupParser
  import laika.ast._
  import laika.format.Markdown

  val result = MarkupParser.of(Markdown).build.parse(markdownText)

  println(
    s"""markdownText:
       |----------------
       |$markdownText
       |----------------
       |""".stripMargin
  )

  result match {
    case Right(document) =>
      println("Parsed successfully:")
      println(document.content)

    case Left(error) =>
      println("Parsing failed:")
      println(error)
  }

  /* Example using cats-effect (just showing the type, not running the effect) */
  println("\n=== Cats Effect Examples ===")
  val program: IO[Unit] = for {
    a <- IO.pure(1)
    b <- IO.pure(2)
    c <- IO.delay(a + b)
    _ <- IO.println(s"a + b = $c")
    _ <- IO.println("Hello, Cats Effect!")
    _ <- IO.println("This would run in the cats-effect runtime")
  } yield ()

  /* WARNING: Don't use import cats.effect.unsafe.implicits.global and do unsafeRunSync() in production. */
  import cats.effect.unsafe.implicits.global
  program.unsafeRunSync()
}
