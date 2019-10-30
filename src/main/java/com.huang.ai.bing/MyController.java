package com.huang.ai.bing;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * 功能：
 *
 * @author huangaibing
 * @date 2019/10/30 9:54
 */
public class MyController {
    @RequestMapping(value = "/upload", method = {RequestMethod.GET})
    /**
     * 功能：直接返回文件给前台
     *
     * @param response
     * @param content
     * @return void
     */
    public void upload(HttpServletResponse response, @RequestParam String content) throws IOException {
//        BitMatrix bit = MatrixToImageUtil.genImage(content);
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        BufferedImage image = MatrixToImageUtil.toBufferedImage(bit);
//        ImageIO.write(image, "png", out);
//        byte[] bytes = out.toByteArray();
//        response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode("test.png","UTF-8"));
//        IOUtils.copy(new ByteArrayInputStream(bytes),response.getOutputStream());
    }
}
