package dungeonkit.renderer

import dungeonkit.data.Grid
import dungeonkit.data.tiles.Tile
import dungeonkit.data.tiles.binding.CharTileMap

open class ConsoleRenderer : Renderer<CharTileMap> {

    override fun render(map: Grid<Tile>, tileMap: CharTileMap) {
        val (w, h) = map.area
        val chars = Array(h) { Array(w) { tileMap.default.data } }
        map.forEach { (pos, tile) ->
            chars[pos.y][pos.x] = tileMap[tile].data
        }

        chars.forEach { c ->
            println(c.map { "$it$it" }.reduce { a, b -> a + b})
        }
    }

    /**
     * Provides a simpler way to call the renderer.
     */
    companion object : ConsoleRenderer()
}