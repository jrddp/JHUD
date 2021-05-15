package me.kokeria.jhud.items;

import me.kokeria.jhud.util.Renderer;
import net.minecraft.client.Minecraft;

import java.awt.*;

public class Compass extends HUDItem {

    public Compass(int x, int y) {
        super(x, y);
    }

    @Override
    public int getWidth() {
        return 126;
    }

    @Override
    public int getHeight() {
        return 10;
    }

    @Override
    public void render() {

        int width = getWidth();
        Renderer.drawBackgroundBox(x, y, width, getHeight());

        // width in which text should be rendered, smaller so that text doesn't extend over boundary
        int innerWidth = width - 12;

        double playerYaw = Minecraft.getMinecraft().thePlayer.rotationYaw % 360;
        double yawWidth = 100;
        // MUST be a factor of 45 in order to show letter directions
        double yawSpacing = 45 / 4d;

        double edgeYaw = playerYaw - yawWidth / 2;
        double leftYaw = Math.ceil((edgeYaw) / yawSpacing) * yawSpacing;

        // lines and letters
        for (double yaw = leftYaw; yaw < edgeYaw + yawWidth; yaw += yawSpacing) {
            int lineX = (int) (x + (yaw - edgeYaw) * innerWidth / yawWidth) + 6;
            String str = getAngleString((int) yaw);
            if (str == null) {
                Renderer.drawRect(lineX, y + 3, 1, getHeight() - 6, Color.WHITE.getRGB());
            } else {
                Renderer.drawHCenteredString(str, lineX, y + 2, getHeight() - 2);
            }
        }

        // center indicator
        Renderer.drawRect(x + width / 2, y, 1, 1, Color.WHITE.getRGB());
        Renderer.drawRect(x + width / 2, y + getHeight() - 1, 1, 1, Color.WHITE.getRGB());

    }

    private String getAngleString(int yaw) {
        if (yaw % 45 != 0) return null;

        if (yaw < 0) yaw += 360;
        if (yaw >= 360) yaw -= 360;

        switch (yaw) {
            case 0:
                return "S";
            case 45:
                return "SW";
            case 90:
                return "W";
            case 135:
                return "NW";
            case 180:
                return "N";
            case 225:
                return "NE";
            case 270:
                return "E";
            case 315:
                return "SE";
        }

        throw new IllegalArgumentException("Input angle " + yaw + " caused unexpected issues.");

    }

}
