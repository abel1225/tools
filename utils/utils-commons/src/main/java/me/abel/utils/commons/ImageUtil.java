package me.abel.utils.commons;

import net.coobird.thumbnailator.Thumbnails;

import java.io.File;
import java.io.IOException;

/**
 * @description:
 * @author: able.li
 * @create: 2018/11/29 17:05
 */
public class ImageUtil {

    public static void compress(File src, File target) throws IOException {
        Thumbnails.of(src).scale(1.00f).outputQuality(0.5f).toFile(target);
    }

}
