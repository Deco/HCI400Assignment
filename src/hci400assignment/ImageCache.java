/*
 * Curtin University - Machine Perception 400 - Assignment
 * Group 11 - 2014S2
 */
package hci400assignment;

import hci400assignment.gui.ImagePanel;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.imageio.ImageIO;

/**
 *
 * @author Declan White
 */
public class ImageCache
{
    private static final Map<URL, ImageCache> imageCacheMap
      = new ConcurrentHashMap<URL, ImageCache>();

    private final URL url;
    private boolean isLoading;
    private boolean isLoaded;
    private boolean isError;
    private Image cachedImage;

    private final List<ImageCacheListener> listenerList;

    public static ImageCache get(URL url)
    {
        ImageCache imageCache = imageCacheMap.get(url);

        if(imageCache == null) {
            imageCache = new ImageCache(url);
            imageCacheMap.put(url, imageCache);
        }

        return imageCache;
    }

    private ImageCache(URL urlIn)
    {
        url = urlIn;
        isLoading = false;
        isLoaded = false;
        isError = false;

        listenerList = new ArrayList<ImageCacheListener>();
    }

    public void loadTo(ImageCacheListener listener)
    {
        synchronized(listenerList) {
            listenerList.add(listener);
        }
        load();
    }

    private void load()
    {
        if(isLoaded) {
            callback();
            return;
        }
        if(!isLoading) {
            isLoading = true;
            Thread fetchImageThread = new Thread()
            {
                @Override
                public void run()
                {
                    try {
                        Image image = ImageIO.read(url);
                        cachedImage = image;
                    } catch(IOException ex) {
                        StringBuilder msg = new StringBuilder();
                        msg.append("Failed to load image:");
                        msg.append("\n    ");
                        msg.append(url);
                        System.err.println(msg.toString());
                        isError = true;
                    }
                    isLoaded = true;
                    callback();
                }
            };
            fetchImageThread.start();
        }
    }

    private void callback()
    {
        synchronized(listenerList) {
            for(ImageCacheListener listener : listenerList) {
                if(isError) {
                    listener.imageError();
                } else {
                    listener.imageReady(cachedImage);
                }
            }
            listenerList.clear();
        }
    }

}
