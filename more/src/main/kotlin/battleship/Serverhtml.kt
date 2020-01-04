package battleship
import io.vertx.core.AbstractVerticle
import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.StaticHandler
class Serverhtml: AbstractVerticle() {
    override fun start() {
        val Boardcontroller= BoardController(vertx)
        var router = Router.router(vertx)
        router.route("/battleships").handler(Boardcontroller::startHandle)
        router.route("/battleships/:you").handler(Boardcontroller::createHandle)
        router.route("/battleships/:you/:x/:y").handler(Boardcontroller::shipscoordinate)
        router.route("/battleships/:you/:size").handler(Boardcontroller::shipssize)
        router.route("/battleships/:you/:direction/:r/:t").handler(Boardcontroller::shipsdirection)
        router.route("/battleships/:you/:size/:x/:y/:direction").handler(Boardcontroller::createships)
        router.route("/battleships/:you/battle1/:q/:w/:e/:r").handler(Boardcontroller::indexHandle1)
        router.route("/battleships/:you/battle1/:q/:w/:e/:r/:x/:y").handler(Boardcontroller::coordinateHandle1)
        router.route("/web1/*").handler(StaticHandler.create().setWebRoot("web1"))
        vertx.createHttpServer().requestHandler(router).listen(80)
    }
}