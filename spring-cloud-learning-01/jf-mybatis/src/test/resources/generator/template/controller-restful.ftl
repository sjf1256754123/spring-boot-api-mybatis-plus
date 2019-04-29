package ${controllerPackage};

import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import ${basePackage}.dao.${modelNameUpperCamel}Mapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import ${basePackage}.core.CodeMsgEnum;
import ${basePackage}.core.MessageResultUtils;
import ${basePackage}.core.Query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import javax.annotation.Resource;
import java.util.Map;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author ${author}
 * @data ${date}.
 */
@RestController
@RequestMapping("${baseRequestMapping}")
@Api(value = "${modelNameUpperCamel}控制类", description = "控制类接口测试")
public class ${modelNameUpperCamel}Controller {
    @Resource
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @Resource
    private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;

    @GetMapping
    @ApiOperation(value = "获取全部",notes = "返回分页过后的数据",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",value = "查询页码", paramType = "query",dataType = "Integer",defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize",value = "每页数据量", paramType = "query",dataType = "Integer",defaultValue = "10")
    })

    public Map<CodeMsgEnum, Object> list(@ApiIgnore @RequestParam Map<String, Object> params) {
        Page ${modelNameLowerCamel}Page = new Query<>(params);
        QueryWrapper<${modelNameUpperCamel}> wrapper = new QueryWrapper<>();
        IPage<${modelNameUpperCamel}> ${modelNameLowerCamel}IPage = ${modelNameLowerCamel}Mapper.selectPage(${modelNameLowerCamel}Page,wrapper);
        return MessageResultUtils.getResults(${modelNameLowerCamel}IPage, CodeMsgEnum.SEARCH_SUCCESS);
    }
    @PostMapping
    @ApiOperation(value = "添加数据",notes = "添加新的数据",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "${modelNameLowerCamel}",value = "待添加的${modelNameLowerCamel}实例",paramType = "body",dataType = "${modelNameUpperCamel}",required = true)
    })
    public Map<CodeMsgEnum, Object> add(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        boolean b =  ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
        return MessageResultUtils.getResults(b, CodeMsgEnum.SAVE_SUCCESS);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除数据",notes = "根据id删除数据",httpMethod = "DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "查询的id", paramType = "path",required = true,dataType = "Integer"),
    })
    public  Map<CodeMsgEnum, Object> delete(@PathVariable Integer id) {
        boolean b = ${modelNameLowerCamel}Service.removeById(id);
        return MessageResultUtils.getResults(b, CodeMsgEnum.SAVE_SUCCESS);
    }

    @PutMapping
    @ApiOperation(value = "更新数据",notes = "根据内容更新数据",httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "${modelNameLowerCamel}",value = "更新的${modelNameLowerCamel}实例",paramType = "body",dataType = "${modelNameUpperCamel}",required = true)
    })
    public  Map<CodeMsgEnum, Object> update(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        boolean b = ${modelNameLowerCamel}Service.updateById(${modelNameLowerCamel});
        return MessageResultUtils.getResults(b, CodeMsgEnum.SAVE_SUCCESS);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取单个值",notes = "查看单个项目的内容",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "查询的id", paramType = "path",required = true,dataType = "Integer",defaultValue = "0")
    })
    public Map<CodeMsgEnum, Object> detail(@PathVariable Integer id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.getById(id);
        return MessageResultUtils.getResults(${modelNameLowerCamel}, CodeMsgEnum.SAVE_SUCCESS);
    }
}
