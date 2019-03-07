package me.abel.utils.commons;
/**
 * 
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.*;
import java.util.Objects;
import java.util.Properties;

/**
 * 
 * @description 
 * @author Abel.li
 * @contact abel0130@163.com
 * @version
 */
public class PropertiesUtil {

	private static Properties properties;
	
	/*static {
		try {
			final WatchService watchService = FileSystems.getDefault().newWatchService();
			final String fileName = "application.yml";
			final Resource resource = new ClassPathResource(fileName);
			Paths.get(resource.getFile().getParent()).register(watchService, 
					StandardWatchEventKinds.ENTRY_MODIFY,
					StandardWatchEventKinds.ENTRY_DELETE,
					StandardWatchEventKinds.ENTRY_CREATE);
			properties = PropertiesLoaderUtils.loadProperties(resource);

			Thread watchThread = new Thread(() -> {
				while(true){
					try {
						WatchKey watchKey = watchService.take();
						for(WatchEvent<?> event : watchKey.pollEvents()){
							if(Objects.equals(event.context().toString(), fileName)){
								properties = PropertiesLoaderUtils.loadProperties(resource);
								break;
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			watchThread.setDaemon(true);
			watchThread.start();
			
			Runtime.getRuntime().addShutdownHook(new Thread(() -> {
				try {
					watchService.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	static {
        try {
            final WatchService watchService = FileSystems.getDefault().newWatchService();
            final String fileName = "application.properties";
            File file = new File(PropertiesUtil.class.getResource(fileName).getPath());
            FileInputStream resource = new FileInputStream(file);

            Paths.get(file.getParent()).register(watchService,
                    StandardWatchEventKinds.ENTRY_MODIFY,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_CREATE);
            properties.load(resource);

            Thread watchThread = new Thread(() -> {
                while(true){
                    try {
                        WatchKey watchKey = watchService.take();
                        for(WatchEvent<?> event : watchKey.pollEvents()){
                            if(Objects.equals(event.context().toString(), fileName)){
                                properties.load(resource);
                                break;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            watchThread.setDaemon(true);
            watchThread.start();

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    watchService.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public static String getValue(String key){
		return properties.getProperty(key);
	}
}
