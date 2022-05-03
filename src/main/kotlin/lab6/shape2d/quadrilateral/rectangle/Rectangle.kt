package lab6.shape2d.quadrilateral.rectangle

import lab6.shape2d.quadrilateral.Quadrilateral

interface Rectangle : Quadrilateral {
    override val length: Double
    override val width: Double
}
