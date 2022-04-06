package lab2.shape2d.quadrilateral.rectangle

import lab2.shape2d.quadrilateral.Quadrilateral

interface Rectangle : Quadrilateral {
    override val length: Double
    override val width: Double
}
