package ssm.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.assertj.core.util.*;

public class WordUtil {

    // 请求网路自考网数据

    public static String getHttpData(String url) throws URISyntaxException, ClientProtocolException, IOException {

        List<NameValuePair> nameValuePairList = Lists.newArrayList();

        nameValuePairList.add(new BasicNameValuePair("q", "x"));

        URI uri = new URIBuilder(url).addParameters(nameValuePairList).build();

        List<Header> headerList = Lists.newArrayList();

        headerList.add(new BasicHeader(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate"));

        headerList.add(new BasicHeader(HttpHeaders.CONNECTION, "keep-alive"));

        HttpClient httpClient = HttpClients.custom().setDefaultHeaders(headerList).build();

        HttpUriRequest httpUriRequest = RequestBuilder.get().setUri(uri).build();

        HttpResponse httpResponse = httpClient.execute(httpUriRequest);

        HttpEntity entity = httpResponse.getEntity();

        String rawHTMLContent = EntityUtils.toString(entity);

        EntityUtils.consume(entity);

        return rawHTMLContent;

    }


    public static void writeWordFile(String path, String fileName, String content) {
        try {
            if (!"".equals(path)) {
                // 检查目录是否存在
                File fileDir = new File(path);

                if (fileDir.exists()) {

                    byte b[] = content.getBytes();

                    ByteArrayInputStream bais = new ByteArrayInputStream(b);

                    POIFSFileSystem poifs = new POIFSFileSystem();

                    DirectoryEntry directory = poifs.getRoot();

                    DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);

                    FileOutputStream ostream = new FileOutputStream(path + fileName);

                    poifs.writeFilesystem(ostream);

                    bais.close();

                    ostream.close();

                }

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

    }


}
