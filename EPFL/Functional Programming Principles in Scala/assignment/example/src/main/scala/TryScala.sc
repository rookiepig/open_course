val addOne = (x:Int) => x + 1

class Greeter(prefix: String, suffix: String) {
  def greet(name: String): Unit = {
    println(prefix + name + suffix)
  }
}

val greeter = new Greeter("Hello", "!!!")

greeter.greet(name = "ZhangKang")


val list: List[Any] = List(
  "a string",
  732,
  'c',
  true,
  () => "hello list"
)

list.foreach(e => println(e))

class Point(var x: Int, var y: Int) {
  def move(dx: Int,  dy: Int): Unit = {
    x += dx
    y += dy
  }

  override def toString: String = {
    s"($x, $y)"
  }
}

val point = new Point(1, 2)
println(point)
point.move(1, 1)
println(point)

def abs(x: Int) = if (x >= 0) x else -x
