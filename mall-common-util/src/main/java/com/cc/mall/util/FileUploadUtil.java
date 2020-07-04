package com.cc.mall.util;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @program: cc-mall
 * @description:
 * @author: SunChao
 * @create: 2020-07-03 15:09
 **/
public class FileUploadUtil {

    public static String fileUpload(MultipartFile multipartFile, String url) throws IOException, MyException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:tracker.conf");
        String path = resource.getURL().getPath();

        ClientGlobal.init(path);
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getTrackerServer();
        StorageClient storageClient = new StorageClient(trackerServer, null);

        String[] uploadFile = storageClient.upload_file(multipartFile.getBytes(), "jpg", null);
        return url + uploadFile[1];

    }
}
