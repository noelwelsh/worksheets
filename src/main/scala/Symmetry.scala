import cats.implicits._
import doodle.core._
import doodle.java2d._
import doodle.syntax._
import doodle.effect.Writer._

object Symmetry {
  val spacer = square[Algebra, Drawing](20).noStroke.noFill

  // isoceles triangle where each side is a different colour, which makes detecting symmetry simpler
  val iso =
    OpenPath.empty
      .moveTo(0, 0)
      .lineTo(25, 100)
      .path[Algebra, Drawing]
      .strokeColor(Color.blue)
      .on(
        OpenPath.empty.moveTo(0, 0).lineTo(50, 0).path.strokeColor(Color.green)
      )
      .on(
        OpenPath.empty
          .moveTo(0, 0)
          .lineTo(-25, 100)
          .path
          .strokeColor(Color.red)
          .at(50, 0)
      )
      .strokeWidth(1.0)
      .at(-25, -50)

  iso
    .beside(spacer)
    .beside(iso.horizontalReflection)
    .beside(spacer)
    .beside(iso.rotate(180.degrees))
    .write[Png]("src/docs/img/1-triangle.png")

  val ninety =
    OpenPath.empty
      .lineTo(0, 100)
      .path[Algebra, Drawing]
      .strokeColor(Color.green)
      .on(OpenPath.empty.lineTo(100, 0).path.strokeColor(Color.blue))
      .strokeWidth(1.0)

  ninety.write[Png]("src/docs/img/1-ninety.png")

  val oneEighty =
    OpenPath.empty
      .lineTo(100, 0)
      .path[Algebra, Drawing]
      .strokeColor(Color.green)
      .on(OpenPath.empty.lineTo(100, 0).path.strokeColor(Color.blue).at(100, 0))
      .strokeWidth(1.0)

  oneEighty.write[Png]("src/docs/img/1-one-eighty.png")

  val twoAngles =
    OpenPath.empty
      .lineTo(100, 0)
      .path[Algebra, Drawing]
      .strokeColor(Color.green)
      .on(
        OpenPath.empty
          .moveTo(0, 0)
          .lineTo(25, 100)
          .path
          .strokeColor(Color.blue)
          .at(50, 0)
      )
      .strokeWidth(1.0)

  twoAngles.write[Png]("src/docs/img/1-two-angles.png")

  val twoAnglesSymmetry =
    OpenPath.empty
      .lineTo(50, 0)
      .path[Algebra, Drawing]
      .strokeColor(Color.green)
      .on(
        OpenPath.empty
          .moveTo(0, 0)
          .lineTo(25, 100)
          .path
          .strokeColor(Color.blue)
          .at(50, 0)
      )
      .on(
        OpenPath.empty
          .lineTo(50, 0)
          .path
          .strokeColor(Color.red)
          .at(75, 100)
      )
      .strokeWidth(1.0)

  twoAnglesSymmetry.write[Png]("src/docs/img/1-two-angles-symmetry.png")

  val parallelogram =
    OpenPath.empty
      .lineTo(50, 0)
      .path[Algebra, Drawing]
      .strokeColor(Color.green)
      .on(
        OpenPath.empty
          .moveTo(0, 0)
          .lineTo(25, 100)
          .path
          .strokeColor(Color.blue)
      )
      .on(
        OpenPath.empty
          .lineTo(50, 0)
          .path
          .strokeColor(Color.red)
          .at(25, 100)
      )
      .on(
        OpenPath.empty
          .lineTo(25, 100)
          .path
          .strokeColor(Color.black)
          .at(50, 0)
      )
      .strokeWidth(1.0)

  parallelogram.write[Png]("src/docs/img/1-parallelogram.png")

  val enscribedTriangle =
    OpenPath.empty
      .lineTo(50, 0)
      .path[Algebra, Drawing]
      .strokeColor(Color.green)
      .on(
        OpenPath.empty
          .lineTo(-15, 100)
          .path
          .at(50, 0)
          .strokeColor(Color.blue)
      )
      .on(
        OpenPath.empty
          .lineTo(35, 100)
          .path
          .strokeColor(Color.red)
      )
      .on(
        OpenPath.empty
          .lineTo(50, 0)
          .path[Algebra, Drawing]
          .at(35, 100)
          .on(
            OpenPath.empty
              .lineTo(35, 100)
              .path[Algebra, Drawing]
              .at(50, 0)
          )
          .strokeColor(Color.grey)
          .strokeDash(Array(3.0, 3.0))
      )
      .strokeWidth(1.0)

  enscribedTriangle.write[Png]("src/docs/img/1-enscribed-triangle.png")
}
