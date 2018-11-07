package com.lixiaozhuo.fast;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import com.lixiaozhuo.utils.FastDFSClient;

public class FastDfsTest {
	@Test
	public void testUpload() throws Exception {
		// 创建一个配置文件,文件名任意.内容就是tracker服务器的地址
		// 使用全局对象加载配置文件
		ClientGlobal.init(
				"C:/Users/lxz/workspace/e3-manager-web/src/main/resources/conf/client.conf");
		// 创建一个TrackerClient对象
		TrackerClient trackerClient = new TrackerClient();
		// 通过TrackClient获得一个TrackerServer对象
		TrackerServer trackerServer = trackerClient.getConnection();
		// 创建一个StorageServer的引用,可以是null
		StorageServer storagetServer = null;
		// 创建一个StorageClient,参数需要TrackerServer和StroragerSErver
		StorageClient storageClient = new StorageClient(trackerServer,
				storagetServer);
		// 使用StorageClient上传文件
		String[] strings = storageClient.upload_file("C:/file/1.jpg", "jpg",
				null);
		for (String string : strings) {
			System.out.println(string);
		}
	}

	@Test
	public void testFastDfsClient() throws Exception {
		//使用自定义工具类上传
		FastDFSClient fastDFSClient = new FastDFSClient(
				"C:/Users/lxz/workspace/e3-manager-web/src/main/resources/conf/client.conf");
		String file = fastDFSClient.uploadFile("C:/file/1.jpg");
		System.out.println(file);

	}
}
