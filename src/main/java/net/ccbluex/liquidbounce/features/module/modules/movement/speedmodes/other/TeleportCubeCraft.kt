/*
 * RinBounce Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge.
 * https://github.com/rattermc/rinbounce69
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.speedmodes.other

import net.ccbluex.liquidbounce.event.MoveEvent
import net.ccbluex.liquidbounce.features.module.modules.movement.Speed
import net.ccbluex.liquidbounce.features.module.modules.movement.speedmodes.SpeedMode
import net.ccbluex.liquidbounce.utils.extensions.isMoving
import net.ccbluex.liquidbounce.utils.movement.MovementUtils.direction
import net.ccbluex.liquidbounce.utils.timing.MSTimer
import kotlin.math.cos
import kotlin.math.sin

object TeleportCubeCraft : SpeedMode("TeleportCubeCraft") {
    private val timer = MSTimer()
    override fun onMove(event: MoveEvent) {
        if (mc.thePlayer.isMoving && mc.thePlayer.onGround && timer.hasTimePassed(300)) {
            val yaw = direction
            val length = Speed.cubecraftPortLength
            event.x = -sin(yaw) * length
            event.z = cos(yaw) * length
            timer.reset()
        }
    }
}