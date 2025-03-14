```java
@RestController
@RequestMapping("body")
@Tag(name = "body参数")
public class BodyController {

    @Operation(summary = "普通body请求")
    @PostMapping("/body")
    public ResponseEntity<FileResp> body(@RequestBody FileResp fileResp){
        return ResponseEntity.ok(fileResp);
    }

    @Operation(summary = "普通body请求+Param+Header+Path")
    @Parameters({
        @Parameter(name = "id",description = "文件id",in = ParameterIn.PATH),
        @Parameter(name = "token",description = "请求token",required = true,in = ParameterIn.HEADER),
        @Parameter(name = "name",description = "文件名称",required = true,in=ParameterIn.QUERY)
    })
    @PostMapping("/bodyParamHeaderPath/{id}")
    public ResponseEntity<FileResp> bodyParamHeaderPath(@PathVariable("id") String id,@RequestHeader("token") String token, @RequestParam("name")String name,@RequestBody FileResp fileResp){
        fileResp.setName(fileResp.getName()+",receiveName:"+name+",token:"+token+",pathID:"+id);
        return ResponseEntity.ok(fileResp);
    }
}


```