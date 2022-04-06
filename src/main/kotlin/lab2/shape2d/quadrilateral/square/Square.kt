package lab2.shape2d.quadrilateral.square

import lab2.shape2d.quadrilateral.Quadrilateral

interface Square : Quadrilateral {
    override val length: Double
    override val width: Double
}
