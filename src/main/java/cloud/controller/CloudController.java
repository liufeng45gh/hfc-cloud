package cloud.controller;

import cloud.qiniu.Cloud;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lijc on 15/8/27.
 */
@Api(basePath = "/filebase", value = "cloud", description = "云存储接口", produces = "application/json",position = 1)
@RestController
@RequestMapping("/filebase")
public class CloudController {

    @Autowired
    Cloud cloud;

//    @Consumes(MediaType.MULTIPART_FORM_DATA)
//    @ApiImplicitParams(@ApiImplicitParam(dataType = "file", name = "file", paramType = "body"))
    @ApiOperation(httpMethod = "POST", value = "文件上传",response = String.class)
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> upload(@RequestParam("file") MultipartFile file){
        Map<String,Object> map = new HashMap<>();
        try {
            String key;
            key = cloud.simpleUploadWithoutKey(file.getBytes());

            if (cloud.isEroticism(key)){
                map.put("oper_code","0");
                map.put("key","您上传的照片不符合规则");
                return map;
            }

            map.put("oper_code","1");
            map.put("key",key);
//            cloud.test();
        } catch (Exception e) {
            map.put("oper_code","0");
            map.put("message",e.toString());
            e.printStackTrace();
        }
        System.out.println(JSON.toJSONString(map));
        return map;
    }

}
